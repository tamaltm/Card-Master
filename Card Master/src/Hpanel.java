import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;
public class Hpanel extends JPanel{
    static Deck deck;
    static HTable[] player1,player2,player3,player4;
    Hdeck player1move,player2move,player3move,player4move;
    JLabel  player1label,player2label,player3label,player4label,message;
    private int[] scores = {0, 0, 0, 0}; 
    private int totalRounds = 13; 
     
    

    Hpanel(){
        setBackground(Color.GREEN);
        super.setLayout(null);
        deck = new Deck(ALLBITS, ABORT);
        player1 = new HTable[13];
        player1label = new JLabel("Player1 ");
        player1label.setFont(new Font("Arial", Font.TRUETYPE_FONT, 12));
        player1label.setBounds(300,415,100,25);
        add(player1label);
        for(int i=0;i<player1.length;i++){
            player1[i] = new HTable(490-i*30,440);
            player1[i].push(deck.pop());
            add(player1[i]);
        }
        player2label = new JLabel("Player4");
        player2label.setFont(new Font("Arial", Font.TRUETYPE_FONT, 12));
        player2label.setBounds(20,20,100,25);
        add(player2label);
        player2 = new HTable[13];
        for(int i=0;i<player2.length;i++){
            player2[i] = new HTable(590,410-i*30);
            player2[i].push(deck.pop());
            add(player2[i]);
        }
        player3label = new JLabel("Player3");
        player3label.setFont(new Font("Arial", Font.TRUETYPE_FONT, 12));
        player3label.setBounds(310,5,100,25);
        add(player3label);
        player3 = new HTable[13];
        for(int i=0;i<player3.length;i++){
            player3[i] = new HTable(490-i*30,30);
            player3[i].push(deck.pop());
            add(player3[i]);
        }
        player4label = new JLabel("Player2");
        player4label.setFont(new Font("Arial", Font.TRUETYPE_FONT, 12));
        player4label.setBounds(590,30,100,25);
        add(player4label);
        player4 = new HTable[13];
        for(int i=0;i<player4.length;i++){
            player4[i] = new HTable(25,410-i*30);
            player4[i].push(deck.pop());
            add(player4[i]);
        }
        
        
        player1move = new Hdeck(330, 280);
        add(player1move);
        player2move = new Hdeck(430, 220);
        add(player2move);
        player3move = new Hdeck(330, 140);
        add(player3move);
        player4move = new Hdeck(230, 220);
        add(player4move);
        message = new JLabel("Welcome to Hearts");
        message.setFont(new Font("Arial", Font.TRUETYPE_FONT, 15));
        message.setBounds(250, 550, 400, 40);
        
        Hmovelistener ml = new Hmovelistener(player1move, player2move, player3move, player4move, message, scores, totalRounds,this,player1label,player2label,player3label,player4label);
        addMouseListener(ml);
        addMouseMotionListener(ml);
        add(message);
    }

    public static HTable[] getTable1() {
        return player1;
    }

    public static HTable[] getTable2() {
        return player2;
    }

    public static HTable[] getTable3() {
        return player3;
    }

    public static HTable[] getTable4() {
        return player4;
    }
    public static Deck getDeck(){
        return deck;
    }
    public void showScoreTable() {
    JDialog scoreDialog = new JDialog();
    scoreDialog.setTitle("Game Over - Scores");
    scoreDialog.setSize(300, 200);
    scoreDialog.setLocationRelativeTo(this); 
    scoreDialog.setModal(true);

    String[] columnNames = {"Player", "Score"};
    String[][] data = {
        {"Player 1", String.valueOf(scores[0])},
        {"Player 2", String.valueOf(scores[1])},
        {"Player 3", String.valueOf(scores[2])},
        {"Player 4", String.valueOf(scores[3])}
    };

    JTable scoreTable = new JTable(data, columnNames);
    scoreTable.setEnabled(false);
    scoreTable.setFillsViewportHeight(true);

    scoreDialog.add(scoreTable.getTableHeader(), "North");
    scoreDialog.add(scoreTable, "Center");

    JButton closeButton = new JButton("Close");
    closeButton.addActionListener(e -> scoreDialog.dispose());
    scoreDialog.add(closeButton, "South");

    scoreDialog.setVisible(true);
}

    
}
