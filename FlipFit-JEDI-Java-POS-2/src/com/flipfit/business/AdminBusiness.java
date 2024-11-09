/**
 * 
 */
package com.flipfit.business;
import java.util.*;

import com.flipfit.DAO.AdminDAOImpl;
import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;


public class AdminBusiness implements AdminBusinessInterface{
	AdminDAOImpl adminDAO = new AdminDAOImpl();
	
	public List<GymOwner> getGymOwners() {
		System.out.println("Fetched gym owner details successfully!");
		return adminDAO.getAllGymOwners();
	}

	public List<Gym> getGym() {
		System.out.println("Fetched gym details successfully!");
		return adminDAO.getAllGyms();
	}


	public List<GymOwner> viewAllPendingGymOwnerRequests() {
		System.out.println("Fetched pending gym owner details successfully!");
		return adminDAO.getPendingGymOwnerRequests();
	}


	public boolean approveSingleGymOwnerRequest(String gymOwnerEmail) {
		adminDAO.approveSingleOwnerRequest(gymOwnerEmail);
		System.out.println("Approved gym owner request! " + gymOwnerEmail);
		return true;
	}

	public boolean approveAllPendingGymOwnerRequests() {
		adminDAO.approveAllOwnerRequest();
		System.out.println("Approved all pending gym owner requests!");
		return true;
	}

	public List<Gym> viewAllPendingGymRequests() {
		System.out.println("Fetched pending gym requests successfully!");
		return adminDAO.getPendingGymRequests();
	}

	public boolean approveSingleGymRequest(String gymId) {
		adminDAO.approveSingleGymRequest(gymId);
		System.out.println("Successfully approved gym request! " + gymId);
		return true;
	}

	public boolean approveAllPendingGymRequests() {
		adminDAO.approveAllGymRequest();
		System.out.println("Successfully approved all pending gym requests!");
		return true;
	}
}
