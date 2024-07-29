package com.example.openpayd.service;

import com.example.openpayd.dto.ExchangeRateResponse;
import com.example.openpayd.model.ExchangeRate;
import com.example.openpayd.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;
    private final RestTemplate restTemplate;

    @Value("${currencylayer.api.url}")
    private String fixerApiUrl;

    @Value("${currencylayer.api.key}")
    private String fixerApiKey;

    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository, RestTemplate restTemplate) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.restTemplate = restTemplate;
    }

    public ExchangeRateResponse getExchangeRate(String baseCurrency, String targetCurrency) {
        Optional<ExchangeRate> optionalRate = exchangeRateRepository.findByBaseCurrencyAndTargetCurrency(baseCurrency, targetCurrency);

        if (optionalRate.isPresent()) {
            ExchangeRate rate = optionalRate.get();
            return new ExchangeRateResponse(rate.getBaseCurrency(), rate.getTargetCurrency(), rate.getRate());
        } else {
            String url = String.format("%s/live?access_key=%s&currencies=%s&source=%s", fixerApiUrl, fixerApiKey, baseCurrency, targetCurrency);
            ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
            if (response != null) {
                ExchangeRate rate = new ExchangeRate();
                rate.setBaseCurrency(baseCurrency);
                rate.setTargetCurrency(targetCurrency);
                rate.setRate(response.getRate());
                exchangeRateRepository.save(rate);
            }
            return response;
        }
    }
}
