package jamapa.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author red rackhir
 */
public class Tools {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

    public static String dateToString(Date date) {
        return sdf.format(date);
    }

    public static Date stringToDate(String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
