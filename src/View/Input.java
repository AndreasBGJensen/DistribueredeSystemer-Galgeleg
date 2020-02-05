package View;

import java.io.Serializable;
import java.util.Scanner;

public class Input implements Serializable {

    private Scanner sc;

    private static String inputLetter;

    public Input(){
        sc = new Scanner(System.in);
    }

    /**
     * Reads the char input. Ignores whitespaces. If the input have more than one char the variable letterindput will
     * be signed to the first char.
     */
    public void getIndput(){
        inputLetter = sc.next().trim().substring(0,1);
    }

    public String getInputLetter(){
        return inputLetter;
    }

}
