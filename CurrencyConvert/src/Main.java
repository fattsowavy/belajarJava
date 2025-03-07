import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        // Tambah mata uang awal (opsional)
        converter.addCurrency("GBP", 21000.0);

        System.out.println("Selamat datang di Currency Converter!");
        System.out.println("Mata uang yang tersedia: IDR, USD, EUR, GBP");
        System.out.println("Ketik 'exit' untuk keluar.");

        while (true) {
            // Input jumlah
            System.out.print("Masukkan jumlah uang (contoh: 100): ");
            String amountInput = scanner.nextLine();

            // Cek jika pengguna ingin keluar
            if (amountInput.equalsIgnoreCase("exit")) {
                System.out.println("Terima kasih telah menggunakan Currency Converter!");
                break;
            }

            double amount;
            try {
                amount = Double.parseDouble(amountInput);
                if (amount < 0) {
                    System.out.println("Jumlah tidak boleh negatif!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan jumlah yang valid!");
                continue;
            }

            // Input mata uang asal
            System.out.print("Masukkan mata uang asal (contoh: IDR): ");
            String fromCurrency = scanner.nextLine().toUpperCase();

            // Input mata uang tujuan
            System.out.print("Masukkan mata uang tujuan (contoh: USD): ");
            String toCurrency = scanner.nextLine().toUpperCase();

            // Lakukan konversi
            converter.printConversion(amount, fromCurrency, toCurrency);

            // Tanyakan apakah ingin update nilai tukar
            System.out.print("Apakah Anda ingin update nilai tukar? (ya/tidak): ");
            String updateChoice = scanner.nextLine().toLowerCase();
            if (updateChoice.equals("ya")) {
                System.out.print("Masukkan kode mata uang (contoh: USD): ");
                String code = scanner.nextLine().toUpperCase();
                System.out.print("Masukkan nilai tukar baru: ");
                double newRate;
                try {
                    newRate = Double.parseDouble(scanner.nextLine());
                    converter.updateCurrency(code, newRate);
                    System.out.println("Nilai tukar " + code + " diperbarui!");
                } catch (NumberFormatException e) {
                    System.out.println("Masukkan nilai tukar yang valid!");
                }
            }
            System.out.println("-------------------");
        }

        scanner.close();
    }
}