package com.flipfit.application;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;
import com.flipfit.business.*;

import java.util.*;

/**
 * 
 */

public class AdminMenu {

	AdminBusiness adminBusiness = new AdminBusiness();

	List<GymOwner> gymOwnerList = adminBusiness.getGymOwners();
	List<Gym> gymList = adminBusiness.getGym();
	Scanner sc = new Scanner(System.in);
	
	public void viewAllPendingGymOwnerRequests() {
		viewAllGymOwners(adminBusiness.viewAllPendingGymOwnerRequests());
	}
	public void viewAllPendingGymRequests() {
		viewAllGyms(adminBusiness.viewAllPendingGymRequests());
	}
	
	public void approveSingleGymOwnerRequest() {
		System.out.println("Enter gym owner email: ");
		adminBusiness.approveSingleGymOwnerRequest(sc.next());
	}
	
	public void approveSingleGymRequest() {
		System.out.println("Enter gym Id: ");
		adminBusiness.approveSingleGymRequest(sc.next());
	}

	public void approvePendingGymOwnerRequests() {
		adminBusiness.approveAllPendingGymOwnerRequests();
	}

	public void approvePendingGymRequests() {
		adminBusiness.approveAllPendingGymRequests();
	}

	public void adminMenu(Scanner in) throws Exception {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		while (true) {
			System.out.println("1. View All Gym ");
			System.out.println("2. View All Gym Owners");
			System.out.println("3. View all pending Gym Owner Requests");
			System.out.println("4. View all pending Gym Requests");
			System.out.println("5. Approve all pending Gym Owner Requests");
			System.out.println("6. Approve all pending Gym Requests");
			System.out.println("7. Approve Single Gym Owner Request");
			System.out.println("8. Approve Single Gym Request");
			System.out.println("9. Exit");
			
			System.out.print("Enter your choice: ");
			int choice = in.nextInt();
			switch (choice) {
			// Case statements
			case 1:
				viewAllGyms(gymList);
				break;
			case 2:
				viewAllGymOwners(gymOwnerList);
				break;
			case 3:
				viewAllPendingGymOwnerRequests();
				break;
			case 4:
				viewAllPendingGymRequests();
				break;
			case 5:
				approvePendingGymOwnerRequests();
				break;
			case 6:
				approvePendingGymRequests();
				break;
			case 7:
				approveSingleGymOwnerRequest();
				break;
			case 8:
				approveSingleGymRequest();
				break;
			case 9:
				return;
			// Default case statement
			default:
				System.out.println("Wrong choice");
			}
		}
}
			
	public void viewAllGyms(List<Gym> gyms) {
		gyms.forEach(gym -> {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Gym Id-->" + gym.getGymId());
			System.out.println("Gym Name-->" + gym.getGymName());
			System.out.println("Gym Owner Mail-->" + gym.getOwnerEmail());
			System.out.println("Gym Address-->" + gym.getAddress());
			System.out.println("Gym Slot Count-->" + gym.getSlotCount());
			System.out.println("Gym Verification -->" + (gym.isVerified() ? "Yes" : "No"));
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		});
	}

	public void viewAllGymOwners(List<GymOwner> gymOwners) {
		gymOwners.forEach(gymOwner -> {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Gym Owner Name-->" + gymOwner.getName());
			System.out.println("Gym Owner phone numver-->" + gymOwner.getPhoneNumber());
			System.out.println("Gym Owner Aadhar-->" + gymOwner.getAadharNumber());
			System.out.println("Gym Owner panNumber-->" + gymOwner.getPanNumber());
			System.out.println("Gym Owner Verification -->" + (gymOwner.isVerified() ? "Yes" : "No"));
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		});

	}
}
