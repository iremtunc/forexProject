package com.example.openpayd.dto;

import java.time.LocalDateTime;

public class ConversionTransactionResponse {
    private String sourceCurrency;
    private String targetCurrency;
    private Double sourceAmount;
    private Double targetAmount;
    private LocalDateTime timestamp;

    // Parametreli yapıcı metot
    public ConversionTransactionResponse(String sourceCurrency, String targetCurrency, Double sourceAmount, Double targetAmount, LocalDateTime timestamp) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.sourceAmount = sourceAmount;
        this.targetAmount = targetAmount;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Double getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(Double sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public Double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
