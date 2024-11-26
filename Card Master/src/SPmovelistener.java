import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.event.MouseInputAdapter;
public class SPmovelistener extends MouseInputAdapter{
    Card selectedCard = null;
    SPtable tableSelect = null;
    SPdeck deckSelect = null;
    SPpanel sppanel;

    public SPmovelistener(SPpanel sppanel){
        this.sppanel = sppanel;
    }

    int count = 0;
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Component pressed = e.getComponent().getComponentAt(e.getPoint());
        if(pressed instanceof SPtable){
            System.out.println("ST pressed");
            tableSelect = (SPtable) pressed;
            selectedCard = tableSelect.clickedCard(e.getY()-150);

        }if(pressed instanceof SPdeck){
            
            if(count<=4){
                System.out.println("Deck pushed");
                push_cards();
                count++;
            }
        }
    }

    private void push_cards() {
        for(SPtable sptables:SPpanel.getTables()){
            sptables.push(SPpanel.deck.pop());
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        Component released = e.getComponent().getComponentAt(e.getPoint());
        if(released instanceof SPtable){
            System.out.println("ST released");
            if(tableSelect!=null){
                SPtable source = tableSelect;
                SPtable destination = (SPtable) released;
                source.moveTo(destination, selectedCard);
                int sourceIndex = Arrays.asList(SPpanel.getTables()).indexOf(source);
                    int destinationIndex = Arrays.asList(SPpanel.getTables()).indexOf(destination);

                    if (sourceIndex != -1) {
                    
                    sppanel.updateTableCounter(sourceIndex, source.cardCount());
                    }
                    if (destinationIndex != -1) {
                    sppanel.updateTableCounter(destinationIndex, destination.cardCount());
                    }
                source.repaint();
                destination.repaint();

            }
        }
    }
    

    
}
