import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Perpustakaan perpus = new Perpustakaan();
        Scanner input = new Scanner(System.in);
        int pil;

        do {
            System.out.println("Menu: ");
            System.out.println("1. Tambahkan buku");
            System.out.println("2. Tampilkan buku");
            System.out.println("3. Keluar");
            System.out.print("Masuukan pilihan: ");
            pil = input.nextInt();
            input.nextLine();

            switch (pil) {
                case 1:
                    System.out.println("Tambahkan buku");
                    System.out.print("Masukkan judul buku: ");
                    String judul = input.nextLine();
                    System.out.print("Masukkan penulis buku: ");
                    String penulis = input.nextLine();
                    perpus.tambahBuku(judul, penulis);
                case 2:
                    perpus.tampilkanBuku();
            }
        } while (pil != 3);

        input.close();
    }
}