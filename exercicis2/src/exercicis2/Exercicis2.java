/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicis2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author soib1a20
 */
public class Exercicis2 {

    private Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //isNroPerfecte(14);
        isAnnoBisiesto(1976);
    }

    private static void isNroPerfecte(int nro) {
        /* 1.- En la teoria dels nombres, es considera "perfecte" a aquells nombres naturals que són
iguals que la suma dels seus divisors. Per exemple, 6 = 1 + 2 + 3 és un nombre natural
perfecte. Escriure un mètode que determini si un nombre enter és un natural perfecte.
El mètode retornarà true quan el nombre sigui perfecte, false en cas contrari.
I si el nombre no és natural escriurà “El nombre no és major igual que zero” */
        // Averiguar nros divisores
        ArrayList<Integer> divisores = new ArrayList<>();

        for (int i = nro - 1; i > 0; i--) {
            if (nro % i == 0) {
                divisores.add(i);
                System.out.println("Divisible por " + i);
            }
        }
        // Sumar los divisores a ver si dan el mismo nro
        int suma = 0;
        String plus = "";
        for (int n : divisores) {
            if (suma > 0) {
                plus = " + ";
            }
            System.out.print(plus + n);
            suma += n;
        }
        System.out.println(" = " + suma);
        //return suma == nro;
        String modificador = "";
        if (suma != nro) {
            modificador = " NO";
        }
        System.out.println("El nro. '" + nro + "'" + modificador + " es un nro. perfecto!");
    }

    private static void isAnnoBisiesto(int anno) {
        // Es bisiesto si es divisible entre 100 y 400
        boolean isBisest = false;
        if (anno % 400 == 0) {
            isBisest = true;
        }
        if (!isBisest && (anno % 4 == 0 && anno % 100 != 0)) {
            isBisest = true;
        }
        String modif = isBisest ? " SI" : " NO";
        System.out.println("El año del señor de '" + anno + "'" + modif + " fue bisiesto!");
    }
}
