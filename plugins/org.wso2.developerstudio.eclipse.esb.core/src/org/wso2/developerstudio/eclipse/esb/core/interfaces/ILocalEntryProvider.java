package org.wso2.developerstudio.eclipse.esb.core.interfaces;

import java.util.List;
import java.util.Map;

import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProvider;

public interface ILocalEntryProvider extends IDeveloperStudioProvider{
	/**
	 * Retrieves the local entries provided by this provider
	 * @return
	 */
	public IEsbLocalEntry[] getLocalEntries(Map<String,List<String>> filters);
	
	public ILocalEntryProvider[] getCategories(Map<String, List<String>> filters);
}
