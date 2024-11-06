package com.flipfit.application;

import com.flipfit.business.GYMCustomerBusiness;
import com.flipfit.business.GYMCustomerBusinessImpl;
import com.flipfit.business.GYMOwnerBusiness;
import com.flipfit.business.GYMOwnerBusinessImpl;
import java.util.Scanner;

public class FlipFitMainMenu {
    
    public static void updatePassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your old password: ");
        String oldPassword = scanner.nextLine();
        
        System.out.println("Enter your new password: ");
        String newPassword = scanner.nextLine();
        
        if (newPassword.length() < 8) {
            System.out.println("Password should be at least 8 characters");
            return ;
        }
        
        System.out.println("Enter your new password again: ");
        String newPasswordAgain = scanner.nextLine();
        
        if (oldPassword.equals(newPassword)) {
            System.out.println("Enter a password not used before");
            return;
        }
        
        
        
        if (newPassword.equals(newPasswordAgain)) {
            System.out.println("Password changed successfully");
        }
        
        else {
            System.out.println("Passwords do not match");
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to The FLIPFIT APP");
        System.out.println("1. Login\n2. Registration for GYM Customer\n3. Registration for GYM Owner\n4. Update Password\n5. Exit");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = in.nextInt();
        GYMCustomerMenu customer = new GYMCustomerMenu();
        GYMOwnerMenu owner = new GYMOwnerMenu();
        GYMAdminMenu admin = new GYMAdminMenu();
        switch (choice) {
            case 1:
                System.out.println("Login Page");
                System.out.println("Enter your username: ");
                String username = in.next();
                System.out.println("Enter your password: ");
                String password = in.next();
                System.out.println("Enter your role (gymcustomer/gymowner/gymadmin): ");
                String role = in.next();
                role = role.toLowerCase();
                if (role.equals("gymcustomer")) {
                    customer.CustomerOperationList();
                } else if (role.equals("gymowner")) {
                    owner.OwnerOperationList();
                } else if (role.equals("gymadmin")) {
                    admin.AdminOperationList();
                } else {
                    System.out.println("Invalid Role");
                }
                break;
            case 2:
                System.out.println("Registration for GYM Customer");
                customer.customerRegistration();
                break;
            case 3:
                System.out.println("Registration for GYM Owner");
                owner.ownerRegistration();
                break;
            case 4:
                System.out.println("Update Password");
                updatePassword();
                break;
            case 5:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        in.close();
    }
}
