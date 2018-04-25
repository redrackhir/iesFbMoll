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
class Dinglemouse {

    static Object deadAntCount(String ants) {
        if (ants==null) {return 0;}
        ants = ants.replace("ant", "");
        String bits[] = {"a","n","t"};
        int count = 0, max = 0;
        for (int b = 0; b<bits.length; b++) {
            for (int i = 0; i < ants.length(); i++) {
                if (ants.substring(i, i + 1).equalsIgnoreCase(bits[b])) {count++;}
            }
            if (count>max){max=count;}
            count=0;
        }
        return max;
    }

}
