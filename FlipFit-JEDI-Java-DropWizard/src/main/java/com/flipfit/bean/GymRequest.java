package com.flipfit.bean;

public class GymRequest {
    private Gym gym;
    private String slotCount;
    private String seatPerSlotCount;
    
    // Getters and setters
    public Gym getGym() {
        return gym;
    }
    
    public void setGym(Gym gym) {
        this.gym = gym;
    }
    
    public String getSlotCount() {
        return slotCount;
    }
    
    public void setSlotCount(String slotCount) {
        this.slotCount = slotCount;
    }
    
    public String getSeatPerSlotCount() {
        return seatPerSlotCount;
    }
    
    public void setSeatPerSlotCount(String seatPerSlotCount) {
        this.seatPerSlotCount = seatPerSlotCount;
    }
}
