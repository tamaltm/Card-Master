import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class FCmovelistener extends MouseInputAdapter {
    Card selectedCard = null;
    FCTable tableSelect = null;
    Foundation foundselect = null;
    FreeCell freeCellselect = null;

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Component pressed = e.getComponent().getComponentAt(e.getPoint());

        if (pressed instanceof FCTable) {
            System.out.println("T");
            tableSelect = (FCTable) pressed;
            selectedCard = tableSelect.clickedCard(e.getY());
            for (Foundation foundation : FCpanel.getFoundation()) {
                if (tableSelect.moveTo(foundation, selectedCard)) {
                    foundation.push(tableSelect.pop());
                    if (!tableSelect.isEmpty()) {
                        tableSelect.topCard().showFace();
                    }
                    selectedCard = null;
                    break;
                }
            }

        }
        if (pressed instanceof FreeCell) {
            System.out.println("F");
            freeCellselect = (FreeCell) pressed;
            //tableSelect = null;
           // foundselect = null;
            selectedCard = freeCellselect.topCard();
            
        }

        if (pressed instanceof Foundation) {
            System.out.println("Fo  ");
            foundselect = (Foundation) pressed;
            tableSelect = null;
            freeCellselect = null;
            selectedCard = foundselect.topCard();

        }
        e.getComponent().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        super.mouseReleased(e);
        Component released = e.getComponent().getComponentAt(e.getPoint());
        if (released instanceof FCTable) {
            System.out.println("TR");
            if (foundselect != null) {
                Foundation source = foundselect;
                FCTable destination = (FCTable) released;
                destination.moveTo(destination, selectedCard);
                source.repaint();
                destination.repaint();
            }
            if (tableSelect != null) {
                FCTable source = tableSelect;
                FCTable destination = (FCTable) released;
                source.moveTo(destination, selectedCard);
                source.repaint();
                destination.repaint();
            }
            if (freeCellselect != null) {
                FreeCell source = freeCellselect;
                FCTable destination = (FCTable) released;
                source.moveTo(destination, selectedCard);
                source.repaint();
                destination.repaint();
            }
        }

        if (released instanceof FreeCell) {
            if (tableSelect != null) {
                FCTable source = tableSelect;
                FreeCell destination = (FreeCell) released;
                source.moveTo(destination, selectedCard);
                source.repaint();
                destination.repaint();
            }
        }
        e.getComponent().repaint();
        foundselect = null;
        tableSelect = null;
        freeCellselect = null;
        selectedCard = null;
    }

}
