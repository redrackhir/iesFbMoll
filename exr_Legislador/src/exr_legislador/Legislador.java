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
public abstract class Legislador extends Persona {

    private String provinciaQueRepresenta;
    private String partidoPolitico;
    private int numeroDespacho;

    public Legislador(String provinciaQueRepresenta, String partidoPolitico, int numeroDespacho) {
        this.provinciaQueRepresenta = provinciaQueRepresenta;
        this.partidoPolitico = partidoPolitico;
        this.numeroDespacho = numeroDespacho;
    }

    public Legislador(String provinciaQueRepresenta, String partidoPolitico, int numeroDespacho,
             String nombre, String apellido, int edad, boolean casado) {
        super(nombre, apellido, edad, casado);
        this.provinciaQueRepresenta = provinciaQueRepresenta;
        this.partidoPolitico = partidoPolitico;
        this.numeroDespacho = numeroDespacho;
    }

    public abstract String getCamaraDondeTrabaja();

    @Override
    public String toString() {
        return super.toString() + " Por " + provinciaQueRepresenta + ", Partido: "
                + partidoPolitico + ", Despacho: " + numeroDespacho;
    }

}
