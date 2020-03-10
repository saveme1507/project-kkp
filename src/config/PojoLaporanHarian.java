package config;

public class PojoLaporanHarian {

    private String kode;
    private String produk;
    private String stokAwal;
    private String Harga;
    private String terjual;
    private String jumlah;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public String getStokAwal() {
        return stokAwal;
    }

    public void setStokAwal(String stokAwal) {
        this.stokAwal = stokAwal;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String Harga) {
        this.Harga = Harga;
    }

    public String getTerjual() {
        return terjual;
    }

    public void setTerjual(String terjual) {
        this.terjual = terjual;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

}
