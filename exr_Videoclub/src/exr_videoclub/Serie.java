/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_videoclub;

/**
 *
 * @author soib1a20
 */
public class Serie implements Entregable {

    String titulo;
    int temporada;
    boolean entregado;
    String genero;
    String creador;

    public Serie() {
    }

    public Serie(String titulo, String creador) {
        this.titulo = titulo;
        this.creador = creador;
    }

    public Serie(String titulo, int temporada, String genero, String creador) {
        this.titulo = titulo;
        this.temporada = temporada;
        this.genero = genero;
        this.creador = creador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
    public String toString() {
        //                             123456789 123456789 123456789 123456789 123456789 123456789 123456789 
        String frmt = "Serie       %-30s %-20s %-20s %2d  %2s";
        return String.format(frmt, titulo, genero, creador, temporada, entregado ? "SI":"NO");
    }

    @Override
    public void entregar() {
        entregado = true;
    }

    @Override
    public void devolver() {
        entregado = false;
    }

    @Override
    public boolean isEntregado() {
        return entregado;
    }

    @Override
    public void compareTo(Object obj
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

}
