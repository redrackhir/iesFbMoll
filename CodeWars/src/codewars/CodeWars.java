package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author red rackhir
 */
public class CodeWars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println(HighAndLow("4 3 1 6 7 9"));
        //System.err.println(findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        /*
        int t = solveSuperMarketQueue(new int[]{ 2, 2, 3, 3, 4, 4 }, 2);
        System.out.println("Time: " + t);
         */
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
    }

    public static String HighAndLow(String numbers) {
        String[] strArray = numbers.split(" ");
        int min = 9999, max = -9999;

        for (String item : strArray) {
            int intValue = Integer.valueOf(item);
            if (intValue > max) {
                max = intValue;
            }
            if (intValue < min) {
                min = intValue;
            }

        }
        return String.valueOf(max) + " " + String.valueOf(min);

    }

    public static int findIt(int[] A) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int key = A[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
            System.out.println("map[" + key + "] = " + map.get(key));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
            System.out.println(entry.toString());
        }

        return 0;
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        Queue<Integer> queue = new LinkedList();
        int[] tills = new int[n];
        int time = 0;

        for (int i : customers) {
            queue.add(i);
        }

        boolean finish = false;
        while (!finish) {
            int suma = 0;
            for (int i = 0; i < n; i++) {
                if (tills[i] <= 1) {
                    tills[i] = queue.isEmpty() ? 0 : queue.poll();
                } else {
                    tills[i]--;
                }
                suma += tills[i];
                finish = suma == 0 ? true : false;
                System.out.println("till[" + i + "] = " + tills[i] + " time: " + time);
            }
            if (!finish) {
                time++;
            }
        }

        return time;
    }

    public static String longest(String s1, String s2) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(s1.split("")));
        list.addAll(Arrays.asList(s2.split("")));
        
        //str.stream().distinct().collect(Collectors.toList());
        Collections.sort(list);
        Set<String> set = new LinkedHashSet<>(list);
        
        return String.join("", set);
    }
}
