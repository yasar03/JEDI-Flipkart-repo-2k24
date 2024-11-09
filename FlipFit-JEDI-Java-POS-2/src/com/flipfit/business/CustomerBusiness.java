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
//	Customer customer1 = new Customer("c1@gmail.com", "c1", "Customer", "sample 1", "0000", 22, "Kanpur");
//	Customer customer2 = new Customer("c2@gmail.com", "c2", "Customer", "sample 2", "0000", 32, "Vadodara");
//	Customer customer3 = new Customer("c3@gmail.com", "c3", "Customer", "sample 3", "0000", 42, "Kolkata");
//	Customer customer4 = new Customer("c4@gmail.com", "c4", "Customer", "sample 4", "0000", 52, "Mumbai");
//
//
//	Booking b1 = new Booking("123", "121", "171", "confirmed", d1, "c1@gmail.com", "John");
//	Booking b2 = new Booking("173", "191", "131", "waitlisted", d1, "c2@gmail.com", "Jack");
//	Booking b3 = new Booking("113", "129", "173", "confirmed", d1, "c3@gmail.com", "Johnathon");
//	Booking b4 = new Booking("193", "127", "971", "waitlisted", d1, "c4@gmail.com", "J");
//
//	Slot s1 = new Slot("900", "1400", "1500", 100, "John", "g1");
//	Slot s2 = new Slot("910", "1500", "1600", 100, "J", "g2");
//	Slot s3 = new Slot("930", "1600", "1700", 100, "Jack", "g3");
//	Slot s4 = new Slot("950", "1700", "1800", 100, "Johnny", "g4");
//
//
//	Gym gym1 = new Gym("g1", "gym1", "gymowner1@gmail.com", "Kanpur", 2, 5, true);
//	Gym gym2 = new Gym("g2", "gym2", "gymowner2@gmail.com", "Hyderabad", 3, 5, true);
//	Gym gym3 = new Gym("g3", "gym3", "gymowner3@gmail.com", "Bangalore", 2, 3, true);
//	Gym gym4 = new Gym("g4", "gym4", "gymowner4@gmail.com", "Cochin", 6, 5, true);
//
//	public CustomerBusiness() {
//		customers.add(customer1);
//		customers.add(customer2);
//		customers.add(customer3);
//		customers.add(customer4);
//
//		bookings.add(b1);
//		bookings.add(b2);
//		bookings.add(b3);
//		bookings.add(b4);
//
//		slots.add(s1);
//		slots.add(s2);
//		slots.add(s3);
//		slots.add(s4);
//
//		gyms.add(gym1);
//		gyms.add(gym2);
//		gyms.add(gym3);
//		gyms.add(gym4);
//	}
	
	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	public List<Gym> fetchGymList() {
		System.out.println("Fetched Gym list successfully!");
        try {
            return customerDAO.fetchGymList();
        } catch (GymNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void fetchSlotList(String gymId) throws NoSlotsFoundException, GymNotFoundException {
		System.out.println("Fetched Slot list successfully!");
//        try {
//            customerDAO.fetchSlotList(gymId);
//        } catch (Exception e) {
//            throw new NoSlotsFoundException("Gym not found");
//        }
		try {
			// Call the business layer method to fetch the slot list
			customerDAO.fetchSlotList(gymId);
		} catch (GymNotFoundException | NoSlotsFoundException e) {
//			System.out.println(e.getMessage());
			
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
//		for (Customer cust : customers) {
//			if (cust.getEmail().equals(customer.getEmail())) {
//				cust.setName(customer.getName());
//				cust.setPhoneNumber(customer.getPhoneNumber());
//				cust.setAge(customer.getAge());
//				cust.setAddress(customer.getAddress());
//				customers.add(cust);
//				System.out.println("Successfully edited your profile\ns");
//				break;
//			}
//		}
	}

	
//	public List<Booking> getBookings(String email) {
//		return bookings.stream()
//			.filter(b -> b.getCustomerEmail().equals(email))
//			.collect(Collectors.toList());
//	}
	public List<Booking> getBookings(String email) {
		customerDAO.fetchBookedSlots(email);
		List<Booking> customerBookings = new ArrayList<>();
//		System.out.println("Booking List: "+ bookings);
//		for (Booking b : bookings) {
//			System.out.println("Booking Email: "+ b.getCustomerEmail());
//			if (b.getCustomerEmail().equals(email)) {
//				customerBookings.add(b);
//			}
//		}
//		System.out.println("Booking List: "+ customerBookings);
		return customerBookings;
//		return customerDAO.fetchBookedSlots(email);
	}

	public boolean cancelBooking(String bookingId, String email) {
		customerDAO.cancelBooking(bookingId, email);
//		for (Booking booking : bookings) {
//			if (booking.getBookingId().equals(bookingId)) {
//				bookings.remove(booking);
//				System.out.println("Successfully cancelled your booking");
//				return true;
//			}
//		}
		return false;
	}

	
	public List<Gym> getGymInCity(String city) {
		return gyms.stream()
			.filter(g -> g.getAddress().equals(city))
			.collect(Collectors.toList());
	}
//	public List<Gym> getGymInCity(String city) {
//		List<Gym> newGym = new ArrayList<Gym>();
//		for (Gym gym : gyms) {
//			if (gym.getAddress().equals(city)) {
//				newGym.add(gym);
//			}
//		}
//		return newGym;
//	}

	public List<Slot> getSlotInGym(String gymId) {
		
		
		return slots.stream()
			.filter(s -> s.getGymId().equals(gymId))
			.collect(Collectors.toList());
	}
//	public List<Slot> getSlotInGym(String gymId) {
//		List<Slot> slotsOfGym = new ArrayList<>();
//		for (Slot s : slots) {
//			if (s.getGymId().equals(gymId)) {
//				slotsOfGym.add(s);
//			}
//		}
//		return slotsOfGym;
//	}

	public void bookSlot(String bookingId, String gymId, String slotId, String date, String email) {
//		List<Booking> tempBookings = getBookings(email);
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
//		try {
			customerDAO.makePayment(paymentId, cardNumber, cvv, expiryDate, upiId, email);
//		} catch (GymNotFoundException e) {
//			throw new RuntimeException(e);
//		}
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
