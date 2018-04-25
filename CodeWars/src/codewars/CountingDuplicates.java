package codewars;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author red rackhir
 */
public class CountingDuplicates {

    public static int duplicateCount(String text) {
        int total = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String c : text.split("")) {
            map.put(c.toLowerCase(), map.get(c) != null ? map.get(c) + 1 : 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                total++;
            }
        }
        return total;
    }
}
