class Elektronik extends Produk {
    private int garansi;

    Elektronik(String nama, double harga, int garansi) {
        super(nama, harga);
        this.garansi = garansi;
    }

    String deskripsi(){
        return getnama() + " - Rp" + getHarga() + ", Garansi: " + garansi + " bulan";
    }
}
