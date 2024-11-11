package com.flipfit.rest;

import com.flipfit.bean.Booking;
import com.flipfit.bean.BookingRequest;
import com.flipfit.bean.Customer;
import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.Payment;
import com.flipfit.business.AdminBusiness;
import com.flipfit.business.CustomerBusiness;
import com.flipfit.utils.IdGenerator;
import io.dropwizard.jersey.params.IntParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class FlipfitCustomerRestController {
    
    public CustomerBusiness customerBusiness;
    
    public FlipfitCustomerRestController() {
        this.customerBusiness = new CustomerBusiness();
    }
    
    @GET
    @Path("/gyms")
    public Response viewAllGyms() {
        List<Gym> gymList = customerBusiness.fetchGymList();
        return Response.ok(gymList).build();
    }
    
    @GET
    @Path("/gyms-by-city/{city}")
    public Response viewAllGymsByCity(@PathParam("city") String city) {
        List<Gym> gymList = customerBusiness.getGymInCity(city);
        return Response.ok(gymList).build();
    }
    
    @POST
    @Path("/book-slot/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bookSlot(@PathParam("email") String email, BookingRequest bookingRequest) {
        String bookingId = IdGenerator.generateId("Booking");
        
        customerBusiness.bookSlot(
            bookingId,
            bookingRequest.getGymId(),
            bookingRequest.getSlotId(),
            bookingRequest.getDate(),
            email
        );
        return Response.ok("Slot booked successfully!").build();
    }

    
    @POST
    @Path("/make-payment/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response makePayment(@PathParam("email") String email, Payment payments) {
        String paymentId = IdGenerator.generateId("Payment");
        customerBusiness.makePayments(paymentId, payments.getCardNumber(), payments.getCardPIN(), payments.getCardExpiry(), payments.getUpiId(), email);
        return Response.ok("Payment successful!").build();
    }
    
    @GET
    @Path("/booked-slots/{email}")
    public Response viewAllBookedSlots(@PathParam("email") String email) {
        List<Booking> gymList = customerBusiness.getBookings(email);
        return Response.ok(gymList).build();
    }
    
    @GET
    @Path("/cancel-booking/{email}")
    public Response cancelBooking(@PathParam("email") String email, String bookingId) {
        customerBusiness.cancelBooking(bookingId, email);
        return Response.ok("Booking cancelled successfully!").build();
    }
    
    @POST
    @Path("/edit-profile/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editProfile(@PathParam("email") String email, Customer updatedCustomer) {
        updatedCustomer.setEmail(email); // Ensure email is set
        customerBusiness.editProfile(updatedCustomer.getEmail(), updatedCustomer.getName(), updatedCustomer.getPhoneNumber(), updatedCustomer.getAge(), updatedCustomer.getAddress());
        return Response.ok("Profile updated successfully!").build();
    }
}

