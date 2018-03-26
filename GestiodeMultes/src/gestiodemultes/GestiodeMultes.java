/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiodemultes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Dual
 */
public class GestiodeMultes {

    private static Scanner sc = new Scanner(System.in).useDelimiter(" |\r\n");
    private static final VehicleRegister registre = new VehicleRegister();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean exit = false;
        char opcion = ' ';
        // TODO code application logic here
        do {
            printMenu();

            opcion = sc.nextLine().charAt(0);

            switch (opcion) {
                case '1':
                    entrada();
                    break;
                case '2':
                    salida();
                    break;
                case '3':
                    listado();
                    break;
                case 'x':
                case 'X':
                    exit = true;
            }
        } while (!exit);
    }

    private static void printMenu() {
        clearScreen();
        System.out.println("******** MENU ********\n");
        System.out.println("1.- Foto de entrada");
        System.out.println("2.- Foto de salida");
        System.out.println("3.- Listar registro\n");
        System.out.println("X.- Salir\n");
        System.out.println("---------------------------");
        System.out.print("Escoja opción: ");
    }

    private static void entrada() {
        clearScreen();
        System.out.println("Formato de entrada: <matricula> <hh.mm> <km.>");
        System.out.print("_>");
        while (!sc.hasNext()) {
        }

        String matr = "";
        double hora = 0;
        double km = 0;
        matr = sc.next().toUpperCase();
        hora = Double.parseDouble(sc.next());
        km = Double.parseDouble(sc.nextLine());

        registre.entrada(matr, hora, km);
    }

    public static void salida() {
        clearScreen();
        System.out.println("Formato: <matricula> <hh.mm> <km.>");
        System.out.print("_>");
        while (!sc.hasNext()) {
        }

        String matr = "";
        double hora = 0;
        double km = 0;
        matr = sc.next().toUpperCase();
        hora = Double.parseDouble(sc.next());
        km = Double.parseDouble(sc.nextLine());
        registre.salida(matr, hora, km);
    }

    private static void listado() {
        clearScreen();
        System.out.println("\nMatrícula - Hora  - Km.  - E/S");
        System.out.println("--------------------------------");
        System.out.println(registre.toString());
        pressAKey();
    }

    private static void clearScreen() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    public static void pressAKey() {
        System.out.print("\nPulse ENTER para continuar... ");
        sc.nextLine();
    }

}
