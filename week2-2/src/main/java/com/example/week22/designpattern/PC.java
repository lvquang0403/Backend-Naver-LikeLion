package com.example.week22.designpattern;

import org.springframework.stereotype.Component;

@Component
public class PC implements Computer{
    @Override
    public String getType() {
        return "PC";
    }
}
