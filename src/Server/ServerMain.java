package Server;



import Controller.GameController.IPlayGalgeleg;

import java.rmi.Naming;

public class ServerMain {

        public static void main(String[] arg) throws Exception
        {
            // Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
            System.setProperty("java.rmi.server.hostname","dist.saluton.dk");
            java.rmi.registry.LocateRegistry.createRegistry(10099); // start i server-JVM

            IPlayGalgeleg k = new Server.JavaSkelImpl();
            Naming.rebind("rmi://dist.saluton.dk:10099/kontotjeneste", k);

           //Naming.rebind("rmi://localhost:10099/kontotjeneste", k);
            System.out.println("Kontotjeneste registreret.");
        }
    }

