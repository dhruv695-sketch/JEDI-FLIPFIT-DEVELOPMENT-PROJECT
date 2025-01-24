package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.User;
import com.flipkart.business.*;

public class FlipFitApplicationClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int num =2;

        while (isRunning) {
            System.out.println("Welcome to FlipFit Application:");
            System.out.println("1. Login");
            System.out.println("2. Registration Of the Gym Customer");
            System.out.println("3. Registration Of the Gym Owner");
            System.out.println("4. Change Password");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                	num++;
                    GymCustomerClient.registerGymCustomer(scanner,num);
                    break;
                case 3:
                    GymOwnerClient.registerGymOwner(scanner);
                    break;
                case 4:
                    changePassword(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void login(Scanner scanner) {
        System.out.println("\nLogin:");
        System.out.print("Enter the UserName: ");
        String username = scanner.nextLine();
        System.out.print("Enter the Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter the Role (GymAdmin/Owner/Customer): ");
        String role = scanner.nextLine();
        User user = new User();
        user.setUserEmail(email);
        user.setUserPassword(password);
        user.setUserName(username);
        if(role.equals("Customer")){
			user.setUserRoleId(3);
		}
		else if(role.equals("GymOwner")){
			user.setUserRoleId(2);
		}
		else if(role.equals("Admin")){
			user.setUserRoleId(1);
		}
        
        UserAuthService userBus = new UserAuthService();
        userBus.validateLogin(email, password);
      
        
        

        switch (role.toLowerCase()) {
            case "customer":
                // Navigate to Customer menu
                GymCustomerClient.displayCustomerMenu(scanner);
                break;
            case "owner":
                // Navigate to Gym Owner menu
                GymOwnerClient.displayGymOwnerMenu(scanner);
                break;
            case "gymadmin":
                // Navigate to Gym Admin menu
                GymAdminClient.displayGymAdminMenu(scanner);
                break;
            default:
                System.out.println("Invalid role. Please try again.");
        }
    }

    private static void changePassword(Scanner scanner) {
        System.out.println("\nChange Password:");
        System.out.print("Enter your Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your old Password: ");
        String oldPassword = scanner.nextLine();
        System.out.print("Enter your new Password: ");
        String newPassword = scanner.nextLine();
        System.out.println("Password changed successfully!");
        // Logic for updating the password can be added here
    }
}
