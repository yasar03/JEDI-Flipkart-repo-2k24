/**
 * 
 */
package com.flipfit.bean;

import java.util.Date;

/**
 * 
 */
public class Booking {
	private String bookingId;
	private String slotId;
	private String gymId;
	private String type;
	private String date;
	private String customerEmail;

	public Booking() {
		super();
	}//default constructor

	public Booking(String bookingId,String slotId,String gymId,String type,String date,String customerEmail,String trainer)
	{
		this.bookingId=bookingId;
		this.slotId=slotId;
		this.gymId=gymId;
		this.type=type;
		this.date=date;
		this.customerEmail=customerEmail;
	}


	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public String getGymId() {
		return gymId;
	}

	public void setGymId(String gymId) {
		this.gymId = gymId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

}
