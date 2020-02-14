import Controller.GameController.GameController;
import Controller.GameController.GameControllerModserver;

public class Main {

    public static void main(String[] args) {

        try {
            //GameControllerModserver playDTUServer = new GameControllerModserver();
            GameController play = new GameController();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
