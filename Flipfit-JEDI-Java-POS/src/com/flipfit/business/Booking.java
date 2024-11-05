package com.flipfit.business;

public interface Booking {
    public void confirmBooking(int userId, int slotId);
    public void cancelBooking(int userId, int slotId);
    public void getCenter();
}
