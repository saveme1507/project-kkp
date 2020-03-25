package config;

/**
 *
 * @author saveme
 */
public class ItemLapHarian {
    int noTransaksi,jumlah;
    String tanggal;

    public ItemLapHarian(int noTransaksi, String tanggal, int jumlah) {
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

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    
}
