package com.flipfit.business;

import com.flipfit.bean.Customer;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.User;

public interface UserBusinessInterface{

    public boolean registerCustomer(Customer customer);
   
    public boolean registerGymOwner(GymOwner gymOwner);
  
    public boolean authenticateUser(User user);
    
    public boolean updatePassword(String email, String newPassword);
  
    public boolean logout(User user);
    
}