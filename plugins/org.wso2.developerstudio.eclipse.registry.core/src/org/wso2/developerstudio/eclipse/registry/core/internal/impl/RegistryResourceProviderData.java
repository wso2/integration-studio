package org.wso2.developerstudio.eclipse.registry.core.internal.impl;

import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryResourceProvider;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryResourceProviderData;

public class RegistryResourceProviderData implements
		IRegistryResourceProviderData {
	private String id;
	private String name;
	private IRegistryResourceProvider resourceProvider;
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public IRegistryResourceProvider getProvider() {
		return resourceProvider;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setResourceProvider(IRegistryResourceProvider resourceProvider) {
		this.resourceProvider = resourceProvider;
	}

	public String getText() {
		return getName();
	}

}
