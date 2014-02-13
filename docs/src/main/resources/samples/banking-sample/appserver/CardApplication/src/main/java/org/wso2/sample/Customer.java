package org.wso2.sample;

public class Customer {
 	private int customerID;
	private String customerName;
	private String branch;
	
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getBranch() {
		return branch;
	}

}
