package com.flipfit.bean;

import java.util.Date;

public class GYMBooking {
    public Long bookingId;
    public Date bookingTime;
    public Long userId;
    public Long slotId;
    public String modeOfPayment;
    
    public Long getBookingId() {
        return bookingId;
    }
    
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    
    public Date getBookingTime() {
        return bookingTime;
    }
    
    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getSlotId() {
        return slotId;
    }
    
    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }
    
    public String getModeOfPayment() {
        return modeOfPayment;
    }
    
    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }
}
