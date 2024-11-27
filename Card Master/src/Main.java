import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Main extends JFrame{

    Gamepanel gamepanel;
   // public static final int Panel_Width = 640,Panel_height = 500;
    Main(Color backgroundColor){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gamepanel = new Gamepanel(backgroundColor);
        gamepanel.setPreferredSize(new Dimension(640,500));
        setIconImage(new ImageIcon(getClass().getResource("/cards/Kicon.png")).getImage());
        add(gamepanel);
        pack();
        setLocationRelativeTo(null); 
        setVisible(true);

    }
    public static void main(String[] args) {
        new Main(Color.LIGHT_GRAY);
    }
    
}