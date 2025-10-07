package com.github.ASE.Facade;

import com.github.ASE.Facade.Subsystems.CarRental;
import com.github.ASE.Facade.Subsystems.FlightBooking;
import com.github.ASE.Facade.Subsystems.HotelBooking;

public class TravelBooking {
    private final FlightBooking flightBooking;
    private final HotelBooking hotelBooking;
    private final CarRental carRental;

    public TravelBooking() {
        this.flightBooking = new FlightBooking();
        this.hotelBooking = new HotelBooking();
        this.carRental = new CarRental();
    }

    public void bookTrip(String origin, String destination, String dates) {
        System.out.println("\n--- Booking Flight ---");
        flightBooking.searchFlights(destination);
        String flightId = flightBooking.bookFlight(origin, destination, dates);
        flightBooking.confirmFlight(flightId);

        System.out.println("\n--- Booking Hotel ---");
        hotelBooking.findAvailableRooms(destination);
        String hotelId = hotelBooking.reserveRoom("Grand Hotel", dates);
        hotelBooking.confirmReservation(hotelId);

        System.out.println("\n--- Booking Car ---");
        carRental.checkAvailability(destination);
        String carId = carRental.bookCar("SUV", dates);
        carRental.finalizeCarRental(carId);
    }
}
