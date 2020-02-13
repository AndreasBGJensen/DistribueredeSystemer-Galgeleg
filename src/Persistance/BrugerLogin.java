package Persistance;

import Controller.UserController.UserController;
import PlayGalgeleg.IPlayGalgeleg;
import View.Input;
import brugerautorisation.BrugerOperations;

import java.rmi.Naming;
import java.util.Scanner;

public class BrugerLogin {
    String userPattern = "s[0-9]{6}";
    IValidate validation;
    private static boolean login = false;
    private static String currentUser = "";
    public BrugerLogin() {
        validation = (IValidate) new BrugerOperations();
    }

        //FIXME: Alt nedenstående loging relateret burde ligge en UserController og ikke her.
        // ALT andet lige burde det slet ikke ligge i Konstruktoren, men i en metode for sig selv.

    public boolean login(){
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
            password = sc.nextLine().trim();
        }

        if(validation.validate(userName,password)){
            setLogin(true);
            setCurrentUser(userName);
            return true;
        }

        return false;


    }

    public static boolean isLogin() {
        return login;
    }

    public static void setLogin(boolean login) {
        BrugerLogin.login = login;
    }

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(String currentUser) {
        BrugerLogin.currentUser = currentUser;
    }
}
