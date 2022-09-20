package com.example.currencycalculation.service.impl;

import com.example.currencycalculation.clients.CurrencyExchangeClient;
import com.example.currencycalculation.entity.CalculatedAmount;
import com.example.currencycalculation.service.CalculationService;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalculationServiceImpl implements CalculationService {

    private final CurrencyExchangeClient currencyCalculationClient;
    private final RestTemplate restTemplate;
    private final Environment environment;

    public CalculationServiceImpl(CurrencyExchangeClient currencyCalculationClient, RestTemplate restTemplate, Environment environment) {
        this.currencyCalculationClient = currencyCalculationClient;
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    @Override
    public CalculatedAmount exchange(String from, String to, BigDecimal quantity) {
        BigDecimal conversionMultiple = currencyCalculationClient.getRate(from, to);

        return new CalculatedAmount(1,
                from,
                to,
                conversionMultiple,
                quantity,
                conversionMultiple.multiply(quantity),
                environment.getProperty("local.server.port")
        );
    }

    @Override
    public CalculatedAmount exchangeByRestTemplate(String from, String to, BigDecimal quantity) {
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<BigDecimal> currencyRate = restTemplate.getForEntity("http://currency-exchange-service/currency-exchange-service/{from}/{to}",
                BigDecimal.class, uriVariables);
        BigDecimal rate = currencyRate.getBody();
        return new CalculatedAmount(null,
                from,
                to,
                rate,
                quantity,
                rate.multiply(quantity),
                environment.getProperty("local.server.port"));
    }
}
