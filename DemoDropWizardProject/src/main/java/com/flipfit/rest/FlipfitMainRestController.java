package com.flipfit.rest;


import com.flipfit.bean.GymOwner;
import com.flipfit.bean.PasswordUpdateRequest;
import com.flipfit.business.UserBusiness;
import com.flipfit.business.UserBusinessInterface;
import com.flipfit.bean.User;
import com.flipfit.business.GymOwnerBusiness;
import com.flipfit.business.GymOwnerBusinessInterface;

import io.dropwizard.jersey.params.IntParam;
import javax.ws.rs.*;
    import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Path("/application")
@Produces(MediaType.APPLICATION_JSON)
public class FlipfitMainRestController {
    
    private static UserBusinessInterface userBusiness = new UserBusiness();
    private static GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
    // Login Endpoint
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        String userEmail = user.getEmail();
        String password = user.getPassword();
        String roleId = user.getRoleId();
        
        if (userBusiness.authenticateUser(user)) {
            // Getting the current date and time
            LocalDateTime loginTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedLoginTime = loginTime.format(formatter);
            
            String message = "Welcome " + userEmail + "! You are logged in at " + formattedLoginTime;
            return Response.ok(message).build();
        } else {
            return Response.status(Response.Status.FORBIDDEN)
                .entity("Sorry! You are not Registered! Please Register Yourself!")
                .build();
        }
    }
    
    // Update Password Endpoint
    @POST
    @Path("/updatePassword")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePassword(PasswordUpdateRequest request) {
        String userEmail = request.getEmail();
        String password = request.getPassword();
        String rePassword = request.getRePassword();
        
        if (!password.equals(rePassword)) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Passwords do not match!")
                .build();
        }
        
        if (userBusiness.updatePassword(userEmail, password)) {
            return Response.ok("Password Updated Successfully!").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Password Update Failed!")
                .build();
        }
    }
    
    // Registration Endpoint for Customer
    @POST
    @Path("/registerCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerCustomer(User user) {
        // Call customer registration logic here
        return Response.ok("Customer Registered Successfully!").build();
    }
    
    // Registration Endpoint for Gym Owner
    @POST
    @Path("/registerGymOwner")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerGymOwner(GymOwner gymOwner) {
        // Call gym owner registration logic here
        userBusiness.registerGymOwner(gymOwner);
        return Response.ok("Gym Owner Registered Successfully!").build();
    }
}

