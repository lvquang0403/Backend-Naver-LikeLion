package com.example.currencyexchange.service;

import java.math.BigDecimal;

public interface RateService {
    BigDecimal getRate(String from, String to);
}
