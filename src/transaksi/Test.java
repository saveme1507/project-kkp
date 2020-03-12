package transaksi;

import config.Koneksi_1;
import config.Koneksi_2;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Test {

    ArrayList<Integer> terjual = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here  
        System.out.println(getDate());
        System.out.println(setPeriode());
        for (int i = 0; i < 10; i++) {
            int no=1+i;
            System.out.println(no);
        }
    }

    private static String getDate() {
        int hari, bulan, tahun;
        GregorianCalendar date = new GregorianCalendar();
        String namabulan[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        hari = date.get(Calendar.DAY_OF_MONTH);
        bulan = date.get(Calendar.MONTH);
        tahun = date.get(Calendar.YEAR);
        String tglSekarang = String.valueOf(hari + " " + namabulan[bulan] + " " + tahun);
        return tglSekarang;
    }

    private static String setPeriode() {
        Calendar cal = Calendar.getInstance();
        String a = new SimpleDateFormat("MMM yyyy").format(cal.getTime());
        return a;
    }

//    private String pilihTgl(){
//        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
//        String date = dcn.format(jDateChooser1.getDate() );
//    
//        return date;
//    }
}
