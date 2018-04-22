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
public class Televisor extends Electrodomestico {

    private int resolucion = 20;
    private boolean tdt = false;

    public Televisor(String marca, String modelo) {
        super(marca, modelo);
    }

    public Televisor(double precioBase, int peso) {
        super(precioBase, peso);
    }

    public Televisor(double precioBase, int peso, String color, String eficiencia, int resolucion, boolean tdt) {
        super(precioBase, peso, color, eficiencia);
        this.resolucion = resolucion;
        this.tdt = tdt;
    }

    public int getResolucion() {
        return resolucion;
    }

    public boolean isTdt() {
        return tdt;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    private void adjustPrice() {
        /* precioFinal(): si tiene una resolución mayor de 40 pulgadas, se
           incrementara el precio un 30% y si tiene un sintonizador TDT
           incorporado, aumentara 50 €. */
        if (resolucion > 40) {
            precioFinal += (precioFinal * 0.3);
        }
        if (tdt) {
            precioFinal += 50;
        }
    }

}
