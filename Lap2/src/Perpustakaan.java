import java.util.ArrayList;
import java.util.Scanner;

class Buku {
    String judul;
    String penulis;
    boolean dipinjam;
    String peminjam;
    String tanggalPeminjaman;

    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
        this.dipinjam = false;
    }
}

public class Perpustakaan {
    private static ArrayList<Buku> koleksiBuku = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        tampilkanMenu();
    }

    private static void tampilkanMenu() {
        int pilihan;
        do {
            System.out.println("\n=== MENU PERPUSTAKAAN ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Semua Buku");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Lihat Buku Dipinjam");
            System.out.println("5. Kembalikan Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");

            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1: tambahBuku(); break;
                case 2: tampilkanBuku(); break;
                case 3: pinjamBuku(); break;
                case 4: tampilkanBukuDipinjam(); break;
                case 5: kembalikanBuku(); break;
                case 0: System.out.println("Terima kasih!"); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    private static void tambahBuku() {
        System.out.print("Judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Penulis: ");
        String penulis = scanner.nextLine();

        koleksiBuku.add(new Buku(judul, penulis));
        System.out.println("Buku berhasil ditambahkan!");
    }

    private static void tampilkanBuku() {
        if (koleksiBuku.isEmpty()) {
            System.out.println("Belum ada buku di perpustakaan.");
            return;
        }

        System.out.println("\nDaftar Buku:");
        for (int i = 0; i < koleksiBuku.size(); i++) {
            Buku buku = koleksiBuku.get(i);
            String status = buku.dipinjam ? " (Dipinjam)" : " (Tersedia)";
            System.out.println((i+1) + ". " + buku.judul + " - " + buku.penulis + status);
        }
    }

    private static void pinjamBuku() {
        tampilkanBuku();
        if (koleksiBuku.isEmpty()) return;

        System.out.print("\nPilih nomor buku yang ingin dipinjam: ");
        int nomor = scanner.nextInt();
        scanner.nextLine();

        if (nomor < 1 || nomor > koleksiBuku.size()) {
            System.out.println("Nomor buku tidak valid!");
            return;
        }

        Buku buku = koleksiBuku.get(nomor - 1);

        if (buku.dipinjam) {
            System.out.println("Maaf, buku sudah dipinjam!");
            return;
        }

        System.out.print("Nama peminjam: ");
        buku.peminjam = scanner.nextLine();
        System.out.print("Tanggal pinjam (dd/mm/yyyy): ");
        buku.tanggalPeminjaman = scanner.nextLine();
        buku.dipinjam = true;

        System.out.println("Buku berhasil dipinjam!");
    }

    private static void tampilkanBukuDipinjam() {
        System.out.println("\nBuku yang Sedang Dipinjam:");
        boolean adaPeminjaman = false;

        for (Buku buku : koleksiBuku) {
            if (buku.dipinjam) {
                System.out.println("- " + buku.judul + " dipinjam oleh " + buku.peminjam +
                        " pada " + buku.tanggalPeminjaman);
                adaPeminjaman = true;
            }
        }

        if (!adaPeminjaman) {
            System.out.println("Tidak ada buku yang dipinjam saat ini.");
        }
    }

    private static void kembalikanBuku() {
        tampilkanBukuDipinjam();
        if (koleksiBuku.isEmpty()) return;

        System.out.print("\nPilih nomor buku yang dikembalikan: ");
        int nomor = scanner.nextInt();
        scanner.nextLine();

        if (nomor < 1 || nomor > koleksiBuku.size()) {
            System.out.println("Nomor buku tidak valid!");
            return;
        }

        Buku buku = koleksiBuku.get(nomor - 1);

        if (!buku.dipinjam) {
            System.out.println("Buku ini tidak sedang dipinjam!");
            return;
        }

        System.out.println("Buku '" + buku.judul + "' berhasil dikembalikan.");
        buku.dipinjam = false;
        buku.peminjam = null;
        buku.tanggalPeminjaman = null;
    }
}