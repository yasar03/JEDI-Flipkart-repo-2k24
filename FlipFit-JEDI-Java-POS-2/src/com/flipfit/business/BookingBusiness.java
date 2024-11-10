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
