/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface WSDLEndPointPropertiesEditionPart {

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
	 * @return the endPointName
	 * 
	 */
	public String getEndPointName();

	/**
	 * Defines a new endPointName
	 * @param newValue the new endPointName to set
	 * 
	 */
	public void setEndPointName(String newValue);


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
	 * @return the duplicate
	 * 
	 */
	public Boolean getDuplicate();

	/**
	 * Defines a new duplicate
	 * @param newValue the new duplicate to set
	 * 
	 */
	public void setDuplicate(Boolean newValue);


	/**
	 * @return the reversed
	 * 
	 */
	public Boolean getReversed();

	/**
	 * Defines a new reversed
	 * @param newValue the new reversed to set
	 * 
	 */
	public void setReversed(Boolean newValue);




	/**
	 * Init the templateParameters
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTemplateParameters(ReferencesTableSettings settings);

	/**
	 * Update the templateParameters
	 * @param newValue the templateParameters to update
	 * 
	 */
	public void updateTemplateParameters();

	/**
	 * Adds the given filter to the templateParameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTemplateParameters(ViewerFilter filter);

	/**
	 * Adds the given filter to the templateParameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTemplateParameters(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the templateParameters table
	 * 
	 */
	public boolean isContainedInTemplateParametersTable(EObject element);


	/**
	 * @return the InLine
	 * 
	 */
	public Boolean getInLine();

	/**
	 * Defines a new InLine
	 * @param newValue the new InLine to set
	 * 
	 */
	public void setInLine(Boolean newValue);


	/**
	 * @return the format
	 * 
	 */
	public Enumerator getFormat();

	/**
	 * Init the format
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initFormat(Object input, Enumerator current);

	/**
	 * Defines a new format
	 * @param newValue the new format to set
	 * 
	 */
	public void setFormat(Enumerator newValue);


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
	 * @return the suspendErrorCodes
	 * 
	 */
	public String getSuspendErrorCodes();

	/**
	 * Defines a new suspendErrorCodes
	 * @param newValue the new suspendErrorCodes to set
	 * 
	 */
	public void setSuspendErrorCodes(String newValue);


	/**
	 * @return the suspendInitialDuration
	 * 
	 */
	public String getSuspendInitialDuration();

	/**
	 * Defines a new suspendInitialDuration
	 * @param newValue the new suspendInitialDuration to set
	 * 
	 */
	public void setSuspendInitialDuration(String newValue);


	/**
	 * @return the suspendMaximumDuration
	 * 
	 */
	public String getSuspendMaximumDuration();

	/**
	 * Defines a new suspendMaximumDuration
	 * @param newValue the new suspendMaximumDuration to set
	 * 
	 */
	public void setSuspendMaximumDuration(String newValue);


	/**
	 * @return the suspendProgressionFactor
	 * 
	 */
	public String getSuspendProgressionFactor();

	/**
	 * Defines a new suspendProgressionFactor
	 * @param newValue the new suspendProgressionFactor to set
	 * 
	 */
	public void setSuspendProgressionFactor(String newValue);


	/**
	 * @return the retryErrorCodes
	 * 
	 */
	public String getRetryErrorCodes();

	/**
	 * Defines a new retryErrorCodes
	 * @param newValue the new retryErrorCodes to set
	 * 
	 */
	public void setRetryErrorCodes(String newValue);


	/**
	 * @return the retryCount
	 * 
	 */
	public String getRetryCount();

	/**
	 * Defines a new retryCount
	 * @param newValue the new retryCount to set
	 * 
	 */
	public void setRetryCount(String newValue);


	/**
	 * @return the retryDelay
	 * 
	 */
	public String getRetryDelay();

	/**
	 * Defines a new retryDelay
	 * @param newValue the new retryDelay to set
	 * 
	 */
	public void setRetryDelay(String newValue);




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
	 * @return the optimize
	 * 
	 */
	public Enumerator getOptimize();

	/**
	 * Init the optimize
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initOptimize(Object input, Enumerator current);

	/**
	 * Defines a new optimize
	 * @param newValue the new optimize to set
	 * 
	 */
	public void setOptimize(Enumerator newValue);


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
	 * @return the wsdlUri
	 * 
	 */
	public String getWsdlUri();

	/**
	 * Defines a new wsdlUri
	 * @param newValue the new wsdlUri to set
	 * 
	 */
	public void setWsdlUri(String newValue);


	/**
	 * @return the service
	 * 
	 */
	public String getService();

	/**
	 * Defines a new service
	 * @param newValue the new service to set
	 * 
	 */
	public void setService(String newValue);


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
	 * @return the addressingEnabled
	 * 
	 */
	public Boolean getAddressingEnabled();

	/**
	 * Defines a new addressingEnabled
	 * @param newValue the new addressingEnabled to set
	 * 
	 */
	public void setAddressingEnabled(Boolean newValue);


	/**
	 * @return the addressingVersion
	 * 
	 */
	public Enumerator getAddressingVersion();

	/**
	 * Init the addressingVersion
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initAddressingVersion(Object input, Enumerator current);

	/**
	 * Defines a new addressingVersion
	 * @param newValue the new addressingVersion to set
	 * 
	 */
	public void setAddressingVersion(Enumerator newValue);


	/**
	 * @return the addressingSeparateListener
	 * 
	 */
	public Boolean getAddressingSeparateListener();

	/**
	 * Defines a new addressingSeparateListener
	 * @param newValue the new addressingSeparateListener to set
	 * 
	 */
	public void setAddressingSeparateListener(Boolean newValue);


	/**
	 * @return the timeOutDuration
	 * 
	 */
	public String getTimeOutDuration();

	/**
	 * Defines a new timeOutDuration
	 * @param newValue the new timeOutDuration to set
	 * 
	 */
	public void setTimeOutDuration(String newValue);


	/**
	 * @return the timeOutAction
	 * 
	 */
	public Enumerator getTimeOutAction();

	/**
	 * Init the timeOutAction
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTimeOutAction(Object input, Enumerator current);

	/**
	 * Defines a new timeOutAction
	 * @param newValue the new timeOutAction to set
	 * 
	 */
	public void setTimeOutAction(Enumerator newValue);


	/**
	 * @return the failoverNonRetryErrorCodes
	 * 
	 */
	public String getFailoverNonRetryErrorCodes();

	/**
	 * Defines a new failoverNonRetryErrorCodes
	 * @param newValue the new failoverNonRetryErrorCodes to set
	 * 
	 */
	public void setFailoverNonRetryErrorCodes(String newValue);




	// Start of user code for reliableMessagingPolicy specific getters and setters declaration
	public void setReliableMessagingPolicy(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getReliableMessagingPolicy();
	// End of user code
	// Start of user code for securityPolicy specific getters and setters declaration
	public void setSecurityPolicy(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getSecurityPolicy();
	// End of user code
	// Start of user code for inboundPolicy specific getters and setters declaration
	public void setInboundPolicy(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getInboundPolicy();
	// End of user code
	// Start of user code for outboundPolicy specific getters and setters declaration
	public void setOutboundPolicy(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getOutboundPolicy();
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
