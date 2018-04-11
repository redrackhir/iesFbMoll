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

    private Nodo head = null;
    private Nodo last = null;
    private int count = 0;

    public Cola() {
    }

    public void add(Nodo nodo) {
        Nodo puntero = head;

        if (head == null) {
            head = nodo;
            last = nodo;
        } else {
            last.sig = nodo;
            last = nodo;
        }
        count++;
        System.out.println("\tAñadido '" + nodo.info + "'");
    }

    public void recorre() {
        Nodo puntero = head;
        if (puntero == null) {
            System.err.println("Cola vacía!");
        } else {
            System.out.print("En cola: ");
            do {
                System.out.print("<=" + puntero.info);
                puntero = puntero.sig;
            } while (puntero != null);
            System.out.println();
        }
    }

    public Nodo cerca(String info) {
        if (count == 0) {
            System.err.println("Cola vacía!");
            return null;
        }
        Nodo puntero = head;
        while (puntero != null) {
            if (puntero.info.equalsIgnoreCase(info)) {
                return puntero;
            }
            puntero = puntero.sig;
        }
        return null;
    }

    public void extrae() {
        // Extrae el primero de la cola (FIFO)
        Nodo puntero = head;

        if (head == null) {
            System.err.println("Cola vacía!");
        } else {
            System.out.println("\tExtraído '" + head.info + "'");
            head = head.sig;
        }
    }
}
