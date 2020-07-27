package config;

/**
 *
 * @author saveme
 */
public class ItemLapHarian {
    int noTransaksi;
    String tanggal,jumlah;

    public ItemLapHarian(int noTransaksi, String tanggal, String jumlah) {
        this.noTransaksi = noTransaksi;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
    }

    public int getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(int noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    
}
