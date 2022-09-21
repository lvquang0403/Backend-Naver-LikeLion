package com.example.ecommerce.service.impl;

import com.example.ecommerce.exception.CustomerNotFoundException;
import com.example.ecommerce.exception.NotEnoughItemException;
import com.example.ecommerce.exception.ProductNotFoundException;
import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.jpa.JpaCustomerRepository;
import com.example.ecommerce.repository.jpa.JpaProductRepository;
import com.example.ecommerce.repository.mybatis.MbtCartItemRepository;
import com.example.ecommerce.service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartItemServiceImpl implements CartItemService {
    private final MbtCartItemRepository mbtCartItemRepository;
    private final JpaCustomerRepository jpaCustomerRepository;
    private final JpaProductRepository jpaProductRepository;

    public CartItemServiceImpl(MbtCartItemRepository mbtCartItemRepository, JpaCustomerRepository jpaCustomerRepository, JpaProductRepository jpaProductRepository) {
        this.mbtCartItemRepository = mbtCartItemRepository;
        this.jpaCustomerRepository = jpaCustomerRepository;
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public List<CartItem> findByCondition(Long customerId, String nameProduct, Integer offset, Integer limit) {
        if(jpaCustomerRepository.findById(customerId).isEmpty()){
            throw new CustomerNotFoundException();
        }
        List<Product> listProduct = jpaProductRepository.findByNameProduct(nameProduct);
        if (listProduct.isEmpty()){
            throw new ProductNotFoundException();
        }
        List<CartItem> listItemCart = mbtCartItemRepository
                .findCartItemByCustomerIdAndProductName(customerId, "%"+nameProduct+"%");
        if(listItemCart.size() < limit){
            throw new NotEnoughItemException(listItemCart);
        }
//        listItemCart.stream()
//                .filter(item -> item.getProductId().equals(foundProduct.get().getProductId())); //find item follow by productId
        return listItemCart.subList(offset,offset+limit);
    }
}
