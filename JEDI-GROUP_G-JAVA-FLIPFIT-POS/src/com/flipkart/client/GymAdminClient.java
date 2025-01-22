package com.flipkart.client;

import java.util.Scanner;

public class GymAdminClient {

    public static void displayGymAdminMenu(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nGym Admin Menu:");
            System.out.println("1. Verify Gym Owners");
            System.out.println("2. Verify Gyms");
            System.out.println("3. Get Pending Gym Verifications");
            System.out.println("4. Get Pending Gym Owner Verifications");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Verifying gym owners...");
                    // Logic for verifying gym owners
                    break;
                case 2:
                    System.out.println("Verifying gyms...");
                    // Logic for verifying gyms
                    break;
                case 3:
                    System.out.println("Getting pending gym verifications...");
                    // Logic to retrieve pending gym verifications
                    break;
                case 4:
                    System.out.println("Getting pending gym owner verifications...");
                    // Logic to retrieve pending gym owner verifications
                    break;
                case 5:
                    System.out.println("Logging out...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
