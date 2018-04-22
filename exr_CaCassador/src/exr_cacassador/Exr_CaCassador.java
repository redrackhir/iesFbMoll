/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_cacassador;

import java.util.ArrayList;

/**
 *
 * @author soib1a20
 */
public class Exr_CaCassador {

    private static ArrayList<Ca> cans = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ca ca1 = new Ca("Frosty",2);
        ca1.setGenere(Genere.MASCLE);
        Ca ca2 = new Ca("Betsy",2);
        ca2.setGenere(Genere.FEMELLA);
        cans.add(ca1);
        
        mostraCans();
        
        cans.add(ca2);
        
        mostraCans();

        ca1.aparella(ca2);
        
        mostraCans();
        
        cans.addAll(ca2.teCries());
    }
    
    private static void mostraCans() {
        for (Ca ca: cans) {
            System.out.println(ca);
        }
    }
    
}
