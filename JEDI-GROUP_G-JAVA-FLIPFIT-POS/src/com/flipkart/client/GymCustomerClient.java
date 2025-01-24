package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.User;
import com.flipkart.business.UserAuthService;

public class GymCustomerClient {

    public static void registerGymCustomer(Scanner scanner, int num) {
        System.out.println("\nRegistration Of Gym Customer:");
        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Email ID: ");
        String email = scanner.nextLine();
        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();
        User user = new User();
        user.setUserEmail(email);
        user.setUserPassword(password);
        user.setUserName(name);
        user.setUserRoleId(3);
        UserAuthService userBus = new UserAuthService();
        userBus.registerUser(user, num);
        
        System.out.println("Gym Customer registered successfully!");
        // Logic for storing customer data can be added here
    }

    public static void displayCustomerMenu(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View All Gyms");
            System.out.println("2. View Bookings");
//            System.out.println("3. Book Slot");
            System.out.println("3. Edit Booking");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
            	case 1:
            		System.out.println("Displaying all gyms...");
            		break;
                case 2:
                    System.out.println("Viewing bookings...");
                    // Logic for viewing bookings
                    break;
//                case 3:
//                    System.out.println("Booking a slot...");
//                    // Logic for booking a slot
//                    break;
                case 3:
                    System.out.println("Booking edited...");
                    // Logic for booking a slot
                    break;
                case 4:
                    System.out.println("Logging out...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
