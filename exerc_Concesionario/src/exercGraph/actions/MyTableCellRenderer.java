/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercGraph.actions;

/**
 *
 * @author red rackhir
 */
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class MyTableCellRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        Component c
                = super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus,
                        row, column);

        // Only for specific cell
        switch (String.valueOf(value)) {
            case " X ": c.setForeground(Color.blue); break;
            case " O ": c.setForeground(Color.green); break;
        }
        return c;
    }
}
