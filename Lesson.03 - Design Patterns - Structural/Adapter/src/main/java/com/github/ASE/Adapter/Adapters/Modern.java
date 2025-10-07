package com.github.ASE.Adapter.Adapters;

import com.github.ASE.Adapter.PaymentProcessor;

public class Modern implements PaymentProcessor {
    private final com.github.ASE.Adapter.Adaptee.Modern modernPaymentAPI;

    public Modern(com.github.ASE.Adapter.Adaptee.Modern modernPaymentAPI) {
        this.modernPaymentAPI = modernPaymentAPI;
    }

    @Override
    public void processPayment(double amount, String currency) {
        modernPaymentAPI.submitPayment(amount, currency);
    }

    @Override
    public boolean checkStatus() {
        return modernPaymentAPI.queryStatus().getString("status").equals("Completed");
    }
}
