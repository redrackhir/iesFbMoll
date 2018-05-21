/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.controller;

import gestionalquileres.FrameModes;
import static gestionalquileres.FrameModes.EDIT;
import static gestionalquileres.FrameModes.NEW;
import gestionalquileres.services.ServiceContrato;
import gestionalquileres.view.FrmContrato;
import gestionalquileres.Utils;
import static gestionalquileres.Utils.centrarFrame;
import gestionalquileres.model.Contrato;
import gestionalquileres.services.GestionSql;
import gestionalquileres.view.PnlSelectCliente;
import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author red rackhir
 */
public class ActionsFrmContrato {

    private FrmContrato frame;
    private Contrato contr = new Contrato();
    private boolean isModified;
    private Color COLOR_LIGHT_RED = new Color(255, 220, 220);

    public ActionsFrmContrato(FrmContrato frame, int idContrato) {
        this.frame = frame;
        if (frame.getMode() == EDIT) {
            initialize(EDIT, idContrato);
        } else {
            initialize(NEW, 0);
        }
    }

    public void initialize(FrameModes mode, int idContrato) {
        Utils.centrarFrame(frame);
        if (mode == NEW) {
            resetView();
            frame.setTitle("Nuevo contrato");
        } else {
            refreshView(idContrato);
            frame.setTitle("Editar contrato - " + contr.getId());
        }
        ServiceContrato.populateComboBox(frame.getJcbFinca(), "ID", "", "SELECT Id, Nombre FROM fincas");
        ServiceContrato.populateComboBox(frame.getJcbInquilino(), "DNI", "", "SELECT Dni, Nombre FROM fincas");
    }

    private void resetView() {
        for (Component comp : frame.getjPanel1().getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            }
        }
    }

    private void refreshView(int idContrato) {
        contr = ServiceContrato.getContrato(idContrato);
        // actualizar campos con los datos del contrato
        frame.getJtfId().setText(String.valueOf(contr.getId()));
        frame.getJtfFechaInicio().setText(Utils.dateToString(contr.getFechaInicio()));
        frame.getJtfFechaFin().setText(Utils.dateToString(contr.getFechaFin()));
        frame.getJtfFechaFirma().setText(Utils.dateToString(contr.getFechaFirma()));
        frame.getJcbFinca().setSelectedIndex(contr.getRefFinca());
        frame.getJcbInquilino().setSelectedIndex(Integer.valueOf(contr.getRefInquilino()));
        frame.getJtfPrecioInicial().setText(String.valueOf(contr.getPrecioInicial()));
        frame.getJtfRefDocumento().setText(String.valueOf(contr.getRefDoc()));
        frame.getJtfRevision().setText(String.valueOf(contr.getTipoRevision()));
        frame.getJtfTipoContrato().setText(String.valueOf(contr.getTipoContrato()));
        // background color to white
        for (Component c : frame.getjPanel1().getComponents()) {
            if (c instanceof JTextField || c instanceof JTextArea) {
                c.setBackground(Color.white);
            }
        }
        setEditPermissions();
    }

    private Contrato getContratoFromFrame() {
        Contrato contr = new Contrato(Integer.valueOf(frame.getJtfId().getText()),
                frame.getJcbFinca().getSelectedIndex(),
                frame.getJcbInquilino().getSelectedItem().toString(),
                Utils.stringToDate(frame.getJtfFechaInicio().getText()),
                Utils.stringToDate(frame.getJtfFechaFin().getText()),
                Utils.stringToDate(frame.getJtfFechaFirma().getText()),
                frame.getJtfRefDocumento().getText(),
                frame.getJtfTipoContrato().getText(),
                Float.valueOf(frame.getJtfTipoContrato().getText()),
                frame.getJtfRevision().getText());
        return contr;
    }

    public void insertContrato() {
        ServiceContrato.insert(getContratoFromFrame());
//        if (validateContrato() == true) {
//            //          Contrato cli = getContratoFromFrame();
//        } else {
//            
//        }
    }

    public void updateContrato() {
        if (frame.getMode() == NEW) {
            insertContrato();
        } else {
            ServiceContrato.update(getContratoFromFrame());
        }
        refreshView(getContratoFromFrame().getId());
    }

    public void setIsModified(java.awt.event.KeyEvent evt) {
        if (evt.getSource() instanceof JTextField) {
            ((JTextField) evt.getSource()).setBackground(COLOR_LIGHT_RED);
        } else if (evt.getSource() instanceof JTextArea) {
            ((JTextArea) evt.getSource()).setBackground(COLOR_LIGHT_RED);
        }
        this.isModified = true;
    }

    private boolean validateContrato() {
        // verificar campos ok
        boolean retVal = true;
        getContratoFromFrame();

        return contr.validate();
    }

    private void setEditPermissions() {
        switch (frame.getMode()) {
            case NEW:
                frame.getJtfId().setEnabled(true);
                break;
            case EDIT:
                frame.getJtfId().setEnabled(false);
                break;
            default:
                break;
        }
    }

    public void selectFinca() {
        // Panel de listado
        PnlSelectCliente pl = new PnlSelectCliente();
        pl.setVisible(true);
        // Formulario interno
        JInternalFrame jf = new JInternalFrame();
        int height = pl.getPreferredSize().height + 30;
        jf.setSize(250, 350);
        jf.setTitle("Seleccione cliente");
        jf.setClosable(true);
        jf.setResizable(true);
        centrarFrame(jf);
        // Añadimos el panel al formulario
        jf.add(pl);
        // Y este al mdi
        frame.getParent().add(jf);
//        ((JFrame)frame.getParent()).getDesktop().add(jf);
        jf.setVisible(true);
        try {
            jf.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ActionsFrmContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
