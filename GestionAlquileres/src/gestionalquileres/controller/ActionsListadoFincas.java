/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.controller;

import gestionalquileres.FrameModes;
import static gestionalquileres.FrameModes.EDIT;
import gestionalquileres.services.ServiceFinca;
import gestionalquileres.view.FrmFinca;
import gestionalquileres.view.FrmMain;
import gestionalquileres.view.PnlListadoFincas;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.SwingUtilities;

/**
 *
 * @author soib1a20
 */
public class ActionsListadoFincas {

    private PnlListadoFincas frame;

    public ActionsListadoFincas(PnlListadoFincas frame) {
        this.frame = frame;
    }

    public void openEditForm(int idFinca) {
        FrameModes mode = EDIT;
        if (idFinca == 0) {
            mode = FrameModes.NEW;
        }
        FrmFinca fin = new FrmFinca(mode, idFinca);
        ((FrmMain) SwingUtilities.getWindowAncestor(frame)).getDesktop().add(fin);
        fin.setVisible(true);
        fin.toFront();
        try {
            fin.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ActionsListadoFincas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String idFinca) {
        int retVal = JOptionPane.showConfirmDialog(frame, "<html><h3>Va a eliminar un registro</h3></br>"
                + "La eliminación es irreversible, está completamente seguro?</html>",
                "Borrar registro", WARNING_MESSAGE);
        if (retVal == YES_OPTION) {
            ServiceFinca.delete(idFinca);
        }
    }

}
