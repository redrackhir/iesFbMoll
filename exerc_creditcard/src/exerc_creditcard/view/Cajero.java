/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_creditcard.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soib1a20
 */
public class Cajero extends Frame {

    public Cajero(String title) {
        initComponents();
        this.setTitle(title);
    }

    private void initComponents() {
        Dimension scr = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Dimension mySize = new Dimension(600, 480);
        this.setSize(mySize);
        // Center on screen
        int posX = (scr.width - mySize.width) / 2;
        int posY = (scr.height - mySize.height) / 2;
        this.setLocation(posX, posY);

        // set ON_CLOSING_WINDOW action perform
        this.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    System.exit(0);
                } catch (Throwable ex) {
                    Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Finalizado");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        TextArea txt = new TextArea();
        txt.setBackground(Color.lightGray);

        txt.setText("Introduzca targeta...");

        this.add(txt);

    }

}
