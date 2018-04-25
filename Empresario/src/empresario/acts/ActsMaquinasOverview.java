/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresario.acts;

import empresario.view.FrmMaquinasOverview;
import empresario.model.Empresario;
import empresario.model.Maquina;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 *
 * @author red rackhir
 */
public class ActsMaquinasOverview {

    private FrmMaquinasOverview frame;

    public ActsMaquinasOverview(FrmMaquinasOverview frame) {
        this.frame = frame;
    }

    public void initComponents() {
        populateTable();
    }

    private void populateTable() {
        frame.getjPanel1().removeAll();

        for (Maquina maq : Empresario.getMaquinas()) {
            FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
            Panel cont = new Panel(layout);
            cont.setBackground(Color.LIGHT_GRAY);
            cont.setPreferredSize(new Dimension(400, 35));
            // Boton
            JToggleButton btn = new JToggleButton();
            btn.setActionCommand(String.valueOf(maq.getUid()));
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startStopMachine(e.getActionCommand());
                }

            });
            btn.setSelected(maq.isEnabled());
            btn.setText((maq.isEnabled() ? "Stop" : "Start"));
            cont.add("btnStartStop", btn);
            // Etiqueta
            JLabel label1 = new JLabel();
            String frmt = "%s estado: %s mant.: %d%% cola: %d";
            label1.setText(String.format(frmt, maq.getName() + "_" + maq.getUid(),
                    (maq.isEnabled() ? "Activa" : "Parada"),
                    maq.getMaintState(),
                    maq.getBeltQty()));
            label1.setHorizontalAlignment(SwingConstants.LEFT);
            //label1.setBorder(BorderFactory.createLineBorder(Color.yellow));
            // Añadir al contenedor
            cont.add(label1);

            // Añadir contenedor al panel
            frame.getjPanel1().add(cont);

        }
        frame.getjPanel1().repaint();
        frame.getjPanel1().revalidate();
        //frame.getjPanel1().setPreferredSize(new Dimension(600, 300));
        frame.pack();
    }

    private void startStopMachine(String actionCommand) {
        System.out.println("Encender/Parar machina: " + actionCommand);
        int n = Integer.valueOf(actionCommand) - 1;
        Maquina m = Empresario.getMaquina(n);

        m.setEnabled(!m.isEnabled());

        populateTable();
    }

    public void refresh() {
        populateTable();

    }

}
