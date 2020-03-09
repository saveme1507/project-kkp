package config;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author saveme
 */
public class CurrentDate {

    public static String tgl_skrg() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

}
