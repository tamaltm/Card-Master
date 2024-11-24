import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EmptyStackException;
import javax.swing.event.MouseInputAdapter;

public class Hmovelistener extends MouseInputAdapter {
    static boolean roundEnded = false;
    Card selectedCard = null;
    HTable[] table1select, table2select, table3select, table4select;
    Hdeck p1, p2, p3, p4;
    int max = 0;
    String currentSuit = null;
    int currentTurn = 1, roundWinner = 0;
    int count=0;

    public Hmovelistener(Hdeck player1Deck, Hdeck player2Deck, Hdeck player3Deck, Hdeck player4Deck) {
        this.p1 = player1Deck;
        this.p2 = player2Deck;
        this.p3 = player3Deck;
        this.p4 = player4Deck;
    }

public void mousePressed(MouseEvent e) throws EmptyStackException {
    Component pressed = e.getComponent().getComponentAt(e.getPoint());
    table1select = Hpanel.getTable1();
    table2select = Hpanel.getTable2();
    table3select = Hpanel.getTable3();
    table4select = Hpanel.getTable4();

    if (Hpanel.getDeck() == null) return;

    if (pressed instanceof HTable) {
        HTable table = (HTable) pressed;

        
        if (isInTableArray(table, table1select) && currentTurn == 1) {
            processPlayerTurn(p1, table, 1, table1select);
        } else if (isInTableArray(table, table2select) && currentTurn == 2) {
            processPlayerTurn(p2, table, 2, table2select);
        } else if (isInTableArray(table, table3select) && currentTurn == 3) {
            processPlayerTurn(p3, table, 3, table3select);
        } else if (isInTableArray(table, table4select) && currentTurn == 4) {
            processPlayerTurn(p4, table, 4, table4select);
        }

        
        System.out.println("Round ended: "+roundEnded);
        if (roundEnded) {
            clearTablesAndStartNewRound();
        }

        e.getComponent().repaint();
    }
}


private void processPlayerTurn(Hdeck playerDeck, HTable table, int playerNumber, HTable[] playerTable) {
    System.out.println("Player " + playerNumber + " selected");
    selectedCard = table.clickedCard(playerDeck.getY());
    if (selectedCard == null) return;

    System.out.println("Selected card value: " + selectedCard.getValue());

    
    if (currentSuit == null) {
        
        currentSuit = selectedCard.getSuit();
    } else if (hasSameSuit(currentSuit, playerTable) && !selectedCard.getSuit().equals(currentSuit)) {
        System.out.println("Invalid move: Must play a card of the current suit.");
        return;
    }

    
    moveCardToDeck(playerDeck, table, playerNumber);

    
    int currentCardValue = selectedCard.getValue() == 1 ? 14 : selectedCard.getValue();
    if (selectedCard.getSuit().equals(currentSuit) && currentCardValue > max) {
        max = currentCardValue;
        roundWinner = playerNumber;
    }

    
    currentTurn = currentTurn == 4 ? 1 : currentTurn + 1;

    
    if (count==4) {
        roundEnded = true;  
        count=0; 
    }

    playerDeck.repaint();
}


    private void moveCardToDeck(Hdeck playerDeck, HTable table, int playerNumber) {
        playerDeck.push(table.pop());
        count++;
        System.out.println("Player " + playerNumber + " played: " + selectedCard);
    }

    private void clearTablesAndStartNewRound() {
        System.out.println("Round ended. Winner: Player " + roundWinner);
    
        
        if (!p1.isEmpty()) p1.pop();
        if (!p2.isEmpty()) p2.pop();
        if (!p3.isEmpty()) p3.pop();
        if (!p4.isEmpty()) p4.pop();
    
        
        max = 0;
        currentSuit = null;
        roundEnded = false;
    
        
        currentTurn = roundWinner;
    
        System.out.println("Next round starts with Player " + currentTurn);
    
        
        p1.repaint();
        p2.repaint();
        p3.repaint();
        p4.repaint();
    }
    

    private boolean isInTableArray(HTable table, HTable[] tableArray) {
        if (tableArray == null) return false;
        for (HTable t : tableArray) {
            if (t == table) return true;
        }
        return false;
    }

    private boolean hasSameSuit(String suit, HTable[] tableArray) {
        for (HTable table : tableArray) {
            for (Card card : table.getCards()) {
                if (card.getSuit().equals(suit)) {
                    return true;
                }
            }
        }
        return false;
    }
}