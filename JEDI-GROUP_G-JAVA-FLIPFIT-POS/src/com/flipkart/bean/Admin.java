package com.flipkart.bean;

import java.util.List;

public class Admin extends User {
    private List<GymOwner> pendingGymOwnerVerification;
    private List<Gym> pendingGymVerification;

    // Getters and Setters
    public List<GymOwner> getPendingGymOwnerVerification() {
        return pendingGymOwnerVerification;
    }

    public void setPendingGymOwnerVerification(List<GymOwner> pendingGymOwnerVerification) {
        this.pendingGymOwnerVerification = pendingGymOwnerVerification;
    }

    public List<Gym> getPendingGymVerification() {
        return pendingGymVerification;
    }

    public void setPendingGymVerification(List<Gym> pendingGymVerification) {
        this.pendingGymVerification = pendingGymVerification;
    }
}
