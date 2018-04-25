/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_targetacredit;

import java.util.Scanner;

/**
 *
 * @author soib1a20
 */
public class Tools {

    private static Scanner sc = new Scanner(System.in);

    public static void clearScreen() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    public static void pressAKey() {
        System.out.print("\nPulse ENTER para continuar... ");
        sc.nextLine();
    }

    static double getInputNumber() {
        return Double.valueOf(sc.nextLine());
    }

    static String getText() {
        return sc.nextLine();
    }

}
