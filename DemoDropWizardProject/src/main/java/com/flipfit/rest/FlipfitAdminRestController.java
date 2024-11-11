package com.flipfit.rest;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;
import com.flipfit.business.AdminBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class FlipfitAdminRestController {
    
    private final AdminBusiness adminBusiness;
    
    public FlipfitAdminRestController() {
        this.adminBusiness = new AdminBusiness();
    }
    
    @GET
    @Path("/gyms")
    public Response viewAllGyms() {
        List<Gym> gymList = adminBusiness.getGym();
        return Response.ok(gymList).build();
    }
    
    @GET
    @Path("/gym-owners")
    public Response viewAllGymOwners() {
        List<GymOwner> gymOwnerList = adminBusiness.getGymOwners();
        return Response.ok(gymOwnerList).build();
    }
    
    @GET
    @Path("/pending-gym-owner-requests")
    public Response viewAllPendingGymOwnerRequests() {
        List<GymOwner> pendingGymOwners = adminBusiness.viewAllPendingGymOwnerRequests();
        return Response.ok(pendingGymOwners).build();
    }
    
    @GET
    @Path("/pending-gym-requests")
    public Response viewAllPendingGymRequests() {
        List<Gym> pendingGyms = adminBusiness.viewAllPendingGymRequests();
        return Response.ok(pendingGyms).build();
    }
    
    @POST
    @Path("/approve-gym-owner")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response approveSingleGymOwnerRequest(String email) {
        adminBusiness.approveSingleGymOwnerRequest(email);
        return Response.status(Response.Status.OK).entity("Gym Owner approved").build();
    }
    
    @POST
    @Path("/approve-gym")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response approveSingleGymRequest(String gymId) {
        adminBusiness.approveSingleGymRequest(gymId);
        return Response.status(Response.Status.OK).entity("Gym approved").build();
    }
    
    @POST
    @Path("/approve-all-gym-owners")
    public Response approveAllGymOwnerRequests() {
        adminBusiness.approveAllPendingGymOwnerRequests();
        return Response.status(Response.Status.OK).entity("All pending Gym Owner requests approved").build();
    }
    
    @POST
    @Path("/approve-all-gyms")
    public Response approveAllGymRequests() {
        adminBusiness.approveAllPendingGymRequests();
        return Response.status(Response.Status.OK).entity("All pending Gym requests approved").build();
    }
}
