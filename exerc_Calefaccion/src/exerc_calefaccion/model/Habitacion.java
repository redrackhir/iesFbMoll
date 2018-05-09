/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_calefaccion.model;

/**
 *
 * @author red rackhir
 */
public class Habitacion {

    private String nombre;
    private float temperatura = 15;

    public Habitacion(String nombre) {
        this.nombre = nombre;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public void aumentarTemperatura(float incremento) {
        this.temperatura += incremento;
    }

    public String getNombre() {
        return nombre;
    }

}
