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
public class CalderaGas implements exerc_calefaccion.model.FuenteCalor {

    private boolean estaEncendido;

    @Override
    public void encender(Habitacion temperatura) {
        temperatura.aumentarTemperatura(0.2f);
        estaEncendido=true;
    }

    @Override
    public void apagar(Habitacion temperatura) {
        temperatura.aumentarTemperatura(-.02f);
        estaEncendido=false;
    }

    @Override
    public boolean isEncendido() {
        return estaEncendido;
    }

    @Override
    public String getNombre() {
        return "Caldera de gas";
    }

}
