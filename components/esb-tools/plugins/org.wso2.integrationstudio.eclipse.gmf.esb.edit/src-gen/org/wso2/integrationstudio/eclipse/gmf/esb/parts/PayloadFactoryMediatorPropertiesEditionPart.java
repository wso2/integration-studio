/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface PayloadFactoryMediatorPropertiesEditionPart {

	/**
	 * @return the payloadFormat
	 * 
	 */
	public Enumerator getPayloadFormat();

	/**
	 * Init the payloadFormat
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPayloadFormat(Object input, Enumerator current);

	/**
	 * Defines a new payloadFormat
	 * @param newValue the new payloadFormat to set
	 * 
	 */
	public void setPayloadFormat(Enumerator newValue);


	/**
	 * @return the payload
	 * 
	 */
	public String getPayload();

	/**
	 * Defines a new payload
	 * @param newValue the new payload to set
	 * 
	 */
	public void setPayload(String newValue);




	/**
	 * Init the args
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initArgs(ReferencesTableSettings settings);

	/**
	 * Update the args
	 * @param newValue the args to update
	 * 
	 */
	public void updateArgs();

	/**
	 * Adds the given filter to the args edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToArgs(ViewerFilter filter);

	/**
	 * Adds the given filter to the args edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToArgs(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the args table
	 * 
	 */
	public boolean isContainedInArgsTable(EObject element);


	/**
	 * @return the mediaType
	 * 
	 */
	public Enumerator getMediaType();

	/**
	 * Init the mediaType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initMediaType(Object input, Enumerator current);

	/**
	 * Defines a new mediaType
	 * @param newValue the new mediaType to set
	 * 
	 */
	public void setMediaType(Enumerator newValue);


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




	// Start of user code for payloadKey specific getters and setters declaration
	public void setPayloadKey(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getPayloadKey();
	
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
