/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inbound Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceInputConnector <em>Sequence Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceOutputConnector <em>Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceInputConnector <em>On Error Sequence Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceOutputConnector <em>On Error Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getContainer <em>Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getType <em>Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHttpPort <em>Inbound Http Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolSizeCore <em>Inbound Worker Pool Size Core</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolSizeMax <em>Inbound Worker Pool Size Max</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerThreadKeepAliveSec <em>Inbound Worker Thread Keep Alive Sec</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolQueueLength <em>Inbound Worker Pool Queue Length</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundThreadGroupId <em>Inbound Thread Group Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundThreadId <em>Inbound Thread Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getDispatchFilterPattern <em>Dispatch Filter Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInterval <em>Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isSequential <em>Sequential</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isCoordination <em>Coordination</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileURI <em>Transport VFS File URI</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSContentType <em>Transport VFS Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileNamePattern <em>Transport VFS File Name Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileProcessInterval <em>Transport VFS File Process Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileProcessCount <em>Transport VFS File Process Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSLocking <em>Transport VFS Locking</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMaxRetryCount <em>Transport VFS Max Retry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSReconnectTimeout <em>Transport VFS Reconnect Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterProcess <em>Transport VFS Action After Process</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterProcess <em>Transport VFS Move After Process</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterErrors <em>Transport VFS Action After Errors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterErrors <em>Transport VFS Move After Errors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterFailure <em>Transport VFS Action After Failure</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterFailure <em>Transport VFS Move After Failure</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSAutoLockRelease <em>Transport VFS Auto Lock Release</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSAutoLockReleaseInterval <em>Transport VFS Auto Lock Release Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSLockReleaseSameNode <em>Transport VFS Lock Release Same Node</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSDistributedLock <em>Transport VFS Distributed Lock</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSStreaming <em>Transport VFS Streaming</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSBuild <em>Transport VFS Build</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSDistributedTimeout <em>Transport VFS Distributed Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getJavaNamingFactoryInitial <em>Java Naming Factory Initial</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getJavaNamingProviderUrl <em>Java Naming Provider Url</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSConnectionFactoryJNDIName <em>Transport JMS Connection Factory JNDI Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSConnectionFactoryType <em>Transport JMS Connection Factory Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDestination <em>Transport JMS Destination</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportJMSSessionTransacted <em>Transport JMS Session Transacted</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSSessionAcknowledgement <em>Transport JMS Session Acknowledgement</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSCacheLevel <em>Transport JMS Cache Level</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSUserName <em>Transport JMS User Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPassword <em>Transport JMS Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSJMSSpecVersion <em>Transport JMSJMS Spec Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSSubscriptionDurable <em>Transport JMS Subscription Durable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDurableSubscriberClientID <em>Transport JMS Durable Subscriber Client ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSMessageSelector <em>Transport JMS Message Selector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isApiDispatchingEnabled <em>Api Dispatching Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveTimestampFormat <em>Transport VFS Move Timestamp Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileSortAttribute <em>Transport VFS File Sort Attribute</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSFileSortAscending <em>Transport VFS File Sort Ascending</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSSubFolderTimestampFormat <em>Transport VFS Sub Folder Timestamp Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSCreateFolder <em>Transport VFS Create Folder</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSReceiveTimeout <em>Transport JMS Receive Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSContentType <em>Transport JMS Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSContentTypeProperty <em>Transport JMS Content Type Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSReplyDestination <em>Transport JMS Reply Destination</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPubSubNoLocal <em>Transport JMS Pub Sub No Local</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTConnectionFactory <em>Transport MQTT Connection Factory</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTServerHostName <em>Transport MQTT Server Host Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTServerPort <em>Transport MQTT Server Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTTopicName <em>Transport MQTT Topic Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionQOS <em>Transport MQTT Subscription QOS</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportMQTTSessionClean <em>Transport MQTT Session Clean</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslEnable <em>Transport MQTT Ssl Enable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTTemporaryStoreDirectory <em>Transport MQTT Temporary Store Directory</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionUsername <em>Transport MQTT Subscription Username</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionPassword <em>Transport MQTT Subscription Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTClientId <em>Transport MQTT Client Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTruststore <em>Truststore</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getKeystore <em>Keystore</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSslVerifyClient <em>Ssl Verify Client</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSslProtocol <em>Ssl Protocol</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getHttpsProtocols <em>Https Protocols</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getCertificateRevocationVerifier <em>Certificate Revocation Verifier</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7Port <em>Inbound HL7 Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7AutoAck <em>Inbound HL7 Auto Ack</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7MessagePreProcessor <em>Inbound HL7 Message Pre Processor</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7CharSet <em>Inbound HL7 Char Set</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7TimeOut <em>Inbound HL7 Time Out</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7ValidateMessage <em>Inbound HL7 Validate Message</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7BuildInvalidMessages <em>Inbound HL7 Build Invalid Messages</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7PassThroughInvalidMessages <em>Inbound HL7 Pass Through Invalid Messages</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperConnect <em>Zookeeper Connect</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getConsumerType <em>Consumer Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTopics <em>Topics</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleTopic <em>Simple Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleBrokers <em>Simple Brokers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimplePort <em>Simple Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimplePartition <em>Simple Partition</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleMaxMessagesToRead <em>Simple Max Messages To Read</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getThreadCount <em>Thread Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperSessionTimeoutMs <em>Zookeeper Session Timeout Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperSyncTimeMs <em>Zookeeper Sync Time Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getAutoCommitIntervalMs <em>Auto Commit Interval Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getAutoOffsetReset <em>Auto Offset Reset</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmHost <em>Inbound Cxf Rm Host</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmPort <em>Inbound Cxf Rm Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmConfigFile <em>Inbound Cxf Rm Config File</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isEnableSSL <em>Enable SSL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getServiceParameters <em>Service Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isSuspend <em>Suspend</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint()
 * @model
 * @generated
 */
public interface InboundEndpoint extends EsbElement {
	/**
	 * Returns the value of the '<em><b>Sequence Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Input Connector</em>' containment reference.
	 * @see #setSequenceInputConnector(InboundEndpointSequenceInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SequenceInputConnector()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointSequenceInputConnector getSequenceInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceInputConnector <em>Sequence Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Input Connector</em>' containment reference.
	 * @see #getSequenceInputConnector()
	 * @generated
	 */
	void setSequenceInputConnector(InboundEndpointSequenceInputConnector value);

	/**
	 * Returns the value of the '<em><b>Sequence Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Output Connector</em>' containment reference.
	 * @see #setSequenceOutputConnector(InboundEndpointSequenceOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SequenceOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointSequenceOutputConnector getSequenceOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSequenceOutputConnector <em>Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Output Connector</em>' containment reference.
	 * @see #getSequenceOutputConnector()
	 * @generated
	 */
	void setSequenceOutputConnector(InboundEndpointSequenceOutputConnector value);

