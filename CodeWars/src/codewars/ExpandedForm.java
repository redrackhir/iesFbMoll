/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codewars;

/**
 *
 * @author red rackhir
 */
public class ExpandedForm {

    public static String expandedForm(int num) {
        String number = String.valueOf(num), retVal = "";
        for (int i = 0; i < number.length(); i++) {
            int nro = Integer.valueOf(number.substring(i, i + 1)) * Integer.valueOf("1" + repeated("0", number.length() - i - 1));
            retVal += String.valueOf(nro == 0 ? "" : nro + " + ");
        }
        return retVal.substring(0, retVal.length() - 3);
    }

    private static String repeated(String str, int times) {
        if (times > 0) {
            String s = String.format("%0" + (times) + "d", 0).replace("0", str);
            return s;
        }
        return "";
    }
}
