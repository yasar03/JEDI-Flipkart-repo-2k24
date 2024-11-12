package com.flipfit.DAO;

import java.util.List;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;

public interface AdminDAO {
	public List<GymOwner> getAllGymOwners();

	public List<Gym> getAllGyms();

	public List<GymOwner> getPendingGymOwnerRequests();

	public List<Gym> getPendingGymRequests();

	public void approveSingleOwnerRequest(String gymOwnerEmail);

	public void approveAllOwnerRequest();

	public void approveSingleGymRequest(String gymId);

	public void approveAllGymRequest();
}
