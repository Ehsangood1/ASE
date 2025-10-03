package com.github.ASE.Builder;

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
    }
}