import java.awt.Graphics;
import java.awt.Graphics2D;
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
    public void moveTo(SPtable destination, Card selectedCard) {
        if(destination.accepts(selectedCard)){
            destination.push(this.pop());
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

   
    
    
}
