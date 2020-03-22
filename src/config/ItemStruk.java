package config;

public class ItemStruk {
    String namaPd;
    int harga, qty,jumlah;

    public ItemStruk(String namaPd, int harga, int qty, int jumlah) {
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

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    
}
