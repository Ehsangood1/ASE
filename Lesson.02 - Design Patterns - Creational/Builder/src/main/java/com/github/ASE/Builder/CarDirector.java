package com.github.ASE.Builder;

public class CarDirector {
    public static void constructBasicCar(CarBuilder builder) {
        builder.buildEngine();
        builder.buildChassis();
        builder.buildInterior();
        builder.buildElectronics();
    }

    public static void constructLuxuryCar(CarBuilder builder) {
        constructBasicCar(builder);
        builder.addFeature("Sunroof");
        builder.addFeature("Adaptive Cruise Control");
        builder.addFeature("Heated Seats");
    }
}
