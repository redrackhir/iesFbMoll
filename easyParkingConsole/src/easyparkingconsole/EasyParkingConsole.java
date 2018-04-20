/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyparkingconsole;

import static easyparkingconsole.Ansi_Colours.ANSI_RESET;
import static easyparkingconsole.ConsoleTools.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author red rackhir
 */
public class EasyParkingConsole {

    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Plaza> plazas = new ArrayList<>();
    private static Parque parking = new Parque();
    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Cargamos los datos desde el disco
        parking.loadData();

        // Menu principal
        String option = "";
        boolean salir = false;

        while (!salir) {
            menuPrincipal();
            option = sc.nextLine();
            switch (option.toLowerCase()) {
                case "1":
                    entraVehiculo();
                    break;
                case "2":
                    saleVehiculo();
                    break;
                case "3":
                    estadoParque();
                    break;
                case "a":
                    parking.printRegistro();
                    break;
                case "b":
                    mapaPlazas(10);
                    break;
                case "x":
                    salir = true;
            }
            if (!salir) {
                pressAKey();
            }
        }
    }

    private static void mapaPlazas(int nroColumnas) {
        // Leyenda
        cls();
        System.out.println("- Mapa del parking: PLANTA #1  (Leyenda)");
        System.out.print(Plaza.getColorLibre() + " Libre ");
        System.out.print(Plaza.getColorOcupada() + " Ocupada ");
        System.out.print(Plaza.getColorReservada() + " Reservada ");
        System.out.println(Plaza.getColorIndisponible() + " Indisponible " + ANSI_RESET);
        System.out.println("");

        int col = 0;
        for (Iterator<Plaza> it = plazas.iterator(); it.hasNext();) {
            col++;
            if (col > nroColumnas) {
                col = 1;
                System.out.println();
            }
            Plaza p = it.next();
            p.printGraphicState();
        }
        System.out.println();

    }

    private static EstadosPlaza getRandomState() {
        return EstadosPlaza.values()[(int) (Math.random() * 4)];
    }

    private static void menuPrincipal() {
        cls();
        System.out.println("*********************************************************************");
        System.out.println("**                  M E N U    P R I N C I P A L                   **");
        System.out.println("*********************************************************************");
        System.out.println();
        System.out.println("    1.- Entrada vehículo                        A.- Registro");
        System.out.println("    2.- Salida vehículo                         B.- Mapa parque");
        System.out.println("    3.- Estado parking                          B.- Mapa parque");
        System.out.println();
        System.out.print("Pulsa opción + [ENTER]: ");
    }

    private static void entraVehiculo() {
        cls();
        System.out.println("*** ENTRADA VEHICULO ***");
        System.out.print("Entra matrícula: ");
        String matricula = sc.nextLine();

        parking.vehicleEnter(matricula);
    }

    private static void saleVehiculo() {
        cls();
        System.out.println("*** SALIDA VEHICULO ***");
        System.out.print("Entra matrícula: ");
        String matricula = sc.nextLine();

        parking.vehicleLeave(matricula);
    }

    private static void estadoParque() {
        parking.printStatus();
    }
}
