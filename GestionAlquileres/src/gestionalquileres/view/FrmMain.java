/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.view;

import gestionalquileres.controller.ActionsFrmMain;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;

/**
 *
 * @author red rackhir
 */
public class FrmMain extends javax.swing.JFrame {

    private ActionsFrmMain acciones;

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
        this.acciones = new ActionsFrmMain(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        clientesMenu = new javax.swing.JMenu();
        newClienteMenuItem = new javax.swing.JMenuItem();
        listClientesMenuItem = new javax.swing.JMenuItem();
        fincasMenu = new javax.swing.JMenu();
        newFincaMenuItem = new javax.swing.JMenuItem();
        listFincasMenuItem = new javax.swing.JMenuItem();
        contratosMenu = new javax.swing.JMenu();
        newContratoMenuItem = new javax.swing.JMenuItem();
        listContratosMenuItem = new javax.swing.JMenuItem();
        findContratoMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clientesMenu.setMnemonic('e');
        clientesMenu.setText("Clientes");
        clientesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesMenuActionPerformed(evt);
            }
        });

        newClienteMenuItem.setMnemonic('t');
        newClienteMenuItem.setText("Nuevo");
        newClienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newClienteMenuItemActionPerformed(evt);
            }
        });
        clientesMenu.add(newClienteMenuItem);

        listClientesMenuItem.setMnemonic('y');
        listClientesMenuItem.setText("Listado");
        listClientesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listClientesMenuItemActionPerformed(evt);
            }
        });
        clientesMenu.add(listClientesMenuItem);

        menuBar.add(clientesMenu);

        fincasMenu.setMnemonic('f');
        fincasMenu.setText("Fincas");

        newFincaMenuItem.setMnemonic('s');
        newFincaMenuItem.setText("Nueva");
        newFincaMenuItem.setVerifyInputWhenFocusTarget(false);
        newFincaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFincaMenuItemActionPerformed(evt);
            }
        });
        fincasMenu.add(newFincaMenuItem);

        listFincasMenuItem.setMnemonic('o');
        listFincasMenuItem.setText("Listado");
        listFincasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listFincasMenuItemActionPerformed(evt);
            }
        });
        fincasMenu.add(listFincasMenuItem);

        menuBar.add(fincasMenu);

        contratosMenu.setMnemonic('h');
        contratosMenu.setText("Contratos");

        newContratoMenuItem.setMnemonic('c');
        newContratoMenuItem.setText("Nuevo");
        contratosMenu.add(newContratoMenuItem);

        listContratosMenuItem.setMnemonic('a');
        listContratosMenuItem.setText("Listado");
        listContratosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listContratosMenuItemActionPerformed(evt);
            }
        });
        contratosMenu.add(listContratosMenuItem);

        findContratoMenuItem.setText("Buscar");
        findContratoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findContratoMenuItemActionPerformed(evt);
            }
        });
        contratosMenu.add(findContratoMenuItem);

        menuBar.add(contratosMenu);

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newClienteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newClienteMenuItemActionPerformed
        acciones.showNewCliente();
    }//GEN-LAST:event_newClienteMenuItemActionPerformed

    private void clientesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientesMenuActionPerformed

    private void listClientesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listClientesMenuItemActionPerformed
        acciones.showListadoClientes();
    }//GEN-LAST:event_listClientesMenuItemActionPerformed

    private void listFincasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listFincasMenuItemActionPerformed
        acciones.showListadoFincas();
    }//GEN-LAST:event_listFincasMenuItemActionPerformed

    private void newFincaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFincaMenuItemActionPerformed
        acciones.showNewFinca();
    }//GEN-LAST:event_newFincaMenuItemActionPerformed

    private void listContratosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listContratosMenuItemActionPerformed
        acciones.showListadoContratos();
    }//GEN-LAST:event_listContratosMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI("file:///C:/Users/red%20rackhir/Documents/BaixaPanell.pdf"));
                System.out.println("Lanzando navegador");
            } else {
                System.out.println("Navegador no soportado");
            }
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void findContratoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findContratoMenuItemActionPerformed
        acciones.showSearchContrato();
    }//GEN-LAST:event_findContratoMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu clientesMenu;
    private javax.swing.JMenu contratosMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fincasMenu;
    private javax.swing.JMenuItem findContratoMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem listClientesMenuItem;
    private javax.swing.JMenuItem listContratosMenuItem;
    private javax.swing.JMenuItem listFincasMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newClienteMenuItem;
    private javax.swing.JMenuItem newContratoMenuItem;
    private javax.swing.JMenuItem newFincaMenuItem;
    // End of variables declaration//GEN-END:variables

    public JDesktopPane getDesktop() {
        return desktopPane;
    }

}