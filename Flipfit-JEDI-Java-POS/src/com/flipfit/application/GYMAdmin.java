package com.flipfit.application;

import com.flipfit.business.Booking;
import com.flipfit.business.BookingImpl;
import com.flipfit.business.GYMAdminBusiness;
import com.flipfit.business.GYMAdminBusinessImpl;

public class GYMAdmin {
    public static void main(String args) {
        System.out.println("Hello from GYMAdmin");
        
        GYMAdminBusiness adminService = new GYMAdminBusinessImpl();
        adminService.sendNotification("Sample message");
        adminService.addGYM(1, "Sample GYM", "Sample Address");
        adminService.removeGYM(1);
        adminService.listGYM();
        adminService.addCustomerInWaitingList(1, 1);
        adminService.removeCustomerFromWaitingList(1, 1);
        
        Booking booking = new BookingImpl();
        booking.confirmBooking(1, 1);
        booking.cancelBooking(1, 1);
        booking.getCenter();
        
        
    }
}
