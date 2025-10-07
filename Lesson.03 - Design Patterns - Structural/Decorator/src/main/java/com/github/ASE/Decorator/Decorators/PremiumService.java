package com.github.ASE.Decorator.Decorators;

public class PremiumService extends StreamingService {
    public PremiumService(com.github.ASE.Decorator.Components.StreamingService decoratedService) {
        super(decoratedService);
    }

    @Override
    public void streamContent(String content) {
        System.out.println("Accessing Premium Content...");
        super.streamContent(content);
    }

    @Override
    public double getCost() {
        return super.getCost() + 4.99; // Add premium cost
    }
}
