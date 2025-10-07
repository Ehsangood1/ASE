package com.github.ASE.Adapter.Adapters;

import com.github.ASE.Adapter.PaymentProcessor;

public class Legacy implements PaymentProcessor {
    private final com.github.ASE.Adapter.Adaptee.Legacy legacySystem;

    public Legacy(com.github.ASE.Adapter.Adaptee.Legacy legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void processPayment(double amount, String currency) {
        legacySystem.makePayment(currency + " " + String.valueOf(amount));
    }

    @Override
    public boolean checkStatus() {
        return legacySystem.getTransactionStatus().equals("Processed");
    }
}
