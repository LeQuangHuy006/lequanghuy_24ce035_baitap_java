package MODER;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int id;
    private int customerId;
    private LocalDateTime orderDate;
    private List<OrderItem> items;

    public Order() {}

    public Order(int customerId, LocalDateTime orderDate, List<OrderItem> items) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.items = items;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}

