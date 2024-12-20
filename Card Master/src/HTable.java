//import java.awt.Graphics2D;
import java.awt.Graphics;
import java.util.Stack;
//import java.awt.Color;
public class HTable extends Pile{
    public HTable(int x,int y){
        super(x,y);
        super.setSize(500,600);
        super.setOpaque(false);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
      //  Graphics2D g2d = (Graphics2D) g;
        // g2d.setColor(Color.white);
        // g2d.drawLine(0, 0, 72, 0);
        // g2d.drawLine(0,0,0,96);
        // g2d.drawLine(71,0,71,96);

        int cardinc = 0;
        if(!isEmpty()){
            for(Card c :cards){
                    g.drawImage(c.CardImage(), 0, cardinc, 72,96,this);
                    cardinc+=30;
            }
        }
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

    public Stack<Card> getCards() {
    return this.cards;
}
    
    
}
