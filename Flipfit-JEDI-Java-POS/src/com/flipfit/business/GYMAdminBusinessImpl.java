package com.flipfit.business;

public class GYMAdminBusinessImpl implements GYMAdminBusiness {
   
   @Override
    public String sendNotification(String message) {
        return message;
    }
    
    @Override
    public void addGYM(int gymId, String gymName, String gymAddress) {
        System.out.println("GYM added successfully");
    }
    
    @Override
    public void removeGYM(int gymId) {
        System.out.println("GYM removed successfully");
    }
    
    @Override
    public void listGYM() {
        System.out.println("GYM listed successfully");
    }
    
    @Override
    public void addCustomerInWaitingList(int customerId, int centerId) {
        System.out.println("Customer added to waiting list successfully");
    }
    
    @Override
    public void removeCustomerFromWaitingList(int customerId, int centerId) {
        System.out.println("Customer removed from waiting list successfully");
    }
    
    
    
}
