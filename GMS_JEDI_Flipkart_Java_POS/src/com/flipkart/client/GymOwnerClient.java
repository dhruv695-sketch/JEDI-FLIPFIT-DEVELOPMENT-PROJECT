/**
 * 
 */
package com.flipkart.client;
import java.util.Scanner;

import com.flipkart.business.*;
import com.flipkart.bean.*;
import java.util.*;

/**
 * 
 */
public class GymOwnerClient {

	public static final String ANSI_YELLOW = "\u001B[33m";
	GymOwner gymOwner = new GymOwner();
	GymCenter gymCenter = new GymCenter();
	User user = new User();

	GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
	UserBusinessInterface userBusiness = new UserBusiness();
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
	public void registerGymOwner(Scanner sc){
		
		System.out.println("Enter your email: ");
		gymOwner.setEmail(sc.next());
	
		System.out.println("Enter your name: ");
		gymOwner.setName(sc.next());
		
		System.out.println("Enter your mobile: ");
		gymOwner.setPhone(sc.nextLong());
		
		System.out.println("Enter your address: ");
		gymOwner.setAddress(sc.next());
		
		System.out.println("Enter your GST number: ");
		gymOwner.setGstNumber(sc.next());
		
		System.out.println("Enter your password: ");
		String password = sc.next();
		gymOwner.setApproved(false);
		
		
		user.setEmail(gymOwner.getEmail());
		user.setPassword(password);
		user.setRoleId(2);
		userBusiness.registerUser(user);
		userBusiness.registerGymOwner(gymOwner);
	}
	
	public void registerGym(Scanner sc) throws Exception{
		GymCenter gymCenter = new GymCenter();
		System.out.println("Add gym Details: ");
		System.out.print("Enter gym Name: ");
		gymCenter.setName(sc.next());
		System.out.print("Enter gym location: ");
		gymCenter.setLocation(sc.next());
		System.out.println("Enter the number of seats: ");
		gymCenter.setNoOfSeats(sc.nextInt());
		gymCenter.setGymOwnerEmail(gymOwner.getEmail());
		gymCenter.setApproved(false);
		gymOwnerBusiness.addGym(gymCenter);
	}
	
	public void getGymOwnerDetails(String gymOwnerEmail) throws Exception{
		GymOwner gymOwner = gymOwnerBusiness.getGymOwnerDetails(gymOwnerEmail);
		System.out.printf("%-15s\t", "Id");
		System.out.printf("%-15s\t", "Name");
		System.out.printf("%-15s\t", "Email");
		System.out.printf("%-15s\t", "Address");
		System.out.printf("%-15s\t", "GstNumber");
		System.out.printf("%-15s\t", "Phone");
		System.out.println();
		System.out.printf("%-15s\t", gymOwner.getId());
		System.out.printf("%-15s\t", gymOwner.getName());
		System.out.printf("%-15s\t", gymOwner.getEmail());
		System.out.printf("%-15s\t", gymOwner.getAddress());
		System.out.printf("%-15s\t", gymOwner.getGstNumber());
		System.out.printf("%-15s\t", gymOwner.getPhone());
		if(gymOwner.isApproved())
		{
			System.out.printf("%-15s\t", ANSI_GREEN + "Yes" + ANSI_RESET);
//			System.out.println(ANSI_GREEN + "Yes" + ANSI_RESET);
//			System.out.printf("%-15s\t", "Yes");
		}
		else
		{
			System.out.printf("%-15s\t", ANSI_RED + "No" + ANSI_RESET);
//			System.out.println(ANSI_RED + "No" + ANSI_RESET);
//			System.out.printf("%-15s\t", "No");
		}
		System.out.println("");
		
	}
	
