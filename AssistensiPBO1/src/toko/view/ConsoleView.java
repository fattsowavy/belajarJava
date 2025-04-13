package toko.view;

import toko.model.Order;
import toko.model.Produk;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void tampilkanMenuUtama() {
        System.out.println("\n=== Menu Utama ===");
        System.out.println("1. Sign Up");
        System.out.println("2. Sign In");
        System.out.println("3. Lihat Katalog");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");
    }

    public void tampilkanMenuDaftar() {
        System.out.println("\nDaftar Sebagai:");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("3. Batal");
        System.out.print("Pilih: ");
    }

    public record FormDaftarData(String nama, String username, String password, String lanjut) {}

    public FormDaftarData tampilkanFormDaftar() {
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Ingin mendaftar lagi? (Ya/Tidak): ");
        String lanjut = scanner.nextLine();
        return new FormDaftarData(nama, username, password, lanjut);
    }

    public record FormLoginData(String username, String password) {}

    public FormLoginData tampilkanFormLogin() {
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();
        return new FormLoginData(username, password);
    }

    public void tampilkanMenuAdmin() {
        System.out.println("\n=== Menu Admin ===");
        System.out.println("1. Sign-Out");
        System.out.println("2. Kelola Produk");
        System.out.println("3. Lihat Semua Order");
        System.out.print("Pilih menu: ");
    }

    public void tampilkanMenuUser() {
        System.out.println("\n=== Menu User ===");
        System.out.println("1. Sign-Out");
        System.out.println("2. Lihat Katalog");
        System.out.println("3. Kelola Order");
        System.out.print("Pilih menu: ");
    }

    public void tampilkanMenuKelolaProduk() {
        System.out.println("\n=== Kelola Produk ===");
        System.out.println("1. Insert Produk");
        System.out.println("2. Show Produk");
        System.out.println("3. Delete Produk");
        System.out.println("4. Update Produk");
        System.out.println("5. Kembali");
        System.out.print("Pilih menu: ");
    }

    public record FormTambahProdukData(String nama, int harga, int stok) {}

    public FormTambahProdukData tampilkanFormTambahProduk() {
        System.out.print("Nama produk: ");
        String nama = scanner.nextLine();
        System.out.print("Harga: ");
        int harga = scanner.nextInt();
        System.out.print("Stok: ");
        int stok = scanner.nextInt();
        scanner.nextLine();
        return new FormTambahProdukData(nama, harga, stok);
    }

    public record FormEditProdukData(int idx, int hargaBaru, int tambahStok) {}

    public FormEditProdukData tampilkanFormEditProduk() {
        System.out.print("Pilih produk: ");
        int idx = scanner.nextInt();
        System.out.print("Harga baru: ");
        int hargaBaru = scanner.nextInt();
        System.out.print("Jumlah stok yang ditambahkan: ");
        int tambahStok = scanner.nextInt();
        scanner.nextLine();
        return new FormEditProdukData(idx, hargaBaru, tambahStok);
    }

    public record FormHapusProdukData(int idx) {}

    public FormHapusProdukData tampilkanFormHapusProduk() {
        System.out.print("Pilih produk: ");
        int idx = scanner.nextInt();
        scanner.nextLine();
        return new FormHapusProdukData(idx);
    }

    public void tampilkanMenuOrderUser() {
        System.out.println("\n=== Menu Orderan User ===");
        System.out.println("1. Tambah Orderan");
        System.out.println("2. Lihat Orderan Saya");
        System.out.println("3. Kembali");
        System.out.print("Pilih menu: ");
    }

    public record FormTambahOrderData(int idx, int jumlah) {}

    public ArrayList<FormTambahOrderData> tampilkanFormTambahOrder() {
        ArrayList<FormTambahOrderData> items = new ArrayList<>();
        String lanjut;
        do {
            System.out.print("Pilih produk (0 untuk selesai): ");
            int idx = scanner.nextInt();
            if (idx == 0) break;
            System.out.print("Jumlah: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();
            items.add(new FormTambahOrderData(idx, jumlah));
            System.out.print("Tambah produk lain? (Ya/Tidak): ");
            lanjut = scanner.nextLine();
        } while (lanjut.equalsIgnoreCase("Ya"));
        return items;
    }

    public void tampilkanProduk(ArrayList<Produk> daftarProduk) {
        System.out.println("\n=== Daftar Produk ===");
        if (daftarProduk.isEmpty()) {
            System.out.println("Belum ada produk.");
        } else {
            for (int i = 0; i < daftarProduk.size(); i++) {
                System.out.println((i + 1) + ". " + daftarProduk.get(i));
            }
        }
    }

    public void tampilkanOrder(ArrayList<Order> daftarOrder, String username) {
        System.out.println("\n=== Orderan Anda ===");
        boolean adaOrder = false;
        for (Order o : daftarOrder) {
            if (o.getUsername().equals(username)) {
                System.out.println(o);
                adaOrder = true;
            }
        }
        if (!adaOrder) {
            System.out.println("Belum ada order.");
        }
    }

    public void tampilkanSemuaOrder(ArrayList<Order> daftarOrder) {
        System.out.println("\n=== Daftar Orderan ===");
        if (daftarOrder.isEmpty()) {
            System.out.println("Belum ada order.");
        } else {
            for (Order o : daftarOrder) {
                System.out.println(o);
            }
        }
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
}