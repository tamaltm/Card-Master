import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
public class SPmovelistener extends MouseInputAdapter{
    Card selectedCard = null;

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Component pressed = e.getComponent().getComponentAt(e.getPoint());
        if(pressed instanceof SPtable){
            System.out.println("ST pressed");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        Component released = e.getComponent().getComponentAt(e.getPoint());
        if(released instanceof SPtable){
            System.out.println("ST released");
        }
    }
    

    
}