	/**
	 * Returns the value of the '<em><b>On Error Sequence Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Error Sequence Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Error Sequence Input Connector</em>' containment reference.
	 * @see #setOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_OnErrorSequenceInputConnector()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointOnErrorSequenceInputConnector getOnErrorSequenceInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceInputConnector <em>On Error Sequence Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Error Sequence Input Connector</em>' containment reference.
	 * @see #getOnErrorSequenceInputConnector()
	 * @generated
	 */
	void setOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector value);

	/**
	 * Returns the value of the '<em><b>On Error Sequence Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Error Sequence Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Error Sequence Output Connector</em>' containment reference.
	 * @see #setOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_OnErrorSequenceOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointOnErrorSequenceOutputConnector getOnErrorSequenceOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getOnErrorSequenceOutputConnector <em>On Error Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Error Sequence Output Connector</em>' containment reference.
	 * @see #getOnErrorSequenceOutputConnector()
	 * @generated
	 */
	void setOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' containment reference.
	 * @see #setContainer(InboundEndpointContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Container()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointContainer getContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getContainer <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' containment reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(InboundEndpointContainer value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType
	 * @see #setType(InboundEndpointType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Type()
	 * @model
	 * @generated
	 */
	InboundEndpointType getType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType
	 * @see #getType()
	 * @generated
	 */
	void setType(InboundEndpointType value);

	/**
	 * Returns the value of the '<em><b>Inbound HL7 Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound HL7 Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound HL7 Port</em>' attribute.
	 * @see #setInboundHL7Port(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7Port()
	 * @model
	 * @generated
	 */
	String getInboundHL7Port();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7Port <em>Inbound HL7 Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound HL7 Port</em>' attribute.
	 * @see #getInboundHL7Port()
	 * @generated
	 */
	void setInboundHL7Port(String value);

	/**
	 * Returns the value of the '<em><b>Inbound HL7 Auto Ack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound HL7 Auto Ack</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound HL7 Auto Ack</em>' attribute.
	 * @see #setInboundHL7AutoAck(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7AutoAck()
	 * @model
	 * @generated
	 */
	boolean isInboundHL7AutoAck();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7AutoAck <em>Inbound HL7 Auto Ack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound HL7 Auto Ack</em>' attribute.
	 * @see #isInboundHL7AutoAck()
	 * @generated
	 */
	void setInboundHL7AutoAck(boolean value);

	/**
	 * Returns the value of the '<em><b>Inbound HL7 Message Pre Processor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound HL7 Message Pre Processor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound HL7 Message Pre Processor</em>' attribute.
	 * @see #setInboundHL7MessagePreProcessor(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7MessagePreProcessor()
	 * @model
	 * @generated
	 */
	String getInboundHL7MessagePreProcessor();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7MessagePreProcessor <em>Inbound HL7 Message Pre Processor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound HL7 Message Pre Processor</em>' attribute.
	 * @see #getInboundHL7MessagePreProcessor()
	 * @generated
	 */
	void setInboundHL7MessagePreProcessor(String value);

	/**
	 * Returns the value of the '<em><b>Inbound HL7 Char Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound HL7 Char Set</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound HL7 Char Set</em>' attribute.
	 * @see #setInboundHL7CharSet(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7CharSet()
	 * @model
	 * @generated
	 */
	String getInboundHL7CharSet();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7CharSet <em>Inbound HL7 Char Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound HL7 Char Set</em>' attribute.
	 * @see #getInboundHL7CharSet()
	 * @generated
	 */
	void setInboundHL7CharSet(String value);

	/**
	 * Returns the value of the '<em><b>Inbound HL7 Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound HL7 Time Out</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound HL7 Time Out</em>' attribute.
	 * @see #setInboundHL7TimeOut(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7TimeOut()
	 * @model
	 * @generated
	 */
	String getInboundHL7TimeOut();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7TimeOut <em>Inbound HL7 Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound HL7 Time Out</em>' attribute.
	 * @see #getInboundHL7TimeOut()
	 * @generated
	 */
	void setInboundHL7TimeOut(String value);

	/**
	 * Returns the value of the '<em><b>Inbound HL7 Validate Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound HL7 Validate Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound HL7 Validate Message</em>' attribute.
	 * @see #setInboundHL7ValidateMessage(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7ValidateMessage()
	 * @model
	 * @generated
	 */
	boolean isInboundHL7ValidateMessage();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isInboundHL7ValidateMessage <em>Inbound HL7 Validate Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound HL7 Validate Message</em>' attribute.
	 * @see #isInboundHL7ValidateMessage()
	 * @generated
	 */
	void setInboundHL7ValidateMessage(boolean value);

	/**
	 * Returns the value of the '<em><b>Inbound HL7 Build Invalid Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound HL7 Build Invalid Messages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound HL7 Build Invalid Messages</em>' attribute.
	 * @see #setInboundHL7BuildInvalidMessages(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7BuildInvalidMessages()
	 * @model
	 * @generated
	 */
	String getInboundHL7BuildInvalidMessages();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7BuildInvalidMessages <em>Inbound HL7 Build Invalid Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound HL7 Build Invalid Messages</em>' attribute.
	 * @see #getInboundHL7BuildInvalidMessages()
	 * @generated
	 */
	void setInboundHL7BuildInvalidMessages(String value);

	/**
	 * Returns the value of the '<em><b>Inbound HL7 Pass Through Invalid Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound HL7 Pass Through Invalid Messages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound HL7 Pass Through Invalid Messages</em>' attribute.
	 * @see #setInboundHL7PassThroughInvalidMessages(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHL7PassThroughInvalidMessages()
	 * @model
	 * @generated
	 */
	String getInboundHL7PassThroughInvalidMessages();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHL7PassThroughInvalidMessages <em>Inbound HL7 Pass Through Invalid Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound HL7 Pass Through Invalid Messages</em>' attribute.
	 * @see #getInboundHL7PassThroughInvalidMessages()
	 * @generated
	 */
	void setInboundHL7PassThroughInvalidMessages(String value);

	/**
	 * Returns the value of the '<em><b>Zookeeper Connect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zookeeper Connect</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zookeeper Connect</em>' attribute.
	 * @see #setZookeeperConnect(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ZookeeperConnect()
	 * @model
	 * @generated
	 */
	String getZookeeperConnect();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperConnect <em>Zookeeper Connect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zookeeper Connect</em>' attribute.
	 * @see #getZookeeperConnect()
	 * @generated
	 */
	void setZookeeperConnect(String value);

	/**
	 * Returns the value of the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Id</em>' attribute.
	 * @see #setGroupId(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_GroupId()
	 * @model
	 * @generated
	 */
	String getGroupId();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getGroupId <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Id</em>' attribute.
	 * @see #getGroupId()
	 * @generated
	 */
	void setGroupId(String value);

	/**
	 * Returns the value of the '<em><b>Consumer Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ConsumerType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consumer Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consumer Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ConsumerType
	 * @see #setConsumerType(ConsumerType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ConsumerType()
	 * @model
	 * @generated
	 */
	ConsumerType getConsumerType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getConsumerType <em>Consumer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consumer Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ConsumerType
	 * @see #getConsumerType()
	 * @generated
	 */
	void setConsumerType(ConsumerType value);

	/**
	 * Returns the value of the '<em><b>Content Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ContentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ContentType
	 * @see #setContentType(ContentType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ContentType()
	 * @model
	 * @generated
	 */
	ContentType getContentType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getContentType <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ContentType
	 * @see #getContentType()
	 * @generated
	 */
	void setContentType(ContentType value);

	/**
	 * Returns the value of the '<em><b>Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topics</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topics</em>' attribute.
	 * @see #setTopics(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Topics()
	 * @model
	 * @generated
	 */
	String getTopics();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTopics <em>Topics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topics</em>' attribute.
	 * @see #getTopics()
	 * @generated
	 */
	void setTopics(String value);

	/**
	 * Returns the value of the '<em><b>Simple Topic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Topic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Topic</em>' attribute.
	 * @see #setSimpleTopic(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SimpleTopic()
	 * @model
	 * @generated
	 */
	String getSimpleTopic();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleTopic <em>Simple Topic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Topic</em>' attribute.
	 * @see #getSimpleTopic()
	 * @generated
	 */
	void setSimpleTopic(String value);

	/**
	 * Returns the value of the '<em><b>Simple Brokers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Brokers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Brokers</em>' attribute.
	 * @see #setSimpleBrokers(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SimpleBrokers()
	 * @model
	 * @generated
	 */
	String getSimpleBrokers();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleBrokers <em>Simple Brokers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Brokers</em>' attribute.
	 * @see #getSimpleBrokers()
	 * @generated
	 */
	void setSimpleBrokers(String value);

	/**
	 * Returns the value of the '<em><b>Simple Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Port</em>' attribute.
	 * @see #setSimplePort(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SimplePort()
	 * @model
	 * @generated
	 */
	String getSimplePort();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimplePort <em>Simple Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Port</em>' attribute.
	 * @see #getSimplePort()
	 * @generated
	 */
	void setSimplePort(String value);

	/**
	 * Returns the value of the '<em><b>Simple Partition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Partition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Partition</em>' attribute.
	 * @see #setSimplePartition(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SimplePartition()
	 * @model
	 * @generated
	 */
	String getSimplePartition();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimplePartition <em>Simple Partition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Partition</em>' attribute.
	 * @see #getSimplePartition()
	 * @generated
	 */
	void setSimplePartition(String value);

	/**
	 * Returns the value of the '<em><b>Simple Max Messages To Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Max Messages To Read</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Max Messages To Read</em>' attribute.
	 * @see #setSimpleMaxMessagesToRead(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SimpleMaxMessagesToRead()
	 * @model
	 * @generated
	 */
	String getSimpleMaxMessagesToRead();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSimpleMaxMessagesToRead <em>Simple Max Messages To Read</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Max Messages To Read</em>' attribute.
	 * @see #getSimpleMaxMessagesToRead()
	 * @generated
	 */
	void setSimpleMaxMessagesToRead(String value);

	/**
	 * Returns the value of the '<em><b>Thread Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread Count</em>' attribute.
	 * @see #setThreadCount(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ThreadCount()
	 * @model
	 * @generated
	 */
	String getThreadCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getThreadCount <em>Thread Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thread Count</em>' attribute.
	 * @see #getThreadCount()
	 * @generated
	 */
	void setThreadCount(String value);

	/**
	 * Returns the value of the '<em><b>Zookeeper Session Timeout Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zookeeper Session Timeout Ms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zookeeper Session Timeout Ms</em>' attribute.
	 * @see #setZookeeperSessionTimeoutMs(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ZookeeperSessionTimeoutMs()
	 * @model
	 * @generated
	 */
	String getZookeeperSessionTimeoutMs();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperSessionTimeoutMs <em>Zookeeper Session Timeout Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zookeeper Session Timeout Ms</em>' attribute.
	 * @see #getZookeeperSessionTimeoutMs()
	 * @generated
	 */
	void setZookeeperSessionTimeoutMs(String value);

	/**
	 * Returns the value of the '<em><b>Zookeeper Sync Time Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zookeeper Sync Time Ms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zookeeper Sync Time Ms</em>' attribute.
	 * @see #setZookeeperSyncTimeMs(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ZookeeperSyncTimeMs()
	 * @model
	 * @generated
	 */
	String getZookeeperSyncTimeMs();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getZookeeperSyncTimeMs <em>Zookeeper Sync Time Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zookeeper Sync Time Ms</em>' attribute.
	 * @see #getZookeeperSyncTimeMs()
	 * @generated
	 */
	void setZookeeperSyncTimeMs(String value);

	/**
	 * Returns the value of the '<em><b>Auto Commit Interval Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Commit Interval Ms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Commit Interval Ms</em>' attribute.
	 * @see #setAutoCommitIntervalMs(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_AutoCommitIntervalMs()
	 * @model
	 * @generated
	 */
	String getAutoCommitIntervalMs();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getAutoCommitIntervalMs <em>Auto Commit Interval Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Commit Interval Ms</em>' attribute.
	 * @see #getAutoCommitIntervalMs()
	 * @generated
	 */
	void setAutoCommitIntervalMs(String value);

	/**
	 * Returns the value of the '<em><b>Auto Offset Reset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Offset Reset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Offset Reset</em>' attribute.
	 * @see #setAutoOffsetReset(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_AutoOffsetReset()
	 * @model
	 * @generated
	 */
	String getAutoOffsetReset();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getAutoOffsetReset <em>Auto Offset Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Offset Reset</em>' attribute.
	 * @see #getAutoOffsetReset()
	 * @generated
	 */
	void setAutoOffsetReset(String value);

	/**
	 * Returns the value of the '<em><b>Inbound Cxf Rm Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Cxf Rm Host</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Cxf Rm Host</em>' attribute.
	 * @see #setInboundCxfRmHost(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundCxfRmHost()
	 * @model
	 * @generated
	 */
	String getInboundCxfRmHost();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmHost <em>Inbound Cxf Rm Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Cxf Rm Host</em>' attribute.
	 * @see #getInboundCxfRmHost()
	 * @generated
	 */
	void setInboundCxfRmHost(String value);

	/**
	 * Returns the value of the '<em><b>Inbound Cxf Rm Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Cxf Rm Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Cxf Rm Port</em>' attribute.
	 * @see #setInboundCxfRmPort(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundCxfRmPort()
	 * @model
	 * @generated
	 */
	String getInboundCxfRmPort();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmPort <em>Inbound Cxf Rm Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Cxf Rm Port</em>' attribute.
	 * @see #getInboundCxfRmPort()
	 * @generated
	 */
	void setInboundCxfRmPort(String value);

	/**
	 * Returns the value of the '<em><b>Inbound Cxf Rm Config File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Cxf Rm Config File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Cxf Rm Config File</em>' attribute.
	 * @see #setInboundCxfRmConfigFile(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundCxfRmConfigFile()
	 * @model
	 * @generated
	 */
	String getInboundCxfRmConfigFile();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundCxfRmConfigFile <em>Inbound Cxf Rm Config File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Cxf Rm Config File</em>' attribute.
	 * @see #getInboundCxfRmConfigFile()
	 * @generated
	 */
	void setInboundCxfRmConfigFile(String value);

	/**
	 * Returns the value of the '<em><b>Enable SSL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable SSL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable SSL</em>' attribute.
	 * @see #setEnableSSL(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_EnableSSL()
	 * @model
	 * @generated
	 */
	boolean isEnableSSL();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isEnableSSL <em>Enable SSL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable SSL</em>' attribute.
	 * @see #isEnableSSL()
	 * @generated
	 */
	void setEnableSSL(boolean value);

	/**
	 * Returns the value of the '<em><b>Service Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Parameters</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ServiceParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<InboundEndpointParameter> getServiceParameters();

	/**
	 * Returns the value of the '<em><b>Suspend</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspend</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspend</em>' attribute.
	 * @see #setSuspend(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Suspend()
	 * @model default="false"
	 * @generated
	 */
	boolean isSuspend();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isSuspend <em>Suspend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspend</em>' attribute.
	 * @see #isSuspend()
	 * @generated
	 */
	void setSuspend(boolean value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(String value);

	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' attribute.
	 * @see #setProtocol(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Protocol()
	 * @model
	 * @generated
	 */
	String getProtocol();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getProtocol <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' attribute.
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(String value);

	/**
	 * Returns the value of the '<em><b>Inbound Http Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Http Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Http Port</em>' attribute.
	 * @see #setInboundHttpPort(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundHttpPort()
	 * @model
	 * @generated
	 */
	String getInboundHttpPort();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundHttpPort <em>Inbound Http Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Http Port</em>' attribute.
	 * @see #getInboundHttpPort()
	 * @generated
	 */
	void setInboundHttpPort(String value);

	/**
	 * Returns the value of the '<em><b>Inbound Worker Pool Size Core</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Worker Pool Size Core</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Worker Pool Size Core</em>' attribute.
	 * @see #setInboundWorkerPoolSizeCore(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundWorkerPoolSizeCore()
	 * @model
	 * @generated
	 */
	String getInboundWorkerPoolSizeCore();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolSizeCore <em>Inbound Worker Pool Size Core</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Worker Pool Size Core</em>' attribute.
	 * @see #getInboundWorkerPoolSizeCore()
	 * @generated
	 */
	void setInboundWorkerPoolSizeCore(String value);

	/**
	 * Returns the value of the '<em><b>Inbound Worker Pool Size Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Worker Pool Size Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Worker Pool Size Max</em>' attribute.
	 * @see #setInboundWorkerPoolSizeMax(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundWorkerPoolSizeMax()
	 * @model
	 * @generated
	 */
	String getInboundWorkerPoolSizeMax();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolSizeMax <em>Inbound Worker Pool Size Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Worker Pool Size Max</em>' attribute.
	 * @see #getInboundWorkerPoolSizeMax()
	 * @generated
	 */
	void setInboundWorkerPoolSizeMax(String value);

	/**
	 * Returns the value of the '<em><b>Inbound Worker Thread Keep Alive Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Worker Thread Keep Alive Sec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Worker Thread Keep Alive Sec</em>' attribute.
	 * @see #setInboundWorkerThreadKeepAliveSec(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundWorkerThreadKeepAliveSec()
	 * @model
	 * @generated
	 */
	String getInboundWorkerThreadKeepAliveSec();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerThreadKeepAliveSec <em>Inbound Worker Thread Keep Alive Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Worker Thread Keep Alive Sec</em>' attribute.
	 * @see #getInboundWorkerThreadKeepAliveSec()
	 * @generated
	 */
	void setInboundWorkerThreadKeepAliveSec(String value);

	/**
	 * Returns the value of the '<em><b>Inbound Worker Pool Queue Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Worker Pool Queue Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Worker Pool Queue Length</em>' attribute.
	 * @see #setInboundWorkerPoolQueueLength(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundWorkerPoolQueueLength()
	 * @model
	 * @generated
	 */
	String getInboundWorkerPoolQueueLength();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundWorkerPoolQueueLength <em>Inbound Worker Pool Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Worker Pool Queue Length</em>' attribute.
	 * @see #getInboundWorkerPoolQueueLength()
	 * @generated
	 */
	void setInboundWorkerPoolQueueLength(String value);

	/**
	 * Returns the value of the '<em><b>Inbound Thread Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Thread Group Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Thread Group Id</em>' attribute.
	 * @see #setInboundThreadGroupId(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundThreadGroupId()
	 * @model
	 * @generated
	 */
	String getInboundThreadGroupId();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundThreadGroupId <em>Inbound Thread Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Thread Group Id</em>' attribute.
	 * @see #getInboundThreadGroupId()
	 * @generated
	 */
	void setInboundThreadGroupId(String value);

	/**
	 * Returns the value of the '<em><b>Inbound Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound Thread Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound Thread Id</em>' attribute.
	 * @see #setInboundThreadId(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_InboundThreadId()
	 * @model
	 * @generated
	 */
	String getInboundThreadId();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInboundThreadId <em>Inbound Thread Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound Thread Id</em>' attribute.
	 * @see #getInboundThreadId()
	 * @generated
	 */
	void setInboundThreadId(String value);

	/**
	 * Returns the value of the '<em><b>Dispatch Filter Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dispatch Filter Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dispatch Filter Pattern</em>' attribute.
	 * @see #setDispatchFilterPattern(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_DispatchFilterPattern()
	 * @model
	 * @generated
	 */
	String getDispatchFilterPattern();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getDispatchFilterPattern <em>Dispatch Filter Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dispatch Filter Pattern</em>' attribute.
	 * @see #getDispatchFilterPattern()
	 * @generated
	 */
	void setDispatchFilterPattern(String value);

	/**
	 * Returns the value of the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interval</em>' attribute.
	 * @see #setInterval(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Interval()
	 * @model
	 * @generated
	 */
	String getInterval();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getInterval <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval</em>' attribute.
	 * @see #getInterval()
	 * @generated
	 */
	void setInterval(String value);

	/**
	 * Returns the value of the '<em><b>Sequential</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequential</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequential</em>' attribute.
	 * @see #setSequential(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Sequential()
	 * @model default="true"
	 * @generated
	 */
	boolean isSequential();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isSequential <em>Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequential</em>' attribute.
	 * @see #isSequential()
	 * @generated
	 */
	void setSequential(boolean value);

	/**
	 * Returns the value of the '<em><b>Coordination</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coordination</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordination</em>' attribute.
	 * @see #setCoordination(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Coordination()
	 * @model default="true"
	 * @generated
	 */
	boolean isCoordination();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isCoordination <em>Coordination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coordination</em>' attribute.
	 * @see #isCoordination()
	 * @generated
	 */
	void setCoordination(boolean value);

	/**
	 * Returns the value of the '<em><b>Transport VFS File URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS File URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS File URI</em>' attribute.
	 * @see #setTransportVFSFileURI(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileURI()
	 * @model
	 * @generated
	 */
	String getTransportVFSFileURI();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileURI <em>Transport VFS File URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS File URI</em>' attribute.
	 * @see #getTransportVFSFileURI()
	 * @generated
	 */
	void setTransportVFSFileURI(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Content Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Content Type</em>' attribute.
	 * @see #setTransportVFSContentType(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSContentType()
	 * @model
	 * @generated
	 */
	String getTransportVFSContentType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSContentType <em>Transport VFS Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Content Type</em>' attribute.
	 * @see #getTransportVFSContentType()
	 * @generated
	 */
	void setTransportVFSContentType(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS File Name Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS File Name Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS File Name Pattern</em>' attribute.
	 * @see #setTransportVFSFileNamePattern(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileNamePattern()
	 * @model
	 * @generated
	 */
	String getTransportVFSFileNamePattern();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileNamePattern <em>Transport VFS File Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS File Name Pattern</em>' attribute.
	 * @see #getTransportVFSFileNamePattern()
	 * @generated
	 */
	void setTransportVFSFileNamePattern(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS File Process Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS File Process Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS File Process Interval</em>' attribute.
	 * @see #setTransportVFSFileProcessInterval(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileProcessInterval()
	 * @model
	 * @generated
	 */
	String getTransportVFSFileProcessInterval();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileProcessInterval <em>Transport VFS File Process Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS File Process Interval</em>' attribute.
	 * @see #getTransportVFSFileProcessInterval()
	 * @generated
	 */
	void setTransportVFSFileProcessInterval(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS File Process Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS File Process Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS File Process Count</em>' attribute.
	 * @see #setTransportVFSFileProcessCount(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileProcessCount()
	 * @model
	 * @generated
	 */
	String getTransportVFSFileProcessCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileProcessCount <em>Transport VFS File Process Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS File Process Count</em>' attribute.
	 * @see #getTransportVFSFileProcessCount()
	 * @generated
	 */
	void setTransportVFSFileProcessCount(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Locking</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.Enable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Locking</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Locking</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.Enable
	 * @see #setTransportVFSLocking(Enable)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSLocking()
	 * @model
	 * @generated
	 */
	Enable getTransportVFSLocking();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSLocking <em>Transport VFS Locking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Locking</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.Enable
	 * @see #getTransportVFSLocking()
	 * @generated
	 */
	void setTransportVFSLocking(Enable value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Max Retry Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Max Retry Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Max Retry Count</em>' attribute.
	 * @see #setTransportVFSMaxRetryCount(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMaxRetryCount()
	 * @model
	 * @generated
	 */
	String getTransportVFSMaxRetryCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMaxRetryCount <em>Transport VFS Max Retry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Max Retry Count</em>' attribute.
	 * @see #getTransportVFSMaxRetryCount()
	 * @generated
	 */
	void setTransportVFSMaxRetryCount(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Reconnect Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Reconnect Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Reconnect Timeout</em>' attribute.
	 * @see #setTransportVFSReconnectTimeout(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSReconnectTimeout()
	 * @model
	 * @generated
	 */
	String getTransportVFSReconnectTimeout();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSReconnectTimeout <em>Transport VFS Reconnect Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Reconnect Timeout</em>' attribute.
	 * @see #getTransportVFSReconnectTimeout()
	 * @generated
	 */
	void setTransportVFSReconnectTimeout(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Action After Process</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.VFSAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Action After Process</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Action After Process</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
	 * @see #setTransportVFSActionAfterProcess(VFSAction)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSActionAfterProcess()
	 * @model
	 * @generated
	 */
	VFSAction getTransportVFSActionAfterProcess();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterProcess <em>Transport VFS Action After Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Action After Process</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
	 * @see #getTransportVFSActionAfterProcess()
	 * @generated
	 */
	void setTransportVFSActionAfterProcess(VFSAction value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Move After Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Move After Process</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Move After Process</em>' attribute.
	 * @see #setTransportVFSMoveAfterProcess(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMoveAfterProcess()
	 * @model
	 * @generated
	 */
	String getTransportVFSMoveAfterProcess();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterProcess <em>Transport VFS Move After Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Move After Process</em>' attribute.
	 * @see #getTransportVFSMoveAfterProcess()
	 * @generated
	 */
	void setTransportVFSMoveAfterProcess(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Action After Errors</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.VFSAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Action After Errors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Action After Errors</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
	 * @see #setTransportVFSActionAfterErrors(VFSAction)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSActionAfterErrors()
	 * @model
	 * @generated
	 */
	VFSAction getTransportVFSActionAfterErrors();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterErrors <em>Transport VFS Action After Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Action After Errors</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
	 * @see #getTransportVFSActionAfterErrors()
	 * @generated
	 */
	void setTransportVFSActionAfterErrors(VFSAction value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Move After Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Move After Errors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Move After Errors</em>' attribute.
	 * @see #setTransportVFSMoveAfterErrors(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMoveAfterErrors()
	 * @model
	 * @generated
	 */
	String getTransportVFSMoveAfterErrors();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterErrors <em>Transport VFS Move After Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Move After Errors</em>' attribute.
	 * @see #getTransportVFSMoveAfterErrors()
	 * @generated
	 */
	void setTransportVFSMoveAfterErrors(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Action After Failure</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.VFSAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Action After Failure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Action After Failure</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
	 * @see #setTransportVFSActionAfterFailure(VFSAction)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSActionAfterFailure()
	 * @model
	 * @generated
	 */
	VFSAction getTransportVFSActionAfterFailure();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSActionAfterFailure <em>Transport VFS Action After Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Action After Failure</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSAction
	 * @see #getTransportVFSActionAfterFailure()
	 * @generated
	 */
	void setTransportVFSActionAfterFailure(VFSAction value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Move After Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Move After Failure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Move After Failure</em>' attribute.
	 * @see #setTransportVFSMoveAfterFailure(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMoveAfterFailure()
	 * @model
	 * @generated
	 */
	String getTransportVFSMoveAfterFailure();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveAfterFailure <em>Transport VFS Move After Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Move After Failure</em>' attribute.
	 * @see #getTransportVFSMoveAfterFailure()
	 * @generated
	 */
	void setTransportVFSMoveAfterFailure(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Auto Lock Release</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Auto Lock Release</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Auto Lock Release</em>' attribute.
	 * @see #setTransportVFSAutoLockRelease(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSAutoLockRelease()
	 * @model default="true"
	 * @generated
	 */
	boolean isTransportVFSAutoLockRelease();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSAutoLockRelease <em>Transport VFS Auto Lock Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Auto Lock Release</em>' attribute.
	 * @see #isTransportVFSAutoLockRelease()
	 * @generated
	 */
	void setTransportVFSAutoLockRelease(boolean value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Auto Lock Release Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Auto Lock Release Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Auto Lock Release Interval</em>' attribute.
	 * @see #setTransportVFSAutoLockReleaseInterval(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSAutoLockReleaseInterval()
	 * @model
	 * @generated
	 */
	String getTransportVFSAutoLockReleaseInterval();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSAutoLockReleaseInterval <em>Transport VFS Auto Lock Release Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Auto Lock Release Interval</em>' attribute.
	 * @see #getTransportVFSAutoLockReleaseInterval()
	 * @generated
	 */
	void setTransportVFSAutoLockReleaseInterval(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Lock Release Same Node</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Lock Release Same Node</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Lock Release Same Node</em>' attribute.
	 * @see #setTransportVFSLockReleaseSameNode(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSLockReleaseSameNode()
	 * @model default="true"
	 * @generated
	 */
	boolean isTransportVFSLockReleaseSameNode();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSLockReleaseSameNode <em>Transport VFS Lock Release Same Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Lock Release Same Node</em>' attribute.
	 * @see #isTransportVFSLockReleaseSameNode()
	 * @generated
	 */
	void setTransportVFSLockReleaseSameNode(boolean value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Distributed Lock</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Distributed Lock</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Distributed Lock</em>' attribute.
	 * @see #setTransportVFSDistributedLock(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSDistributedLock()
	 * @model default="true"
	 * @generated
	 */
	boolean isTransportVFSDistributedLock();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSDistributedLock <em>Transport VFS Distributed Lock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Distributed Lock</em>' attribute.
	 * @see #isTransportVFSDistributedLock()
	 * @generated
	 */
	void setTransportVFSDistributedLock(boolean value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Streaming</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Streaming</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Streaming</em>' attribute.
	 * @see #setTransportVFSStreaming(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSStreaming()
	 * @model default="false"
	 * @generated
	 */
	boolean isTransportVFSStreaming();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSStreaming <em>Transport VFS Streaming</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Streaming</em>' attribute.
	 * @see #isTransportVFSStreaming()
	 * @generated
	 */
	void setTransportVFSStreaming(boolean value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Build</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Build</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Build</em>' attribute.
	 * @see #setTransportVFSBuild(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSBuild()
	 * @model default="false"
	 * @generated
	 */
	boolean isTransportVFSBuild();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSBuild <em>Transport VFS Build</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Build</em>' attribute.
	 * @see #isTransportVFSBuild()
	 * @generated
	 */
	void setTransportVFSBuild(boolean value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Distributed Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Distributed Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Distributed Timeout</em>' attribute.
	 * @see #setTransportVFSDistributedTimeout(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSDistributedTimeout()
	 * @model
	 * @generated
	 */
	String getTransportVFSDistributedTimeout();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSDistributedTimeout <em>Transport VFS Distributed Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Distributed Timeout</em>' attribute.
	 * @see #getTransportVFSDistributedTimeout()
	 * @generated
	 */
	void setTransportVFSDistributedTimeout(String value);

	/**
	 * Returns the value of the '<em><b>Java Naming Factory Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Naming Factory Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Naming Factory Initial</em>' attribute.
	 * @see #setJavaNamingFactoryInitial(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_JavaNamingFactoryInitial()
	 * @model
	 * @generated
	 */
	String getJavaNamingFactoryInitial();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getJavaNamingFactoryInitial <em>Java Naming Factory Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Naming Factory Initial</em>' attribute.
	 * @see #getJavaNamingFactoryInitial()
	 * @generated
	 */
	void setJavaNamingFactoryInitial(String value);

	/**
	 * Returns the value of the '<em><b>Java Naming Provider Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Naming Provider Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Naming Provider Url</em>' attribute.
	 * @see #setJavaNamingProviderUrl(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_JavaNamingProviderUrl()
	 * @model
	 * @generated
	 */
	String getJavaNamingProviderUrl();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getJavaNamingProviderUrl <em>Java Naming Provider Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Naming Provider Url</em>' attribute.
	 * @see #getJavaNamingProviderUrl()
	 * @generated
	 */
	void setJavaNamingProviderUrl(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Connection Factory JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Connection Factory JNDI Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Connection Factory JNDI Name</em>' attribute.
	 * @see #setTransportJMSConnectionFactoryJNDIName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSConnectionFactoryJNDIName()
	 * @model
	 * @generated
	 */
	String getTransportJMSConnectionFactoryJNDIName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSConnectionFactoryJNDIName <em>Transport JMS Connection Factory JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Connection Factory JNDI Name</em>' attribute.
	 * @see #getTransportJMSConnectionFactoryJNDIName()
	 * @generated
	 */
	void setTransportJMSConnectionFactoryJNDIName(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Connection Factory Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Connection Factory Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Connection Factory Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType
	 * @see #setTransportJMSConnectionFactoryType(JMSConnectionFactoryType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSConnectionFactoryType()
	 * @model
	 * @generated
	 */
	JMSConnectionFactoryType getTransportJMSConnectionFactoryType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSConnectionFactoryType <em>Transport JMS Connection Factory Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Connection Factory Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType
	 * @see #getTransportJMSConnectionFactoryType()
	 * @generated
	 */
	void setTransportJMSConnectionFactoryType(JMSConnectionFactoryType value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Destination</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Destination</em>' attribute.
	 * @see #setTransportJMSDestination(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSDestination()
	 * @model
	 * @generated
	 */
	String getTransportJMSDestination();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDestination <em>Transport JMS Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Destination</em>' attribute.
	 * @see #getTransportJMSDestination()
	 * @generated
	 */
	void setTransportJMSDestination(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Session Transacted</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Session Transacted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Session Transacted</em>' attribute.
	 * @see #setTransportJMSSessionTransacted(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSSessionTransacted()
	 * @model default="true"
	 * @generated
	 */
	boolean isTransportJMSSessionTransacted();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportJMSSessionTransacted <em>Transport JMS Session Transacted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Session Transacted</em>' attribute.
	 * @see #isTransportJMSSessionTransacted()
	 * @generated
	 */
	void setTransportJMSSessionTransacted(boolean value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Session Acknowledgement</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Session Acknowledgement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Session Acknowledgement</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement
	 * @see #setTransportJMSSessionAcknowledgement(JMSSessionAcknowledgement)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSSessionAcknowledgement()
	 * @model
	 * @generated
	 */
	JMSSessionAcknowledgement getTransportJMSSessionAcknowledgement();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSSessionAcknowledgement <em>Transport JMS Session Acknowledgement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Session Acknowledgement</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement
	 * @see #getTransportJMSSessionAcknowledgement()
	 * @generated
	 */
	void setTransportJMSSessionAcknowledgement(JMSSessionAcknowledgement value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Cache Level</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Cache Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Cache Level</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel
	 * @see #setTransportJMSCacheLevel(JMSCacheLevel)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSCacheLevel()
	 * @model
	 * @generated
	 */
	JMSCacheLevel getTransportJMSCacheLevel();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSCacheLevel <em>Transport JMS Cache Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Cache Level</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel
	 * @see #getTransportJMSCacheLevel()
	 * @generated
	 */
	void setTransportJMSCacheLevel(JMSCacheLevel value);

	/**
	 * Returns the value of the '<em><b>Transport JMS User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS User Name</em>' attribute.
	 * @see #setTransportJMSUserName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSUserName()
	 * @model
	 * @generated
	 */
	String getTransportJMSUserName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSUserName <em>Transport JMS User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS User Name</em>' attribute.
	 * @see #getTransportJMSUserName()
	 * @generated
	 */
	void setTransportJMSUserName(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Password</em>' attribute.
	 * @see #setTransportJMSPassword(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSPassword()
	 * @model
	 * @generated
	 */
	String getTransportJMSPassword();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPassword <em>Transport JMS Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Password</em>' attribute.
	 * @see #getTransportJMSPassword()
	 * @generated
	 */
	void setTransportJMSPassword(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMSJMS Spec Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMSJMS Spec Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMSJMS Spec Version</em>' attribute.
	 * @see #setTransportJMSJMSSpecVersion(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSJMSSpecVersion()
	 * @model
	 * @generated
	 */
	String getTransportJMSJMSSpecVersion();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSJMSSpecVersion <em>Transport JMSJMS Spec Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMSJMS Spec Version</em>' attribute.
	 * @see #getTransportJMSJMSSpecVersion()
	 * @generated
	 */
	void setTransportJMSJMSSpecVersion(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Subscription Durable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Subscription Durable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Subscription Durable</em>' attribute.
	 * @see #setTransportJMSSubscriptionDurable(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSSubscriptionDurable()
	 * @model
	 * @generated
	 */
	String getTransportJMSSubscriptionDurable();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSSubscriptionDurable <em>Transport JMS Subscription Durable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Subscription Durable</em>' attribute.
	 * @see #getTransportJMSSubscriptionDurable()
	 * @generated
	 */
	void setTransportJMSSubscriptionDurable(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Durable Subscriber Client ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Durable Subscriber Client ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Durable Subscriber Client ID</em>' attribute.
	 * @see #setTransportJMSDurableSubscriberClientID(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSDurableSubscriberClientID()
	 * @model
	 * @generated
	 */
	String getTransportJMSDurableSubscriberClientID();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSDurableSubscriberClientID <em>Transport JMS Durable Subscriber Client ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Durable Subscriber Client ID</em>' attribute.
	 * @see #getTransportJMSDurableSubscriberClientID()
	 * @generated
	 */
	void setTransportJMSDurableSubscriberClientID(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Message Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Message Selector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Message Selector</em>' attribute.
	 * @see #setTransportJMSMessageSelector(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSMessageSelector()
	 * @model
	 * @generated
	 */
	String getTransportJMSMessageSelector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSMessageSelector <em>Transport JMS Message Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Message Selector</em>' attribute.
	 * @see #getTransportJMSMessageSelector()
	 * @generated
	 */
	void setTransportJMSMessageSelector(String value);

	/**
	 * Returns the value of the '<em><b>Api Dispatching Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Api Dispatching Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Api Dispatching Enabled</em>' attribute.
	 * @see #setApiDispatchingEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_ApiDispatchingEnabled()
	 * @model
	 * @generated
	 */
	boolean isApiDispatchingEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isApiDispatchingEnabled <em>Api Dispatching Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api Dispatching Enabled</em>' attribute.
	 * @see #isApiDispatchingEnabled()
	 * @generated
	 */
	void setApiDispatchingEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Move Timestamp Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Move Timestamp Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Move Timestamp Format</em>' attribute.
	 * @see #setTransportVFSMoveTimestampFormat(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSMoveTimestampFormat()
	 * @model
	 * @generated
	 */
	String getTransportVFSMoveTimestampFormat();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSMoveTimestampFormat <em>Transport VFS Move Timestamp Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Move Timestamp Format</em>' attribute.
	 * @see #getTransportVFSMoveTimestampFormat()
	 * @generated
	 */
	void setTransportVFSMoveTimestampFormat(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS File Sort Attribute</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.VFSFileSort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS File Sort Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS File Sort Attribute</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSFileSort
	 * @see #setTransportVFSFileSortAttribute(VFSFileSort)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileSortAttribute()
	 * @model
	 * @generated
	 */
	VFSFileSort getTransportVFSFileSortAttribute();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSFileSortAttribute <em>Transport VFS File Sort Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS File Sort Attribute</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.VFSFileSort
	 * @see #getTransportVFSFileSortAttribute()
	 * @generated
	 */
	void setTransportVFSFileSortAttribute(VFSFileSort value);

	/**
	 * Returns the value of the '<em><b>Transport VFS File Sort Ascending</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS File Sort Ascending</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS File Sort Ascending</em>' attribute.
	 * @see #setTransportVFSFileSortAscending(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSFileSortAscending()
	 * @model
	 * @generated
	 */
	boolean isTransportVFSFileSortAscending();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSFileSortAscending <em>Transport VFS File Sort Ascending</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS File Sort Ascending</em>' attribute.
	 * @see #isTransportVFSFileSortAscending()
	 * @generated
	 */
	void setTransportVFSFileSortAscending(boolean value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Sub Folder Timestamp Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Sub Folder Timestamp Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Sub Folder Timestamp Format</em>' attribute.
	 * @see #setTransportVFSSubFolderTimestampFormat(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSSubFolderTimestampFormat()
	 * @model
	 * @generated
	 */
	String getTransportVFSSubFolderTimestampFormat();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportVFSSubFolderTimestampFormat <em>Transport VFS Sub Folder Timestamp Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Sub Folder Timestamp Format</em>' attribute.
	 * @see #getTransportVFSSubFolderTimestampFormat()
	 * @generated
	 */
	void setTransportVFSSubFolderTimestampFormat(String value);

	/**
	 * Returns the value of the '<em><b>Transport VFS Create Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport VFS Create Folder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport VFS Create Folder</em>' attribute.
	 * @see #setTransportVFSCreateFolder(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportVFSCreateFolder()
	 * @model
	 * @generated
	 */
	boolean isTransportVFSCreateFolder();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportVFSCreateFolder <em>Transport VFS Create Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport VFS Create Folder</em>' attribute.
	 * @see #isTransportVFSCreateFolder()
	 * @generated
	 */
	void setTransportVFSCreateFolder(boolean value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Receive Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Receive Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Receive Timeout</em>' attribute.
	 * @see #setTransportJMSReceiveTimeout(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSReceiveTimeout()
	 * @model
	 * @generated
	 */
	String getTransportJMSReceiveTimeout();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSReceiveTimeout <em>Transport JMS Receive Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Receive Timeout</em>' attribute.
	 * @see #getTransportJMSReceiveTimeout()
	 * @generated
	 */
	void setTransportJMSReceiveTimeout(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Content Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Content Type</em>' attribute.
	 * @see #setTransportJMSContentType(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSContentType()
	 * @model
	 * @generated
	 */
	String getTransportJMSContentType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSContentType <em>Transport JMS Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Content Type</em>' attribute.
	 * @see #getTransportJMSContentType()
	 * @generated
	 */
	void setTransportJMSContentType(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Content Type Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Content Type Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Content Type Property</em>' attribute.
	 * @see #setTransportJMSContentTypeProperty(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSContentTypeProperty()
	 * @model
	 * @generated
	 */
	String getTransportJMSContentTypeProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSContentTypeProperty <em>Transport JMS Content Type Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Content Type Property</em>' attribute.
	 * @see #getTransportJMSContentTypeProperty()
	 * @generated
	 */
	void setTransportJMSContentTypeProperty(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Reply Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Reply Destination</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Reply Destination</em>' attribute.
	 * @see #setTransportJMSReplyDestination(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSReplyDestination()
	 * @model
	 * @generated
	 */
	String getTransportJMSReplyDestination();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSReplyDestination <em>Transport JMS Reply Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Reply Destination</em>' attribute.
	 * @see #getTransportJMSReplyDestination()
	 * @generated
	 */
	void setTransportJMSReplyDestination(String value);

	/**
	 * Returns the value of the '<em><b>Transport JMS Pub Sub No Local</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport JMS Pub Sub No Local</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport JMS Pub Sub No Local</em>' attribute.
	 * @see #setTransportJMSPubSubNoLocal(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportJMSPubSubNoLocal()
	 * @model
	 * @generated
	 */
	String getTransportJMSPubSubNoLocal();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportJMSPubSubNoLocal <em>Transport JMS Pub Sub No Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport JMS Pub Sub No Local</em>' attribute.
	 * @see #getTransportJMSPubSubNoLocal()
	 * @generated
	 */
	void setTransportJMSPubSubNoLocal(String value);

	/**
	 * Returns the value of the '<em><b>Transport MQTT Connection Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport MQTT Connection Factory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport MQTT Connection Factory</em>' attribute.
	 * @see #setTransportMQTTConnectionFactory(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTConnectionFactory()
	 * @model
	 * @generated
	 */
	String getTransportMQTTConnectionFactory();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTConnectionFactory <em>Transport MQTT Connection Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport MQTT Connection Factory</em>' attribute.
	 * @see #getTransportMQTTConnectionFactory()
	 * @generated
	 */
	void setTransportMQTTConnectionFactory(String value);

	/**
	 * Returns the value of the '<em><b>Transport MQTT Server Host Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport MQTT Server Host Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport MQTT Server Host Name</em>' attribute.
	 * @see #setTransportMQTTServerHostName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTServerHostName()
	 * @model
	 * @generated
	 */
	String getTransportMQTTServerHostName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTServerHostName <em>Transport MQTT Server Host Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport MQTT Server Host Name</em>' attribute.
	 * @see #getTransportMQTTServerHostName()
	 * @generated
	 */
	void setTransportMQTTServerHostName(String value);

	/**
	 * Returns the value of the '<em><b>Transport MQTT Server Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport MQTT Server Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport MQTT Server Port</em>' attribute.
	 * @see #setTransportMQTTServerPort(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTServerPort()
	 * @model
	 * @generated
	 */
	String getTransportMQTTServerPort();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTServerPort <em>Transport MQTT Server Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport MQTT Server Port</em>' attribute.
	 * @see #getTransportMQTTServerPort()
	 * @generated
	 */
	void setTransportMQTTServerPort(String value);

	/**
	 * Returns the value of the '<em><b>Transport MQTT Topic Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport MQTT Topic Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport MQTT Topic Name</em>' attribute.
	 * @see #setTransportMQTTTopicName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTTopicName()
	 * @model
	 * @generated
	 */
	String getTransportMQTTTopicName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTTopicName <em>Transport MQTT Topic Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport MQTT Topic Name</em>' attribute.
	 * @see #getTransportMQTTTopicName()
	 * @generated
	 */
	void setTransportMQTTTopicName(String value);

	/**
	 * Returns the value of the '<em><b>Transport MQTT Subscription QOS</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.MQTTSubscriptionQOS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport MQTT Subscription QOS</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport MQTT Subscription QOS</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.MQTTSubscriptionQOS
	 * @see #setTransportMQTTSubscriptionQOS(MQTTSubscriptionQOS)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSubscriptionQOS()
	 * @model
	 * @generated
	 */
	MQTTSubscriptionQOS getTransportMQTTSubscriptionQOS();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionQOS <em>Transport MQTT Subscription QOS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport MQTT Subscription QOS</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.MQTTSubscriptionQOS
	 * @see #getTransportMQTTSubscriptionQOS()
	 * @generated
	 */
	void setTransportMQTTSubscriptionQOS(MQTTSubscriptionQOS value);

	/**
	 * Returns the value of the '<em><b>Transport MQTT Session Clean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport MQTT Session Clean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport MQTT Session Clean</em>' attribute.
	 * @see #setTransportMQTTSessionClean(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSessionClean()
	 * @model
	 * @generated
	 */
	boolean isTransportMQTTSessionClean();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#isTransportMQTTSessionClean <em>Transport MQTT Session Clean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport MQTT Session Clean</em>' attribute.
	 * @see #isTransportMQTTSessionClean()
	 * @generated
	 */
	void setTransportMQTTSessionClean(boolean value);

	/**
	 * Returns the value of the '<em><b>Transport MQTT Ssl Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport MQTT Ssl Enable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport MQTT Ssl Enable</em>' attribute.
	 * @see #setTransportMQTTSslEnable(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSslEnable()
	 * @model
	 * @generated
	 */
	String getTransportMQTTSslEnable();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSslEnable <em>Transport MQTT Ssl Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport MQTT Ssl Enable</em>' attribute.
	 * @see #getTransportMQTTSslEnable()
	 * @generated
	 */
	void setTransportMQTTSslEnable(String value);

	/**
	 * Returns the value of the '<em><b>Transport MQTT Temporary Store Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport MQTT Temporary Store Directory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport MQTT Temporary Store Directory</em>' attribute.
	 * @see #setTransportMQTTTemporaryStoreDirectory(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTTemporaryStoreDirectory()
	 * @model
	 * @generated
	 */
	String getTransportMQTTTemporaryStoreDirectory();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTTemporaryStoreDirectory <em>Transport MQTT Temporary Store Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport MQTT Temporary Store Directory</em>' attribute.
	 * @see #getTransportMQTTTemporaryStoreDirectory()
	 * @generated
	 */
	void setTransportMQTTTemporaryStoreDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Transport MQTT Subscription Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport MQTT Subscription Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport MQTT Subscription Username</em>' attribute.
	 * @see #setTransportMQTTSubscriptionUsername(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSubscriptionUsername()
	 * @model
	 * @generated
	 */
	String getTransportMQTTSubscriptionUsername();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionUsername <em>Transport MQTT Subscription Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport MQTT Subscription Username</em>' attribute.
	 * @see #getTransportMQTTSubscriptionUsername()
	 * @generated
	 */
	void setTransportMQTTSubscriptionUsername(String value);

	/**
	 * Returns the value of the '<em><b>Transport MQTT Subscription Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport MQTT Subscription Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport MQTT Subscription Password</em>' attribute.
	 * @see #setTransportMQTTSubscriptionPassword(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTSubscriptionPassword()
	 * @model
	 * @generated
	 */
	String getTransportMQTTSubscriptionPassword();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTSubscriptionPassword <em>Transport MQTT Subscription Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport MQTT Subscription Password</em>' attribute.
	 * @see #getTransportMQTTSubscriptionPassword()
	 * @generated
	 */
	void setTransportMQTTSubscriptionPassword(String value);

	/**
	 * Returns the value of the '<em><b>Transport MQTT Client Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport MQTT Client Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport MQTT Client Id</em>' attribute.
	 * @see #setTransportMQTTClientId(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_TransportMQTTClientId()
	 * @model
	 * @generated
	 */
	String getTransportMQTTClientId();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTransportMQTTClientId <em>Transport MQTT Client Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport MQTT Client Id</em>' attribute.
	 * @see #getTransportMQTTClientId()
	 * @generated
	 */
	void setTransportMQTTClientId(String value);

	/**
	 * Returns the value of the '<em><b>Truststore</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Truststore</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Truststore</em>' attribute.
	 * @see #setTruststore(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Truststore()
	 * @model
	 * @generated
	 */
	String getTruststore();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getTruststore <em>Truststore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Truststore</em>' attribute.
	 * @see #getTruststore()
	 * @generated
	 */
	void setTruststore(String value);

	/**
	 * Returns the value of the '<em><b>Keystore</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keystore</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keystore</em>' attribute.
	 * @see #setKeystore(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_Keystore()
	 * @model
	 * @generated
	 */
	String getKeystore();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getKeystore <em>Keystore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keystore</em>' attribute.
	 * @see #getKeystore()
	 * @generated
	 */
	void setKeystore(String value);

	/**
	 * Returns the value of the '<em><b>Ssl Verify Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ssl Verify Client</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ssl Verify Client</em>' attribute.
	 * @see #setSslVerifyClient(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SslVerifyClient()
	 * @model
	 * @generated
	 */
	String getSslVerifyClient();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSslVerifyClient <em>Ssl Verify Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ssl Verify Client</em>' attribute.
	 * @see #getSslVerifyClient()
	 * @generated
	 */
	void setSslVerifyClient(String value);

	/**
	 * Returns the value of the '<em><b>Ssl Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ssl Protocol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ssl Protocol</em>' attribute.
	 * @see #setSslProtocol(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_SslProtocol()
	 * @model
	 * @generated
	 */
	String getSslProtocol();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getSslProtocol <em>Ssl Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ssl Protocol</em>' attribute.
	 * @see #getSslProtocol()
	 * @generated
	 */
	void setSslProtocol(String value);

	/**
	 * Returns the value of the '<em><b>Https Protocols</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Https Protocols</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Https Protocols</em>' attribute.
	 * @see #setHttpsProtocols(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_HttpsProtocols()
	 * @model
	 * @generated
	 */
	String getHttpsProtocols();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getHttpsProtocols <em>Https Protocols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Https Protocols</em>' attribute.
	 * @see #getHttpsProtocols()
	 * @generated
	 */
	void setHttpsProtocols(String value);

	/**
	 * Returns the value of the '<em><b>Certificate Revocation Verifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Certificate Revocation Verifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Certificate Revocation Verifier</em>' attribute.
	 * @see #setCertificateRevocationVerifier(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpoint_CertificateRevocationVerifier()
	 * @model
	 * @generated
	 */
	String getCertificateRevocationVerifier();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint#getCertificateRevocationVerifier <em>Certificate Revocation Verifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Certificate Revocation Verifier</em>' attribute.
	 * @see #getCertificateRevocationVerifier()
	 * @generated
	 */
	void setCertificateRevocationVerifier(String value);

} // InboundEndpoint
