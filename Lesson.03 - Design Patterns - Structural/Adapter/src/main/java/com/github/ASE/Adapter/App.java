package com.github.ASE.Adapter;

public class App {

    public static void main(String[] args) {
        com.github.ASE.Adapter.Adaptee.Legacy legacySystem = new com.github.ASE.Adapter.Adaptee.Legacy();
        PaymentProcessor legacyAdapter = new com.github.ASE.Adapter.Adapters.Legacy(legacySystem);

        System.out.println("Processing Legacy Payment:");
        legacyAdapter.processPayment(100.0, "USD");
        System.out.println("STATUS: " + String.valueOf(legacyAdapter.checkStatus()));

        com.github.ASE.Adapter.Adaptee.Modern modernSystem = new com.github.ASE.Adapter.Adaptee.Modern("MY_API_KEY");
        PaymentProcessor modernAdapter = new com.github.ASE.Adapter.Adapters.Modern(modernSystem);

        System.out.println("\nProcessing Modern Payment:");
        modernAdapter.processPayment(200.0, "EUR");
        System.out.println("STATUS: " + String.valueOf(modernAdapter.checkStatus()));

        com.github.ASE.Adapter.Adaptee.Crypto cryptoSystem = new com.github.ASE.Adapter.Adaptee.Crypto();
        PaymentProcessor cryptoAdapter = new com.github.ASE.Adapter.Adapters.Crypto(cryptoSystem, "WALLET_789");

        System.out.println("\nProcessing Crypto Payment:");
        cryptoAdapter.processPayment(0.5, "BTC");
        System.out.println("STATUS: " + String.valueOf(cryptoAdapter.checkStatus()));
    }
}