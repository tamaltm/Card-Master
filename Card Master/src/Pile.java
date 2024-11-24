import java.awt.Dimension;
import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.JPanel;

public abstract class Pile extends JPanel{
    
    int x,y;
    Stack<Card> cards;
    public Pile(int x,int y){
        super.setLocation(x,y);
         cards = new Stack<>();
    }

    public boolean isEmpty(){
        return this.cards.isEmpty();
    }
    public void push(Card c){
        this.cards.push(c);
    }
    public Card pop() throws EmptyStackException{
        return this.cards.pop();
    }
    public Card topCard() throws EmptyStackException{
        if(!this.cards.isEmpty()){
            return this.cards.peek();
        }
        return null;
    }
    
}
