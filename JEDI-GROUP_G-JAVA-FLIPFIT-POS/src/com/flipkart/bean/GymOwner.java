package com.flipkart.bean;
/**
 * 
 */
public class GymOwner extends User{
	
	/**
	 * @return the gymOwnerId
	 */
	
    private boolean isApproved;

	public int getGymOwnerId() {
		return getUserId();
	}

	/**
	 * @param gymOwnerId the gymOwnerId to set
	 */
	public void setGymOwnerId(int gymOwnerId) {
		setUserId(gymOwnerId);
	}

	public boolean getisApproved() {
		return isApproved;
	}

	public void setisApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	
}
