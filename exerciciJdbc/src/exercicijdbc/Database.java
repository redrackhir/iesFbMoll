/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicijdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tipo: JavaDB Operaciones típicas INSERT, UPDATE, SELECT...
 *
 * @author red rackhir
 */
public class Database {

    private final String dbName = "exerciciDatabase";
    private final String user = "redrackhir";
    private final String dbPassword = "";
    private final String strUrl = "jdbc:derby://localhost:1527/" + dbName;
    private Connection dbConn = null;

    public Database() {
        setDBSystemDir();
    }

    private void setDBSystemDir() {
        // Decide on the db system directory: <userhome>/.addressbook/
        String userHomeDir = System.getProperty("user.home", ".");
        String systemDir = userHomeDir + "\\.netbeans-derby";
        try {
            // Register driver
            System.out.println("Registrando driver jdbc...");
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("systemDir=" + systemDir);
        //DriverManager.registerDriver(new jdbc.Driver());
        // Set the db system directory.
        System.setProperty("derby.system.home", systemDir);

        dbConn = null;
        //String strUrl = "jdbc:derby://localhost:1527/" + dbName;
        //String strUrl = "jdbc:derby://localhost:1527/exerciciBanco";
        System.out.println("Conectando a: " + strUrl);
        try {
            dbConn = DriverManager.getConnection(strUrl, user, dbPassword);
            System.out.println("Conectado OK.");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    private void createDb() {
        // Crear database en jdbc
        String strSql = "CREATE DATABASE IF NOT EXISTS 'curstomers';";
        crearTablaCustomers();
    }
    
    private void crearTablaCustomers() {
        String strSql = "CREATE TABLE customers IF NOT EXISTS "
                + "(id INTEGER NOT NULL, " 
                + "dni VARCHAR(15), "
                + "customer_name VARCHAR(50), "
                + "PRIMARY KEY (id));";
    }

    public Usuario getUsuario(int idUsuario) {
        //String strUrl = "jdbc:derby:" + dbName + ";user=" + user + ";password=" + dbPassword;
        String strSql = "SELECT * FROM Usuarios WHERE id=" + idUsuario;
        try {
            //dbConn = DriverManager.getConnection(strUrl);
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery(strSql);

            while (rs.next()) {
                Usuario c = new Usuario(rs.getString("dni"), rs.getString("nombre"));
                return c;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return null;
    }

    public void loadUsuariosFromDb(ListaUsuarios lista) {

        String strSql = "SELECT dni, nombre FROM Usuarios";
        try {
            //dbConn = DriverManager.getConnection(strUrl);
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery(strSql);

            while (rs.next()) {
                lista.addUsuario(rs.getString("dni"), rs.getString("nombre"));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public void insertUsuario(Usuario c) {
        try {
            String insertUsuarioSql = "INSERT INTO Usuarios (ID, DNI, NOMBRE) "
                    + "VALUES (?,?,?)";
            PreparedStatement prepStat = dbConn.prepareStatement(insertUsuarioSql);
            prepStat.setInt(1, getNumRows("Usuarios") + 1);
            prepStat.setString(2, c.getDni());
            prepStat.setString(3, c.getNombre());
            // execute insert SQL stetement
            prepStat.execute();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    private int getNumRows(String tabla) {
        try {
            //dbConn = DriverManager.getConnection(strUrl);
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from " + tabla);
            rs.next();
            return rs.getInt(1);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return -1;

    }

}
