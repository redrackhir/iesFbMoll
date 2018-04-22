/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciexprregulars;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author soib1a20
 */
public class ExerciciExprRegulars {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // matchDni();
        // matchNie();
        // matchIban();
        matchMatricula();
    }

    private static void matchDni() {
        System.out.print("Entra un DNI:");
        String dni = sc.nextLine();

        Pattern pat = Pattern.compile("[0-9]{8}[a-zA-Z]");
        Matcher mat = pat.matcher(dni);

        if (mat.matches()) {
            System.out.println("DNI con formato correcto.");
        } else {
            System.err.println("Formato incorrecto!!!");
        }
    }

    private static void matchNie() {
        System.out.print("Entra un NIE:");
        String nie = sc.nextLine();

        Pattern pat = Pattern.compile("[xXyYzZ][0-9]{7}[a-zA-Z]");
        Matcher mat = pat.matcher(nie);

        if (mat.matches()) {
            System.out.println("NIE con formato correcto.");
        } else {
            System.err.println("Formato incorrecto!!!");
        }
    }

    private static void matchIban() {
        System.out.print("Entra un nro. de cuenta IBAN:");
        String iban = sc.nextLine();

        Pattern pat = Pattern.compile("[A-Z][0-9]{22}");
        Matcher mat = pat.matcher(iban);

        if (mat.matches()) {
            System.out.println("IBAN con formato correcto.");
        } else {
            System.err.println("Formato incorrecto!!!");
        }
    }

    private static void matchMatricula() {
        System.out.print("Entra un nro. de MATRICULA:");
        String matricula = sc.nextLine().toUpperCase();
        

        String antigua ="[A-Z]{1,2}[0-9]{4}[A-Z]{1,2}";
        String nueva ="[0-9]{4}[A-Z]{3}";

        if (matricula.matches(antigua)) {
            System.out.println("Matrícula '" + matricula + "' con formato antiguo correcto.");
        } else if (matricula.matches(nueva)) {
            System.out.println("Matrícula '" + matricula + "' con formato actual correcto.");
        } else {
            System.err.println("Formato incorrecto!!!");
        }
    }

}
