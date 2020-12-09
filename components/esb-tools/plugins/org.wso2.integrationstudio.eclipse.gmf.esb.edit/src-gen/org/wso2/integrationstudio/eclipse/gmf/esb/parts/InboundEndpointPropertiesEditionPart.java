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
public interface InboundEndpointPropertiesEditionPart {

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
	 * @return the type
	 * 
	 */
	public Enumerator getType();

	/**
	 * Init the type
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initType(Object input, Enumerator current);

	/**
	 * Defines a new type
	 * @param newValue the new type to set
	 * 
	 */
	public void setType(Enumerator newValue);


	/**
	 * @return the class
	 * 
	 */
	public String getClass_();

	/**
	 * Defines a new class
	 * @param newValue the new class to set
	 * 
	 */
	public void setClass_(String newValue);


	/**
	 * @return the protocol
	 * 
	 */
	public String getProtocol();

	/**
	 * Defines a new protocol
	 * @param newValue the new protocol to set
	 * 
	 */
	public void setProtocol(String newValue);


	/**
	 * @return the inboundEndpointBehaviour
	 * 
	 */
	public Enumerator getInboundEndpointBehaviour();

	/**
	 * Init the inboundEndpointBehaviour
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initInboundEndpointBehaviour(Object input, Enumerator current);

	/**
	 * Defines a new inboundEndpointBehaviour
	 * @param newValue the new inboundEndpointBehaviour to set
	 * 
	 */
	public void setInboundEndpointBehaviour(Enumerator newValue);


	/**
	 * @return the inboundHttpPort
	 * 
	 */
	public String getInboundHttpPort();

	/**
	 * Defines a new inboundHttpPort
	 * @param newValue the new inboundHttpPort to set
	 * 
	 */
	public void setInboundHttpPort(String newValue);


	/**
	 * @return the inboundWorkerPoolSizeCore
	 * 
	 */
	public String getInboundWorkerPoolSizeCore();

	/**
	 * Defines a new inboundWorkerPoolSizeCore
	 * @param newValue the new inboundWorkerPoolSizeCore to set
	 * 
	 */
	public void setInboundWorkerPoolSizeCore(String newValue);


	/**
	 * @return the inboundWorkerPoolSizeMax
	 * 
	 */
	public String getInboundWorkerPoolSizeMax();

	/**
	 * Defines a new inboundWorkerPoolSizeMax
	 * @param newValue the new inboundWorkerPoolSizeMax to set
	 * 
	 */
	public void setInboundWorkerPoolSizeMax(String newValue);


	/**
	 * @return the inboundWorkerThreadKeepAliveSec
	 * 
	 */
	public String getInboundWorkerThreadKeepAliveSec();

	/**
	 * Defines a new inboundWorkerThreadKeepAliveSec
	 * @param newValue the new inboundWorkerThreadKeepAliveSec to set
	 * 
	 */
	public void setInboundWorkerThreadKeepAliveSec(String newValue);


	/**
	 * @return the inboundWorkerPoolQueueLength
	 * 
	 */
	public String getInboundWorkerPoolQueueLength();

	/**
	 * Defines a new inboundWorkerPoolQueueLength
	 * @param newValue the new inboundWorkerPoolQueueLength to set
	 * 
	 */
	public void setInboundWorkerPoolQueueLength(String newValue);


	/**
	 * @return the inboundThreadGroupId
	 * 
	 */
	public String getInboundThreadGroupId();

	/**
	 * Defines a new inboundThreadGroupId
	 * @param newValue the new inboundThreadGroupId to set
	 * 
	 */
	public void setInboundThreadGroupId(String newValue);


	/**
	 * @return the inboundThreadId
	 * 
	 */
	public String getInboundThreadId();

	/**
	 * Defines a new inboundThreadId
	 * @param newValue the new inboundThreadId to set
	 * 
	 */
	public void setInboundThreadId(String newValue);


	/**
	 * @return the dispatchFilterPattern
	 * 
	 */
	public String getDispatchFilterPattern();

	/**
	 * Defines a new dispatchFilterPattern
	 * @param newValue the new dispatchFilterPattern to set
	 * 
	 */
	public void setDispatchFilterPattern(String newValue);


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
	 * @return the sequential
	 * 
	 */
	public Boolean getSequential();

	/**
	 * Defines a new sequential
	 * @param newValue the new sequential to set
	 * 
	 */
	public void setSequential(Boolean newValue);


	/**
	 * @return the coordination
	 * 
	 */
	public Boolean getCoordination();

	/**
	 * Defines a new coordination
	 * @param newValue the new coordination to set
	 * 
	 */
	public void setCoordination(Boolean newValue);


	/**
	 * @return the transportVFSFileURI
	 * 
	 */
	public String getTransportVFSFileURI();

	/**
	 * Defines a new transportVFSFileURI
	 * @param newValue the new transportVFSFileURI to set
	 * 
	 */
	public void setTransportVFSFileURI(String newValue);


	/**
	 * @return the wso2mbConnectionUrl
	 * 
	 */
	public String getWso2mbConnectionUrl();

	/**
	 * Defines a new wso2mbConnectionUrl
	 * @param newValue the new wso2mbConnectionUrl to set
	 * 
	 */
	public void setWso2mbConnectionUrl(String newValue);


	/**
	 * @return the transportVFSContentType
	 * 
	 */
	public String getTransportVFSContentType();

	/**
	 * Defines a new transportVFSContentType
	 * @param newValue the new transportVFSContentType to set
	 * 
	 */
	public void setTransportVFSContentType(String newValue);


	/**
	 * @return the transportVFSFileNamePattern
	 * 
	 */
	public String getTransportVFSFileNamePattern();

	/**
	 * Defines a new transportVFSFileNamePattern
	 * @param newValue the new transportVFSFileNamePattern to set
	 * 
	 */
	public void setTransportVFSFileNamePattern(String newValue);


	/**
	 * @return the transportVFSFileProcessInterval
	 * 
	 */
	public String getTransportVFSFileProcessInterval();

	/**
	 * Defines a new transportVFSFileProcessInterval
	 * @param newValue the new transportVFSFileProcessInterval to set
	 * 
	 */
	public void setTransportVFSFileProcessInterval(String newValue);


	/**
	 * @return the transportVFSFileProcessCount
	 * 
	 */
	public String getTransportVFSFileProcessCount();

	/**
	 * Defines a new transportVFSFileProcessCount
	 * @param newValue the new transportVFSFileProcessCount to set
	 * 
	 */
	public void setTransportVFSFileProcessCount(String newValue);


	/**
	 * @return the transportVFSLocking
	 * 
	 */
	public Enumerator getTransportVFSLocking();

	/**
	 * Init the transportVFSLocking
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportVFSLocking(Object input, Enumerator current);

	/**
	 * Defines a new transportVFSLocking
	 * @param newValue the new transportVFSLocking to set
	 * 
	 */
	public void setTransportVFSLocking(Enumerator newValue);


	/**
	 * @return the transportVFSMaxRetryCount
	 * 
	 */
	public String getTransportVFSMaxRetryCount();

	/**
	 * Defines a new transportVFSMaxRetryCount
	 * @param newValue the new transportVFSMaxRetryCount to set
	 * 
	 */
	public void setTransportVFSMaxRetryCount(String newValue);


	/**
	 * @return the transportVFSMoveAfterFailedMove
	 * 
	 */
	public String getTransportVFSMoveAfterFailedMove();

	/**
	 * Defines a new transportVFSMoveAfterFailedMove
	 * @param newValue the new transportVFSMoveAfterFailedMove to set
	 * 
	 */
	public void setTransportVFSMoveAfterFailedMove(String newValue);


	/**
	 * @return the transportVFSReconnectTimeout
	 * 
	 */
	public String getTransportVFSReconnectTimeout();

	/**
	 * Defines a new transportVFSReconnectTimeout
	 * @param newValue the new transportVFSReconnectTimeout to set
	 * 
	 */
	public void setTransportVFSReconnectTimeout(String newValue);


	/**
	 * @return the transportJMSSharedSubscription
	 * 
	 */
	public Boolean getTransportJMSSharedSubscription();

	/**
	 * Defines a new transportJMSSharedSubscription
	 * @param newValue the new transportJMSSharedSubscription to set
	 * 
	 */
	public void setTransportJMSSharedSubscription(Boolean newValue);


	/**
	 * @return the transportJMSSubscriptionName
	 * 
	 */
	public String getTransportJMSSubscriptionName();

	/**
	 * Defines a new transportJMSSubscriptionName
	 * @param newValue the new transportJMSSubscriptionName to set
	 * 
	 */
	public void setTransportJMSSubscriptionName(String newValue);


	/**
	 * @return the transportJMSPinnedServers
	 * 
	 */
	public String getTransportJMSPinnedServers();

	/**
	 * Defines a new transportJMSPinnedServers
	 * @param newValue the new transportJMSPinnedServers to set
	 * 
	 */
	public void setTransportJMSPinnedServers(String newValue);


	/**
	 * @return the transportVFSActionAfterProcess
	 * 
	 */
	public Enumerator getTransportVFSActionAfterProcess();

	/**
	 * Init the transportVFSActionAfterProcess
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportVFSActionAfterProcess(Object input, Enumerator current);

	/**
	 * Defines a new transportVFSActionAfterProcess
	 * @param newValue the new transportVFSActionAfterProcess to set
	 * 
	 */
	public void setTransportVFSActionAfterProcess(Enumerator newValue);


	/**
	 * @return the transportVFSMoveAfterProcess
	 * 
	 */
	public String getTransportVFSMoveAfterProcess();

