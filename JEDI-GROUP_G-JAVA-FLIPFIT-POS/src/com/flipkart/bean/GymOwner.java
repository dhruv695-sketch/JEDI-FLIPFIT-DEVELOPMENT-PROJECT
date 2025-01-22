package com.flipkart.bean;

import java.util.List;

/**
 * 
 */
public class GymOwner extends User{
	
	public GymOwner(String name) {
		super(name);
	}
	
	public GymOwner(String name, String emailId, String password) {
		super(name, emailId, password);
		// TODO Auto-generated constructor stub
	}

	private List<GymCentre> gymList;

    // Getters and Setters
    public List<GymCentre> getGymList() {
        return gymList;
    }

    public void setGymList(List<GymCentre> gymList) {
        this.gymList = gymList;
    }
}
