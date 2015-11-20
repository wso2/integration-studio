package org.wso2.developerstudio.eclipse.esb.core.internal.impl;

import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEndpointProvider;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEndpointProviderData;

public class EndpointProviderDataImpl implements IEndpointProviderData{
	private String id;
	private String name;
	private IEndpointProvider endpointProvider;
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setProvider(IEndpointProvider endpointProvider) {
		this.endpointProvider = endpointProvider;
	}
	public IEndpointProvider getProvider() {
		return endpointProvider;
	}
	public String getText() {
		return getName();
	}
	
}
