package com.flipkart.bean;

/**
 * 
 */
public class Booking {
    private int bookingId;
    private int userId;
    private int gymId;
    private int slotId;
    private boolean bookingStatus;
    private int waitlistNumber;

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getWaitlistNumber() {
        return waitlistNumber;
    }

    public void setWaitlistNumber(int waitlistNumber) {
        this.waitlistNumber = waitlistNumber;
    }
}
