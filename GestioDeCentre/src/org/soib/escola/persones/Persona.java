/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.soib.escola.persones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soib1a20
 */
public class Persona {

    String nom;
    private String llinatges;
    private Date dataNeixement;

    public Persona(String nom, String llinatges, String dataNeixement) {
        this.nom = nom;
        this.llinatges = llinatges;
        this.dataNeixement = strToDate(dataNeixement);
    }

    public String getNom() {
        return nom;
    }

    public String getLlinatges() {
        return llinatges;
    }

    public Date getDataNeixement() {
        return dataNeixement;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    public void setDataNeixement(String dataNeixement) {
        this.dataNeixement = strToDate(dataNeixement);
    }

    @Override
    public String toString() {
        return llinatges + ", " + nom + ". Data neixem.: " + dateToStr(dataNeixement);
    }

    private String dateToStr(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    private Date strToDate(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Fecha incorrecta. El formato debe ser dd/mm/aaaa");
        }
        return null;
    }

}
