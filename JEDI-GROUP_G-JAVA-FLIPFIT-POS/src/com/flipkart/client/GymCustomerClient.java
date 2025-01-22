package com.flipkart.client;

import java.util.Scanner;

public class GymCustomerClient {

    public static void registerGymCustomer(Scanner scanner) {
        System.out.println("\nRegistration Of Gym Customer:");
        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Email ID: ");
        String email = scanner.nextLine();
        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();
        System.out.println("Gym Customer registered successfully!");
        // Logic for storing customer data can be added here
    }

    public static void displayCustomerMenu(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Bookings");
            System.out.println("2. Book Slot");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Viewing bookings...");
                    // Logic for viewing bookings
                    break;
                case 2:
                    System.out.println("Booking a slot...");
                    // Logic for booking a slot
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
