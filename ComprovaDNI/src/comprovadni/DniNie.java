/*
 * To change this license header", " choose License Headers in Project Properties.
 * To change this template file", " choose Tools | Templates
 * and open the template in the editor.
 */
package comprovadni;

/**
 *
 * @author soib1a20
 */
public class DniNie {

    private static final String[] LETRAS = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B",
        "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
    private final String dni;
    private int nroDoc;
    private char letraIni;
    private char letraFin;
    private boolean isNie = false;

    public DniNie(String dni) {
        this.dni = dni.toUpperCase();
        desglosaDni(this.dni);
        compruebaLetra();
    }

    private String calcLetraNif() {
        return LETRAS[nroDoc % 23];
    }

    public String getNif() {
        return String.valueOf(nroDoc) + letraFin;
    }
    
    public String getNie() {
        return letraIni + String.valueOf(nroDoc) + letraFin;
    }

    public int getNroDni() {
        return nroDoc;
    }

    public char getLetraNif() {
        return letraFin;
    }

    private void desglosaDni(String dni) {
        String parteNumerica = "";
        char firstLetter = dni.charAt(0);
        if (Character.isLetter(firstLetter)) {
            letraIni = firstLetter;
            switch (firstLetter) {
                case 'X':
                    parteNumerica = "0";
                    break;
                case 'Y':
                    parteNumerica = "1";
                    break;
                case 'Z':
                    parteNumerica = "2";
                    break;
            }
        }
        for (char c : dni.toCharArray()) {
            if (Character.isDigit(c)) {
                parteNumerica += c;
            } else {
                letraFin = c;
            }
        }
        nroDoc = Integer.parseInt(parteNumerica);
    }

    private void compruebaLetra() {
        if (letraFin != calcLetraNif().charAt(0)) {
            System.out.println("Letra incorrecta! Verifique nroDoc. de documento!!");
        } else {
            System.out.println("Documento correcto!");
        }
    }
}
