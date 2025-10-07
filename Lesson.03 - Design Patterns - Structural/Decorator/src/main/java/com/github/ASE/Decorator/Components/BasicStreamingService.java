package com.github.ASE.Decorator.Components;

public class BasicStreamingService implements StreamingService {
    @Override
    public void streamContent(String content) {
        System.out.println("Streaming '" + content + "' in SD.");
    }

    @Override
    public double getCost() {
        return 9.99; // Base price
    }
}
