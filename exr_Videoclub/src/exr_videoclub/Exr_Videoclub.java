/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_videoclub;

import java.util.ArrayList;

/**
 *
 * @author soib1a20
 */
public class Exr_Videoclub {

    private static ArrayList<Entregable> alquileres = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        alquileres.add(new Serie("Game Of Thrones", 7, "Fantastic", "Brian Kirk, Neil Marshal..."));
        alquileres.add(new Serie("The Big Bang Theory", 6, "Comedy", "Bill Prady, Chuck Lorre"));
        alquileres.add(new Serie("Los Soprano", 3, "Thriller", "Tim Van Patten"));
        alquileres.add(new Serie("Tales from the crypt", 5, "Fantastic", "Robert Zemeckis"));
        alquileres.add(new Serie("The walking dead", 2, "Horror", "Chandler Riggs"));
        alquileres.add(new Serie("WestWorld", 1, "Fantastic", "Michael Crichton"));
        alquileres.add(new Serie("Breaking Bad", 4, "Drama", "Peter Gould"));

        // Añadir videojuegos
        alquileres.add(new Videojuego("Warcraft", "Strategy", "Blizzard", 15));
        alquileres.add(new Videojuego("Starcraft", "Strategy", "Blizzard", 14));
        alquileres.add(new Videojuego("Minecraft", "Survival", "Microsoft", 13));
        alquileres.add(new Videojuego("Farming Simulator 2018", "Simulator", "Giants", 12));
        alquileres.add(new Videojuego("Stranded Deep", "Survival", "Beam Team", 7));
        alquileres.add(new Videojuego("The Sims 10", "Strategy", "Maxis", 4));
        alquileres.add(new Videojuego("Call Of Duty", "Shooter", "Infinity Ward", 5));
        alquileres.add(new Videojuego("CoD: Medal Of Honor", "1st. person shoooter", "DreamWorks Interactive", 6));
        alquileres.add(new Videojuego("Company Of Heroes", "Strategy", "Relic Entertainment", 7));
        alquileres.add(new Videojuego("Collin McRae", "Simulator", "Codemasters", 9));
        alquileres.add(new Videojuego("Flight Simulator 2018", "Simulator", "Microsoft", 18));

        mostrarLista();

        entregarAlgunos();

        mostrarLista();

        mostrarTopOne();
    }

    private static void mostrarLista() {
        Tools.clearScreen();
        String cabecera = " Id. Tipo        Titulo                         Género              Director            temp. entr.";
        System.out.println(cabecera);
        System.out.println("-------------------------------------------------------------------------------------------------");
        String strCount;
        int count = 0;
        for (Entregable e : alquileres) {
            strCount = String.format("[%2d] ", count);
            if (e.isEntregado()) {
                System.err.println(strCount + e.toString());
            } else {
                System.out.println(strCount + e.toString());
            }
            count++;
        }
        Tools.pressAKey();
    }

    private static void mostrarTopOne() {
        System.out.println("Serie con más temporadas: " + serieConMasTemporadas());
        System.out.println("Videojuego con más horas: " + videojuegoConMasHoras());
    }

    private static void entregarAlgunos() {
        for (int i = 0; i < (Math.random() * 15); i++) {
            int indx = (int) (Math.random() * alquileres.size());
            alquileres.get(indx).entregar();
            System.out.println(indx + " entregado.");
        }
        Tools.pressAKey();
    }

    private static Serie serieConMasTemporadas() {
        int max = 0;
        Serie serie = null;
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i) instanceof Serie) {
                Serie item = (Serie) alquileres.get(i);
                if (item.getTemporada() > max) {
                    max = item.getTemporada();
                    serie = item;
                }
            }
        }
        return serie;
    }

    private static Videojuego videojuegoConMasHoras() {
        int max = 0;
        Videojuego videojuego = null;
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i) instanceof Videojuego) {
                Videojuego item = (Videojuego) alquileres.get(i);
                if (item.getHoras() > max) {
                    max = item.getHoras();
                    videojuego = item;
                }
            }
        }
        return videojuego;
    }

}
