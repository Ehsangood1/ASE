package com.github.ASE.Decorator.Decorators;

public abstract class StreamingService implements com.github.ASE.Decorator.Components.StreamingService {
    protected com.github.ASE.Decorator.Components.StreamingService decoratedService;

    public StreamingService(com.github.ASE.Decorator.Components.StreamingService decoratedService) {
        this.decoratedService = decoratedService;
    }

    @Override
    public void streamContent(String content) {
        decoratedService.streamContent(content);
    }

    @Override
    public double getCost() {
        return decoratedService.getCost();
    }
}
