/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface SequencesPropertiesEditionPart {

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
	 * @return the recieveSequence
	 * 
	 */
	public Boolean getRecieveSequence();

	/**
	 * Defines a new recieveSequence
	 * @param newValue the new recieveSequence to set
	 * 
	 */
	public void setRecieveSequence(Boolean newValue);


	/**
	 * @return the associatedProxy
	 * 
	 */
	public EList getAssociatedProxy();

	/**
	 * Defines a new associatedProxy
	 * @param newValue the new associatedProxy to set
	 * 
	 */
	public void setAssociatedProxy(EList newValue);

	/**
	 * Add a value to the associatedProxy multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToAssociatedProxy(Object newValue);

	/**
	 * Remove a value to the associatedProxy multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToAssociatedProxy(Object newValue);




	/**
	 * Init the templateParameters
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTemplateParameters(ReferencesTableSettings settings);

	/**
	 * Update the templateParameters
	 * @param newValue the templateParameters to update
	 * 
	 */
	public void updateTemplateParameters();

	/**
	 * Adds the given filter to the templateParameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTemplateParameters(ViewerFilter filter);

	/**
	 * Adds the given filter to the templateParameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTemplateParameters(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the templateParameters table
	 * 
	 */
	public boolean isContainedInTemplateParametersTable(EObject element);


	/**
	 * @return the traceEnabled
	 * 
	 */
	public Boolean getTraceEnabled();

	/**
	 * Defines a new traceEnabled
	 * @param newValue the new traceEnabled to set
	 * 
	 */
	public void setTraceEnabled(Boolean newValue);


	/**
	 * @return the statisticsEnabled
	 * 
	 */
	public Boolean getStatisticsEnabled();

	/**
	 * Defines a new statisticsEnabled
	 * @param newValue the new statisticsEnabled to set
	 * 
	 */
	public void setStatisticsEnabled(Boolean newValue);




	// Start of user code for onError specific getters and setters declaration
    public RegistryKeyProperty getOnError();
    
    public void setOnError(RegistryKeyProperty registryKeyProperty);
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
