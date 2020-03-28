package transaksi;

import config.Koneksi_1;
import config.Koneksi_2;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Test {

    ArrayList<item> kode = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(config.CurrentDate.jam());
        
        
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

   class item{
       int kode,qty;

        public item(int kode, int qty) {
            this.kode = kode;
            this.qty = qty;
        }

        public int getKode() {
            return kode;
        }

        public void setKode(int kode) {
            this.kode = kode;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }
       
   }
    
}
