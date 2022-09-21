package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ResponseObject;
import com.example.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //localhost:8080/product/find-product
    @GetMapping("find-product/{condition}/{price}")
    public ResponseEntity<ResponseObject> findProduct(@PathVariable String condition,
                                                      @PathVariable BigDecimal price){
        List<Product> listProducts = null;
        if (condition.equalsIgnoreCase("LESS_THAN")){
            listProducts = productService.findProductLessThan(price);
        } else if (condition.equalsIgnoreCase("EQUAL")) {
            listProducts = productService.findProductEqual(price);
        } else if (condition.equalsIgnoreCase("GREATER_THAN")) {
            listProducts = productService.findProductGreaterThan(price);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                    "Fail",
                    "condition not exist",
                    null
            ));
        }
        return ResponseEntity.ok().body(new ResponseObject(
                "OK",
                "Successfully",
                listProducts
        ));
    }

    @GetMapping("hello")
    public ResponseEntity<ResponseObject> hello(){
        return ResponseEntity.ok().body(new ResponseObject(
                "ok",
                "hello-hello",
                null
        ));
    }
}
