package com.flipfit.business;

import com.flipfit.bean.*;
import java.util.*;

public interface CustomerBusinessInterface{
    public Customer getProfile(Customer customer);
    /*
    returns the customer profile
    */

    public void editProfile(Customer customer);
    /*
    allows the customer to edit profile
    */
    public List<Booking> getBookings(String email);
    /*
    returns the list of all the bookings of the customer
    */
    public boolean cancelBooking(String bookingId, String email);
    /*
    allows the customer to cancel Booking
    */

    public List<Gym> getGymInCity(String city);
    /*
    returns the list of gyms in a city
    */

    public List<Slot> getSlotInGym(String gymId);
    /*
    returns the list of slots in a gym
    */

    public int bookSlot(String gymId, String slotId, String email, Date date);
    /*
    allows the customer to book a slot
    */

    public boolean isSlotBooked(String slotId, Date date);
    /*
    returns true if the slot is fully booked else returns false
    */

    public boolean hasBookedSlotAlready(String slotId, String customerEmail, Date date);
    /*
    checks if the customer has already booked the slot with given slotId
    */
}