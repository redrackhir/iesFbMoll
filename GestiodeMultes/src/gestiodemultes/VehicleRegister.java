/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiodemultes;

import java.util.ArrayList;

/**
 *
 * @author Dual
 */
public class VehicleRegister {

    public static final double SPEED_MAX = 120;
    private final static int MAX_SIZE = 100;    // Capacitat del registre
    private static ArrayList<Registre> registre;

    public VehicleRegister() {
        registre = new ArrayList<>();
    }

    public void entrada(String matricula, double hora, double kilometre) {
        // Si ya hay una entrada previa, la borra
        int indexVehicle = getVehicleEntrance(matricula);
        if (indexVehicle >= 0) {
            registre.remove(indexVehicle);
        }
        // Si el registro esta al maximo, borra el mas antiguo
        if (registre.size() > MAX_SIZE) {
            registre.remove(0);
        }
        // Y finalmente añade el nuevo registro
        registre.add(new Registre(matricula, hora, kilometre, true));
    }

    public void salida(String matricula, double hora, double kilometre) {
        // Comprueba si tiene entrada...
        double kmHr = 0;
        int indexVehicle = getVehicleEntrance(matricula);
        if (indexVehicle >= 0) {
            // ... y calcula la velocidad media
            Registre r = registre.get(indexVehicle);
            kmHr = getVelMedia(r.getHora(), r.getKilometre(), hora, kilometre);
            if (kmHr > SPEED_MAX) {
                expedirMulta(matricula, kilometre, hora, kmHr);
            }
            registre.remove(getVehicleIndex(matricula));
        }
    }

    @Override
    public String toString() {
        String retVal = "";
        for (Registre reg : registre) {
            retVal += reg.toString() + "\n";
        }
        return retVal;
    }

    private int getVehicleIndex(String matricula) {
        int cont = 0;
        for (Registre reg : registre) {
            if (reg.getMatricula().equalsIgnoreCase(matricula)) {
                return cont;
            }
            cont++;
        }
        return -1;
    }

    private double getVelMedia(double horaIn, double kmStart, double horaOut, double kmEnd) {
        return ((kmEnd - kmStart) / (horaOut - horaIn));
    }

    private int getVehicleEntrance(String matricula) {
        int idx = 0;
        for (Registre reg : registre) {
            if (reg.isInn() && matricula.equalsIgnoreCase(reg.getMatricula())) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    private void expedirMulta(String matricula, double km, double hora, double kmHr) {
        // recrear expedicion de multa
        System.out.println("+-------------------------------+");
        System.out.println("| Multa por exceso de velocidad |");
        System.out.println("+-------------------------------+");
        System.out.println("  Matrícula....: " + matricula);
        System.out.println("  Kmtr.........: " + km);
        System.out.println("  Hora.........: " + hora);
        System.out.println("  Velocidad....: " + kmHr + "Km/hr.");
        System.out.println("  Max.permitido: " + SPEED_MAX + "Km/hr.\n");
        GestiodeMultes.pressAKey();
    }

}
