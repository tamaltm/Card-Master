import java.awt.Graphics;

public class Foundation extends Pile {

    int suitnumber;
    public Foundation(int x, int y,int z) {
        super(x, y);
        super.setSize(72,96);
        this.suitnumber = z;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.isEmpty())
        g.drawImage(Card.base(suitnumber), 0, 0, 72,96,this);
        else
        g.drawImage(this.topCard().CardImage(),0,0,72,96,this);
    }
    public void moveFromWaste(Waste from, Card card) {
        if(accepts(card)){
            this.push(from.pop());
            from = null;
    }

}
        public boolean accepts(Card card){
            if(!this.isEmpty()){
                return this.topCard().getValue() == card.getValue()-1 && this.topCard().getSuit().equals(card.getSuit()); 
            }
            return card.getValue() == 1 && suitToInt(card.getSuit());
        }

        public boolean suitToInt(String s){
            if(s.equals("c")){
                return this.suitnumber == 3;  
            }else if(s.equals("s")){
                return this.suitnumber == 1;
            }else if(s.equals("h")){
                return this.suitnumber == 2;
            }else if(s.equals("d")){
                return this.suitnumber == 4;
            }else{
                return false;
            }
            
        }
        public void moveTo(Table destination, Card card) {
            if(destination.accepts(card)){
                destination.push(this.pop());
            }
        }
}
