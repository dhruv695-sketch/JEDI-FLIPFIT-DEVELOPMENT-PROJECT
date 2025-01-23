package com.flipkart.bean;

/**
 * 
 */
public class BookSlot {
    private int bookingId;
    private int customerId;
    private int gymId;
    private int slotId;
    private boolean bookingStatus;
    private int waitlistNumber;
    /**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the gymId
	 */
	public int getGymId() {
		return gymId;
	}
	/**
	 * @param gymId the gymId to set
	 */
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	/**
	 * @return the slotId
	 */
	public int getSlotId() {
		return slotId;
	}
	/**
	 * @param slotId the slotId to set
	 */
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	/**
	 * @return the bookingStatus
	 */
	public boolean isBookingStatus() {
		return bookingStatus;
	}
	/**
	 * @param bookingStatus the bookingStatus to set
	 */
	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	/**
	 * @return the waitlistNumber
	 */
	public int getWaitlistNumber() {
		return waitlistNumber;
	}
	/**
	 * @param waitlistNumber the waitlistNumber to set
	 */
	public void setWaitlistNumber(int waitlistNumber) {
		this.waitlistNumber = waitlistNumber;
	}    
    
}
