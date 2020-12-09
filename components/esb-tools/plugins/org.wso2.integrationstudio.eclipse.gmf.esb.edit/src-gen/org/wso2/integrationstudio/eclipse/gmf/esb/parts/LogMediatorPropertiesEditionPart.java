/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface LogMediatorPropertiesEditionPart {

	/**
	 * @return the logCategory
	 * 
	 */
	public Enumerator getLogCategory();

	/**
	 * Init the logCategory
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initLogCategory(Object input, Enumerator current);

	/**
	 * Defines a new logCategory
	 * @param newValue the new logCategory to set
	 * 
	 */
	public void setLogCategory(Enumerator newValue);


	/**
	 * @return the logLevel
	 * 
	 */
	public Enumerator getLogLevel();

	/**
	 * Init the logLevel
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initLogLevel(Object input, Enumerator current);

	/**
	 * Defines a new logLevel
	 * @param newValue the new logLevel to set
	 * 
	 */
	public void setLogLevel(Enumerator newValue);


	/**
	 * @return the logSeparator
	 * 
	 */
	public String getLogSeparator();

	/**
	 * Defines a new logSeparator
	 * @param newValue the new logSeparator to set
	 * 
	 */
	public void setLogSeparator(String newValue);




	/**
	 * Init the properties
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initProperties(ReferencesTableSettings settings);

	/**
	 * Update the properties
	 * @param newValue the properties to update
	 * 
	 */
	public void updateProperties();

	/**
	 * Adds the given filter to the properties edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToProperties(ViewerFilter filter);

	/**
	 * Adds the given filter to the properties edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToProperties(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the properties table
	 * 
	 */
	public boolean isContainedInPropertiesTable(EObject element);


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
