import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class SpiderMain extends JFrame{
    
    SpiderMain(Color backgroundColor){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SPpanel sppanel = new SPpanel(backgroundColor);
        sppanel.setPreferredSize(new Dimension(1040,740));
        setIconImage(new ImageIcon(getClass().getResource("/cards/Sicon.png")).getImage());
        add(sppanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SpiderMain(Color.GRAY).setVisible(true);
    }
}
