/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;


// End of user code

/**
 * 
 * 
 */
public interface SwitchMediatorPropertiesEditionPart {

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
	 * @return the source
	 * 
	 */
	public String getSource();

	/**
	 * Defines a new source
	 * @param newValue the new source to set
	 * 
	 */
	public void setSource(String newValue);


	/**
	 * @return the namespace
	 * 
	 */
	public String getNamespace();

	/**
	 * Defines a new namespace
	 * @param newValue the new namespace to set
	 * 
	 */
	public void setNamespace(String newValue);


	/**
	 * @return the namespacePrefix
	 * 
	 */
	public String getNamespacePrefix();

	/**
	 * Defines a new namespacePrefix
	 * @param newValue the new namespacePrefix to set
	 * 
	 */
	public void setNamespacePrefix(String newValue);




	/**
	 * Init the caseBranches
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initCaseBranches(ReferencesTableSettings settings);

	/**
	 * Update the caseBranches
	 * @param newValue the caseBranches to update
	 * 
	 */
	public void updateCaseBranches();

	/**
	 * Adds the given filter to the caseBranches edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToCaseBranches(ViewerFilter filter);

	/**
	 * Adds the given filter to the caseBranches edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToCaseBranches(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the caseBranches table
	 * 
	 */
	public boolean isContainedInCaseBranchesTable(EObject element);




	// Start of user code for sourceXPath specific getters and setters declaration
	public NamespacedProperty getSourceXPath();
    
    public void setSourceXPath(NamespacedProperty nameSpacedProperty);    
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
