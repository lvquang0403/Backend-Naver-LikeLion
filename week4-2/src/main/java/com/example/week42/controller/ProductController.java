package com.example.week42.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("admin")
@RestController
public class ProductController {
    @PostMapping("")
    public String getHome(@RequestParam("name") String name){
        return "Home";
    }
}
