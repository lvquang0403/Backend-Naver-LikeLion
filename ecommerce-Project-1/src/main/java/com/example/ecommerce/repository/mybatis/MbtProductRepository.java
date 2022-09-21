package com.example.ecommerce.repository.mybatis;

import com.example.ecommerce.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface MbtProductRepository {

    @Select("SELECT * FROM product WHERE price < #{price};")
    @Results(value = {@Result(property="productId", column="product_id"),
            @Result(property="nameProduct", column = "name_product"),
            @Result(property = "productType", column = "product_type"),
            @Result(property = "size", column = "size"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "price", column = "price")})
    List<Product> findProductLessThan(BigDecimal price);
    @Select("SELECT * FROM product")
    @Results(value = {@Result(property="productId", column="product_id"),
            @Result(property="nameProduct", column = "name_product"),
            @Result(property = "productType", column = "product_type"),
            @Result(property = "size", column = "size"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "price", column = "price")})
    List<Product> findAll();

}
