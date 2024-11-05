package com.flipfit.bean;

public class ModeOfPayment {
    private String bankName;
    private Long accountNumber;
    private String ifscCode;
    private String userName;
    private Long userNumber;
    
    public String getBankName() {
        return bankName;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    public Long getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String getIfscCode() {
        return ifscCode;
    }
    
    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Long getUserNumber() {
        return userNumber;
    }
    
    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }
}
