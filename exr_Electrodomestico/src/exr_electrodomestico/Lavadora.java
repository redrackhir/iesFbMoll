/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_electrodomestico;

/**
 *
 * @author soib1a20
 */
public class Lavadora extends Electrodomestico {

    private int carga = 5;

    public Lavadora(String marca, String modelo) {
        super(marca, modelo);
    }

    public Lavadora(double precioBase, int peso) {
        super(precioBase, peso);
        adjustPrice();
    }

    public Lavadora(double precioBase, int peso, String color, String eficiencia, int carga) {
        super(precioBase, peso, color, eficiencia);
        this.carga = carga;
        adjustPrice();
    }
    
    

    public int getCarga() {
        return carga;
    }

    private void adjustPrice() {
        if (carga > 30) {
            this.precioFinal += 50;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Lavadora {" + "capacidad: " + carga + "Kg.}";
    }

}
