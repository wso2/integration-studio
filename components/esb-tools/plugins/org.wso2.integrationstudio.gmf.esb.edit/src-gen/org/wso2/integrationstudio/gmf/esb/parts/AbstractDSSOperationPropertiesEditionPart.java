/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface AbstractDSSOperationPropertiesEditionPart {



	/**
	 * Init the DSSPrperties
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initDSSPrperties(ReferencesTableSettings settings);

	/**
	 * Update the DSSPrperties
	 * @param newValue the DSSPrperties to update
	 * 
	 */
	public void updateDSSPrperties();

	/**
	 * Adds the given filter to the DSSPrperties edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToDSSPrperties(ViewerFilter filter);

	/**
	 * Adds the given filter to the DSSPrperties edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToDSSPrperties(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the DSSPrperties table
	 * 
	 */
	public boolean isContainedInDSSPrpertiesTable(EObject element);


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
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
