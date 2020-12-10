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
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface SynapseAPIPropertiesEditionPart {



	/**
	 * Init the handlers
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initHandlers(ReferencesTableSettings settings);

	/**
	 * Update the handlers
	 * @param newValue the handlers to update
	 * 
	 */
	public void updateHandlers();

	/**
	 * Adds the given filter to the handlers edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToHandlers(ViewerFilter filter);

	/**
	 * Adds the given filter to the handlers edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToHandlers(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the handlers table
	 * 
	 */
	public boolean isContainedInHandlersTable(EObject element);


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
	 * @return the apiName
	 * 
	 */
	public String getApiName();

	/**
	 * Defines a new apiName
	 * @param newValue the new apiName to set
	 * 
	 */
	public void setApiName(String newValue);


	/**
	 * @return the context
	 * 
	 */
	public String getContext();

	/**
	 * Defines a new context
	 * @param newValue the new context to set
	 * 
	 */
	public void setContext(String newValue);


	/**
	 * @return the hostName
	 * 
	 */
	public String getHostName();

	/**
	 * Defines a new hostName
	 * @param newValue the new hostName to set
	 * 
	 */
	public void setHostName(String newValue);


	/**
	 * @return the port
	 * 
	 */
	public String getPort();

	/**
	 * Defines a new port
	 * @param newValue the new port to set
	 * 
	 */
	public void setPort(String newValue);




	/**
	 * Init the resources
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initResources(ReferencesTableSettings settings);

	/**
	 * Update the resources
	 * @param newValue the resources to update
	 * 
	 */
	public void updateResources();

	/**
	 * Adds the given filter to the resources edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToResources(ViewerFilter filter);

	/**
	 * Adds the given filter to the resources edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToResources(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the resources table
	 * 
	 */
	public boolean isContainedInResourcesTable(EObject element);


	/**
	 * @return the versionType
	 * 
	 */
	public Enumerator getVersionType();

	/**
	 * Init the versionType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initVersionType(Object input, Enumerator current);

	/**
	 * Defines a new versionType
	 * @param newValue the new versionType to set
	 * 
	 */
	public void setVersionType(Enumerator newValue);


	/**
	 * @return the version
	 * 
	 */
	public String getVersion();

	/**
	 * Defines a new version
	 * @param newValue the new version to set
	 * 
	 */
	public void setVersion(String newValue);


	/**
	 * @return the traceEnabled
	 * 
	 */
	public Boolean getTraceEnabled();

	/**
	 * Defines a new traceEnabled
	 * @param newValue the new traceEnabled to set
	 * 
	 */
	public void setTraceEnabled(Boolean newValue);


	/**
	 * @return the statisticsEnabled
	 * 
	 */
	public Boolean getStatisticsEnabled();

	/**
	 * Defines a new statisticsEnabled
	 * @param newValue the new statisticsEnabled to set
	 * 
	 */
	public void setStatisticsEnabled(Boolean newValue);


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




	// Start of user code for publishSwagger specific getters and setters declaration
	public void setPublishSwagger(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getPublishSwagger();
	// End of user code

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
