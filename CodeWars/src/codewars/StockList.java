/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codewars;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author red rackhir
 */
public class StockList {

    public static String stockSummary(String[] art, String[] cd) {
        Map<String, Integer> map = new HashMap<>();
        int total = 0;
        for (String code : cd) {
            map.put(code.substring(0, 1), 0);
        }
        for (int i = 0; i < art.length; i++) {
            String key = art[i].substring(0, 1);
            if (map.containsKey(key)) {
                int value = map.get(key);
                int num = Integer.valueOf(art[i].split(" ")[1]) + value;
                map.put(key, num);
                total += num;
            }
        }
        String result = "";
        for (String code : cd) {
            if (map.containsKey(code)) {
                String sep = result.length() == 0 ? "" : " - ";
                result += sep + "(" + code + " : " + map.get(code) + ")";
            }
        }
        return total != 0 ? result : "";
    }
}
