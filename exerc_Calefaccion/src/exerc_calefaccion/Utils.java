/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_calefaccion;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author red rackhir
 */
public class Utils {
       /** Centra el frame en la pantalla
     * @param ventana Frame a centrar
     */
    public static void centrarFrame(JFrame ventana) {
        Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
        Point pnt = new Point();
        
        int w = ventana.getWidth();
        int h = ventana.getHeight();
        
        pnt.x  = (scr.width - w) / 2;
        pnt.y  = (scr.height - h) / 2 - 50;

        ventana.setLocation(pnt);
    }
    
}
