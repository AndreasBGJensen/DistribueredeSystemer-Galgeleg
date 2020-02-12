package brugerautorisation;

import Persistance.IValidate;
import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class BrugerOperations implements IValidate {

    private final static String GL_KODE = "kode968v3t";
    private final static String KODE = "Systemer2020";

    private final static String STUDIE_NR = "s130016";
    Brugeradmin ba;

    public BrugerOperations() {
        try {
            ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noget gik galt med forbindelsen til serveren under validering");
        }
    }

    public Bruger getBruger(String username, String password) {return null;}



    /*
    public static void main(String[] arg) throws Exception {
        //Brugeradmin ba =(Brugeradmin) Naming.lookup("rmi://localhost/brugeradmin");



        System.out.println("Hentet bruger " +b.toString());


        Bruger off = ba.hentBrugerOffentligt(STUDIE_NR);
        System.out.println("Fik offentlige data " + Diverse.toString(off));

        //ba.sendGlemtAdgangskodeEmail("s123456", "Dette er en test, husk at skifte kode");
        // ba.ændrAdgangskode(STUDIE_NR, KODE, "Systemer2020");

        System.out.println("Fik bruger " + b);
        System.out.println("med data " + Diverse.toString(b));
        // ba.sendEmail("jacno", "xxx", "Hurra det virker!", "Jeg er så glad");

        Object ekstraFelt = ba.getEkstraFelt(STUDIE_NR, KODE, "hobby");
        System.out.println("Brugerens hobby er: " + ekstraFelt);

        ba.setEkstraFelt(STUDIE_NR, KODE, "hobby", "Tennis og programmering"); // Skriv noget andet her

        String webside = (String) ba.getEkstraFelt(STUDIE_NR, KODE, "webside");
        System.out.println("Brugerens webside er: " + webside);

    }*/

        @Override
        public Bruger validate (String brugernavn, String kodeord){
            try {
                Bruger b = ba.hentBruger(brugernavn, kodeord);

                return b;
            } catch (
                    RemoteException e) {
                e.printStackTrace();
                System.out.println("Noget gik galt med forbindelsen til serveren under indhentning af bruger");
                return null;
            }
        }
    }

