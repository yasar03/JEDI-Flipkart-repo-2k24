package com.flipfit.bean;

public class Notification {
    public Long notificationId;
    public Long userId;
    public String message;
    public Boolean sent;
    
    public Long getNotificationId() {
        return notificationId;
    }
    
    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Boolean getSent() {
        return sent;
    }
    
    public void setSent(Boolean sent) {
        this.sent = sent;
    }
}
