package ECommerce;

import java.util.ArrayList;

public class Client {

    private ArrayList<Order> previousOrders;
    private Cart cart;
    private String address;
    private String paymentDetails;

    public Client() {
        previousOrders = new ArrayList<>();
    }

    public Client(ArrayList<Order> previousOrders, Cart cart, String address, String paymentDetails) {
        this.previousOrders = previousOrders;
        this.cart = cart;
        this.address = address;
        this.paymentDetails = paymentDetails;
    }

    public ArrayList<Order> getPreviousOrders() {
        return previousOrders;
    }

    public void setPreviousOrders(ArrayList<Order> previousOrders) {
        this.previousOrders = previousOrders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
