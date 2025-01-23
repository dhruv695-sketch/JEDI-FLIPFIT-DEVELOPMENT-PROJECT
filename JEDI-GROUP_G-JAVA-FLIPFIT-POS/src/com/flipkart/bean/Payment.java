package com.flipkart.bean;

//import java.util.Date;
import java.text.DateFormat;
//import java.text.SimpleDateFormat;
/**
 * 
 */
public class Payment {
    
	private int paymentId;
	private int transactionId;
    private float amount;
    private int customerId;
    private String paymentMethod;
    private DateFormat paymentDateTime;

    /**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the transactionId
	 */
	public int getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
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
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	/**
	 * @return the paymentDateTime
	 */
	public DateFormat getPaymentDateTime() {
		return paymentDateTime;
	}
	/**
	 * @param paymentDateTime the paymentDateTime to set
	 */
	public void setPaymentDateTime(DateFormat paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

    

    
}
