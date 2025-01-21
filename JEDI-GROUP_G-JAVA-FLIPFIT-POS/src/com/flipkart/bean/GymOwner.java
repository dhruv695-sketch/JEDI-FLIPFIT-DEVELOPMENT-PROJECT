package com.flipkart.bean;
import java.util.List;

public class GymOwner extends User{
	private List<Gym> gymList;

    // Getters and Setters
    public List<Gym> getGymList() {
        return gymList;
    }

    public void setGymList(List<Gym> gymList) {
        this.gymList = gymList;
    }
}
