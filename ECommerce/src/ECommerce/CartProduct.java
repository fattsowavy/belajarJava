package ECommerce;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CartProduct extends Product{

    private int quantity;
    private LocalDateTime timeAdded;
    private OrderStatus itemStatus;

    public CartProduct(){
        timeAdded = LocalDateTime.now();
    }

    public CartProduct(int quantity, LocalDateTime timeAdded, OrderStatus itemStatus) {
        this.quantity = quantity;
        this.timeAdded = timeAdded;
        this.itemStatus = itemStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(LocalDateTime timeAdded) {
        this.timeAdded = timeAdded;
    }

    public String getFormattedDateAdded() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(timeAdded);
    }

    public String getFormattedTimeAdded() {
        return DateTimeFormatter.ofPattern("hh:mm").format(timeAdded);
    }

    public boolean canAddToCart() {
        return getStockQuantity() >= getQuantity();
    }

    public OrderStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(OrderStatus itemStatus) {
        this.itemStatus = itemStatus;
    }
}
