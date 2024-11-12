package com.flipfit.rest;


import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymRequest;
import com.flipfit.bean.Slot;
import com.flipfit.business.GymOwnerBusiness;
import com.flipfit.business.UserBusiness;
import com.flipfit.exception.InvalidInputException;
import com.flipfit.utils.IdGenerator;

import javax.ws.rs.*;
    import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gym-owner")
@Produces(MediaType.APPLICATION_JSON)
public class FlipfitOwnerRestController {
    
    private final GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();
    private final UserBusiness userBusiness = new UserBusiness();

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerGymOwner(GymOwner gymOwner) {
        boolean registerSuccess = userBusiness.registerGymOwner(gymOwner);
        if (registerSuccess) {
            return Response.status(Response.Status.CREATED).entity("Gym Owner registered successfully!").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Gym Owner registration failed! Try again!").build();
        }
    }

    @GET
    @Path("/profile/{email}")
    public Response viewProfile(@PathParam("email") String email) {
        GymOwner gymOwner = gymOwnerBusiness.getProfile(email);
        return Response.ok(gymOwner).build();
    }

    @POST
    @Path("/profile/edit/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editProfile(@PathParam("email") String email, GymOwner updatedGymOwner) {
        updatedGymOwner.setEmail(email); // Ensure email is set
        gymOwnerBusiness.editProfile(updatedGymOwner);
        return Response.ok("Profile updated successfully!").build();
    }
    
    @POST
    @Path("/gym")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGym(GymRequest gymRequest) throws InvalidInputException {
        Gym gym = gymRequest.getGym();
        gym.setGymId(IdGenerator.generateId("Gym"));
        gym.setVerified(false);  // Default to unverified
        
        gymOwnerBusiness.addGym(gym, gymRequest.getSlotCount(), gymRequest.getSeatPerSlotCount());
        return Response.status(Response.Status.CREATED).entity("Gym added successfully!").build();
    }
    
    
    @POST
    @Path("/gym/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editGym(Gym updatedGym) {
//        updatedGym.setGymId(gymId); // Ensure gymId is set
        gymOwnerBusiness.editGym(updatedGym);
        
        return Response.ok(updatedGym.getGymName()).build();
    }

    @GET
    @Path("/gyms/{email}")
    public Response getGymDetails(@PathParam("email") String email) {
        List<Gym> gyms = gymOwnerBusiness.getGymDetail(email);
        return Response.ok(gyms).build();
    }

    @POST
    @Path("/add-slot")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSlot(Slot slot) {
        slot.setSlotId(IdGenerator.generateId("Slot"));
        gymOwnerBusiness.addSlot(slot);
        return Response.status(Response.Status.CREATED).entity("Slot added successfully!").build();
    }

    @GET
    @Path("/logout/{email}")
    public Response logOut(@PathParam("email") String email) {
        GymOwner gymOwner = new GymOwner();
        gymOwner.setEmail(email);
        boolean logOutSuccess = userBusiness.logout(gymOwner);
        if (logOutSuccess) {
            return Response.ok("Logged Out Successfully!").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Logout failed!").build();
        }
    }
}
