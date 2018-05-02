package codewars;

import java.math.BigDecimal;
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
        System.out.println(PhoneDir.phone("/+1-541-754-3010 156 Alphand_St. <J Steeve>\n"
                + " 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
                + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n", "1-541-754-3010"));
        //System.out.println(HumanReadableTime.makeReadable(359999));
        /*
        String art[] = new String[]{"ZBAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String cd[] = new String[]{"A", "B"};
        System.out.println("(A : 0) - (B : 1140)");
        System.out.println(StockList.stockSummary(art, cd));
//System.out.println(Dinglemouse.deadAntCount("ant anantt aantnt"));
        /* String[] question = {"right", "down", "left", "left", "left", "left", "right"};
        String[] values = {"right", "down", "left", "left", "left", "left", "right"};
        String[] expect = {"E.Honda", "Chun Li", "Ken", "M.Bison", "Sagat", "Dhalsim", "Sagat"};
        int[][] position = {{0}, {0}};*/
        //System.out.println(Arrays.asList(StreetFighter.selection(question,position)));
        // TODO code application logic here
        //System.out.println(HighAndLow("4 3 1 6 7 9"));
        //System.err.println(findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        /*
        int t = solveSuperMarketQueue(new int[]{ 2, 2, 3, 3, 4, 4 }, 2);
        System.out.println("Time: " + t);
         */
        //System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
        /*
        String[] retVal = dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"});
        System.out.println(String.join(",", retVal));
        
        retVal = dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"});
        System.out.println(String.join(",", retVal));
         */
        //System.out.println(Arrays.toString(GapInPrimes.gap(2, 548600, 548900)));
        //System.out.println(Arrays.toString(GapInPrimes.gap(2, 755200, 755400)));

        //System.out.println(CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix"));
        /*        String phone = "(012) 123-1234";
        System.out.println(phone + ": " + ValidPhoneNumber.checkPhoneNumber(phone));
        phone = "(012 123-1234";
        System.out.println(phone + ": " + ValidPhoneNumber.checkPhoneNumber(phone));
        phone = "(012)123-1234";
        System.out.println(phone + ": " + ValidPhoneNumber.checkPhoneNumber(phone));
        phone = "(012) 123 1234";
        System.out.println(phone + ": " + ValidPhoneNumber.checkPhoneNumber(phone));
        phone = "(0a2) 123-1234";
        System.out.println(phone + ": " + ValidPhoneNumber.checkPhoneNumber(phone));
        
        System.out.println(ExpandedForm.expandedForm(42));
        System.out.println(ExpandedForm.expandedForm(402));
        System.out.println(ExpandedForm.expandedForm(70304));
         */
        //System.out.println(Keypad.presses("HOW R U"));
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

    public static String[] dirReduc(String[] arr) {
        ArrayList<String> dirs = new ArrayList<>(Arrays.asList(arr));
        int y = Collections.frequency(dirs, "SOUTH") - Collections.frequency(dirs, "NORTH");
        int x = Collections.frequency(dirs, "EAST") - Collections.frequency(dirs, "WEST");
        String str = new String(new char[Math.abs(y)]).replace("\0", y > 0 ? "SOUTH " : "NORTH ");
        str += new String(new char[Math.abs(x)]).replace("\0", x > 0 ? "EAST " : "WEST ");
        return str.split(" ");
    }
}
