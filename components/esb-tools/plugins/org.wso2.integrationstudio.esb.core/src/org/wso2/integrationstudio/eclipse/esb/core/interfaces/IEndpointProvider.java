package org.wso2.integrationstudio.esb.core.interfaces;

import java.util.List;
import java.util.Map;

import org.wso2.integrationstudio.platform.core.interfaces.IIntegrationStudioProvider;

public interface IEndpointProvider extends IIntegrationStudioProvider{
	/**
	 * Retrieves the endpoints provided by this provider
	 * @return
	 */
	public IEsbEndpoint[] getEndpoints(Map<String,List<String>> filters);
	
	public IEndpointProvider[] getCategories(Map<String, List<String>> filters);
}
