/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.model;

import java.sql.Date;

/**
 *
 * @author red rackhir
 */
public class Contrato {

    private int id;
    private int refFinca;
    private String refInquilino;
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaFirma;
    private String refDoc;
    private final String[] TIPOS_CONTRATO = {"Temporal", "Indefinido"};
    private String tipoContrato;
    private float precioInicial;
    private final String[] TIPOS_REVISION = {"Mensual", "Trimestral", "Semestral", "Anual"};
    private String tipoRevision;

    public Contrato(int id, int refFinca, String refInquilino, Date fechaInicio, Date fechaFin, Date fechaFirma, 
            String refDoc, String tipoContrato, float precioInicial, String tipoRevision) {
        this.id = id;
        this.refFinca = refFinca;
        this.refInquilino = refInquilino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaFirma = fechaFirma;
        this.refDoc = refDoc;
        this.tipoContrato = tipoContrato;
        this.precioInicial = precioInicial;
        this.tipoRevision = tipoRevision;
    }

    public Contrato() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public int getRefFinca() {
        return refFinca;
    }

    public String getRefInquilino() {
        return refInquilino;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public Date getFechaFirma() {
        return fechaFirma;
    }

    public String getRefDoc() {
        return refDoc;
    }

    public String[] getTIPOS_CONTRATO() {
        return TIPOS_CONTRATO;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public float getPrecioInicial() {
        return precioInicial;
    }

    public String[] getTIPOS_REVISION() {
        return TIPOS_REVISION;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public boolean validate() {
        return true;
    }



}
