package com.example.currencyexchange.controller;

import com.example.currencyexchange.service.RateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("currency-exchange-service")
public class RateController {
    private final RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }
    @GetMapping("{from}/{to}")
    public BigDecimal getRate(@PathVariable String from,
                              @PathVariable String to){
        return rateService.getRate(from, to);
    }
}
