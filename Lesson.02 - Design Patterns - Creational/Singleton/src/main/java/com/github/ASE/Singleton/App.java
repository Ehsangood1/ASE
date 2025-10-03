package com.github.ASE.Singleton;

public class App {

    public static void main(String[] args) {
        System.out.println(ConfigManager.getInstance().getProperty("UnknownKey") + "\n");
        System.out.println(ConfigManager.getInstance().toJSON() + "\n");

        ConfigManager.getInstance().setProperty("persistent", "true");
        System.out.println(ConfigManager.getInstance().toJSON() + "\n");
    }
}