package ECommerce;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

    private int ID;
    private Client client;
    private Seller seller;
    private LocalDateTime orderTime;
    private ArrayList<CartProduct> products;
    private OrderStatus orderStatus;
    private double totalAmount;
    private String paymentMethod;

    public Order() {
        products = new ArrayList<CartProduct>();
    }

    public Order(int ID, Client client, Seller seller, LocalDateTime orderTime, ArrayList<CartProduct> products, OrderStatus orderStatus, double totalAmount, String paymentMethod) {
        this.ID = ID;
        this.client = client;
        this.seller = seller;
        this.orderTime = orderTime;
        this.products = products;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }


}
