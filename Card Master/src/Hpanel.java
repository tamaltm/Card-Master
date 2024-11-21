import javax.swing.JPanel;
import java.awt.Color;
public class Hpanel extends JPanel{
    static Deck deck;
    static HTable[] player1,player2,player3,player4;

    Hpanel(){
        setBackground(Color.GREEN);
        super.setLayout(null);
        deck = new Deck(ALLBITS, ABORT);
        player1 = new HTable[13];
        for(int i=0;i<player1.length;i++){
            player1[i] = new HTable(460-i*30,395);
            player1[i].push(deck.pop());
            add(player1[i]);
        }
        player2 = new HTable[13];
        for(int i=0;i<player2.length;i++){
            player2[i] = new HTable(540,390-i*30);
            player2[i].push(deck.pop());
            add(player2[i]);
        }
        
        player3 = new HTable[13];
        for(int i=0;i<player3.length;i++){
            player3[i] = new HTable(460-i*30,30);
            player3[i].push(deck.pop());
            add(player3[i]);
        }
        player4 = new HTable[13];
        for(int i=0;i<player4.length;i++){
            player4[i] = new HTable(15,390-i*30);
            player4[i].push(deck.pop());
            add(player4[i]);
        }
    }
}
