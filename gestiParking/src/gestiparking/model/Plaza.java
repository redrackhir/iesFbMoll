/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiparking.model;

/**
 *
 * @author red rackhir
 */
public class Plaza {

    private int id;
    private EstadosPlaza estado = EstadosPlaza.LIBRE;

    public Plaza(int id) {
        this.id = id;
    }

    public Plaza(int id, EstadosPlaza estado) {
        this.id = id;
        this.estado = estado;
    }

    public EstadosPlaza getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

}
