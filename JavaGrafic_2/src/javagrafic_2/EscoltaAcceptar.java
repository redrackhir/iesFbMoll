/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javagrafic_2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Guillem
 */
public class EscoltaAcceptar implements ActionListener {
    
    TextField login;
    TextField pass;
    Label etiq3;
    
    public EscoltaAcceptar(TextField login, TextField pass, Label etiq3){
        this.login=login;
        this.pass=pass;
        this.etiq3=etiq3;
      
    }
    
    public void actionPerformed(ActionEvent e){
        
        if (login.getText().equals("Guillem")&& pass.getText().equals("salom12"))
            etiq3.setText("Dades Vàlides");
        else
            etiq3.setText("Dades no Vàlides");
        
    }
    
    
           
    
}
