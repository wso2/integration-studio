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
public interface BuilderMediatorOutputConectorPropertiesEditionPart {



	/**
	 * Init the commentMediators
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initCommentMediators(ReferencesTableSettings settings);

	/**
	 * Update the commentMediators
	 * @param newValue the commentMediators to update
	 * 
	 */
	public void updateCommentMediators();

	/**
	 * Adds the given filter to the commentMediators edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToCommentMediators(ViewerFilter filter);

	/**
	 * Adds the given filter to the commentMediators edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToCommentMediators(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the commentMediators table
	 * 
	 */
	public boolean isContainedInCommentMediatorsTable(EObject element);





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