	/**
	 * Defines a new transportVFSMoveAfterProcess
	 * @param newValue the new transportVFSMoveAfterProcess to set
	 * 
	 */
	public void setTransportVFSMoveAfterProcess(String newValue);


	/**
	 * @return the transportVFSActionAfterErrors
	 * 
	 */
	public Enumerator getTransportVFSActionAfterErrors();

	/**
	 * Init the transportVFSActionAfterErrors
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportVFSActionAfterErrors(Object input, Enumerator current);

	/**
	 * Defines a new transportVFSActionAfterErrors
	 * @param newValue the new transportVFSActionAfterErrors to set
	 * 
	 */
	public void setTransportVFSActionAfterErrors(Enumerator newValue);


	/**
	 * @return the transportVFSMoveAfterErrors
	 * 
	 */
	public String getTransportVFSMoveAfterErrors();

	/**
	 * Defines a new transportVFSMoveAfterErrors
	 * @param newValue the new transportVFSMoveAfterErrors to set
	 * 
	 */
	public void setTransportVFSMoveAfterErrors(String newValue);


	/**
	 * @return the transportVFSFailedRecordsFileName
	 * 
	 */
	public String getTransportVFSFailedRecordsFileName();

	/**
	 * Defines a new transportVFSFailedRecordsFileName
	 * @param newValue the new transportVFSFailedRecordsFileName to set
	 * 
	 */
	public void setTransportVFSFailedRecordsFileName(String newValue);


	/**
	 * @return the transportVFSFailedRecordsFileDestination
	 * 
	 */
	public String getTransportVFSFailedRecordsFileDestination();

	/**
	 * Defines a new transportVFSFailedRecordsFileDestination
	 * @param newValue the new transportVFSFailedRecordsFileDestination to set
	 * 
	 */
	public void setTransportVFSFailedRecordsFileDestination(String newValue);


	/**
	 * @return the transportVFSMoveFailedRecordTimestampFormat
	 * 
	 */
	public String getTransportVFSMoveFailedRecordTimestampFormat();

	/**
	 * Defines a new transportVFSMoveFailedRecordTimestampFormat
	 * @param newValue the new transportVFSMoveFailedRecordTimestampFormat to set
	 * 
	 */
	public void setTransportVFSMoveFailedRecordTimestampFormat(String newValue);


	/**
	 * @return the transportVFSFailedRecordNextRetryDuration
	 * 
	 */
	public String getTransportVFSFailedRecordNextRetryDuration();

	/**
	 * Defines a new transportVFSFailedRecordNextRetryDuration
	 * @param newValue the new transportVFSFailedRecordNextRetryDuration to set
	 * 
	 */
	public void setTransportVFSFailedRecordNextRetryDuration(String newValue);


	/**
	 * @return the transportVFSActionAfterFailure
	 * 
	 */
	public Enumerator getTransportVFSActionAfterFailure();

	/**
	 * Init the transportVFSActionAfterFailure
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportVFSActionAfterFailure(Object input, Enumerator current);

	/**
	 * Defines a new transportVFSActionAfterFailure
	 * @param newValue the new transportVFSActionAfterFailure to set
	 * 
	 */
	public void setTransportVFSActionAfterFailure(Enumerator newValue);


	/**
	 * @return the transportVFSMoveAfterFailure
	 * 
	 */
	public String getTransportVFSMoveAfterFailure();

	/**
	 * Defines a new transportVFSMoveAfterFailure
	 * @param newValue the new transportVFSMoveAfterFailure to set
	 * 
	 */
	public void setTransportVFSMoveAfterFailure(String newValue);


	/**
	 * @return the transportVFSReplyFileURI
	 * 
	 */
	public String getTransportVFSReplyFileURI();

	/**
	 * Defines a new transportVFSReplyFileURI
	 * @param newValue the new transportVFSReplyFileURI to set
	 * 
	 */
	public void setTransportVFSReplyFileURI(String newValue);


	/**
	 * @return the transportVFSReplyFileName
	 * 
	 */
	public String getTransportVFSReplyFileName();

	/**
	 * Defines a new transportVFSReplyFileName
	 * @param newValue the new transportVFSReplyFileName to set
	 * 
	 */
	public void setTransportVFSReplyFileName(String newValue);


	/**
	 * @return the transportVFSAutoLockRelease
	 * 
	 */
	public Boolean getTransportVFSAutoLockRelease();

	/**
	 * Defines a new transportVFSAutoLockRelease
	 * @param newValue the new transportVFSAutoLockRelease to set
	 * 
	 */
	public void setTransportVFSAutoLockRelease(Boolean newValue);


	/**
	 * @return the transportVFSAutoLockReleaseInterval
	 * 
	 */
	public String getTransportVFSAutoLockReleaseInterval();

	/**
	 * Defines a new transportVFSAutoLockReleaseInterval
	 * @param newValue the new transportVFSAutoLockReleaseInterval to set
	 * 
	 */
	public void setTransportVFSAutoLockReleaseInterval(String newValue);


	/**
	 * @return the transportVFSLockReleaseSameNode
	 * 
	 */
	public Boolean getTransportVFSLockReleaseSameNode();

	/**
	 * Defines a new transportVFSLockReleaseSameNode
	 * @param newValue the new transportVFSLockReleaseSameNode to set
	 * 
	 */
	public void setTransportVFSLockReleaseSameNode(Boolean newValue);


	/**
	 * @return the transportVFSDistributedLock
	 * 
	 */
	public Boolean getTransportVFSDistributedLock();

	/**
	 * Defines a new transportVFSDistributedLock
	 * @param newValue the new transportVFSDistributedLock to set
	 * 
	 */
	public void setTransportVFSDistributedLock(Boolean newValue);


	/**
	 * @return the transportVFSStreaming
	 * 
	 */
	public Boolean getTransportVFSStreaming();

	/**
	 * Defines a new transportVFSStreaming
	 * @param newValue the new transportVFSStreaming to set
	 * 
	 */
	public void setTransportVFSStreaming(Boolean newValue);


	/**
	 * @return the transportVFSBuild
	 * 
	 */
	public Boolean getTransportVFSBuild();

	/**
	 * Defines a new transportVFSBuild
	 * @param newValue the new transportVFSBuild to set
	 * 
	 */
	public void setTransportVFSBuild(Boolean newValue);


	/**
	 * @return the transportVFSDistributedTimeout
	 * 
	 */
	public String getTransportVFSDistributedTimeout();

	/**
	 * Defines a new transportVFSDistributedTimeout
	 * @param newValue the new transportVFSDistributedTimeout to set
	 * 
	 */
	public void setTransportVFSDistributedTimeout(String newValue);


	/**
	 * @return the transportVFSSFTPIdentities
	 * 
	 */
	public String getTransportVFSSFTPIdentities();

	/**
	 * Defines a new transportVFSSFTPIdentities
	 * @param newValue the new transportVFSSFTPIdentities to set
	 * 
	 */
	public void setTransportVFSSFTPIdentities(String newValue);


	/**
	 * @return the transportVFSSFTPIdentityPassPhrase
	 * 
	 */
	public String getTransportVFSSFTPIdentityPassPhrase();

	/**
	 * Defines a new transportVFSSFTPIdentityPassPhrase
	 * @param newValue the new transportVFSSFTPIdentityPassPhrase to set
	 * 
	 */
	public void setTransportVFSSFTPIdentityPassPhrase(String newValue);


	/**
	 * @return the transportVFSSFTPUserDirIsRoot
	 * 
	 */
	public Boolean getTransportVFSSFTPUserDirIsRoot();

	/**
	 * Defines a new transportVFSSFTPUserDirIsRoot
	 * @param newValue the new transportVFSSFTPUserDirIsRoot to set
	 * 
	 */
	public void setTransportVFSSFTPUserDirIsRoot(Boolean newValue);


	/**
	 * @return the javaNamingFactoryInitial
	 * 
	 */
	public String getJavaNamingFactoryInitial();

	/**
	 * Defines a new javaNamingFactoryInitial
	 * @param newValue the new javaNamingFactoryInitial to set
	 * 
	 */
	public void setJavaNamingFactoryInitial(String newValue);


	/**
	 * @return the javaNamingProviderUrl
	 * 
	 */
	public String getJavaNamingProviderUrl();

	/**
	 * Defines a new javaNamingProviderUrl
	 * @param newValue the new javaNamingProviderUrl to set
	 * 
	 */
	public void setJavaNamingProviderUrl(String newValue);


	/**
	 * @return the transportJMSConnectionFactoryJNDIName
	 * 
	 */
	public String getTransportJMSConnectionFactoryJNDIName();

	/**
	 * Defines a new transportJMSConnectionFactoryJNDIName
	 * @param newValue the new transportJMSConnectionFactoryJNDIName to set
	 * 
	 */
	public void setTransportJMSConnectionFactoryJNDIName(String newValue);


	/**
	 * @return the transportJMSConnectionFactoryType
	 * 
	 */
	public Enumerator getTransportJMSConnectionFactoryType();

	/**
	 * Init the transportJMSConnectionFactoryType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportJMSConnectionFactoryType(Object input, Enumerator current);

	/**
	 * Defines a new transportJMSConnectionFactoryType
	 * @param newValue the new transportJMSConnectionFactoryType to set
	 * 
	 */
	public void setTransportJMSConnectionFactoryType(Enumerator newValue);


	/**
	 * @return the transportJMSConcurrentConsumers
	 * 
	 */
	public String getTransportJMSConcurrentConsumers();

	/**
	 * Defines a new transportJMSConcurrentConsumers
	 * @param newValue the new transportJMSConcurrentConsumers to set
	 * 
	 */
	public void setTransportJMSConcurrentConsumers(String newValue);


