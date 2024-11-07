/**
 * 
 */
package com.flipfit.business;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.Slot;
import com.flipfit.DAO.*;
import com.flipfit.constants.ColorConstants;

import java.util.*;

/**
 * 
 */
public class GymOwnerBusiness implements GymOwnerBusinessInterface {
	GymOwnerDAOImpl gymOwnerDAO = new GymOwnerDAOImpl();

	/**
	 * Obtains gym owner's profile details 
	 * @param email the email of the gym owner whose profile details are requested
	 * @return GymOwner the gym owner object
	 */
	public GymOwner getProfile(String email) {
		System.out.println(ColorConstants.GREEN +"Fetched Gym owner details successfully! " + email+ColorConstants.RESET);
		return gymOwnerDAO.getGymOwnerDetails(email);
	}
	
	public void editProfile(GymOwner gymOwnerNew) {
		gymOwnerDAO.editGymOwnerDetails(gymOwnerNew);
		System.out.println(ColorConstants.GREEN + "\nEdited your profile Successfully!" + ColorConstants.RESET);
	}
	/**
	 * This method allows a gym owner to add details of a particular gym.
	 * @param gym the gym object representing the gym details
	 */
	public boolean addGym(Gym gym) {
		gymOwnerDAO.addGym(gym);
		System.out.println(ColorConstants.GREEN + "\nAdded Gym Successfully!" + gym.getGymId() + ColorConstants.RESET );
		return true;
	}
	/**
	 * This method allows a gym owner to edit details of a particular gym.
	 * @param gym the gym object representing the gym details
	 */
	public void editGym(Gym gym) {
		gymOwnerDAO.editGym(gym);
		System.out.println(ColorConstants.GREEN + "\nEdited Gym Details Successfully! " + gym.getGymId()+ ColorConstants.RESET );
	}
	/**
	 * Obtains all the gyms that owned by the given gym owner.
	 * @param gymOwnerEmail the gym owner's email for which the list of gyms is requested
	 * @return list of gyms owned by the given gym owner
	 */
	public List<Gym> getGymDetail(String gymOwnerEmail) {
		System.out.println(ColorConstants.GREEN +"\nFetched gym details successfully! " + gymOwnerEmail+ ColorConstants.RESET);
		return gymOwnerDAO.getGymsOfGymOwner(gymOwnerEmail);
	}
	/**
	 * This method allows a gym owner to add details of a slot.
	 * @param slot the slot object representing the slot details
	 */
	public void addSlot(Slot slot) {
		gymOwnerDAO.addSlot(slot);
		System.out.println(ColorConstants.GREEN + "\nAdded slot successfully!"+ ColorConstants.RESET);
	}
	/**
	 * Checks if the gym owner is verified or not.
	 * @param email the gym owner's email 
	 * @return true if the gym owner is verified else returns false;
	 */
	public boolean isApproved(String email) {
		return gymOwnerDAO.checkOwnerApproval(email);
	}
	/**
	 * Checks if the gym is verified or not.
	 * @param gymId the gym id for which the verification status is requested
	 * @return true if the gym is verified else returns false;
	 */
	public boolean isGymApproved(String gymId) {
		return gymOwnerDAO.checkGymApproval(gymId);
	}
}
