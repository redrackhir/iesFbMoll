/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacces;

/**
 *
 * @author soib1a20
 */
public class Usuari {
    
    private static int id;
    private static int count = 0;
    private String nom;
    private boolean isInn;
    
    private static void nouUsuari() {
        count++;
        id = count;
    }
    
    public Usuari(String nom) {
        this.nom = nom;
        nouUsuari();
    }
    
    public String getNom() {
        return nom;
    }
    
}
