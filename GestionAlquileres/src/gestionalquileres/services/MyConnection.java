/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author red rackhir
 */
public class MyConnection {

    private static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            try {
                // determina cuando finaliza el programa para cerrar la conexión
                Runtime.getRuntime().addShutdownHook(new myShtDwnHook());
                
                ResourceBundle rb = ResourceBundle.getBundle("jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String pwd = rb.getString("pwd");
                String usr = rb.getString("usr");
                
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return con;
    }
    
    static class myShtDwnHook extends Thread {
        // MVJ invocará este método antes de finalizar el programa
        // Ahí aprovechamos para cerrar la conexión
        public void run() {
            try {
                Connection con = MyConnection.getConnection();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
