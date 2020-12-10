package org.wso2.integrationstudio.eclipse.registry.core.interfaces;

import org.wso2.integrationstudio.eclipse.platform.core.interfaces.IIntegrationStudioElement;

public interface IRegistryResource extends IIntegrationStudioElement{

	/**
	 * The registry resource path for this resource
	 * 
	 * @return
	 */
	public String getPath();

	/**
	 * Returns a list of possible media types associated for this resources
	 * 
	 * @return
	 */
	public String[] getMediaTypes();

	/**
	 * Get the registry resource which this registry resource is a child of 
	 * @return
	 */
	public IRegistryCollection getParent();
	
}
