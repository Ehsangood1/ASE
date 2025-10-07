package com.github.ASE.Adapter.Adaptee;

public class Legacy {
    public String makePayment(String amount) {
        return "LEGACY_TXN_" + System.currentTimeMillis() + amount;
    }

    public String getTransactionStatus() {
        return "Processed";
    }
}
