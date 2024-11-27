import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class FreeCellmain extends JFrame{
    
    FreeCellmain(Color backgroundColor){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FCpanel fcpanel = new FCpanel(backgroundColor);
        fcpanel.setPreferredSize(new Dimension(740,500));
        setIconImage(new ImageIcon(getClass().getResource("/cards/Ficon.png")).getImage());
        add(fcpanel);
        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }
    public static void main(String[] args) {
        new FreeCellmain(Color.orange).setVisible(true);
    }
}
