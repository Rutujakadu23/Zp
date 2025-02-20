package com.example.otp.repository;

import com.example.otp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find products by name containing a specific substring
	 // Find products where the name contains the specified string
    List<Product> findByNameContaining(String name);

    // Find products where the description contains the specified string
    List<Product> findByDescriptionContaining(String description);
   
   
    List<Product> findByStockQuantity(int stockQuantity);
}
