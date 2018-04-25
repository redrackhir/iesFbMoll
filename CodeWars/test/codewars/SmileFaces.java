package codewars;

import java.util.List;

/**
 *
 * @author red rackhir
 */
public class SmileFaces {

    // ([:;]{1}[-~]?[)D]{1})
    public static int countSmileys(List<String> arr) {
        int count = 0;
        for (String str : arr) {
            count += str.matches("([:;]{1}[-~]?[)D]{1})") ? 1 : 0;
        }
        return count;
    }
}
