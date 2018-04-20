/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiparking.model;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author red rackhir
 */
public class Planta {

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();  // vehiculos en la planta
    private ArrayList<Asiento> registro = new ArrayList<>();    // registro contable
    private ArrayList<Plaza> plazas = new ArrayList<>();        // plazas de la planta
    private String filenamePlanta = "planta_";
    private final String filenameRegistro = "registro";
    private int capacidad;
    private int nivel;

    public Planta(int nivel, int capacidad) {
        this.nivel = nivel;
        this.capacidad = capacidad;
        filenamePlanta += String.valueOf(nivel);
    }

    /* public void vehicleLeave(String matricula) {
    // Buscar vehiculo en el planta
    int idx = findByMatricula(matricula);
    
    if (idx < 0) {
    System.err.println("El vehiculo '" + matricula + "' no está en el planta!!");
    return;
    }
    
    Vehiculo v = vehiculos.get(idx);
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
    
    // Lo añadimos al registro contable
    Asiento a = new Asiento(new Date(), concepto, precio, v.getMatricula());
    registro.add(a);
    
    // Guardamos en disco
    ReadWriteObjs.saveArray(vehiculos, filenamePlanta);
    ReadWriteObjs.saveArray(registro, filenameRegistro);
    
    // Lo quitamos del array parking
    vehiculos.remove(v);
    
    }*/

  

    public void loadData() {
        vehiculos = ReadWriteObjs.loadArray(vehiculos, filenamePlanta);
        registro = ReadWriteObjs.loadArray(registro, filenameRegistro);
    }

    public int getPrcntFilled() {
        return ((vehiculos.size() * 100) / capacidad);
    }

    public int getCapacidad() {
        return capacidad;
    }

    public JList setVehiclesList() {
        return new JList((ListModel) vehiculos);
    }

    public String[] getVehiclesList() {
        return (String[]) vehiculos.toArray(new String[0]);
    }

}
