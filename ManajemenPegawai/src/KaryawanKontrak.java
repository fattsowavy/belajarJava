class KaryawanKontrak extends Pegawai implements Tunjangan {
    private double tarifPerJam;
    private double jamKerja;

    public KaryawanKontrak(String nama, int id, double tarifPerJam, double jamKerja) {
        super(nama, id);
        this.tarifPerJam = tarifPerJam;
        this.jamKerja = jamKerja;
    }

    @Override
    void kerja() {
        System.out.println(nama + " bekerja secara kontrak berdasarkan jam kerja.");
    }

    @Override
    public double hitungGaji() {
        return tarifPerJam * jamKerja;
    }
}
