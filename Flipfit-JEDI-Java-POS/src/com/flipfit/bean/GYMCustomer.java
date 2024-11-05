package com.flipfit.bean;

public class GYMCustomer {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String password;
    private String role;
    
    public int getCustomerId() {
        return customerId;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public String getCustomerAddress() {
        return customerAddress;
    }
    
    public String getCustomerEmail() {
        return customerEmail;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}