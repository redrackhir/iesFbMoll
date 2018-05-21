/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.services;

import gestionalquileres.Utils;
import java.sql.Connection;
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
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase trata las acciones comunes con la base de datos: leer, insertar,
 * modificar y borrar registros
 *
 * @author red rackhir
 */
public class GestionSql {

    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/gestion_alquileres";
    static final String USER = "root";
    static final String PASS = "159753";
    private static Connection conn = null;

    /**
     * Abre la conexión con la BBDD.
     *
     * @return True si fue exitosa o False si no lo fue.
     */
    public static Connection openConn() {
        // comprueba si sigue abierta y la cierra
        try {
            //PASO 1: Open a connection   
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(true);
        } catch (SQLException se) {
            //se.printStackTrace();
            String msg = "Excepción SQL: " + se.getMessage()
                    + "\nCompruebe que el servidor MySQL está funcionando.";
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            //e.printStackTrace();
            String msg = "Excepción: " + e.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.WARNING_MESSAGE);
        }
        return conn;
    }

    /**
     * Cierra la conexión con la BBDD
     *
     * @return
     */
    public static boolean closeConn() {
        if (conn != null) {
            try {
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(GestionSql.class.getName()).log(Level.SEVERE, null, ex);
                String msg = "Excepción: " + ex.getMessage();
                JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.WARNING_MESSAGE);
            }
        }
        return false;
    }

    /**
     * Consulta la BBDD y devuelve un DefaultTableModel cargado con los datos.
     * El parámetro pasado debe contener la consulta SQL.
     *
     * @param strSQL Cadena con la sentencia SQL a ejecutar.
     * @return DefaultTableModel con los datos devueltos listos para añadir al
     * JTable.
     */
    public static DefaultTableModel getTableModel(String strSQL) {
        Statement stmt = null;
        try {
            conn = openConn();
            if (conn != null) {
                stmt = conn.createStatement();
                ResultSet rst = stmt.executeQuery(strSQL);
                ResultSetMetaData metaDatos = rst.getMetaData();
                // nombres de columnas
                Vector<String> columnas = new Vector<String>();
                int nroColumnas = metaDatos.getColumnCount();
                for (int columna = 1; columna <= nroColumnas; columna++) {
                    columnas.add(metaDatos.getColumnName(columna));
                }
                // Datos de la tabla
                Vector<Vector<Object>> data = new Vector<>();
                while (rst.next()) {
                    Vector<Object> vector = new Vector<Object>();
                    for (int idColumna = 1; idColumna <= nroColumnas; idColumna++) {
                        vector.add(rst.getObject(idColumna));
                    }
                    data.add(vector);
                }

                return new DefaultTableModel(data, columnas) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

            }
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GestionSql.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    /**
     * Ejecuta la sentencia DELETE, es decir, borrar registro en la BBDD
     *
     * @param tabla Nombre de la tabla a ejecutar la sentencia
     * @param indexVarName Nombre del campo/columna que contiene el ID, el campo
     * UNIQUE KEY, vamos.
     * @param indexID Valor del índice (ID) que queremos borrar
     */
    public static void borraRegistro(String tabla, String indexVarName, int indexID) {
        try {
            conn = openConn();
            if (conn != null) {
                String strSQL = "DELETE FROM " + tabla + " WHERE " + indexVarName + " = " + indexID;
                PreparedStatement stmt = conn.prepareStatement(strSQL);
                stmt.execute();
                Logger.getLogger(Utils.class.getName()).log(Level.INFO, "Sentencia SQL", strSQL);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionSql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Fallo al ejecutar SQL:" + ex.getMessage(), "Atención!!", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConn();
        }
    }

    /**
     * Funcion equivalente a la que existe en MSAccess.\n Devuelve el resultado
     * consultado en la BBDD
     *
     * @param FieldName Nombre de campo a consultar
     * @param TableName Tabla a consultar
     * @param Criteria Equivale a la cadena SQL 'WHERE' pero sin el 'WHERE'
     * @return Objeto con el resultado de la consulta SQL
     */
    public static Object DLookup(String FieldName, String TableName, String Criteria) {
        try {
            conn = openConn();
            if (conn != null) {
                String strSQL = "SELECT " + FieldName + " FROM " + TableName + " WHERE " + Criteria;
                Statement stmt = conn.createStatement();
                ResultSet rst = stmt.executeQuery(strSQL);
                Logger.getLogger(Utils.class.getName()).log(Level.INFO, "Sentencia SQL: " + strSQL);
                if (rst.next()) {
                    return rst.getObject(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionSql.class.getName()).log(Level.SEVERE, null, ex);
            String msg = "Excepción: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestionSql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
