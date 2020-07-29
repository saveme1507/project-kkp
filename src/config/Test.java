/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.transform.Source;
import transaksi.LaporanHarian;

/**
 *
 * @author saveme
 */
public class Test {

    static String s = "12";

    public static void main(String[] args) {
        System.out.println(tgl_skrng_ttd());
    }

    static boolean cekInteger(String s) {
        boolean hasil;
        try {
            int test = Integer.parseInt(s);
            hasil = true;
        } catch (NumberFormatException e) {
            hasil = false;
        }
        return hasil;
    }

    public static String tgl_skrng_ttd() {
        int hari, tgl, bulan, tahun;
        GregorianCalendar date = new GregorianCalendar();
        String namaHari[] = {"Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu", "Minggu"};
        String namabulan[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        hari = date.get(Calendar.DAY_OF_WEEK);
        tgl = date.get(Calendar.DAY_OF_MONTH);
        bulan = date.get(Calendar.MONTH);
        tahun = date.get(Calendar.YEAR);
        String tglSekarang = "Jakarta, " + namaHari[hari] +" "+ String.valueOf(tgl + " " + namabulan[bulan]+ " " + tahun);
        return tglSekarang;
    }

}
