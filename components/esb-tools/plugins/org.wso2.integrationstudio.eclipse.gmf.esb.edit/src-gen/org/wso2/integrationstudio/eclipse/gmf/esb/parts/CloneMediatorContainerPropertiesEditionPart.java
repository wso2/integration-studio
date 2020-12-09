/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface CloneMediatorContainerPropertiesEditionPart {



	/**
	 * Init the cloneTargetContainer
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initCloneTargetContainer(ReferencesTableSettings settings);

	/**
	 * Update the cloneTargetContainer
	 * @param newValue the cloneTargetContainer to update
	 * 
	 */
	public void updateCloneTargetContainer();

	/**
	 * Adds the given filter to the cloneTargetContainer edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToCloneTargetContainer(ViewerFilter filter);

	/**
	 * Adds the given filter to the cloneTargetContainer edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToCloneTargetContainer(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the cloneTargetContainer table
	 * 
	 */
	public boolean isContainedInCloneTargetContainerTable(EObject element);





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
