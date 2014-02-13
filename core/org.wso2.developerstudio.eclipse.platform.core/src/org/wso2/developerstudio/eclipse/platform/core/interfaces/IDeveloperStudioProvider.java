package org.wso2.developerstudio.eclipse.platform.core.interfaces;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;

public interface IDeveloperStudioProvider {
	/**
	 * Get a unique id for this provider
	 * @return
	 */
	public String getId();
	
	/**
	 * Get the display caption of this provider
	 * @return
	 */
	public String getText();
	
	/**
	 * Get an image descriptor to represent an Icon for this provider
	 * @return
	 */
	public ImageDescriptor getIcon();
	
	/**
	 * Get a sublist of providers for this provider
	 * @return
	 */
	public IDeveloperStudioProvider[] getCategories(Map<String, List<String>> filters);
	
	/**
	 * Retrieves the elements provided by this provider
	 * @return
	 */
	public IDeveloperStudioElement[] getElements(Map<String,List<String>> filters);
	
	/**
	 * Refresh if the lists are cached
	 */
	public void refresh();

}
