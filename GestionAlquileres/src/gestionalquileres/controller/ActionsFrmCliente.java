/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.controller;

import gestionalquileres.FrameModes;
import gestionalquileres.services.ServiceCliente;
import gestionalquileres.view.FrmCliente;
import gestionalquileres.Utils;
import gestionalquileres.model.Cliente;
import java.awt.Component;
import javax.swing.JTextField;

/**
 *
 * @author red rackhir
 */
public class ActionsFrmCliente {

    private FrmCliente frame;
    private Cliente cli = new Cliente();
    private boolean isModified;

    public ActionsFrmCliente(FrmCliente frame) {
        this.frame = frame;
        if (frame.getMode() == FrameModes.EDIT) {
            initialize(frame.getJtfDni().getText());
        } else {
            initialize(null);
        }
    }

    public void initialize(String idCliente) {
        Utils.centrarFrame(frame);
        if (idCliente == null) {
            resetView();
        } else {
            refreshView(idCliente);
        }
    }

    private void resetView() {
        for (Component comp : frame.getjPanel1().getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            }
        }
    }

    private void refreshView(String idCliente) {
//        loadData(idCliente);
        // actualizar campos con los datos del cliente
    }

    public void insertNewCliente() {
            ServiceCliente.insertCliente(getClienteFromFrame());
//        if (validateCliente() == true) {
//            //          Cliente cli = getClienteFromFrame();
//        } else {
//            
//        }
    }

    private Cliente getClienteFromFrame() {
        Cliente cli = new Cliente(frame.getJtfDni().getText(),
                frame.getJtfNombre().getText(), frame.getJtfApellido1().getText(),
                frame.getJtfApellido2().getText(), frame.getJtfDomicilio().getText(),
                frame.getJtfTelf1().getText(), frame.getJtfTelf2().getText(),
                null, "No comments", frame.getJtfPoblacion().getText(),
                Integer.valueOf(Utils.getNoNull(frame.getJtfCP().getText(), "0")), 0);
        return cli;
    }

    public void setIsModified(boolean value) {
        this.isModified = value;
    }

    private boolean validateCliente() {
        // verificar campos ok
        boolean retVal = true;
        getClienteFromFrame();

        return cli.validate();
    }

}
