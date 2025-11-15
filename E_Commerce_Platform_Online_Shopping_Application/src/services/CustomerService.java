package services;

import entities.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customerList;
    
    public CustomerService() {
        this.customerList = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    // retrieve Customer by ID
    public Customer getCustomer(int userId) {
        return customerList.stream()
                .filter(customer -> customer.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    public List<Customer> getCustomers() {
        return customerList;
    }
    
    // Other customer-related service methods would go here (e.g., login, updateProfile)
}