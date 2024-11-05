package com.flipfit.business;

public interface GYMOwnerBusiness {
    public void gymAddition();
    public void gymDeletion(int gymId);
    public void addSlots(int numberOfSlots, int gymId);
    public void removeSlots(int numberOfSlots, int gymId);
    
}
