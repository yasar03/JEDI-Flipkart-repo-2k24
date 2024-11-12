package com.flipfit.business;

import com.flipfit.bean.*;
import java.util.*;

public interface AdminBusinessInterface{
    /**
     *
     * @return List of all GymOwners
     */
    public List<GymOwner> getGymOwners();
    
    /**
     *
     * @return List of all Gyms
     */
    public List<Gym> getGym() ;
    /**
     *
     * @return List of GymOwners whose requests are pending for approval
     */
    public List<GymOwner> viewAllPendingGymOwnerRequests();
    /**
     *
     * @return boolean
     */
    public boolean approveSingleGymOwnerRequest(String gymOwnerEmail);
    /**
     *
     * @return boolean
     */
    public boolean approveAllPendingGymOwnerRequests();
    /**
     *
     * @return List of Gyms whose requests are pending for approval
     */
    public List<Gym> viewAllPendingGymRequests();
    /**
     *
     * @return boolean
     */
    public boolean approveSingleGymRequest(String gymId);
    /**
     *
     * @return boolean
     */
    public boolean approveAllPendingGymRequests();
    
}
