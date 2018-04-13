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
public class Main {

    private static ArrayList<Comercial> comerciales = new ArrayList<>();
    private static ArrayList<Repartidor> repartidores = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Añadir comerciales al array
        /*comerciales.add(new Comercial("Juan", 28, 800, 210));
        comerciales.add(new Comercial("Pedro", 30, 1200, 250));
        comerciales.add(new Comercial("José", 32, 900, 160));
        comerciales.add(new Comercial("Luís", 45, 1250, 170));*/

        // Añadir desde disco
        RWObjectsFile.load("comerciales.ser", comerciales);

        // Añadir repartidores al array
        repartidores.add(new Repartidor("Fernando", 23, 800, "zona 1"));
        repartidores.add(new Repartidor("Gabriel", 30, 1200, "zona 2"));
        repartidores.add(new Repartidor("Francisco", 25, 900, "zona 3"));
        repartidores.add(new Repartidor("Angel", 27, 1250, "zona 4"));

        listarEmpleados();

        Comercial com = comerciales.get(1);
        System.out.println("Hoy es el cumple de " + com.getNombre() + ", felicidades!!");
        com.setEdad(31);
        System.out.println(com.toString() + "\n");

        Repartidor rep = repartidores.get(0);
        Repartidor rep2 = repartidores.get(2);
        System.out.println(rep.getNombre() + " y " + rep2.getNombre() + " intercambian sus zonas...");
        String temp = rep.getZona();
        rep.setZona(rep2.getZona());
        rep2.setZona(temp);
        System.out.println(rep);
        System.out.println(rep2 + "\n");

        RWObjectsFile.save("comerciales.ser", comerciales);
    }

    private static void listarEmpleados() {
        // Comerciales
        for (Empleado emp : comerciales) {
            System.out.println(emp.toString());
        }
        // Repartidores
        for (Empleado rep : repartidores) {
            System.out.println(rep.toString());
        }
        System.out.println();
    }

}
