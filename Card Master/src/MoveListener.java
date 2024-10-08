import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class MoveListener extends MouseInputAdapter {
    Deck deck = null;
    Waste waste = null;
    Card selectedCard = null;
    Foundation foundselect = null;
    Table tableSelect = null;
    
    @Override
    public void mousePressed(MouseEvent e) {
        Component pressed = e.getComponent().getComponentAt(e.getPoint());
        deck = Gamepanel.getDeck();
        if(pressed instanceof Deck){
           // System.out.println("deck is clicked");
            if(!deck.isEmpty()){
                Waste waste = Gamepanel.getWaste();
                waste.push(deck.pop());
                waste.topCard().showFace();
                
            }else{
                System.out.println("Deck is empty");
                Waste waste = Gamepanel.getWaste();
                if (waste != null) {
                    int Size = waste.cards.size();
                    for (int i = 0; i < Size; i++) {
                        deck.push(waste.pop());
                    }
                } else {
                    System.err.println("Waste pile is null!");
                }
            }
        
            
        }
        
        
        
        
        if(pressed instanceof Waste){
            tableSelect = null;
            System.out.println("Waste is Clicked");
            waste = Gamepanel.getWaste();
            selectedCard = waste.topCard();
            if(selectedCard!=null){
                for(Foundation foundation : Gamepanel.getPiles()){
                    foundation.moveFromWaste(waste,selectedCard);
                }
            }

        }


        if(pressed instanceof Table){
            waste = null;
            tableSelect = (Table) pressed;
            selectedCard = tableSelect.clickedCard(e.getY());
            for(Foundation foundation : Gamepanel.getPiles()){
                if(tableSelect.moveTo(foundation,selectedCard)){
                    foundation.push(tableSelect.pop());
                    if(!tableSelect.isEmpty()){
                        tableSelect.topCard().showFace();
                    }
                    selectedCard = null;
                    break;
                }
            }
        }



        if(pressed instanceof Foundation){
            foundselect = (Foundation) pressed;
            tableSelect = null;
            waste = null;
            selectedCard = foundselect.topCard();
        }
        e.getComponent().repaint();

    }

   
    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        if(selectedCard!=null){
            Component released = e.getComponent().getComponentAt(e.getPoint());
            if(released instanceof Table){
                System.out.println("table released");
                if(waste!=null){
                    Table t = (Table) released;
                    if(!waste.isEmpty()){
                        t.moveFromWaste(waste,selectedCard);
                    }
                    waste.repaint();
                }else if (tableSelect!=null){
                    Table source = tableSelect;
                    Table destination = (Table) released;

                    source.moveTo(destination,selectedCard);
                    source.repaint();
                }else if (foundselect != null){
                    Foundation source = foundselect;
                    Table destination = (Table) released;
                    source.moveTo(destination,selectedCard);
                    source.repaint();
                    destination.repaint();

                }
            }
        }e.getComponent().repaint();
        selectedCard = null;
        foundselect = null;
        tableSelect = null;
        waste = null;
    }
    
}
