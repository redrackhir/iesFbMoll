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
public class Cola {

    private Nodo cabeza = null;

    public Cola() {
    }

    public void add(Nodo nodo) {
        Nodo puntero = cabeza;

        if (cabeza == null) {
            cabeza = nodo;
        } else {
            while (puntero.sig != null) {
                puntero = puntero.sig;
            }

            puntero.sig = nodo;
        }
        
        System.out.println("Se ha añadido '" + nodo.info + "'");
    }

    public void recorre() {
        Nodo puntero = cabeza;
        if (puntero == null) {
            System.err.println("Cola vacía!");
        } else {
            System.out.print("Quedan en cola: ");
            do {
                System.out.print("<="+puntero.info);
                puntero = puntero.sig;
            } while (puntero != null);
            System.out.println();
        }
    }

    public void extrae() {
        // Extrae el primero de la cola (FIFO)
        Nodo puntero = cabeza;

        if (cabeza == null) {
            System.err.println("Cola vacía!");
        } else {
            System.out.println("Se ha extraído '" + cabeza.info + "'");
            cabeza = cabeza.sig;
        }
    }
}
