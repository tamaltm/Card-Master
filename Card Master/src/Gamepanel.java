import java.awt.Color;

import javax.swing.JPanel;

public class Gamepanel extends JPanel{
      static Deck deck;
      static Waste waste;
      static Foundation[] piles;
      static Table[] tpiles;

    Gamepanel(){
        setBackground(Color.GREEN);
        super.setLayout(null);
        deck = new Deck(500,20);
        add(deck);
        waste = new Waste(420, 20);
        add(waste);
        piles = new Foundation[4];
        for(int i=0;i<piles.length;++i){
            piles[i] = new Foundation(20+80*i, 20, i+1);
            add(piles[i]);
        }
        tpiles = new Table[7];
        for(int i=0;i<tpiles.length;++i){
            tpiles[i] = new Table(20+80*i,150,i+2);
            add(tpiles[i]);
        }
        
        MoveListener ml = new MoveListener();
        addMouseListener(ml);
        addMouseMotionListener(ml);
        
    }
    public static Deck getDeck() {
        return deck;
    }
    public static Waste getWaste() {
        return waste;
    }
    public static Foundation[] getPiles() {
        return piles;
    }
    
    
}
