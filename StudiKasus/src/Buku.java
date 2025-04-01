public class Buku extends Item{
    String penulis;
    int jumlahHalaman;
    String genre;

    public Buku(String id, String judul, int tahunTerbit, String penulis, int jumlahHalaman, String genre) {
        super(id, judul, tahunTerbit);
        this.penulis = penulis;
        this.jumlahHalaman = jumlahHalaman;
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Penulis : " + penulis);
        System.out.println("Jumlah : " + jumlahHalaman);
        System.out.println("Genre : " + genre);
    }

    public void bacaRingkasan() {
        System.out.println("Membaca ringkasan  dari buku " + judul + " oleh " + penulis);
    }
}
