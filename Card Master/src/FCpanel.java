import java.awt.Color;

import javax.swing.JPanel;
public class FCpanel extends JPanel{
    static Foundation[] foundation ;
    static FreeCell[] frecells;
    static FCTable[] fctables;
    static Deck deck ;
    FCpanel(){
        setBackground(Color.GREEN);
        super.setLayout(null);
        deck = new Deck(PROPERTIES, HEIGHT);
        foundation = new Foundation[4];
        for(int i=0;i<foundation.length;++i){
            foundation[i] = new Foundation(20+80*i, 20, i+1);
            add(foundation[i]);
        }
        frecells = new FreeCell[4];
        for(int i=0;i<frecells.length;++i){
            frecells[i] = new FreeCell(382+80*i, 20);
            add(frecells[i]);
        }
        fctables = new FCTable[8];
        
        for (int i = 0; i < fctables.length; ++i) {
            fctables[i] = new FCTable(20 + 90 * i, 150);
            int cards = i < 4 ? 7 : 6;  // first 4 piles get 7 cards, next 4 get 6 cards
            for (int j = 0; j < cards; ++j) {
                fctables[i].push(deck.pop());
            }
            add(fctables[i]);
        }
    }

        
    
    public static Deck getDeck() {
        return deck;
    }
}
