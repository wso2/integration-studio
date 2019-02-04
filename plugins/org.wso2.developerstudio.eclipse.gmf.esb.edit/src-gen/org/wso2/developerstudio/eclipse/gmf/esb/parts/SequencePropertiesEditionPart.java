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
public interface SequencePropertiesEditionPart {

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
	 * @return the key
	 * 
	 */
	public String getKey();

	/**
	 * Defines a new key
	 * @param newValue the new key to set
	 * 
	 */
	public void setKey(String newValue);




	/**
	 * Init the outputConnector
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOutputConnector(ReferencesTableSettings settings);

	/**
	 * Update the outputConnector
	 * @param newValue the outputConnector to update
	 * 
	 */
	public void updateOutputConnector();

	/**
	 * Adds the given filter to the outputConnector edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToOutputConnector(ViewerFilter filter);

	/**
	 * Adds the given filter to the outputConnector edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToOutputConnector(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the outputConnector table
	 * 
	 */
	public boolean isContainedInOutputConnectorTable(EObject element);




	/**
	 * Init the includedMediators
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initIncludedMediators(ReferencesTableSettings settings);

	/**
	 * Update the includedMediators
	 * @param newValue the includedMediators to update
	 * 
	 */
	public void updateIncludedMediators();

	/**
	 * Adds the given filter to the includedMediators edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToIncludedMediators(ViewerFilter filter);

	/**
	 * Adds the given filter to the includedMediators edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToIncludedMediators(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the includedMediators table
	 * 
	 */
	public boolean isContainedInIncludedMediatorsTable(EObject element);


	/**
	 * @return the receiveSequence
	 * 
	 */
	public Boolean getReceiveSequence();

	/**
	 * Defines a new receiveSequence
	 * @param newValue the new receiveSequence to set
	 * 
	 */
	public void setReceiveSequence(Boolean newValue);


	/**
	 * @return the duplicate
	 * 
	 */
	public Boolean getDuplicate();

	/**
	 * Defines a new duplicate
	 * @param newValue the new duplicate to set
	 * 
	 */
	public void setDuplicate(Boolean newValue);


	/**
	 * @return the referringSequenceType
	 * 
	 */
	public Enumerator getReferringSequenceType();

	/**
	 * Init the referringSequenceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initReferringSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new referringSequenceType
	 * @param newValue the new referringSequenceType to set
	 * 
	 */
	public void setReferringSequenceType(Enumerator newValue);




	// Start of user code for staticReferenceKey specific getters and setters declaration
    public RegistryKeyProperty getStaticReferenceKey();
    
    public void setStaticReferenceKey(RegistryKeyProperty registryKeyProperty);
	// End of user code
	// Start of user code for dynamicReferenceKey specific getters and setters declaration
	public NamespacedProperty getdDynamicReferenceKey();
    
    public void setDynamicReferenceKey(NamespacedProperty nameSpacedProperty);
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
