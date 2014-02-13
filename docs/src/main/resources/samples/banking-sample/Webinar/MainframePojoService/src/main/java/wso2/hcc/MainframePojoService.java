package wso2.hcc;

public class MainframePojoService {
	private String isNewCustomer;
	
	public Account createAccount(String customerId, String isNewCustomer, String accountType){
		String accountNo = createAccountNo(customerId);
		setIsNewCustomer(isNewCustomer);
		Account account = new Account();
		account.setAccountNo(accountNo);
		account.setAccountType(accountType);
		account.setCustomerID(customerId);
		account.setIsNewCustomer(isNewCustomer);
		return account;
	}
	
	public String createAccountNo(String customerID){
		int randomNo = (int)(Math.random() * 1000);
		return randomNo + customerID;
		
	}
	
	public void linkCardToAccount(String customerID, String isExisting){
		if(isExisting.equals("1")){
			
		}		
	}
	
	public void setIsNewCustomer(String isExistingCustomer) {
		this.isNewCustomer = isExistingCustomer;
	}

	public String getIsNewCustomer() {
		return isNewCustomer;
	}
}
