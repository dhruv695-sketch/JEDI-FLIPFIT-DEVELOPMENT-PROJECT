package com.flipkart.bean;

//import java.util.List;
//import java.util.Date;
import java.text.DateFormat;

/**
 * 
 */
public class Notification {
	
	private int notificationId;
	private String type;
    private DateFormat notificationDateTime;
    private String message;
//    private List<String> userIdList;
    
    /**
	 * @return the notificationId
	 */
	public int getNotificationId() {
		return notificationId;
	}
	/**
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the notificationDateTime
	 */
	public DateFormat getNotificationDateTime() {
		return notificationDateTime;
	}
	/**
	 * @param notificationDateTime the notificationDateTime to set
	 */
	public void setNotificationDateTime(DateFormat notificationDateTime) {
		this.notificationDateTime = notificationDateTime;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
   
}
