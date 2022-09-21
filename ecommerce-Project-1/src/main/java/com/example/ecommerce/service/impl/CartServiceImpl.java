package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ItemDTO;
import com.example.ecommerce.exception.CustomerNotFoundException;
import com.example.ecommerce.exception.ProductNotFoundException;
import com.example.ecommerce.model.*;
import com.example.ecommerce.repository.jpa.JpaCartItemRepository;
import com.example.ecommerce.repository.jpa.JpaCartRepository;
import com.example.ecommerce.repository.jpa.JpaCustomerRepository;
import com.example.ecommerce.repository.jpa.JpaProductRepository;
import com.example.ecommerce.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CartServiceImpl implements CartService {
    private final JpaCartRepository jpaCartRepository;
    private final JpaCustomerRepository jpaCustomerRepository;
    private final JpaCartItemRepository jpaCartItemRepository;
    private final JpaProductRepository jpaProductRepository;

    public CartServiceImpl(JpaCartRepository jpaCartRepository, JpaCustomerRepository jpaCustomerRepository, JpaCartItemRepository jpaCartItemRepository, JpaProductRepository jpaProductRepository) {
        this.jpaCartRepository = jpaCartRepository;
        this.jpaCustomerRepository = jpaCustomerRepository;
        this.jpaCartItemRepository = jpaCartItemRepository;
        this.jpaProductRepository = jpaProductRepository;
    }

    public void updateCartItem(CartItem cartItem, Integer quantity, BigDecimal price){
        try {
            int newQuantity = cartItem.getQuantityWished() + quantity;
            BigDecimal newTotalPrice = price.multiply(new BigDecimal(newQuantity));
            jpaCartItemRepository.save(new CartItem(cartItem.getCartItemId(),
                    cartItem.getCartId(),
                    cartItem.getProductId(),
                    newQuantity,
                    Date.valueOf(LocalDateTime.now().toLocalDate()),
                    newTotalPrice.round(new MathContext(3))));  //https://www.geeksforgeeks.org/bigdecimal-round-method-in-java/
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void addNewCartItem(Long productId, BigDecimal price, Long cartId, Integer quantity){
        try {
            jpaCartItemRepository.save(new CartItem(
                    cartId,
                    productId, // key is productId
                    quantity, // value is quantity of productId ordered
                    Date.valueOf(LocalDateTime.now().toLocalDate()),
                    price.multiply(new BigDecimal(quantity)).round(new MathContext(3))
            ));
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public List<ItemDTO> insertItem(Long customerId, List<ItemDTO> itemList) {
        Optional<Customer> foundCustomer = jpaCustomerRepository.findById(customerId);
        if (foundCustomer.isEmpty()){
            throw new CustomerNotFoundException();
        }
        Customer customer = foundCustomer.get();
        if(customer.getCartId()==null){
            log.info("CartId of customer is null => create new cart and add into Customer !!");
            customer.setCartId(jpaCartRepository.save(new Cart()).getCartId());
        }
        for (var item : itemList) {
            Optional<Product> foundProduct = jpaProductRepository.findById(item.getProductId());
            if(foundProduct.isEmpty()){
                throw new ProductNotFoundException();
            }
            //check : is productId in Cart of customer?
            Optional<CartItem> foundCartItem = jpaCartItemRepository.findByCartIdAndProductId(
                    customer.getCartId(),
                    foundProduct.get().getProductId());
            if(foundCartItem.isEmpty()) {
                //if productId don't have in Cart of Customer => add new into Cart
                 addNewCartItem(item.getProductId(), foundProduct.get().getPrice(),
                        customer.getCartId(), item.getQuantity());
            }
            //if productId exist in Cart => Update
            else {
                updateCartItem(foundCartItem.get(), item.getQuantity(), foundProduct.get().getPrice());
            }

        }
        return itemList;
    }

}
