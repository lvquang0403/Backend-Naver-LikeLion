package com.example.week22.designpattern;

import org.springframework.stereotype.Component;

@Component
public class Server implements Computer {
    @Override
    public String getType() {
        return "Server";
    }
}
