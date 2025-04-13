package toko.controller;

import toko.manager.AuthManager;
import toko.manager.OrderManager;
import toko.manager.ProductManager;
import toko.model.Admin;
import toko.model.Account;
import toko.model.User;
import toko.view.ConsoleView;

public class AplikasiController {
    private ConsoleView view;
    private AuthManager authManager;
    private ProductManager productManager;
    private OrderManager orderManager;
    private Account penggunaAktif;

    public AplikasiController(ConsoleView view, AuthManager authManager, ProductManager productManager, OrderManager orderManager) {
        this.view = view;
        this.authManager = authManager;
        this.productManager = productManager;
        this.orderManager = orderManager;
        this.penggunaAktif = null;
    }

    public void jalankan() {
        int pilih;
        do {
            view.tampilkanMenuUtama();
            pilih = view.getScanner().nextInt();
            view.getScanner().nextLine();

            switch (pilih) {
                case 1 -> daftar();
                case 2 -> login();
                case 3 -> productManager.tampilkanProduk(view);
                case 4 -> view.tampilkanPesan("Terima kasih!");
                default -> view.tampilkanPesan("Pilihan tidak valid.");
            }
        } while (pilih != 4);
    }

    private void daftar() {
        int pilih;
        do {
            view.tampilkanMenuDaftar();
            pilih = view.getScanner().nextInt();
            view.getScanner().nextLine();

            if (pilih == 1 || pilih == 2) {
                ConsoleView.FormDaftarData data;
                do {
                    data = view.tampilkanFormDaftar();
                    if (authManager.isUsernameTaken(data.username())) {
                        view.tampilkanPesan("Username sudah digunakan.");
                        continue;
                    }
                    Account pengguna = (pilih == 1)
                            ? new Admin(data.nama(), data.username(), data.password())
                            : new User(data.nama(), data.username(), data.password());
                    authManager.tambahPengguna(pengguna);
                    view.tampilkanPesan("Pendaftaran berhasil!");
                } while (data.lanjut().equalsIgnoreCase("Ya"));
            } else if (pilih != 3) {
                view.tampilkanPesan("Pilihan tidak valid.");
            }
        } while (pilih != 3);
    }

    private void login() {
        ConsoleView.FormLoginData data = view.tampilkanFormLogin();
        penggunaAktif = authManager.login(data.username(), data.password());
        if (penggunaAktif != null) {
            view.tampilkanPesan("Login berhasil sebagai " + (penggunaAktif instanceof Admin ? "Admin" : penggunaAktif.getNama()));
            if (penggunaAktif instanceof Admin) {
                menuAdmin();
            } else {
                menuUser();
            }
        } else {
            view.tampilkanPesan("Login gagal. Username atau password salah.");
        }
    }

    private void menuAdmin() {
        int pilih;
        do {
            view.tampilkanMenuAdmin();
            pilih = view.getScanner().nextInt();
            view.getScanner().nextLine();

            switch (pilih) {
                case 1 -> penggunaAktif = null; // Sign-out
                case 2 -> productManager.kelolaProduk(view);
                case 3 -> orderManager.tampilkanSemuaOrder(view); // Admin melihat semua order
                default -> view.tampilkanPesan("Pilihan tidak valid.");
            }
        } while (pilih != 1 && penggunaAktif != null);
    }

    private void menuUser() {
        int pilih;
        do {
            view.tampilkanMenuUser();
            pilih = view.getScanner().nextInt();
            view.getScanner().nextLine();

            switch (pilih) {
                case 1 -> penggunaAktif = null; // Sign-out
                case 2 -> productManager.tampilkanProduk(view);
                case 3 -> orderManager.kelolaOrderUser((User) penggunaAktif, view, productManager); // User hanya melihat order sendiri
                default -> view.tampilkanPesan("Pilihan tidak valid.");
            }
        } while (pilih != 1 && penggunaAktif != null);
    }
}