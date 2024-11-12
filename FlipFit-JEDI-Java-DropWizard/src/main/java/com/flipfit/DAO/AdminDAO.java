package com.flipfit.DAO;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;
import java.util.List;

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
