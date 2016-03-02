package org.wso2.developerstudio.eclipse.esb.core.interfaces;

import java.util.List;
import java.util.Map;

import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProvider;

public interface ISequenceProvider extends IDeveloperStudioProvider{
	/**
	 * Retrieves the sequences provided by this provider
	 * @return
	 */
	public IEsbSequence[] getSequences(Map<String,List<String>> filters);
	
	public ISequenceProvider[] getCategories(Map<String, List<String>> filters);

}
