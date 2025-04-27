public class Pesanan {
    private String idPesanan;
    private String penerima;
    private String alamatTujuan;
    private Double beratBarang;
    private String status;

    public Pesanan(String idPesanan, String penerima, String alamatTujuan, Double beratBarang, String status) {
        this.idPesanan = idPesanan;
        this.penerima = penerima;
        this.alamatTujuan = alamatTujuan;
        this.beratBarang = beratBarang;
        this.status = "DIPROSES";
    }

    public String getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(String idPesanan) {
        this.idPesanan = idPesanan;
    }

    public String getPenerima() {
        return penerima;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }

    public String getAlamatTujuan() {
        return alamatTujuan;
    }

    public void setAlamatTujuan(String alamatTujuan) {
        this.alamatTujuan = alamatTujuan;
    }

    public Double getBeratBarang() {
        return beratBarang;
    }

    public void setBeratBarang(Double beratBarang) {
        this.beratBarang = beratBarang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pesanan{" +
                "idPesanan='" + idPesanan + '\'' +
                ", penerima='" + penerima + '\'' +
                ", alamatTujuan='" + alamatTujuan + '\'' +
                ", beratBarang=" + beratBarang + " kg" +
                ", status='" + status + '\'' +
                '}';
    }
}
