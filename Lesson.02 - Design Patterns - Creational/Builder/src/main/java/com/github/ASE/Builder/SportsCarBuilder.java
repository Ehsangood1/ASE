package com.github.ASE.Builder;

public class SportsCarBuilder implements CarBuilder {
    private Car car;

    public SportsCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildEngine() {
        this.car.setEngine("V8 Turbocharged");
    }

    @Override
    public void buildChassis() {
        this.car.setChassis("Aluminum Sport Chassis");
    }

    @Override
    public void buildInterior() {
        this.car.setInterior("Leather Seats");
    }

    @Override
    public void buildElectronics() {
        this.car.setElectronics("Digital Dashboard");
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
