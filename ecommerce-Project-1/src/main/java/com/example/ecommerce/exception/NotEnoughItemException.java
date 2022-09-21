package com.example.ecommerce.exception;

import com.example.ecommerce.model.CartItem;
import lombok.Data;

import java.util.List;

@Data
public class NotEnoughItemException extends RuntimeException{
    private final List<CartItem> cartItemList;

    public NotEnoughItemException(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

}
