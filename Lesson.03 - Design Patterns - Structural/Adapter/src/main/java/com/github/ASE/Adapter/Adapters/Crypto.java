package com.github.ASE.Adapter.Adapters;

import com.github.ASE.Adapter.PaymentProcessor;

public class Crypto implements PaymentProcessor {
    private final com.github.ASE.Adapter.Adaptee.Crypto cryptoProvider;
    private final String walletAddress;

    public Crypto(com.github.ASE.Adapter.Adaptee.Crypto cryptoProvider, String walletAddress) {
        this.cryptoProvider = cryptoProvider;
        this.walletAddress = walletAddress;
    }

    @Override
    public void processPayment(double amount, String currency) {
        cryptoProvider.sendCryptoPayment(walletAddress, amount, currency);
    }

    @Override
    public boolean checkStatus() {
        if (cryptoProvider.transactionsCount() == 0) {
            return false;
        }

        return true;
    }
}
