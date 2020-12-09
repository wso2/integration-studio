package org.wso2.developerstudio.eclipse.esb.core.internal.impl;

import org.wso2.developerstudio.eclipse.esb.core.interfaces.ISequenceProvider;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.ISequenceProviderData;

public class SequenceProviderDataImpl implements ISequenceProviderData{
	private String id;
	private String name;
	private ISequenceProvider provider;
	
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

	public void setProvider(ISequenceProvider provider) {
		this.provider = provider;
	}

	public ISequenceProvider getProvider() {
		return provider;
	}

}
