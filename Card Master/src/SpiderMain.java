import java.awt.Dimension;
import javax.swing.JFrame;
public class SpiderMain extends JFrame{
    
    SpiderMain(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SPpanel sppanel = new SPpanel();
        sppanel.setPreferredSize(new Dimension(1040,740));
        add(sppanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SpiderMain().setVisible(true);
    }
}
