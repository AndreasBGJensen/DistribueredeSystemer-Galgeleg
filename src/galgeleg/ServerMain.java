package galgeleg;

import PlayGalgeleg.IPlayGalgeleg;

import java.rmi.Naming;

public class ServerMain {

        public static void main(String[] arg) throws Exception
        {
            // Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
            java.rmi.registry.LocateRegistry.createRegistry(1099); // start i server-JVM

            IPlayGalgeleg k = new JavaSkelImpl();
            Naming.rebind("rmi://localhost/kontotjeneste", k);
            System.out.println("Kontotjeneste registreret.");
        }
    }

