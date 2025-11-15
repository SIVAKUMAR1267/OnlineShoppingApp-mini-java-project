package services;

import entities.Order;
import entities.Product;
import entities.ProductQuantityPair;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orderList;

    public OrderService() {
        this.orderList = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orderList.add(order);
    }

    
    public void updateOrderStatus(int orderId, String status) {
        Order order = getOrder(orderId);

        if (order != null) {
            String currentStatus = order.getStatus();
            if ("Completed".equalsIgnoreCase(status) && "Pending".equalsIgnoreCase(currentStatus)) {
                
                
                for (ProductQuantityPair pair : order.getProducts()) {
                    Product product = pair.getProduct();
                    int quantity = pair.getQuantity();
                    
                    if (product.getStockQuantity() < quantity) {
                         System.out.println("Insufficient stock for product: " + product.getName());
                         return; 
                    }
                }
                
              
                for (ProductQuantityPair pair : order.getProducts()) {
                    Product product = pair.getProduct();
                    int quantity = pair.getQuantity();
                    product.setStockQuantity(product.getStockQuantity() - quantity);
                }
                order.setStatus(status);
                System.out.println("Order " + orderId + " set to " + status + ". Stock adjusted.");
                
            } else if ("Cancelled".equalsIgnoreCase(status)) {
                
                if ("Completed".equalsIgnoreCase(currentStatus) || "Pending".equalsIgnoreCase(currentStatus)) {
                    for (ProductQuantityPair pair : order.getProducts()) {
                        Product product = pair.getProduct();
                        int quantity = pair.getQuantity();
                        product.setStockQuantity(product.getStockQuantity() + quantity);
                    }
                    order.setStatus(status);
                    System.out.println("Order " + orderId + " set to " + status + ". Stock returned.");
                } else {
                    System.out.println("Order status cannot be cancelled from " + currentStatus);
                }
            } else if ("Delivered".equalsIgnoreCase(status) && "Completed".equalsIgnoreCase(currentStatus)) {
               
                order.setStatus(status);
                System.out.println("Order " + orderId + " set to " + status + ".");
            } else {
                System.out.println("Invalid status transition for Order " + orderId + ". Current status is " + currentStatus);
            }
        } else {
            System.out.println("Order " + orderId + " not found.");
        }
    }

    
    public Order getOrder(int orderId) {
        return orderList.stream().filter(order -> order.getOrderId() == orderId).findFirst().orElse(null);
    }

    public List<Order> getOrders() {
        return orderList;
    }
}