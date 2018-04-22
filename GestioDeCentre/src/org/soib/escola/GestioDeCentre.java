/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.soib.escola;

import org.soib.escola.persones.Professor;
import java.util.ArrayList;
import org.soib.escola.persones.Alumne;
import org.soib.escola.persones.Persona;

/**
 *
 * @author soib1a20
 */
public class GestioDeCentre {

    private static ArrayList<Alumne> alumnes = new ArrayList<>();
    private static ArrayList<Professor> professors = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        introduirDades();

        imprimir(alumnes.get(0));

        mostrarDades();

    }

    public static void introduirDades() {
        // Afegim alumnes
        alumnes.add(new Alumne("Jordi", "Reverté", "25/4/1974", "Programació JAVA"));
        alumnes.add(new Alumne("Manuel", "Pérez", "26/8/1986","Programació Android"));
        alumnes.add(new Alumne("Jesús", "Quintilla", "12/3/1994","Programació HTML5 + CSS3"));

        // Afegim professors
        professors.add(new Professor("Guillem", "Salom", "5/8/1974", "Java"));
        professors.add(new Professor("David", "Gelpi", "1/1/1974", "Metodologías ágiles"));
        professors.add(new Professor("Macià", "Mut Puigserver", "30/2/1983", "Programación Android"));
    }

    private static void imprimir(Persona p) {
        System.out.println("\n*** Imprimir objeto Persona ***");
        System.out.println(p.toString());
    }

    public static void mostrarDades() {
        llistarAlumnes();
        llistarProfessors();
    }

    private static void llistarAlumnes() {
        System.out.println("\n*** Imprimir llistat Alumnes ***");
        for (Alumne a : alumnes) {
            System.out.println(a.toString());
        }
    }

    private static void llistarProfessors() {
        System.out.println("\n*** Imprimir llistat Professors ***");
        for (Professor p : professors) {
            System.out.println(p.toString());
        }
    }

}