	/**
	 * @return the transportJMSDestination
	 * 
	 */
	public String getTransportJMSDestination();

	/**
	 * Defines a new transportJMSDestination
	 * @param newValue the new transportJMSDestination to set
	 * 
	 */
	public void setTransportJMSDestination(String newValue);


	/**
	 * @return the transportJMSSessionTransacted
	 * 
	 */
	public Boolean getTransportJMSSessionTransacted();

	/**
	 * Defines a new transportJMSSessionTransacted
	 * @param newValue the new transportJMSSessionTransacted to set
	 * 
	 */
	public void setTransportJMSSessionTransacted(Boolean newValue);


	/**
	 * @return the transportJMSSessionAcknowledgement
	 * 
	 */
	public Enumerator getTransportJMSSessionAcknowledgement();

	/**
	 * Init the transportJMSSessionAcknowledgement
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportJMSSessionAcknowledgement(Object input, Enumerator current);

	/**
	 * Defines a new transportJMSSessionAcknowledgement
	 * @param newValue the new transportJMSSessionAcknowledgement to set
	 * 
	 */
	public void setTransportJMSSessionAcknowledgement(Enumerator newValue);


	/**
	 * @return the transportJMSCacheLevel
	 * 
	 */
	public Enumerator getTransportJMSCacheLevel();

	/**
	 * Init the transportJMSCacheLevel
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportJMSCacheLevel(Object input, Enumerator current);

	/**
	 * Defines a new transportJMSCacheLevel
	 * @param newValue the new transportJMSCacheLevel to set
	 * 
	 */
	public void setTransportJMSCacheLevel(Enumerator newValue);


	/**
	 * @return the transportJMSUserName
	 * 
	 */
	public String getTransportJMSUserName();

	/**
	 * Defines a new transportJMSUserName
	 * @param newValue the new transportJMSUserName to set
	 * 
	 */
	public void setTransportJMSUserName(String newValue);


	/**
	 * @return the transportJMSPassword
	 * 
	 */
	public String getTransportJMSPassword();

	/**
	 * Defines a new transportJMSPassword
	 * @param newValue the new transportJMSPassword to set
	 * 
	 */
	public void setTransportJMSPassword(String newValue);


	/**
	 * @return the transportJMSJMSSpecVersion
	 * 
	 */
	public String getTransportJMSJMSSpecVersion();

	/**
	 * Defines a new transportJMSJMSSpecVersion
	 * @param newValue the new transportJMSJMSSpecVersion to set
	 * 
	 */
	public void setTransportJMSJMSSpecVersion(String newValue);


	/**
	 * @return the transportJMSSubscriptionDurable
	 * 
	 */
	public String getTransportJMSSubscriptionDurable();

	/**
	 * Defines a new transportJMSSubscriptionDurable
	 * @param newValue the new transportJMSSubscriptionDurable to set
	 * 
	 */
	public void setTransportJMSSubscriptionDurable(String newValue);


	/**
	 * @return the transportJMSDurableSubscriberClientID
	 * 
	 */
	public String getTransportJMSDurableSubscriberClientID();

	/**
	 * Defines a new transportJMSDurableSubscriberClientID
	 * @param newValue the new transportJMSDurableSubscriberClientID to set
	 * 
	 */
	public void setTransportJMSDurableSubscriberClientID(String newValue);


	/**
	 * @return the transportJMSMessageSelector
	 * 
	 */
	public String getTransportJMSMessageSelector();

	/**
	 * Defines a new transportJMSMessageSelector
	 * @param newValue the new transportJMSMessageSelector to set
	 * 
	 */
	public void setTransportJMSMessageSelector(String newValue);


	/**
	 * @return the transportJMSRetryDuration
	 * 
	 */
	public String getTransportJMSRetryDuration();

	/**
	 * Defines a new transportJMSRetryDuration
	 * @param newValue the new transportJMSRetryDuration to set
	 * 
	 */
	public void setTransportJMSRetryDuration(String newValue);


	/**
	 * @return the transportVFSMoveTimestampFormat
	 * 
	 */
	public String getTransportVFSMoveTimestampFormat();

	/**
	 * Defines a new transportVFSMoveTimestampFormat
	 * @param newValue the new transportVFSMoveTimestampFormat to set
	 * 
	 */
	public void setTransportVFSMoveTimestampFormat(String newValue);


	/**
	 * @return the transportVFSFileSortAttribute
	 * 
	 */
	public Enumerator getTransportVFSFileSortAttribute();

	/**
	 * Init the transportVFSFileSortAttribute
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportVFSFileSortAttribute(Object input, Enumerator current);

	/**
	 * Defines a new transportVFSFileSortAttribute
	 * @param newValue the new transportVFSFileSortAttribute to set
	 * 
	 */
	public void setTransportVFSFileSortAttribute(Enumerator newValue);


	/**
	 * @return the transportVFSFileSortAscending
	 * 
	 */
	public Boolean getTransportVFSFileSortAscending();

	/**
	 * Defines a new transportVFSFileSortAscending
	 * @param newValue the new transportVFSFileSortAscending to set
	 * 
	 */
	public void setTransportVFSFileSortAscending(Boolean newValue);


	/**
	 * @return the transportVFSSubFolderTimestampFormat
	 * 
	 */
	public String getTransportVFSSubFolderTimestampFormat();

	/**
	 * Defines a new transportVFSSubFolderTimestampFormat
	 * @param newValue the new transportVFSSubFolderTimestampFormat to set
	 * 
	 */
	public void setTransportVFSSubFolderTimestampFormat(String newValue);


	/**
	 * @return the transportVFSCreateFolder
	 * 
	 */
	public Boolean getTransportVFSCreateFolder();

	/**
	 * Defines a new transportVFSCreateFolder
	 * @param newValue the new transportVFSCreateFolder to set
	 * 
	 */
	public void setTransportVFSCreateFolder(Boolean newValue);


	/**
	 * @return the transportJMSReceiveTimeout
	 * 
	 */
	public String getTransportJMSReceiveTimeout();

	/**
	 * Defines a new transportJMSReceiveTimeout
	 * @param newValue the new transportJMSReceiveTimeout to set
	 * 
	 */
	public void setTransportJMSReceiveTimeout(String newValue);


	/**
	 * @return the transportJMSContentType
	 * 
	 */
	public String getTransportJMSContentType();

	/**
	 * Defines a new transportJMSContentType
	 * @param newValue the new transportJMSContentType to set
	 * 
	 */
	public void setTransportJMSContentType(String newValue);


	/**
	 * @return the transportJMSContentTypeProperty
	 * 
	 */
	public String getTransportJMSContentTypeProperty();

	/**
	 * Defines a new transportJMSContentTypeProperty
	 * @param newValue the new transportJMSContentTypeProperty to set
	 * 
	 */
	public void setTransportJMSContentTypeProperty(String newValue);


	/**
	 * @return the transportJMSReplyDestination
	 * 
	 */
	public String getTransportJMSReplyDestination();

	/**
	 * Defines a new transportJMSReplyDestination
	 * @param newValue the new transportJMSReplyDestination to set
	 * 
	 */
	public void setTransportJMSReplyDestination(String newValue);


	/**
	 * @return the transportJMSPubSubNoLocal
	 * 
	 */
	public String getTransportJMSPubSubNoLocal();

	/**
	 * Defines a new transportJMSPubSubNoLocal
	 * @param newValue the new transportJMSPubSubNoLocal to set
	 * 
	 */
	public void setTransportJMSPubSubNoLocal(String newValue);


	/**
	 * @return the transportJMSDurableSubscriberName
	 * 
	 */
	public String getTransportJMSDurableSubscriberName();

	/**
	 * Defines a new transportJMSDurableSubscriberName
	 * @param newValue the new transportJMSDurableSubscriberName to set
	 * 
	 */
	public void setTransportJMSDurableSubscriberName(String newValue);


	/**
	 * @return the transportJMSBrokerType
	 * 
	 */
	public Enumerator getTransportJMSBrokerType();

	/**
	 * Init the transportJMSBrokerType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportJMSBrokerType(Object input, Enumerator current);

	/**
	 * Defines a new transportJMSBrokerType
	 * @param newValue the new transportJMSBrokerType to set
	 * 
	 */
	public void setTransportJMSBrokerType(Enumerator newValue);


	/**
	 * @return the transportMQTTConnectionFactory
	 * 
	 */
	public String getTransportMQTTConnectionFactory();

	/**
	 * Defines a new transportMQTTConnectionFactory
	 * @param newValue the new transportMQTTConnectionFactory to set
	 * 
	 */
	public void setTransportMQTTConnectionFactory(String newValue);


	/**
	 * @return the transportMQTTServerHostName
	 * 
	 */
	public String getTransportMQTTServerHostName();

	/**
	 * Defines a new transportMQTTServerHostName
	 * @param newValue the new transportMQTTServerHostName to set
	 * 
	 */
	public void setTransportMQTTServerHostName(String newValue);


	/**
	 * @return the transportMQTTServerPort
	 * 
	 */
	public String getTransportMQTTServerPort();

	/**
	 * Defines a new transportMQTTServerPort
	 * @param newValue the new transportMQTTServerPort to set
	 * 
	 */
	public void setTransportMQTTServerPort(String newValue);


	/**
	 * @return the transportMQTTTopicName
	 * 
	 */
	public String getTransportMQTTTopicName();

	/**
	 * Defines a new transportMQTTTopicName
	 * @param newValue the new transportMQTTTopicName to set
	 * 
	 */
	public void setTransportMQTTTopicName(String newValue);


	/**
	 * @return the transportMQTTSubscriptionQOS
	 * 
	 */
	public Enumerator getTransportMQTTSubscriptionQOS();

