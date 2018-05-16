/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.controller;

import gestionalquileres.FrameModes;
import gestionalquileres.view.FrmCliente;
import gestionalquileres.view.FrmListado;
import gestionalquileres.view.FrmMain;
import javax.swing.SwingUtilities;

/**
 *
 * @author soib1a20
 */
public class ActionsListado {

    private FrmListado frame;

    public ActionsListado(FrmListado frame) {
        this.frame = frame;
    }

    public void openFrmCliente(String idCliente) {
        FrmCliente cli = new FrmCliente(FrameModes.NEW);
        ((FrmMain)SwingUtilities.getWindowAncestor(frame)).getDesktop().add(cli);
        cli.setVisible(true);
    }

}
