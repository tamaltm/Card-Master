import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeMenu extends JFrame{
    JButton Klondike ;
    Font f;
    JLabel wc ;
    Container c ;
    WelcomeMenu(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640,500);
        setLocationRelativeTo(null);
        setVisible(true);
        components();
        
    }
    public void components(){
        CustomPanel p = new CustomPanel();
        p.setLayout(null);
        wc = new JLabel("Welcome to Card Master");
        wc.setBounds(100,60,200,40);
        Klondike= new JButton("Klondike");
        Klondike.setBounds(100,100,120,30);
        setContentPane(p);
        p.add(wc);
        p.add(Klondike);
        setVisible(true);
    }
    
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, this.getWidth(),getHeight());
    }


    public static void main(String[] args) {
        new WelcomeMenu();
    }
    
    class CustomPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
