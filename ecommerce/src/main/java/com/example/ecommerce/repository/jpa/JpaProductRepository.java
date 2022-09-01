package com.example.ecommerce.repository.jpa;

import com.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameProduct(String productName);
}
