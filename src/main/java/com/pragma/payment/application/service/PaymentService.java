package com.pragma.payment.application.service;

import com.pragma.payment.domain.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(String id);
    Payment createPayment(Payment payment);
    Payment updatePayment(String id, Payment payment);
    void deletePayment(String id);
}