	public void getAllGymDetails() throws Exception{
		List<GymCenter> allGyms = gymOwnerBusiness.viewAllGymCenters(gymOwner.getEmail());
		System.out.printf("%-15s\t", "Id");
		System.out.printf("%-15s\t", "Name");
		System.out.printf("%-15s\t", "Location");
		System.out.printf("%-15s\t", "No of Seats");
		System.out.println();
		for(GymCenter gym : allGyms) {
			System.out.printf("%-15s\t", gym.getId());
			System.out.printf("%-15s\t", gym.getName());
			System.out.printf("%-15s\t", gym.getLocation());
			System.out.printf("%-15s\t", gym.getNoOfSeats());
			
			if(gym.isApproved())
			{
				System.out.printf("%-15s\t", ANSI_GREEN + "Yes" + ANSI_RESET);
//				System.out.println(ANSI_GREEN + "Yes" + ANSI_RESET);
//				System.out.printf("%-15s\t", "Yes");
			}
			else
			{
				System.out.printf("%-15s\t", ANSI_RED + "No" + ANSI_RESET);
//				System.out.println(ANSI_RED + "No" + ANSI_RESET);
//				System.out.printf("%-15s\t", "No");
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void getAllApprovedGymDetails() throws Exception{
		List<GymCenter> allApprovedGyms = gymOwnerBusiness.viewAllApprovedGymCenters(gymOwner.getEmail());
		System.out.printf("%-15s\t", "Id");
		System.out.printf("%-15s\t", "Name");
		System.out.printf("%-15s\t", "Location");
		System.out.printf("%-15s\t", "No of Seats");
		System.out.println();
		for(GymCenter gym : allApprovedGyms) {
			System.out.printf("%-15s\t", gym.getId());
			System.out.printf("%-15s\t", gym.getName());
			System.out.printf("%-15s\t", gym.getLocation());
			System.out.printf("%-15s\t", gym.getNoOfSeats());
			System.out.printf("%-15s\t", "Yes");
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void addSlots(Scanner sc, String gymOwnerEmail) throws Exception{
		getAllGymDetails();
		System.out.println("Enter the gymCenter id for which you want to add slots: ");
		gymCenter.setId(sc.nextInt());
		if(!gymOwnerBusiness.isApproved(gymCenter.getId())){
			System.out.println(ANSI_RED + "This Gym is not Authorized" + ANSI_RESET);
//			System.out.println("This Gym is not Authorized");
			gymOwnerPage(sc, gymOwnerEmail);
		}
		else {
			viewAllSlots(gymCenter.getId());
			System.out.println("Add slot timing: ");
			Slot slot = new Slot();
			slot.setTime(sc.next());
//			System.out.println("Add slot Id: ");
//			slot.setId(sc.nextInt());
			slot.setId(gymOwnerBusiness.createSlot(slot, gymCenter.getId()));
//			slot.setId();
			gymOwnerBusiness.addSlots(gymCenter.getId(),slot);
			gymOwnerPage(sc, gymOwnerEmail);
		}
	}
	
	public void viewAllSlots(int gymCenterId) throws Exception{
		System.out.println("Listing all existing slots: ");
		List<Slot> allSlots = gymOwnerBusiness.viewAllSlots(gymCenterId);
		System.out.printf("%-15s\t", "Id");
		System.out.printf("%-15s\t", "Time");
		System.out.println();
		for(Slot slot : allSlots) {
			System.out.printf("%-15s\t", slot.getId());
			System.out.printf("%-15s\t", slot.getTime());
			System.out.println("");
		}
		System.out.println("-------------------------------------");
	}
	
	public void viewAllSlots(Scanner sc) throws Exception{
		getAllApprovedGymDetails();
		System.out.println("Enter the gymCenter id for which you want to see all slots: ");
		viewAllSlots(sc.nextInt());
	}
	
	public void gymOwnerPage(Scanner sc,String gymOwnerEmail) throws Exception{
		if(!gymOwnerBusiness.isApproved(gymOwnerEmail)) {
			System.out.println(ANSI_RED + "You are not a Authorized Gym Owner" + ANSI_RESET);
//			System.out.println("You are not a Authorized Gym Owner");
			ApplicationClient.mainPage();
		}
		else {
			gymOwner.setEmail(gymOwnerEmail);
			while(true) {
				System.out.println(ANSI_YELLOW + "------------------------------ \n 1. Add Gyms \n 2. View All Gyms \n 3. Add Slots in a Gym \n 4. View All Slots of a Gym \n 5. View Own Details \n 6. Exit \n ------------------------------ \n Enter your choice: " + ANSI_RESET);
				System.out.println("------------------------------");
//				System.out.println("1. Add Gyms");
//				System.out.println("2. View All Gyms");
//				System.out.println("3. Add Slots in a Gym");
//				System.out.println("4. View All Slots of a Gym");
//				System.out.println("5. View Own Details");
//				System.out.println("6. Exit");
//				System.out.println("------------------------------");
//				System.out.print("Enter your choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					registerGym(sc);
					break;
				case 2:
					getAllGymDetails();
					break;
				case 3:
					addSlots(sc, gymOwnerEmail);
					break;
				case 4:
					viewAllSlots(sc);
					break;
				case 5:
					getGymOwnerDetails(gymOwnerEmail);
					break;
				case 6:
					ApplicationClient.mainPage();
					break;
				default:
					System.out.println(ANSI_RED + "Incorrect Choice" + ANSI_RESET);
				}
			}
			
		}
	}
	

}
