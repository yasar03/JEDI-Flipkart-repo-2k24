package com.flipfit.business;

public interface BookingBusinessInterface {
	
    public boolean isConfirmed(String bookingId);
   
    public int getWaitingList();
}