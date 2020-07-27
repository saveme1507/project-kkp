package config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public static String tgl_skrg_string() {
        int hari, bulan, tahun;
        GregorianCalendar date = new GregorianCalendar();
        String namabulan[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        hari = date.get(Calendar.DAY_OF_MONTH);
        bulan = date.get(Calendar.MONTH);
        tahun = date.get(Calendar.YEAR);
        String tglSekarang = String.valueOf(hari + " " + namabulan[bulan].toUpperCase() + " " + tahun);
        return tglSekarang;
    }

    public static String periodeBulan(int bulan) {
        String namabulan[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        String periode = namabulan[bulan].toUpperCase();
        return periode;
    }
    
    public static int jam(){
        int jam;
        GregorianCalendar date =  new GregorianCalendar();
        jam = date.get(Calendar.HOUR_OF_DAY);
        return jam;
    }
    
      public static String tglSql_toFormatTb(String dateSql) {
        int hari, bulan, tahun;
        SimpleDateFormat formatInput = new SimpleDateFormat("yyyy-MM-dd");
        String dateHasil = null;
        try {
            Date dateInput = formatInput.parse(dateSql);
            GregorianCalendar date = (GregorianCalendar) GregorianCalendar.getInstance();
            date.setTime(dateInput);
            String namabulan[] = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sep", "Okt", "Nov", "Des"};
            hari = date.get(Calendar.DAY_OF_MONTH);
            bulan = date.get(Calendar.MONTH);
            tahun = date.get(Calendar.YEAR);
            dateHasil =String.valueOf(hari + " " + namabulan[bulan]+ " " + tahun);
        }catch (ParseException e) {
        }
        return dateHasil;
    }
      
        public static String tglSql_toString(String dateSql) {
        int hari, bulan, tahun;
        SimpleDateFormat formatInput = new SimpleDateFormat("yyyy-MM-dd");
        String dateHasil = null;
        try {
            Date dateInput = formatInput.parse(dateSql);
            GregorianCalendar date = (GregorianCalendar) GregorianCalendar.getInstance();
            date.setTime(dateInput);
            String namabulan[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
            hari = date.get(Calendar.DAY_OF_MONTH);
            bulan = date.get(Calendar.MONTH);
            tahun = date.get(Calendar.YEAR);
            dateHasil =String.valueOf(hari + " " + namabulan[bulan]+ " " + tahun);
        }catch (ParseException e) {
        }
        return dateHasil;
    }
    
}
