class Pakaian extends Produk {
    private String ukuran;
    Pakaian(String nama, double harga, String ukuran) {
        super(nama, harga);
    }

    String deskripsi(){
        return getnama() + " - Rp" + getHarga() + " - Ukuran: " + ukuran;
    }
}
