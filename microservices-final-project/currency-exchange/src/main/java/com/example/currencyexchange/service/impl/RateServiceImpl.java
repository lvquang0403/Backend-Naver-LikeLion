package com.example.currencyexchange.service.impl;

import com.example.currencyexchange.repository.RateRepository;
import com.example.currencyexchange.service.RateService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RateServiceImpl implements RateService {
    private final RateRepository rateRepository;
    private final Environment environment;

    public RateServiceImpl(RateRepository rateRepository, Environment environment) {
        this.rateRepository = rateRepository;
        this.environment = environment;
    }

    @Override
    public BigDecimal getRate(String from, String to) {
        return rateRepository.findByFromAndTo(from, to).getConversionMultiple();
    }
}
