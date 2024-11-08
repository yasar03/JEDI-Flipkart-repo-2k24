package com.flipfit.DAO;

import com.flipfit.exception.GymNotFoundException;
import java.util.Date;
import java.util.List;

import com.flipfit.bean.Gym;
import com.flipfit.exception.NoSlotsFoundException;

public interface CustomerDAO {
	public List<Gym> fetchGymList() throws GymNotFoundException;

	public void fetchSlotList(String gymId) throws GymNotFoundException, NoSlotsFoundException;

	public void fetchBookedSlots(String email);

	public void bookSlots(String bookingId, String slotId, String gymId, String type, String date, String customerEmail) throws GymNotFoundException;

	public boolean isFull(String slotId, String date);

	public boolean alreadyBooked(String slotId, String email, String date);

	public void cancelBooking(String slotId, String email, String date);

	public boolean checkSlotExists(String slotId, String gymId);

	public boolean checkGymApprove(String gymId);
}
