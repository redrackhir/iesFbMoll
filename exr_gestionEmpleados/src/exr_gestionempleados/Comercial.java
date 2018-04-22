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
public class Comercial extends Empleado implements java.io.Serializable {

    private double comision;

    /**
     *
     */
    public Comercial() {
    }

    public Comercial(String nombre, int edad, double salario, double comision) {
        super(nombre, edad, salario);
        this.comision = comision;
    }

    public double getPlus() {
        if (this.getEdad() > 30 && this.comision > 200) {
            return this.PLUS;
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "  Comercial (comision: " + comision + "€). Plus: " + this.getPlus();
    }

    void setComision(int value) {
        this.comision = value;
    }

}
