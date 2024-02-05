package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitness.Payment;
import com.example.repo.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment editPayment(Long id, Payment updatedPayment) {
        Optional<Payment> existingPayment = paymentRepository.findById(id);

        if (existingPayment.isPresent()) {
            Payment paymentToUpdate = existingPayment.get();
            paymentToUpdate.setSubscriber(updatedPayment.getSubscriber());
            paymentToUpdate.setAmount(updatedPayment.getAmount());
            paymentToUpdate.setPaymentDate(updatedPayment.getPaymentDate());

            return paymentRepository.save(paymentToUpdate);
        }
        return null;
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}

