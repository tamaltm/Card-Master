import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
public class SPmovelistener extends MouseInputAdapter{
    Card selectedCard = null;
    SPtable tableSelect = null;
    SPdeck deckSelect = null;


    int count = 0;
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Component pressed = e.getComponent().getComponentAt(e.getPoint());
        if(pressed instanceof SPtable){
            System.out.println("ST pressed");
            tableSelect = (SPtable) pressed;
            selectedCard = tableSelect.clickedCard(e.getY());

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
                source.repaint();
                destination.repaint();

            }
        }
    }
    

    
}
