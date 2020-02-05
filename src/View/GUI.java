package View;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public static void main(String[] args) {
        JFrame f = new JFrame();//creating instance of JFrame

JFrame r = new JFrame();

r.setSize(400,200);
        JButton b=new JButton("Spil Galgeleg");//creating instance of JButton
        b.setBounds(130,190,100, 40);//x axis, y axis, width, height

        r.add(b);//adding button in JFrame
f.add(r);



        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible



        for(int i = 0; i<27;i++){
            JButton b1=new JButton("a");
            f.add(b1);

        }



        f.setLayout(new FlowLayout(FlowLayout.TRAILING));
        //setting grid layout of 3 rows and 3 columns

        f.setSize(300,300);
        f.setVisible(true);
    }
}

