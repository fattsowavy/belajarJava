import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Produk> daftarProduk = new ArrayList<>();
        while (true) {
            System.out.println("\n=== Toko Online ===");
            System.out.println("1. Tambah Produk Elektronik");
            System.out.println("2. Tambah Produk Pakaian");
            System.out.println("3. Tampilkan Semua Produk");
            System.out.println("4. Keluar");
            System.out.print("Masukkan Pilihan [1..4]: ");
            int pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 4){
                System.out.println("Terima Kasih!");
            }
        }
    }
}