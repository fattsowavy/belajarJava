import controller.TicketController;
import service.TicketService;
import view.TicketView;

public class Main {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        TicketView ticketView = new TicketView();
        TicketController ticketController = new TicketController(ticketService, ticketView);

        boolean running = true;
        while (running) {
            ticketView.displayMenu();
            int choice = ticketView.getUserChoice();

            switch (choice) {
                case 1:
                    ticketController.displayAllTickets();
                    break;
                case 2:
                    ticketController.displayAvailableTickets();
                    break;
                case 3:
                    String ticketId = ticketView.getTicketIdInput();
                    String customerName = ticketView.getCustomerNameInput();
                    ticketController.bookTicket(ticketId, customerName);
                    break;
                case 4:
                    ticketId = ticketView.getTicketIdInput();
                    ticketController.cancelTicket(ticketId);
                    break;
                case 5:
                    ticketId = ticketView.getTicketIdInput();
                    ticketController.showTicketDetails(ticketId);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    ticketView.displayMessage("Pilihan tidak valid!");
            }
        }

        ticketView.displayMessage("Terima kasih telah menggunakan sistem pemesanan tiket!");
        ticketView.close();
    }
}