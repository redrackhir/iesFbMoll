/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calciban;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author soib1a20
 */
public class CalcIBAN {

    /**
     * Calculadora dígito control cuenta bancaria + IBAN
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Entrar nro de cuenta
        Scanner sc = new Scanner(System.in);

        System.out.print("Entra nº de cuenta: ");
        String accountNmbr = sc.nextLine(); //"1234-1234-99-1234567890";
        String account = accountNmbr.replace("-", "");

        // Comprobar mínimo de 20 dígitos
        if (accountNmbr.length() < 20) {
            System.out.println("La cuenta debe tener un mínimo de 20 dígitos!!");
            System.exit(0);
        }

        // Calcular digito control CCC
        int dc = getDcAccount(accountNmbr);

        // Compara con el introducido
        int userDc = getDcNumber(accountNmbr);

        System.out.println(userDc + " - " + dc);
        System.out.println("El código IBAN de la cuenta es: " + (getIbanNumber(accountNmbr))
                + "-" + formattedAccountNmbr(account));

        if (userDc != dc) {
            System.out.println("Hay un error, el dígito de control no corresponde!");
        } else {
            System.out.println("Nº de cuenta correcto!");
        }

    }

    private static int getDcAccount(String accountNmbr) {
        // valores por posicion de dígito
        int[] tokens = {4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7, 3, 6};

        // eliminar guiones
        String account = accountNmbr.replace("-", "");

        // Hacemos 2 bloques de 8 y 10 digitos respectivamente
        // izdo. Entidad+Oficina. Dcho. nro de cuenta
        String lBlock = account.substring(0, 8);
        String rBlock = account.substring(10);

        // Hacemos los calculos para bloque izdo.
        int sumaBloque = 0;
        for (int i = 0; i < lBlock.length(); i++) {
            int digito = Integer.parseInt(lBlock.substring(i, i + 1));
            sumaBloque += digito * tokens[i];
        }

        int firstDigit = 11 - (sumaBloque % 11);
        if (firstDigit > 9) {
            if (firstDigit == 10) {
                firstDigit = 1;
            } else {
                firstDigit = 0;
            }
        }

        // Calculos bloque dcho.
        sumaBloque = 0;
        for (int i = 0; i < rBlock.length(); i++) {
            int offset=8;
            int digito = Integer.parseInt(rBlock.substring(i, i + 1));
            sumaBloque += digito * tokens[i+offset];
        }

        int secondDigit = 11 - (sumaBloque % 11);
        if (secondDigit > 9) {
            if (secondDigit == 10) {
                secondDigit = 1;
            } else {
                secondDigit = 0;
            }
        }
        return Integer.parseInt(String.valueOf(firstDigit) + String.valueOf(secondDigit));
    }

    /**
     * Extrae el dígito de control de una cuenta
     *
     * @param accountNmbr
     * @return DC
     */
    private static int getDcNumber(String accountNmbr) {
        String account = accountNmbr.replace("-", "");
        return Integer.parseInt(account.substring(8, 10));
    }

    private static String getIbanNumber(String accountNmbr) {
        String account = accountNmbr.replace("-", "");
        // Sustituimos ES00 por sus valores (E=14 y S=28)
        // y lo añadimos al final del nro de cuenta
        account += "142800";
        BigInteger nmbr = new BigInteger(account);
        nmbr = nmbr.mod(new BigInteger("97"));
        return "ES" + (98 - (nmbr.intValue()));
    }

    private static String formattedAccountNmbr(String account) {
        return account.substring(0, 4) + "-" + account.substring(4, 8) + "-"
                + account.substring(8, 10) + "-" + account.substring(10, 20);
    }

}
