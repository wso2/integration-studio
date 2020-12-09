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
public interface ProxyServicePropertiesEditionPart {

	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


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
	 * @return the serviceGroup
	 * 
	 */
	public String getServiceGroup();

	/**
	 * Defines a new serviceGroup
	 * @param newValue the new serviceGroup to set
	 * 
	 */
	public void setServiceGroup(String newValue);


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
	 * @return the startOnLoad
	 * 
	 */
	public Boolean getStartOnLoad();

	/**
	 * Defines a new startOnLoad
	 * @param newValue the new startOnLoad to set
	 * 
	 */
	public void setStartOnLoad(Boolean newValue);


	/**
	 * @return the transports
	 * 
	 */
	public String getTransports();

	/**
	 * Defines a new transports
	 * @param newValue the new transports to set
	 * 
	 */
	public void setTransports(String newValue);


	/**
	 * @return the endpointType
	 * 
	 */
	public Enumerator getEndpointType();

	/**
	 * Init the endpointType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initEndpointType(Object input, Enumerator current);

	/**
	 * Defines a new endpointType
	 * @param newValue the new endpointType to set
	 * 
	 */
	public void setEndpointType(Enumerator newValue);


	/**
	 * @return the endpointName
	 * 
	 */
	public String getEndpointName();

	/**
	 * Defines a new endpointName
	 * @param newValue the new endpointName to set
	 * 
	 */
	public void setEndpointName(String newValue);


	/**
	 * @return the faultSequenceType
	 * 
	 */
	public Enumerator getFaultSequenceType();

	/**
	 * Init the faultSequenceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initFaultSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new faultSequenceType
	 * @param newValue the new faultSequenceType to set
	 * 
	 */
	public void setFaultSequenceType(Enumerator newValue);


	/**
	 * @return the faultSequenceName
	 * 
	 */
	public String getFaultSequenceName();

	/**
	 * Defines a new faultSequenceName
	 * @param newValue the new faultSequenceName to set
	 * 
	 */
	public void setFaultSequenceName(String newValue);


	/**
	 * @return the inSequenceType
	 * 
	 */
	public Enumerator getInSequenceType();

	/**
	 * Init the inSequenceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initInSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new inSequenceType
	 * @param newValue the new inSequenceType to set
	 * 
	 */
	public void setInSequenceType(Enumerator newValue);


	/**
	 * @return the inSequenceName
	 * 
	 */
	public String getInSequenceName();

	/**
	 * Defines a new inSequenceName
	 * @param newValue the new inSequenceName to set
	 * 
	 */
	public void setInSequenceName(String newValue);


	/**
	 * @return the outSequenceType
	 * 
	 */
	public Enumerator getOutSequenceType();

	/**
	 * Init the outSequenceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initOutSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new outSequenceType
	 * @param newValue the new outSequenceType to set
	 * 
	 */
	public void setOutSequenceType(Enumerator newValue);


	/**
	 * @return the outSequenceName
	 * 
	 */
	public String getOutSequenceName();

	/**
	 * Defines a new outSequenceName
	 * @param newValue the new outSequenceName to set
	 * 
	 */
	public void setOutSequenceName(String newValue);




	/**
	 * Init the serviceParameters
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initServiceParameters(ReferencesTableSettings settings);

	/**
	 * Update the serviceParameters
	 * @param newValue the serviceParameters to update
	 * 
	 */
	public void updateServiceParameters();

	/**
	 * Adds the given filter to the serviceParameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToServiceParameters(ViewerFilter filter);

	/**
	 * Adds the given filter to the serviceParameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToServiceParameters(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the serviceParameters table
	 * 
	 */
	public boolean isContainedInServiceParametersTable(EObject element);


	/**
	 * @return the reliableMessagingEnabled
	 * 
	 */
	public Boolean getReliableMessagingEnabled();

	/**
	 * Defines a new reliableMessagingEnabled
	 * @param newValue the new reliableMessagingEnabled to set
	 * 
	 */
	public void setReliableMessagingEnabled(Boolean newValue);


	/**
	 * @return the securityEnabled
	 * 
	 */
	public Boolean getSecurityEnabled();

	/**
	 * Defines a new securityEnabled
	 * @param newValue the new securityEnabled to set
	 * 
	 */
	public void setSecurityEnabled(Boolean newValue);




	/**
	 * Init the servicePolicies
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initServicePolicies(ReferencesTableSettings settings);

	/**
	 * Update the servicePolicies
	 * @param newValue the servicePolicies to update
	 * 
	 */
	public void updateServicePolicies();

	/**
	 * Adds the given filter to the servicePolicies edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToServicePolicies(ViewerFilter filter);

	/**
	 * Adds the given filter to the servicePolicies edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToServicePolicies(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the servicePolicies table
	 * 
	 */
	public boolean isContainedInServicePoliciesTable(EObject element);


