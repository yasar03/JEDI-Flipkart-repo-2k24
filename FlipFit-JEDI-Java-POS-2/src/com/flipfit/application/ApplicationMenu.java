package com.flipfit.application;

import com.flipfit.business.UserBusinessInterface;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

import com.flipfit.bean.User;
import com.flipfit.business.UserBusiness;

public class ApplicationMenu {
	/**
	 * Method to update password
	 */
	public static void updatePassword() {
		Scanner in = new Scanner(System.in);
		System.out.println("__________________________________________________________________________________\n");
		System.out.println("Enter Email to update password: ");
		String userEmail = in.next();
		System.out.println("Enter New Password: ");
		String password = in.next();
		System.out.println("Re-Enter New Password: ");
		String rePassword = in.next();
		if (!password.equals(rePassword)) {
			System.out.println("Passwords do not match!");
			return;
		}
		
//		User user = new User(userEmail, password, "GymCustomer");
		UserBusinessInterface userBusiness = new UserBusiness();
		if (userBusiness.updatePassword(userEmail, password)) {
			System.out.println("Password Updated Successfully!");
		} else {
			System.out.println("Password Update Failed!");
		}
	}
	
	/**
	 * Method to login to the FlipFit application
	 * @throws Exception
	 */
	public static void login() throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("__________________________________________________________________________________\n");
		System.out.println("Enter LogIn Details\n");
		System.out.print("Enter Email: ");
		String userEmail = in.next();
		System.out.print("Enter Password: ");
		String password = in.next();
		System.out.print("Enter Role Name(GymOwner/GymCustomer/GymAdmin): ");
		String roleId = in.next();
		User user = new User(userEmail, password, roleId);
		UserBusiness userBusiness = new UserBusiness();
		if (roleId.equalsIgnoreCase("GymAdmin")) {
			AdminMenu admin = new AdminMenu();
			admin.adminMenu(in);
		} 
		else if (userBusiness.authenticateUser(user)) {
			System.out.println("__________________________________________________________________________________\n");
			System.out.println("Welcome " + userEmail + "! You are logged in.");
			LocalDateTime loginTime = LocalDateTime.now();
			
			// Format the time for display
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedLoginTime = loginTime.format(formatter);
			
			// Print the login time
			System.out.println("Login time: " + formattedLoginTime);

			if (roleId.equalsIgnoreCase("GymCustomer")) {

				CustomerMenu customer = new CustomerMenu();
				customer.customerMenu(userEmail);

			} else if (roleId.equalsIgnoreCase("GymOwner")) {

				GymOwnerMenu gymOwner = new GymOwnerMenu();
				gymOwner.gymOwnerMenu(in, userEmail);

			} else {
				System.out.println("Wrong Choice!");
			}
		} else {
			System.out.println("\nSorry! You are not Registered! Please Register Yourself!");
		}
	}

	/**
	 * Method to display the application menu
	 * @throws Exception
	 */
	public static void applicationMenu() throws Exception {
		boolean recur = true;
		System.out.println("Welcome to the FlipFit Application!");

		while (recur) {
			System.out.println("\nChoose your action:");
			System.out.println("1. Login");
			System.out.println("2. Customer Registration");
			System.out.println("3. Gym Owner Registration");
			System.out.println("4. Update password");
			System.out.println("5. Exit");
			System.out.print("\nEnter Your Choice: ");

			Scanner in = new Scanner(System.in);

			int choice = in.nextInt();
			switch (choice) {
			case 1:
				login();
				break;
			case 2:
				CustomerMenu customer = new CustomerMenu();
				customer.registerCustomer();
				login();
				break;
			case 3:
				GymOwnerMenu owner = new GymOwnerMenu();
				owner.gymOwnerRegistration(in);
				login();
				break;
			case 4:
				updatePassword();
				break;
			case 5:
				System.out.println("Exiting...");
				System.out.println("Exited Successfully");
				recur = false;
				System.exit(0);
				break;
			default:
				System.out.println("Wrong choice");
			}
		}

	}
	
	/**
	 * Main method
	 * @param args the command line arguments
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		applicationMenu();
	}

}
