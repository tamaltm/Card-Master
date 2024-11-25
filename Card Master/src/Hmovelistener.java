import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EmptyStackException;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.MouseInputAdapter;

public class Hmovelistener extends MouseInputAdapter {
    static boolean roundEnded = false;
    Card selectedCard = null;
    HTable[] table1select, table2select, table3select, table4select;
    Hdeck p1, p2, p3, p4;
    int max = 0;
    String currentSuit = null;
    int currentTurn = 1, roundWinner = 0;
    int count = 0,scores[]={0,0,0,0},totalRounds=0;
    JLabel message = new JLabel();
    private int roundsPlayed = 0;
    private Hpanel hpanel; 

public Hmovelistener(Hdeck player1Deck, Hdeck player2Deck, Hdeck player3Deck, Hdeck player4Deck, 
                     JLabel message, int[] scores, int totalRounds, Hpanel hpanel) {
    this.p1 = player1Deck;
    this.p2 = player2Deck;
    this.p3 = player3Deck;
    this.p4 = player4Deck;
    this.message = message;
    this.scores = scores;
    this.totalRounds = totalRounds;
    this.hpanel = hpanel; 
}



    @Override
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

            System.out.println("Round ended: " + roundEnded);
            if (roundEnded) {
                startRoundResetDelay();
            }

            e.getComponent().repaint();
        }
    }

    private void processPlayerTurn(Hdeck playerDeck, HTable table, int playerNumber, HTable[] playerTable) {
        System.out.println("Player " + playerNumber + " selected");
        selectedCard = table.clickedCard(playerDeck.getY());
        if (selectedCard == null) return;

        SwingUtilities.invokeLater(() -> 
        message.setText("Player " + playerNumber + " selected: " + selectedCard)
    );

        if (currentSuit == null) {
            currentSuit = selectedCard.getSuit();
        } else if (hasSameSuit(currentSuit, playerTable) && !selectedCard.getSuit().equals(currentSuit)) {
            SwingUtilities.invokeLater(() -> 
            message.setText("Invalid move: Must play a card of the current suit.")
        );
            return;
        }

        moveCardToDeck(playerDeck, table, playerNumber);

        int currentCardValue = selectedCard.getValue() == 1 ? 14 : selectedCard.getValue();
        if (selectedCard.getSuit().equals(currentSuit) && currentCardValue > max) {
            max = currentCardValue;
            roundWinner = playerNumber;
        }

        currentTurn = currentTurn == 4 ? 1 : currentTurn + 1;

        if (count == 4) {
            roundEnded = true;
            count = 0;
        }

        playerDeck.repaint();
    }

    private void moveCardToDeck(Hdeck playerDeck, HTable table, int playerNumber) {
        playerDeck.push(table.pop());
        count++;
        System.out.println("Player " + playerNumber + " played: " + selectedCard);
    }

    private void startRoundResetDelay() {
        SwingUtilities.invokeLater(() -> 
        message.setText("Round ended. Winner: Player " + roundWinner)
    );

        
        Timer delay = new Timer(1000, e -> clearTablesAndStartNewRound());
        delay.setRepeats(false);
        delay.start();
    }

    private void clearTablesAndStartNewRound() {
        
        int roundPenalty = 0;
        roundPenalty += p1.pop().getPenalty();
        roundPenalty += p2.pop().getPenalty();
        roundPenalty += p3.pop().getPenalty();
        roundPenalty += p4.pop().getPenalty();
        

        
        System.out.println("roundPenalty "+roundPenalty);
        scores[roundWinner - 1] += roundPenalty;
        for(int i=0;i<4;i++){
            System.out.println("Score["+(i+1)+"]"+scores[i]);
        }
        roundsPlayed++;
    
        
        if (roundsPlayed >= totalRounds) {
            SwingUtilities.invokeLater(() -> hpanel.showScoreTable());
            return;
        }
    
        
        max = 0;
        currentSuit = null;
        roundEnded = false;
        currentTurn = roundWinner;
    
        SwingUtilities.invokeLater(() -> 
            message.setText("Player " + currentTurn + "'s Turn")
        );
        
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
