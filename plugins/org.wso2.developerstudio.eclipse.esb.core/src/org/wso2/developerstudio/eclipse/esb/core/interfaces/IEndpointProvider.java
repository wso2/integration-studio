package org.wso2.developerstudio.eclipse.esb.core.interfaces;

import java.util.List;
import java.util.Map;

import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProvider;

public interface IEndpointProvider extends IDeveloperStudioProvider{
	/**
	 * Retrieves the endpoints provided by this provider
	 * @return
	 */
	public IEsbEndpoint[] getEndpoints(Map<String,List<String>> filters);
	
	public IEndpointProvider[] getCategories(Map<String, List<String>> filters);
}
