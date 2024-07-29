package com.example.openpayd.repository;

import com.example.openpayd.model.ConversionTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConversionTransactionRepository extends JpaRepository<ConversionTransaction, Long> {
    List<ConversionTransaction> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}
