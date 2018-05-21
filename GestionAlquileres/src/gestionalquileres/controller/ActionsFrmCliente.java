/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.controller;

import gestionalquileres.FrameModes;
import static gestionalquileres.FrameModes.EDIT;
import static gestionalquileres.FrameModes.NEW;
import gestionalquileres.services.ServiceCliente;
import gestionalquileres.view.FrmCliente;
import gestionalquileres.Utils;
import gestionalquileres.model.Cliente;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author red rackhir
 */
public class ActionsFrmCliente {

    private FrmCliente frame;
    private Cliente cli = new Cliente();
    private boolean isModified;
    private Color COLOR_LIGHT_RED = new Color(255, 220, 220);

    public ActionsFrmCliente(FrmCliente frame, String idCliente) {
        this.frame = frame;
        if (frame.getMode() == EDIT) {
            initialize(EDIT, idCliente);
        } else {
            initialize(NEW, null);
        }
    }

    public void initialize(FrameModes mode, String idCliente) {
        Utils.centrarFrame(frame);
        if (mode == NEW) {
            resetView();
            frame.setTitle("Nuevo cliente");
        } else {
            refreshView(idCliente);
            frame.setTitle("Editar cliente - " + cli.getNombre() + " " + cli.getApellido1());
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
        cli = ServiceCliente.getCliente(idCliente);
        // actualizar campos con los datos del cliente
        frame.getJtfDni().setText(cli.getDni());
        frame.getJtfNombre().setText(cli.getNombre());
        frame.getJtfApellido1().setText(cli.getApellido1());
        frame.getJtfApellido2().setText(cli.getApellido2());
        frame.getJtfTelf1().setText(cli.getTelf1());
        frame.getJtfTelf2().setText(cli.getTelf2());
        frame.getJtfDomicilio().setText(cli.getDomicilio());
        frame.getJtfCP().setText(String.valueOf(cli.getCP()));
        frame.getJtfPoblacion().setText(cli.getPoblacion());
        frame.getJtfSaldo().setText(String.valueOf(cli.getSaldo()));
        frame.getJtfEmail().setText(String.valueOf(cli.getEmail()));
        frame.getJtaComentarios().setText(String.valueOf(cli.getComentarios()));
        // background color to white
        for (Component c: frame.getjPanel1().getComponents()) {
            if (c instanceof JTextField || c instanceof JTextArea) {
                c.setBackground(Color.white);
            }
        }
        setEditPermissions();
    }

    public void insertCliente() {
        ServiceCliente.insert(getClienteFromFrame());
//        if (validateCliente() == true) {
//            //          Cliente cli = getClienteFromFrame();
//        } else {
//            
//        }
    }

    public void updateCliente() {
        if (frame.getMode() == NEW) {
            insertCliente();
        } else {
            ServiceCliente.update(getClienteFromFrame());
        }
        refreshView(getClienteFromFrame().getDni());
    }

    private Cliente getClienteFromFrame() {
        Cliente cli = new Cliente(frame.getJtfDni().getText(),
                frame.getJtfNombre().getText(),
                frame.getJtfApellido1().getText(),
                frame.getJtfApellido2().getText(),
                frame.getJtfDomicilio().getText(),
                frame.getJtfTelf1().getText(),
                frame.getJtfTelf2().getText(),
                frame.getJtfEmail().getText(),
                frame.getJtaComentarios().getText(),
                frame.getJtfPoblacion().getText(),
                Integer.valueOf(Utils.getNoNull(frame.getJtfCP().getText(), "0")),
                Double.valueOf(frame.getJtfSaldo().getText()));
        return cli;
    }

    public void setIsModified(java.awt.event.KeyEvent evt) {
        if (evt.getSource() instanceof JTextField) {
            ((JTextField) evt.getSource()).setBackground(COLOR_LIGHT_RED);
        } else if (evt.getSource() instanceof JTextArea) {
            ((JTextArea) evt.getSource()).setBackground(COLOR_LIGHT_RED);
        }
        this.isModified = true;
    }

    private boolean validateCliente() {
        // verificar campos ok
        boolean retVal = true;
        getClienteFromFrame();

        return cli.validate();
    }

    private void setEditPermissions() {
        switch (frame.getMode()) {
            case NEW:
                frame.getJtfDni().setEnabled(true);
                break;
            case EDIT:
                frame.getJtfDni().setEnabled(false);
                break;
            default:
                break;
        }
    }

}
