package com.github.ASE.Facade.Subsystems;

public class CarRental {
    public void checkAvailability(String location) {
        System.out.println("Checking car availability in " + location);
    }

    public String bookCar(String carType, String dates) {
        System.out.println("Booking " + carType + " from " + dates);
        return "CAR_54321";
    }

    public void finalizeCarRental(String bookingId) {
        System.out.println("Finalizing car rental: " + bookingId);
    }
}
