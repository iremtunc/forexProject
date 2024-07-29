package com.example.openpayd.controller;

import com.example.openpayd.dto.ConversionResponse;
import com.example.openpayd.dto.ConversionTransactionResponse;
import com.example.openpayd.dto.ExchangeRateResponse;
import com.example.openpayd.service.ConversionService;
import com.example.openpayd.service.ExchangeRateService;
import com.example.openpayd.service.TransactionHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forex")
public class ForexController {
    private final ExchangeRateService exchangeRateService;
    private final ConversionService conversionService;
    private final TransactionHistoryService transactionHistoryService;


    public ForexController(ExchangeRateService exchangeRateService, ConversionService conversionService, TransactionHistoryService transactionHistoryService) {
        this.exchangeRateService = exchangeRateService;
        this.conversionService = conversionService;
        this.transactionHistoryService = transactionHistoryService;

    }

    @GetMapping("/rate")
    public ExchangeRateResponse getExchangeRate(@RequestParam String base, @RequestParam String target) {
        return exchangeRateService.getExchangeRate(base, target);
    }

    @PostMapping("/convert")
    public ConversionResponse convertCurrency(@RequestParam String source, @RequestParam String target, @RequestParam Double amount) {
        return conversionService.convertCurrency(source, target, amount);
    }

    @GetMapping("/history")
    public List<ConversionTransactionResponse> getConversionHistory() {
        return transactionHistoryService.getConversionHistory();
    }
}
