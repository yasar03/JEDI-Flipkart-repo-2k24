package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.exception.InvalidInputException;
import java.util.*;

public interface GymOwnerBusinessInterface{
    public GymOwner getProfile(String email);
   
    public void editProfile(GymOwner gymOwnerNews);
 
    public boolean addGym(Gym gym, String slotCount, String seatCountPerSlot) throws InvalidInputException;

    public void editGym(Gym gym);

    public List<Gym> getGymDetail(String gymOwnerEmail);

    public boolean isApproved(String email);

    public boolean isGymApproved(String gymId);
   
}