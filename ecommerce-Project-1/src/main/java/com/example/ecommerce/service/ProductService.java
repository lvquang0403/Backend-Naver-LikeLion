package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<Product> findProductLessThan(BigDecimal price);
    List<Product> findProductGreaterThan(BigDecimal price);
    List<Product> findProductEqual(BigDecimal price);
}
