package com.example.ecommerce.service;
import com.example.ecommerce.dto.ItemDTO;
import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Customer;
import java.util.List;

public interface CartService {
    List<ItemDTO> insertItem(Long customerId, List<ItemDTO> itemList);
}
