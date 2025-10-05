package com.github.ASE.Builder.MethodChaining;

import com.github.ASE.Builder.Car;

public class MCCarBuilder {
    private Car car;

    public MCCarBuilder() {
        this.car = new Car();
    }

    public MCCarBuilder engine(String engine) {
        this.car.setEngine(engine);
        return this;
    }

    public MCCarBuilder chassis(String chassis) {
        this.car.setChassis(chassis);
        return this;
    }

    public MCCarBuilder interior(String interior) {
        this.car.setInterior(interior);
        return this;
    }

    public MCCarBuilder electronics(String electronics) {
        this.car.setElectronics(electronics);
        return this;
    }

    public MCCarBuilder feature(String feature) {
        this.car.addFeature(feature);
        return this;
    }

    public Car build() {
        return this.car;
    }

    public MCCarBuilder reset() {
        this.car = new Car();
        return this;
    }
}
