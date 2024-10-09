import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Collections;

public class SPdeck extends Pile {

    SPdeck(int x, int y) {
        super(x, y);
        super.setSize(72, 96);
        for(int i=0;i<2;i++){
        for (Suit suit : Suit.values()) {
            for (int j = 1; j <= 13; ++j) {
                Card card = new Card(j, Suit.SPADES);
                push(card);
                System.out.println(card);
            }
        }
    }
        Collections.shuffle(cards);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(0, 0, 72, 96);
        if (!isEmpty())
            g2d.drawImage(Card.cardBack(), 0, 0, 72, 96, this);
    }
}