	/**
	 * @return the wsdlType
	 * 
	 */
	public Enumerator getWsdlType();

	/**
	 * Init the wsdlType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initWsdlType(Object input, Enumerator current);

	/**
	 * Defines a new wsdlType
	 * @param newValue the new wsdlType to set
	 * 
	 */
	public void setWsdlType(Enumerator newValue);


	/**
	 * @return the wsdlXML
	 * 
	 */
	public String getWsdlXML();

	/**
	 * Defines a new wsdlXML
	 * @param newValue the new wsdlXML to set
	 * 
	 */
	public void setWsdlXML(String newValue);


	/**
	 * @return the wsdlURL
	 * 
	 */
	public String getWsdlURL();

	/**
	 * Defines a new wsdlURL
	 * @param newValue the new wsdlURL to set
	 * 
	 */
	public void setWsdlURL(String newValue);




	/**
	 * Init the wsdlResources
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initWsdlResources(ReferencesTableSettings settings);

	/**
	 * Update the wsdlResources
	 * @param newValue the wsdlResources to update
	 * 
	 */
	public void updateWsdlResources();

	/**
	 * Adds the given filter to the wsdlResources edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToWsdlResources(ViewerFilter filter);

	/**
	 * Adds the given filter to the wsdlResources edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToWsdlResources(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the wsdlResources table
	 * 
	 */
	public boolean isContainedInWsdlResourcesTable(EObject element);


	/**
	 * @return the preservePolicy
	 * 
	 */
	public Boolean getPreservePolicy();

	/**
	 * Defines a new preservePolicy
	 * @param newValue the new preservePolicy to set
	 * 
	 */
	public void setPreservePolicy(Boolean newValue);


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
	 * Init the inSequenceInputConnectors
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initInSequenceInputConnectors(ReferencesTableSettings settings);

	/**
	 * Update the inSequenceInputConnectors
	 * @param newValue the inSequenceInputConnectors to update
	 * 
	 */
	public void updateInSequenceInputConnectors();

	/**
	 * Adds the given filter to the inSequenceInputConnectors edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToInSequenceInputConnectors(ViewerFilter filter);

	/**
	 * Adds the given filter to the inSequenceInputConnectors edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToInSequenceInputConnectors(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the inSequenceInputConnectors table
	 * 
	 */
	public boolean isContainedInInSequenceInputConnectorsTable(EObject element);


	/**
	 * @return the mainSequence
	 * 
	 */
	public Boolean getMainSequence();

	/**
	 * Defines a new mainSequence
	 * @param newValue the new mainSequence to set
	 * 
	 */
	public void setMainSequence(Boolean newValue);




	// Start of user code for onError specific getters and setters declaration
	public void setOnError(RegistryKeyProperty rkp);
	
	public RegistryKeyProperty getOnError();
	
	// End of user code
	// Start of user code for endpointKey specific getters and setters declaration
	public void setEndpointKey(RegistryKeyProperty rkp);
	
	public RegistryKeyProperty getEndpointKey();
	
	// End of user code
	// Start of user code for faultSequenceKey specific getters and setters declaration
	public void setFaultSequenceKey(RegistryKeyProperty rkp);
	
	public RegistryKeyProperty getFaultSequenceKey();
	
	// End of user code
	// Start of user code for faultSequenceOnError specific getters and setters declaration
	public void setFaultSequenceOnError(RegistryKeyProperty rkp);
	
	public RegistryKeyProperty getFaultSequenceOnError();
	
	// End of user code
	// Start of user code for inSequenceKey specific getters and setters declaration
	public void setInSequenceKey(RegistryKeyProperty rkp);
	
	public RegistryKeyProperty getInSequenceKey();
	    
	// End of user code
	// Start of user code for inSequenceOnError specific getters and setters declaration
	public void setInSequenceOnError(RegistryKeyProperty rkp);
	
	public RegistryKeyProperty getInSequenceOnError();
	
	// End of user code
	// Start of user code for outSequenceKey specific getters and setters declaration
	public void setOutSequenceKey(RegistryKeyProperty rkp);
	
	public RegistryKeyProperty getOutSequenceKey();
	
	// End of user code
	// Start of user code for outSequenceOnError specific getters and setters declaration
	public void setOutSequenceOnError(RegistryKeyProperty rkp);
	
	public RegistryKeyProperty getOutSequenceOnError();
	
	// End of user code
	// Start of user code for wsdlKey specific getters and setters declaration
	public void setWsdlKey(RegistryKeyProperty rkp);
	
	public RegistryKeyProperty getWsdlKey();
	
	// End of user code
	// Start of user code for wsdlEndpoint specific getters and setters declaration
	public void setWsdlEndpoint(RegistryKeyProperty rkp);
	
	public RegistryKeyProperty getWsdlEndpoint();
	
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
