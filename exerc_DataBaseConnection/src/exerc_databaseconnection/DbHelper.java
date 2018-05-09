/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_databaseconnection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author soib1a20
 */
public class DbHelper {

    private static final String DB_NAME = "myDataBase";
    private static final String DB_USER = "root";
    private static final String DB_PSWR = "";
    private static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;

    private static Connection conectar() {
        Connection link = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PSWR);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }

    public static DefaultTableModel getTableModel(String vSQL) {
        try {
            Connection cn = conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(vSQL);
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector rows = new Vector();

            while (rs.next()) {
                Vector newRow = new Vector();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }
            return new DefaultTableModel(rows, columnNames);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    static void insert(String txtNif, String txtNom, String txtLLinatge1, String txtLlinatge2) {
        try {
            Connection cn = conectar();
            Statement st = cn.createStatement();
            String dupe = String.format("ON DUPLICATE KEY UPDATE nom = '%s', llinatge1 = '%s', llinatge2 = '%s';",
                    txtNom, txtLLinatge1, txtLlinatge2);
            PreparedStatement pst = cn.prepareStatement("INSERT INTO usuaris VALUES(?,?,?,?) " + dupe);
            pst.setString(1, txtNif);
            pst.setString(2, txtNom);
            pst.setString(3, txtLLinatge1);
            pst.setString(4, txtLlinatge2);

            pst.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    static void delete(String nif) {
        Connection cn = conectar();
        try {
            Statement st = cn.createStatement();
            st.execute("DELETE FROM usuaris WHERE nif = '" + nif + "';");
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
