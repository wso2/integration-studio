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
public interface SqlStatementPropertiesEditionPart {

	/**
	 * @return the queryString
	 * 
	 */
	public String getQueryString();

	/**
	 * Defines a new queryString
	 * @param newValue the new queryString to set
	 * 
	 */
	public void setQueryString(String newValue);




	/**
	 * Init the parameters
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initParameters(ReferencesTableSettings settings);

	/**
	 * Update the parameters
	 * @param newValue the parameters to update
	 * 
	 */
	public void updateParameters();

	/**
	 * Adds the given filter to the parameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToParameters(ViewerFilter filter);

	/**
	 * Adds the given filter to the parameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToParameters(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the parameters table
	 * 
	 */
	public boolean isContainedInParametersTable(EObject element);


	/**
	 * @return the resultsEnabled
	 * 
	 */
	public Boolean getResultsEnabled();

	/**
	 * Defines a new resultsEnabled
	 * @param newValue the new resultsEnabled to set
	 * 
	 */
	public void setResultsEnabled(Boolean newValue);




	/**
	 * Init the results
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initResults(ReferencesTableSettings settings);

	/**
	 * Update the results
	 * @param newValue the results to update
	 * 
	 */
	public void updateResults();

	/**
	 * Adds the given filter to the results edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToResults(ViewerFilter filter);

	/**
	 * Adds the given filter to the results edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToResults(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the results table
	 * 
	 */
	public boolean isContainedInResultsTable(EObject element);





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
