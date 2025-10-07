package com.github.ASE.Facade;

public class App {

    public static void main(String[] args) {
        TravelBooking booking = new TravelBooking();

        System.out.println("== Booking a Trip to Paris ==\n");
        booking.bookTrip("New York", "Paris", "2024-06-10 to 2024-06-17");
    }
}
