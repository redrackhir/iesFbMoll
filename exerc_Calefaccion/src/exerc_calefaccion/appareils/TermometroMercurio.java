/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_calefaccion.appareils;

import exerc_calefaccion.model.Habitacion;

/**
 *
 * @author red rackhir
 */
public class TermometroMercurio implements exerc_calefaccion.model.LectorTemperatura {

    private float temp;

    @Override
    public float leer(Habitacion temp) {
        return temp.getTemperatura();
    }

    @Override
    public String getNombre() {
        return "Termómetro de mercurio";
    }

}
