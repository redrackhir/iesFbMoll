/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.model;

/**
 *
 * @author red rackhir
 */
public class Cliente {

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String domicilio;
    private String telf1;
    private String telf2;
    private String email;
    private String comentarios;
    private double saldo = 0;
    private String poblacion;
    private int cp;

    public Cliente(String dni, String nombre, String apellido1) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
    }

    public Cliente(String dni, String nombre, String apellido1, String apellido2,
            String domicilio, String telf1, String telf2, String email, String comentarios,
            String poblacion, int cp, double saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.domicilio = domicilio;
        this.telf1 = telf1;
        this.telf2 = telf2;
        this.email = email;
        this.comentarios = comentarios;
        this.poblacion = poblacion;
        this.cp = cp;
        this.saldo = saldo;
    }

    public Cliente() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getTelf1() {
        return telf1;
    }

    public String getTelf2() {
        return telf2;
    }

    public String getEmail() {
        return email;
    }

    public String getComentarios() {
        return comentarios;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setTelf1(String telf1) {
        this.telf1 = telf1;
    }

    public void setTelf2(String telf2) {
        this.telf2 = telf2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getPoblacion() {
        return this.poblacion;
    }

    public int getCP() {
        return this.cp;
    }

    public boolean validate() {
        // Validar datos correctos
        if (dni == null || dni.length() != 9) {
            return false;
        }
        if (nombre.length() == 0) {
            return false;
        }
        if (apellido1.length() == 0) {
            return false;
        }

        return true;
    }

}
