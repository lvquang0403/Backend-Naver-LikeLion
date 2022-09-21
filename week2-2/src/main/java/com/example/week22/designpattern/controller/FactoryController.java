package com.example.week22.designpattern.controller;

import com.example.week22.designpattern.Computer;
import com.example.week22.designpattern.Factory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("factory-method")
public class FactoryController {
    private final Factory factory;

    public FactoryController(Factory factory) {
        this.factory = factory;
    }

    @GetMapping(value = "/{type}")
    public String getMethod(@PathVariable("type") String type){
        Computer computer = factory.getComputer(type);
        System.out.println("Type " + type);
        System.out.println("Computer " + computer.getType());
        return computer.getType();
    }
}
