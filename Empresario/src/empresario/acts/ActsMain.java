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
import empresario.view.FrmMaquinasOverview;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

/**
 *
 * @author red rackhir
 */
public class ActsMain {

    private FrmMain frame;
    private FrmMaquinasOverview frmOverview;

    public ActsMain(FrmMain frame) {
        this.frame = frame;
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
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
        
        showDataInToolBar();
    }

    private void showDataInToolBar() {
        JLabel label = frame.getjLabel1();
        label.setText(String.format("%.2f€", Empresario.getMoney()));
    }
    
    private void showMachine(ActionEvent evt) {
        int index = Integer.valueOf(evt.getActionCommand()) - 1;
        FrmMaquina maq = new FrmMaquina(Empresario.getMaquina(index));
        maq.setVisible(true);
        frame.getjDesktopPane1().add(maq);
        //frame.pack();

    }

    public void showMachinesOverview() {
        if (frmOverview == null) {
            frmOverview = new FrmMaquinasOverview();
            frmOverview.setTitle("Listado de máquinas");
            frmOverview.setClosable(true);
            frmOverview.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            frame.getjDesktopPane1().add(frmOverview);
            
        } else { frmOverview.refreshData(); }
        frmOverview.setVisible(true);
    }

    public void nextTurn() {
        // produccion de maquinas
        Empresario.nextTurn();
        showMachinesOverview();
        
        // almacenaje
    }

}
