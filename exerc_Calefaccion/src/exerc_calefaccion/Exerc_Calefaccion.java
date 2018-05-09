/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_calefaccion;

import exerc_calefaccion.appareils.AireAcondicionado;
import exerc_calefaccion.appareils.CalderaGas;
import exerc_calefaccion.appareils.TermometroElectronico;
import exerc_calefaccion.appareils.TermometroMercurio;
import exerc_calefaccion.model.Habitacion;
import exerc_calefaccion.view.FrmTermostato;

/**
 *
 * @author red rackhir
 */
public class Exerc_Calefaccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTermostato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTermostato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTermostato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTermostato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Termostato con termometro electronico y caldera de gas en el salón
        FrmTermostato t1 = new FrmTermostato(new Habitacion("Salón"), new TermometroMercurio(),
                new CalderaGas());

        // Termostato con termometro electronico y caldera de gas en el salón
        FrmTermostato t2 = new FrmTermostato(new Habitacion("Cocina"), new TermometroElectronico(),
                new AireAcondicionado());

        Utils.centrarFrame(t1);
        t2.setLocation(t1.getLocation().x + 20, t1.getLocation().y + 20);
        
        t1.setVisible(true);
        t2.setVisible(true);
    }

}
