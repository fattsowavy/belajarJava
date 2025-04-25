package model;

public class Ticket {
    private String ticketId;
    private String eventName;
    private String customerName;
    private String seatNumber;
    private double price;
    private boolean isBooked;

    public Ticket(String ticketId, String eventName, String seatNumber, double price) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = false;
        this.customerName = "";
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookTicket(String customerName) {
        this.customerName = this.customerName;
        this.isBooked = true;
    }

    public void cancelBooking() {
        this.isBooked = false;
        this.customerName = "";
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ID='" + ticketId + '\'' +
                ", Event='" + eventName + '\'' +
                ", Seat='" + seatNumber + '\'' +
                ", Price=" + price + '\'' +
                ", Status=" + (isBooked ? "Booked by " + customerName : "Available") +
                '}';
    }
}
