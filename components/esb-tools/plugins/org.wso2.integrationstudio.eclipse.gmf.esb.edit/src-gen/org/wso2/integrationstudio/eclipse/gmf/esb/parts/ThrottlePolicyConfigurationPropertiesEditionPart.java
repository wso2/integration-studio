/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface ThrottlePolicyConfigurationPropertiesEditionPart {

	/**
	 * @return the policyType
	 * 
	 */
	public Enumerator getPolicyType();

	/**
	 * Init the policyType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPolicyType(Object input, Enumerator current);

	/**
	 * Defines a new policyType
	 * @param newValue the new policyType to set
	 * 
	 */
	public void setPolicyType(Enumerator newValue);


	/**
	 * @return the maxConcurrentAccessCount
	 * 
	 */
	public String getMaxConcurrentAccessCount();

	/**
	 * Defines a new maxConcurrentAccessCount
	 * @param newValue the new maxConcurrentAccessCount to set
	 * 
	 */
	public void setMaxConcurrentAccessCount(String newValue);




	/**
	 * Init the policyEntries
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initPolicyEntries(ReferencesTableSettings settings);

	/**
	 * Update the policyEntries
	 * @param newValue the policyEntries to update
	 * 
	 */
	public void updatePolicyEntries();

	/**
	 * Adds the given filter to the policyEntries edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToPolicyEntries(ViewerFilter filter);

	/**
	 * Adds the given filter to the policyEntries edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToPolicyEntries(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the policyEntries table
	 * 
	 */
	public boolean isContainedInPolicyEntriesTable(EObject element);





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
