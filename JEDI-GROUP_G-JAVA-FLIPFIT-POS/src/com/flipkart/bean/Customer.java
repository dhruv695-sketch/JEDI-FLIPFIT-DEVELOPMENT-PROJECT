package com.flipkart.bean;

//import java.util.*;

/**
 * 
 */
public class Customer extends User{
	private int customerAge;
    private String customerGender;
    private String customerAddress;
    
    
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
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

}
