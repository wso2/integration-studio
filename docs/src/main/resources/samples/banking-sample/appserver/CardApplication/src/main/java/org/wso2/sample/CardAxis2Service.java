package org.wso2.sample;

public class CardAxis2Service {
	private int cardNo = 1000;
//	private String existing = "1";
	private String nonexisting = "0";
	
	public Card issueCard(String cID, String customerExists, String cName, String accntNo){
		Card card = new Card(cID);
		if(customerExists.equals(nonexisting)){
		    card.setAccountNo(accntNo);
		    card.setCustomerName(cName);
		    card.setCardNo(cardNo++);
		    card.setPin((int)(Math.random()*1000));
		}else{
			card.setCustomerID(cID);
			card.setCustomerName(cName);
		}
		return card;
	}
}
