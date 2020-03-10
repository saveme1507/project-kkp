package config;


public class PojoLaporanHarian {

    private int kode,stokAwal,Harga,terjual,jumlah;
    private String produk;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public int getStokAwal() {
        return stokAwal;
    }

    public void setStokAwal(int stokAwal) {
        this.stokAwal = stokAwal;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
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

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }
    
}
