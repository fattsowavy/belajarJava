package toko.model;

public class Produk {
    private String nama;
    private int harga;
    private int stok;

    public Produk(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah; // Hanya menambah stok
    }

    public boolean kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nama + " | Harga: " + harga + " | Stok: " + stok;
    }
}