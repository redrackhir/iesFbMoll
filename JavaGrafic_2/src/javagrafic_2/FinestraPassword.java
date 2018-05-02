/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javagrafic_2;

import java.awt.*;
import java.awt.event.WindowListener;
/**
 *
 * @author Guillem
 */
public class FinestraPassword extends Frame {

    public FinestraPassword() {

        this.setTitle("Entrada al Sistema");
        this.setLayout(null);
        
        // Centrat de la finestra
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int ample = 300;
        int alt = 200;
        this.setSize(ample, alt);
        this.setLocation(d.width/2-ample/2, d.height/2-alt/2);
        
        //tipus de lletra        
        Font font = new Font("Arial", Font.PLAIN, 20);
        this.setFont(font);
        this.setBackground (Color.cyan);
           
        // Components
        
           Label etiq =new Label();
           etiq.setBounds(10,50,120,30);
           etiq.setText("Login: ");
           this.add(etiq);
           
           TextField login = new TextField(8);
           login.setBounds(100,50,150,30);
           this.add(login);
           
           Label etiq2 =new Label();     
           etiq2.setBounds(50,150,100,30);
           etiq2.setText("Password: ");
           this.add(etiq2);
           
           TextField pass = new TextField(10);
           pass.setBounds(150,150,150,30);
           pass.setEchoChar('*');
           this.add(pass);
           
           Button boto =new Button("Acceptar");
           boto.setBounds(100,100,120,40);
           boto.setBackground(Color.yellow);
           boto.setForeground(Color.white);
           this.add(boto);
           
           Label etiq3 =new Label();
           etiq3.setBounds(10,175,200,60);
           this.add(etiq3);
          
           EscoltaAcceptar e = new EscoltaAcceptar(login,pass,etiq3);
           
           boto.addActionListener(e);
    }

}
