package org.wso2.integrationstudio.registry.core.interfaces;

import org.wso2.integrationstudio.platform.core.interfaces.IIntegrationStudioProviderData;


public interface IRegistryResourceProviderData extends IIntegrationStudioProviderData{
	
	/**
	 * get the provider
	 * @return
	 */
	public IRegistryResourceProvider getProvider();
	
}
