package com.flipfit.business;

public interface GYMBooking {
    public void confirmBooking(int userId, int slotId);
    public void cancelBooking(int userId, int slotId);
    public void getCenter();
}
