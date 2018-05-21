/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.controller;

import gestionalquileres.FrameModes;
import static gestionalquileres.FrameModes.EDIT;
import gestionalquileres.services.ServiceContrato;
import gestionalquileres.view.FrmContrato;
import gestionalquileres.view.FrmMain;
import gestionalquileres.view.PnlListadoContratos;
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
public class ActionsListadoContratos {

    private PnlListadoContratos frame;

    public ActionsListadoContratos(PnlListadoContratos frame) {
        this.frame = frame;
    }

    public void openEditForm(int idContrato) {
        FrameModes mode = EDIT;
        if (idContrato == 0) {
            mode = FrameModes.NEW;
        }
        FrmContrato cli = new FrmContrato(mode, idContrato);
        ((FrmMain) SwingUtilities.getWindowAncestor(frame)).getDesktop().add(cli);
        cli.setVisible(true);
        cli.toFront();
        try {
            cli.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ActionsListadoContratos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String idContrato) {
        int retVal = JOptionPane.showConfirmDialog(frame, "<html><h3>Va a eliminar un registro</h3></br>"
                + "La eliminación es irreversible, está completamente seguro?</html>",
                "Borrar registro", WARNING_MESSAGE);
        if (retVal == YES_OPTION) {
            ServiceContrato.delete(idContrato);
        }
    }

}
