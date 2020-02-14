package Server;

import Controller.GameController.IPlayGalgeleg;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class JavaSkelImpl extends UnicastRemoteObject implements IPlayGalgeleg {
    Galgelogik logik = null;

    public JavaSkelImpl() throws java.rmi.RemoteException{
       if(logik==null) {
           logik = new Galgelogik();
       }
    }


/*
TODO: Quick fix, Skal laves således at der ikke bare retuneres et nyt Galgelogik-objekt
 */
    @Override
    public Galgelogik galgelogik() throws RemoteException {
        System.out.println("Server: Galgelogik");
        logik = new Galgelogik();
        return logik;
    }

    @Override
    public ArrayList<String> getBrugteBogstaver() throws RemoteException {
        System.out.println("Server: GetBrugteBogstaver");

        return logik.getBrugteBogstaver();
    }

    @Override
    public String getSynligtOrd() throws RemoteException {
        System.out.println("Server: Get synligt ord");

        return logik.getSynligtOrd();
    }

    @Override
    public String getOrdet() throws RemoteException {
        System.out.println("Server: getOrdet");

        return logik.getOrdet();
    }

    @Override
    public int getAntalForkerteBogstaver() throws RemoteException {
        System.out.println("Server: getAntalForkerteBogstaver");

        return logik.getAntalForkerteBogstaver();
    }

    @Override
    public boolean erSidsteBogstavKorrekt() throws RemoteException {
        System.out.println("Server: erSidsteBogstavKorrekt");

        return logik.erSidsteBogstavKorrekt();
    }

    @Override
    public boolean erSpilletVundet() throws RemoteException {
        System.out.println("Server: erSpilletVundet");

        return logik.erSpilletVundet();
    }

    @Override
    public boolean erSpilletTabt() throws RemoteException {
        System.out.println("Server: erSpilletTabt");

        return logik.erSpilletTabt();
    }

    @Override
    public boolean erSpilletSlut() throws RemoteException {
        System.out.println("Server: erSpilletSlut");

        return logik.erSpilletSlut();
    }

    @Override
    public void gætBogstav(String bogstav) throws RemoteException {
        logik.gætBogstav(bogstav);
    }


}
