import java.awt.Graphics;
import java.awt.Graphics2D;

public class FreeCell extends Pile {

    public FreeCell(int x, int y) {
        super(x, y);
        super.setSize(72, 96);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(0, 0, 72, 96);
        if (!isEmpty()) {
            g2d.drawImage(this.topCard().CardImage(), 0, 0, 72, 96, this);
        }

    }

    public void moveTo(FCTable destination, Card selectedCard) {
        if (destination.accepts(selectedCard)) {
            destination.push(this.pop());
        }
    }

    public boolean accepts() {
        if (isEmpty()) {
            return true;
        }
        return false;
    }

}
