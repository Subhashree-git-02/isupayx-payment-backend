package com.example.demo.service;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {

        payment.setPaymentId(UUID.randomUUID().toString());

       
        payment.setCreatedAt(LocalDateTime.now());

        if (payment.getStatus() == null || payment.getStatus().isBlank()) {
            payment.setStatus("SUCCESS");
        }

        return paymentRepository.save(payment);
    }

    public Optional<Payment> getPaymentById(String paymentId) {
        return paymentRepository.findByPaymentId(paymentId);
    }
}