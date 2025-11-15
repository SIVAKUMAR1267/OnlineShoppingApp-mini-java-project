package app;

import entities.*;
import services.*;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class OnlineShopping {
    private static ProductService productService;
    private static CustomerService customerService;
    private static OrderService orderService;
    private static AdminService adminService;
    private static int orderIdCounter = 1;

    public static void main(String[] args) {
        productService = new ProductService();
        customerService = new CustomerService();
        orderService = new OrderService();
        adminService = new AdminService();
        Scanner scanner = new Scanner(System.in);

        //preloading data
        Admin initialAdmin = new Admin(100, "AdminUser", "admin@shop.com");
        adminService.addAdmin(initialAdmin);
        
      
        Product p1 = new Product(101, "T-Shirt", 599.00, 50);
        Product p2 = new Product(102, "Jeans", 1299.00, 30);
        Product p3 = new Product(103, "Sneakers", 1999.50, 20);
        productService.addProduct(p1);
        productService.addProduct(p2);
        productService.addProduct(p3);
        System.out.println("Preloaded 3 products.");

        Customer c1 = new Customer(201, "Aniket", "aniket@mail.com", "Pune, India");
        Customer c2 = new Customer(202, "Bhavna", "bhavna@mail.com", "Mumbai, India");
        customerService.addCustomer(c1);
        customerService.addCustomer(c2);
        System.out.println("Preloaded 2 customers.");
        
        
        List<ProductQuantityPair> preloadedOrderProducts = new ArrayList<>();
        preloadedOrderProducts.add(new ProductQuantityPair(p1, 2));
        preloadedOrderProducts.add(new ProductQuantityPair(p3, 1)); 
        
        
        Order preloadedOrder = new Order(orderIdCounter++, c1, preloadedOrderProducts, "Pending");
        orderService.placeOrder(preloadedOrder);
        c1.addOrder(preloadedOrder); 
        System.out.println("Preloaded 1 order.");
        
        


        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    adminMenu(scanner);
                    break;
                case 2:
                    customerMenu(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    private static void adminMenu(Scanner scanner) {
        int adminChoice;
        do {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Products");
            System.out.println("4. Create Admin");
            System.out.println("5. View Admins");
            System.out.println("6. Update Order Status");
            System.out.println("7. View Orders");
            System.out.println("8. Return");
            System.out.print("Choose an option: ");
            adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    removeProduct(scanner);
                    break;
                case 3:
                    viewProducts();
                    break;
                case 4:
                    createAdmin(scanner);
                    break;
                case 5:
                    viewAdmins();
                    break;
                case 6:
                    updateOrderStatus(scanner);
                    break;
                case 7:
                    viewOrders();
                    break;
                case 8:
                    System.out.println("Exiting Admin...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (adminChoice != 8);
    }

    private static void customerMenu(Scanner scanner) {
        int customerChoice;
        do {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Create Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. View Products");
            System.out.println("6. Return");
            System.out.print("Choose an option: ");
            customerChoice = scanner.nextInt();

            switch (customerChoice) {
                case 1:
                    createCustomer(scanner);
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    placeOrder(scanner);
                    break;
                case 4:
                    viewOrders(scanner);
                    break;
                case 5:
                    viewProducts();
                    break;
                case 6:
                    System.out.println("Exiting Customer Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (customerChoice != 6);
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Product Name: ");
        String name = scanner.next();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Stock Quantity: ");
        int stockQuantity = scanner.nextInt();
        
        Product product = new Product(productId, name, price, stockQuantity);
        productService.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private static void removeProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        
        
        if (productService.getProductById(productId) == null) {
            System.out.println("Error: Product with ID " + productId + " not found. No product was removed.");
            return;
        }
        
        productService.removeProduct(productId);
        System.out.println("Product removed successfully!");
    }

    private static void viewProducts() {
        System.out.println("\nProducts:");
        productService.getProducts().forEach(System.out::println);
    }
    
    private static void createAdmin(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Username: ");
        String username = scanner.next();
        System.out.print("Enter Email: ");
        String email = scanner.next();
        
        Admin admin = new Admin(userId, username, email);
        adminService.addAdmin(admin);
        System.out.println("Admin created successfully!");
    }
    
    private static void viewAdmins() {
        System.out.println("\nAdmins:");
        adminService.getAdmins().forEach(System.out::println);
    }

    private static void createCustomer(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Username: ");
        String username = scanner.next();
        System.out.print("Enter Email: ");
        String email = scanner.next();
        System.out.print("Enter Address: ");
        String address = scanner.next();
        
        Customer customer = new Customer(userId, username, email, address);
        customerService.addCustomer(customer);
        System.out.println("Customer created successfully!");
    }

    private static void viewCustomers() {
        System.out.println("\nCustomers:");
        customerService.getCustomers().forEach(customer -> System.out.println("User ID: " + customer.getUserId() + ", Username: " + customer.getUsername() + ", Email: " + customer.getEmail() + ", Address: " + customer.getAddress()));
    }
    
    private static void placeOrder(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        List<ProductQuantityPair> orderProducts = new ArrayList<>();
        int productId;
        while (true) {
            System.out.print("Enter Product ID to add to order (or -1 to complete): ");
            productId = scanner.nextInt();
            if (productId == -1) break;

            Product product = productService.getProductById(productId);
            if (product == null) {
                System.out.println("Product not found.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            
            if (quantity <= 0) {
                 System.out.println("Quantity must be positive.");
                 continue;
            }

            orderProducts.add(new ProductQuantityPair(product, quantity));
        }

        if (orderProducts.isEmpty()) {
            System.out.println("Order cancelled. No products added.");
            return;
        }

        Order newOrder = new Order(orderIdCounter++, customer, orderProducts, "Pending");
        orderService.placeOrder(newOrder);
        customer.addOrder(newOrder);
        System.out.println("Order placed successfully!");
    }
    
    private static void updateOrderStatus(Scanner scanner) {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        System.out.print("Enter new status (Completed/Delivered/Cancelled): ");
        String status = scanner.next();
        
        orderService.updateOrderStatus(orderId, status);
    }
    
    private static void viewOrders() {
        System.out.println("\nOrders:");
        for (Order order : orderService.getOrders()) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer: " + order.getCustomer().getUsername() + ", Status: " + order.getStatus());
            for (ProductQuantityPair pair : order.getProducts()) {
                System.out.println(" Product: " + pair.getProduct().getName() + ", Quantity: " + pair.getQuantity());
            }
        }
    }
    
    private static void viewOrders(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        
        System.out.println("\nOrders:");
        for (Order order : customer.getOrders()) {
            System.out.println("Order ID: " + order.getOrderId() + ", Status: " + order.getStatus());
            for (ProductQuantityPair pair : order.getProducts()) {
                System.out.println(" Product: " + pair.getProduct().getName() + ", Quantity: " + pair.getQuantity());
            }
        }
    }
}