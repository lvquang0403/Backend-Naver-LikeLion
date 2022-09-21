package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @Column(name = "cart_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;
    @Column(name = "cart_id")
    private Long cartId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "quantity_wished")
    private Integer quantityWished;
    @Column(name = "date_added")
    private Date dateAdded;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    public CartItem(Long cartId, Long productId, Integer quantityWished, Date dateAdded, BigDecimal totalAmount) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantityWished = quantityWished;
        this.dateAdded = dateAdded;
        this.totalAmount = totalAmount;
    }

    public CartItem(Long cartId, Long productId, BigDecimal price, Date dateAdded, BigDecimal multiply) {
    }
}
