package View;

public class Welcome implements IWelcome {
    @Override
    public void welcome() {
        System.out.println("Welkommen til dette forygende spil\n");
        System.out.println("Nedenfor kan du se nogle '****'");
        System.out.println("Disse kan du gætte på...\n Tryk enter når du har gættet på et bogstav");
    }
}
