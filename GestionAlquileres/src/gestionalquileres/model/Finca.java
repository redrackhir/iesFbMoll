/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.model;

/**
 *
 * @author red rackhir
 */
public class Finca {

    private int id;
    private String nombre;
    private String tipo;
    private String ubicacion;
    private String refCatastral;
    private String refPropietario;
    private String comentarios;
    private final String DELIMITER = ";;";

    public Finca(int id, String nombre, String tipo, String ubicacion,
            String refCatastral, String refPropietario, String comentarios) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.refCatastral = refCatastral;
        this.refPropietario = refPropietario;
        this.comentarios = comentarios;
    }

    public Finca() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getRefCatastral() {
        return refCatastral;
    }

    public String getRefPropietario() {
        return refPropietario;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String[] getValuesForInsertDb() {
        String retVal = "'" + nombre + "'" + DELIMITER
                + "'" + tipo + "'" + DELIMITER
                + "'" + ubicacion + "'" + DELIMITER
                + "'" + refCatastral + "'" + DELIMITER
                + "'" + refPropietario + "'" + DELIMITER
                + "'" + comentarios + "'";
        return retVal.split(DELIMITER);
    }

    public String[] getValuesForUpdateDb() {
        String retVal = "'" + nombre + "'" + DELIMITER
                + "'" + tipo + "'" + DELIMITER
                + "'" + ubicacion + "'" + DELIMITER
                + "'" + refCatastral + "'" + DELIMITER
                + "'" + refPropietario + "'" + DELIMITER
                + "'" + comentarios + "'";
        return retVal.split(DELIMITER);
    }

    public boolean validate() {

        return true;
    }

}
