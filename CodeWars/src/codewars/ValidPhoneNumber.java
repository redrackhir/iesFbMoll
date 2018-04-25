package codewars;

/**
 *
 * @author red rackhir
 */
public class ValidPhoneNumber {

    public static boolean checkPhoneNumber(String phone) {
        String regex = "\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}";
        return phone.matches(regex) && phone.length() == 14;
    }

}
