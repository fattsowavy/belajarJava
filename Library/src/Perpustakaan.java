import java.util.ArrayList;

public class Perpustakaan {
    ArrayList<Buku> daftarBuku = new ArrayList<>();

    void tambahBuku(String judul, String penulis){
        Buku bukuBaru = new Buku(judul, penulis);
        daftarBuku.add(bukuBaru);
        System.out.println("Buku berhasil ditambahkan");
    }

    void tampilkanBuku(){
        if(daftarBuku.isEmpty()){
            System.out.println("Buku Kosong");
        } else {
            for(Buku buku : daftarBuku){
                buku.info();

            }
        }
    }


}
