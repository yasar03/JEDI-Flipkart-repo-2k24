package com.flipfit.business;

public interface GYMAdminBusiness {
    public String sendNotification(String message);
    public void addGYM(int gymId, String gymName, String gymAddress, int numberOfSlots, int[] slots);
    public void removeGYM(int gymId);
    public void listGYM();
    public void addCustomerInWaitingList(int customerId, int centerId);
    public void removeCustomerFromWaitingList(int customerId, int centerId);
    
}
