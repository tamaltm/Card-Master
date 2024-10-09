import java.awt.Color;

import javax.swing.JPanel;
public class SPpanel extends JPanel{
    static SPtable[] sptables;
    static SPdeck deck;
    SPpanel(){
        setBackground(Color.GREEN);
        super.setLayout(null);
        deck = new SPdeck(890, 630);
        add(deck);
        sptables = new SPtable[10];
        for(int i=0;i<sptables.length;i++){
            sptables[i] = new SPtable(70+90*i,80);
            int cards = i<4 ? 6 : 7;
            for(int j=0;j<cards;j++){
                sptables[i].push(deck.pop());
                add(sptables[i]);
            }
        }
        SPmovelistener s = new SPmovelistener();
        addMouseListener(s);
        addMouseMotionListener(s);

    }
}
