package com.example.currencycalculation.controller;

import com.example.currencycalculation.entity.CalculatedAmount;
import com.example.currencycalculation.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculationController {
    @Autowired
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/currency-converter/api/v1/from/{from}/to/{to}/quantity/{quantity}")
    public CalculatedAmount calculatedAmount(@PathVariable String from,
                                             @PathVariable String to,
                                             @PathVariable BigDecimal quantity){
        Map<String,String> uriVariables = new HashMap<>();
        return calculationService.exchange(from, to, quantity);
    }
    @GetMapping("/currency-converter/api/v2/from/{from}/to/{to}/quantity/{quantity}")
    public CalculatedAmount exchangeByRestTemplate(@PathVariable String from,
                                             @PathVariable String to,
                                             @PathVariable BigDecimal quantity){
        Map<String,String> uriVariables = new HashMap<>();
        return calculationService.exchangeByRestTemplate(from, to, quantity);
    }


}
