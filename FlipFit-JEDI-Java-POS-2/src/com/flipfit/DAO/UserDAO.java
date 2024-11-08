package com.flipfit.DAO;

import com.flipfit.bean.Customer;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.User;
import com.flipfit.exception.UnauthorizedAccessException;

public interface UserDAO {
	public boolean authenticateUser(User user);

	public boolean registerCustomer(Customer customer);

	public boolean registerGymOwner(GymOwner gymOwner);
}
