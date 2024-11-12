import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayDeque;
import java.util.Deque;

public class Table extends Pile {

    public Table(int x, int y,int z) {
        super(x, y);
        super.setSize(72,450);
        super.setOpaque(false);
        for(int i=0;i<z;i++){
            push(Gamepanel.getDeck().pop());
        }
        if(z>0){
            topCard().showFace();
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.drawLine(0, 0, 72, 0);
        g2d.drawLine(0,0,0,96);
        g2d.drawLine(71,0,71,96);
       // g2d.setPaint(new GradientPaint(getLocationOnScreen(), getForeground(), getLocation(), getBackground()));
        //g2d.fillRect(0, 0, 72, 96);

        int cardinc = 0;
        if(!isEmpty()){
            for(Card c :cards){
                if(c.IsUp()){
                    g.drawImage(c.CardImage(), 0, cardinc, 72,96,this);
                    cardinc+=20;
                }else{
                    g.drawImage(Card.cardBack(), 0, cardinc, 72,96,this);
                    cardinc+=20;
                }
                
            }
        }

    }



    public void moveFromWaste(Waste source, Card selectedCard) {
        if(this.accepts(selectedCard)){
            push(source.pop());
            source = null;
        }
        
    }



    boolean accepts(Card selectedCard) {
        if(!isEmpty()){
            return this.topCard().getValue()==selectedCard.getValue()+1 && this.topCard().getColor()!=selectedCard.getColor();
        }
        return selectedCard.getValue() == 13; 
    }
    
    public Card clickedCard(int y){
        int index = y / 20;
        if(index < this.cards.size()){
            Card returnMe = (Card) cards.toArray()[index];
            if(returnMe.IsUp()){
                return returnMe;
            }
        }
        return (Card) cards.toArray()[cards.size()-1];
    }



    public void moveTo(Table destination, Card card) {
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



    public boolean moveTo(Foundation foundation, Card selectedCard) {
        if(foundation.accepts(selectedCard)){
            
            return true;
        }
        return false;
    }
}
