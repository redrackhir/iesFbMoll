/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicirecursivitat;

import java.util.Scanner;

/**
 *
 * @author soib1a20
 */
public class ExerciciRecursivitat {
    
    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Calcula factorial de...");
        int num = sc.nextInt();
        
        System.out.println(" = " + String.valueOf(fact(num)));
    }
    
    private static long fact(int x) {
        if (x == 0) {
            System.out.print("1");
            return 1;
        } else {
            System.out.print(x + "*");
            return x * fact(x - 1);
        }
    }
    
}
