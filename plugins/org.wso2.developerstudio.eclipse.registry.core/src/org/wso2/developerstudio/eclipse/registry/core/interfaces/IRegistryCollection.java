package org.wso2.developerstudio.eclipse.registry.core.interfaces;

import java.util.List;
import java.util.Map;

public interface IRegistryCollection extends IRegistryResource {

	/**
	 * Return known registry resources inside this registry resource collection
	 * 
	 * @return
	 */
	public IRegistryResource[] getChildren(Map<String,List<String>> filters);
}
