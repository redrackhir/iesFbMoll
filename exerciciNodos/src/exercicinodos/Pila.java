/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicinodos;

/**
 *
 * @author soib1a20
 */
public class Pila {

    private Nodo cabeza = null;

    public Pila() {

    }

    public void add(Nodo nodo) {
        if (cabeza == null) {
            cabeza = nodo;
        } else {
            Nodo temp = cabeza;
            cabeza = nodo;
            cabeza.sig=temp;
        }
        System.out.println("Añadido '" + nodo.info + "'");
    }

    public void recorre() {
        Nodo puntero = cabeza;
        if (puntero == null) {
            System.err.println("Pila vacía!");
        } else {
            System.out.print("En la pila estan... \n");
            do {
                System.out.println("\t- " + puntero.info);
                puntero = puntero.sig;
            } while (puntero != null);
            System.out.println();
        }
    }
    
    public void extrae() {
        // Extrae el ultimo de la pila (LIFO)
        
    }

}
