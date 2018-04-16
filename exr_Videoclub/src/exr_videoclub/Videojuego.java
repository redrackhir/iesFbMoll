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
public class Videojuego implements Entregable {

    private String titulo;
    private String genero;
    private String companyia;
    private int horas = 10;
    private boolean entregado = false;

    public Videojuego() {
    }

    public Videojuego(String titulo, int horas) {
        this.titulo = titulo;
        this.horas = horas;
    }

    public Videojuego(String titulo, String genero, String companyia, int horas) {
        this.titulo = titulo;
        this.genero = genero;
        this.companyia = companyia;
        this.horas = horas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompanyia() {
        return companyia;
    }

    public void setCompanyia(String companyia) {
        this.companyia = companyia;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        String frmt = "Videojuego  %-30s %-20s %-20s %2d  %2s";

        return String.format(frmt, titulo, genero, companyia, horas, entregado ? "SI":"NO");
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
    public void compareTo(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
