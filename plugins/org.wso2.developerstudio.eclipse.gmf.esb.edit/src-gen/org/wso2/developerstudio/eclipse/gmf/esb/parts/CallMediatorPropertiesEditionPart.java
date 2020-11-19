/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface CallMediatorPropertiesEditionPart {

	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);


	/**
	 * @return the commentsList
	 * 
	 */
	public EList getCommentsList();

	/**
	 * Defines a new commentsList
	 * @param newValue the new commentsList to set
	 * 
	 */
	public void setCommentsList(EList newValue);

	/**
	 * Add a value to the commentsList multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToCommentsList(Object newValue);

	/**
	 * Remove a value to the commentsList multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToCommentsList(Object newValue);


	/**
	 * @return the Reverse
	 * 
	 */
	public Boolean getReverse();

	/**
	 * Defines a new Reverse
	 * @param newValue the new Reverse to set
	 * 
	 */
	public void setReverse(Boolean newValue);




	/**
	 * Init the endpoint
	 * @param settings settings for the endpoint ReferencesTable 
	 */
	public void initEndpoint(ReferencesTableSettings settings);

	/**
	 * Update the endpoint
	 * @param newValue the endpoint to update
	 * 
	 */
	public void updateEndpoint();

	/**
	 * Adds the given filter to the endpoint edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEndpoint(ViewerFilter filter);

	/**
	 * Adds the given filter to the endpoint edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEndpoint(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the endpoint table
	 * 
	 */
	public boolean isContainedInEndpointTable(EObject element);


	/**
	 * @return the endpointType
	 * 
	 */
	public Enumerator getEndpointType();

	/**
	 * Init the endpointType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initEndpointType(Object input, Enumerator current);

	/**
	 * Defines a new endpointType
	 * @param newValue the new endpointType to set
	 * 
	 */
	public void setEndpointType(Enumerator newValue);


	/**
	 * @return the enableBlockingCalls
	 * 
	 */
	public Boolean getEnableBlockingCalls();

	/**
	 * Defines a new enableBlockingCalls
	 * @param newValue the new enableBlockingCalls to set
	 * 
	 */
	public void setEnableBlockingCalls(Boolean newValue);




	// Start of user code for endpointXpath specific getters and setters declaration
    public NamespacedProperty getEndpointXPath();

    public void setEndpointXPath(NamespacedProperty nameSpacedProperty);
	// End of user code
	// Start of user code for endpointRegistryKey specific getters and setters declaration
    public RegistryKeyProperty getEndpointRegistryKey();
    
    public void setEndpointRegistryKey(RegistryKeyProperty registryKeyProperty);
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
