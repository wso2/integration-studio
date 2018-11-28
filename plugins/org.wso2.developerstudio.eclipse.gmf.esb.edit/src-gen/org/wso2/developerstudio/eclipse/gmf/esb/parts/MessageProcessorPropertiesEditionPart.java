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


// End of user code

/**
 * 
 * 
 */
public interface MessageProcessorPropertiesEditionPart {

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
	 * @return the processorName
	 * 
	 */
	public String getProcessorName();

	/**
	 * Defines a new processorName
	 * @param newValue the new processorName to set
	 * 
	 */
	public void setProcessorName(String newValue);


	/**
	 * @return the processorType
	 * 
	 */
	public Enumerator getProcessorType();

	/**
	 * Init the processorType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initProcessorType(Object input, Enumerator current);

	/**
	 * Defines a new processorType
	 * @param newValue the new processorType to set
	 * 
	 */
	public void setProcessorType(Enumerator newValue);


	/**
	 * @return the messageProcessorProvider
	 * 
	 */
	public String getMessageProcessorProvider();

	/**
	 * Defines a new messageProcessorProvider
	 * @param newValue the new messageProcessorProvider to set
	 * 
	 */
	public void setMessageProcessorProvider(String newValue);


	/**
	 * @return the messageStore
	 * 
	 */
	public String getMessageStore();

	/**
	 * Defines a new messageStore
	 * @param newValue the new messageStore to set
	 * 
	 */
	public void setMessageStore(String newValue);


	/**
	 * @return the sourceMessageStore
	 * 
	 */
	public String getSourceMessageStore();

	/**
	 * Defines a new sourceMessageStore
	 * @param newValue the new sourceMessageStore to set
	 * 
	 */
	public void setSourceMessageStore(String newValue);


	/**
	 * @return the targetMessageStore
	 * 
	 */
	public String getTargetMessageStore();

	/**
	 * Defines a new targetMessageStore
	 * @param newValue the new targetMessageStore to set
	 * 
	 */
	public void setTargetMessageStore(String newValue);


	/**
	 * @return the processorState
	 * 
	 */
	public Enumerator getProcessorState();

	/**
	 * Init the processorState
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initProcessorState(Object input, Enumerator current);

	/**
	 * Defines a new processorState
	 * @param newValue the new processorState to set
	 * 
	 */
	public void setProcessorState(Enumerator newValue);


	/**
	 * @return the retryInterval
	 * 
	 */
	public String getRetryInterval();

	/**
	 * Defines a new retryInterval
	 * @param newValue the new retryInterval to set
	 * 
	 */
	public void setRetryInterval(String newValue);


	/**
	 * @return the forwardingInterval
	 * 
	 */
	public String getForwardingInterval();

	/**
	 * Defines a new forwardingInterval
	 * @param newValue the new forwardingInterval to set
	 * 
	 */
	public void setForwardingInterval(String newValue);


	/**
	 * @return the samplingInterval
	 * 
	 */
	public String getSamplingInterval();

	/**
	 * Defines a new samplingInterval
	 * @param newValue the new samplingInterval to set
	 * 
	 */
	public void setSamplingInterval(String newValue);


	/**
	 * @return the samplingConcurrency
	 * 
	 */
	public String getSamplingConcurrency();

	/**
	 * Defines a new samplingConcurrency
	 * @param newValue the new samplingConcurrency to set
	 * 
	 */
	public void setSamplingConcurrency(String newValue);


	/**
	 * @return the maxDeliveryAttempts
	 * 
	 */
	public String getMaxDeliveryAttempts();

	/**
	 * Defines a new maxDeliveryAttempts
	 * @param newValue the new maxDeliveryAttempts to set
	 * 
	 */
	public void setMaxDeliveryAttempts(String newValue);


	/**
	 * @return the dropMessageAfterMaximumDeliveryAttempts
	 * 
	 */
	public Enumerator getDropMessageAfterMaximumDeliveryAttempts();

	/**
	 * Init the dropMessageAfterMaximumDeliveryAttempts
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initDropMessageAfterMaximumDeliveryAttempts(Object input, Enumerator current);

	/**
	 * Defines a new dropMessageAfterMaximumDeliveryAttempts
	 * @param newValue the new dropMessageAfterMaximumDeliveryAttempts to set
	 * 
	 */
	public void setDropMessageAfterMaximumDeliveryAttempts(Enumerator newValue);


	/**
	 * @return the axis2ClientRepository
	 * 
	 */
	public String getAxis2ClientRepository();

	/**
	 * Defines a new axis2ClientRepository
	 * @param newValue the new axis2ClientRepository to set
	 * 
	 */
	public void setAxis2ClientRepository(String newValue);


	/**
	 * @return the axis2Configuration
	 * 
	 */
	public String getAxis2Configuration();

	/**
	 * Defines a new axis2Configuration
	 * @param newValue the new axis2Configuration to set
	 * 
	 */
	public void setAxis2Configuration(String newValue);


	/**
	 * @return the quartzConfigFilePath
	 * 
	 */
	public String getQuartzConfigFilePath();

	/**
	 * Defines a new quartzConfigFilePath
	 * @param newValue the new quartzConfigFilePath to set
	 * 
	 */
	public void setQuartzConfigFilePath(String newValue);


	/**
	 * @return the cronExpression
	 * 
	 */
	public String getCronExpression();

	/**
	 * Defines a new cronExpression
	 * @param newValue the new cronExpression to set
	 * 
	 */
	public void setCronExpression(String newValue);


	/**
	 * @return the nonRetryHttpStatusCodes
	 * 
	 */
	public String getNonRetryHttpStatusCodes();

	/**
	 * Defines a new nonRetryHttpStatusCodes
	 * @param newValue the new nonRetryHttpStatusCodes to set
	 * 
	 */
	public void setNonRetryHttpStatusCodes(String newValue);




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
	 * @return the taskCount
	 * 
	 */
	public String getTaskCount();

	/**
	 * Defines a new taskCount
	 * @param newValue the new taskCount to set
	 * 
	 */
	public void setTaskCount(String newValue);


	/**
	 * @return the maxStoreConnectionAttempts
	 * 
	 */
	public String getMaxStoreConnectionAttempts();

	/**
	 * Defines a new maxStoreConnectionAttempts
	 * @param newValue the new maxStoreConnectionAttempts to set
	 * 
	 */
	public void setMaxStoreConnectionAttempts(String newValue);


	/**
	 * @return the storeConnectionInterval
	 * 
	 */
	public String getStoreConnectionInterval();

	/**
	 * Defines a new storeConnectionInterval
	 * @param newValue the new storeConnectionInterval to set
	 * 
	 */
	public void setStoreConnectionInterval(String newValue);


	/**
	 * @return the failMessagesStore
	 * 
	 */
	public String getFailMessagesStore();

	/**
	 * Defines a new failMessagesStore
	 * @param newValue the new failMessagesStore to set
	 * 
	 */
	public void setFailMessagesStore(String newValue);





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
