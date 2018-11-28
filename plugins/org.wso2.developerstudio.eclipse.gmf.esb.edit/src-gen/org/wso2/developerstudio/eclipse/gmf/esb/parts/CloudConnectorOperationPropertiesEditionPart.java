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


// End of user code

/**
 * 
 * 
 */
public interface CloudConnectorOperationPropertiesEditionPart {

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
	 * Init the connectorParameters
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initConnectorParameters(ReferencesTableSettings settings);

	/**
	 * Update the connectorParameters
	 * @param newValue the connectorParameters to update
	 * 
	 */
	public void updateConnectorParameters();

	/**
	 * Adds the given filter to the connectorParameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToConnectorParameters(ViewerFilter filter);

	/**
	 * Adds the given filter to the connectorParameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToConnectorParameters(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the connectorParameters table
	 * 
	 */
	public boolean isContainedInConnectorParametersTable(EObject element);


	/**
	 * @return the configRef
	 * 
	 */
	public String getConfigRef();

	/**
	 * Defines a new configRef
	 * @param newValue the new configRef to set
	 * 
	 */
	public void setConfigRef(String newValue);


	/**
	 * @return the connectorName
	 * 
	 */
	public String getConnectorName();

	/**
	 * Defines a new connectorName
	 * @param newValue the new connectorName to set
	 * 
	 */
	public void setConnectorName(String newValue);


	/**
	 * @return the operationName
	 * 
	 */
	public String getOperationName();

	/**
	 * Defines a new operationName
	 * @param newValue the new operationName to set
	 * 
	 */
	public void setOperationName(String newValue);


	/**
	 * @return the cloudConnectorName
	 * 
	 */
	public String getCloudConnectorName();

	/**
	 * Defines a new cloudConnectorName
	 * @param newValue the new cloudConnectorName to set
	 * 
	 */
	public void setCloudConnectorName(String newValue);


	/**
	 * @return the availableConfigs
	 * 
	 */
	public String getAvailableConfigs();

	/**
	 * Defines a new availableConfigs
	 * @param newValue the new availableConfigs to set
	 * 
	 */
	public void setAvailableConfigs(String newValue);


	/**
	 * @return the parameterEditorType
	 * 
	 */
	public Enumerator getParameterEditorType();

	/**
	 * Init the parameterEditorType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initParameterEditorType(Object input, Enumerator current);

	/**
	 * Defines a new parameterEditorType
	 * @param newValue the new parameterEditorType to set
	 * 
	 */
	public void setParameterEditorType(Enumerator newValue);





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
