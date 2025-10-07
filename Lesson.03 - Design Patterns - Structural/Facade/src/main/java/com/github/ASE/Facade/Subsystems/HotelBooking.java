package com.github.ASE.Facade.Subsystems;

public class HotelBooking {
    public void findAvailableRooms(String location) {
        System.out.println("Finding available hotel rooms in " + location);
    }

    public String reserveRoom(String hotelName, String dates) {
        System.out.println("Reserving room at " + hotelName + " for " + dates);
        return "HOTEL_67890";
    }

    public void confirmReservation(String reservationId) {
        System.out.println("Hotel reservation confirmed: " + reservationId);
    }
}
