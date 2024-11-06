package com.flipfit.business;

public class GYMCustomerBusinessImpl implements GYMCustomerBusiness {
    
    @Override
    public int createCustomer(String customerName, String customerEmail, String customerAddress, String customerPassword) {
        System.out.println("Customer created");
        int customerId = 1;
        return customerId;
    }
    
    @Override
    public boolean updateCustomer(int customerId) {
        System.out.println("Customer updated");
        return true;
    }
    
    @Override
    public boolean deleteCustomer(int customerId) {
        System.out.println("Customer deleted");
        return true;
    }
    
    @Override
    public void viewProfile() {
        System.out.println("Customer listed");
    }
    
    
    @Override
    public void viewBookings(int customerId) {
        System.out.println("Bookings listed");
    }
    
    @Override
    public void makePayment(int customerId, int paymentId) {
        System.out.println("Payment made");
    }
    
    @Override
    public void makeBooking(int customerId, int slotId) {
        System.out.println("Booking made");
    }
    
    @Override
    public void viewList() {
        System.out.println("List of GYMs");
    }
    
    @Override
    public void viewSlots() {
        System.out.println("List of slots");
    }
    
    @Override
    public void cancelBooking(int customerId, int slotId) {
        System.out.println("Booking cancelled");
    }
}
