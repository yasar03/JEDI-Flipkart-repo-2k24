package com.flipfit.application;

import com.flipfit.business.GYMOwnerBusiness;
import com.flipfit.business.GYMOwnerBusinessImpl;
import java.util.Scanner;

public class GYMOwnerMenu {
    Scanner sc = new Scanner(System.in);
    public void ownerRegistration(){
        
        /* name address slots availavke, slot timings*/
        
        Scanner scanner = new Scanner(System.in);
        /*name address email password*/
        
        
        
        System.out.println("Enter Gym name: ");
        String gymName = scanner.nextLine();
        
        System.out.println("Enter Gym address: ");
        String gymAddress = scanner.nextLine();
        
        System.out.println("Enter Number of available Slots: ");
        int numberOfSlots = scanner.nextInt();
        
        int [] slots = new int[numberOfSlots];
        
        for (int i = 0; i < numberOfSlots; i++) {
            slots[i] = scanner.nextInt();
        }
        
        
        GYMOwnerBusiness gymServer = new GYMOwnerBusinessImpl();
        gymServer.gymAddition(gymName,gymAddress,numberOfSlots,slots);
        
    }
    public void OwnerOperationList() {
        System.out.println("Welcome GYM Owner");
        System.out.println("1. View Profile\n2. Add GYM\n3. Edit GYM\n4. Remove GYM\n5. Add Slots\n6. Remove Slots");
        
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        GYMOwnerBusiness gymServer = new GYMOwnerBusinessImpl();
        switch (choice) {
            case 1:
                gymServer.viewProfile();
                break;
            case 2:
                System.out.println("Enter Gym name: ");
                String gymName = sc.nextLine();
                System.out.println("Enter Gym address: ");
                String gymAddress = sc.nextLine();
                System.out.println("Enter Number of available Slots: ");
                int numberOfSlots = sc.nextInt();
                int [] slots = new int[numberOfSlots];
                for (int i = 0; i < numberOfSlots; i++) {
                    slots[i] = sc.nextInt();
                }
                gymServer.gymAddition(gymName, gymAddress, numberOfSlots, slots);
                break;
            case 3:
                System.out.println("Enter Gym ID: ");
                int gymId = sc.nextInt();
                System.out.println("Enter Gym name: ");
                String gymNameEdited = sc.nextLine();
                System.out.println("Enter Gym address: ");
                String gymAddressEdited = sc.nextLine();
                System.out.println("Enter Number of available Slots: ");
                int numberOfSlotsEdited = sc.nextInt();
                int [] slotsEdited = new int[numberOfSlotsEdited];
                for (int i = 0; i < numberOfSlotsEdited; i++) {
                    slotsEdited[i] = sc.nextInt();
                }
                gymServer.gymEdit(gymId, gymNameEdited, gymAddressEdited, numberOfSlotsEdited, slotsEdited);
                
                break;
            case 4:
                gymServer.gymDeletion(1);
                break;
            case 5:
                System.out.println("Enter Number of Slots: ");
                int slotsToAdd = sc.nextInt();
                gymServer.addSlots(slotsToAdd, 1);
                break;
            case 6:
                System.out.println("Enter Number of Slots: ");
                int slotsToRemove = sc.nextInt();
                gymServer.removeSlots(slotsToRemove, 1);
                break;
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to FlipFit!");
        
        GYMOwnerBusiness gymOwnerService = new GYMOwnerBusinessImpl();
        gymOwnerService.gymAddition("Sample Gym", "Sample Address", 1, new int[]{1});
        gymOwnerService.gymDeletion(1);
        gymOwnerService.addSlots(1, 1);
        gymOwnerService.removeSlots(1, 1);
        
        
        
        
    }
}
