package services;

import entities.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> productList;
    
    public ProductService() {
        this.productList = new ArrayList<>();
    }

    // add, remove, retrieve products
    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(int productId) {
        productList.removeIf(product -> product.getProductId() == productId);
    }

    public List<Product> getProducts() {
        return productList;
    }

    public Product getProductById(int productId) {
        return productList.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }
    
    // Other product-related service methods would go here (e.g., updateProduct)
}