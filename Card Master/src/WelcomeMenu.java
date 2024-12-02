
import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeMenu extends JFrame {
    static JButton Klondike, FreeCell, Spider, Hearts, Settings;
    static Color backgroundColor = Color.CYAN;
    JLabel wc;

    WelcomeMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 500);
        setLocationRelativeTo(createRootPane());
        setResizable(true);
        setIconImage(new ImageIcon(getClass().getResource("/cards/icon.png")).getImage());
        components();
        setVisible(true);
    }

    public void components() {
        CustomPanel p = new CustomPanel();
        p.setLayout(null);

        wc = new JLabel("Welcome to Card Master");
        wc.setFont(new Font("Arial", Font.BOLD, 24));
        wc.setForeground(Color.WHITE);
        wc.setBounds(180, 50, 300, 40);

        Klondike = new JButton("Klondike");
        Klondike.setBounds(120, 150, 120, 30);

        FreeCell = new JButton("FreeCell");
        FreeCell.setBounds(260, 150, 120, 30);

        Spider = new JButton("Spider");
        Spider.setBounds(120, 200, 120, 30);

        Hearts = new JButton("Hearts");
        Hearts.setBounds(260, 200, 120, 30);

        Settings = new JButton("Settings");
        Settings.setBounds(190, 300, 120, 30);

        p.add(wc);
        p.add(Klondike);
        p.add(FreeCell);
        p.add(Spider);
        p.add(Hearts);
        p.add(Settings);

        setContentPane(p);

        
        Klondike.addActionListener(e -> new Main(backgroundColor));
        FreeCell.addActionListener(e -> new FreeCellmain(backgroundColor));
        Spider.addActionListener(e -> new SpiderMain(backgroundColor));
        Hearts.addActionListener(e -> new Hmain(backgroundColor));
        Settings.addActionListener(e -> openSettings());
    }

    public void openSettings() {
        
        Color newColor = JColorChooser.showDialog(this, "Choose Background Color", backgroundColor);
        if (newColor != null) {
            backgroundColor = newColor; 
            repaint(); 
        }
    }

    class CustomPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(backgroundColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String[] args) {
        new WelcomeMenu();
    }
}
