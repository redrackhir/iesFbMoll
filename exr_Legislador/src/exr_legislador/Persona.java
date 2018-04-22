/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_legislador;

/**
 *
 * @author soib1a20
 */
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private boolean casado;

    public Persona() {
        nombre = "";
        apellido = "";
        edad = 0;
        casado = false;
    }

    public Persona(String nombre, String apellido, int edad, boolean casado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.casado = casado;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    @Override
    public String toString() {
        String estadoCivil = casado ? "casado" : "soltero";
        return nombre + " " + apellido + ". " + edad + " años, " + estadoCivil + '.';
    }

}
