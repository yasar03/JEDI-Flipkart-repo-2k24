/**
 * 
 */
package com.flipfit.business;

import com.flipfit.DAO.CustomerDAO;
import com.flipfit.DAO.CustomerDAOImpl;
import com.flipfit.bean.*;
import java.util.*;
import java.util.Date;
public class BookingBusiness implements BookingBusinessInterface{

	List<Booking> bookings=new ArrayList<>();
	Date d1=new Date(); //current date
	
	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	
	//	Booking b1=new Booking("123","121","171","confirmed",d1,"c1@gmail.com","John");
//	Booking b2=new Booking("173","191","131","waitlisted",d1,"c2@gmail.com","Jack");
//	Booking b3=new Booking("113","129","173","confirmed",d1,"c3@gmail.com","Johnathon");
//	Booking b4=new Booking("193","127","971","waitlisted",d1,"c4@gmail.com","J");
//
//	public BookingBusiness()
//	{
//		bookings.add(b1);
//		bookings.add(b2);
//		bookings.add(b3);
//		bookings.add(b4);
//	}

	public boolean isConfirmed(String bookingId) {

		for(Booking b:bookings)
		{
			if(b.getBookingId().equals(bookingId))
			{
				if(b.getType()=="confirmed")
					return true;
				else
					return false;
			}
		}
		return false;
	}

	public int getWaitingList() {
		return -1;
	}

}
