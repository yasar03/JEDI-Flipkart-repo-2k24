package com.flipfit.business;

public interface GYMOwnerBusiness {
    public void viewProfile();
    public void gymAddition(String gymName, String gymAddress, int numberOfSlots, int[] slots);
    public void gymEdit(int gymId, String gymName, String gymAddress, int numberOfSlots, int[] slots);
    public void gymDeletion(int gymId);
    public void addSlots(int numberOfSlots, int gymId);
    public void removeSlots(int numberOfSlots, int gymId);
    
}
