import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManajemenPengiriman manage = new ManajemenPengiriman();

        while (true) {
            System.out.println("\n === Sistem Pengiriman ===");
            System.out.println("1. Tambah Pengiriman");
            System.out.println("2. Lacak Pengiriman");
            System.out.println("3. Update Status Pengiriman");
            System.out.println("4. Tampilkan Semua Pengiriman");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            int select = input.nextInt();
            input.nextLine();

            switch (select) {
                case 1:
                    System.out.print("Masukkan ID Pengiriman: ");
                    String id = input.nextLine();
                    System.out.print("Masukkan Nama Penerima: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan Alamat Pengiriman: ");
                    String alamat = input.nextLine();
                    System.out.print("Masukkan Berat Barang: ");
                    double berat = input.nextDouble();
                    input.nextLine();
                    break;

                case 2:
                    System.out.print("Masukkan ID Pengiriman: ");
                    id = input.nextLine();
                    manage.trackPesanan(id);
                    break;
                case 3:
                    System.out.print("Masukkan ID Pesanan: ");
                    id = input.nextLine();
                    System.out.print("Masukkan Status Baru (DIPROSES/DIKIRIM/DITERIMA): ");
                    String status = input.nextLine();
                    manage.updateStatus(id, status);
                    break;

                case 4:
                    manage.showPesanan();
                    break;

                case 5:
                    System.out.println("Keluar dari sistem...");
                    input.close();
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}