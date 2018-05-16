/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.controller;

import gestionalquileres.view.FrmListado;
import gestionalquileres.FrameModes;
import static gestionalquileres.Utils.centrarFrame;
import gestionalquileres.view.FrmCliente;
import gestionalquileres.view.FrmMain;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

/**
 *
 * @author red rackhir
 */
public class ActionsFrmMain {

    FrmMain frame;

    public ActionsFrmMain(FrmMain frame) {
        this.frame = frame;
        frame.setExtendedState(MAXIMIZED_BOTH);
    }

    public void nuevoCliente() {
        FrmCliente cli = new FrmCliente(FrameModes.NEW);
        frame.getDesktop().add(cli);
        cli.setVisible(true);
    }

    public void showClientesListado() {
        FrmListado fl = new FrmListado();
        fl.setVisible(true);
        JInternalFrame jf = new JInternalFrame();
        jf.setSize(600, 400);
        centrarFrame(jf);
        jf.add(fl);
        jf.setClosable(true);
        jf.pack();
        frame.getDesktop().add(jf);
        jf.setVisible(true);
        
    }

}
