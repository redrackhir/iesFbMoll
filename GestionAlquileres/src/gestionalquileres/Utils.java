/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author red rackhir
 */
public class Utils {

    /**
     * Centra el frame en la pantalla
     *
     * @param ventana Frame a centrar
     */
    public static void centrarFrame(Object ventana) {
        Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension medidasVentana;
        Point pnt = new Point();
        int w, h, type;

        if (ventana instanceof JFrame) {
            medidasVentana = getFrameDimension((JFrame) ventana);
        } else {
            medidasVentana = getInternalFrameDimension((JInternalFrame) ventana);
        }

        w = medidasVentana.width;
        h = medidasVentana.height;

        pnt.x = (scr.width - w) / 2;
        pnt.y = (scr.height - h) / 2 - 50;

        if (ventana instanceof JFrame) {
            ((JFrame) ventana).setLocation(pnt);
        } else {
            ((JInternalFrame) ventana).setLocation(pnt);
        }
    }

    private static Dimension getFrameDimension(JFrame jFrame) {
        return new Dimension(jFrame.getWidth(), jFrame.getHeight());
    }

    private static Dimension getInternalFrameDimension(JInternalFrame jInternalFrame) {
        return new Dimension(jInternalFrame.getWidth(), jInternalFrame.getHeight());
    }

    public static String getNoNull(String text, String defValue) {
        String retVal = defValue;
        if (text!=null && !text.isEmpty()) {
            retVal = text;
        } 
        return retVal;
    }

    public static String dateToString(Date fechaFin) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy") ;
            return sdf.format(fechaFin);
    }
    
    public static Date stringToDate(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy") ;
        try {
            return (Date) sdf.parse(strDate);
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
