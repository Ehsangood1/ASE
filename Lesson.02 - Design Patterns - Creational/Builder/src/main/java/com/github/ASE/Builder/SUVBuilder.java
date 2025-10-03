package com.github.ASE.Builder;

public class SUVBuilder implements CarBuilder {
    private Car car;

    public SUVBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildEngine() {
        this.car.setEngine("V6 Hybrid");
    }

    @Override
    public void buildChassis() {
        this.car.setChassis("Steel Off-road Frame");
    }

    @Override
    public void buildInterior() {
        this.car.setInterior("Vegan Leather Seats");
    }

    @Override
    public void buildElectronics() {
        this.car.setElectronics("Navigation System");
    }

    @Override
    public void addFeature(String feature) {
        this.car.addFeature(feature);
    }

    @Override
    public Car getCar() {
        return this.car;
    }
}
