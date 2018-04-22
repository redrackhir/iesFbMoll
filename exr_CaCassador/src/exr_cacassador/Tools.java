/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr_cacassador;

/**
 *
 * @author soib1a20
 */
public class Tools {

    public static boolean getRandomSuccess(int probability) {
        // Return true if passes % of probability, false otherwise
        return ((Math.random() * 100) < probability);
    }

    public static int getRandomNumBetween(int min, int max) {
        int interval = max - min;
        int num = (int) ((Math.random() * interval) + min);
        return num;
    }
}
