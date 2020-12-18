package org.wso2.integrationstudio.esb.core.interfaces;

import java.util.List;
import java.util.Map;

import org.wso2.integrationstudio.platform.core.interfaces.IIntegrationStudioProvider;

public interface ISequenceProvider extends IIntegrationStudioProvider{
	/**
	 * Retrieves the sequences provided by this provider
	 * @return
	 */
	public IEsbSequence[] getSequences(Map<String,List<String>> filters);
	
	public ISequenceProvider[] getCategories(Map<String, List<String>> filters);

}
