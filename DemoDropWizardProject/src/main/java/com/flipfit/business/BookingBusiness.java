/**
 * 
 */
package com.flipfit.business;

import com.flipfit.DAO.CustomerDAO;
import com.flipfit.DAO.CustomerDAOImpl;
import com.flipfit.bean.Booking;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class BookingBusiness implements BookingBusinessInterface{

	List<Booking> bookings=new ArrayList<>();
	Date d1=new Date(); //current date
	
	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	
	/**
	 * Checks if a booking is confirmed or not for the given bookingId
	 * @param bookingId the id of a booking that needs to be checked
	 * @return true if the bookingId is confirmed else returns false
	 */
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
