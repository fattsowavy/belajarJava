public class Buku{
    String judul;
    String penulis;

    Buku(String judul, String penulis){
        this.judul = judul;
        this.penulis = penulis;
    }

    void info(){
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
    }

    public static void info2(){
        System.out.println("Makan");
    }


}