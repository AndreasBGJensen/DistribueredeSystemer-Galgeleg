package PlayGalgeleg;

import galgeleg.Galgelogik;

import java.util.ArrayList;


/**
 * This is a RMI-stub class
 */

public interface IPlayGalgeleg extends java.rmi.Remote {

    public Galgelogik galgelogik() throws java.rmi.RemoteException;
    public ArrayList<String> getBrugteBogstaver() throws java.rmi.RemoteException;
    public String getSynligtOrd() throws java.rmi.RemoteException;
    public String getOrdet() throws java.rmi.RemoteException;
    public int getAntalForkerteBogstaver() throws java.rmi.RemoteException;
    public boolean erSidsteBogstavKorrekt() throws java.rmi.RemoteException;
    public boolean erSpilletVundet() throws java.rmi.RemoteException;
    public boolean erSpilletTabt() throws java.rmi.RemoteException;
    public boolean erSpilletSlut() throws java.rmi.RemoteException;
    public void gætBogstav(String bogstav)throws java.rmi.RemoteException;
}
