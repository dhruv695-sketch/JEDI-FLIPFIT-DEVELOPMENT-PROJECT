package com.flipkart.bean;

//import java.util.*;

/**
 * 
 */
public class Customer extends User{
	private int customerAge;
    private int customerGender;
    private int customerAddress;
    
    
    public int getCustomerId() {
		return getUserId();
	}
	public void setCustomerId(int customerId) {
		setUserId(customerId);
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public int getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(int customerGender) {
		this.customerGender = customerGender;
	}
	public int getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(int customerAddress) {
		this.customerAddress = customerAddress;
	}

}
