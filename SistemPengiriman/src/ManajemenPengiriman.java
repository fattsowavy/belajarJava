import java.util.HashMap;
import java.util.Map;

public class ManajemenPengiriman {
    private HashMap<String, Pesanan> daftarPesanan;

    public ManajemenPengiriman() {
        daftarPesanan = new HashMap<>();
    }

    public void addPesanan(String idPesanan, Pesanan pesanan) {
        if (daftarPesanan.containsKey(idPesanan)) {
            System.out.println("ID Tidak Valid!");
        } else {
            daftarPesanan.put(idPesanan, pesanan);
            System.out.println("Pesanan " + idPesanan + " berhasil dibuat!");
        }
    }

    public void trackPesanan(String idPesanan) {
        Pesanan pesanan = daftarPesanan.get(idPesanan);
        if (pesanan != null) {
            System.out.println("\n=== Informasi Pesanan ===");
            System.out.println(pesanan);
        } else {
            System.out.println("Pesanan " + idPesanan + " tidak ditemukan!");
        }
    }

    public void updateStatus(String idPesanan, String status) {
        Pesanan pesanan = daftarPesanan.get(idPesanan);
        if (pesanan != null) {
            pesanan.setStatus(status);
            System.out.println("Pesanan " + idPesanan + " berhasil diupdate!");
        } else {
            System.out.println("Pesanan " + idPesanan + " tidak ditemukan!");
        }
    }

    public void showPesanan(){
        if (daftarPesanan.isEmpty()){
            System.out.println("Belum ada pesanan!");
        } else {
            System.out.println("\n=== Informasi Pesanan ===");
            for (Map.Entry<String, Pesanan> entry : daftarPesanan.entrySet()){
                System.out.println(entry);
            }
        }
    }
}
