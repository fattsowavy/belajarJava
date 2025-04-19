package ECommerce;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

    private int ID;
    private Client client;
    private Seller seller;
    private LocalDateTime orderTime;
    private ArrayList<CartProduct> products;
    private double totalAmount;
    private String paymentMethod;

    public Order() {
        products = new ArrayList<CartProduct>();
    }

    public Order(int ID, Client client, Seller seller, LocalDateTime orderTime, ArrayList<CartProduct> products, double totalAmount, String paymentMethod) {
        this.ID = ID;
        this.client = client;
        this.seller = seller;
        this.orderTime = orderTime;
        this.products = products;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public ArrayList<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<CartProduct> products) {
        this.products = products;
    }

    public OrderStatus getOrderStatus() {

        OrderStatus status = OrderStatus.DELIVERED;

        int cancelled = 0;
        for (CartProduct product : products) {
            if (product.getItemStatus().equals(OrderStatus.SHIPPED)) status = OrderStatus.SHIPPED;
            if (product.getItemStatus().equals(OrderStatus.PENDING)) status = OrderStatus.PENDING;
            if (product.getItemStatus().equals(OrderStatus.CANCELLED)) cancelled++;
        }

            if (cancelled == products.size()) return OrderStatus.CANCELLED;
            else return status;
    }



    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void calculateTotalAmount() {
        this.totalAmount = products.stream().mapToDouble(cp -> cp.getPrice() * cp.getQuantity()).sum();
    }
}
