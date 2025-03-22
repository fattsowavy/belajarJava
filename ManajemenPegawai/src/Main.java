public class Main {
    public static void main(String[] args)
    {
        KaryawanTetap pegawai1 = new KaryawanTetap("Fatwa" , 1511, 35000000, 15000000);
        pegawai1.infoPegawai();
        pegawai1.kerja();
        System.out.println("Gaji: Rp " + String.format("%,.0f", pegawai1.hitungGaji()));

        System.out.println();

        KaryawanKontrak pegawai2 = new KaryawanKontrak("Jeruk", 4011,  50000, 160);
        pegawai2.infoPegawai();
        pegawai2.kerja();
        System.out.println("Gaji: Rp " + pegawai2.hitungGaji());
    }
}