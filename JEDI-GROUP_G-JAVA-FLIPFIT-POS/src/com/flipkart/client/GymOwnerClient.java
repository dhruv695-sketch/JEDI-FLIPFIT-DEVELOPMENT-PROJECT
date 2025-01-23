package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.business.GymOwnerService;

public class GymOwnerClient {

    public static void registerGymOwner(Scanner scanner) {
        System.out.println("\nRegistration Of Gym Owner:");
        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Email ID: ");
        String email = scanner.nextLine();
        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();
        System.out.println("Gym Owner registered successfully!");
        // Logic for storing owner data can be added here
    }

    public static void displayGymOwnerMenu(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nGym Owner Menu:");
            System.out.println("1. View Gyms");
            System.out.println("2. Add Gym");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
//                	GymOwnerService gymservice = new GymOwnerService();
//                	gymservice.getGymsForOwner(choice)
                    System.out.println("Viewing gyms...");
                    // Logic for viewing gyms
                    break;
                case 2:
                	
                    System.out.println("Adding a gym...");
                    // Logic for adding a gym
                    break;
                case 3:
                    System.out.println("Logging out...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
