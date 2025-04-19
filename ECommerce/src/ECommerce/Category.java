package ECommerce;

import java.util.ArrayList;

public class Category {

    private int ID;
    private String name;
    private String description;
    private ArrayList<Product> products;

    public Category() {
        products = new ArrayList<Product>();
    }

    public Category(int ID, String name, String description, ArrayList<Product> products) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.products = products;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
