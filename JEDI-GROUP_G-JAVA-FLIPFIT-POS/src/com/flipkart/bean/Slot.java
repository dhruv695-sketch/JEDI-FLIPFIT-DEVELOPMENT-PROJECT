package com.flipkart.bean;

import java.util.List;

/**
 * 
 */
public class Slot {
    private int slotId;
    private String startTime;
    private String endTime;
    private int seats;
    private int remainingSeats;
    private List<String> waitlistUsers;

    // Getters and Setters
    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public List<String> getWaitlistUsers() {
        return waitlistUsers;
    }

    public void setWaitlistUsers(List<String> waitlistUsers) {
        this.waitlistUsers = waitlistUsers;
    }
}
