/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author saveme
 */
public class ItemLapBulanan {

    int no, jml_transaksi;
    String tanggal, jml_pendapatan;

    public ItemLapBulanan(int no, int jml_transaksi, String jml_pendapatan, String tanggal) {
        this.no = no;
        this.jml_transaksi = jml_transaksi;
        this.jml_pendapatan = jml_pendapatan;
        this.tanggal = tanggal;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getJml_transaksi() {
        return jml_transaksi;
    }

    public void setJml_transaksi(int jml_transaksi) {
        this.jml_transaksi = jml_transaksi;
    }

    public String getJml_pendapatan() {
        return jml_pendapatan;
    }

    public void setJml_pendapatan(String jml_pendapatan) {
        this.jml_pendapatan = jml_pendapatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

}
