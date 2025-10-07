package com.github.ASE.Decorator.Decorators;

public class OfflineService extends StreamingService {
    public OfflineService(com.github.ASE.Decorator.Components.StreamingService decoratedService) {
        super(decoratedService);
    }

    @Override
    public void streamContent(String content) {
        System.out.println("Downloading for offline viewing...");
        super.streamContent(content);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.99; // Add offline cost
    }
}
