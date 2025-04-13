public class Main {
    int[][] dataPenjualan = {
            {10, 20, 30},
            {15, 25, 35},
            {20, 30, 40},
            {25, 35, 45},
            {30, 40, 50},
            {35, 45, 55},
            {40, 50, 60}
    };

    public int[] hitungTotalPenjualanPerJenisBaju() {
        int[] totalPenjualanJenisBaju = new int[dataPenjualan[0].length];
        for (int i = 0; i < dataPenjualan.length; i++) { // Perbaikan: i < 6 atau dataPenjualan.length
            for (int j = 0; j < dataPenjualan[i].length; j++) {
                totalPenjualanJenisBaju[j] += dataPenjualan[i][j];
            }
        }
        return totalPenjualanJenisBaju;
    }

    public int hitungTotalPenjualanSelamaSatuMinggu() {
        int[] totalPenjualanPerJenisBaju = hitungTotalPenjualanPerJenisBaju();
        int totalPenjualan = 0;
        for (int i = 0; i < totalPenjualanPerJenisBaju.length; i++) {
            totalPenjualan  += totalPenjualanPerJenisBaju[i]; // Perbaikan: jumlahkan ke total
        }
        return totalPenjualan;
    }

    public static void main(String[] args) {
        Main penjualanBaju = new Main();
        int[] totalPenjualanPerJenisBaju = penjualanBaju.hitungTotalPenjualanPerJenisBaju();
        int totalPenjualan = penjualanBaju.hitungTotalPenjualanSelamaSatuMinggu();

        System.out.println("Total Penjualan Baju Jenis A: " + totalPenjualanPerJenisBaju[0]);
        System.out.println("Total Penjualan Baju Jenis B: " + totalPenjualanPerJenisBaju[1]);
        System.out.println("Total Penjualan Baju Jenis C: " + totalPenjualanPerJenisBaju[2]);
        System.out.println("Total penjualan selama satu minggu: " + totalPenjualan);
    }
}

