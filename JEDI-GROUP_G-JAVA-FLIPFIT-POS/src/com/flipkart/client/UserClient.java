package com.flipkart.client;

import com.flipkart.bean.User;
import com.flipkart.business.UserAuthService;
import java.util.Scanner;

/**
 * 
 */
public class UserClient {
    private UserAuthService userAuthService = new UserAuthService();

    public void userMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to FlipFit Application");
        System.out.println("1. Login");
        System.out.println("2. Registration of the GymCustomer");
        System.out.println("3. Registration of the GymOwner");
        System.out.println("4. Change Password");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
        	case 1 -> loginUser(scanner);
            case 2 -> registerUser(scanner);
            case 3 -> registerGymOwner(scanner);
            case 4 -> changePassword(scanner);
            case 5 -> System.out.println("Exiting application.");
            default -> System.out.println("Invalid choice.");
           
           
        }
    }

    private void registerUser(Scanner scanner) {
        System.out.println("Enter your details for registration:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Email ID: ");
        String email = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        User user = new User(name, email, password);
        if (userAuthService.registerUser(user)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. Try again.");
        }
    }
    private void changePassword(Scanner scanner) {
        System.out.print("Enter your email ID: ");
        String email = scanner.next();
        System.out.print("Enter your old password: ");
        String oldPassword = scanner.next();
        System.out.print("Enter your new password: ");
        String newPassword = scanner.next();
        if (userAuthService.changePassword(email, oldPassword, newPassword)) {
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Password change failed. Please check your credentials.");
        }
    }

    private void loginUser(Scanner scanner) {
        System.out.println("Enter your login details:");

        System.out.print("Enter your Username: ");
        String username = scanner.next();
        System.out.print("Enter your Password: ");
        String password = scanner.next();
        System.out.print("Enter your Role (GymAdmin/GymOwner/GymCustomer): ");
        String role = scanner.next();

        if (userAuthService.validateLogin(username, password, role)) {
            System.out.println("Login successful!");

            // Display role-specific menu
            switch (role) {
                case "GymCustomer" -> displayGymCustomerMenu();
                case "GymOwner" -> displayGymOwnerMenu();
                case "GymAdmin" -> displayGymAdminMenu();
                default -> System.out.println("Invalid role.");
            }
        } else {
            System.out.println("Invalid credentials or role. Try again.");
        }
    }
 // Method to display GymCustomer menu
    private void displayGymCustomerMenu() {
        System.out.println("Welcome to GymCustomer Menu!");
        System.out.println("1. View available gyms");
        System.out.println("2. Book a gym");
        System.out.println("3. View gym bookings");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        // Handle GymCustomer actions based on the choice
    }
 // Method to display GymOwner menu
    private void displayGymOwnerMenu() {
        System.out.println("Welcome to GymOwner Menu!");
        System.out.println("1. Add new gym");
        System.out.println("2. View gym bookings");
        System.out.println("3. Update gym details");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        // Handle GymOwner actions based on the choice
    }

    // Method to display GymAdmin menu
    private void displayGymAdminMenu() {
        System.out.println("Welcome to GymAdmin Menu!");
        System.out.println("1. Manage users");
        System.out.println("2. View reports");
        System.out.println("3. Manage gyms");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        // Handle GymAdmin actions based on the choice
    }
}