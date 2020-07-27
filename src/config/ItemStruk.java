package config;

public class ItemStruk {
    String namaPd,harga,jumlah;
    int qty;

    public ItemStruk(String namaPd, String harga, int qty, String jumlah) {
        this.namaPd = namaPd;
        this.harga = harga;
        this.qty = qty;
        this.jumlah = jumlah;
    }

    public String getNamaPd() {
        return namaPd;
    }

    public void setNamaPd(String namaPd) {
        this.namaPd = namaPd;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    
    
}
