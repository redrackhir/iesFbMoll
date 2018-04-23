/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresario.acts;

import empresario.model.Empresario;
import empresario.model.Maquina;
import empresario.view.FrmMain;
import empresario.view.FrmMaquina;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

/**
 *
 * @author red rackhir
 */
public class ActsMain {

    private FrmMain frame;

    public ActsMain(FrmMain frame) {
        this.frame = frame;
    }

    public void initComponents() {
        // Rellenar lista de maquinas
        for (Maquina maq : Empresario.getMaquinas()) {

            JMenuItem menuItem = new JMenuItem();
            menuItem.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    showMachine(evt);
                }
            });

            menuItem.setActionCommand(String.valueOf(maq.getUid()));
            menuItem.setText(maq.getName() + "_" + maq.getUid());
            frame.getjMenu1().add(menuItem);
        }
    }

    private void showMachine(ActionEvent evt) {
        int index = Integer.valueOf(evt.getActionCommand()) - 1;
        new FrmMaquina(Empresario.getMaquina(index)).setVisible(true);
    }
}
