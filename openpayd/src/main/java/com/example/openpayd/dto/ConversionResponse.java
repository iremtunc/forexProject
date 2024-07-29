package com.example.openpayd.dto;

import lombok.Data;

@Data
public class ConversionResponse {
    private String sourceCurrency;
    private String targetCurrency;
    private Double sourceAmount;
    private Double targetAmount;
    private String transactionId;
}