	/**
	 * Init the transportMQTTSubscriptionQOS
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportMQTTSubscriptionQOS(Object input, Enumerator current);

	/**
	 * Defines a new transportMQTTSubscriptionQOS
	 * @param newValue the new transportMQTTSubscriptionQOS to set
	 * 
	 */
	public void setTransportMQTTSubscriptionQOS(Enumerator newValue);


	/**
	 * @return the transportMQTTSessionClean
	 * 
	 */
	public Boolean getTransportMQTTSessionClean();

	/**
	 * Defines a new transportMQTTSessionClean
	 * @param newValue the new transportMQTTSessionClean to set
	 * 
	 */
	public void setTransportMQTTSessionClean(Boolean newValue);


	/**
	 * @return the transportMQTTSslEnable
	 * 
	 */
	public String getTransportMQTTSslEnable();

	/**
	 * Defines a new transportMQTTSslEnable
	 * @param newValue the new transportMQTTSslEnable to set
	 * 
	 */
	public void setTransportMQTTSslEnable(String newValue);


	/**
	 * @return the transportMQTTTemporaryStoreDirectory
	 * 
	 */
	public String getTransportMQTTTemporaryStoreDirectory();

	/**
	 * Defines a new transportMQTTTemporaryStoreDirectory
	 * @param newValue the new transportMQTTTemporaryStoreDirectory to set
	 * 
	 */
	public void setTransportMQTTTemporaryStoreDirectory(String newValue);


	/**
	 * @return the transportMQTTSubscriptionUsername
	 * 
	 */
	public String getTransportMQTTSubscriptionUsername();

	/**
	 * Defines a new transportMQTTSubscriptionUsername
	 * @param newValue the new transportMQTTSubscriptionUsername to set
	 * 
	 */
	public void setTransportMQTTSubscriptionUsername(String newValue);


	/**
	 * @return the transportMQTTSubscriptionPassword
	 * 
	 */
	public String getTransportMQTTSubscriptionPassword();

	/**
	 * Defines a new transportMQTTSubscriptionPassword
	 * @param newValue the new transportMQTTSubscriptionPassword to set
	 * 
	 */
	public void setTransportMQTTSubscriptionPassword(String newValue);


	/**
	 * @return the transportMQTTClientId
	 * 
	 */
	public String getTransportMQTTClientId();

	/**
	 * Defines a new transportMQTTClientId
	 * @param newValue the new transportMQTTClientId to set
	 * 
	 */
	public void setTransportMQTTClientId(String newValue);


	/**
	 * @return the truststore
	 * 
	 */
	public String getTruststore();

	/**
	 * Defines a new truststore
	 * @param newValue the new truststore to set
	 * 
	 */
	public void setTruststore(String newValue);


	/**
	 * @return the keystore
	 * 
	 */
	public String getKeystore();

	/**
	 * Defines a new keystore
	 * @param newValue the new keystore to set
	 * 
	 */
	public void setKeystore(String newValue);


	/**
	 * @return the sslVerifyClient
	 * 
	 */
	public String getSslVerifyClient();

	/**
	 * Defines a new sslVerifyClient
	 * @param newValue the new sslVerifyClient to set
	 * 
	 */
	public void setSslVerifyClient(String newValue);


	/**
	 * @return the sslProtocol
	 * 
	 */
	public String getSslProtocol();

	/**
	 * Defines a new sslProtocol
	 * @param newValue the new sslProtocol to set
	 * 
	 */
	public void setSslProtocol(String newValue);


	/**
	 * @return the httpsProtocols
	 * 
	 */
	public String getHttpsProtocols();

	/**
	 * Defines a new httpsProtocols
	 * @param newValue the new httpsProtocols to set
	 * 
	 */
	public void setHttpsProtocols(String newValue);


	/**
	 * @return the certificateRevocationVerifier
	 * 
	 */
	public String getCertificateRevocationVerifier();

	/**
	 * Defines a new certificateRevocationVerifier
	 * @param newValue the new certificateRevocationVerifier to set
	 * 
	 */
	public void setCertificateRevocationVerifier(String newValue);


	/**
	 * @return the inboundHL7Port
	 * 
	 */
	public String getInboundHL7Port();

	/**
	 * Defines a new inboundHL7Port
	 * @param newValue the new inboundHL7Port to set
	 * 
	 */
	public void setInboundHL7Port(String newValue);


	/**
	 * @return the inboundHL7AutoAck
	 * 
	 */
	public Boolean getInboundHL7AutoAck();

	/**
	 * Defines a new inboundHL7AutoAck
	 * @param newValue the new inboundHL7AutoAck to set
	 * 
	 */
	public void setInboundHL7AutoAck(Boolean newValue);


	/**
	 * @return the inboundHL7MessagePreProcessor
	 * 
	 */
	public String getInboundHL7MessagePreProcessor();

	/**
	 * Defines a new inboundHL7MessagePreProcessor
	 * @param newValue the new inboundHL7MessagePreProcessor to set
	 * 
	 */
	public void setInboundHL7MessagePreProcessor(String newValue);


	/**
	 * @return the inboundHL7CharSet
	 * 
	 */
	public String getInboundHL7CharSet();

	/**
	 * Defines a new inboundHL7CharSet
	 * @param newValue the new inboundHL7CharSet to set
	 * 
	 */
	public void setInboundHL7CharSet(String newValue);


	/**
	 * @return the inboundHL7TimeOut
	 * 
	 */
	public String getInboundHL7TimeOut();

	/**
	 * Defines a new inboundHL7TimeOut
	 * @param newValue the new inboundHL7TimeOut to set
	 * 
	 */
	public void setInboundHL7TimeOut(String newValue);


	/**
	 * @return the inboundHL7ValidateMessage
	 * 
	 */
	public Boolean getInboundHL7ValidateMessage();

	/**
	 * Defines a new inboundHL7ValidateMessage
	 * @param newValue the new inboundHL7ValidateMessage to set
	 * 
	 */
	public void setInboundHL7ValidateMessage(Boolean newValue);


	/**
	 * @return the inboundHL7BuildInvalidMessages
	 * 
	 */
	public Boolean getInboundHL7BuildInvalidMessages();

	/**
	 * Defines a new inboundHL7BuildInvalidMessages
	 * @param newValue the new inboundHL7BuildInvalidMessages to set
	 * 
	 */
	public void setInboundHL7BuildInvalidMessages(Boolean newValue);


	/**
	 * @return the inboundHL7PassThroughInvalidMessages
	 * 
	 */
	public Boolean getInboundHL7PassThroughInvalidMessages();

	/**
	 * Defines a new inboundHL7PassThroughInvalidMessages
	 * @param newValue the new inboundHL7PassThroughInvalidMessages to set
	 * 
	 */
	public void setInboundHL7PassThroughInvalidMessages(Boolean newValue);


	/**
	 * @return the zookeeperConnect
	 * 
	 */
	public String getZookeeperConnect();

	/**
	 * Defines a new zookeeperConnect
	 * @param newValue the new zookeeperConnect to set
	 * 
	 */
	public void setZookeeperConnect(String newValue);


	/**
	 * @return the groupId
	 * 
	 */
	public String getGroupId();

	/**
	 * Defines a new groupId
	 * @param newValue the new groupId to set
	 * 
	 */
	public void setGroupId(String newValue);


	/**
	 * @return the contentType
	 * 
	 */
	public String getContentType();

	/**
	 * Defines a new contentType
	 * @param newValue the new contentType to set
	 * 
	 */
	public void setContentType(String newValue);


	/**
	 * @return the consumerType
	 * 
	 */
	public Enumerator getConsumerType();

	/**
	 * Init the consumerType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initConsumerType(Object input, Enumerator current);

	/**
	 * Defines a new consumerType
	 * @param newValue the new consumerType to set
	 * 
	 */
	public void setConsumerType(Enumerator newValue);


	/**
	 * @return the topicsOrTopicFilter
	 * 
	 */
	public Enumerator getTopicsOrTopicFilter();

	/**
	 * Init the topicsOrTopicFilter
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTopicsOrTopicFilter(Object input, Enumerator current);

	/**
	 * Defines a new topicsOrTopicFilter
	 * @param newValue the new topicsOrTopicFilter to set
	 * 
	 */
	public void setTopicsOrTopicFilter(Enumerator newValue);


	/**
	 * @return the topicsName
	 * 
	 */
	public String getTopicsName();

	/**
	 * Defines a new topicsName
	 * @param newValue the new topicsName to set
	 * 
	 */
	public void setTopicsName(String newValue);


	/**
	 * @return the topicFilterFrom
	 * 
	 */
	public Enumerator getTopicFilterFrom();

	/**
	 * Init the topicFilterFrom
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTopicFilterFrom(Object input, Enumerator current);

	/**
	 * Defines a new topicFilterFrom
	 * @param newValue the new topicFilterFrom to set
	 * 
	 */
	public void setTopicFilterFrom(Enumerator newValue);


	/**
	 * @return the topicFilterName
	 * 
	 */
	public String getTopicFilterName();

	/**
	 * Defines a new topicFilterName
	 * @param newValue the new topicFilterName to set
	 * 
	 */
	public void setTopicFilterName(String newValue);


	/**
	 * @return the simpleConsumerTopic
	 * 
	 */
	public String getSimpleConsumerTopic();

	/**
	 * Defines a new simpleConsumerTopic
	 * @param newValue the new simpleConsumerTopic to set
	 * 
	 */
	public void setSimpleConsumerTopic(String newValue);


	/**
	 * @return the simpleConsumerBrokers
	 * 
	 */
	public String getSimpleConsumerBrokers();

