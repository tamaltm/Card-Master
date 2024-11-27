import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class SPpanel extends JPanel{
    static SPtable[] sptables;
    static SPdeck deck;
    private JLabel[] tableCounters;
    SPpanel(Color Background){
        setBackground(Background);
        super.setLayout(null);
        deck = new SPdeck(890, 630);
        add(deck);
        sptables = new SPtable[10];
        tableCounters = new JLabel[sptables.length];
        for(int i=0;i<sptables.length;i++){
            sptables[i] = new SPtable(70+90*i,80);
            int cards = i<4 ? 6 : 7;
            for(int j=0;j<cards;j++){
                sptables[i].push(deck.pop());
                add(sptables[i]);
            }
            tableCounters[i] = new JLabel("Table " + (i + 1) + ": 0");
            tableCounters[i].setBounds(70 + 90 * i, 60, 80, 20);
            add(tableCounters[i]);
        }
        SPmovelistener s = new SPmovelistener(this);
        addMouseListener(s);
        addMouseMotionListener(s);

    }
    public static SPtable[] getTables() {
        return sptables;
    }
    public void updateTableCounter(int index, int count) {
        tableCounters[index].setText("Table " + (index + 1) + ": " + count);
    }
}
