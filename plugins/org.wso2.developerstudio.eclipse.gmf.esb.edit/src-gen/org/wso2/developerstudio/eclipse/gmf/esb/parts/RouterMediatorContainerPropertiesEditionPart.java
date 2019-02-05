/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface RouterMediatorContainerPropertiesEditionPart {



	/**
	 * Init the routerTargetContainer
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initRouterTargetContainer(ReferencesTableSettings settings);

	/**
	 * Update the routerTargetContainer
	 * @param newValue the routerTargetContainer to update
	 * 
	 */
	public void updateRouterTargetContainer();

	/**
	 * Adds the given filter to the routerTargetContainer edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToRouterTargetContainer(ViewerFilter filter);

	/**
	 * Adds the given filter to the routerTargetContainer edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToRouterTargetContainer(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the routerTargetContainer table
	 * 
	 */
	public boolean isContainedInRouterTargetContainerTable(EObject element);





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
