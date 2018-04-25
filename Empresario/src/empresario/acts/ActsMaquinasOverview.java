/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresario.acts;

import empresario.view.FrmMaquinasOverview;
import empresario.model.Empresario;
import empresario.model.Maquina;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
        // Creacion de componentes
        Dimension tamanyo = new Dimension(300, 150);
        Color fondo = Color.red;
        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("label1");

        // Redimensionado de componentes
        panel1.setPreferredSize(tamanyo);
        panel1.setLocation(0, 0);
        panel1.setVisible(true);
        panel1.setBackground(fondo);

        // Añadir componentes al panel
        panel1.add(label1);

        // Añadir panel al frame
        frame.getContentPane().add(panel1);
        frame.getContentPane().add(label1);
        frame.pack();
    }

    private void populateTable2() {
        /*        Container cont = new Container();
        cont.setPreferredSize(new Dimension(500, 300));*/
        for (Maquina maq : Empresario.getMaquinas()) {
            JLabel label1 = new JLabel();
            label1.setText(maq.getName() + "_" + maq.getUid());
            //frame.getjPanel1().add(label1);
            frame.getContentPane().add(label1);

            JButton btn = new JButton();
            btn.setActionCommand(String.valueOf(maq.getUid()));
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startStopMachine(e.getActionCommand());
                }

            });
            btn.setText("Start/Stop");
            frame.getjPanel1().add("btnStartStop", btn);

        }
        //scrollPane = new JScrollPane(cont, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPane.setPreferredSize(new Dimension(500, 300));
        /*JPanel panelContainer = new JPanel(new BorderLayout(3, 3));
        panelContainer.setBackground(Color.red);
        panelContainer.setBorder(new javax.swing.border.LineBorder(Color.BLUE));
        panelContainer.setPreferredSize(new Dimension(500, 300));
        panelContainer.add(scrollPane, BorderLayout.CENTER);*/

        //add everything to frame   
        //JFrame frame = new JFrame();
        /*frame.setPreferredSize(new Dimension(800, 400)); */
        frame.getjPanel1().setPreferredSize(new Dimension(600,300));
        frame.pack();
        /*datos.add(maq.getName());
            datos.add(String.valueOf(maq.getMaintState()));
            datos.add(String.valueOf(maq.isEnabled()));*/
    }

    private void startStopMachine(String actionCommand) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
