import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        OnlineStore store = new OnlineStore();
        int pilihan;

        System.out.println("Masukkan Nama Barang: ");
        System.out.println("Masukkan Harga Barang: ");
        System.out.print("Pilih Metode Pembayaran : \n1. Kartu Kredit \n2. Tranfer Bank \n3. E-Wallet");
        pilihan = input.nextInt();
        input.nextLine();

        switch (pilihan) {
            case 1:
                int noKartu ,harga;
                double total;
                String namaKartu;
                System.out.print("Masukkan Nomor Kartu: ");
                noKartu = input.nextInt();
                input.nextLine();
                System.out.println("Masukkan Nama Anda: ");
                namaKartu = input.nextLine();
                System.out.println("Masukkan Jumlah Pembyaran: ");
                total = input.nextDouble();
                PaymentMethod creditcard = new CreditCard(Integer.toString(noKartu),namaKartu);
                store.setPaymentMethod(creditcard);
                store.checkout(total);
        }

    }
}