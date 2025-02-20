package com.example.otp.controller;

import com.example.otp.model.Product;
import com.example.otp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Add a new product
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct)
                                     : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    // Search products by name
    @GetMapping("/search/name")
    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name) {
        List<Product> products = productService.searchProductsByName(name);
        return products.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                                  : ResponseEntity.ok(products);
    }
    // Endpoint to search products by description
    @GetMapping("/search/description")
    public ResponseEntity<List<Product>> searchProductsByDescription(@RequestParam String description) {
        List<Product> products = productService.searchProductsByDescription(description);
        return products.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                                  : ResponseEntity.ok(products);
    }

    // Get out-of-stock products
    @GetMapping("/out-of-stock")
    public ResponseEntity<List<Product>> getOutOfStockProducts() {
        List<Product> products = productService.getOutOfStockProducts();
        return products.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                                  : ResponseEntity.ok(products);
    }
}



