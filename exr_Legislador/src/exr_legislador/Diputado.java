/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_legislador;

/**
 *
 * @author soib1a20
 */
public class Diputado extends Legislador {

    private int asientoCamaraBaja;
    private final String lugarTrabajo = "Cámara Baja";

    public Diputado(int asientoCamaraBaja, String provinciaQueRepresenta, String partidoPolitico, int numeroDespacho) {
        super(provinciaQueRepresenta, partidoPolitico, numeroDespacho);
        this.asientoCamaraBaja = asientoCamaraBaja;
    }

    public Diputado(int asientoCamaraBaja, String provinciaQueRepresenta, String partidoPolitico, int numeroDespacho,
            String nombre, String apellido, int edad, boolean casado) {
        super(provinciaQueRepresenta, partidoPolitico, numeroDespacho, nombre, apellido, edad, casado);
        this.asientoCamaraBaja = asientoCamaraBaja;
    }

    @Override
    public String getCamaraDondeTrabaja() {
        return this.lugarTrabajo;
    }

    public int getAsientoCamaraBaja() {
        return asientoCamaraBaja;
    }

    public void setAsientoCamaraBaja(int asientoCamaraBaja) {
        this.asientoCamaraBaja = asientoCamaraBaja;
    }

    @Override
    public String toString() {
        return "Diputado: " + super.toString() + " " + lugarTrabajo + ", asiento: "
                + asientoCamaraBaja + '.';
    }

}
