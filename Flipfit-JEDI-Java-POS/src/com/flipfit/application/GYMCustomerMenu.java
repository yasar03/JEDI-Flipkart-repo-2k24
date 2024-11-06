package com.flipfit.application;

import com.flipfit.business.GYMCustomerBusiness;
import com.flipfit.business.GYMCustomerBusinessImpl;
import java.util.Scanner;

public class GYMCustomerMenu {
    Scanner sc = new Scanner(System.in);
    public void customerRegistration(){
        Scanner scanner = new Scanner(System.in);
        /*name address email password*/
        
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        
        System.out.println("Enter your address: ");
        String address = scanner.nextLine();
        
        GYMCustomerBusiness customerServer = new GYMCustomerBusinessImpl();
        customerServer.createCustomer(name,email,password,address);
    }
    public void CustomerOperationList() {
        System.out.println("Welcome Customer");
        System.out.println("1. Update Profile\n2. Delete Profile\n3. View Profile\n4. View List of GYMs\n5. View Available Slots\n6. Make Bookings\n7. Make Payment\n8. View Booking\n9. Cancel Booking");
        
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        GYMCustomerBusiness customerServer = new GYMCustomerBusinessImpl();
        switch (choice) {
            case 1:
                customerServer.updateCustomer(1);
                break;
            case 2:
                customerServer.deleteCustomer(1);
                break;
            case 3:
                customerServer.viewProfile();
                break;
            case 4:
                customerServer.viewList();
                break;
            case 5:
                customerServer.viewSlots();
                break;
            case 6:
                System.out.println("Enter GYM ID: ");
                int gymId = sc.nextInt();
                customerServer.makeBooking(1, gymId);
                break;
            case 7:
                System.out.println("Enter GYM ID: ");
                int gymId1 = sc.nextInt();
                customerServer.makePayment(1, gymId1);
                break;
            case 8:
                customerServer.viewBookings(1);
                break;
            case 9:
                System.out.println("Enter GYM ID: ");
                int gymId3 = sc.nextInt();
                customerServer.cancelBooking(1, gymId3);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello from GYMCustomer");
        
        GYMCustomerBusiness service = new GYMCustomerBusinessImpl();
        System.out.println(service.createCustomer("Sample Name", "example.com", "Sample Address", "password"));
        System.out.println(service.deleteCustomer(1));
        System.out.println(service.updateCustomer(1));
        service.viewProfile();
        service.viewBookings(1);
        service.makeBooking(1, 1);
        service.cancelBooking(1, 1);
    }
    
}
