import java.util.Scanner;

public class Modul2 {

    // Menghitung total penjualan per jenis baju
    public int[] hitungTotalPenjualanPerJenisBaju(int[][] data) {
        int[] totalPenjualanJenisBaju = new int[data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                totalPenjualanJenisBaju[j] += data[i][j];
            }
        }
        return totalPenjualanJenisBaju;
    }

    // Menghitung total penjualan selama seminggu
    public int hitungTotalPenjualanSelamaSatuMinggu(int[][] data) {
        int[] totalPerJenis = hitungTotalPenjualanPerJenisBaju(data);
        int total = 0;
        for (int t : totalPerJenis) {
            total += t;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah hari: ");
        int hari = input.nextInt();
        System.out.print("Masukkan jumlah jenis baju: ");
        int jenis = input.nextInt();

        int[][] dataPenjualan = new int[hari][jenis];

        // Input data penjualan
        for (int i = 0; i < hari; i++) {
            for (int j = 0; j < jenis; j++) {
                System.out.print("Penjualan hari ke-" + (i + 1) + ", jenis ke-" + (j + 1) + ": ");
                dataPenjualan[i][j] = input.nextInt();
            }
        }

        // Membuat objek untuk memanggil metode
        Modul2 penjualan = new Modul2();

        int[] totalPerJenis = penjualan.hitungTotalPenjualanPerJenisBaju(dataPenjualan);
        int total = penjualan.hitungTotalPenjualanSelamaSatuMinggu(dataPenjualan);

        // Menampilkan hasil
        for (int i = 0; i < totalPerJenis.length; i++) {
            System.out.println("Total Penjualan Baju Jenis " + (char) ('A' + i) + ": " + totalPerJenis[i]);
        }

        System.out.println("Total penjualan selama satu minggu: " + total);
    }
}
