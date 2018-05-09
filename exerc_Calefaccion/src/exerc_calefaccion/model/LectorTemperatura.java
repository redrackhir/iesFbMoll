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
public interface LectorTemperatura {

    public float leer(Habitacion temp);
    
    public String getNombre();
}
