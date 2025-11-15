package entities;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items; 

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    // Getters and setters
    public Map<Product, Integer> getItems() {
        return items;
    }

    // Method to add item to the cart
    public void addItem(Product product, int quantity) {
        items.put(product, quantity);
    }
    
    // Method to remove item from the cart
    public void removeItem(Product product) {
        items.remove(product);
    }
    
    // Note: Setter for items map is not included to enforce map operations.
    
    @Override
    public String toString() {
        return "ShoppingCart [items=" + items + "]";
    }
}
