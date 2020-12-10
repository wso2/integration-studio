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
public interface TaskPropertiesEditionPart {

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
	 * @return the taskName
	 * 
	 */
	public String getTaskName();

	/**
	 * Defines a new taskName
	 * @param newValue the new taskName to set
	 * 
	 */
	public void setTaskName(String newValue);


	/**
	 * @return the taskGroup
	 * 
	 */
	public String getTaskGroup();

	/**
	 * Defines a new taskGroup
	 * @param newValue the new taskGroup to set
	 * 
	 */
	public void setTaskGroup(String newValue);


	/**
	 * @return the triggerType
	 * 
	 */
	public Enumerator getTriggerType();

	/**
	 * Init the triggerType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTriggerType(Object input, Enumerator current);

	/**
	 * Defines a new triggerType
	 * @param newValue the new triggerType to set
	 * 
	 */
	public void setTriggerType(Enumerator newValue);


	/**
	 * @return the count
	 * 
	 */
	public String getCount();

	/**
	 * Defines a new count
	 * @param newValue the new count to set
	 * 
	 */
	public void setCount(String newValue);


	/**
	 * @return the interval
	 * 
	 */
	public String getInterval();

	/**
	 * Defines a new interval
	 * @param newValue the new interval to set
	 * 
	 */
	public void setInterval(String newValue);


	/**
	 * @return the cron
	 * 
	 */
	public String getCron();

	/**
	 * Defines a new cron
	 * @param newValue the new cron to set
	 * 
	 */
	public void setCron(String newValue);


	/**
	 * @return the pinnedServers
	 * 
	 */
	public String getPinnedServers();

	/**
	 * Defines a new pinnedServers
	 * @param newValue the new pinnedServers to set
	 * 
	 */
	public void setPinnedServers(String newValue);


	/**
	 * @return the taskImplementation
	 * 
	 */
	public String getTaskImplementation();

	/**
	 * Defines a new taskImplementation
	 * @param newValue the new taskImplementation to set
	 * 
	 */
	public void setTaskImplementation(String newValue);




	/**
	 * Init the taskProperties
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTaskProperties(ReferencesTableSettings settings);

	/**
	 * Update the taskProperties
	 * @param newValue the taskProperties to update
	 * 
	 */
	public void updateTaskProperties();

	/**
	 * Adds the given filter to the taskProperties edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTaskProperties(ViewerFilter filter);

	/**
	 * Adds the given filter to the taskProperties edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTaskProperties(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the taskProperties table
	 * 
	 */
	public boolean isContainedInTaskPropertiesTable(EObject element);





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
