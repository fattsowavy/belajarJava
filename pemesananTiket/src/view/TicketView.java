package view;

import model.Ticket;
import java.util.Map;
import java.util.Scanner;

public class TicketView {
    private Scanner scanner;

    public TicketView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n=== Sistem Pemesanan Tiket ===");
        System.out.println("1. Lihat Semua Tiket");
        System.out.println("2. Lihat Tiket Tersedia");
        System.out.println("3. Pesan Tiket");
        System.out.println("4. Batalkan Pesanan");
        System.out.println("5. Lihat Detail Tiket");
        System.out.println("0. Keluar");
        System.out.print("Pilihan: ");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public String getTicketIdInput() {
        System.out.print("Masukkan ID Tiket: ");
        return scanner.next();
    }

    public String getCustomerNameInput() {
        System.out.print("Masukkan Nama Pemesan: ");
        scanner.nextLine(); // Membersihkan newline sebelumnya
        return scanner.nextLine();
    }

    public void displayTickets(Map<String, Ticket> tickets) {
        if (tickets.isEmpty()) {
            System.out.println("Tidak ada tiket yang tersedia.");
        } else {
            System.out.println("\n=== Daftar Tiket ===");
            for (Ticket ticket : tickets.values()) {
                System.out.println(ticket);
                System.out.println("---------------------");
            }
        }
    }

    public void displayTicketDetails(Ticket ticket) {
        System.out.println("\n=== Detail Tiket ===");
        System.out.println(ticket);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void close() {
        scanner.close();
    }
}