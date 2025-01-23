package com.flipkart.bean;

//import java.util.List;
//import java.util.Date;
import java.text.DateFormat;
//import java.text.SimpleDateFormat;

/**
 * 
 */

public class Slot{
    private int slotId;
    private DateFormat slotDateTime;
    private int slotSeats;
    private int slotSeatsLeft;
//    private List<String> waitlistUsers;
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
	 * @return the slotDateTime
	 */
	public DateFormat getSlotDateTime() {
		return slotDateTime;
	}
	/**
	 * @param slotDateTime the slotDateTime to set
	 */
	public void setSlotDateTime(DateFormat slotDateTime) {
		this.slotDateTime = slotDateTime;
	}
	/**
	 * @return the slotSeats
	 */
	public int getSlotSeats() {
		return slotSeats;
	}
	/**
	 * @param slotSeats the slotSeats to set
	 */
	public void setSlotSeats(int slotSeats) {
		this.slotSeats = slotSeats;
	}
	/**
	 * @return the slotSeatsLeft
	 */
	public int getSlotSeatsLeft() {
		return slotSeatsLeft;
	}
	/**
	 * @param slotSeatsLeft the slotSeatsLeft to set
	 */
	public void setSlotSeatsLeft(int slotSeatsLeft) {
		this.slotSeatsLeft = slotSeatsLeft;
	}
//    private String getDateTime()
//    {
//    	DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MI:SS");
//    	Date date = new Date();
//    }
    

}
