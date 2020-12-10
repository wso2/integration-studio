package org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints;


public interface IEndpoint {
	
	public void createFormBasicSection();
	public void createFormQosSection();
	public void createFormMiscSection();
	public void createFormErrorHandlingSection();
	
	public EndpointCommons getEndpointCommons();

}
