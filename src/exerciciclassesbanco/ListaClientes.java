/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciclassesbanco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author red rackhir
 */
public class ListaClientes {

    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static Database db = new Database();
    private static Scanner sc = new Scanner(System.in);

    public ListaClientes() {
        loadFromDb();
    }

    public void newCliente(String dni, String nombre) {
        addCliente(dni, nombre);
        Cliente c = new Cliente(dni, nombre);
        db.insertCliente(c);
    }
    
    public void addCliente(String dni, String nombre) {
        // Añade a la lista local
        Cliente c = new Cliente(dni, nombre);
        clientes.add(c);
    }

    public static void listarClientes() {
        clearScreen();
        System.out.println("                  Listado de CLIENTES");
        System.out.println("=========================================================");
        System.out.println(" Id       D.N.I.  Nombre cliente");
        //                  123 123456789012 123456789 123456789 123456789 123456789 
        System.out.println("---------------------------------------------------------");
        Iterator<Cliente> cIt = clientes.iterator();
        int count = 0;
        while (cIt.hasNext()) {
            Cliente c = cIt.next();
            System.out.printf("%3.3s %12.12s %-40s\n",c.getId(),c.getDni(),c.getNombre());
            count++;
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Total: " + count + " clientes.\n");

        pressAKey();
    }

    private void loadFromDb() {
        Database db = new Database();
        db.loadClientesFromDb(this);
    }

    private static void clearScreen() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    private static void pressAKey() {
        System.out.print("\nPulse ENTER para continuar... ");
        sc.nextLine();
    }

}
