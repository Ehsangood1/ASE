package com.github.ASE.Builder;

public interface CarBuilder {
    void buildEngine();

    void buildChassis();

    void buildInterior();

    void buildElectronics();

    void addFeature(String feature);

    Car getCar();
}
