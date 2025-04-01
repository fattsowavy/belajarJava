public class Dvd extends Item{
    int durasi;
    String sutradara;
    String rating;

    public Dvd(String id, String judul, int tahunTerbit, int durasi, String sutradara, String rating) {
        super(id, judul, tahunTerbit);
        this.durasi = durasi;
        this.sutradara = sutradara;
        this.rating = rating;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Durasi : " + durasi);
        System.out.println("Sutradara : " + sutradara);
        System.out.println("Rating : " + rating);
    }

    public void putar(){
        System.out.println("Memutar DVD " + judul + "dengan durasi " + durasi + " menit");
    }
}
