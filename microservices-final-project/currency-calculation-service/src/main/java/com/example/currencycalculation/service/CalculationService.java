package com.example.currencycalculation.service;

import com.example.currencycalculation.entity.CalculatedAmount;

import java.math.BigDecimal;

public interface CalculationService {
    CalculatedAmount exchange(String from, String to, BigDecimal quantity);
    CalculatedAmount exchangeByRestTemplate(String from, String to,BigDecimal quantity);

}
