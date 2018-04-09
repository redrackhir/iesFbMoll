/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.soib.escola.persones;

import java.util.Date;

/**
 *
 * @author soib1a20
 */
public class Alumne extends Persona {

    private String curs;

    public Alumne(String nom, String llinatges, String dataNeixement) {
        super(nom, llinatges, dataNeixement);
    }

    public Alumne(String nom, String llinatges, String dataNeixement, String curs) {
        super(nom, llinatges, dataNeixement);
        this.curs = curs;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    @Override
    public String toString() {
        return "Alumne: "+super.toString() + ". Curs: " + curs;
    }

}
