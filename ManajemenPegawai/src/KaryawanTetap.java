class KaryawanTetap extends Pegawai implements Tunjangan {
    private double gajiPokok;
    private double tunjangan;

    public KaryawanTetap(String nama, int id, double gajiPokok, double tunjangan) {
        super(nama, id);
        this.gajiPokok = gajiPokok;
        this.tunjangan = tunjangan;
    }

    @Override
    void kerja() {
        System.out.println(nama + " bekerja secara full-time sebagai karyawan tetap");
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + tunjangan;
    }
}
