abstract class Pegawai {
    protected String nama;
    protected int id;

    Pegawai(String nama, int id) {
        this.nama = nama;
        this.id = id;
    }

    abstract void kerja();

    void infoPegawai() {
        System.out.println("ID: " + id + ", Nama: " + nama);
    }
}
