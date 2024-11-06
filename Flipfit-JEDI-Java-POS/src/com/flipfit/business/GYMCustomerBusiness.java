package com.flipfit.business;

public interface GYMCustomerBusiness {
    public int createCustomer(String customerName, String customerEmail, String customerAddress, String customerPassword);
    public boolean updateCustomer(int customerId);
    public boolean deleteCustomer(int customerId);
    public void viewProfile();
    public void makePayment(int customerId, int paymentId);
    public void viewList();
    public void viewSlots();
    public void makeBooking(int customerId, int slotId);
    public void viewBookings(int customerId);
    public void cancelBooking(int customerId, int slotId);
    
}

