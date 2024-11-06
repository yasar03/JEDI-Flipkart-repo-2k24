package com.flipfit.business;

public class GYMOwnerBusinessImpl implements GYMOwnerBusiness{
    
    public void viewProfile() {
        // TODO Auto-generated method stub
        System.out.println("Profile details");
    }
    public void gymAddition(String gymName, String gymAddress, int numberOfSlots, int[] slots) {
        // TODO Auto-generated method stub
        System.out.println("GYM added successfully");
    }
    
    public void gymEdit(int gymId, String gymName, String gymAddress, int numberOfSlots, int[] slots) {
        // TODO Auto-generated method stub
        System.out.println("GYM edited successfully");
    }

    public void gymDeletion(int gymId) {
        // TODO Auto-generated method stub
    }

    public void addSlots(int numberOfSlots, int gymId) {
        // TODO Auto-generated method stub
    }

    public void removeSlots(int numberOfSlots, int gymId) {
        // TODO Auto-generated method stub
    }
    
}
