/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface CloneMediatorPropertiesEditionPart {

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
	 * @return the commentsList
	 * 
	 */
	public EList getCommentsList();

	/**
	 * Defines a new commentsList
	 * @param newValue the new commentsList to set
	 * 
	 */
	public void setCommentsList(EList newValue);

	/**
	 * Add a value to the commentsList multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToCommentsList(Object newValue);

	/**
	 * Remove a value to the commentsList multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToCommentsList(Object newValue);


	/**
	 * @return the Reverse
	 * 
	 */
	public Boolean getReverse();

	/**
	 * Defines a new Reverse
	 * @param newValue the new Reverse to set
	 * 
	 */
	public void setReverse(Boolean newValue);


	/**
	 * @return the cloneID
	 * 
	 */
	public String getCloneID();

	/**
	 * Defines a new cloneID
	 * @param newValue the new cloneID to set
	 * 
	 */
	public void setCloneID(String newValue);


	/**
	 * @return the sequentialMediation
	 * 
	 */
	public Boolean getSequentialMediation();

	/**
	 * Defines a new sequentialMediation
	 * @param newValue the new sequentialMediation to set
	 * 
	 */
	public void setSequentialMediation(Boolean newValue);


	/**
	 * @return the continueParent
	 * 
	 */
	public Boolean getContinueParent();

	/**
	 * Defines a new continueParent
	 * @param newValue the new continueParent to set
	 * 
	 */
	public void setContinueParent(Boolean newValue);




	/**
	 * Init the targets
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTargets(ReferencesTableSettings settings);

	/**
	 * Update the targets
	 * @param newValue the targets to update
	 * 
	 */
	public void updateTargets();

	/**
	 * Adds the given filter to the targets edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTargets(ViewerFilter filter);

	/**
	 * Adds the given filter to the targets edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTargets(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the targets table
	 * 
	 */
	public boolean isContainedInTargetsTable(EObject element);




	/**
	 * Init the targetsOutputConnector
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTargetsOutputConnector(ReferencesTableSettings settings);

	/**
	 * Update the targetsOutputConnector
	 * @param newValue the targetsOutputConnector to update
	 * 
	 */
	public void updateTargetsOutputConnector();

	/**
	 * Adds the given filter to the targetsOutputConnector edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTargetsOutputConnector(ViewerFilter filter);

	/**
	 * Adds the given filter to the targetsOutputConnector edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTargetsOutputConnector(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the targetsOutputConnector table
	 * 
	 */
	public boolean isContainedInTargetsOutputConnectorTable(EObject element);





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
