package com.example.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.annotation.AfterReturning;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Long productId;
    private Integer quantity;
}
