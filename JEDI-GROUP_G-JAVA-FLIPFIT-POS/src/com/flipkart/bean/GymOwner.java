package com.flipkart.bean;
/**
 * 
 */
public class GymOwner extends User{
	
	/**
	 * @return the gymOwnerId
	 */
	public int getGymOwnerId() {
		return getUserId();
	}

	/**
	 * @param gymOwnerId the gymOwnerId to set
	 */
	public void setGymOwnerId(int gymOwnerId) {
		setUserId(gymOwnerId);
	}

	
}
