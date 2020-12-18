package org.wso2.integrationstudio.registry.core.interfaces;

import java.util.List;
import java.util.Map;

import org.wso2.integrationstudio.platform.core.interfaces.IIntegrationStudioProvider;

public interface IRegistryResourceProvider extends IIntegrationStudioProvider{
	/**
	 * Retrieves the resources provided by this provider
	 * @return
	 */
	public IRegistryResource[] getResources(Map<String,List<String>> filters);
	
	public IRegistryResourceProvider[] getCategories(Map<String, List<String>> filters);

}
