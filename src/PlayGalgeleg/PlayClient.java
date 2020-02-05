package PlayGalgeleg;

import java.rmi.Naming;


/*
Denne klasse har blot virket som en testklasse
 */

public class PlayClient {

    public static void main(String[] args) throws Exception

    {
        IPlayGalgeleg k = (IPlayGalgeleg) Naming.lookup("rmi://localhost/kontotjeneste");
        k.galgelogik();

        System.out.println(k.getSynligtOrd());
        System.out.println(k.getBrugteBogstaver().get(1));
        k.getSynligtOrd();

    }
}
