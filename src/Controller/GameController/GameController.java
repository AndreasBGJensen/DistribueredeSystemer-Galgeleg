package Controller.GameController;


import Controller.UserController.UserController;
import PlayGalgeleg.IPlayGalgeleg;
import View.IWelcome;
import View.Input;
import View.Welcome;

import java.rmi.Naming;
import java.util.Scanner;

/**
 * In this class the gameplay will be executed.
 */

public class GameController {
    IPlayGalgeleg k;
    IWelcome welcomeMessage  = new Welcome();
    Input input;

    String userPattern = "s[0-9]{6}";

    public GameController() throws Exception {

        UserController validation = new UserController();

        //FIXME: Alt nedenstående loging relateret burde ligge en UserController og ikke her.
        // ALT andet lige burde det slet ikke ligge i Konstruktoren, men i en metode for sig selv.

        Scanner sc = new Scanner(System.in);

        System.out.println("For at komme i gang med dette fantastiske spil skal du logge på.\nIndtast brugernavn og tryk \"Enter\".");
        String userName = sc.nextLine().trim().toLowerCase();

        //while (userName.length() != 7 && userName.startsWith("s",0)){
        while (!userName.matches(userPattern)){
            System.out.println("Forkert brugernavn er indtastet. (Brugernavns format: \"sXXXXXX\" X = tal mellem 0-9)\nPrøv igen.");
            userName = sc.nextLine().trim();
        }
        System.out.println("Indtast kodeord og tryk \"Enter\".");
        String password = sc.nextLine().trim();
        while (password.length() == 0){
            System.out.println("Intet password er indtastet. Prøv igen.");
            userName = sc.nextLine().trim();
        }

        if(validation.validate(userName,password)) {
            welcomeMessage.welcome();

            k = (IPlayGalgeleg) Naming.lookup("rmi://localhost/kontotjeneste");
            k.galgelogik();
            input = new Input();
            play();
        }else{
            System.out.println("You have entered a wrong username");
        }
    }

    public void play() throws Exception {

        while (!k.erSpilletSlut()) {
            System.out.println(k.getSynligtOrd());
            input.getIndput();
            k.gætBogstav(input.getInputLetter());

        }
    }

}

