package com.github.ASE.Decorator.Decorators;

public class FourKService extends StreamingService {
    public FourKService(com.github.ASE.Decorator.Components.StreamingService decoratedService) {
        super(decoratedService);
    }

    @Override
    public void streamContent(String content) {
        super.streamContent(content + " [4K]");
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.99; // Add 4K cost
    }
}
