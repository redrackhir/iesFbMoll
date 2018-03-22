/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciclassesbanco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author soib1a20
 */
public class ExerciciClassesBanco {

    static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente c1 = new Cliente("25654874J", "Pepito Grillo");
        Cliente c2 = new Cliente("65843216X", "Josefina Bermudez");
        clientes.add(c1);
        clientes.add(c2);

        //listarClientes();
        Cuenta cta1 = new Cuenta(1, 1);
        Cuenta cta2 = new Cuenta(2, 2);

        cuentas.add(cta1);
        cuentas.add(cta2);

        //listarCuentas();
        //System.out.println(cta1.getIdCuenta());
        menuPrincipal();
    }

    private static void imprimirMenu() {
        clearScreen();
        System.out.println("======================================================================================");
        System.out.println("                               MENU PRINCIPAL");
        System.out.println("======================================================================================");
        System.out.println("");
        System.out.println("  1.- Nuevo cliente          5.- Ingreso");
        System.out.println("  2.- Nueva cuenta           6.- Reintegro");
        System.out.println("  3.- Listar clientes");
        System.out.println("  4.- Listar cuentas");
        System.out.println("");
        System.out.println("99.- Salir\n");

    }

    private static void menuPrincipal() {
        boolean exit = false;
        while (!exit) {
            imprimirMenu();

            System.out.print("Escoje opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    addCliente();
                    break;
                case 2:
                    addCuenta();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    listarCuentas();
                    break;
                case 5:
                    ingreso();
                    break;
                case 99:
                    exit = true;
                    break;
            }
            sc.nextLine();
        }
    }

    private static void addCliente() {
        clearScreen();
        System.out.print("D.N.I. cliente: ");
        String dni = sc.next();
        System.out.print("Nombre cliente: ");
        String nombre = sc.next();

        Cliente c = new Cliente(dni, nombre);
        clientes.add(c);

    }

    private static void addCuenta() {
        clearScreen();

        System.out.print("Oficina: ");
        int oficina = sc.nextInt();
        System.out.print("código cuenta: ");
        int cc = sc.nextInt();
        System.out.print("ID de cliente: ");
        int idCliente = sc.nextInt();

        Cuenta c = new Cuenta(cc, idCliente);

        cuentas.add(c);
    }

    private static void listarClientes() {
        clearScreen();
        System.out.println("                              Listado de CLIENTES");
        System.out.println("======================================================================================");
        Iterator<Cliente> clientesIt = clientes.iterator();
        while (clientesIt.hasNext()) {
            System.out.println(clientesIt.next().toString());
        }
        pressAKey();
    }

    private static void listarCuentas() {
        System.out.println("                               Listado de CUENTAS");
        System.out.println("======================================================================================");
        Iterator<Cuenta> cuentasIt = cuentas.iterator();
        while (cuentasIt.hasNext()) {
            System.out.println(cuentasIt.next().toString());
        }
        pressAKey();
    }

    private static void ingreso() {
        clearScreen();
        System.out.println("*** INGRESO EN EFECTIVO ***");
        System.out.print("Nro. de cuenta: ");
        int nroCta = sc.nextInt();

        // Buscar la cuenta descrita para hacer el ingreso
        int idx = getCtaIndex(nroCta);

        if (idx > -1) {
            System.out.print("Cantidad a ingresar: ");
            double cant = sc.nextDouble();
            System.out.println("Cta.: " + cuentas.get(idx).getCodigoCuentaCompleto());
            System.out.println("Saldo anterior: " + cuentas.get(idx).getSaldo());
            cuentas.get(idx).ingreso(cant);
            
          
            
            System.out.println("Saldo actual..: " + cuentas.get(idx).getSaldo());
        } else {
            System.out.print("La Cuenta '" + nroCta + "' no existe!!!\n");
        }
        pressAKey();
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

    private static int getCtaIndex(int nroCta) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getCodigoCuenta() == nroCta) {
                return i;
            }
        }
        return -1;
    }

}
