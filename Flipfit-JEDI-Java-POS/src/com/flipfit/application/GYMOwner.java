package com.flipfit.application;

import com.flipfit.business.GYMOwnerBusiness;
import com.flipfit.business.GYMOwnerBusinessImpl;

public class GYMOwner {
    public static void main(String[] args) {
        System.out.println("Welcome to FlipFit!");
        
        GYMOwnerBusiness gymOwnerService = new GYMOwnerBusinessImpl();
        gymOwnerService.gymAddition();
        gymOwnerService.gymDeletion(1);
        gymOwnerService.addSlots(1, 1);
        gymOwnerService.removeSlots(1, 1);
        
        
        
        
    }
}
