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
public class Senador extends Legislador {

    private int asientoCamaraAlta;
    private final String lugarTrabajo = "Cámara Alta";

    public Senador(int asientoCamaraAlta, String provinciaQueRepresenta, String partidoPolitico, int numeroDespacho) {
        super(provinciaQueRepresenta, partidoPolitico, numeroDespacho);
        this.asientoCamaraAlta = asientoCamaraAlta;
    }

    public Senador(int asientoCamaraAlta, String provinciaQueRepresenta, String partidoPolitico, int numeroDespacho, String nombre, String apellido, int edad, boolean casado) {
        super(provinciaQueRepresenta, partidoPolitico, numeroDespacho, nombre, apellido, edad, casado);
        this.asientoCamaraAlta = asientoCamaraAlta;
    }

    @Override
    public String getCamaraDondeTrabaja() {
        return this.lugarTrabajo;
    }

    @Override
    public String toString() {
        return "Senador: " + super.toString() + " " + lugarTrabajo + ", asiento: "+ asientoCamaraAlta + '.';
    }
    
    

}
