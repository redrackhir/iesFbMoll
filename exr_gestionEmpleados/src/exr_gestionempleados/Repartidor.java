/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_gestionempleados;

/**
 *
 * @author soib1a20
 */
public class Repartidor extends Empleado {

    private String zona;

    public Repartidor(String nombre, int edad, double salario, String zona) {
        super(nombre, edad, salario);
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public double getPlus() {
        if (this.getEdad() < 25 && this.zona.equalsIgnoreCase("zona 3")) {
            return PLUS;
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "  Repartidor (zona: " + zona + "). Plus: " + this.getPlus();
    }

}
