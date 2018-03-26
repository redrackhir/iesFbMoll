/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiodemultes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dual
 */
public class VehicleRegister {

    private final static int MAX_REGS = 100;    // Capacitat del registre
    private static ArrayList<Registre> registre;

    public VehicleRegister() {
        registre = new ArrayList<>();
    }

    public void entrada(String matricula, double hora, double kilometre) {
        registre.add(new Registre(matricula, hora, kilometre, true));
    }

    public void salida(String matricula, double hora, double kilometre) {
        // Comprueba si tiene entrada...
        double kmHr = 0;
        int indexVehicle = getFirstVehicleEntrance(matricula);
        if (indexVehicle >= 0) {
            // ... y calcula la velocidad media
            Registre r = registre.get(indexVehicle);
            kmHr = getVelMedia(r.getHora(), r.getKilometre(), hora, kilometre);
        }
        registre.remove(getVehicleIndex(matricula));
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
        return ((horaOut - horaIn)/(kmEnd - kmStart));
    }

    private int getFirstVehicleEntrance(String matricula) {
        int idx = 0;
        for (Registre reg : registre) {
            if (reg.isInn() && matricula.equalsIgnoreCase(reg.getMatricula())) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

}
