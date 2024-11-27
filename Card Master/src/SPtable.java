import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayDeque;
import java.util.Deque;
import java.awt.Color;
public class SPtable extends Pile{

    public SPtable(int x, int y) {
        super(x, y);
        super.setSize(72,450);
        super.setOpaque(false);
    }

    @Override
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
                    cardinc+=30;
            }
        }
    }
    public void moveTo(SPtable destination, Card card) {
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
    public Card clickedCard(int y){
        int index = y / 20;
        if(index < this.cards.size()){
                return (Card) cards.toArray()[index];  
        }
        return (Card) cards.toArray()[cards.size()-1];
    }

    private boolean accepts(Card selectedCard) {
        if(!isEmpty()){
            return this.topCard().getValue()==selectedCard.getValue()+1 ;
        }
        return selectedCard.getValue() == 13; 
    }

    public int cardCount() {
        return cards.size();
    }

    public boolean hasCompleteSequence() {
       
        if (cards.size() < 13) return false;
    
        
        for (int i = 0; i < 13; i++) {
            Card current = cards.get(cards.size() - 1 - i);
            Card next = i < 12 ? cards.get(cards.size() - 2 - i) : null;
    
            if (next != null) {
                
                if (current.getValue() != next.getValue() + 1 || current.getSuit() != next.getSuit()) {
                    return false;
                }
            }
        }
        return true;
    }
    public void removeCompleteSequence() {
        if (hasCompleteSequence()) {
            
            for (int i = 0; i < 13; i++) {
                cards.pop();
            }
    
            System.out.println("Sequence removed!");
        }
    }
    
    
    
}
