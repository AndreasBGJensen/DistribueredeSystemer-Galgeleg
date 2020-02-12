package PlayGalgeleg;

import Controller.UserController.UserController;

import java.rmi.Naming;
import java.util.Scanner;


/*
Denne klasse har blot virket som en testklasse
 */

public class PlayClient {



    public static void main(String[] args) throws Exception

    {
        UserController validation = new UserController();

        Scanner sc = new Scanner(System.in);

        String username = sc.nextLine();
        String password = sc.nextLine();

        if(validation.validate(username,password)) {


            IPlayGalgeleg k = (IPlayGalgeleg) Naming.lookup("rmi://localhost/kontotjeneste");
            k.galgelogik();

            System.out.println(k.getSynligtOrd());
            System.out.println(k.getBrugteBogstaver().get(1));
            k.getSynligtOrd();
        }
    }
}
