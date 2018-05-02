/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primerafinestra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author Guillem
 */
public class FinestraNova extends JFrame{
    
    public FinestraNova() {
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        
        
        
        int ample = d.width/3;
        int alt = d.height/3;
        
        this.setSize(ample, alt);
        
        
        this.setLocation(d.width/2-ample/2,d.height/2-alt/2);
        
        this.setBackground(new Color(20,140,10));
        this.setForeground(Color.red);
        
        //setLayout(new GridLayout(4,2,0,5));
        this.setLayout(null);
        
        Font  font = new Font("Arial", Font.PLAIN, 20);
        this.setFont(font);
        
        this.setTitle("La primera finestra");
        
        JLabel jLetiq = new JLabel();
        jLetiq.setText("Encara no has pitjat el botó");  
        jLetiq.setBounds(10,150,250,30);
        this.add(jLetiq);
        
        JButton jBoto = new JButton("Pitja");
        jBoto.setBounds(10,35,100,30);
        jBoto.setBackground(Color.blue);
        jBoto.setForeground(Color.red);    
        this.add(jBoto);
        
        EscoltaBoto e = new EscoltaBoto(jLetiq);
        jBoto.addActionListener(e);
    }
    
    
}
