import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class FCpanel extends JPanel{
    static Foundation[] foundation ;
    static FreeCell[] frecells;
    static FCTable[] fctables;
    static Deck deck ;
    private JLabel[] tableCounters;

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
        tableCounters = new JLabel[fctables.length];
        for (int i = 0; i < fctables.length; ++i) {
            fctables[i] = new FCTable(20 + 90 * i, 150);
            int cards = i < 4 ? 7 : 6;  
            for (int j = 0; j < cards; ++j) {
                fctables[i].push(deck.pop());
            }
            add(fctables[i]);
            tableCounters[i] = new JLabel("Table " + (i + 1) + ": 0");
            tableCounters[i].setBounds(20 + 90 * i, 130, 80, 20);
            add(tableCounters[i]);
        }
        FCmovelistener f = new FCmovelistener(this);
        addMouseListener(f);
        addMouseMotionListener(f);
    }

        
    
    public static Deck getDeck() {
        return deck;
    }

    

    public static Foundation[] getFoundation() {
        return foundation;
    }



    public static FreeCell[] getFrecells() {
        return frecells;
    }



    public static FCTable[] getFctables() {
        return fctables;
    }



    public  void updateTableCounter(int index, int count) {
        tableCounters[index].setText("Table " + (index + 1) + ": " + count);
    }
    
}
