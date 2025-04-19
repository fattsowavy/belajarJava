package ECommerce;

import java.util.ArrayList;

public class Cart {

    private ArrayList<CartProduct> products;

    public Cart() {
        products = new ArrayList<CartProduct>();
    }

    public Cart(ArrayList<CartProduct> products) {
        this.products = products;
    }

    public ArrayList<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<CartProduct> products) {
        this.products = products;
    }

    public double calculateTotal(){
        return products.stream().mapToDouble(cp -> cp.getPrice() * cp.getQuantity()).sum();
    }
}
