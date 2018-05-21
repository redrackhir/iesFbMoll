/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.controller;

import gestionalquileres.FrameModes;
import static gestionalquileres.FrameModes.EDIT;
import gestionalquileres.services.ServiceCliente;
import gestionalquileres.view.FrmCliente;
import gestionalquileres.view.FrmMain;
import gestionalquileres.view.PnlListadoClientes;
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
public class ActionsListadoClientes {

    private PnlListadoClientes frame;

    public ActionsListadoClientes(PnlListadoClientes frame) {
        this.frame = frame;
    }

    public void openEditForm(String idCliente) {
        FrameModes mode = EDIT;
        if (idCliente == null) {
            mode = FrameModes.NEW;
        }
        FrmCliente cli = new FrmCliente(mode, idCliente);
        ((FrmMain) SwingUtilities.getWindowAncestor(frame)).getDesktop().add(cli);
        cli.setVisible(true);
        cli.toFront();
        try {
            cli.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ActionsListadoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String idCliente) {
        int retVal = JOptionPane.showConfirmDialog(frame, "<html><h3>Va a eliminar un registro</h3></br>"
                + "La eliminación es irreversible, está completamente seguro?</html>",
                "Borrar registro", WARNING_MESSAGE);
        if (retVal == YES_OPTION) {
            ServiceCliente.delete(idCliente);
        }
    }

    public void returnSelected(Object valueAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