	/**
	 * Defines a new simpleConsumerBrokers
	 * @param newValue the new simpleConsumerBrokers to set
	 * 
	 */
	public void setSimpleConsumerBrokers(String newValue);


	/**
	 * @return the simpleConsumerPort
	 * 
	 */
	public String getSimpleConsumerPort();

	/**
	 * Defines a new simpleConsumerPort
	 * @param newValue the new simpleConsumerPort to set
	 * 
	 */
	public void setSimpleConsumerPort(String newValue);


	/**
	 * @return the simpleConsumerPartition
	 * 
	 */
	public String getSimpleConsumerPartition();

	/**
	 * Defines a new simpleConsumerPartition
	 * @param newValue the new simpleConsumerPartition to set
	 * 
	 */
	public void setSimpleConsumerPartition(String newValue);


	/**
	 * @return the simpleConsumerMaxMessagesToRead
	 * 
	 */
	public String getSimpleConsumerMaxMessagesToRead();

	/**
	 * Defines a new simpleConsumerMaxMessagesToRead
	 * @param newValue the new simpleConsumerMaxMessagesToRead to set
	 * 
	 */
	public void setSimpleConsumerMaxMessagesToRead(String newValue);


	/**
	 * @return the threadCount
	 * 
	 */
	public String getThreadCount();

	/**
	 * Defines a new threadCount
	 * @param newValue the new threadCount to set
	 * 
	 */
	public void setThreadCount(String newValue);


	/**
	 * @return the consumerId
	 * 
	 */
	public String getConsumerId();

	/**
	 * Defines a new consumerId
	 * @param newValue the new consumerId to set
	 * 
	 */
	public void setConsumerId(String newValue);


	/**
	 * @return the socketTimeoutMs
	 * 
	 */
	public String getSocketTimeoutMs();

	/**
	 * Defines a new socketTimeoutMs
	 * @param newValue the new socketTimeoutMs to set
	 * 
	 */
	public void setSocketTimeoutMs(String newValue);


	/**
	 * @return the socketReceiveBufferBytes
	 * 
	 */
	public String getSocketReceiveBufferBytes();

	/**
	 * Defines a new socketReceiveBufferBytes
	 * @param newValue the new socketReceiveBufferBytes to set
	 * 
	 */
	public void setSocketReceiveBufferBytes(String newValue);


	/**
	 * @return the fetchMessageMaxBytes
	 * 
	 */
	public String getFetchMessageMaxBytes();

	/**
	 * Defines a new fetchMessageMaxBytes
	 * @param newValue the new fetchMessageMaxBytes to set
	 * 
	 */
	public void setFetchMessageMaxBytes(String newValue);


	/**
	 * @return the numConsumerFetches
	 * 
	 */
	public String getNumConsumerFetches();

	/**
	 * Defines a new numConsumerFetches
	 * @param newValue the new numConsumerFetches to set
	 * 
	 */
	public void setNumConsumerFetches(String newValue);


	/**
	 * @return the autoCommitEnable
	 * 
	 */
	public Boolean getAutoCommitEnable();

	/**
	 * Defines a new autoCommitEnable
	 * @param newValue the new autoCommitEnable to set
	 * 
	 */
	public void setAutoCommitEnable(Boolean newValue);


	/**
	 * @return the autoCommitIntervalMs
	 * 
	 */
	public String getAutoCommitIntervalMs();

	/**
	 * Defines a new autoCommitIntervalMs
	 * @param newValue the new autoCommitIntervalMs to set
	 * 
	 */
	public void setAutoCommitIntervalMs(String newValue);


	/**
	 * @return the queuedMaxMessageChunks
	 * 
	 */
	public String getQueuedMaxMessageChunks();

	/**
	 * Defines a new queuedMaxMessageChunks
	 * @param newValue the new queuedMaxMessageChunks to set
	 * 
	 */
	public void setQueuedMaxMessageChunks(String newValue);


	/**
	 * @return the rebalanceMaxRetries
	 * 
	 */
	public String getRebalanceMaxRetries();

	/**
	 * Defines a new rebalanceMaxRetries
	 * @param newValue the new rebalanceMaxRetries to set
	 * 
	 */
	public void setRebalanceMaxRetries(String newValue);


	/**
	 * @return the fetchMinBytes
	 * 
	 */
	public String getFetchMinBytes();

	/**
	 * Defines a new fetchMinBytes
	 * @param newValue the new fetchMinBytes to set
	 * 
	 */
	public void setFetchMinBytes(String newValue);


	/**
	 * @return the fetchWaitMaxMs
	 * 
	 */
	public String getFetchWaitMaxMs();

	/**
	 * Defines a new fetchWaitMaxMs
	 * @param newValue the new fetchWaitMaxMs to set
	 * 
	 */
	public void setFetchWaitMaxMs(String newValue);


	/**
	 * @return the rebalanceBackoffMs
	 * 
	 */
	public String getRebalanceBackoffMs();

	/**
	 * Defines a new rebalanceBackoffMs
	 * @param newValue the new rebalanceBackoffMs to set
	 * 
	 */
	public void setRebalanceBackoffMs(String newValue);


	/**
	 * @return the refreshLeaderBackoffMs
	 * 
	 */
	public String getRefreshLeaderBackoffMs();

	/**
	 * Defines a new refreshLeaderBackoffMs
	 * @param newValue the new refreshLeaderBackoffMs to set
	 * 
	 */
	public void setRefreshLeaderBackoffMs(String newValue);


	/**
	 * @return the autoOffsetReset
	 * 
	 */
	public Enumerator getAutoOffsetReset();

	/**
	 * Init the autoOffsetReset
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initAutoOffsetReset(Object input, Enumerator current);

	/**
	 * Defines a new autoOffsetReset
	 * @param newValue the new autoOffsetReset to set
	 * 
	 */
	public void setAutoOffsetReset(Enumerator newValue);


	/**
	 * @return the consumerTimeoutMs
	 * 
	 */
	public String getConsumerTimeoutMs();

	/**
	 * Defines a new consumerTimeoutMs
	 * @param newValue the new consumerTimeoutMs to set
	 * 
	 */
	public void setConsumerTimeoutMs(String newValue);


	/**
	 * @return the excludeInternalTopics
	 * 
	 */
	public Boolean getExcludeInternalTopics();

	/**
	 * Defines a new excludeInternalTopics
	 * @param newValue the new excludeInternalTopics to set
	 * 
	 */
	public void setExcludeInternalTopics(Boolean newValue);


	/**
	 * @return the partitionAssignmentStrategy
	 * 
	 */
	public Enumerator getPartitionAssignmentStrategy();

	/**
	 * Init the partitionAssignmentStrategy
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPartitionAssignmentStrategy(Object input, Enumerator current);

	/**
	 * Defines a new partitionAssignmentStrategy
	 * @param newValue the new partitionAssignmentStrategy to set
	 * 
	 */
	public void setPartitionAssignmentStrategy(Enumerator newValue);


	/**
	 * @return the clientId
	 * 
	 */
	public String getClientId();

	/**
	 * Defines a new clientId
	 * @param newValue the new clientId to set
	 * 
	 */
	public void setClientId(String newValue);


	/**
	 * @return the zookeeperSessionTimeoutMs
	 * 
	 */
	public String getZookeeperSessionTimeoutMs();

	/**
	 * Defines a new zookeeperSessionTimeoutMs
	 * @param newValue the new zookeeperSessionTimeoutMs to set
	 * 
	 */
	public void setZookeeperSessionTimeoutMs(String newValue);


	/**
	 * @return the zookeeperConnectionTimeoutMs
	 * 
	 */
	public String getZookeeperConnectionTimeoutMs();

	/**
	 * Defines a new zookeeperConnectionTimeoutMs
	 * @param newValue the new zookeeperConnectionTimeoutMs to set
	 * 
	 */
	public void setZookeeperConnectionTimeoutMs(String newValue);


	/**
	 * @return the zookeeperSyncTimeMs
	 * 
	 */
	public String getZookeeperSyncTimeMs();

	/**
	 * Defines a new zookeeperSyncTimeMs
	 * @param newValue the new zookeeperSyncTimeMs to set
	 * 
	 */
	public void setZookeeperSyncTimeMs(String newValue);


	/**
	 * @return the offsetsStorage
	 * 
	 */
	public Enumerator getOffsetsStorage();

	/**
	 * Init the offsetsStorage
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initOffsetsStorage(Object input, Enumerator current);

	/**
	 * Defines a new offsetsStorage
	 * @param newValue the new offsetsStorage to set
	 * 
	 */
	public void setOffsetsStorage(Enumerator newValue);


	/**
	 * @return the offsetsChannelBackoffMs
	 * 
	 */
	public String getOffsetsChannelBackoffMs();

	/**
	 * Defines a new offsetsChannelBackoffMs
	 * @param newValue the new offsetsChannelBackoffMs to set
	 * 
	 */
	public void setOffsetsChannelBackoffMs(String newValue);


	/**
	 * @return the offsetsChannelSocketTimeoutMs
	 * 
	 */
	public String getOffsetsChannelSocketTimeoutMs();

	/**
	 * Defines a new offsetsChannelSocketTimeoutMs
	 * @param newValue the new offsetsChannelSocketTimeoutMs to set
	 * 
	 */
	public void setOffsetsChannelSocketTimeoutMs(String newValue);


	/**
	 * @return the offsetsCommitMaxRetries
	 * 
	 */
	public String getOffsetsCommitMaxRetries();

	/**
	 * Defines a new offsetsCommitMaxRetries
	 * @param newValue the new offsetsCommitMaxRetries to set
	 * 
	 */
	public void setOffsetsCommitMaxRetries(String newValue);


	/**
	 * @return the dualCommitEnabled
	 * 
	 */
	public Boolean getDualCommitEnabled();

