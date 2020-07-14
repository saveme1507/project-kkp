/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.xml.transform.Source;
import transaksi.LaporanHarian;

/**
 *
 * @author saveme
 */
public class Test {
    static String s = "12";
    
    public static void main(String[] args) {
        if (cekInteger(s)==true) {
            System.out.println("ini integer");
        }
    }
    
    static boolean cekInteger(String s){
        boolean hasil;
         try {
            int test = Integer.parseInt(s);
            hasil = true;
        } catch (NumberFormatException e) {
            hasil = false;
        }
        return hasil;
    }
    
    
}
