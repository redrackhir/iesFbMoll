/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.services;

import gestionalquileres.Utils;
import static gestionalquileres.services.GestionSql.closeConn;
import static gestionalquileres.services.GestionSql.openConn;
import gestionalquileres.model.Finca;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author red rackhir
 */
public class ServiceFinca {

    private static Connection conn = null;
    private static final int MODE_INSERT = 1;
    private static final int MODE_UPDATE = 2;

    /**
     * Devuelve un objeto Finca dede la BBDD
     *
     * @param idFinca ID del finca a consultar
     * @return Objeto Finca
     */
    public static Finca getFinca(int idFinca) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "SELECT * FROM fincas "
                        + "WHERE Id = '" + idFinca + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                Finca fin = new Finca(rs.getInt("ID"), rs.getString("NOMBRE"),
                        rs.getString("TIPO"),
                        rs.getString("UBICACION"),
                        rs.getString("REFCATASTRAL"),
                        rs.getString("REF_PROPIETARIO"),
                        rs.getString("COMENTARIOS"));
                return fin;
            }
        } catch (SQLException ex) {
            String msg = "SQL Error: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.WARNING_MESSAGE);

        } finally {
            closeConn();
        }
        return null;
    }

    /**
     * Inserta un nuevo finca en la BBDD
     *
     * @param fin Objeto finca a guardar
     */
    public static void insert(Finca fin) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "INSERT INTO fincas ("
                        + "nombre"
                        + ", tipo"
                        + ", ubicacion"
                        + ", refCatastral"
                        + ", ref_propietario"
                        + ", comentarios"
                        + ") "
                        + "VALUES (?, ?, ?, ?, ?, ?);";
                int idx = 1;
                Statement stmt = conn.createStatement();
                sql = assignValues(sql, fin, MODE_INSERT);
                stmt.execute(sql);

                    String msg = ("Registro insertado correctamente.");
                    JOptionPane.showMessageDialog(null, msg, "Base de datos", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            String msg = ("Error al insertar finca: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.WARNING_MESSAGE);
        } finally {
            closeConn();
        }

    }

    private static String assignValues(String sql, Finca fin, int mode) {
        String[] values;
        if (mode == MODE_INSERT) {
            values = fin.getValuesForInsertDb();
        } else {
            values = fin.getValuesForUpdateDb();
        }
        int i = 0;
        while (sql.indexOf("?") > -1) {
            sql = sql.replaceFirst("\\?", values[i]);
            i++;
        }
        return sql;
    }

    /**
     * Modifica el objeto Finca en la BBDD
     *
     * @param fin Objeto Finca
     */
    public static void update(Finca fin) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "UPDATE fincas "
                        + "SET nombre = ?"
                        + ", tipo = ?"
                        + ", ubicacion = ?"
                        + ", refCatastral = ?"
                        + ", ref_propietario = ? "
                        + ", comentarios = ? "
                        + "WHERE Id = " + fin.getId();
                Statement stmt = conn.createStatement();
                sql = assignValues(sql, fin, MODE_UPDATE);
                stmt.execute(sql);

                String str = "Finca " + fin.getNombre() + " actualizado!!";
                Logger.getLogger(Utils.class.getName()).log(Level.INFO, "Actualización", str);
            }
        } catch (SQLException ex) {
            String msg = ("Error al actualizar finca: " + ex.getMessage());
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, msg, ex);
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConn();
        }
    }

    public static boolean delete(String idFinca) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "DELETE FROM fincas "
                        + "WHERE id = '" + idFinca + "'";
                Statement stmt = conn.createStatement();
                return stmt.execute(sql);
            }
        } catch (SQLException ex) {
            String msg = ("Error al actualizar finca: " + ex.getMessage());
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, msg, ex);
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConn();
        }
        return false;
    }

    /**
     * Rellena un comboBox con el resultado de una instruccion SQL. Útil para
     * rellenar combos con 2 campos (id + campo)
     *
     * @param combo Referencia al control JComboBox
     * @param selectedIndex Indice seleccionado en el mismo
     * @param strSQL Instruccion SQL a ejecutar
     */
    public static void populateComboBox(JComboBox combo, String selectedIndex, String nullIndexMessage, String strSQL) {
        try {
            conn = openConn();
            if (conn != null) {
                Statement stmt = conn.createStatement();
                combo.removeAllItems();
                // Add default index selection null
                if (selectedIndex == null) {
                    combo.addItem(nullIndexMessage);
                }
                int idx = 0;
                ResultSet rs = stmt.executeQuery(strSQL);
                while (rs.next()) {
                    combo.addItem(rs.getString(1) + ": " + rs.getString(2));
                    if (rs.getString(1).equals(selectedIndex)) {
                        combo.setSelectedIndex(idx);
                    }
                    idx++;
                }
            }
        } catch (SQLException ex) {
            String msg = ("Excepcion:" + ex.getMessage());
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.WARNING_MESSAGE);
        } finally {
            closeConn();
        }
    }

}
