package com.example.otp.service;

import com.example.otp.model.Product;
import com.example.otp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Add a new product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product
    public Product updateProduct(Long id, Product productDetails) {
        if (productRepository.existsById(id)) {
            productDetails.setId(id);
            return productRepository.save(productDetails);
        }
        return null; // Or throw an exception
    }

    // Delete a product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    // Search products by name
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    // Search products by descsription
    public List<Product> searchProductsByDescription(String description) {
        return productRepository.findByDescriptionContaining(description);
    
    }

    // Get out-of-stock products
    public List<Product> getOutOfStockProducts() {
        return productRepository.findByStockQuantity(0);
    }
}



