package com.flipfit.bean;

public class PasswordUpdateRequest {
    private String email;
    private String password;
    private String rePassword;
    
    // Getters and Setters
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRePassword() {
        return rePassword;
    }
    
    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
