/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiodemultes;

import java.util.Date;

/**
 *
 * @author soib1a20
 */
public class Registre {

    private String matricula;       // Matricula del vehicle
    private double hora;            // Hora d'entrada/sortida
    private double kilometre;       // Km. d'entrada/sortida
    private boolean inn = false;            // true si entra, false si sale

    Registre(String matricula, double hora, double kilometre, boolean inn) {
        this.matricula = matricula;
        this.kilometre = kilometre;
        this.hora = hora;
        this.inn = inn;
    }

    public double getHora() {
        return hora;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getKilometre() {
        return kilometre;
    }

    public boolean isInn() {
        return inn;
    }

    public String toString() {
        return String.format("%-9s - %2.2f - %3.1f - %s",
                matricula, hora, kilometre, inn ? "E" : "  S");
    }

}
