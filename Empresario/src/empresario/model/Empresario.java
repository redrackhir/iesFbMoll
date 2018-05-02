/*
 * Empresario.java
 * 
 * Copyright (c) 2018 red rackhir.
 * 
 * Empresario is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Empresario is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Expression program is undefined on line 16, column 30 in Templates/Licenses/license-default.txt..  If not, see <http ://www.gnu.org/licenses/>.
 */
package empresario.model;

import empresario.view.FrmMain;
import empresario.view.FrmMaquina;
import java.util.ArrayList;

/**
 *
 * @author red rackhir
 */
public class Empresario {

    private static ArrayList<Maquina> maquinas = new ArrayList<>();
    private static Stock stock;
    private static double money = 150f;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Product botella = new Product(1, "Envase de vidrio 25cl.", 50, "Uds.", 1);
        Product cocacola = new Product(1, "Coca-cola", 150, "L.", 0.25);
        Product product = new Product(1, "Botella Coca-cola 25cl.", 0, "L.", 0);
        stock.addProduct(botella);
        stock.addProduct(cocacola);
        stock.addProduct(product);
        ArrayList<Product> prodConsumed = new ArrayList<>();
        prodConsumed.add(stock.get(0));
        prodConsumed.add(stock.get(1));
        ArrayList<Product> prodCreated = new ArrayList<>();
        prodCreated.add(stock.get(2));

        maquinas.add(new Maquina(1, "Embotelladora", 50.0, 180000.0, 100, 100, 25, prodConsumed, prodCreated));
        maquinas.add(new Maquina(2, "Embotelladora", 50.0, 50000.0, 75, 75, 38, prodConsumed, prodCreated));

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
            java.util.logging.Logger.getLogger(FrmMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    public static Maquina getMaquina(int i) {
        return maquinas.get(i);
    }

    public static ArrayList<Maquina> getMaquinas() {
        return maquinas;
    }
    
    public static void nextTurn() {
        // Pasa turno por cada maquina
        for (Maquina m:getMaquinas()) {
            m.nextTurn();
        }
    }

    public static double getMoney() {
        return money;
    }
    

}
