abstract class Produk {
    private String nama;
    private double harga;
    public  static int jumlahProduk;

    Produk(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
        jumlahProduk++;
    }

    public String getnama(){
        return nama;
    }
//    public  void setnama(String nama){
//        this.nama = nama;
//    }

    public double getHarga(){
        return harga;
    }
//    public void setHarga(){
//        this.harga = harga;
//    }

    abstract String deskripsi();
}
