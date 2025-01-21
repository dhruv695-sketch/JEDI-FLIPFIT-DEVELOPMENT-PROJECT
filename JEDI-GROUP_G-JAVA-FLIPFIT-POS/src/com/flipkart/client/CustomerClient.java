package com.flipkart.client;

import com.flipkart.bean.Booking;
import com.flipkart.business.CustomerService;
import java.util.Scanner;

/**
 * 
 */
public class CustomerClient {
    private CustomerService customerService = new CustomerService();

    public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Customer Menu");
        System.out.println("1. Create Booking");
        System.out.println("2. View Bookings");
        System.out.println("3. Cancel Booking");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> createBooking(scanner);
            case 2 -> viewBookings(scanner);
            case 3 -> cancelBooking(scanner);
            default -> System.out.println("Invalid choice.");
        }
    }

    private void createBooking(Scanner scanner) {
        System.out.println("Enter booking details:");
        System.out.print("User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Gym ID: ");
        int gymId = scanner.nextInt();
        System.out.print("Slot ID: ");
        int slotId = scanner.nextInt();
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setGymId(gymId);
        booking.setSlotId(slotId);
        if (customerService.createBooking(booking)) {
            System.out.println("Booking created successfully!");
        } else {
            System.out.println("Failed to create booking.");
        }
    }

    private void viewBookings(Scanner scanner) {
        System.out.print("Enter your customer ID: ");
        int customerId = scanner.nextInt();
        System.out.println("Fetching bookings...");
        var bookings = customerService.getBookingsForCustomer(customerId);
        if (bookings != null) {
            bookings.forEach(System.out::println);
        } else {
            System.out.println("No bookings found.");
        }
    }

    private void cancelBooking(Scanner scanner) {
        System.out.print("Enter booking ID to cancel: ");
        int bookingId = scanner.nextInt();
        if (customerService.cancelBooking(bookingId)) {
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Failed to cancel booking.");
        }
    }
}