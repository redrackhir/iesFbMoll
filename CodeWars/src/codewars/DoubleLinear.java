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
public class DoubleLinear {

    public static int dblLinear(int n) {
        boolean finish = false;
        int x = 1, y, z;
        do {
            y = 2 * x + 1;
            x++;
            if (y == n) {
                return x;
            }
            z = 3 * x + 1;
            x++;
            if (z == n) {
                return x;
            }

        } while (!finish);
        return 0;
    }

}
