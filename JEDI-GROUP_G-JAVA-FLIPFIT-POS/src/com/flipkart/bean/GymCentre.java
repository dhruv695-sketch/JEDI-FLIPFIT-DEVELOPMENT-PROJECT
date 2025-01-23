package com.flipkart.bean;

import java.util.List;

/**
 * 
 */
public class GymCentre {
	 	private int gymId;
	    private String name;
	    private String location;
	    private List<Slot> slotList;
	    private boolean isApproved;
	    
	    public GymCentre(String name) {
	    	this.name = name;
	    }

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
		
		public boolean getisApproved() {
			return isApproved;
		}

		public void setisApproved(boolean isApproved) {
			this.isApproved = isApproved;
		}
}
