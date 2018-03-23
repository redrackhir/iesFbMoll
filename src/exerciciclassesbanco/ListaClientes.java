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

    private static Scanner sc = new Scanner(System.in);

    public ListaClientes() {
        
    }
    
    public void addCliente(String dni, String nombre) {
        clientes.add(new Cliente(dni, nombre));
    }

    public static void listarClientes() {
        clearScreen();
        System.out.println("                              Listado de CLIENTES");
        System.out.println("======================================================================================");
        Iterator<Cliente> clientesIt = clientes.iterator();
        while (clientesIt.hasNext()) {
            System.out.println(clientesIt.next().toString());
        }
        pressAKey();
    }
    
    public void loadFromDb() {
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
