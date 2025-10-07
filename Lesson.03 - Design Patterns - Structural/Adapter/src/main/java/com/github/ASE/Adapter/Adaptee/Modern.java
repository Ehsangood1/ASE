package com.github.ASE.Adapter.Adaptee;

import org.json.JSONObject;

public class Modern {
    final String apiKey;
    String lastId = "";

    public Modern(String apiKey) {
        this.apiKey = apiKey;
    }

    public JSONObject submitPayment(double amount, String currency) {
        lastId = "MODERN_TXN_" + System.currentTimeMillis();

        JSONObject obj = new JSONObject();
        obj.put("amount", amount);
        obj.put("currency", currency);
        obj.put("apiKey", this.apiKey);
        obj.put("transactionId", lastId);
        return obj;
    }

    public JSONObject queryStatus() {
        JSONObject obj = new JSONObject();
        obj.put("transactionId", lastId);
        obj.put("status", "Completed");
        return obj;
    }
}
