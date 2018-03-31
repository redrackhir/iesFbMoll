/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyparkingconsole;

import static easyparkingconsole.ConsoleTools.cls;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author red rackhir
 */
public class Parque implements Serializable {

    private ArrayList<Vehiculo> parque = new ArrayList<>();     // registro de vehiculos
    private ArrayList<Asiento> registro = new ArrayList<>();   // registro contable
    private int capacidad = 10;
    private final String filename = "parque";

    public void vehicleEnter(String matricula) {
        if (parque.size() < capacidad) {
            Vehiculo v = new Vehiculo(matricula.toUpperCase(), new Date());

            // Añadimos al array
            parque.add(v);

            // Guardamos en disco
            ReadWriteObjs.saveArray(parque, filename);

            System.out.println("Entrada registrada: matrícula '" + v.getMatricula()
                    + "' fecha '" + v.getFechaHoraEntradaStr() + "'");
        } else {
            System.err.println("El parking está al máximo!!");
        }
    }

    public void vehicleLeave(String matricula) {
        // Buscar vehiculo en el parque
        int idx = findByMatricula(matricula);

        if (idx < 0) {
            System.err.println("El vehiculo '" + matricula + "' no está en el parque!!");
            return;
        }

        Vehiculo v = parque.get(idx);
        v.setHoraSalida(new Date());
        // Calcular diferencia entre entrada y salida
        long estancia = v.getMinutes();
        double precio = estancia * .10f;
        precio = (double) Math.round(precio * 100) / 100;

        System.out.println("Salida registrada.: matrícula '" + matricula
                + "' fecha '" + v.getHoraSalida().toLocaleString() + "' "
                + "\n\t- Estancia: " + estancia + " minutos. "
                + "\n\t- Importe.: " + String.format("%.2f", precio) + "€");

        // Creamos asiento contable
        String concepto = "Ticket '" + v.getMatricula() + "' E." + v.getHoraEntradaStr()
                + "-S." + v.getHoraSalidaStr() + " " + v.getMinutes() + "min. " + precio + "€";
        Asiento a = new Asiento(new Date(), concepto, precio, v.getMatricula());
        registro.add(a);

        // Lo quitamos del array
        parque.remove(v);

        // Guardamos en disco
        ReadWriteObjs.saveArray(parque, filename);

    }

    public void printStatus() {
        cls();
        System.out.println("\tListado de vehiculos en el parque");
        System.out.println("************************************************");
        for (Vehiculo coche : parque) {
            System.out.println(coche.toString());
        }
        System.out.println("------------------------------------------------");
        System.out.printf("Capacidad: %d - Vehiculos acogidos: %d (%d%%)\n",
                capacidad, parque.size(), getPrcntFilled());
    }

    private int getPrcntFilled() {
        return ((parque.size() * 100) / capacidad);
    }

    private int findByMatricula(String matricula) {
        int idx = 0;
        for (Vehiculo coche : parque) {
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    public void printRegistro() {
        cls();
        System.out.println("\tRegistro de ventas");
        System.out.println("************************************************");
        for (Asiento a : registro) {
            System.out.println(a.toString());
        }
        System.out.println("------------------------------------------------");
        System.out.printf("Capacidad: %d - Vehiculos acogidos: %d (%d%%)\n",
                capacidad, parque.size(), getPrcntFilled());
    }

    public void loadData() {
        parque = ReadWriteObjs.loadArray(parque, filename);
    }
}
