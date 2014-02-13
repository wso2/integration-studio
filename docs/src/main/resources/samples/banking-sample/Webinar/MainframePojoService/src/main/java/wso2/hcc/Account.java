package wso2.hcc;

public class Account {
	private String accountNo;
	private String customerID;
	private String isNewCustomer;
	private String accountType;
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setIsNewCustomer(String isExisting) {
		this.isNewCustomer = isExisting;
	}
	
	public String getIsNewCustomer() {
		return isNewCustomer;
	}
	
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountNo() {
		return accountNo;
	}

}
