package toko.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId; // Nomor urut order
    private String username;
    private List<String> namaProdukList; // Daftar nama produk
    private List<Integer> jumlahList; // Daftar jumlah per produk
    private List<Integer> hargaList; // Daftar harga per produk

    public Order(int orderId, String username) {
        this.orderId = orderId;
        this.username = username;
        this.namaProdukList = new ArrayList<>();
        this.jumlahList = new ArrayList<>();
        this.hargaList = new ArrayList<>();
    }

    public void tambahProduk(String namaProduk, int jumlah, int harga) {
        namaProdukList.add(namaProduk);
        jumlahList.add(jumlah);
        hargaList.add(harga);
    }

    public int getOrderId() {
        return orderId;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getNamaProdukList() {
        return namaProdukList;
    }

    public List<Integer> getJumlahList() {
        return jumlahList;
    }

    @Override
    public String toString() {
        if (namaProdukList.isEmpty()) {
            return "Order #" + orderId + " | Username: " + username + " | Produk: Tidak ada produk";
        }
        StringBuilder produkStr = new StringBuilder();
        for (int i = 0; i < namaProdukList.size(); i++) {
            produkStr.append(namaProdukList.get(i))
                    .append(" (Jumlah: ").append(jumlahList.get(i))
                    .append(", Harga: ").append(hargaList.get(i)).append(")");
            if (i < namaProdukList.size() - 1) {
                produkStr.append(", ");
            }
        }
        return "Order #" + orderId + " | Username: " + username + " | Produk: " + produkStr;
    }
}