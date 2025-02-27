/**
 * 
 */
package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

/**
 * 
 */
public interface GymOwnerDao {

	public GymOwner getGymOwnerDetails(String gymOwnerEmail);
	
	public List<GymCenter> viewAllGymCenters(String gymOwnerEmail);
	
	public List<GymCenter> viewAllApprovedGymCenters(String gymOwnerEmail);
	
	public List<Slot> viewAllSlots(int GymCenterId);
	
	public boolean addSlots(int gymCenterId,Slot slot);
	
	public void addGym(GymCenter gymCenter);

	public int createSlot(Slot slot, int gymCenterId);
	
	public boolean isApproved(String gymOwnerEmail);

	public boolean isApproved(int gymCenterId);
}
