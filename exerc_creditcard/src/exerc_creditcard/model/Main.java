/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_creditcard.model;

import exerc_creditcard.view.Cajero;

/**
 *
 * @author soib1a20
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TargetaCredit t = new TargetaCredit(new int[]{1,2,3,4}, 0f);
        
        Cajero cajero = new Cajero("Cajero #1");
        cajero.setVisible(true);
        
    }
    
    private static void menu0() {
        Tools.clearScreen();
        System.out.println("**********************************************************");
        System.out.println("***        C A J E R O     A U T O M A T I C O         ***");
        System.out.println("**********************************************************");
        System.out.println("1.- Introduzca targeta");
        Tools.pressAKey();
    }
    
    private static void menu1() {
        Tools.clearScreen();
        System.out.println("**********************************************************");
        System.out.println("***        C A J E R O     A U T O M A T I C O         ***");
        System.out.println("**********************************************************");
        System.out.println("1.- Ver saldo");
        System.out.println("2.- Cambiar PIN");
        System.out.println("3.- Reintegro");
        Tools.pressAKey();
    }
    
}
