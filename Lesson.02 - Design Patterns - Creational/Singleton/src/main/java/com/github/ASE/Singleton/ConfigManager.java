package com.github.ASE.Singleton;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class ConfigManager {
    private static volatile ConfigManager instance;
    private final Map<String, String> properties = new HashMap<>();

    // Private constructor to prevent instantiation
    private ConfigManager() {
        this.resetConfig();
    }

    // Thread-safe singleton access
    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public void resetConfig() {
        this.properties.clear();
        this.properties.put("databaseURL", "jdbc:mysql://localhost:3306/mydb");
        this.properties.put("maxConnections", "10");
        this.properties.put("theme", "dark");
        this.properties.put("logLevel", "INFO");
    }

    // Get a property value
    public String getProperty(String key) {
        return this.properties.getOrDefault(key, "NOT_FOUND");
    }

    // Set or override a property
    public void setProperty(String key, String value) {
        this.properties.put(key, value);
    }

    public String toJSON() {
        JSONObject jsonObject = new JSONObject(this.properties);
        return jsonObject.toString(2);
    }
}
