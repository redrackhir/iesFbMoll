/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicinodos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soib1a20
 */
public class ExerciciNodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cola cola = new Cola();

        cola.add(new Nodo("Primero"));
        cola.add(new Nodo("Segundo"));
        cola.add(new Nodo("Tercero"));

        cola.recorre();

        cola.add(new Nodo("Cuarto"));

        cola.extrae();

        cola.recorre();

        cola.add(new Nodo("Quinto"));

        cola.extrae();
        cola.extrae();
        cola.extrae();
        cola.extrae();

        long endTime = System.currentTimeMillis() + 100;
        do {
        } while (endTime > System.currentTimeMillis());
        
        cola.recorre();
    }

}