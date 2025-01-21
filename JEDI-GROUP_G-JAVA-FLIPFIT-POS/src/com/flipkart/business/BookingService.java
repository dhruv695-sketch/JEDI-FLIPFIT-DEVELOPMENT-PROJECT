package com.flipkart.business;

import com.flipkart.bean.Booking;

public class BookingService {
    // Method to check booking status
    public boolean checkBookingStatus(int bookingId) {
        // Logic to check booking status
        System.out.println("Checking booking status for ID: " + bookingId);
        return true; // Placeholder
    }

    // Method to handle waitlist
    public int addToWaitlist(int slotId, int userId) {
        // Logic to add to waitlist
        System.out.println("User ID " + userId + " added to waitlist for slot ID " + slotId);
        return 0; // Placeholder waitlist number
    }
}
