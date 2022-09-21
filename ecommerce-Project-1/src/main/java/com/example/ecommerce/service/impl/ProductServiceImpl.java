package com.example.ecommerce.service.impl;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.mybatis.MbtProductRepository;
import com.example.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final MbtProductRepository productRepository;

    public ProductServiceImpl(MbtProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findProductLessThan(BigDecimal price) {
        return productRepository.findProductLessThan(price);
    }

    @Override
    public List<Product> findProductGreaterThan(BigDecimal price) {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getPrice().compareTo(price) > 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductEqual(BigDecimal price) {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getPrice().compareTo(price) == 0)
                .collect(Collectors.toList());
    }

}
