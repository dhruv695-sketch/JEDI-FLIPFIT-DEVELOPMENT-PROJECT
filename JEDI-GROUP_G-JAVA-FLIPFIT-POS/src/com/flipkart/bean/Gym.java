package com.flipkart.bean;
import java.util.List;

public class Gym {
	 private int gymId;
	    private String name;
	    private String location;
	    private List<Slot> slotList;

	    // Getters and Setters
	    public int getGymId() {
	        return gymId;
	    }

	    public void setGymId(int gymId) {
	        this.gymId = gymId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    public List<Slot> getSlotList() {
	        return slotList;
	    }

	    public void setSlotList(List<Slot> slotList) {
	        this.slotList = slotList;
	    }
}
