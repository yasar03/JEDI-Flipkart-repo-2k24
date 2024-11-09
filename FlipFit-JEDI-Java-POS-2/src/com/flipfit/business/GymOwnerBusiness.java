/**
 * 
 */
package com.flipfit.business;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.Slot;
import com.flipfit.DAO.*;
import com.flipfit.constants.*;

import com.flipfit.exception.InvalidInputException;
import java.util.*;


public class GymOwnerBusiness implements GymOwnerBusinessInterface {
	GymOwnerDAOImpl gymOwnerDAO = new GymOwnerDAOImpl();

	public GymOwner getProfile(String email) {
		System.out.println("Fetched Gym owner details successfully! ");
		return gymOwnerDAO.getGymOwnerDetails(email);
	}
	
	public void editProfile(GymOwner gymOwnerNew) {
		gymOwnerDAO.editGymOwnerDetails(gymOwnerNew);
		System.out.println("\nEdited your profile Successfully!");
	}

	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);  // Try to parse the String as Integer
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public boolean addGym(Gym gym, String slotCount, String seatPerSlotCount) throws InvalidInputException {
//		Integer n1 = slotCount;
		
		if(!isInteger(slotCount)) {
			throw new InvalidInputException("Invalid slot count value!");
			
		}
		
		if(!isInteger(seatPerSlotCount)) {
			throw new InvalidInputException("Invalid seat per slot count value!");
		}
		
		gym.setSlotCount(Integer.parseInt(slotCount));
		gym.setSeatsPerSlotCount(Integer.parseInt(seatPerSlotCount));
		
		gymOwnerDAO.addGym(gym);
		System.out.println("\nAdded Gym Successfully!" + gym.getGymId());
		return true;
	}
	
	public void editGym(Gym gym) {
		gymOwnerDAO.editGym(gym);
		System.out.println("\nEdited Gym Details Successfully! " + gym.getGymId());
	}

	public List<Gym> getGymDetail(String gymOwnerEmail) {
		System.out.println("\nFetched gym details successfully! " + gymOwnerEmail);
		return gymOwnerDAO.getGymsOfGymOwner(gymOwnerEmail);
	}

	public void addSlot(Slot slot) {
		gymOwnerDAO.addSlot(slot);
		System.out.println("\nAdded slot successfully!");
	}

	public boolean isApproved(String email) {
		return gymOwnerDAO.checkOwnerApproval(email);
	}

	public boolean isGymApproved(String gymId) {
		return gymOwnerDAO.checkGymApproval(gymId);
	}
}
