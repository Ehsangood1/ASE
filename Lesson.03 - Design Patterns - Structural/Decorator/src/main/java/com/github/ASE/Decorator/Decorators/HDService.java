package com.github.ASE.Decorator.Decorators;

public class HDService extends StreamingService {
    public HDService(com.github.ASE.Decorator.Components.StreamingService decoratedService) {
        super(decoratedService);
    }

    @Override
    public void streamContent(String content) {
        super.streamContent(content + " [HD]");
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.99; // Add HD cost
    }
}
