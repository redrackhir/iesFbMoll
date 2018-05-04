/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercGraph.actions;

import exercGraph.view.FrmTresEnRaya;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private final String[] fichas = {" ", " X ", "", "", "", " O "}; // 0 nadie; 1 jugador; 5 maquina
    private final int FREE = 0;
    private final int PLAYER = 1;
    private final int COMPUTER = 5;
    private final Color COMPUTER_COLOR = Color.blue;
    private final Color PLAYER_COLOR = Color.green;

    public actsTresEnRaya(FrmTresEnRaya frame) {
        this.frame = frame;
        frame.setTitle("Ejemplo 3 en raya");
        tabla = frame.getTable();
        // oculta la fila de cabecera
        tabla.getTableHeader().setUI(null);
        // mostrar lineas divisorias de celdas
        tabla.setShowGrid(true);
        tabla.setShowHorizontalLines(true);
        tabla.setShowVerticalLines(true);
        tabla.setGridColor(Color.darkGray);
        centerFrame();
    }

    private void centerFrame() {
        Dimension scr = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((scr.width - frame.getSize().width) / 2, (scr.height - frame.getSize().height) / 2);
    }

    public void playerMoves(int row, int col) {
        setMove(row, col, PLAYER);
        drawTablero();
        gameEnds();
        computerMoves();
        drawTablero();
        gameEnds();
    }

    private void computerMoves() {
        String target = preventPlayerWins();

        if (target.equals("") & !isOccupied("11")) {
            target = "11";
        }
        if (target.equals("")) {
            target = getFirstFree();
        }

        int fil = Integer.valueOf(target.split("")[0]);
        int col = Integer.valueOf(target.split("")[1]);

        setMove(fil, col, COMPUTER);

        tableroToString();
    }

    private String preventPlayerWins() {
        String target = "";
        if ((tablero[0][1] == 1 && tablero[0][2] == 1) || (tablero[1][0] == 1 && tablero[2][0] == 1)
                || (tablero[1][1] == 1 && tablero[2][2] == 1)) {
            target = isOccupied("00") ? "" : "00";
        } else if ((tablero[0][0] == 1 && tablero[0][2] == 1) || (tablero[1][1] == 1 && tablero[2][1] == 1)) {
            target = isOccupied("01") ? "" : "01";
        } else if ((tablero[1][2] == 1 && tablero[2][2] == 1) || (tablero[0][0] == 1 && tablero[0][1] == 1)
                || (tablero[1][1] == 1 && tablero[2][0] == 1)) {
            target = isOccupied("02") ? "" : "02";
        }
        if ((tablero[0][0] == 1 && tablero[2][0] == 1) || (tablero[1][1] == 1 && tablero[1][2] == 1)) {
            target = isOccupied("10") ? "" : "10";
        } else if ((tablero[0][1] == 1 && tablero[2][1] == 1) || (tablero[1][0] == 1 && tablero[1][2] == 1)) {
            target = isOccupied("10") ? "" : "10";
        } else if ((tablero[0][1] == 1 && tablero[1][1] == 1) || (tablero[2][0] == 1 && tablero[2][2] == 1)) {
            target = isOccupied("12") ? "" : "12";
        }
        if ((tablero[0][0] == 1 && tablero[1][0] == 1) || (tablero[2][1] == 1 && tablero[2][2] == 1)
                || (tablero[1][1] == 1 && tablero[0][2] == 1)) {
            target = isOccupied("20") ? "" : "20";
        } else if ((tablero[0][1] == 1 && tablero[1][1] == 1) || (tablero[2][0] == 1 && tablero[2][2] == 1)) {
            target = isOccupied("21") ? "" : "21";
        } else if ((tablero[0][2] == 1 && tablero[1][2] == 1) || (tablero[2][0] == 1 && tablero[2][1] == 1)
                || (tablero[1][1] == 1 && tablero[0][0] == 1)) {
            target = isOccupied("22") ? "" : "22";
        }
        gameEnds();
        return target;
    }

    private int whoWins() {
        // rows
        for (int row = 0; row < 3; row++) {
            if (tablero[row][0] + tablero[row][1] + tablero[row][2] == 3) {
                return PLAYER;
            }
            if (tablero[row][0] + tablero[row][1] + tablero[row][2] == 15) {
                return COMPUTER;
            }
        }
        // columns
        for (int col = 0; col < 3; col++) {
            if (tablero[0][col] + tablero[1][col] + tablero[2][col] == 3) {
                return PLAYER;
            }
            if (tablero[0][col] + tablero[1][col] + tablero[2][col] == 15) {
                return COMPUTER;
            }
        }
        // diagonals
        if (tablero[0][0] + tablero[1][1] + tablero[2][2] == 3) {
            return PLAYER;
        }
        if (tablero[0][0] + tablero[1][1] + tablero[2][2] == 15) {
            return COMPUTER;
        }
        if (tablero[0][2] + tablero[1][1] + tablero[2][0] == 3) {
            return PLAYER;
        }
        if (tablero[0][2] + tablero[1][1] + tablero[2][0] == 15) {
            return COMPUTER;
        }
        return 0;
    }

    private void gameEnds() {

        tableroToString();

        if (whoWins() != 0) {
            // fin de partida
            String player = whoWins() == 1 ? "Jugador" : "Computadora";
            Object[] options = {"Ok"};
            JOptionPane.showOptionDialog(frame, player + " gana!!!",
                    "Fin de partida", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
            newGame();
            drawTablero();
        } else if (getFirstFree() == null) {
            Object[] options = {"Ok"};
            JOptionPane.showOptionDialog(frame, "Empate!!!",
                    "Fin de partida", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
            newGame();
            drawTablero();
        }
    }

    private void drawTablero() {
        DefaultTableCellRenderer rendr = new MyTableCellRenderer();
        rendr.setHorizontalAlignment(JLabel.CENTER);
        for (int fil = 0; fil < 3; fil++) {
            for (int col = 0; col < 3; col++) {
                tabla.setValueAt(fichas[tablero[fil][col]], fil, col);
                Color playerColor = tablero[fil][col] == 1 ? PLAYER_COLOR : COMPUTER_COLOR;
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

    private boolean isOccupied(String target) {
        if (target.equals("")) {
            return false;
        }
        int fil = Integer.valueOf(target.split("")[0]);
        int col = Integer.valueOf(target.split("")[1]);
        return tablero[fil][col] != FREE;
    }

    private void setMove(int row, int col, int player) {
        if (tablero[row][col] == FREE) {
            tablero[row][col] = player;
        }
    }

    private void newGame() {
        // reset tablero
        tablero = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    }

    private void tableroToString() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(tablero[row][col] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
