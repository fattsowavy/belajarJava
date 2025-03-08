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
                break;
            }

            switch (pilihan){
                case 1:
                    System.out.print("Masukkan nama produk: ");
                    String namaElktrnk = input.nextLine();
                    System.out.print("Masukka harga: Rp. ");
                    double hargaElktrnk = input.nextDouble();
                    System.out.print("Masukkan garansi (bulan): ");
                    int garansi = input.nextInt();
                    input.nextLine();

                    Elektronik elek = new Elektronik(namaElktrnk, hargaElktrnk, garansi);
                    daftarProduk.add(elek);
                    System.out.println("Produk Elektronik berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.print("Masukkan nama produk: ");
                    String namaPakaian = input.nextLine();
                    System.out.print("Masukkan harga: Rp");
                    double hargaPakaian = input.nextDouble();
                    System.out.print("Masukkan ukuran (S/M/L): ");
                    String ukuran = input.nextLine();
                    input.nextLine();

                    Pakaian pakaian = new Pakaian(namaPakaian, hargaPakaian, ukuran);
                    daftarProduk.add(pakaian);
                    System.out.println("Produk pakaian ditambahkan!");
                    break;
                case 3:
                    if (daftarProduk.isEmpty()){
                        System.out.println("Belum ada produk di toko");
                    } else {
                        for (Produk produk : daftarProduk){
                            System.out.println(produk.deskripsi());
                        }
                        System.out.println("Total produk: " + Produk.jumlahProduk);
                    }
                    break;

                    default:
                        System.out.println("Pilihan tidak valid! ");
            }

        }
        input.close();
    }
}