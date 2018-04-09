/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.soib.escola.persones;

/**
 *
 * @author soib1a20
 */
public class Professor extends Persona {

    private String especialitat;

    /**
     * Get the value of especialitat
     *
     * @return the value of especialitat
     */
    public String getEspecialitat() {
        return especialitat;
    }

    /**
     * Set the value of especialitat
     *
     * @param especialitat new value of especialitat
     */
    public void setEspecialitat(String especialitat) {
        this.especialitat = especialitat;
    }

    public Professor(String nom, String llinatges, String dataNeixement) {
        super(nom, llinatges, dataNeixement);
    }

    public Professor(String nom, String llinatges, String dataNeixement, String especialitat) {
        super(nom, llinatges, dataNeixement);
        this.especialitat = especialitat;
    }

    @Override
    public String toString() {
        return "Professor: " + super.toString() + ". Especialitat: " + especialitat;
    }

}