	/**
	 * Defines a new dualCommitEnabled
	 * @param newValue the new dualCommitEnabled to set
	 * 
	 */
	public void setDualCommitEnabled(Boolean newValue);


	/**
	 * @return the inboundCxfRmHost
	 * 
	 */
	public String getInboundCxfRmHost();

	/**
	 * Defines a new inboundCxfRmHost
	 * @param newValue the new inboundCxfRmHost to set
	 * 
	 */
	public void setInboundCxfRmHost(String newValue);


	/**
	 * @return the inboundCxfRmPort
	 * 
	 */
	public String getInboundCxfRmPort();

	/**
	 * Defines a new inboundCxfRmPort
	 * @param newValue the new inboundCxfRmPort to set
	 * 
	 */
	public void setInboundCxfRmPort(String newValue);


	/**
	 * @return the inboundCxfRmConfigFile
	 * 
	 */
	public String getInboundCxfRmConfigFile();

	/**
	 * Defines a new inboundCxfRmConfigFile
	 * @param newValue the new inboundCxfRmConfigFile to set
	 * 
	 */
	public void setInboundCxfRmConfigFile(String newValue);


	/**
	 * @return the enableSSL
	 * 
	 */
	public Boolean getEnableSSL();

	/**
	 * Defines a new enableSSL
	 * @param newValue the new enableSSL to set
	 * 
	 */
	public void setEnableSSL(Boolean newValue);




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
	 * @return the suspend
	 * 
	 */
	public Boolean getSuspend();

	/**
	 * Defines a new suspend
	 * @param newValue the new suspend to set
	 * 
	 */
	public void setSuspend(Boolean newValue);


	/**
	 * @return the transportRabbitMqConnectionFactory
	 * 
	 */
	public String getTransportRabbitMqConnectionFactory();

	/**
	 * Defines a new transportRabbitMqConnectionFactory
	 * @param newValue the new transportRabbitMqConnectionFactory to set
	 * 
	 */
	public void setTransportRabbitMqConnectionFactory(String newValue);


	/**
	 * @return the transportRabbitMqServerHostName
	 * 
	 */
	public String getTransportRabbitMqServerHostName();

	/**
	 * Defines a new transportRabbitMqServerHostName
	 * @param newValue the new transportRabbitMqServerHostName to set
	 * 
	 */
	public void setTransportRabbitMqServerHostName(String newValue);


	/**
	 * @return the transportRabbitMqServerPort
	 * 
	 */
	public String getTransportRabbitMqServerPort();

	/**
	 * Defines a new transportRabbitMqServerPort
	 * @param newValue the new transportRabbitMqServerPort to set
	 * 
	 */
	public void setTransportRabbitMqServerPort(String newValue);


	/**
	 * @return the transportRabbitMqServerUserName
	 * 
	 */
	public String getTransportRabbitMqServerUserName();

	/**
	 * Defines a new transportRabbitMqServerUserName
	 * @param newValue the new transportRabbitMqServerUserName to set
	 * 
	 */
	public void setTransportRabbitMqServerUserName(String newValue);


	/**
	 * @return the transportRabbitMqServerPassword
	 * 
	 */
	public String getTransportRabbitMqServerPassword();

	/**
	 * Defines a new transportRabbitMqServerPassword
	 * @param newValue the new transportRabbitMqServerPassword to set
	 * 
	 */
	public void setTransportRabbitMqServerPassword(String newValue);


	/**
	 * @return the transportRabbitMqQueueName
	 * 
	 */
	public String getTransportRabbitMqQueueName();

	/**
	 * Defines a new transportRabbitMqQueueName
	 * @param newValue the new transportRabbitMqQueueName to set
	 * 
	 */
	public void setTransportRabbitMqQueueName(String newValue);


	/**
	 * @return the transportRabbitMqExchangeName
	 * 
	 */
	public String getTransportRabbitMqExchangeName();

	/**
	 * Defines a new transportRabbitMqExchangeName
	 * @param newValue the new transportRabbitMqExchangeName to set
	 * 
	 */
	public void setTransportRabbitMqExchangeName(String newValue);


	/**
	 * @return the transportRabbitMqQueueDurable
	 * 
	 */
	public String getTransportRabbitMqQueueDurable();

	/**
	 * Defines a new transportRabbitMqQueueDurable
	 * @param newValue the new transportRabbitMqQueueDurable to set
	 * 
	 */
	public void setTransportRabbitMqQueueDurable(String newValue);


	/**
	 * @return the transportRabbitMqQueueExclusive
	 * 
	 */
	public String getTransportRabbitMqQueueExclusive();

	/**
	 * Defines a new transportRabbitMqQueueExclusive
	 * @param newValue the new transportRabbitMqQueueExclusive to set
	 * 
	 */
	public void setTransportRabbitMqQueueExclusive(String newValue);


	/**
	 * @return the transportRabbitMqQueueAutoDelete
	 * 
	 */
	public String getTransportRabbitMqQueueAutoDelete();

	/**
	 * Defines a new transportRabbitMqQueueAutoDelete
	 * @param newValue the new transportRabbitMqQueueAutoDelete to set
	 * 
	 */
	public void setTransportRabbitMqQueueAutoDelete(String newValue);


	/**
	 * @return the transportRabbitMqQueueAutoAck
	 * 
	 */
	public String getTransportRabbitMqQueueAutoAck();

	/**
	 * Defines a new transportRabbitMqQueueAutoAck
	 * @param newValue the new transportRabbitMqQueueAutoAck to set
	 * 
	 */
	public void setTransportRabbitMqQueueAutoAck(String newValue);


	/**
	 * @return the transportRabbitMqQueueRoutingKey
	 * 
	 */
	public String getTransportRabbitMqQueueRoutingKey();

	/**
	 * Defines a new transportRabbitMqQueueRoutingKey
	 * @param newValue the new transportRabbitMqQueueRoutingKey to set
	 * 
	 */
	public void setTransportRabbitMqQueueRoutingKey(String newValue);


	/**
	 * @return the transportRabbitMqQueueDeliveryMode
	 * 
	 */
	public String getTransportRabbitMqQueueDeliveryMode();

	/**
	 * Defines a new transportRabbitMqQueueDeliveryMode
	 * @param newValue the new transportRabbitMqQueueDeliveryMode to set
	 * 
	 */
	public void setTransportRabbitMqQueueDeliveryMode(String newValue);


	/**
	 * @return the transportRabbitMqExchangeType
	 * 
	 */
	public String getTransportRabbitMqExchangeType();

	/**
	 * Defines a new transportRabbitMqExchangeType
	 * @param newValue the new transportRabbitMqExchangeType to set
	 * 
	 */
	public void setTransportRabbitMqExchangeType(String newValue);


	/**
	 * @return the transportRabbitMqExchangeDurable
	 * 
	 */
	public String getTransportRabbitMqExchangeDurable();

	/**
	 * Defines a new transportRabbitMqExchangeDurable
	 * @param newValue the new transportRabbitMqExchangeDurable to set
	 * 
	 */
	public void setTransportRabbitMqExchangeDurable(String newValue);


	/**
	 * @return the transportRabbitMqExchangeAutoDelete
	 * 
	 */
	public String getTransportRabbitMqExchangeAutoDelete();

	/**
	 * Defines a new transportRabbitMqExchangeAutoDelete
	 * @param newValue the new transportRabbitMqExchangeAutoDelete to set
	 * 
	 */
	public void setTransportRabbitMqExchangeAutoDelete(String newValue);


	/**
	 * @return the transportRabbitMqServerVirtualHost
	 * 
	 */
	public String getTransportRabbitMqServerVirtualHost();

	/**
	 * Defines a new transportRabbitMqServerVirtualHost
	 * @param newValue the new transportRabbitMqServerVirtualHost to set
	 * 
	 */
	public void setTransportRabbitMqServerVirtualHost(String newValue);


	/**
	 * @return the transportRabbitMqFactoryHeartbeat
	 * 
	 */
	public String getTransportRabbitMqFactoryHeartbeat();

	/**
	 * Defines a new transportRabbitMqFactoryHeartbeat
	 * @param newValue the new transportRabbitMqFactoryHeartbeat to set
	 * 
	 */
	public void setTransportRabbitMqFactoryHeartbeat(String newValue);


	/**
	 * @return the transportRabbitMqConnectionSslEnabled
	 * 
	 */
	public String getTransportRabbitMqConnectionSslEnabled();

	/**
	 * Defines a new transportRabbitMqConnectionSslEnabled
	 * @param newValue the new transportRabbitMqConnectionSslEnabled to set
	 * 
	 */
	public void setTransportRabbitMqConnectionSslEnabled(String newValue);


	/**
	 * @return the transportRabbitMqConnectionSslKeystoreLocation
	 * 
	 */
	public String getTransportRabbitMqConnectionSslKeystoreLocation();

	/**
	 * Defines a new transportRabbitMqConnectionSslKeystoreLocation
	 * @param newValue the new transportRabbitMqConnectionSslKeystoreLocation to set
	 * 
	 */
	public void setTransportRabbitMqConnectionSslKeystoreLocation(String newValue);


	/**
	 * @return the transportRabbitMqConnectionSslKeystoreType
	 * 
	 */
	public String getTransportRabbitMqConnectionSslKeystoreType();

	/**
	 * Defines a new transportRabbitMqConnectionSslKeystoreType
	 * @param newValue the new transportRabbitMqConnectionSslKeystoreType to set
	 * 
	 */
	public void setTransportRabbitMqConnectionSslKeystoreType(String newValue);


	/**
	 * @return the transportRabbitMqConnectionSslKeystorePassword
	 * 
	 */
	public String getTransportRabbitMqConnectionSslKeystorePassword();

