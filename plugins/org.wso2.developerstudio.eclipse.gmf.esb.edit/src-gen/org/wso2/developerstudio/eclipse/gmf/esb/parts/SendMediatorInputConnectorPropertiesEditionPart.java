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
public interface SendMediatorInputConnectorPropertiesEditionPart {



	/**
	 * Init the incomingLinks
	 * @param settings settings for the incomingLinks ReferencesTable 
	 */
	public void initIncomingLinks(ReferencesTableSettings settings);

	/**
	 * Update the incomingLinks
	 * @param newValue the incomingLinks to update
	 * 
	 */
	public void updateIncomingLinks();

	/**
	 * Adds the given filter to the incomingLinks edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToIncomingLinks(ViewerFilter filter);

	/**
	 * Adds the given filter to the incomingLinks edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToIncomingLinks(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the incomingLinks table
	 * 
	 */
	public boolean isContainedInIncomingLinksTable(EObject element);





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
