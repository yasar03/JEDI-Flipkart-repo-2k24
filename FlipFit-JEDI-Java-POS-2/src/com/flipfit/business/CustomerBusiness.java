/**
 *
 */
package com.flipfit.business;

import com.flipfit.DAO.CustomerDAO;
import com.flipfit.DAO.CustomerDAOImpl;
import com.flipfit.bean.*;
import com.flipfit.constants.*;
import com.flipfit.exception.GymNotFoundException;
import com.flipfit.exception.NoSlotsFoundException;
import com.flipfit.utils.IdGenerator;

import java.util.Date;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerBusiness implements CustomerBusinessInterface {

	List<Customer> customers = new ArrayList<>();
	List<Booking> bookings = new ArrayList<>();

	List<Slot> slots = new ArrayList<>();
	List<Gym> gyms = new ArrayList<>();

	Date d1 = new Date();

	
	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	public List<Gym> fetchGymList() {
		System.out.println("Fetched Gym list successfully!");
        try {
            return customerDAO.fetchGymList();
        } catch (GymNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	
	public List<Gym> getGymInCity(String city) {
        try {
            return customerDAO.getGymInCity(city);
        } catch (GymNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void fetchSlotList(String gymId) throws NoSlotsFoundException, GymNotFoundException {
		System.out.println("Fetched Slot list successfully!");

		try {
			// Call the business layer method to fetch the slot list
			customerDAO.fetchSlotList(gymId);
		} catch (GymNotFoundException | NoSlotsFoundException e) {
			throw e;
		}
    }
	

	public Customer getProfile(Customer customer) {
		for (Customer cust : customers) {
			if (cust.getEmail().equals(customer.getEmail()))
				return cust;
		}
		return null;
	}

	
	public void editProfile(String email, String name, String phoneNumber, int age, String address) {
		customerDAO.editProfile(email, name, phoneNumber, age, address);
	}

	
	public List<Booking> getBookings(String email) {
		customerDAO.fetchBookedSlots(email);
		List<Booking> customerBookings = new ArrayList<>();

		return customerBookings;
	}

	public boolean cancelBooking(String bookingId, String email) {
		customerDAO.cancelBooking(bookingId, email);
		return false;
	}



	public List<Slot> getSlotInGym(String gymId) {
		
		
		return slots.stream()
			.filter(s -> s.getGymId().equals(gymId))
			.collect(Collectors.toList());
	}


	public void bookSlot(String bookingId, String gymId, String slotId, String date, String email) {
		CustomerDAO customerDAO = new CustomerDAOImpl();
        try {
            customerDAO.bookSlots(bookingId, slotId, gymId, "", date, email);
        } catch (GymNotFoundException e) {
            throw new RuntimeException(e);
        }

//		boolean flag=false;
//		for(Booking booking:bookings)
//		{
//			if(booking.getCustomerEmail().equals(email) && booking.getType().equals("confirmed"))
//			{
//				flag=true;
//				tempBookings.add(booking);
//			}
//		}
//		if(flag)
//		{
//			boolean isDate=false;
//			for(Booking booking:tempBookings)
//			{
//				if(booking.getDate().equals(date))
//				{
//					isDate=true;
//					for(Slot slot:slots)
//					{
//						if(slot.getSlotId().equals(slotId) && !slot.getGymId().equals(gymId))
//						{
//							int num=slot.getNumOfSeatsBooked();
//							if(!isSlotBooked(slotId,date))
//							{
//								slot.setNumOfSeatsBooked(num--);
//								Booking getBooking = new Booking();
//								getBooking.setBookingId(IdGenerator.generateId("Booking"));
//								Booking tempBooking=new Booking(getBooking.getBookingId(),slotId,slot.getGymId(),"confirmed",date,email,slot.getTrainer());
//								bookings.add(tempBooking);
//								bookings.remove(booking);
//								return 0;
//							}
//							else
//							{
//								slot.setNumOfSeatsBooked(num--);
//								Booking getBooking = new Booking();
//								getBooking.setBookingId(IdGenerator.generateId("Booking"));
//								Booking tempBooking=new Booking(getBooking.getBookingId(),slotId,slot.getGymId(),"waitlisted",date,email,slot.getTrainer());
//								bookings.add(tempBooking);
//								return 1;
//							}
//						}
//					}
//					return 3;
//				}
//			}
//			if(!isDate)
//			{
//				for(Slot slot:slots)
//				{
//					if(slot.getSlotId().equals(slotId) && slot.getGymId().equals(gymId))
//					{
//						int num=slot.getNumOfSeatsBooked();
//						slot.setNumOfSeatsBooked(num--);
//						Booking getBooking = new Booking();
//						getBooking.setBookingId(IdGenerator.generateId("Booking"));
//						if(!isSlotBooked(slotId,date))
//						{
//							Booking tempBooking=new Booking(getBooking.getBookingId(),slotId,slot.getGymId(),"confirmed",date,email,slot.getTrainer());
//							bookings.add(tempBooking);
//							return 2;
//						}
//						else
//						{
//							Booking tempBooking=new Booking(getBooking.getBookingId(),slotId,slot.getGymId(),"waitlisted",date,email,slot.getTrainer());
//							bookings.add(tempBooking);
//							return 1;
//						}
//					}
//				}
//			}
//		}
//		else
//		{
//			for(Slot slot:slots)
//			{
//				if(slot.getSlotId().equals(slotId) && slot.getGymId().equals(gymId))
//				{
//					int num=slot.getNumOfSeatsBooked();
//					slot.setNumOfSeatsBooked(num--);
//					Booking getBooking = new Booking();
//					getBooking.setBookingId(IdGenerator.generateId("Booking"));
//					if(!isSlotBooked(slotId,date))
//					{
//						Booking tempBooking=new Booking(getBooking.getBookingId(),slotId,slot.getGymId(),"confirmed",date,email,slot.getTrainer());
//						bookings.add(tempBooking);
//						return 2;
//					}
//					else
//					{
//						Booking tempBooking=new Booking(getBooking.getBookingId(),slotId,slot.getGymId(),"waitlisted",date,email,slot.getTrainer());
//						bookings.add(tempBooking);
//						return 1;
//					}
//				}
//			}
//			return 3;
//		}
//		return 1;
	}
	
	public void makePayments(String paymentId, String cardNumber, String cvv, String expiryDate, String upiId, String email) {
		CustomerDAO customerDAO = new CustomerDAOImpl();

			customerDAO.makePayment(paymentId, cardNumber, cvv, expiryDate, upiId, email);

	}

	public boolean isSlotBooked(String slotId, String date) {
		return slots.stream()
			.anyMatch(s -> s.getSlotId().equals(slotId) && s.getNumOfSeats() <= s.getNumOfSeatsBooked());
	}

	public boolean hasBookedSlotAlready(String slotId, String customerEmail, Date date) {
		return bookings.stream()
			.anyMatch(b -> b.getSlotId().equals(slotId) && b.getCustomerEmail().equals(customerEmail));
	}


}
