package Server;



import Controller.GameController.IPlayGalgeleg;

import java.rmi.Naming;

public class ServerMain {

        public static void main(String[] arg) throws Exception
        {
            // Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
            //System.setProperty("dist.saluton.dk", "kontotjeneste");
            java.rmi.registry.LocateRegistry.createRegistry(1099); // start i server-JVM

            IPlayGalgeleg k = new Server.JavaSkelImpl();
            //Naming.rebind("rmi://java.rmi.server.hostname/kontotjeneste", k);
           Naming.rebind("rmi://localhost/kontotjeneste", k);
            System.out.println("Kontotjeneste registreret.");
        }
    }

