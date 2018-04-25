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
public class Keypad {

    private static String[] keys = {"ADGJMPTW ", "BEHKNQUX", "CFILORVY", "SZ"};

    public static int presses(String phrase) {
        int count = 0;
        for (char c : phrase.toCharArray()) {
            if (keys[0].indexOf(c) > 0) {
                count++;
            }
            if (keys[1].indexOf(c) > 0) {
                count += 2;
            }
            if (keys[2].indexOf(c) > 0) {
                count += 3;
            }
            if (keys[3].indexOf(c) > 0) {
                count += 4;
            }
        }
        return count;
    }
}
