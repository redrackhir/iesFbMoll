/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primerafinestra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Guillem
 */
public class EscoltaBoto implements ActionListener{
    
    JLabel etiqueta;
    
    public EscoltaBoto(JLabel eti) {        
        this.etiqueta=eti;                
    }
    @Override
    public void actionPerformed(ActionEvent ae) {       
        this.etiqueta.setText("A la fi has pitjat");
    }
    
}
