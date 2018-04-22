/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_legislador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author soib1a20
 */
public class Main {

    private static ArrayList<Persona> lacosanostra = new ArrayList<>();

    ;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        lacosanostra.add(new Diputado(25, "Madrid", "PP", 1, "José Luis", "Ábalos Meco", 52, true));
        lacosanostra.add(new Senador(12, "Barceloma", "Podemos", 1, "Joan", "Comorera Estadellas", 34, true));
        lacosanostra.add(new Diputado(26, "Madrid", "Podemos", 1, "Íñigo", "Errejón Galván", 28, false));
        lacosanostra.add(new Senador(13, "Barceloma", "Podemos", 1, "María", "Freixanet Mateo", 41, true));

        mostrarTodos();
        // System.out.println(exercici(new String[]{"NORTH", "SOUTH", "NORTH", "EAST", "WEST", "EAST"}));
    }

    public static void mostrarTodos() {
        for (Persona p : lacosanostra) {
            System.out.println(p.toString());
        }
    }

    public static String exercici(String[] dir) {
        ArrayList<String> dirs = new ArrayList<>(Arrays.asList(dir));
        int y = Collections.frequency(dirs, "SOUTH") - Collections.frequency(dirs, "NORTH");
        int x = Collections.frequency(dirs, "EAST") - Collections.frequency(dirs, "WEST");

        String str = new String(new char[Math.abs(y)]).replace("\0", y > 0 ? "SOUTH" : "NORTH");
        str += x == 0 ? "" : ",";
        str += new String(new char[Math.abs(x)]).replace("\0", x > 0 ? "EAST" : "WEST");

        return str;
    }

}
