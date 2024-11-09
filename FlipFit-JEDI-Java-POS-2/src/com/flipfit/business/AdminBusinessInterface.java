package com.flipfit.business;

import com.flipfit.bean.*;
import java.util.*;

public interface AdminBusinessInterface{
	 
    public List<GymOwner> getGymOwners();
    
    public List<Gym> getGym() ;
    
    public List<GymOwner> viewAllPendingGymOwnerRequests();
  
    public boolean approveSingleGymOwnerRequest(String gymOwnerEmail);
   
    public boolean approveAllPendingGymOwnerRequests();
   
    public List<Gym> viewAllPendingGymRequests();
    
    public boolean approveSingleGymRequest(String gymId);
   
    public boolean approveAllPendingGymRequests();
    
}
