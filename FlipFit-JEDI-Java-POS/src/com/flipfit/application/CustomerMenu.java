package com.flipfit.application;

import com.flipfit.bean.Booking;
import com.flipfit.bean.Payment;
import com.flipfit.exception.GymNotFoundException;
import com.flipfit.exception.NoSlotsFoundException;
import com.flipfit.utils.IdGenerator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.flipfit.bean.Customer;
import com.flipfit.bean.Gym;
import com.flipfit.bean.Slot;
import com.flipfit.business.CustomerBusiness;
import com.flipfit.business.UserBusiness;

public class CustomerMenu {

	Customer customer = new Customer();
	CustomerBusiness customerBusiness = new CustomerBusiness();
	Scanner sc = new Scanner(System.in);
	
	public void addBooking(String gymId, String slotId, String date, String email) {
		Booking booking = new Booking();
		String bookingId = IdGenerator.generateId("Booking");
		booking.setBookingId(bookingId);
		booking.setSlotId(slotId);
		booking.setGymId(gymId);
		booking.setDate(date);
		booking.setCustomerEmail(email);
		customerBusiness.bookSlot(bookingId, gymId, slotId, date, email);
	}

	public void registerCustomer() {
		System.out.print("Enter email: ");
		customer.setEmail(sc.next());
		System.out.print("Enter password: ");
		customer.setPassword(sc.next());
		System.out.print("Enter Name: ");
		customer.setName(sc.next());
		System.out.print("Enter Phone Number: ");
		customer.setPhoneNumber(sc.next());
		System.out.print("Enter Age: ");
		customer.setAge(Integer.valueOf(sc.next()));
		System.out.print("Enter Address: ");
		customer.setAddress(sc.next());
		UserBusiness userBusiness = new UserBusiness();
		userBusiness.registerCustomer(customer);

		System.out.println("Customer registered successfully!");

	}
	
