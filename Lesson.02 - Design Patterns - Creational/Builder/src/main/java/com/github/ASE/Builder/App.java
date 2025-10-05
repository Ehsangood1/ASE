package com.github.ASE.Builder;

import com.github.ASE.Builder.MethodChaining.MCCarBuilder;

public class App {

    public static void main(String[] args) {
        CarBuilder sportsCarBuilder1 = new SportsCarBuilder();
        CarDirector.constructBasicCar(sportsCarBuilder1);
        System.out.println(String.join("\n", sportsCarBuilder1.getCar().giveMeSpecs()) + "\n");

        CarBuilder suvBuilder1 = new SUVBuilder();
        CarDirector.constructBasicCar(suvBuilder1);
        System.out.println(String.join("\n", suvBuilder1.getCar().giveMeSpecs()) + "\n");

        CarBuilder sportsCarBuilder2 = new SportsCarBuilder();
        CarDirector.constructLuxuryCar(sportsCarBuilder2);
        System.out.println(String.join("\n", sportsCarBuilder2.getCar().giveMeSpecs()) + "\n");

        CarBuilder suvBuilder2 = new SUVBuilder();
        CarDirector.constructLuxuryCar(suvBuilder2);
        System.out.println(String.join("\n", suvBuilder2.getCar().giveMeSpecs()) + "\n");

        MCCarBuilder mcBuilder = new MCCarBuilder();
        Car mcSportCar = mcBuilder.engine("V8 Turbocharged").chassis("Aluminum Sport Chassis").interior("Leather Seats")
                .electronics("Digital Dashboard").feature("Racing Mode").feature("Sport Exhaust").build();
        System.out.println(String.join("\n", mcSportCar.giveMeSpecs()) + "\n");
    }
}