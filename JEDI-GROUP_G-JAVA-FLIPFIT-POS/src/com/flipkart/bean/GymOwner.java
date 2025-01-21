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

	private List<Gym> gymList;

    // Getters and Setters
    public List<Gym> getGymList() {
        return gymList;
    }

    public void setGymList(List<Gym> gymList) {
        this.gymList = gymList;
    }
}
