package com.pragma.payment.application.service;

import com.pragma.payment.domain.model.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final List<Payment> payments = new ArrayList<>();

    @Override
    public List<Payment> getAllPayments() {
        return new ArrayList<>(payments);
    }

    @Override
    public Payment getPaymentById(String id) {
        return payments.stream()
               .filter(payment -> payment.getId().equals(id))
               .findFirst()
               .orElse(null);
    }

    @Override
    public Payment createPayment(Payment payment) {
        payments.add(payment);
        return payment;
    }

    @Override
    public Payment updatePayment(String id, Payment payment) {
        Optional<Payment> optionalPayment = payments.stream()
               .filter(p -> p.getId().equals(id))
               .findFirst();
        if (optionalPayment.isPresent()) {
            Payment existingPayment = optionalPayment.get();
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setCurrency(payment.getCurrency());
            existingPayment.setStatus(payment.getStatus());
            return existingPayment;
        }
        return null;
    }

    @Override
    public void deletePayment(String id) {
        payments.removeIf(payment -> payment.getId().equals(id));
    }
}