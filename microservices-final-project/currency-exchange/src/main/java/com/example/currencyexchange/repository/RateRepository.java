package com.example.currencyexchange.repository;

import com.example.currencyexchange.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate,Long> {
    Rate findByFromAndTo(String from, String to);
}
