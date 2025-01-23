/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;

/**
 * 
 */
public interface GymOwnerDao {
	  public boolean addGym(GymCentre gymCentre);

	    // Method to update gym details
	    public boolean updateGym(GymCentre gymCentre);

	    // Method to add a new slot to a gym
	    public boolean addSlotToGym(int gymId, Slot slot);

	    // Method to retrieve all gyms for an owner
	    public List<GymCentre> getGymsForOwner(int ownerId);

}
