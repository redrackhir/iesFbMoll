/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.controller;

import gestionalquileres.FrameModes;
import static gestionalquileres.Utils.centrarFrame;
import gestionalquileres.view.FrmCliente;
import gestionalquileres.view.FrmFinca;
import gestionalquileres.view.FrmMain;
import gestionalquileres.view.PnlBuscarContrato;
import gestionalquileres.view.PnlListadoClientes;
import gestionalquileres.view.PnlListadoContratos;
import gestionalquileres.view.PnlListadoFincas;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JInternalFrame;

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

    public void showNewCliente() {
        FrmCliente cli = new FrmCliente(FrameModes.NEW, null);
        frame.getDesktop().add(cli);
        cli.setVisible(true);
    }

    public void showListadoClientes() {
        // Panel de listado
        PnlListadoClientes pl = new PnlListadoClientes();
        pl.setVisible(true);
        // Formulario interno
        JInternalFrame jf = new JInternalFrame();
        int height = pl.getPreferredSize().height + 30;
        jf.setSize(650, height);
        jf.setTitle("Listado de clientes");
        jf.setClosable(true);
        jf.setResizable(true);
        centrarFrame(jf);
        // Añadimos el panel al formulario
        jf.add(pl);
        // Y este al mdi
        frame.getDesktop().add(jf);
        jf.setVisible(true);

    }

    public void showNewFinca() {
        FrmFinca frm = new FrmFinca(FrameModes.NEW, 0);
        frame.getDesktop().add(frm);
        frm.setVisible(true);
    }

    public void showListadoFincas() {
        // Panel de listado
        PnlListadoFincas pl = new PnlListadoFincas();
        pl.setVisible(true);
        // Formulario interno
        JInternalFrame jf = new JInternalFrame();
        int height = pl.getPreferredSize().height + 30;
        jf.setSize(650, height);
        jf.setTitle("Listado de fincas");
        jf.setClosable(true);
        jf.setResizable(true);
        centrarFrame(jf);
        // Añadimos el panel al formulario
        jf.add(pl);
        // Y este al mdi
        frame.getDesktop().add(jf);
        jf.setVisible(true);

    }

    public void showListadoContratos() {
        // Panel de listado
        PnlListadoContratos pl = new PnlListadoContratos();
        pl.setVisible(true);
        // Formulario interno
        JInternalFrame jf = new JInternalFrame();
        int height = pl.getPreferredSize().height + 30;
        jf.setSize(800, height);
        jf.setTitle("Contratos");
        jf.setClosable(true);
        jf.setResizable(true);
        centrarFrame(jf);
        // Añadimos el panel al formulario
        jf.add(pl);
        // Y este al mdi
        frame.getDesktop().add(jf);
        jf.setVisible(true);
    }

    public void showSearchContrato() {
        // Panel de listado
        PnlBuscarContrato pl = new PnlBuscarContrato();
        pl.setVisible(true);
        // Formulario interno
        JInternalFrame jf = new JInternalFrame();
        int height = pl.getPreferredSize().height + 30;
        jf.setSize(800, height);
        jf.setTitle("Buscar contratos");
        jf.setClosable(true);
        jf.setResizable(true);
        centrarFrame(jf);
        // Añadimos el panel al formulario
        jf.add(pl);
        // Y este al mdi
        frame.getDesktop().add(jf);
        jf.setVisible(true);
    }

}
