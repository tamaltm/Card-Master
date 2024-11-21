import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class Hmovelistener extends MouseInputAdapter{
    private static boolean deal = false;
    Card selectedCard = null;
    HTable[] table1select,table2select,table3select,table4select;

   public void mousePressed(MouseEvent e) {
    Component pressed = e.getComponent().getComponentAt(e.getPoint());
    table1select = Hpanel.getTable1();
    table2select = Hpanel.getTable2();
    table3select = Hpanel.getTable3();
    table4select = Hpanel.getTable4();
    
    if (pressed instanceof HTable) {
        HTable table = (HTable) pressed; 
        if (isInTableArray(table, table1select)) {
            System.out.println("player 1 selected");
            selectedCard = table.clickedCard(e.getY());
            System.out.println(selectedCard.getValue());



        } else if (isInTableArray(table, table2select)) {
            System.out.println("player 2 selected");
            selectedCard = table.clickedCard(e.getY());
            System.out.println(selectedCard.getValue());


        } else if (isInTableArray(table, table3select)) {
            System.out.println("player 3 selected");
            selectedCard = table.clickedCard(e.getY());
            System.out.println(selectedCard.getValue());


        } else if (isInTableArray(table, table4select)) {
            System.out.println("player 4 selected");
            selectedCard = table.clickedCard(e.getY());
            System.out.println(selectedCard.getValue());
        }
    }
}


private boolean isInTableArray(HTable table, HTable[] tableArray) {
    if (tableArray == null) return false;
    for (HTable t : tableArray) {
        if (t == table) {
            return true;
        }
    }
    return false;
}}
