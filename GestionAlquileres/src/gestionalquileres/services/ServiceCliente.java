/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.services;

import gestionalquileres.Utils;
import static gestionalquileres.services.GestionSql.closeConn;
import static gestionalquileres.services.GestionSql.openConn;
import gestionalquileres.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ServiceCliente {

    private static Connection conn = null;
    private static final int MODE_INSERT = 1;
    private static final int MODE_UPDATE = 2;

    /**
     * Devuelve un objeto Cliente dede la BBDD
     *
     * @param idCliente ID del cliente a consultar
     * @return Objeto Cliente
     */
    public static Cliente getCliente(String idCliente) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "SELECT * FROM clientes "
                        + "WHERE dni = '" + idCliente + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                Cliente cli = new Cliente(rs.getString("DNI"), rs.getString("Nombre"),
                        rs.getString("Apellido1"), rs.getString("Apellido2"),
                        rs.getString("Domicilio"), rs.getString("Telf1"),
                        rs.getString("Telf2"), rs.getString("Email"),
                        rs.getString("Comentarios"), rs.getString("Poblacion"),
                        rs.getInt("CP"), rs.getDouble("Saldo"));
                return cli;
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
     * Inserta un nuevo cliente en la BBDD
     *
     * @param cli Objeto cliente a guardar
     */
    public static void insert(Cliente cli) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "INSERT INTO clientes (dni, nombre, apellido1, apellido2, "
                        + "domicilio, telf1, telf2, cp, poblacion, saldo, email, comentarios) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                int idx = 1;
                PreparedStatement stmt = conn.prepareStatement(sql);
                assignValues(stmt, cli, MODE_INSERT);
                int retVal = stmt.executeUpdate();
                if (retVal > 0) {
                    String msg = ("Registro insertado correctamente.");
                    JOptionPane.showMessageDialog(null, msg, "Base de datos", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String msg = ("El registro no se ha podido insertar.\nVerifique que los datos son correctos");
                    JOptionPane.showMessageDialog(null, msg, "Base de datos", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            String msg = ("Error al insertar cliente: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.WARNING_MESSAGE);
        } finally {
            closeConn();
        }

    }

    private static void assignValues(PreparedStatement stmt, Cliente cli, int mode) throws SQLException {
        int idx = 1;
        if (mode == MODE_INSERT) {
            stmt.setString(idx, cli.getDni());
            idx++;
        }
        stmt.setString(idx, cli.getNombre());
        idx++;
        stmt.setString(idx, cli.getApellido1());
        idx++;
        stmt.setString(idx, cli.getApellido2());
        idx++;
        stmt.setString(idx, cli.getDomicilio());
        idx++;
        stmt.setString(idx, cli.getTelf1());
        idx++;
        stmt.setString(idx, cli.getTelf2());
        idx++;
        stmt.setInt(idx, cli.getCP());
        idx++;
        stmt.setString(idx, cli.getPoblacion());
        idx++;
        stmt.setDouble(idx, cli.getSaldo());
        idx++;
        stmt.setString(idx, cli.getEmail());
        idx++;
        stmt.setString(idx, cli.getComentarios());
        idx++;
    }

    /**
     * Modifica el objeto Cliente en la BBDD
     *
     * @param cli Objeto Cliente
     */
    public static void update(Cliente cli) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "UPDATE clientes SET nombre = ?, apellido1 = ?, apellido2 = ?, "
                        + "domicilio = ?, telf1 = ?, telf2 = ?, cp = ?, poblacion = ?, saldo = ?, "
                        + "email = ?, comentarios = ? "
                        + "WHERE dni = '" + cli.getDni() + "'";
                PreparedStatement stmt = conn.prepareStatement(sql);
                assignValues(stmt, cli, MODE_UPDATE);
                stmt.executeUpdate();

                String str = "Cliente " + cli.getNombre() + " actualizado!!";
                Logger.getLogger(Utils.class.getName()).log(Level.INFO, "Actualización", str);
            }
        } catch (SQLException ex) {
            String msg = ("Error al actualizar cliente: " + ex.getMessage());
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, msg, ex);
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConn();
        }
    }

    public static boolean delete(String idCliente) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "DELETE FROM clientes "
                        + "WHERE dni = '" + idCliente + "'";
                Statement stmt = conn.createStatement();
                return stmt.execute(sql);
            }
        } catch (SQLException ex) {
            String msg = ("Error al actualizar cliente: " + ex.getMessage());
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
    public static void rellenaComboBox(JComboBox combo, int selectedIndex, String strSQL) {
        try {
            conn = openConn();
            if (conn != null) {
                Statement stmt = conn.createStatement();
                combo.removeAllItems();
                int idx = 0;
                ResultSet rs = stmt.executeQuery(strSQL);
                while (rs.next()) {
                    combo.addItem(rs.getInt(1) + " - " + rs.getString(2));
                    if (rs.getInt(1) == selectedIndex) {
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
