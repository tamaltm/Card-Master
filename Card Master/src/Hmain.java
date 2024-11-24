import java.awt.Dimension;

import javax.swing.JFrame;

public class Hmain extends JFrame{
    Hpanel hpanel;
    Hmain(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hpanel = new Hpanel();
        hpanel.setPreferredSize(new Dimension(690,600));
        add(hpanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Hmain();
    }
}
