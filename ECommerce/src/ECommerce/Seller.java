package ECommerce;

import java.util.ArrayList;

public class Seller {
    private int soldItemCount;
    private double profit;
    private String sellerName;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;

    public Seller(){
        products = new ArrayList<Product>();
    }

    public Seller(int soldItemCount, double profit, String sellerName, ArrayList<Product> products, ArrayList<Order> orders) {
        this.soldItemCount = soldItemCount;
        this.profit = profit;
        this.sellerName = sellerName;
        this.products = products;
        this.orders = orders;
    }

    public int getSoldItemCount() {
        return soldItemCount;
    }

    public void setSoldItemCount(int soldItemCount) {
        this.soldItemCount = soldItemCount;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
