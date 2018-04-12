/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

/**
 *
 * @author soib1a20
 */
public class Yatzy {

    public static int chance(int... dice) {
        int count = 0;
        for (int i = 0; i < dice.length; i++) {
            count += dice[i];
        }
        return count;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        int[] dados = {d1, d2, d3, d4, d5};
        int check = d1;
        for (int i = 1; i < 5; i++) {
            if (check != dados[i]) {
                return 0;
            }
        }
        return 50;
    }

    public static int ones(int... dice) {
        int count = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 1) {
                count++;
            }
        }
        return count;
    }

}
