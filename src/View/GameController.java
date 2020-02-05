package View;


import PlayGalgeleg.IPlayGalgeleg;
import galgeleg.JavaStubIncomming;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * In this class the gameplay will be executed.
 */

public class GameController {
    IPlayGalgeleg k;

    Input input;

    public GameController() throws Exception {
        k = (IPlayGalgeleg) Naming.lookup("rmi://localhost/kontotjeneste");
        k.galgelogik();
        input = new Input();
        play();
    }

    public void play() throws Exception {

        while (!k.erSpilletSlut()) {
            System.out.println(k.getSynligtOrd());
            input.getIndput();
            k.gætBogstav(input.getInputLetter());

        }
    }

}

