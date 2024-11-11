package com.flipfit.DAO;

import com.flipfit.bean.Customer;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.User;

public interface UserDAO {
	public boolean authenticateUser(User user);

	public boolean registerCustomer(Customer customer);

	public boolean registerGymOwner(GymOwner gymOwner);
	
	public boolean updatePassword(String email, String newPassword);
}
