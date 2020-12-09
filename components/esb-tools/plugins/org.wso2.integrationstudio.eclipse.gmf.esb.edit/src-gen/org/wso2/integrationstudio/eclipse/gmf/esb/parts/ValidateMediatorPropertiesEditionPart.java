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
public interface ValidateMediatorPropertiesEditionPart {

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
	 * Init the features
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initFeatures(ReferencesTableSettings settings);

	/**
	 * Update the features
	 * @param newValue the features to update
	 * 
	 */
	public void updateFeatures();

	/**
	 * Adds the given filter to the features edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToFeatures(ViewerFilter filter);

	/**
	 * Adds the given filter to the features edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToFeatures(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the features table
	 * 
	 */
	public boolean isContainedInFeaturesTable(EObject element);




	/**
	 * Init the schemas
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initSchemas(ReferencesTableSettings settings);

	/**
	 * Update the schemas
	 * @param newValue the schemas to update
	 * 
	 */
	public void updateSchemas();

	/**
	 * Adds the given filter to the schemas edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSchemas(ViewerFilter filter);

	/**
	 * Adds the given filter to the schemas edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSchemas(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the schemas table
	 * 
	 */
	public boolean isContainedInSchemasTable(EObject element);




	/**
	 * Init the resources
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initResources(ReferencesTableSettings settings);

	/**
	 * Update the resources
	 * @param newValue the resources to update
	 * 
	 */
	public void updateResources();

	/**
	 * Adds the given filter to the resources edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToResources(ViewerFilter filter);

	/**
	 * Adds the given filter to the resources edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToResources(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the resources table
	 * 
	 */
	public boolean isContainedInResourcesTable(EObject element);


	/**
	 * @return the enableCacheSchema
	 * 
	 */
	public Boolean getEnableCacheSchema();

	/**
	 * Defines a new enableCacheSchema
	 * @param newValue the new enableCacheSchema to set
	 * 
	 */
	public void setEnableCacheSchema(Boolean newValue);




	// Start of user code for source specific getters and setters declaration
    public NamespacedProperty getSource();

    public void setSource(NamespacedProperty nameSpacedProperty);

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
