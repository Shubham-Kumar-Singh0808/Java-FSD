package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitness.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByAmountGreaterThan(BigDecimal amount);
    
    List<Payment> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);
}

