package com.flipfit.application;

import com.flipfit.business.GYMCustomerBusiness;
import com.flipfit.business.GYMCustomerBusinessImpl;

public class GYMCustomer {
    public static void main(String[] args) {
        System.out.println("Hello from GYMCustomer");
        
        GYMCustomerBusiness service = new GYMCustomerBusinessImpl();
        System.out.println(service.createCustomer("Sample Name", "example.com", "Sample Address", "password"));
        System.out.println(service.deleteCustomer(1));
        System.out.println(service.updateCustomer(1));
        service.listCustomer();
        service.viewBookings(1);
        service.makeBooking(1, 1);
        service.cancelBooking(1, 1);
    }
    
}
