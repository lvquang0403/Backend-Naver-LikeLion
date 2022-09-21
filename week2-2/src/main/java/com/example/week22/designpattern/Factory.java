package com.example.week22.designpattern;

import org.springframework.stereotype.Component;

@Component
public class Factory {
    public Computer getComputer(String type){
        if(type.equalsIgnoreCase("PC")){
            return new PC();
        }
        else if (type.equalsIgnoreCase("Server")){
            return new Server();
        }
        return null;
    }
}
