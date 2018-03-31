/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyparkingconsole;

import static easyparkingconsole.Ansi_Colours.*;

/**
 *
 * @author red rackhir
 */
class Plaza {

    public static final String CLR_LIBRE = ANSI_WHITE + ANSI_BG_GREEN;
    public static final String CLR_OCUPADA = ANSI_WHITE + ANSI_BG_RED;
    public static final String CLR_RESERVADA = ANSI_WHITE + ANSI_BG_BLUE;
    public static final String CLR_INDISPONIBLE = ANSI_BLACK + ANSI_BG_WHITE;
    private int id;
    private int planta;
    private EstadosPlaza estado = EstadosPlaza.LIBRE;

    public Plaza(int id, int planta) {
        this.id = id;
        this.planta = planta;
    }

    public Plaza(int id, int planta, EstadosPlaza estado) {
        this.id = id;
        this.planta = planta;
        this.estado = estado;
    }

    public static String getColorLibre() {
        return CLR_LIBRE;
    }

    public static String getColorOcupada() {
        return CLR_OCUPADA;
    }

    public static String getColorReservada() {
        return CLR_RESERVADA;
    }

    public static String getColorIndisponible() {
        return CLR_INDISPONIBLE;
    }

    public EstadosPlaza getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    void printGraphicState() {

        char icon = ' ';
        String color = ANSI_RESET;

        switch (estado) {
            case LIBRE:
                color += CLR_LIBRE;
                icon = ' ';
                break;
            case OCUPADA:
                color += CLR_OCUPADA;
                icon = '@';
                break;
            case RESERVADA:
                color += CLR_RESERVADA;
                icon = '@';
                break;
            case INDISPONIBLE:
                color += CLR_INDISPONIBLE;
                icon = '@';
                break;
        }
        System.out.printf("%s%3d%s", color, id, ANSI_RESET + "  ");
    }

}
