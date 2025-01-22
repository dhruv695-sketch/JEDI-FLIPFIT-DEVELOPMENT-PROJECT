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

    private void loginUser(Scanner scanner) {
        System.out.println("Enter your login details:");
//        System.out.print("Enter the UserName: ");
//        String name = scanner.next();
//        
        System.out.print("Enter your Email ID: ");
        String email = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        if (userAuthService.validateLogin(email, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }
}