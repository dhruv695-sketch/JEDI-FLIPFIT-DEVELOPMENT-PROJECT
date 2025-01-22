/**
 * 
 */
package com.flipkart.client;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymCentre;
import com.flipkart.business.GymAdminService;
import java.util.Scanner;

/**
 * 
 */
public class AdminClient {
    private GymAdminService gymAdminService = new GymAdminService();

    public void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Admin Menu");
        System.out.println("1. Verify Gym Owner");
        System.out.println("2. Verify Gym");
        System.out.println("3. View Pending Gym Verifications");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> verifyGymOwner(scanner);
            case 2 -> verifyGym(scanner);
            case 3 -> viewPendingGyms();
            default -> System.out.println("Invalid choice.");
        }
    }

    private void verifyGymOwner(Scanner scanner) {
        System.out.print("Enter Gym Owner Name: ");
        String name = scanner.next();
        GymOwner owner = new GymOwner(name);
        if (gymAdminService.verifyGymOwner(owner)) {
            System.out.println("Gym owner verified successfully!");
        } else {
            System.out.println("Failed to verify gym owner.");
        }
    }

    private void verifyGym(Scanner scanner) {
        System.out.print("Enter Gym Name: ");
        String name = scanner.next();
        GymCentre gymCentre = new GymCentre(name);
        if (gymAdminService.verifyGym(gymCentre)) {
            System.out.println("Gym verified successfully!");
        } else {
            System.out.println("Failed to verify gym.");
        }
    }

    private void viewPendingGyms() {
        System.out.println("Fetching pending gym verifications...");
        var pendingGyms = gymAdminService.getPendingGymVerifications();
        if (pendingGyms != null) {
            pendingGyms.forEach(System.out::println);
        } else {
            System.out.println("No pending gyms.");
        }
    }
}
