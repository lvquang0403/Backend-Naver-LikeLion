package com.example.currencycalculation.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeClient {
    @GetMapping("currency-exchange-service/{from}/{to}")
    BigDecimal getRate (@PathVariable String from,
                        @PathVariable String to);
}