	public void makePayment(String cardNumber, String cvv, String expiryDate, String upiId, String email) {
		Payment payment = new Payment();
		String payementId = IdGenerator.generateId("Payment");
		payment.setPaymentId(payementId);
		payment.setCardNumber(cardNumber);
		payment.setCardPIN(cvv);
		payment.setCardExpiry(expiryDate);
		payment.setUpiId(upiId);
		customerBusiness.makePayments(payementId, cardNumber, cvv, expiryDate, upiId, email);
		
	}
	
	
	public void viewGymsByCity(String email) {
		System.out.print("Enter your city: ");
		List<Gym> gyms = customerBusiness.getGymInCity(sc.next());
		if(gyms.isEmpty()) {
			System.out.println("No gyms found in the city");
			return;
		}
		gyms.forEach(gym -> {
			System.out.println("Gym Id: " + gym.getGymId());
			System.out.println("Gym Owner Email: " + gym.getOwnerEmail());
			System.out.println("Gym Name: " + gym.getGymName());
			System.out.println();
		});
		
		System.out.print("Enter gym ID: ");
		String gymId = sc.next();
		System.out.print("Enter Date (yyyy-mm-dd): ");
		String dateStr = sc.next();
		
		try {
			customerBusiness.fetchSlotList(gymId);
			System.out.print("Enter the slot ID which you want to book: ");
			String slotId = sc.next();
			
			System.out.println("Mode of Payment: \n1. Online \n2. Offline");
			System.out.print("Enter your choice: ");
			int paymentChoice = sc.nextInt();
			
			if (paymentChoice == 1) {
				System.out.println("Payment options: \n1. Credit Card \n2. Debit Card \n3. UPI");
				System.out.print("Enter your choice: ");
				int paymentOption = 0;
				paymentOption = sc.nextInt();
				if (paymentOption == 1) {
					System.out.println("Enter Credit Card Number: ");
					String cardNumber = sc.next();
					System.out.println("Enter CVV: ");
					String cvv = sc.next();
					System.out.println("Enter Expiry Date: ");
					String expiryDate = sc.next();
					makePayment(cardNumber, cvv, expiryDate, null, email);
				} else if (paymentOption == 2) {
					System.out.println("Enter Debit Card Number: ");
					String cardNumber = sc.next();
					System.out.println("Enter CVV: ");
					String cvv = sc.next();
					System.out.println("Enter Expiry Date: ");
					String expiryDate = sc.next();
					makePayment(cardNumber, cvv, expiryDate, null, email);
				} else if (paymentOption == 3) {
					System.out.println("Enter UPI ID: ");
					String upiId = sc.next();
					makePayment(null, null, null, upiId, email);
				} else {
					System.out.println("Invalid choice");
				}
				
			} else {
				System.out.println("Payment pending");
			}
			addBooking(gymId,slotId, dateStr, email);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void viewGyms(String email) throws ParseException {

		CustomerBusiness customerBusiness = new CustomerBusiness();
		
		List<Gym> gym = customerBusiness.fetchGymList();
		
		gym.forEach(g -> {
			System.out.println("Gym ID: "+g.getGymId());
			System.out.println("Gym Name: "+g.getGymName());
			System.out.println("Gym Owner Email: "+g.getOwnerEmail());
			System.out.println("Gym Address: "+g.getAddress());
			System.out.println("Gym Approval Status: "+g.isVerified());
			System.out.println();
		});
		System.out.print("Enter gym ID: ");
		String gymId = sc.next();
		System.out.print("Enter Date (yyyy-mm-dd): ");
		String dateStr = sc.next();
        
        try {
            customerBusiness.fetchSlotList(gymId);
			System.out.print("Enter the slot ID which you want to book: ");
			String slotId = sc.next();
			
			System.out.println("Mode of Payment: \n1. Online \n2. Offline");
			System.out.print("Enter your choice: ");
			int paymentChoice = sc.nextInt();
			
			if (paymentChoice == 1) {
				System.out.println("Payment options: \n1. Credit Card \n2. Debit Card \n3. UPI");
				System.out.print("Enter your choice: ");
				int paymentOption = 0;
				paymentOption = sc.nextInt();
				if (paymentOption == 1) {
					System.out.println("Enter Credit Card Number: ");
					String cardNumber = sc.next();
					System.out.println("Enter CVV: ");
					String cvv = sc.next();
					System.out.println("Enter Expiry Date: ");
					String expiryDate = sc.next();
					makePayment(cardNumber, cvv, expiryDate, null, email);
				} else if (paymentOption == 2) {
					System.out.println("Enter Debit Card Number: ");
					String cardNumber = sc.next();
					System.out.println("Enter CVV: ");
					String cvv = sc.next();
					System.out.println("Enter Expiry Date: ");
					String expiryDate = sc.next();
					makePayment(cardNumber, cvv, expiryDate, null, email);
				} else if (paymentOption == 3) {
					System.out.println("Enter UPI ID: ");
					String upiId = sc.next();
					makePayment(null, null, null, upiId, email);
				} else {
					System.out.println("Invalid choice");
				}
				
			} else {
				System.out.println("Payment pending");
			}
			addBooking(gymId,slotId, dateStr, email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
		}
		

	}

	public void editProfile(String email) {
		System.out.print("Enter Name: ");
		String name = sc.next();
		System.out.print("Enter Phone Number: ");
		String phone = sc.next();
		System.out.print("Enter Age: ");
		int age = sc.nextInt();
		System.out.print("Enter Address: ");
		String address = sc.next();
		customerBusiness.editProfile(email, name, phone, age, address);
	}

	

	public void cancelBooking(String email) {
		System.out.print("Enter booking ID that you want to cancel: ");
		String bookingId = sc.next();
		customerBusiness.cancelBooking(bookingId, email);
	}

	public void customerMenu(String email) throws ParseException {
		int choice = 0;

		while (choice != 5) {
			System.out.println("Menu:-");
			System.out.println("1.View All Gyms \n2.View Gyms by City\n3.View Booked Slots \n4.Cancel Booked Slots \n5.Edit Profile \n6.Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				viewGyms(email);
				break;
			case 2:
				viewGymsByCity(email);
				break;
			case 3:
				customerBusiness.getBookings(email);
				break;
			case 4:
				cancelBooking(email);
				break;
			case 5:
				editProfile(email);
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
