package com.flipfit.bean;

public class BookingRequest {
    private String slotId;
    private String gymId;
    private String date;
    
    // Getters and setters
    public String getSlotId() {
        return slotId;
    }
    
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }
    
    public String getGymId() {
        return gymId;
    }
    
    public void setGymId(String gymId) {
        this.gymId = gymId;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
}
