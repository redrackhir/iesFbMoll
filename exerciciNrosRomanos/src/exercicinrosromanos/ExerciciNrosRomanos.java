/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicinrosromanos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author soib1a20
 */
public class ExerciciNrosRomanos {

    private static Map<Character, Integer> tokens = new HashMap<Character, Integer>();
    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        loadTokens();
        String nro = "";
        boolean exit = false;
        do {
            System.out.print("Entra un nro. romano a convertir (deja en blanco para salir): ");
            nro = sc.nextLine();
            if (nro.length() == 0) {
                exit = true;
            } else {
                System.out.println(getNroRomano(nro));
            }
        } while (!exit);
    }

    private static int getNroRomano(String romano) {
        //Sustituir letras por tokens (toke = valor letra)
        char[] romanChars = romano.toCharArray();
        char letra = ' ';
        char letraAntes = ' ';
        int valorLetra = 0;
        int valorLetraAntes = 0;
        int suma = 0;
        for (int i = 0; i < romano.length(); i++) {
            letraAntes = letra;
            letra = romanChars[i];
            valorLetraAntes = tokens.get(letraAntes);
            valorLetra = tokens.get(letra);
            // para empezar siembre se suma el valor, luego restaremos si hace falta
            suma += valorLetra;

            if (valorLetraAntes < valorLetra) {
                suma -= (valorLetraAntes * 2);
                // restamos 2 veces, una para contrarrestar la suma anterior y otra porque resta
            }
        }
        return suma;
    }

    private static void loadTokens() {
        tokens.put('M', 1000);
        tokens.put('D', 500);
        tokens.put('C', 100);
        tokens.put('L', 50);
        tokens.put('X', 10);
        tokens.put('V', 5);
        tokens.put('I', 1);
        tokens.put(' ', 0);
    }

}
