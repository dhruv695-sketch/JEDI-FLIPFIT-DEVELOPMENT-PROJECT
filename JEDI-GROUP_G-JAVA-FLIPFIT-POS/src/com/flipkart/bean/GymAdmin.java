package com.flipkart.bean;

import java.util.List;

/**
 * 
 */
public class GymAdmin extends User {
	
	private List<GymOwner> pendingGymOwnerVerification;
    private List<GymCentre> pendingGymVerification;

    // Getters and Setters
    public List<GymOwner> getPendingGymOwnerVerification() {
        return pendingGymOwnerVerification;
    }

    public void setPendingGymOwnerVerification(List<GymOwner> pendingGymOwnerVerification) {
        this.pendingGymOwnerVerification = pendingGymOwnerVerification;
    }

    public List<GymCentre> getPendingGymVerification() {
        return pendingGymVerification;
    }

    public void setPendingGymVerification(List<GymCentre> pendingGymVerification) {
        this.pendingGymVerification = pendingGymVerification;
    }
}
