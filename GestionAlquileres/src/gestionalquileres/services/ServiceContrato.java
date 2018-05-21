/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.services;

import gestionalquileres.Utils;
import static gestionalquileres.services.GestionSql.closeConn;
import static gestionalquileres.services.GestionSql.openConn;
import gestionalquileres.model.Contrato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author red rackhir
 */
public class ServiceContrato {

    private static Connection conn = null;
    private static final int MODE_INSERT = 1;
    private static final int MODE_UPDATE = 2;
    private static final String PRIMARY_KEY = "Id";
    private static final String[] FIELDS = {"Id", "ref_finca", "ref_inquilino", "fecha_inicio",
        "fecha_fin", "fecha_firma", "refDocumento", "tipo_contrato", "precio_inicial", "revision"};

    /**
     * Devuelve un objeto Contrato dede la BBDD
     *
     * @param idContrato ID del contrato a consultar
     * @return Objeto Contrato
     */
    public static Contrato getContrato(int idContrato) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "SELECT * FROM contratos "
                        + "WHERE Id = '" + idContrato + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                Contrato contr = new Contrato(rs.getInt("ID"), rs.getInt("ref_Finca"),
                        rs.getString("ref_Inquilino"), rs.getDate("fecha_Inicio"),
                        rs.getDate("fecha_Fin"), rs.getDate("fecha_Firma"),
                        rs.getString("refDocumento"), rs.getString("tipo_Contrato"),
                        rs.getFloat("precio_Inicial"), rs.getString("Revision"));
                return contr;
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
     * Inserta un nuevo contrato en la BBDD
     *
     * @param cli Objeto contrato a guardar
     */
    public static void insert(Contrato cli) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "INSERT INTO contratos (";
                for (String f : FIELDS) {
                    sql += f + ", ";
                }
                sql = sql.substring(0, sql.length() - 2);

                sql += "VALUES (";
                for (int i = 0; i < FIELDS.length; i++) {
                    sql += "?, ";
                }
                sql = sql.substring(0, sql.length() - 2);
                sql += ");";

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
            String msg = ("Error al insertar contrato: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.WARNING_MESSAGE);
        } finally {
            closeConn();
        }

    }

    private static void assignValues(PreparedStatement stmt, Contrato cli, int mode) throws SQLException {
        int idx = 1;
        if (mode == MODE_INSERT) {
            stmt.setInt(idx, cli.getId());
            idx++;
        }
        stmt.setInt(idx, cli.getRefFinca());
        idx++;
        stmt.setString(idx, cli.getRefInquilino());
        idx++;
        stmt.setDate(idx, cli.getFechaInicio());
        idx++;
        stmt.setDate(idx, cli.getFechaFin());
        idx++;
        stmt.setDate(idx, cli.getFechaFirma());
        idx++;
        stmt.setString(idx, cli.getRefDoc());
        idx++;
        stmt.setString(idx, cli.getTipoContrato());
        idx++;
        stmt.setFloat(idx, cli.getPrecioInicial());
        idx++;
        stmt.setString(idx, cli.getTipoRevision());
    }

    /**
     * Modifica el objeto Contrato en la BBDD
     *
     * @param cli Objeto Contrato
     */
    public static void update(Contrato cli) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "UPDATE contratos SET ";
                for (String f : FIELDS) {
                    sql += f + " = ?";
                }
                sql += "WHERE dni = '" + cli.getId() + "'";
                PreparedStatement stmt = conn.prepareStatement(sql);
                assignValues(stmt, cli, MODE_UPDATE);
                stmt.executeUpdate();

                String str = "Contrato " + cli.getId() + " actualizado!!";
                Logger.getLogger(Utils.class.getName()).log(Level.INFO, "Actualización", str);
            }
        } catch (SQLException ex) {
            String msg = ("Error al actualizar contrato: " + ex.getMessage());
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, msg, ex);
            JOptionPane.showMessageDialog(null, msg, "Atención!!", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConn();
        }
    }

    public static boolean delete(String idContrato) {
        try {
            conn = openConn();
            if (conn != null) {
                String sql = "DELETE FROM contratos "
                        + "WHERE " + PRIMARY_KEY + " = '" + idContrato + "'";
                Statement stmt = conn.createStatement();
                return stmt.execute(sql);
            }
        } catch (SQLException ex) {
            String msg = ("Error al actualizar contrato: " + ex.getMessage());
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
