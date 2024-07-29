package com.example.openpayd;

import com.example.openpayd.dto.ConversionTransactionResponse;
import com.example.openpayd.model.ConversionTransaction;
import com.example.openpayd.repository.ConversionTransactionRepository;
import com.example.openpayd.service.TransactionHistoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
public class TransactionHistoryServiceTest {
    private final ConversionTransactionRepository conversionTransactionRepository = Mockito.mock(ConversionTransactionRepository.class);
    private final TransactionHistoryService transactionHistoryService = new TransactionHistoryService(conversionTransactionRepository);

    @Test
    public void testGetConversionHistory() {
        ConversionTransaction transaction1 = new ConversionTransaction();
        transaction1.setSourceCurrency("USD");
        transaction1.setTargetCurrency("EUR");
        transaction1.setSourceAmount(100.0);
        transaction1.setTargetAmount(85.0);
        transaction1.setTimestamp(LocalDateTime.now());

        ConversionTransaction transaction2 = new ConversionTransaction();
        transaction2.setSourceCurrency("GBP");
        transaction2.setTargetCurrency("USD");
        transaction2.setSourceAmount(200.0);
        transaction2.setTargetAmount(250.0);
        transaction2.setTimestamp(LocalDateTime.now());

        when(conversionTransactionRepository.findAll()).thenReturn(Arrays.asList(transaction1, transaction2));

        List<ConversionTransactionResponse> history = transactionHistoryService.getConversionHistory();

        assertEquals(2, history.size());
        assertEquals("USD", history.get(0).getSourceCurrency());
        assertEquals("EUR", history.get(0).getTargetCurrency());
        assertEquals(100.0, history.get(0).getSourceAmount());
        assertEquals(85.0, history.get(0).getTargetAmount());

        assertEquals("GBP", history.get(1).getSourceCurrency());
        assertEquals("USD", history.get(1).getTargetCurrency());
        assertEquals(200.0, history.get(1).getSourceAmount());
        assertEquals(250.0, history.get(1).getTargetAmount());
    }
}
