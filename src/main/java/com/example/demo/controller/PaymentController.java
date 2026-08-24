package com.example.demo.controller;

import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(
            @RequestBody Payment payment) {

        Payment savedPayment = paymentService.createPayment(payment);

        return ResponseEntity.ok(savedPayment);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPayment(
            @PathVariable String paymentId) {

        return paymentService.getPaymentById(paymentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}