package com.github.ASE.Builder;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String engine;
    private String chassis;
    private String interior;
    private String electronics;
    private List<String> features = new ArrayList<>();

    public void setEngine(String e) {
        this.engine = e;
    }

    public void setChassis(String c) {
        this.chassis = c;
    }

    public void setInterior(String i) {
        this.interior = i;
    }

    public void setElectronics(String el) {
        this.electronics = el;
    }

    public void addFeature(String feature) {
        this.features.add(feature);
    }

    public List<String> giveMeSpecs() {
        final List<String> out = new ArrayList<>();
        out.add("Engine: " + this.engine);
        out.add("Chassis: " + this.chassis);
        out.add("Interior: " + this.interior);
        out.add("Electronics: " + this.electronics);
        out.add("Features: " + String.join(", ", this.features));
        return out;
    }
}
