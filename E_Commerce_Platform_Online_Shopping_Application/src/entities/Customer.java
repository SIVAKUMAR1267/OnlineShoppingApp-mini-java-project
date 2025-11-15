package entities;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String address;
    private ShoppingCart shoppingCart;
    private List<Order> orders;

    public Customer(int userId, String username, String email, String address) {
        super(userId, username, email);
        this.address = address;
        this.shoppingCart = new ShoppingCart();
        this.orders = new ArrayList<>();
    }

    // Getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
    
    // Note: Setter for shoppingCart not included as it's a one-to-one relationship initialized in the constructor.

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
    
    // Note: Setter for orders not included as it's a list managed by addOrder.

    @Override
    public String toString() {
        return "Customer [userId=" + getUserId() + ", username=" + getUsername() + ", email=" + getEmail() + ", address=" + address + "]";
    }
}