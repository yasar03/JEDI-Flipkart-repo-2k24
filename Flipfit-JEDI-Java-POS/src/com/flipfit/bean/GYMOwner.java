package com.flipfit.bean;

import java.util.List;

public class GYMOwner {
    private int gymId;
    private String gymName;
    private String gymAddress;
    private int slotsAvailable;
    private List<Integer> slotTimings;
    private String role;
    
    public int getGymId() {
        return gymId;
    }
    
    public String getGymName() {
        return gymName;
    }
    
    public String getGymAddress() {
        return gymAddress;
    }
    
    public int getSlotsAvailable() {
        return slotsAvailable;
    }
    
    public List<Integer> getSlotTimings() {
        return slotTimings;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }
    
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }
    
    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }
    
    public void setSlotsAvailable(int slotsAvailable) {
        this.slotsAvailable = slotsAvailable;
    }
    
    public void setSlotTimings(List<Integer> slotTimings) {
        this.slotTimings = slotTimings;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
}
