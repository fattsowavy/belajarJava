package toko.manager;

import toko.model.Produk;
import toko.view.ConsoleView;

import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Produk> daftarProduk;

    public ProductManager() {
        this.daftarProduk = new ArrayList<>();
    }

    public void kelolaProduk(ConsoleView view) {
        int pilih;
        do {
            view.tampilkanMenuKelolaProduk();
            pilih = view.getScanner().nextInt();
            view.getScanner().nextLine();

            switch (pilih) {
                case 1 -> {
                    ConsoleView.FormTambahProdukData data = view.tampilkanFormTambahProduk();
                    String nama = data.nama();
                    int harga = data.harga();
                    int stok = data.stok();
                    daftarProduk.add(new Produk(nama, harga, stok));
                    view.tampilkanPesan("Produk berhasil ditambahkan.");
                }
                case 2 -> tampilkanProduk(view);
                case 3 -> {
                    tampilkanProduk(view);
                    ConsoleView.FormHapusProdukData data = view.tampilkanFormHapusProduk();
                    int idx = data.idx() - 1; // Konversi ke indeks berbasis 0
                    if (idx >= 0 && idx < daftarProduk.size()) {
                        daftarProduk.remove(idx);
                        view.tampilkanPesan("Produk berhasil dihapus.");
                    } else {
                        view.tampilkanPesan("Produk tidak ditemukan.");
                    }
                }
                case 4 -> {
                    tampilkanProduk(view);
                    ConsoleView.FormEditProdukData data = view.tampilkanFormEditProduk();
                    int idx = data.idx() - 1; // Konversi ke indeks berbasis 0
                    int hargaBaru = data.hargaBaru();
                    int tambahStok = data.tambahStok();
                    if (idx >= 0 && idx < daftarProduk.size()) {
                        Produk p = daftarProduk.get(idx);
                        p.setHarga(hargaBaru);
                        p.tambahStok(tambahStok); // Hanya menambah stok
                        view.tampilkanPesan("Produk berhasil diupdate.");
                    } else {
                        view.tampilkanPesan("Produk tidak ditemukan.");
                    }
                }
                case 5 -> {}
                default -> view.tampilkanPesan("Pilihan tidak valid.");
            }
        } while (pilih != 5);
    }

    public void tampilkanProduk(ConsoleView view) {
        view.tampilkanProduk(daftarProduk);
    }

    public ArrayList<Produk> getDaftarProduk() {
        return daftarProduk;
    }
}