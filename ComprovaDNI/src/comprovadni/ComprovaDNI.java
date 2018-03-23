/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comprovadni;

/**
 *
 * @author soib1a20
 */
public class ComprovaDNI {

    /**
     * Comprova la lletra del DNI/NIE
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DniNie doc1 = new DniNie("52608028j");
        System.out.println(doc1.getNif());
    }
    
}
