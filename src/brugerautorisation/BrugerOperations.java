package brugerautorisation;

import Persistance.IValidate;
import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class BrugerOperations implements IValidate {
    private Brugeradmin brugeradmin;

    public BrugerOperations() {
        try {
            brugeradmin = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noget gik galt med forbindelsen til serveren under validering");
        }
    }

    @Override
    public boolean validate (String brugernavn, String kodeord){
        try {
            brugeradmin.hentBruger(brugernavn, kodeord);
            return true;
        } catch (RemoteException e) {
            System.out.println("Noget gik galt med forbindelsen til serveren under indhentning af bruger");
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException uae) {
            System.out.println("Login fejlede: " + uae.getMessage());
            return false;
        }
    }
}

