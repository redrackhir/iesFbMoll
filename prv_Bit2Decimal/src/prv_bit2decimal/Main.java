/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prv_bit2decimal;

/**
 *
 * @author soib1a20
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*int[] myByte = {0, 0, 0, 1, 0, 0, 0, 1};
        
        int retVal = bit2Decimal(myByte);
        System.out.println("Resultado: " + retVal);*/

    }

    public static String getMiddle(String word) {
        //Code goes here!
        int len = word.length();
        int evod = len % 2;

        if (evod == 0) {
            // par
            return word.substring(len, len+2);
        } else {
            return word.substring(len, len+1);
        }
    }

    public static int bit2Decimal(int[] bitArray) {
        int pos = 0, suma = 0;
        for (int i = bitArray.length - 1; i >= 0; i--) {
            int bitValue = bitArray[i];
            int decValue = (int) Math.pow(2, pos);
            suma += decValue;
            System.out.println("Pos: " + pos + " bitValue: " + bitValue + " decValue: "
                    + decValue + " suma: " + suma);
            pos++;
        }
        return suma;
    }

}
