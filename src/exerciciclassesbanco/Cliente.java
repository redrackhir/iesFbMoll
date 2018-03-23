package exerciciclassesbanco;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author soib1a20
 */
public class Cliente {

    public static int nroClientes;
    private int id;
    private String dni;
    private String nombre;
    private int edad;
    private char sexo = '?';
    private String ctaAsociada;

    static int getNewId() {
        return nroClientes + 1;
    }

    static void nuevoCliente() {
        nroClientes++;
    }

    public Cliente(String dni, String nombre) {
        this.id = getNewId();
        this.dni = dni;
        this.nombre = nombre;
        nuevoCliente();
    }

    public Cliente(String dni, String nombre, int edad, char sexo) {
        this(dni, nombre);
        this.edad = edad;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Id: [" + id + "] - " + nombre + ", DNI: " + dni + ", edad: "
                + edad + ", sexo: " + sexo + ", cta. asociada: " + ctaAsociada;
    }

}
