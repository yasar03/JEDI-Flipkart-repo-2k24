package com.flipfit.business;

import com.flipfit.bean.*;
import java.util.*;

public interface CustomerBusinessInterface{
    public Customer getProfile(Customer customer);
    
    public void editProfile(String email, String name, String phoneNumber, int age, String address);
    
    public List<Booking> getBookings(String email);
    
    public boolean cancelBooking(String bookingId, String email);
    
    public List<Gym> getGymInCity(String city);

    public List<Slot> getSlotInGym(String gymId);
  
    public void bookSlot(String bookingId, String gymId, String slotId, String email, String date);
 
    public boolean isSlotBooked(String slotId, String date);

    public boolean hasBookedSlotAlready(String slotId, String customerEmail, Date date);
    
//    public List<Gym> getGymInCity(String city);
}