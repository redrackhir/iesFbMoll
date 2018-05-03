/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercGraph.actions;

import exercGraph.view.FrmTresEnRaya;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author soib1a20
 */
public class actsTresEnRaya {

    private final FrmTresEnRaya frame;
    private final JTable tabla;
    private int[][] tablero = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private String[] fichas = {" ", " X ", " O "}; // 0 nadie; 1 jugador; 2 maquina

    public actsTresEnRaya(FrmTresEnRaya frame) {
        this.frame = frame;
        frame.setTitle("Ejemplo 3 en raya");
        tabla = frame.getTable();
        centerFrame();
    }

    private void centerFrame() {
        Dimension scr = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((scr.width - frame.getSize().width) / 2, (scr.height - frame.getSize().height) / 2);
    }

    public void playerMoves(int row, int col) {
        if (tablero[row][col] == 0) {
            tablero[row][col] = 1;
        }
        drawTablero();
        computerMoves();
    }

    private void computerMoves() {
        String target = "";
        if (tablero[1][1] == 0) {
            target = "11";
        }
        if ((tablero[0][1] == 1 && tablero[0][2] == 1) || (tablero[1][0] == 1 && tablero[2][0] == 1)) {
            target = "00";
        } else if ((tablero[0][0] == 1 && tablero[0][2] == 1) || (tablero[1][1] == 1 && tablero[2][1] == 1)) {
            target = "01";
        } else if ((tablero[0][2] == 1 && tablero[2][2] == 1) || (tablero[0][0] == 1 && tablero[0][1] == 1)) {
            target = "02";
        }
        if ((tablero[0][0] == 1 && tablero[2][0] == 1) || (tablero[1][1] == 1 && tablero[1][2] == 1)) {
            target = "10";
        } else if ((tablero[0][1] == 1 && tablero[2][1] == 1) || (tablero[1][0] == 1 && tablero[1][2] == 1)) {
            target = "11";
        } else if ((tablero[0][1] == 1 && tablero[1][1] == 1) || (tablero[2][0] == 1 && tablero[2][2] == 1)) {
            target = "12";
        }
        if ((tablero[0][0] == 1 && tablero[1][0] == 1) || (tablero[2][1] == 1 && tablero[2][2] == 1)) {
            target = "20";
        } else if ((tablero[0][1] == 1 && tablero[1][1] == 1) || (tablero[2][0] == 1 && tablero[2][2] == 1)) {
            target = "21";
        } else if ((tablero[0][2] == 1 && tablero[1][2] == 1) || (tablero[2][0] == 1 && tablero[2][1] == 1)) {
            target = "22";
        }
        if (target == "") {
            target = getFirstFree();
        }
        int[] move = new int[2];
        move[0] = Integer.valueOf(target.split("")[0]);
        move[1] = Integer.valueOf(target.split("")[1]);
        tablero[move[0]][move[1]] = 2;
        drawTablero();
    }

    private void drawTablero() {
        DefaultTableCellRenderer rendr = new DefaultTableCellRenderer();
        rendr.setHorizontalAlignment(JLabel.CENTER);
        for (int fil = 0; fil < 3; fil++) {
            for (int col = 0; col < 3; col++) {
                tabla.setValueAt(fichas[tablero[fil][col]], fil, col);
                tabla.setDefaultRenderer(tabla.getColumnClass(col), rendr);
            }
        }
    }

    private String getFirstFree() {
        for (int fil = 0; fil < 3; fil++) {
            for (int col = 0; col < 3; col++) {
                if (tablero[fil][col] == 0) {
                    return String.valueOf(fil) + String.valueOf(col);
                }
            }
        }
        return null;
    }

}