	/**
	 * Defines a new transportRabbitMqConnectionSslKeystorePassword
	 * @param newValue the new transportRabbitMqConnectionSslKeystorePassword to set
	 * 
	 */
	public void setTransportRabbitMqConnectionSslKeystorePassword(String newValue);


	/**
	 * @return the transportRabbitMqConnectionSslTruststoreLocation
	 * 
	 */
	public String getTransportRabbitMqConnectionSslTruststoreLocation();

	/**
	 * Defines a new transportRabbitMqConnectionSslTruststoreLocation
	 * @param newValue the new transportRabbitMqConnectionSslTruststoreLocation to set
	 * 
	 */
	public void setTransportRabbitMqConnectionSslTruststoreLocation(String newValue);


	/**
	 * @return the transportRabbitMqConnectionSslTruststoreType
	 * 
	 */
	public String getTransportRabbitMqConnectionSslTruststoreType();

	/**
	 * Defines a new transportRabbitMqConnectionSslTruststoreType
	 * @param newValue the new transportRabbitMqConnectionSslTruststoreType to set
	 * 
	 */
	public void setTransportRabbitMqConnectionSslTruststoreType(String newValue);


	/**
	 * @return the transportRabbitMqConnectionSslTruststorePassword
	 * 
	 */
	public String getTransportRabbitMqConnectionSslTruststorePassword();

	/**
	 * Defines a new transportRabbitMqConnectionSslTruststorePassword
	 * @param newValue the new transportRabbitMqConnectionSslTruststorePassword to set
	 * 
	 */
	public void setTransportRabbitMqConnectionSslTruststorePassword(String newValue);


	/**
	 * @return the transportRabbitMqConnectionSslVersion
	 * 
	 */
	public String getTransportRabbitMqConnectionSslVersion();

	/**
	 * Defines a new transportRabbitMqConnectionSslVersion
	 * @param newValue the new transportRabbitMqConnectionSslVersion to set
	 * 
	 */
	public void setTransportRabbitMqConnectionSslVersion(String newValue);


	/**
	 * @return the transportRabbitMqMessageContentType
	 * 
	 */
	public String getTransportRabbitMqMessageContentType();

	/**
	 * Defines a new transportRabbitMqMessageContentType
	 * @param newValue the new transportRabbitMqMessageContentType to set
	 * 
	 */
	public void setTransportRabbitMqMessageContentType(String newValue);


	/**
	 * @return the transportRabbitMqConnectionRetryCount
	 * 
	 */
	public String getTransportRabbitMqConnectionRetryCount();

	/**
	 * Defines a new transportRabbitMqConnectionRetryCount
	 * @param newValue the new transportRabbitMqConnectionRetryCount to set
	 * 
	 */
	public void setTransportRabbitMqConnectionRetryCount(String newValue);


	/**
	 * @return the transportRabbitMqConnectionRetryInterval
	 * 
	 */
	public String getTransportRabbitMqConnectionRetryInterval();

	/**
	 * Defines a new transportRabbitMqConnectionRetryInterval
	 * @param newValue the new transportRabbitMqConnectionRetryInterval to set
	 * 
	 */
	public void setTransportRabbitMqConnectionRetryInterval(String newValue);


	/**
	 * @return the transportRabbitMqServerRetryInterval
	 * 
	 */
	public String getTransportRabbitMqServerRetryInterval();

	/**
	 * Defines a new transportRabbitMqServerRetryInterval
	 * @param newValue the new transportRabbitMqServerRetryInterval to set
	 * 
	 */
	public void setTransportRabbitMqServerRetryInterval(String newValue);


	/**
	 * @return the wsInboundPort
	 * 
	 */
	public String getWsInboundPort();

	/**
	 * Defines a new wsInboundPort
	 * @param newValue the new wsInboundPort to set
	 * 
	 */
	public void setWsInboundPort(String newValue);


	/**
	 * @return the wsClientSideBroadcastLevel
	 * 
	 */
	public Enumerator getWsClientSideBroadcastLevel();

	/**
	 * Init the wsClientSideBroadcastLevel
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initWsClientSideBroadcastLevel(Object input, Enumerator current);

	/**
	 * Defines a new wsClientSideBroadcastLevel
	 * @param newValue the new wsClientSideBroadcastLevel to set
	 * 
	 */
	public void setWsClientSideBroadcastLevel(Enumerator newValue);


	/**
	 * @return the wsOutflowDispatchSequence
	 * 
	 */
	public String getWsOutflowDispatchSequence();

	/**
	 * Defines a new wsOutflowDispatchSequence
	 * @param newValue the new wsOutflowDispatchSequence to set
	 * 
	 */
	public void setWsOutflowDispatchSequence(String newValue);


	/**
	 * @return the wsOutflowDispatchFaultSequence
	 * 
	 */
	public String getWsOutflowDispatchFaultSequence();

	/**
	 * Defines a new wsOutflowDispatchFaultSequence
	 * @param newValue the new wsOutflowDispatchFaultSequence to set
	 * 
	 */
	public void setWsOutflowDispatchFaultSequence(String newValue);


	/**
	 * @return the wsBossThreadPoolSize
	 * 
	 */
	public String getWsBossThreadPoolSize();

	/**
	 * Defines a new wsBossThreadPoolSize
	 * @param newValue the new wsBossThreadPoolSize to set
	 * 
	 */
	public void setWsBossThreadPoolSize(String newValue);


	/**
	 * @return the wsWorkerThreadPoolSize
	 * 
	 */
	public String getWsWorkerThreadPoolSize();

	/**
	 * Defines a new wsWorkerThreadPoolSize
	 * @param newValue the new wsWorkerThreadPoolSize to set
	 * 
	 */
	public void setWsWorkerThreadPoolSize(String newValue);


	/**
	 * @return the wsSubprotocolHandlerClass
	 * 
	 */
	public String getWsSubprotocolHandlerClass();

	/**
	 * Defines a new wsSubprotocolHandlerClass
	 * @param newValue the new wsSubprotocolHandlerClass to set
	 * 
	 */
	public void setWsSubprotocolHandlerClass(String newValue);


	/**
	 * @return the wsPipelineHandlerClass
	 * 
	 */
	public String getWsPipelineHandlerClass();

	/**
	 * Defines a new wsPipelineHandlerClass
	 * @param newValue the new wsPipelineHandlerClass to set
	 * 
	 */
	public void setWsPipelineHandlerClass(String newValue);


	/**
	 * @return the transportFeedURL
	 * 
	 */
	public String getTransportFeedURL();

	/**
	 * Defines a new transportFeedURL
	 * @param newValue the new transportFeedURL to set
	 * 
	 */
	public void setTransportFeedURL(String newValue);


	/**
	 * @return the transportFeedType
	 * 
	 */
	public Enumerator getTransportFeedType();

	/**
	 * Init the transportFeedType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportFeedType(Object input, Enumerator current);

	/**
	 * Defines a new transportFeedType
	 * @param newValue the new transportFeedType to set
	 * 
	 */
	public void setTransportFeedType(Enumerator newValue);


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
	 * @return the transportJMSRetriesBeforeSuspension
	 * 
	 */
	public String getTransportJMSRetriesBeforeSuspension();

	/**
	 * Defines a new transportJMSRetriesBeforeSuspension
	 * @param newValue the new transportJMSRetriesBeforeSuspension to set
	 * 
	 */
	public void setTransportJMSRetriesBeforeSuspension(String newValue);


	/**
	 * @return the transportJMSResetConnectionOnPollingSuspension
	 * 
	 */
	public Boolean getTransportJMSResetConnectionOnPollingSuspension();

	/**
	 * Defines a new transportJMSResetConnectionOnPollingSuspension
	 * @param newValue the new transportJMSResetConnectionOnPollingSuspension to set
	 * 
	 */
	public void setTransportJMSResetConnectionOnPollingSuspension(Boolean newValue);


	/**
	 * @return the transportJMSPollingSuspensionPeriod
	 * 
	 */
	public String getTransportJMSPollingSuspensionPeriod();

	/**
	 * Defines a new transportJMSPollingSuspensionPeriod
	 * @param newValue the new transportJMSPollingSuspensionPeriod to set
	 * 
	 */
	public void setTransportJMSPollingSuspensionPeriod(String newValue);


	/**
	 * @return the transportMQTTSslKeystoreLocation
	 * 
	 */
	public String getTransportMQTTSslKeystoreLocation();

	/**
	 * Defines a new transportMQTTSslKeystoreLocation
	 * @param newValue the new transportMQTTSslKeystoreLocation to set
	 * 
	 */
	public void setTransportMQTTSslKeystoreLocation(String newValue);


	/**
	 * @return the transportMQTTSslKeystoreType
	 * 
	 */
	public String getTransportMQTTSslKeystoreType();

	/**
	 * Defines a new transportMQTTSslKeystoreType
	 * @param newValue the new transportMQTTSslKeystoreType to set
	 * 
	 */
	public void setTransportMQTTSslKeystoreType(String newValue);


	/**
	 * @return the transportMQTTSslKeystorePassword
	 * 
	 */
	public String getTransportMQTTSslKeystorePassword();

	/**
	 * Defines a new transportMQTTSslKeystorePassword
	 * @param newValue the new transportMQTTSslKeystorePassword to set
	 * 
	 */
	public void setTransportMQTTSslKeystorePassword(String newValue);


	/**
	 * @return the transportMQTTSslTruststoreLocation
	 * 
	 */
	public String getTransportMQTTSslTruststoreLocation();

	/**
	 * Defines a new transportMQTTSslTruststoreLocation
	 * @param newValue the new transportMQTTSslTruststoreLocation to set
	 * 
	 */
	public void setTransportMQTTSslTruststoreLocation(String newValue);


