package com.flipfit.bean;

public class GYMAdmin {
    private int adminId;
    private String adminName;
    private String adminPassword;
    private String role;
    
    public int getAdminId() {
        return adminId;
    }
    
    public String getAdminName() {
        return adminName;
    }
    
    public String getAdminPassword() {
        return adminPassword;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    
    
}
