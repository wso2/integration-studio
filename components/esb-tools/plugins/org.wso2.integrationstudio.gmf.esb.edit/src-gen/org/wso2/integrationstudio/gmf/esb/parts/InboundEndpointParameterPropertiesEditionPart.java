/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.integrationstudio.gmf.esb.RegistryKeyProperty;

// Start of user code for imports



// End of user code

/**
 * 
 * 
 */
public interface InboundEndpointParameterPropertiesEditionPart {

	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


	/**
	 * @return the inboundEndpointParameterType
	 * 
	 */
	public Object getInboundEndpointParameterType();

	/**
	 * Init the inboundEndpointParameterType
	 * @param input choice of values
	 * @param currentValue the current value
	 */
	public void initInboundEndpointParameterType(Object input, Object currentValue);

	/**
	 * Defines a new inboundEndpointParameterType
	 * @param newValue the new inboundEndpointParameterType to set
	 * 
	 */
	public void setInboundEndpointParameterType(Object newValue);

	/**
	 * Adds the given filter to the inboundEndpointParameterType edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToInboundEndpointParameterType(ViewerFilter filter);


	/**
	 * @return the value
	 * 
	 */
	public String getValue();

	/**
	 * Defines a new value
	 * @param newValue the new value to set
	 * 
	 */
	public void setValue(String newValue);




	// Start of user code for inboundEndpointParameterKey specific getters and setters declaration
	public RegistryKeyProperty getInboundEndpointParameterKey();

	public void setInboundEndpointParameterKey(RegistryKeyProperty registryKeyProperty);
	// End of user code

	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
