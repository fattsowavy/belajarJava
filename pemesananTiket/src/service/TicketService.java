package service;

import model.Ticket;
import java.util.HashMap;
import java.util.Map;

public class TicketService {
    private Map<String, Ticket> ticketMap;

    public TicketService() {
        this.ticketMap = new HashMap<>();
        initializeSampleTickets();
    }

    private void initializeSampleTickets() {
        addTicket(new Ticket("T001", "Konser Coldplay", "A1", 150.0));
        addTicket(new Ticket("T002", "Konser Coldplay", "A2", 150.0));
        addTicket(new Ticket("T003", "Teater Romeo & Juliet", "B1", 75.0));
        addTicket(new Ticket("T004", "Teater Romeo & Juliet", "B2", 75.0));
        addTicket(new Ticket("T005", "Pameran Seni Modern", "GA1", 25.0));
    }

    public void addTicket(Ticket ticket) {
        ticketMap.put(ticket.getTicketId(), ticket);
    }

    public Ticket getTicket(String ticketId) {
        return ticketMap.get(ticketId);
    }

    public boolean bookTicket(String ticketId, String customerName) {
        Ticket ticket = ticketMap.get(ticketId);
        if (ticket != null && !ticket.isBooked()) {
            ticket.bookTicket(customerName);
            return true;
        }
        return false;
    }

    public boolean cancelTicket(String ticketId) {
        Ticket ticket = ticketMap.get(ticketId);
        if (ticket != null && ticket.isBooked()) {
            ticket.cancelBooking();
            return true;
        }
        return false;
    }

    public Map<String, Ticket> getAllTickets() {
        return new HashMap<>(ticketMap);
    }

    public Map<String, Ticket> getAvailableTickets() {
        Map<String, Ticket> availableTickets = new HashMap<>();
        for (Map.Entry<String, Ticket> entry : ticketMap.entrySet()) {
            if (!entry.getValue().isBooked()) {
                availableTickets.put(entry.getKey(), entry.getValue());
            }
        }
        return availableTickets;
    }

    public double getTotalRevenue() {
        return ticketMap.values().stream()
                .filter(Ticket::isBooked)
                .mapToDouble(Ticket::getPrice)
                .sum();
    }

    public int getTotalBookedTickets() {
        return (int) ticketMap.values().stream()
                .filter(Ticket::isBooked)
                .count();
    }
}