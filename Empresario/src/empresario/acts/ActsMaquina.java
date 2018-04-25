/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresario.acts;

import empresario.model.Empresario;
import empresario.model.Maquina;
import empresario.model.Product;
import empresario.view.FrmMaquina;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author red rackhir
 */
public class ActsMaquina {

    private FrmMaquina frame;
    private Maquina maq;

    public ActsMaquina(FrmMaquina frame, Maquina maq) {
        this.frame = frame;
        this.maq = maq;
    }

    public void initComponents() {
        frame.getjButton1().setText("Ok");
        frame.getjButton2().setText("Cancel");
        frame.getjLabel6().setText("Materia Prima");
        frame.getjLabel7().setText("Productos");
        frame.getjToggleButton1().setText("Start / Stop");
        frame.setTitle(maq.getName() + "#" + maq.getUid());
    }

    public void fillData() {
        // Primera linea
        String frmt = "Estado: %d%%   %s   Prod. x turno: %.2f";
        String info = String.format(frmt, maq.getMaintState(),
                maq.isEnabled() ? "Funcionando" : "Parada",
                maq.getProdXTurn());
        frame.getjLabel1().setText(info);

        // Segunda linea
        frmt = "Llenado cintas: %d   Capacidad: %d   Consumo kWh: %.2f   Consumido: %.2f";
        info = String.format(frmt, maq.getBeltQty(), maq.getBeltCapacity(),
                maq.getEnergyConsumption(), maq.getEnergyConsumed());
        frame.getjLabel2().setText(info);

        // Lista de prods. consumidos
        DefaultListModel model = new DefaultListModel();
        for (Product p : maq.getProdConsumed()) {
            model.addElement(p.getName() + " - " + p.getConsumeQty());
        }
        frame.getjList1().setModel(model);

        // Lista de prods. fabricados
        model = new DefaultListModel();
        for (Product p : maq.getProdCreated()) {
            model.addElement(p.getName() + " - " + maq.getProdXTurn());
        }
        frame.getjList2().setModel(model);

        // Boton On/Off
        frame.getjToggleButton1().setSelected(maq.isEnabled());

    }

    public void startStopMachine() {
        maq.setEnabled(!maq.isEnabled());
        frame.getjToggleButton1().setSelected(maq.isEnabled());
        fillData();
    }

    public void nextTurn() {
        maq.nextTurn();
        fillData();
    }

    public void btnOk() {
        try {
            frame.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ActsMaquina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void btnCancel() {
        btnOk();
    }
}
