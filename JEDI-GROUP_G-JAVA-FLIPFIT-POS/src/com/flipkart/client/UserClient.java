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
        System.out.println("Welcome to FlipFit");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> registerUser(scanner);
            case 2 -> loginUser(scanner);
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
        System.out.print("Email ID: ");
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