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
public interface SwitchCaseParentContainerPropertiesEditionPart {



	/**
	 * Init the switchCaseContainer
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initSwitchCaseContainer(ReferencesTableSettings settings);

	/**
	 * Update the switchCaseContainer
	 * @param newValue the switchCaseContainer to update
	 * 
	 */
	public void updateSwitchCaseContainer();

	/**
	 * Adds the given filter to the switchCaseContainer edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSwitchCaseContainer(ViewerFilter filter);

	/**
	 * Adds the given filter to the switchCaseContainer edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSwitchCaseContainer(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the switchCaseContainer table
	 * 
	 */
	public boolean isContainedInSwitchCaseContainerTable(EObject element);





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
