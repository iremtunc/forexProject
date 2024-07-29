package com.example.openpayd.service;

import com.example.openpayd.dto.ConversionResponse;
import com.example.openpayd.model.ConversionTransaction;
import com.example.openpayd.repository.ConversionTransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ConversionService {
    private final ConversionTransactionRepository conversionTransactionRepository;
    private final ExchangeRateService exchangeRateService;

    public ConversionService(ConversionTransactionRepository conversionTransactionRepository, ExchangeRateService exchangeRateService) {
        this.conversionTransactionRepository = conversionTransactionRepository;
        this.exchangeRateService = exchangeRateService;
    }

    public ConversionResponse convertCurrency(String sourceCurrency, String targetCurrency, Double sourceAmount) {
        Double rate = exchangeRateService.getExchangeRate(sourceCurrency, targetCurrency).getRate();
        Double targetAmount = sourceAmount * rate;

        ConversionTransaction transaction = new ConversionTransaction();
        transaction.setSourceCurrency(sourceCurrency);
        transaction.setTargetCurrency(targetCurrency);
        transaction.setSourceAmount(sourceAmount);
        transaction.setTargetAmount(targetAmount);
        transaction.setTimestamp(LocalDateTime.now());

        conversionTransactionRepository.save(transaction);

        ConversionResponse response = new ConversionResponse();
        response.setSourceCurrency(sourceCurrency);
        response.setTargetCurrency(targetCurrency);
        response.setSourceAmount(sourceAmount);
        response.setTargetAmount(targetAmount);
        response.setTransactionId(UUID.randomUUID().toString());

        return response;
    }
}
