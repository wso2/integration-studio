package org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores;


public interface IMessageStore {

	public void createConnectionSectionFields();
	public void createParameterSectionFields();
	
	public boolean hasGuaranteedDelivery();
	public boolean hasParameters();
	public boolean hasConnection();
	
	public  void hideGuaranteedDeliverySection();
	public  void hideParametersSection();
	public  void hideConnectionSection();
	
	public  void showGuaranteedDeliverySection();
	public  void showParametersSection();
	public  void showConnectionSection();
}
