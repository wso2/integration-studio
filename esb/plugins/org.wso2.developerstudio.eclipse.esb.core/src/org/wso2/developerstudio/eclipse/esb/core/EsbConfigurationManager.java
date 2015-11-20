package org.wso2.developerstudio.eclipse.esb.core;

import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEndpointProviderData;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.ILocalEntryProviderData;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.ISequenceProviderData;
import org.wso2.developerstudio.eclipse.esb.core.utils.EsbConfigurationExtensionPointHandler;

public class EsbConfigurationManager {
	
	/**
	 * Return a list of endpoint configuration providers
	 * @param refresh - Refresh the list of cached
	 * @return
	 */
	public static IEndpointProviderData[] getEndpointProviders(boolean refresh){
		return EsbConfigurationExtensionPointHandler.getEndpointProviders(refresh);
	}
	
	/**
	 * Return a list of sequence configuration providers
	 * @param refresh - Refresh the list of cached
	 * @return
	 */
	public static ISequenceProviderData[] getSequenceProviders(boolean refresh){
		return EsbConfigurationExtensionPointHandler.getSequenceProviders(refresh);
	}
	
	/**
	 * Return a list of local entry configuration providers
	 * @param refresh - Refresh the list of cached
	 * @return
	 */
	public static ILocalEntryProviderData[] getLocalEntryProviders(boolean refresh){
		return EsbConfigurationExtensionPointHandler.getLocalEntryProviders(refresh);
	}
}
