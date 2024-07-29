package com.example.openpayd.service;

import com.example.openpayd.dto.ConversionTransactionResponse;
import com.example.openpayd.repository.ConversionTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionHistoryService {
    private final ConversionTransactionRepository conversionTransactionRepository;

    public TransactionHistoryService(ConversionTransactionRepository conversionTransactionRepository) {
        this.conversionTransactionRepository = conversionTransactionRepository;
    }

    public List<ConversionTransactionResponse> getConversionHistory() {
        return conversionTransactionRepository.findAll().stream().map(transaction -> new ConversionTransactionResponse(
                transaction.getSourceCurrency(),
                transaction.getTargetCurrency(),
                transaction.getSourceAmount(),
                transaction.getTargetAmount(),
                transaction.getTimestamp()
        )).collect(Collectors.toList());
    }
}
