public class Main {
    public static void main(String[] args) {

        Buku buku = new Buku("A01", "Tukang Haji", 2023, "Fatwa", 12, "Petualang");
        buku.pinjam();
        buku.displayInfo();
        buku.bacaRingkasan();

        System.out.println();

        Dvd dvd = new Dvd("B01", "Sepatu Rusak", 2010, 20, "John Cena", "13+");
        dvd.displayInfo();
        dvd.putar();
    }
}