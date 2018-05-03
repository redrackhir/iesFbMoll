/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercGraph.actions;

import exercGraph.view.FrmCalculadora;
import java.awt.Dimension;
import javax.swing.JTextField;

/**
 *
 * @author soib1a20
 */
public class actsCalculadora {

    FrmCalculadora frame;
    JTextField tfEuros;
    JTextField tfPesetas;

    public actsCalculadora(FrmCalculadora frame) {
        this.frame = frame;
        centerFrame();
        tfEuros = frame.getTfEuro();
        tfPesetas = frame.getTfPta();
        tfEuros.setText("0");
        tfPesetas.setText("0");

    }

    public void toEuros() {
        try {
            int pesetas = tfPesetas.getText().length() > 0 ? Integer.valueOf(tfPesetas.getText().replace(".", "")) : 0;
            double euros = (double) (pesetas / 166.386);
            tfEuros.setText(String.format("%,.2f", euros));
        } catch (NumberFormatException e) {
            System.out.println("No se permiten caracteres NO numéricos");
        }
    }

    public void toPta() {
        try {
            double euros = tfEuros.getText().length() > 0 ? Double.valueOf(tfEuros.getText().replace(",", "")) : 0;
            int pesetas = (int) (euros * 166.386);
            tfPesetas.setText(String.format("%,d", pesetas));
        } catch (NumberFormatException e) {
            System.out.println("No se permiten caracteres NO numéricos");
        }
    }

    void centerFrame() {
        Dimension scr = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((scr.width - frame.getSize().width) / 2, (scr.height - frame.getSize().height) / 2);
    }
}
