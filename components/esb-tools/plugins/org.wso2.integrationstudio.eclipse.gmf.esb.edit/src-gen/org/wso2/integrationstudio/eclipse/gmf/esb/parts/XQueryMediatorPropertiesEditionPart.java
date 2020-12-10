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
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface XQueryMediatorPropertiesEditionPart {

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
	 * Init the variables
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initVariables(ReferencesTableSettings settings);

	/**
	 * Update the variables
	 * @param newValue the variables to update
	 * 
	 */
	public void updateVariables();

	/**
	 * Adds the given filter to the variables edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToVariables(ViewerFilter filter);

	/**
	 * Adds the given filter to the variables edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToVariables(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the variables table
	 * 
	 */
	public boolean isContainedInVariablesTable(EObject element);


	/**
	 * @return the scriptKeyType
	 * 
	 */
	public Enumerator getScriptKeyType();

	/**
	 * Init the scriptKeyType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initScriptKeyType(Object input, Enumerator current);

	/**
	 * Defines a new scriptKeyType
	 * @param newValue the new scriptKeyType to set
	 * 
	 */
	public void setScriptKeyType(Enumerator newValue);


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




	// Start of user code for staticScriptKey specific getters and setters declaration
	public void setStaticScriptKey(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getStaticScriptKeyProperty();
	// End of user code
	// Start of user code for targetXPath specific getters and setters declaration
	public void setTargetXPath(NamespacedProperty namespacedProperty);
	
	public NamespacedProperty getTargetXpath();
	// End of user code
	// Start of user code for dynamicScriptKey specific getters and setters declaration
	public void setDynamicScriptKey(NamespacedProperty namespacedProperty);
	
	public NamespacedProperty getDynamicScriptKey();
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
