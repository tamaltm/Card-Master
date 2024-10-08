import java.awt.Dimension;

import javax.swing.JFrame;


public class Main extends JFrame{

    Gamepanel gamepanel;
   // public static final int Panel_Width = 640,Panel_height = 500;
    Main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamepanel = new Gamepanel();
        gamepanel.setPreferredSize(new Dimension(640,500));
        add(gamepanel);
        pack();
        setLocationRelativeTo(null); 
        setVisible(true);

    }
    public static void main(String[] args) {
       new WelcomeMenu();
        new Main();
        //Card card = new Card(10, Suit.CLUBS);
        //System.out.println(card);
    }
    
}