import java.awt.Image;

import javax.swing.ImageIcon;

public class Card {
   //public static String cardBackname = "back001",directory="cards";
     int value;
     String suit;
    boolean Up ;
    static Suit s;
     Image image;
     Color color;

    public Card(int value, Suit s) {
        this.value = value;
        switch (s) {
            case CLUBS:
                suit = "c";
                color = Color.BLACK;
                break;
            case HEARTS:
                suit = "h";
                color = Color.RED;
                break;
            case DIAMONDS:
                suit = "d";
                color = Color.RED;
                break;
            case SPADES:
                suit = "s";
                color = Color.BLACK;
                break;
            default:
                break;
        }
        Up = false;
        ImageIcon ii = new ImageIcon(getClass().getResource("cards"+CardFile(s, value)));
        image = ii.getImage();
    }




    String CardFile(Suit s, int v) {
        char c='a';
        if(s==Suit.CLUBS){
            c = 'c';
        }else if(s==Suit.HEARTS){
            c = 'h';
        }else if(s==Suit.SPADES){
            c = 's';
        }else if(s == Suit.DIAMONDS){
            c = 'd';
        }
        
        if (v < 10) {
            return "/0" + v + c + ".gif";
        } else {
            return  "/"+v + c + ".gif";
        }
    }
    
    


    public Color getColor() {
        return color;
    }
    
    public boolean IsUp(){
        return Up;
    }
    @Override
    public String toString() {
        return value + suit ;
    }
    public void showFace(){
        Up = true;
    }
    Image CardImage(){
        return image;
    }
    
    public  int getValue() {
        return value;
    }

    public  String getSuit() {
        return suit;
    }




    public static Image cardBack(){
        ImageIcon i = new ImageIcon(Card.class.getResource("cards/back001.gif"));
        Image image = i.getImage();
        return image;
    }

    public static Image outline(){
        ImageIcon i = new ImageIcon(Card.class.getResource("cards/bottom01.gif"));
        Image image = i.getImage();
        return image;
    }
    public static Image base(int k){
        ImageIcon i = new ImageIcon(Card.class.getResource("cards/fpBase0"+k+".gif"));
        Image image = i.getImage();
        return image;
    }
}
