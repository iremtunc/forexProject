package com.example.openpayd.repository;

import com.example.openpayd.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findByBaseCurrencyAndTargetCurrency(String baseCurrency, String targetCurrency);
}