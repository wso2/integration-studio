package org.wso2.developerstudio.eclipse.esb.core.internal.impl;

import org.wso2.developerstudio.eclipse.esb.core.interfaces.ILocalEntryProvider;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.ILocalEntryProviderData;

public class LocalEntryProviderDataImpl implements ILocalEntryProviderData{
	private String id;
	private String name;
	private ILocalEntryProvider provider;
	
	public String getText() {
		return getName();
	}

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

	public void setProvider(ILocalEntryProvider provider) {
		this.provider = provider;
	}

	public ILocalEntryProvider getProvider() {
		return provider;
	}

}
