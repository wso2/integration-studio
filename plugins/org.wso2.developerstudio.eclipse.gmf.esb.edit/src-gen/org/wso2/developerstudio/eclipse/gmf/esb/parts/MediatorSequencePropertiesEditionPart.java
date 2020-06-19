/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface MediatorSequencePropertiesEditionPart {

	/**
	 * @return the anonymous
	 * 
	 */
	public Boolean getAnonymous();

	/**
	 * Defines a new anonymous
	 * @param newValue the new anonymous to set
	 * 
	 */
	public void setAnonymous(Boolean newValue);


	/**
	 * @return the sequenceName
	 * 
	 */
	public String getSequenceName();

	/**
	 * Defines a new sequenceName
	 * @param newValue the new sequenceName to set
	 * 
	 */
	public void setSequenceName(String newValue);




	/**
	 * Init the mediators
	 * @param settings settings for the mediators ReferencesTable 
	 */
	public void initMediators(ReferencesTableSettings settings);

	/**
	 * Update the mediators
	 * @param newValue the mediators to update
	 * 
	 */
	public void updateMediators();

	/**
	 * Adds the given filter to the mediators edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToMediators(ViewerFilter filter);

	/**
	 * Adds the given filter to the mediators edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToMediators(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the mediators table
	 * 
	 */
	public boolean isContainedInMediatorsTable(EObject element);


	/**
	 * @return the onError
	 * 
	 */
	public EObject getOnError();

	/**
	 * Init the onError
	 * @param settings the combo setting
	 */
	public void initOnError(EObjectFlatComboSettings settings);

	/**
	 * Defines a new onError
	 * @param newValue the new onError to set
	 * 
	 */
	public void setOnError(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setOnErrorButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the onError edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToOnError(ViewerFilter filter);

	/**
	 * Adds the given filter to the onError edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToOnError(ViewerFilter filter);


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
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
