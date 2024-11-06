package com.flipfit.application;

import com.flipfit.business.GYMBooking;
import com.flipfit.business.GYMBookingImpl;
import com.flipfit.business.GYMAdminBusiness;
import com.flipfit.business.GYMAdminBusinessImpl;
import java.util.Scanner;

public class GYMAdminMenu {
    Scanner sc = new Scanner(System.in);
    public void AdminOperationList() {
        System.out.println("Welcome Admin");
        System.out.println("1. Send Notification\n2. Add GYM\n3. Remove GYM\n4. View list of GYMs\n5. Add Customer in Waiting List\n6. Remove Customer from Waiting List");
        
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        GYMAdminBusiness adminServer = new GYMAdminBusinessImpl();
        switch (choice) {
            case 1:
                System.out.println("Enter message: ");
                String message = sc.nextLine();
                adminServer.sendNotification(message);
                break;
            case 2:
                System.out.println("Enter GYM ID: ");
                int gymId = sc.nextInt();
                System.out.println("Enter GYM Name: ");
                String gymName = sc.nextLine();
                System.out.println("Enter GYM Address: ");
                String gymAddress = sc.nextLine();
                System.out.println("Enter GYM Owner ID: ");
                int ownerId = sc.nextInt();
                System.out.println("Enter GYM Slots: ");
                int numberOfSlots = sc.nextInt();
                int [] slots = new int[numberOfSlots];
                for (int i = 0; i < numberOfSlots; i++) {
                    slots[i] = sc.nextInt();
                }
                adminServer.addGYM(gymId, gymName, gymAddress, ownerId, slots);
                break;
            case 3:
                System.out.println("Enter GYM ID: ");
                int gymId1 = sc.nextInt();
                adminServer.removeGYM(gymId1);
                break;
            case 4:
                adminServer.listGYM();
                break;
            case 5:
                System.out.println("Enter GYM ID: ");
                int gymId2 = sc.nextInt();
                System.out.println("Enter Customer ID: ");
                int customerId = sc.nextInt();
                adminServer.addCustomerInWaitingList(gymId2, customerId);
                break;
            case 6:
                System.out.println("Enter GYM ID: ");
                int gymId3 = sc.nextInt();
                System.out.println("Enter Customer ID: ");
                int customerId1 = sc.nextInt();
                adminServer.removeCustomerFromWaitingList(gymId3, customerId1);
                break;
        }
        
    }
    public static void main(String args) {
        System.out.println("Hello from GYMAdmin");
        
        GYMAdminBusiness adminService = new GYMAdminBusinessImpl();
        adminService.sendNotification("Sample message");
        adminService.addGYM(1, "Sample GYM", "Sample Address", 1, new int[]{1});
        adminService.removeGYM(1);
        adminService.listGYM();
        adminService.addCustomerInWaitingList(1, 1);
        adminService.removeCustomerFromWaitingList(1, 1);
        
        GYMBooking GYMBooking = new GYMBookingImpl();
        GYMBooking.confirmBooking(1, 1);
        GYMBooking.cancelBooking(1, 1);
        GYMBooking.getCenter();
        
        
    }
}
