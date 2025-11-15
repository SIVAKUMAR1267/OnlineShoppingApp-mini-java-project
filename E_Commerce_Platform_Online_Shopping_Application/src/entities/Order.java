package entities;

import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<ProductQuantityPair> products;
    private String status; // e.g., "Pending", "Completed", "Delivered", "Cancelled"

    public Order(int orderId, Customer customer, List<ProductQuantityPair> products, String status) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
        this.status = status;
    }

    // Getters and setters
    public int getOrderId() {
        return orderId;
    }
    
    // Note: No setter for orderId

    public Customer getCustomer() {
        return customer;
    }
    
    // Note: No setter for customer

    public List<ProductQuantityPair> getProducts() {
        return products;
    }
    
    // Note: No setter for products list

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerId=" + customer.getUserId() + ", status=" + status + ", totalProducts=" + products.size() + "]";
    }
}
