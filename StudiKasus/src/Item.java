public class Item {
    String id;
    String judul;
    int tahunTerbit;
    boolean status;

    public Item(String id, String judul, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.status = true;
    }

    public void pinjam(){
        this.status = false;
    }

    public void kembalikan(){
        this.status = true;
    }

    public void displayInfo(){
        System.out.println("ID: " + id);
        System.out.println("Judul: " + judul);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        if (status == true) {
            System.out.println("Status :Buku Tersedia");
        } else {
            System.out.println("Status: Buku Sedang Dipinjam");
        }
    }
}
