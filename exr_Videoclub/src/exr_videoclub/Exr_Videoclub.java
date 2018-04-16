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
        alquileres.add(new Serie("Game Of Thrones", 1, "Fantastic", "EEUU"));
        alquileres.add(new Serie("The Big Bang Theory", 1, "Comedy", "EEUU"));
        alquileres.add(new Serie("The Bones Collector", 1, "Thriller", "EEUU"));
        alquileres.add(new Serie("The Hobbit", 1, "Fantastic", "EEUU"));
        alquileres.add(new Serie("Batman Begins", 1, "Fantastic", "EEUU"));
        alquileres.add(new Serie("Fantastic Four", 1, "Fantastic", "EEUU"));
        alquileres.add(new Serie("Strange Things", 1, "Thriller", "EEUU"));

        // Añadir videojuegos
        alquileres.add(new Videojuego("Warcraft", "Strategy", "Blizzard", 15));
        alquileres.add(new Videojuego("Starcraft", "Strategy", "Blizzard", 14));
        alquileres.add(new Videojuego("Minecraft", "Survival", "Microsoft", 13));
        alquileres.add(new Videojuego("Farming Simulator 2018", "Simulator", "Giants", 12));
        alquileres.add(new Videojuego("Stranded Deep", "Survival", "Indy", 7));
        alquileres.add(new Videojuego("The Sims 10", "Strategy", "Unknow", 4));
        alquileres.add(new Videojuego("Call Of Duty", "Shooter", "Unknow", 5));
        alquileres.add(new Videojuego("CoD: Medal Of Honor", "1st. person shoooter", "Unknow", 6));
        alquileres.add(new Videojuego("Company Of Heroes", "Strategy", "Unknow", 7));
        alquileres.add(new Videojuego("Collin McRae", "Simulator", "Unknow", 9));
        alquileres.add(new Videojuego("Flight Simulator 2018", "Simulator", "Unknow", 18));

        mostrarLista();

        entregarAlgunos();

        mostrarLista();
    }

    private static void mostrarLista() {
        Tools.clearScreen();
        String cabecera = " Id. Tipo        Titulo                         Género              Director            temp. entr.";
        System.out.println(cabecera);
        System.out.println("-------------------------------------------------------------------------------------------------");
        String strCount;
        int count = 0;
        for (Object o : alquileres) {
            strCount = String.format("[%2d] ", count);
            System.out.println(strCount + o.toString());
            count++;
        }
        Tools.pressAKey();
    }

    private static void entregarAlgunos() {
        for (int i = 0; i < (Math.random() * 15); i++) {
            int indx = (int) (Math.random() * alquileres.size());
            alquileres.get(indx).entregar();
            System.out.println(indx + " entregado.");
        }
        Tools.pressAKey();
    }

}
