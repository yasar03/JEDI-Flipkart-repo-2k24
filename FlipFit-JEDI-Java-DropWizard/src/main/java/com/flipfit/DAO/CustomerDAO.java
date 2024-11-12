package com.flipfit.DAO;

import com.flipfit.bean.Booking;
import com.flipfit.bean.Gym;
import com.flipfit.exception.GymNotFoundException;
import com.flipfit.exception.NoSlotsFoundException;
import java.util.List;

public interface CustomerDAO {
	public List<Gym> fetchGymList() throws GymNotFoundException;
	
	public List<Gym> getGymInCity(String city) throws GymNotFoundException;

	public void fetchSlotList(String gymId) throws GymNotFoundException, NoSlotsFoundException;
	
	public void makePayment(String paymentId, String cardNumber, String cvv, String expiry, String upiId, String email);

	public List<Booking> fetchBookedSlots(String email);

	public void bookSlots(String bookingId, String slotId, String gymId, String type, String date, String customerEmail) throws GymNotFoundException;

	public boolean isFull(String slotId, String date);

	public boolean alreadyBooked(String slotId, String email, String date);

	public void cancelBooking(String slotId, String email);

	public boolean checkSlotExists(String slotId, String gymId);

	public boolean checkGymApprove(String gymId);
	
	public void editProfile(String email, String name, String phoneNumber, int age, String address);
}
