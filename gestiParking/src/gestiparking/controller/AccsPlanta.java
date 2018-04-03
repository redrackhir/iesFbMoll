/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiparking.controller;

import gestiparking.model.Planta;
import gestiparking.view.FrmPlanta;
import java.io.Serializable;

/**
 * La planta gestiona la capaciad de la misma y el estado de las plazas.
 * 
 * @author red rackhir
 */
public class AccsPlanta implements Serializable {

    private FrmPlanta frame;
    private final Planta planta;
    private int nivel;

    public AccsPlanta(FrmPlanta frame, int nivel, int capacidad) {
        this.frame = frame;
        this.nivel = nivel;
         planta = new Planta(nivel, capacidad);
        planta.loadData();
    }

    public int getNivel() {
        return nivel;
    }

    public int getCapacidad() {
        return planta.getCapacidad();
    }

}
