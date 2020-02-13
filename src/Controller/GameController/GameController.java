package Controller.GameController;


import brugerautorisation.Persistance.BrugerLogin;
import PlayGalgeleg.IPlayGalgeleg;
import View.IWelcome;
import View.Input;
import View.Welcome;

import java.rmi.Naming;

/**
 * In this class the gameplay will be executed.
 */

public class GameController {
    IPlayGalgeleg k;
    IWelcome welcomeMessage = new Welcome();
    Input input;
    BrugerLogin brugerLogin;



    public GameController() throws Exception {
        brugerLogin = new BrugerLogin();

        while (true) {
            if (brugerLogin.login()) {
                welcomeMessage.welcome();

                k = (IPlayGalgeleg) Naming.lookup("rmi://localhost/kontotjeneste");
                k.galgelogik();
                play();
            } else {
                System.out.println("You have entered a wrong username");
            }
        }
    }

    public void play () throws Exception {
        input = new Input();
        while (!k.erSpilletSlut()) {
            System.out.println(k.getSynligtOrd());
            input.getIndput();
            k.gætBogstav(input.getInputLetter());

        }
    }
}


