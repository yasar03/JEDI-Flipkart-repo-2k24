package com.flipfit.business;

public class GYMBookingImpl implements GYMBooking {
    public void confirmBooking(int userId, int slotId) {
        System.out.println("Booking confirmed successfully");
    }

    public void cancelBooking(int userId, int slotId) {
        System.out.println("Booking cancelled successfully");
    }

    public void getCenter() {
        System.out.println("Center details");
    }
    
}
