package com.github.ASE.Adapter;

public interface PaymentProcessor {
    void processPayment(double amount, String currency);

    boolean checkStatus();
}
