package toko;

import toko.controller.AplikasiController;
import toko.manager.AuthManager;
import toko.manager.OrderManager;
import toko.manager.ProductManager;
import toko.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        AuthManager authManager = new AuthManager();
        ProductManager productManager = new ProductManager();
        OrderManager orderManager = new OrderManager();
        AplikasiController controller = new AplikasiController(view, authManager, productManager, orderManager);
        controller.jalankan();
    }
}