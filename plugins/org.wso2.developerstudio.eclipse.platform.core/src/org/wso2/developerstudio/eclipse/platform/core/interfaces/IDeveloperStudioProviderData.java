package org.wso2.developerstudio.eclipse.platform.core.interfaces;


public interface IDeveloperStudioProviderData {
	/**
	 * Get the id for this provider
	 * @return
	 */
	public String getId();
	
	/**
	 * Get the name of this provider
	 * @return
	 */
	public String getName();
	
	/**
	 * get the provider
	 * @return
	 */
	public IDeveloperStudioProvider getProvider();
	
	/**
	 * Get list displayable text
	 * @return
	 */
	public String getText();
}
