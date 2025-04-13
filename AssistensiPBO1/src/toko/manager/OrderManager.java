package toko.manager;

import toko.model.Order;
import toko.model.Produk;
import toko.model.User;
import toko.view.ConsoleView;

import java.util.ArrayList;

public class OrderManager {
    private ArrayList<Order> daftarOrder;
    private int nextOrderId; // Untuk menghasilkan orderId secara berurutan

    public OrderManager() {
        this.daftarOrder = new ArrayList<>();
        this.nextOrderId = 1; // Mulai dari 1
    }

    public void kelolaOrderUser(User user, ConsoleView view, ProductManager productManager) {
        int pilih;
        do {
            view.tampilkanMenuOrderUser();
            pilih = view.getScanner().nextInt();
            view.getScanner().nextLine();

            switch (pilih) {
                case 1 -> {
                    productManager.tampilkanProduk(view);
                    ArrayList<ConsoleView.FormTambahOrderData> items = view.tampilkanFormTambahOrder();
                    if (items.isEmpty()) {
                        view.tampilkanPesan("Tidak ada produk yang dipilih.");
                        break;
                    }
                    Order order = new Order(nextOrderId++, user.getUsername());
                    boolean valid = true;
                    // Validasi stok untuk semua item
                    for (ConsoleView.FormTambahOrderData data : items) {
                        int idx = data.idx() - 1; // Konversi ke indeks berbasis 0
                        int jumlah = data.jumlah();
                        if (idx < 0 || idx >= productManager.getDaftarProduk().size()) {
                            view.tampilkanPesan("Produk dengan indeks " + (idx + 1) + " tidak ditemukan.");
                            valid = false;
                            break;
                        }
                        Produk p = productManager.getDaftarProduk().get(idx);
                        if (!p.kurangiStok(jumlah)) {
                            view.tampilkanPesan("Stok tidak cukup untuk " + p.getNama() + ".");
                            valid = false;
                            break;
                        }
                        order.tambahProduk(p.getNama(), jumlah, p.getHarga()); // Simpan harga
                    }
                    if (valid && !order.getNamaProdukList().isEmpty()) {
                        daftarOrder.add(order);
                        view.tampilkanPesan("Order berhasil ditambahkan.");
                    } else {
                        // Kembalikan stok jika order gagal
                        for (ConsoleView.FormTambahOrderData data : items) {
                            int idx = data.idx() - 1;
                            int jumlah = data.jumlah();
                            if (idx >= 0 && idx < productManager.getDaftarProduk().size()) {
                                Produk p = productManager.getDaftarProduk().get(idx);
                                p.tambahStok(jumlah); // Menggunakan tambahStok
                            }
                        }
                        if (valid) {
                            view.tampilkanPesan("Order dibatalkan karena tidak ada produk valid.");
                        }
                    }
                }
                case 2 -> view.tampilkanOrder(daftarOrder, user.getUsername());
                case 3 -> {}
                default -> view.tampilkanPesan("Pilihan tidak valid.");
            }
        } while (pilih != 3);
    }

    public void tampilkanSemuaOrder(ConsoleView view) {
        view.tampilkanSemuaOrder(daftarOrder);
    }
}