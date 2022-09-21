package com.example.ecommerce.service;

import com.example.ecommerce.model.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> findByCondition(Long customerId,
                                   String nameProduct,
                                   Integer offset,
                                   Integer limit);
}
