/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_creditcard.model;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soib1a20
 */
public class TargetaCredit {

    private Scanner sc = new Scanner(System.in);
    private int[] nroTargeta = {0, 0, 0, 0};
    private double saldo = 0;
    private String clau = "0000";
    private boolean esSessioOberta = false;
    private boolean esActiva = false;
    private boolean esBloq = false;
    private int intentsFallits = 0;

    public TargetaCredit(int[] nroTargeta, double saldo) {
        this.nroTargeta = nroTargeta;
        this.saldo = saldo;
    }

    public String getNroTargeta() {
        return String.format("%04d-%04d-%04d-%04d", nroTargeta[0], nroTargeta[1], nroTargeta[2], nroTargeta[3]);
    }

    public void setClau(String clau) {
        this.clau = clau.substring(0, 4);
        this.esActiva = true;
    }

    public void treure(int qnt) {
        try {
            obrirOperacio();
            if (esSessioOberta) {
                reintegro();
            }
            tancarOperacio();
        } catch (CardBlockedException ex) {
            System.err.println(ex.toString());
        } catch (CardUnactivatedException ex) {
            System.err.println(ex.toString());
        } catch (SaldoInsuficiente ex) {
            System.err.println(ex.toString());
        } finally {

        }
    }

    private void reintegro() throws SaldoInsuficiente {
        System.out.print("Cantidad a retirar: ");
        int money = sc.nextInt();
        transact(-money);
        System.out.println("Reintegro realizado correctamente.");
    }

    private void obrirOperacio() throws CardBlockedException, CardUnactivatedException {
        if (esBloq) {
            throw new CardBlockedException("Targeta bloqueada!!");
        }
        if (!esActiva) {
            throw new CardUnactivatedException("Targeta inactiva. Debe activarse antes de usarla!");
        }
        System.out.println("Verificar PIN. Deje el campo en blanco para salir.");
        boolean fin = false;
        do {
            System.out.print("Código PIN: ");
            String pinIn = sc.nextLine();
            if (pinIn.equals("")) {
                fin = true;
                break;
            }
            if (!pinIn.equalsIgnoreCase(clau)) {
                intentsFallits++;
                if (intentsFallits > 3) {
                    throw new CardBlockedException("Targeta bloqueada!!");
                }
                System.out.println("PIN incorrecto. " + intentsFallits + "r fallo.");
            } else {
                esSessioOberta = true;
                fin = true;
            }
        } while (!fin);
    }

    private void transact(int i) throws SaldoInsuficiente {
        if (saldo + i < 0) {
            throw new SaldoInsuficiente("Saldo insuficiente!!");
        }
        saldo += i;
    }

    private void tancarOperacio() {
        esSessioOberta = false;
    }

    private static class CardUnactivatedException extends Exception {

        public CardUnactivatedException(String s) {
            super(s);
        }
    }

    private static class SaldoInsuficiente extends Exception {

        public SaldoInsuficiente(String s) {
            super(s);
        }
    }

    private static class CardBlockedException extends Exception {

        public CardBlockedException(String s) {
            super(s);
        }

    }

    @Override
    public String toString() {
        return getNroTargeta() + " | Saldo: " + saldo + " | Clau: " + clau
                + " | Activa: " + (esActiva ? "Sí" : "No");
    }
}
