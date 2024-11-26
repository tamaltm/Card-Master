import java.awt.Dimension;
import javax.swing.JFrame;
public class FreeCellmain extends JFrame{
    
    FreeCellmain(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FCpanel fcpanel = new FCpanel();
        fcpanel.setPreferredSize(new Dimension(740,500));
        add(fcpanel);
        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }
    public static void main(String[] args) {
        new FreeCellmain().setVisible(true);
    }
}
