import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeMenu extends JFrame {
    static JButton Klondike, FreeCell, Spider, Hearts;
    Font f;
    JLabel wc;
    Container c;

    WelcomeMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        components();
    }

    public void components() {
        CustomPanel p = new CustomPanel();
        p.setLayout(null);
        wc = new JLabel("Welcome to Card Master");
        wc.setBounds(100, 60, 200, 40);
        Klondike = new JButton("Klondike");
        Klondike.setBounds(100, 100, 120, 30);
        FreeCell = new JButton("Freecell");
        FreeCell.setBounds(300, 100, 120, 30);
        Spider = new JButton("Spider");
        Spider.setBounds(100,200,120,30);

        p.add(wc);
        p.add(Klondike);
        p.add(FreeCell);
        p.add(Spider);


        setContentPane(p); 
    }

    
    class CustomPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String[] args) {
        WelcomeMenu menu = new WelcomeMenu();

     
        Klondike.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Klondike button clicked!");
                new Main();
                
            }
        });
        FreeCell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Klondike button clicked!");
                new FreeCellmain();
                
            }
        });
        Spider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Klondike button clicked!");
                new FreeCellmain();
                
            }
        });
    }
}
