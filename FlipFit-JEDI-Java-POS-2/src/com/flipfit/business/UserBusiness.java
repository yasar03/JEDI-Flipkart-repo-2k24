/**
 * 
 */
package com.flipfit.business;

import com.flipfit.DAO.GymOwnerDAOImpl;
import com.flipfit.DAO.UserDAOImpl;
import com.flipfit.bean.Customer;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.User;
import com.flipfit.exception.UnauthorizedAccessException;


public class UserBusiness implements UserBusinessInterface{
	
	GymOwnerDAOImpl gymOwnerDao = new GymOwnerDAOImpl();
	UserDAOImpl userDao = new UserDAOImpl();

	public boolean registerCustomer(Customer customer) {
		boolean registerSuccess = false;
		registerSuccess = userDao.registerCustomer(customer);
		return registerSuccess;
	}

	public boolean registerGymOwner(GymOwner gymOwner) {
		boolean registerSuccess = false;
		registerSuccess = userDao.registerGymOwner(gymOwner);
		return registerSuccess;
	}

	public boolean authenticateUser(User user) {
		boolean authenticateSuccess = false;
//        try {
            authenticateSuccess = userDao.authenticateUser(user);
//        } catch (UnauthorizedAccessException e) {
//            throw new RuntimeException(e);
//        }
        return authenticateSuccess;
	}
	
	public boolean updatePassword(String email, String newPassword) {
		return userDao.updatePassword(email, newPassword);
	}

	public boolean logout(User user) {
		return true;
	}
}
