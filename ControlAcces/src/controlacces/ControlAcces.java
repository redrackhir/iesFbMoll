/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacces;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author soib1a20
 */
public class ControlAcces {

    private static boolean exit = false;
    private static final ArrayList<Usuari> blackList = new ArrayList<>();
    private static final ArrayList<Usuari> innerList = new ArrayList<>();
    private static final int AFORO_MAX = 340;
    private static int aforo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        aforo = (int) Math.round(Math.random() * 340);
        System.out.println("Aforo máx.: " + AFORO_MAX);

        rellenaListas();
        mostrarInfo();

        // un usuario quiere entrar
        Usuari u = new Usuari("Jose Luis Perales");
        tryToEnter(u);

        // bucle de preguntas 
        while (!exit) {
            mostrarInfo();

            entraUsuario();
        }
    }

    private static void rellenaListas() {
        Usuari u1 = new Usuari("Conde Dracula");
        Usuari u2 = new Usuari("Pepito Grillo");
        Usuari u3 = new Usuari("HAL9000");
        Usuari u4 = new Usuari("Han Solo");
        Usuari u5 = new Usuari("Luke Skywalker");
        Usuari u6 = new Usuari("Darth Vader");
        Usuari u7 = new Usuari("Muñeco diabolico");
        Usuari u8 = new Usuari("Dr.Doom");
        Usuari u9 = new Usuari("Magneto");
        blackList.add(u1);
        blackList.add(u2);
        blackList.add(u3);
        blackList.add(u4);
        blackList.add(u5);
        blackList.add(u6);
        blackList.add(u7);
        blackList.add(u8);
        blackList.add(u9);
    }

    private static void tryToEnter(Usuari usuari) {
        // No puede entrar si consta en la lista negra o ya está dentro o aforo completo
        if (isInBlackList(usuari)) {
            System.out.println(usuari.getNom() + " tiene la entrada vetada!!");
        } else if (isInInnerList(usuari)) {
            System.out.println(usuari.getNom() + " ya está dentro!!");
        } else if (aforo >= AFORO_MAX) {
            System.out.println(usuari.getNom() + " no puede entrar. Aforo completo!!");
        } else if (usuari.getNom().equalsIgnoreCase("hugh heffner")) {
            int libre = AFORO_MAX - aforo;
            System.out.println("¡¡¡ Hombre sr. Heffner!!! Vd. siempre es bienvenido,\n");
            System.out.println("y sus " + libre + " acompañantes también!!");
            innerList.add(usuari);
            aforo+=libre;
            return;
        } else {
            System.out.println(usuari.getNom() + " ha entrado en el recinto.");
            innerList.add(usuari);
            aforo++;
        }
    }

    private static boolean isInBlackList(Usuari usuari) {
        for (Usuari user : blackList) {
            if (user.getNom().equalsIgnoreCase(usuari.getNom())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInInnerList(Usuari usuari) {
        for (Usuari user : innerList) {
            if (user.getNom().equalsIgnoreCase(usuari.getNom())) {
                return true;
            }
        }
        return false;
    }

    private static void mostrarInfo() {
        System.out.println("\nUsuarios en el recinto: " + aforo + "\n");
    }

    private static void entraUsuario() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nuevo usuario que quiere entrar ('exit' para salir): ");
        Usuari u = new Usuari(sc.nextLine());
        if (u.getNom().equalsIgnoreCase("exit")) {
            exit = true;
        }
        tryToEnter(u);
    }

}
