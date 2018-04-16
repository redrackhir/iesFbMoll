/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_gestionempleados;

import java.util.ArrayList;

/**
 *
 * @author soib1a20
 */
public class GestionEmpleados {

    private static ArrayList<Empleado> empleados = new ArrayList<>();

    public static void printMenu() {
        Tools.clearScreen();
        System.out.println("==================================================");
        System.out.println("|        G E S T I O N   E M P L E A D O S       |");
        System.out.println("==================================================\n");
        System.out.println("1.- Altas");
        System.out.println("2.- Modificaciones");
        System.out.println("3.- Listado");
        System.out.println("4.- Bajas\n");
        System.out.println("0.- Volver atrás");
        System.out.println("--------------------------------------------------");
        System.out.print("Escoja opción: ");
    }

    public static void start() {
        String opt = "";
        do {
            printMenu();
            opt = Tools.getText();
            switch (opt) {
                case "1":
                    newEntry();
                    break;
                case "2":
                    modifEntry();
                    break;
                case "3":
                    listEmployees();
                    break;
                case "4":
                    delEntry();
                    break;
            }
        } while (!opt.equalsIgnoreCase("0"));
    }

    public static void saveEntries() {
        RWObjectsFile.save("empleados.ser", empleados);
    }

    public static void loadEntries() {
        empleados = (ArrayList<Empleado>) RWObjectsFile.load("empleados.ser");
    }

    private static void newEntry() {
        Tools.clearScreen();
        String nombre, zona;
        double salario, comision;
        int edad;
        Empleado newEmployee;

        System.out.println("*** NUEVO EMPLEADO ***");
        System.out.println("----------------------");
        System.out.print("'C'omercial o 'R'epartidor?.....: ");
        String comRep = Tools.getText();
        comRep = comRep.substring(0, 1).toUpperCase();
        System.out.print("Nombre.........: ");
        nombre = Tools.getText();
        System.out.print("Edad...........: ");
        edad = (int) Tools.getInputNumber();
        System.out.print("Salario........: ");
        salario = Tools.getInputNumber();
        if (comRep.equalsIgnoreCase("C")) {
            System.out.print("Comision........: ");
            comision = Tools.getInputNumber();
            newEmployee = new Comercial(nombre, edad, salario, comision);
        } else {
            System.out.print("Zona............: ");
            zona = Tools.getText();
            newEmployee = new Repartidor(nombre, edad, salario, zona);
        }

        empleados.add(newEmployee);

        saveEntries();

    }

    private static void modEntry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void delEntry() {
        listSmall();
        System.out.print("Entre el nro. de empleado a eliminar: ");
        int id = (int) Tools.getInputNumber();
        if (employeeExists(id)) {
            Empleado e = empleados.get(id);
            System.err.print("¿ Eliminar al empleado '" + e.getNombre() + "' ? (S/N): ");
            String confirm = Tools.getText().substring(0, 1).toUpperCase();
            if (confirm.equalsIgnoreCase("S")) {
                empleados.remove(id);
                System.err.println("**** EMPLEADO ELIMINADO ****");
            }
        } else {
            System.out.println("No hay ningún empleado con ese nro.");
        }
        Tools.pressAKey();
    }

    private static void modifEntry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void listEmployees() {
        Tools.clearScreen();
        int count = 0;
        for (Empleado e : empleados) {
            System.out.println("[" + count + "] " + e.toString());
            count++;
        }
        Tools.pressAKey();
    }
    
    private static void listSmall() {
        Tools.clearScreen();
        int count = 0;
        for (Empleado e : empleados) {
            System.out.println("[" + count + "] " + e.getNombre());
            count++;
        }
    }

    private static boolean employeeExists(int id) {
        return empleados.size() > id;
    }

}
