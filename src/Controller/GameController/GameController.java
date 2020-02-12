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

    public GameController() throws Exception {

        UserController validation = new UserController();

        Scanner sc = new Scanner(System.in);

        System.out.println("Indtast brugernavn og adgangskode. NB: Der skal være enter imellem hver");
        String username = sc.nextLine();
        String password = sc.nextLine();

        if(validation.validate(username,password)) {
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

