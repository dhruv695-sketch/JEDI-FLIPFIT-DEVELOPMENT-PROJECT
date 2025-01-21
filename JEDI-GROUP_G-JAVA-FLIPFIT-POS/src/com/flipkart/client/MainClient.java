package com.flipkart.client;

import java.util.Scanner;

/**
 * 
 */
public class MainClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserClient userClient = new UserClient();
        CustomerClient customerClient = new CustomerClient();
        AdminClient adminClient = new AdminClient();

        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. User Operations");
            System.out.println("2. Customer Operations");
            System.out.println("3. Admin Operations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> userClient.userMenu();
                case 2 -> customerClient.customerMenu();
                case 3 -> adminClient.adminMenu();
                case 4 -> {
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
