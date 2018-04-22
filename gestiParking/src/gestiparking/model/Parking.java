package gestiparking.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Date;

/**
 * Gestiona las entradas/salidas de vehiculos, los tickets, asientos contables y
 * plazas de todo el parking.
 *
 * @author red rackhir
 */
public final class Parking {

    private final ArrayList<Planta> plantas = new ArrayList();
    private final ArrayList<Vehiculo> vehiculos = new ArrayList();
    private final ArrayList<Plaza> plazas = new ArrayList();
    private final ArrayList<Asiento> asientos = new ArrayList();
    private int entradas = 0;
    private int salidas = 0;
    private final int capacidad;
    private final int nroPlantas;

    public Parking(int plantas, int capacidad) {
        this.nroPlantas = plantas;
        this.capacidad = capacidad;
    }

    public Vehiculo vehicleEnter(String matricula) {
        Vehiculo v = null;

        if (matricula.isEmpty()) {
            matricula = getMatriculaAeatoria();
        }

        if (vehiculos.size() < capacidad) {
            v = new Vehiculo(matricula.toUpperCase(), new Date());

            // Añadimos al array
            vehiculos.add(v);
            entradas++;

            // Guardamos en disco
            ReadWriteObjs.saveArray(vehiculos, "vehiculos");

            System.out.println("Entrada registrada: matrícula '" + v.getMatricula()
                    + "' fecha '" + v.getFechaHoraEntradaStr() + "'");
        } else {
            System.err.println("El parking está al máximo!!");
        }
        return v;
    }

    private String getMatriculaAeatoria() {
        int nro = getRandomNumber(0, 9999);
        String letras = "";
        for (int i = 0; i < 3; i++) {
            letras += Character.toString((char) getRandomNumber(65, 90));
        }
        return String.format("%04d", nro) + letras;
    }

    private int getRandomNumber(int min, int max) {
        double i = Math.round(Math.random() * (max - min) + min);
        return (int) i;
    }

    public String[] getMatriculas() {
        String matriculas = "";
        for (int i = 0; i < vehiculos.size(); i++) {
            String format = "%s - %s";
            matriculas += "_" + String.format(format,
                    vehiculos.get(i).getMatricula(),
                    vehiculos.get(i).getHoraEntradaStr());
        }
        matriculas = matriculas.substring(1);
        return matriculas.split("_");
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Vehiculo vehicleLeave(String matricula) {
        if (vehiculos.size() == 0) {
            System.err.println("No quedan vehículos en el parking!!");
            return null;
        }
        Vehiculo v = null;
        if (matricula.isEmpty()) {
            v = getRandomVehicleFromGarage();
        } else {
            v = vehiculos.get(findByMatricula(matricula));
        }
        if (v != null) { // encontrado
            // eliminar de la lista
            vehiculos.remove(v);
            salidas++;
            System.out.println("Vehículo '" + v.getMatricula() + "' ha salido. Quedan " + vehiculos.size());
            // cobrar ticket
        } else {
            System.err.println("Vehiculo no está en garage!!");
        }
        return v;
    }

    public int getEntradas() {
        return entradas;
    }

    public int getSalidas() {
        return salidas;
    }

    private Vehiculo getRandomVehicleFromGarage() {
        int i = getRandomNumber(1, vehiculos.size());
        Vehiculo v = vehiculos.get(i - 1);
        return v;
    }

    private int findByMatricula(String matricula) {
        int idx = 0;
        for (Vehiculo coche : vehiculos) {
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    public int getPlacesFree() {
        return capacidad - vehiculos.size();
    }

    public int getPlacesOcupied() {
        return vehiculos.size();
    }

    public int getCapacity() {
        return capacidad;
    }
}
