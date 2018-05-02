/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codewars;

import java.math.BigDecimal;

/**
 *
 * @author red rackhir
 */
public class HumanReadableTime {

    public static String makeReadable(int seconds) {
        if (seconds > 359999) {
            return "Too big!";
        }
        int longVal = seconds;
        int hours = (int) longVal / 3600;
        int remainder = (int) longVal - hours * 3600;
        int mins = remainder / 60;
        remainder = remainder - mins * 60;
        int secs = remainder;

        return String.format("%02d:%02d:%02d", hours, mins, secs);
    }
}
