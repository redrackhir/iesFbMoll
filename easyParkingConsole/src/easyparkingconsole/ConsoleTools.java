/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyparkingconsole;

import java.util.Scanner;

/**
 *
 * @author red rackhir
 */
public class ConsoleTools {

    private static Scanner sc = new Scanner(System.in);

    public static void pressAKey() {
        System.out.println("\nPulsa [ENTER] para continuar...");
        sc.nextLine();
    }

    public static void cls() {
        for (int i = 0; i < 80; i++) {
            System.out.println();
        }
    }

}
