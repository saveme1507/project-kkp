package config;

import java.util.ArrayList;

public class ItemLaporan {
    private int no = 0;
    private int kode = 0;
    private String produk = "";
    private int stok_awal = 0;
    private int harga = 0;
    private int terjual = 0;
    private int jumlah = 0;

    public ItemLaporan(int no, int kode, String produk, int stok_awal, int harga, int terjual, int jumlah) {
        this.no = no;
        this.kode = kode;
        this.produk = produk;
        this.stok_awal = stok_awal;
        this.harga = harga;
        this.terjual = terjual;
        this.jumlah = jumlah;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public int getStok_awal() {
        return stok_awal;
    }

    public void setStok_awal(int stok_awal) {
        this.stok_awal = stok_awal;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getTerjual() {
        return terjual;
    }

    public void setTerjual(int terjual) {
        this.terjual = terjual;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

 
}
