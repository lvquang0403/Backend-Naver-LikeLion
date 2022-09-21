package com.example.ecommerce.repository.jpa;

import com.example.ecommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JpaCartRepository extends JpaRepository<Cart,Long> {
}
