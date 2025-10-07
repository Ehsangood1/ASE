package com.github.ASE.Facade.Subsystems;

public class FlightBooking {
    public void searchFlights(String destination) {
        System.out.println("Searching flights to " + destination);
    }

    public String bookFlight(String from, String to, String date) {
        System.out.println("Booking flight from " + from + " to " + to + " on " + date);
        return "FLIGHT_12345";
    }

    public void confirmFlight(String bookingId) {
        System.out.println("Flight confirmed: " + bookingId);
    }
}
