package controller;

import model.Ticket;
import service.TicketService;
import view.TicketView;

public class TicketController {
    private TicketService ticketService;
    private TicketView ticketView;

    public TicketController(TicketService ticketService, TicketView ticketView) {
        this.ticketService = ticketService;
        this.ticketView = ticketView;
    }

    public void displayAllTickets() {
        ticketView.displayTickets(ticketService.getAllTickets());
    }

    public void displayAvailableTickets() {
        ticketView.displayTickets(ticketService.getAvailableTickets());
    }

    public void bookTicket(String ticketId, String customerName) {
        boolean success = ticketService.bookTicket(ticketId, customerName);
        if (success) {
            ticketView.displayMessage("Ticket " + ticketId + " berhasil dipesan untuk " + customerName);
        } else {
            ticketView.displayMessage("Gagal memesan ticket " + ticketId + ". Mungkin sudah dipesan atau tidak tersedia.");
        }
    }

    public void cancelTicket(String ticketId) {
        boolean success = ticketService.cancelTicket(ticketId);
        if (success) {
            ticketView.displayMessage("Pembatalan ticket " + ticketId + " berhasil");
        } else {
            ticketView.displayMessage("Gagal membatalkan ticket " + ticketId + ". Mungkin belum dipesan.");
        }
    }

    public void showTicketDetails(String ticketId) {
        Ticket ticket = ticketService.getTicket(ticketId);
        if (ticket != null) {
            ticketView.displayTicketDetails(ticket);
        } else {
            ticketView.displayMessage("Ticket dengan ID " + ticketId + " tidak ditemukan");
        }
    }
}