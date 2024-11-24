import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.EmptyStackException;

public class Hdeck extends Pile{
    Hdeck(int x,int y){
        super(x, y);
        super.setSize(72, 96);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(0, 0, 72, 96);
        try{
        if (isEmpty())
            g2d.drawImage(Card.outline(), 0, 0, 72, 96, this);
        else{
            g2d.drawImage(this.topCard().CardImage(), 0, 0, 72, 96, this);
        }
        } catch(EmptyStackException e){
        e.printStackTrace();
}

}
}