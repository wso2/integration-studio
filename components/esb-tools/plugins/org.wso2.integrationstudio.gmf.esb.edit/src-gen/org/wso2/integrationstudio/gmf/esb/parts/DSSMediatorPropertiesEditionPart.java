/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface DSSMediatorPropertiesEditionPart {

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
	 * @return the serviceName
	 * 
	 */
	public String getServiceName();

	/**
	 * Defines a new serviceName
	 * @param newValue the new serviceName to set
	 * 
	 */
	public void setServiceName(String newValue);


	/**
	 * @return the sourceType
	 * 
	 */
	public Enumerator getSourceType();

	/**
	 * Init the sourceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initSourceType(Object input, Enumerator current);

	/**
	 * Defines a new sourceType
	 * @param newValue the new sourceType to set
	 * 
	 */
	public void setSourceType(Enumerator newValue);


	/**
	 * @return the operationType
	 * 
	 */
	public Enumerator getOperationType();

	/**
	 * Init the operationType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initOperationType(Object input, Enumerator current);

	/**
	 * Defines a new operationType
	 * @param newValue the new operationType to set
	 * 
	 */
	public void setOperationType(Enumerator newValue);




	/**
	 * Init the operations
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOperations(ReferencesTableSettings settings);

	/**
	 * Update the operations
	 * @param newValue the operations to update
	 * 
	 */
	public void updateOperations();

	/**
	 * Adds the given filter to the operations edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToOperations(ViewerFilter filter);

	/**
	 * Adds the given filter to the operations edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToOperations(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the operations table
	 * 
	 */
	public boolean isContainedInOperationsTable(EObject element);


	/**
	 * @return the targetType
	 * 
	 */
	public Enumerator getTargetType();

	/**
	 * Init the targetType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTargetType(Object input, Enumerator current);

	/**
	 * Defines a new targetType
	 * @param newValue the new targetType to set
	 * 
	 */
	public void setTargetType(Enumerator newValue);


	/**
	 * @return the targetProperty
	 * 
	 */
	public String getTargetProperty();

	/**
	 * Defines a new targetProperty
	 * @param newValue the new targetProperty to set
	 * 
	 */
	public void setTargetProperty(String newValue);





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
