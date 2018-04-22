/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_electrodomestico;

import java.util.ArrayList;

/**
 *
 * @author soib1a20
 */
public class Main {

    private static ArrayList<Electrodomestico> stock = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        stock.add(new Lavadora("LG", "L6000",150.0,40,"BLANCO","B",25 ));
        stock.add(new Electrodomestico(235.45, 30, "AZUL", "D"));
        stock.add(new Electrodomestico(100, 15, "ROJO", "E"));
        stock.add(new Lavadora(100, 15, "NEGRO", "E", 31));
        
        mostrarTodo();
    }
    
    public static void mostrarTodo(){
        for (Electrodomestico e: stock){
            System.out.println(e.toString());
        }
    }

}