	/**
	 * @return the transportMQTTSslTruststoreType
	 * 
	 */
	public String getTransportMQTTSslTruststoreType();

	/**
	 * Defines a new transportMQTTSslTruststoreType
	 * @param newValue the new transportMQTTSslTruststoreType to set
	 * 
	 */
	public void setTransportMQTTSslTruststoreType(String newValue);


	/**
	 * @return the transportMQTTSslTruststorePassword
	 * 
	 */
	public String getTransportMQTTSslTruststorePassword();

	/**
	 * Defines a new transportMQTTSslTruststorePassword
	 * @param newValue the new transportMQTTSslTruststorePassword to set
	 * 
	 */
	public void setTransportMQTTSslTruststorePassword(String newValue);


	/**
	 * @return the transportMQTTSslVersion
	 * 
	 */
	public String getTransportMQTTSslVersion();

	/**
	 * Defines a new transportMQTTSslVersion
	 * @param newValue the new transportMQTTSslVersion to set
	 * 
	 */
	public void setTransportMQTTSslVersion(String newValue);


	/**
	 * @return the wssSslKeyStoreFile
	 * 
	 */
	public String getWssSslKeyStoreFile();

	/**
	 * Defines a new wssSslKeyStoreFile
	 * @param newValue the new wssSslKeyStoreFile to set
	 * 
	 */
	public void setWssSslKeyStoreFile(String newValue);


	/**
	 * @return the wssSslKeyStorePass
	 * 
	 */
	public String getWssSslKeyStorePass();

	/**
	 * Defines a new wssSslKeyStorePass
	 * @param newValue the new wssSslKeyStorePass to set
	 * 
	 */
	public void setWssSslKeyStorePass(String newValue);


	/**
	 * @return the wssSslTrustStoreFile
	 * 
	 */
	public String getWssSslTrustStoreFile();

	/**
	 * Defines a new wssSslTrustStoreFile
	 * @param newValue the new wssSslTrustStoreFile to set
	 * 
	 */
	public void setWssSslTrustStoreFile(String newValue);


	/**
	 * @return the wssSslTrustStorePass
	 * 
	 */
	public String getWssSslTrustStorePass();

	/**
	 * Defines a new wssSslTrustStorePass
	 * @param newValue the new wssSslTrustStorePass to set
	 * 
	 */
	public void setWssSslTrustStorePass(String newValue);


	/**
	 * @return the wssSslCertPass
	 * 
	 */
	public String getWssSslCertPass();

	/**
	 * Defines a new wssSslCertPass
	 * @param newValue the new wssSslCertPass to set
	 * 
	 */
	public void setWssSslCertPass(String newValue);


	/**
	 * @return the wsDefaultContentType
	 * 
	 */
	public String getWsDefaultContentType();

	/**
	 * Defines a new wsDefaultContentType
	 * @param newValue the new wsDefaultContentType to set
	 * 
	 */
	public void setWsDefaultContentType(String newValue);


	/**
	 * @return the wsShutdownStatusCode
	 * 
	 */
	public String getWsShutdownStatusCode();

	/**
	 * Defines a new wsShutdownStatusCode
	 * @param newValue the new wsShutdownStatusCode to set
	 * 
	 */
	public void setWsShutdownStatusCode(String newValue);


	/**
	 * @return the wsShutdownStatusMessage
	 * 
	 */
	public String getWsShutdownStatusMessage();

	/**
	 * Defines a new wsShutdownStatusMessage
	 * @param newValue the new wsShutdownStatusMessage to set
	 * 
	 */
	public void setWsShutdownStatusMessage(String newValue);


	/**
	 * @return the wsUsePortOffset
	 * 
	 */
	public Boolean getWsUsePortOffset();

	/**
	 * Defines a new wsUsePortOffset
	 * @param newValue the new wsUsePortOffset to set
	 * 
	 */
	public void setWsUsePortOffset(Boolean newValue);


	/**
	 * @return the wssSslProtocols
	 * 
	 */
	public String getWssSslProtocols();

	/**
	 * Defines a new wssSslProtocols
	 * @param newValue the new wssSslProtocols to set
	 * 
	 */
	public void setWssSslProtocols(String newValue);


	/**
	 * @return the wssSslCipherSuites
	 * 
	 */
	public String getWssSslCipherSuites();

	/**
	 * Defines a new wssSslCipherSuites
	 * @param newValue the new wssSslCipherSuites to set
	 * 
	 */
	public void setWssSslCipherSuites(String newValue);


	/**
	 * @return the transportRabbitMqConsumerQos
	 * 
	 */
	public String getTransportRabbitMqConsumerQos();

	/**
	 * Defines a new transportRabbitMqConsumerQos
	 * @param newValue the new transportRabbitMqConsumerQos to set
	 * 
	 */
	public void setTransportRabbitMqConsumerQos(String newValue);


	/**
	 * @return the transportRabbitMqConsumerQosType
	 * 
	 */
	public Enumerator getTransportRabbitMqConsumerQosType();

	/**
	 * Init the transportRabbitMqConsumerQosType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTransportRabbitMqConsumerQosType(Object input, Enumerator current);

	/**
	 * Defines a new transportRabbitMqConsumerQosType
	 * @param newValue the new transportRabbitMqConsumerQosType to set
	 * 
	 */
	public void setTransportRabbitMqConsumerQosType(Enumerator newValue);


	/**
	 * @return the transportJMSDBUrl
	 * 
	 */
	public String getTransportJMSDBUrl();

	/**
	 * Defines a new transportJMSDBUrl
	 * @param newValue the new transportJMSDBUrl to set
	 * 
	 */
	public void setTransportJMSDBUrl(String newValue);


	/**
	 * @return the transportRabbitMqAutoDeclare
	 * 
	 */
	public Boolean getTransportRabbitMqAutoDeclare();

	/**
	 * Defines a new transportRabbitMqAutoDeclare
	 * @param newValue the new transportRabbitMqAutoDeclare to set
	 * 
	 */
	public void setTransportRabbitMqAutoDeclare(Boolean newValue);


	/**
	 * @return the transportRabbitMqMaxDeadLetteredCount
	 * 
	 */
	public String getTransportRabbitMqMaxDeadLetteredCount();

	/**
	 * Defines a new transportRabbitMqMaxDeadLetteredCount
	 * @param newValue the new transportRabbitMqMaxDeadLetteredCount to set
	 * 
	 */
	public void setTransportRabbitMqMaxDeadLetteredCount(String newValue);


	/**
	 * @return the transportRabbitMqRequeueDelay
	 * 
	 */
	public String getTransportRabbitMqRequeueDelay();

	/**
	 * Defines a new transportRabbitMqRequeueDelay
	 * @param newValue the new transportRabbitMqRequeueDelay to set
	 * 
	 */
	public void setTransportRabbitMqRequeueDelay(String newValue);


	/**
	 * @return the transportRabbitMqExchangeAutoDeclare
	 * 
	 */
	public Boolean getTransportRabbitMqExchangeAutoDeclare();

	/**
	 * Defines a new transportRabbitMqExchangeAutoDeclare
	 * @param newValue the new transportRabbitMqExchangeAutoDeclare to set
	 * 
	 */
	public void setTransportRabbitMqExchangeAutoDeclare(Boolean newValue);


	/**
	 * @return the transportRabbitMqConsumerTag
	 * 
	 */
	public String getTransportRabbitMqConsumerTag();

	/**
	 * Defines a new transportRabbitMqConsumerTag
	 * @param newValue the new transportRabbitMqConsumerTag to set
	 * 
	 */
	public void setTransportRabbitMqConsumerTag(String newValue);


	/**
	 * @return the transportRabbitMqErrorQueueRoutingKey
	 * 
	 */
	public String getTransportRabbitMqErrorQueueRoutingKey();

	/**
	 * Defines a new transportRabbitMqErrorQueueRoutingKey
	 * @param newValue the new transportRabbitMqErrorQueueRoutingKey to set
	 * 
	 */
	public void setTransportRabbitMqErrorQueueRoutingKey(String newValue);


	/**
	 * @return the transportRabbitMqErrorExchangeName
	 * 
	 */
	public String getTransportRabbitMqErrorExchangeName();

	/**
	 * Defines a new transportRabbitMqErrorExchangeName
	 * @param newValue the new transportRabbitMqErrorExchangeName to set
	 * 
	 */
	public void setTransportRabbitMqErrorExchangeName(String newValue);


	/**
	 * @return the transportRabbitMqFactoryConnectionTimeout
	 * 
	 */
	public String getTransportRabbitMqFactoryConnectionTimeout();

	/**
	 * Defines a new transportRabbitMqFactoryConnectionTimeout
	 * @param newValue the new transportRabbitMqFactoryConnectionTimeout to set
	 * 
	 */
	public void setTransportRabbitMqFactoryConnectionTimeout(String newValue);


	/**
	 * @return the transportRabbitMqFactoryNetworkRecoveryInterval
	 * 
	 */
	public String getTransportRabbitMqFactoryNetworkRecoveryInterval();

	/**
	 * Defines a new transportRabbitMqFactoryNetworkRecoveryInterval
	 * @param newValue the new transportRabbitMqFactoryNetworkRecoveryInterval to set
	 * 
	 */
	public void setTransportRabbitMqFactoryNetworkRecoveryInterval(String newValue);




	// Start of user code for transportRabbitMqConsumerQosKey specific getters and setters declaration
    public RegistryKeyProperty getRabbitMqConsumerQosKey();
    
    public void setRabbitMqConsumerQosKey(RegistryKeyProperty registryKeyProperty);
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
