package com.flipfit.DAO;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.Slot;
import java.util.List;

public interface GymOwnerDAO {
	public GymOwner getGymOwnerDetails(String gymOwnerEmailId);

	public void addGymOwnerDetails(GymOwner gymOwnerDetails);

	public void editGymOwnerDetails(GymOwner gymOwnerDetails);

	public Gym getGym(String gymId);

	public void addGym(Gym gymDetails);

	public void editGym(Gym gymDetails);

	public List<Gym> getGymsOfGymOwner(String gymOwnerId);

	public List<Slot> getPossibleSlots(String gymId);

	public void addSlot(Slot slot);

	public boolean checkOwnerApproval(String email);

	public boolean checkGymApproval(String gymId);
}
