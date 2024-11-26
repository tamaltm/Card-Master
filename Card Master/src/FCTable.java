import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayDeque;
import java.util.Deque;
public class FCTable extends Pile {

    public FCTable(int x, int y) {
        super(x, y);
        super.setSize(72, 450);
        super.setOpaque(false);
        
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.drawLine(0, 0, 72, 0);
        g2d.drawLine(0,0,0,96);
        g2d.drawLine(71,0,71,96);

        int cardinc = 0;
        if(!isEmpty()){
            for(Card c :cards){
                
                    g.drawImage(c.CardImage(), 0, cardinc, 72,96,this);
                    cardinc+=20;
                
                
            }
        }

    }
    public Card clickedCard(int y){
        int index = y / 20;
        if(index < this.cards.size()){
                return (Card) cards.toArray()[index];  
        }
        return (Card) cards.toArray()[cards.size()-1];
    }
    public boolean moveTo(Foundation foundation, Card selectedCard) {
        if(foundation.accepts(selectedCard)){
            return true;
            
        }
        return false;
    }
    public void moveTo(FCTable destination, Card card) {
		if (!this.isEmpty() || card.getValue() == 13) {
			if (destination.accepts(card)) {
                 Deque<Card> toBeMovedCards = new ArrayDeque<>();
                 while(!this.isEmpty()) {
                	 Card tmp = this.pop();
                	 toBeMovedCards.push(tmp);
                	 if(tmp.equals(card)) {
                		 break;
                	 }
                 }
                 while(!toBeMovedCards.isEmpty()) {
                	 destination.push(toBeMovedCards.pop());
                 }
			}
		}
		
		if(!this.isEmpty()) {
			this.topCard().showFace();
		}
	}
    public int cardCount() {
        return cards.size(); 
    }
    boolean accepts(Card selectedCard) {
        if(!isEmpty()){
            return this.topCard().getValue()==selectedCard.getValue()+1 && this.topCard().getColor()!=selectedCard.getColor();
        }
        return selectedCard.getValue() == 13; 
    }
    public void moveTo(FreeCell destination, Card selectedCard) {
        if(destination.accepts()){
            destination.push(this.pop());
        }
    }
}
