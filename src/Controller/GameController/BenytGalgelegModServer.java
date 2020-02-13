package PlayGalgeleg;

import java.rmi.Naming;

public class BenytGalgelegModServer {

    public static void main(String[] args) throws Exception

    {
        IPlayGalgeleg k = (IPlayGalgeleg) Naming.lookup("rmi://localhost/kontotjeneste");
        k.galgelogik();

        System.out.println(k.getSynligtOrd());
        System.out.println(k.getBrugteBogstaver().get(1));
        k.getSynligtOrd();

    }
}
