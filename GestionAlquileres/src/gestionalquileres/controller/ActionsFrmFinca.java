/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.controller;

import gestionalquileres.FrameModes;
import static gestionalquileres.FrameModes.EDIT;
import static gestionalquileres.FrameModes.NEW;
import gestionalquileres.services.ServiceFinca;
import gestionalquileres.view.FrmFinca;
import gestionalquileres.Utils;
import gestionalquileres.model.Finca;
import java.awt.Color;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author red rackhir
 */
public class ActionsFrmFinca {

    private FrmFinca frame;
    private Finca fin = new Finca();
    private boolean isModified;
    private Color COLOR_LIGHT_RED = new Color(255, 220, 220);

    public ActionsFrmFinca(FrmFinca frame, int idFinca) {
        this.frame = frame;
        if (frame.getMode() == EDIT) {
            initialize(EDIT, idFinca);
        } else {
            initialize(NEW, 0);
        }
    }

    public void initialize(FrameModes mode, int idFinca) {
        Utils.centrarFrame(frame);
        if (mode == NEW) {
            resetView();
            frame.setTitle("Nuevo finca");
        } else {
            refreshView(idFinca);
            frame.setTitle("Editar finca - " + fin.getNombre() + " " + fin.getTipo());
        }

    }

    private void resetView() {
        for (Component comp : frame.getjPanel1().getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            }
        }
        frame.getJtfId().setEnabled(false);
        populateTipoComboBox(frame.getJcbTipo());
        populatePropietarioComboBox();
    }

    private void refreshView(int idFinca) {
        fin = ServiceFinca.getFinca(idFinca);
        // actualizar campos con los datos del finca
        populateTipoComboBox(frame.getJcbTipo());
        populatePropietarioComboBox();

        frame.getJtfId().setText(String.valueOf(idFinca));
        frame.getJtfNombre().setText(fin.getNombre());
        frame.getJcbTipo().setSelectedItem(fin.getTipo());
        frame.getJtfUbicacion().setText(fin.getUbicacion());
        frame.getJtfRefCatastral().setText(fin.getRefCatastral());
//        frame.getJcbPropietario().setSelectedItem(fin.getRefPropietario());
        frame.getJtaComentarios().setText(fin.getComentarios());
        setBgColorEditableComponents(Color.white);
        setEditPermissions();
    }

    private void setBgColorEditableComponents(Color clr) {
        // background color to white
        for (Component comp : frame.getjPanel1().getComponents()) {
            if (comp instanceof JTextField || comp instanceof JTextArea) {
                comp.setBackground(Color.white);
            }
        }
    }

    private void populateTipoComboBox(JComboBox cbb) {
        cbb.removeAllItems();
        cbb.addItem("Urbana");
        cbb.addItem("Industrial");
        cbb.addItem("Rústica");
    }

    private void populatePropietarioComboBox() {
        String strSQL = "SELECT dni, concat(nombre,' ',apellido1) AS cliente FROM clientes;";
        ServiceFinca.populateComboBox(frame.getJcbPropietario(), fin.getRefPropietario(),
                "Seleccione propietario", strSQL);
    }

    public void insertFinca() {
        ServiceFinca.insert(getFincaFromFrame());
//        if (validateFinca() == true) {
//            //          Finca fin = getFincaFromFrame();
//        } else {
//            
//        }
    }

    public void updateFinca() {
        if (frame.getMode() == NEW) {
            insertFinca();
        } else {
            ServiceFinca.update(getFincaFromFrame());
        }
        refreshView(getFincaFromFrame().getId());
    }

    private Finca getFincaFromFrame() {
        try {
            int id = frame.getJtfId().getText().equals("") ? 0 : Integer.valueOf(frame.getJtfId().getText());
            Finca fin = new Finca(id,
                    frame.getJtfNombre().getText(),
                    frame.getJcbTipo().getSelectedItem().toString(),
                    frame.getJtfUbicacion().getText(),
                    frame.getJtfRefCatastral().getText(),
                    frame.getJcbPropietario().getSelectedItem().toString().split(":")[0],
                    frame.getJtaComentarios().getText());
            return fin;
        } catch (Exception ex) {
            String msg = ("Datos no válidos: " + ex.getMessage());
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, msg, ex);
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void setIsModified(java.awt.event.KeyEvent evt) {
        if (evt.getSource() instanceof JTextField) {
            ((JTextField) evt.getSource()).setBackground(COLOR_LIGHT_RED);
        } else if (evt.getSource() instanceof JTextArea) {
            ((JTextArea) evt.getSource()).setBackground(COLOR_LIGHT_RED);
        }
        this.isModified = true;
    }

    private boolean validateFinca() {
        // verificar campos ok
        boolean retVal = true;
        getFincaFromFrame();

        return fin.validate();
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

}
