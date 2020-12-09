package org.wso2.integrationstudio.eclipse.esb.core.interfaces;

import java.util.List;
import java.util.Map;

import org.wso2.integrationstudio.eclipse.platform.core.interfaces.IIntegrationStudioProvider;

public interface ILocalEntryProvider extends IIntegrationStudioProvider{
	/**
	 * Retrieves the local entries provided by this provider
	 * @return
	 */
	public IEsbLocalEntry[] getLocalEntries(Map<String,List<String>> filters);
	
	public ILocalEntryProvider[] getCategories(Map<String, List<String>> filters);
}
