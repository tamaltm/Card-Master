import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Hmain extends JFrame {
    Hpanel hpanel;

    
    public Hmain(Color backgroundColor) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
       
        hpanel = new Hpanel(backgroundColor);
        hpanel.setPreferredSize(new Dimension(690, 600));
        setIconImage(new ImageIcon(getClass().getResource("/cards/Hicon.png")).getImage());
        add(hpanel);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        
        new Hmain(Color.GREEN);
    }
}
