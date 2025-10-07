package com.github.ASE.Adapter.Adaptee;

import java.util.ArrayList;
import java.util.List;

public class Crypto {
    public class Item {
        public String walletAddress;
        public double amount;
        public String cryptoType;
        public String id;
    }

    final List<Item> transactions = new ArrayList<>();

    public Item sendCryptoPayment(String walletAddress, double amount, String cryptoType) {
        final Item item = new Item();

        item.amount = amount;
        item.walletAddress = walletAddress;
        item.cryptoType = cryptoType;
        item.id = "CRYPTO_TXN_" + System.currentTimeMillis();

        transactions.add(item);

        return item;
    }

    public int transactionsCount() {
        return transactions.size();
    }

    public Item getTransaction(int index) {
        return transactions.get(index);
    }
}
