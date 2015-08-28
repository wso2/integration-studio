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
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.gmf.esb.ConsumerType;
import org.wso2.developerstudio.eclipse.gmf.esb.ContentType;
import org.wso2.developerstudio.eclipse.gmf.esb.Enable;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointOnErrorSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointOnErrorSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement;
import org.wso2.developerstudio.eclipse.gmf.esb.MQTTSubscriptionQOS;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.VFSAction;
import org.wso2.developerstudio.eclipse.gmf.esb.VFSFileSort;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inbound Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSequenceInputConnector <em>Sequence Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSequenceOutputConnector <em>Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getOnErrorSequenceInputConnector <em>On Error Sequence Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getOnErrorSequenceOutputConnector <em>On Error Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundHttpPort <em>Inbound Http Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundWorkerPoolSizeCore <em>Inbound Worker Pool Size Core</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundWorkerPoolSizeMax <em>Inbound Worker Pool Size Max</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundWorkerThreadKeepAliveSec <em>Inbound Worker Thread Keep Alive Sec</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundWorkerPoolQueueLength <em>Inbound Worker Pool Queue Length</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundThreadGroupId <em>Inbound Thread Group Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundThreadId <em>Inbound Thread Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getDispatchFilterPattern <em>Dispatch Filter Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInterval <em>Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isSequential <em>Sequential</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isCoordination <em>Coordination</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSFileURI <em>Transport VFS File URI</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSContentType <em>Transport VFS Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSFileNamePattern <em>Transport VFS File Name Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSFileProcessInterval <em>Transport VFS File Process Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSFileProcessCount <em>Transport VFS File Process Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSLocking <em>Transport VFS Locking</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSMaxRetryCount <em>Transport VFS Max Retry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSReconnectTimeout <em>Transport VFS Reconnect Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSActionAfterProcess <em>Transport VFS Action After Process</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSMoveAfterProcess <em>Transport VFS Move After Process</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSActionAfterErrors <em>Transport VFS Action After Errors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSMoveAfterErrors <em>Transport VFS Move After Errors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSActionAfterFailure <em>Transport VFS Action After Failure</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSMoveAfterFailure <em>Transport VFS Move After Failure</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isTransportVFSAutoLockRelease <em>Transport VFS Auto Lock Release</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSAutoLockReleaseInterval <em>Transport VFS Auto Lock Release Interval</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isTransportVFSLockReleaseSameNode <em>Transport VFS Lock Release Same Node</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isTransportVFSDistributedLock <em>Transport VFS Distributed Lock</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isTransportVFSStreaming <em>Transport VFS Streaming</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isTransportVFSBuild <em>Transport VFS Build</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSDistributedTimeout <em>Transport VFS Distributed Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getJavaNamingFactoryInitial <em>Java Naming Factory Initial</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getJavaNamingProviderUrl <em>Java Naming Provider Url</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSConnectionFactoryJNDIName <em>Transport JMS Connection Factory JNDI Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSConnectionFactoryType <em>Transport JMS Connection Factory Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSDestination <em>Transport JMS Destination</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isTransportJMSSessionTransacted <em>Transport JMS Session Transacted</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSSessionAcknowledgement <em>Transport JMS Session Acknowledgement</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSCacheLevel <em>Transport JMS Cache Level</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSUserName <em>Transport JMS User Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSPassword <em>Transport JMS Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSJMSSpecVersion <em>Transport JMSJMS Spec Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSSubscriptionDurable <em>Transport JMS Subscription Durable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSDurableSubscriberClientID <em>Transport JMS Durable Subscriber Client ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSMessageSelector <em>Transport JMS Message Selector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isApiDispatchingEnabled <em>Api Dispatching Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSMoveTimestampFormat <em>Transport VFS Move Timestamp Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSFileSortAttribute <em>Transport VFS File Sort Attribute</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isTransportVFSFileSortAscending <em>Transport VFS File Sort Ascending</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportVFSSubFolderTimestampFormat <em>Transport VFS Sub Folder Timestamp Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isTransportVFSCreateFolder <em>Transport VFS Create Folder</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSReceiveTimeout <em>Transport JMS Receive Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSContentType <em>Transport JMS Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSContentTypeProperty <em>Transport JMS Content Type Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSReplyDestination <em>Transport JMS Reply Destination</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportJMSPubSubNoLocal <em>Transport JMS Pub Sub No Local</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportMQTTConnectionFactory <em>Transport MQTT Connection Factory</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportMQTTServerHostName <em>Transport MQTT Server Host Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportMQTTServerPort <em>Transport MQTT Server Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportMQTTTopicName <em>Transport MQTT Topic Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportMQTTSubscriptionQOS <em>Transport MQTT Subscription QOS</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isTransportMQTTSessionClean <em>Transport MQTT Session Clean</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportMQTTSslEnable <em>Transport MQTT Ssl Enable</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportMQTTTemporaryStoreDirectory <em>Transport MQTT Temporary Store Directory</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportMQTTSubscriptionUsername <em>Transport MQTT Subscription Username</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportMQTTSubscriptionPassword <em>Transport MQTT Subscription Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTransportMQTTClientId <em>Transport MQTT Client Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTruststore <em>Truststore</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getKeystore <em>Keystore</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSslVerifyClient <em>Ssl Verify Client</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSslProtocol <em>Ssl Protocol</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getHttpsProtocols <em>Https Protocols</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getCertificateRevocationVerifier <em>Certificate Revocation Verifier</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundHL7Port <em>Inbound HL7 Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isInboundHL7AutoAck <em>Inbound HL7 Auto Ack</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundHL7MessagePreProcessor <em>Inbound HL7 Message Pre Processor</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundHL7CharSet <em>Inbound HL7 Char Set</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundHL7TimeOut <em>Inbound HL7 Time Out</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isInboundHL7ValidateMessage <em>Inbound HL7 Validate Message</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundHL7BuildInvalidMessages <em>Inbound HL7 Build Invalid Messages</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundHL7PassThroughInvalidMessages <em>Inbound HL7 Pass Through Invalid Messages</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getZookeeperConnect <em>Zookeeper Connect</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getConsumerType <em>Consumer Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTopics <em>Topics</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSimpleTopic <em>Simple Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSimpleBrokers <em>Simple Brokers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSimplePort <em>Simple Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSimplePartition <em>Simple Partition</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSimpleMaxMessagesToRead <em>Simple Max Messages To Read</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getThreadCount <em>Thread Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getZookeeperSessionTimeoutMs <em>Zookeeper Session Timeout Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getZookeeperSyncTimeMs <em>Zookeeper Sync Time Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getAutoCommitIntervalMs <em>Auto Commit Interval Ms</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getAutoOffsetReset <em>Auto Offset Reset</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundCxfRmHost <em>Inbound Cxf Rm Host</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundCxfRmPort <em>Inbound Cxf Rm Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getInboundCxfRmConfigFile <em>Inbound Cxf Rm Config File</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isEnableSSL <em>Enable SSL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getServiceParameters <em>Service Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#isSuspend <em>Suspend</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InboundEndpointImpl extends EsbElementImpl implements InboundEndpoint {
	/**
	 * The cached value of the '{@link #getSequenceInputConnector() <em>Sequence Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceInputConnector()
	 * @generated
	 * @ordered
	 */
	protected InboundEndpointSequenceInputConnector sequenceInputConnector;

	/**
	 * The cached value of the '{@link #getSequenceOutputConnector() <em>Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected InboundEndpointSequenceOutputConnector sequenceOutputConnector;

	/**
	 * The cached value of the '{@link #getOnErrorSequenceInputConnector() <em>On Error Sequence Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnErrorSequenceInputConnector()
	 * @generated
	 * @ordered
	 */
	protected InboundEndpointOnErrorSequenceInputConnector onErrorSequenceInputConnector;

	/**
	 * The cached value of the '{@link #getOnErrorSequenceOutputConnector() <em>On Error Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnErrorSequenceOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected InboundEndpointOnErrorSequenceOutputConnector onErrorSequenceOutputConnector;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected InboundEndpointContainer container;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final InboundEndpointType TYPE_EDEFAULT = InboundEndpointType.HTTP;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected InboundEndpointType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected String class_ = CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final String PROTOCOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected String protocol = PROTOCOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundHttpPort() <em>Inbound Http Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHttpPort()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_HTTP_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundHttpPort() <em>Inbound Http Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHttpPort()
	 * @generated
	 * @ordered
	 */
	protected String inboundHttpPort = INBOUND_HTTP_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundWorkerPoolSizeCore() <em>Inbound Worker Pool Size Core</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundWorkerPoolSizeCore()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_WORKER_POOL_SIZE_CORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundWorkerPoolSizeCore() <em>Inbound Worker Pool Size Core</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundWorkerPoolSizeCore()
	 * @generated
	 * @ordered
	 */
	protected String inboundWorkerPoolSizeCore = INBOUND_WORKER_POOL_SIZE_CORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundWorkerPoolSizeMax() <em>Inbound Worker Pool Size Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundWorkerPoolSizeMax()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_WORKER_POOL_SIZE_MAX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundWorkerPoolSizeMax() <em>Inbound Worker Pool Size Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundWorkerPoolSizeMax()
	 * @generated
	 * @ordered
	 */
	protected String inboundWorkerPoolSizeMax = INBOUND_WORKER_POOL_SIZE_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundWorkerThreadKeepAliveSec() <em>Inbound Worker Thread Keep Alive Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundWorkerThreadKeepAliveSec()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundWorkerThreadKeepAliveSec() <em>Inbound Worker Thread Keep Alive Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundWorkerThreadKeepAliveSec()
	 * @generated
	 * @ordered
	 */
	protected String inboundWorkerThreadKeepAliveSec = INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundWorkerPoolQueueLength() <em>Inbound Worker Pool Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundWorkerPoolQueueLength()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_WORKER_POOL_QUEUE_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundWorkerPoolQueueLength() <em>Inbound Worker Pool Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundWorkerPoolQueueLength()
	 * @generated
	 * @ordered
	 */
	protected String inboundWorkerPoolQueueLength = INBOUND_WORKER_POOL_QUEUE_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundThreadGroupId() <em>Inbound Thread Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundThreadGroupId()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_THREAD_GROUP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundThreadGroupId() <em>Inbound Thread Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundThreadGroupId()
	 * @generated
	 * @ordered
	 */
	protected String inboundThreadGroupId = INBOUND_THREAD_GROUP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundThreadId() <em>Inbound Thread Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundThreadId()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_THREAD_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundThreadId() <em>Inbound Thread Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundThreadId()
	 * @generated
	 * @ordered
	 */
	protected String inboundThreadId = INBOUND_THREAD_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDispatchFilterPattern() <em>Dispatch Filter Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDispatchFilterPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPATCH_FILTER_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDispatchFilterPattern() <em>Dispatch Filter Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDispatchFilterPattern()
	 * @generated
	 * @ordered
	 */
	protected String dispatchFilterPattern = DISPATCH_FILTER_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterval() <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInterval() <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterval()
	 * @generated
	 * @ordered
	 */
	protected String interval = INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isSequential() <em>Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequential()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SEQUENTIAL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isSequential() <em>Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequential()
	 * @generated
	 * @ordered
	 */
	protected boolean sequential = SEQUENTIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isCoordination() <em>Coordination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCoordination()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COORDINATION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCoordination() <em>Coordination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCoordination()
	 * @generated
	 * @ordered
	 */
	protected boolean coordination = COORDINATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSFileURI() <em>Transport VFS File URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSFileURI()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_FILE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSFileURI() <em>Transport VFS File URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSFileURI()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSFileURI = TRANSPORT_VFS_FILE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSContentType() <em>Transport VFS Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSContentType()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_CONTENT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSContentType() <em>Transport VFS Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSContentType()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSContentType = TRANSPORT_VFS_CONTENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSFileNamePattern() <em>Transport VFS File Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSFileNamePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_FILE_NAME_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSFileNamePattern() <em>Transport VFS File Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSFileNamePattern()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSFileNamePattern = TRANSPORT_VFS_FILE_NAME_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSFileProcessInterval() <em>Transport VFS File Process Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSFileProcessInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_FILE_PROCESS_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSFileProcessInterval() <em>Transport VFS File Process Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSFileProcessInterval()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSFileProcessInterval = TRANSPORT_VFS_FILE_PROCESS_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSFileProcessCount() <em>Transport VFS File Process Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSFileProcessCount()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_FILE_PROCESS_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSFileProcessCount() <em>Transport VFS File Process Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSFileProcessCount()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSFileProcessCount = TRANSPORT_VFS_FILE_PROCESS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSLocking() <em>Transport VFS Locking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSLocking()
	 * @generated
	 * @ordered
	 */
	protected static final Enable TRANSPORT_VFS_LOCKING_EDEFAULT = Enable.ENABLE;

	/**
	 * The cached value of the '{@link #getTransportVFSLocking() <em>Transport VFS Locking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSLocking()
	 * @generated
	 * @ordered
	 */
	protected Enable transportVFSLocking = TRANSPORT_VFS_LOCKING_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSMaxRetryCount() <em>Transport VFS Max Retry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSMaxRetryCount()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_MAX_RETRY_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSMaxRetryCount() <em>Transport VFS Max Retry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSMaxRetryCount()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSMaxRetryCount = TRANSPORT_VFS_MAX_RETRY_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSReconnectTimeout() <em>Transport VFS Reconnect Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSReconnectTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_RECONNECT_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSReconnectTimeout() <em>Transport VFS Reconnect Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSReconnectTimeout()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSReconnectTimeout = TRANSPORT_VFS_RECONNECT_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSActionAfterProcess() <em>Transport VFS Action After Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSActionAfterProcess()
	 * @generated
	 * @ordered
	 */
	protected static final VFSAction TRANSPORT_VFS_ACTION_AFTER_PROCESS_EDEFAULT = VFSAction.NONE;

	/**
	 * The cached value of the '{@link #getTransportVFSActionAfterProcess() <em>Transport VFS Action After Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSActionAfterProcess()
	 * @generated
	 * @ordered
	 */
	protected VFSAction transportVFSActionAfterProcess = TRANSPORT_VFS_ACTION_AFTER_PROCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSMoveAfterProcess() <em>Transport VFS Move After Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSMoveAfterProcess()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_MOVE_AFTER_PROCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSMoveAfterProcess() <em>Transport VFS Move After Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSMoveAfterProcess()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSMoveAfterProcess = TRANSPORT_VFS_MOVE_AFTER_PROCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSActionAfterErrors() <em>Transport VFS Action After Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSActionAfterErrors()
	 * @generated
	 * @ordered
	 */
	protected static final VFSAction TRANSPORT_VFS_ACTION_AFTER_ERRORS_EDEFAULT = VFSAction.NONE;

	/**
	 * The cached value of the '{@link #getTransportVFSActionAfterErrors() <em>Transport VFS Action After Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSActionAfterErrors()
	 * @generated
	 * @ordered
	 */
	protected VFSAction transportVFSActionAfterErrors = TRANSPORT_VFS_ACTION_AFTER_ERRORS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSMoveAfterErrors() <em>Transport VFS Move After Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSMoveAfterErrors()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_MOVE_AFTER_ERRORS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSMoveAfterErrors() <em>Transport VFS Move After Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSMoveAfterErrors()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSMoveAfterErrors = TRANSPORT_VFS_MOVE_AFTER_ERRORS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSActionAfterFailure() <em>Transport VFS Action After Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSActionAfterFailure()
	 * @generated
	 * @ordered
	 */
	protected static final VFSAction TRANSPORT_VFS_ACTION_AFTER_FAILURE_EDEFAULT = VFSAction.NONE;

	/**
	 * The cached value of the '{@link #getTransportVFSActionAfterFailure() <em>Transport VFS Action After Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSActionAfterFailure()
	 * @generated
	 * @ordered
	 */
	protected VFSAction transportVFSActionAfterFailure = TRANSPORT_VFS_ACTION_AFTER_FAILURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSMoveAfterFailure() <em>Transport VFS Move After Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSMoveAfterFailure()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_MOVE_AFTER_FAILURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSMoveAfterFailure() <em>Transport VFS Move After Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSMoveAfterFailure()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSMoveAfterFailure = TRANSPORT_VFS_MOVE_AFTER_FAILURE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransportVFSAutoLockRelease() <em>Transport VFS Auto Lock Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSAutoLockRelease()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSPORT_VFS_AUTO_LOCK_RELEASE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTransportVFSAutoLockRelease() <em>Transport VFS Auto Lock Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSAutoLockRelease()
	 * @generated
	 * @ordered
	 */
	protected boolean transportVFSAutoLockRelease = TRANSPORT_VFS_AUTO_LOCK_RELEASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSAutoLockReleaseInterval() <em>Transport VFS Auto Lock Release Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSAutoLockReleaseInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSAutoLockReleaseInterval() <em>Transport VFS Auto Lock Release Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSAutoLockReleaseInterval()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSAutoLockReleaseInterval = TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransportVFSLockReleaseSameNode() <em>Transport VFS Lock Release Same Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSLockReleaseSameNode()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTransportVFSLockReleaseSameNode() <em>Transport VFS Lock Release Same Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSLockReleaseSameNode()
	 * @generated
	 * @ordered
	 */
	protected boolean transportVFSLockReleaseSameNode = TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransportVFSDistributedLock() <em>Transport VFS Distributed Lock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSDistributedLock()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSPORT_VFS_DISTRIBUTED_LOCK_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTransportVFSDistributedLock() <em>Transport VFS Distributed Lock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSDistributedLock()
	 * @generated
	 * @ordered
	 */
	protected boolean transportVFSDistributedLock = TRANSPORT_VFS_DISTRIBUTED_LOCK_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransportVFSStreaming() <em>Transport VFS Streaming</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSStreaming()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSPORT_VFS_STREAMING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransportVFSStreaming() <em>Transport VFS Streaming</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSStreaming()
	 * @generated
	 * @ordered
	 */
	protected boolean transportVFSStreaming = TRANSPORT_VFS_STREAMING_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransportVFSBuild() <em>Transport VFS Build</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSBuild()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSPORT_VFS_BUILD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransportVFSBuild() <em>Transport VFS Build</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSBuild()
	 * @generated
	 * @ordered
	 */
	protected boolean transportVFSBuild = TRANSPORT_VFS_BUILD_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSDistributedTimeout() <em>Transport VFS Distributed Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSDistributedTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_DISTRIBUTED_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSDistributedTimeout() <em>Transport VFS Distributed Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSDistributedTimeout()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSDistributedTimeout = TRANSPORT_VFS_DISTRIBUTED_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getJavaNamingFactoryInitial() <em>Java Naming Factory Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaNamingFactoryInitial()
	 * @generated
	 * @ordered
	 */
	protected static final String JAVA_NAMING_FACTORY_INITIAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJavaNamingFactoryInitial() <em>Java Naming Factory Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaNamingFactoryInitial()
	 * @generated
	 * @ordered
	 */
	protected String javaNamingFactoryInitial = JAVA_NAMING_FACTORY_INITIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getJavaNamingProviderUrl() <em>Java Naming Provider Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaNamingProviderUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String JAVA_NAMING_PROVIDER_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJavaNamingProviderUrl() <em>Java Naming Provider Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaNamingProviderUrl()
	 * @generated
	 * @ordered
	 */
	protected String javaNamingProviderUrl = JAVA_NAMING_PROVIDER_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSConnectionFactoryJNDIName() <em>Transport JMS Connection Factory JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSConnectionFactoryJNDIName()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSConnectionFactoryJNDIName() <em>Transport JMS Connection Factory JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSConnectionFactoryJNDIName()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSConnectionFactoryJNDIName = TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSConnectionFactoryType() <em>Transport JMS Connection Factory Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSConnectionFactoryType()
	 * @generated
	 * @ordered
	 */
	protected static final JMSConnectionFactoryType TRANSPORT_JMS_CONNECTION_FACTORY_TYPE_EDEFAULT = JMSConnectionFactoryType.TOPIC;

	/**
	 * The cached value of the '{@link #getTransportJMSConnectionFactoryType() <em>Transport JMS Connection Factory Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSConnectionFactoryType()
	 * @generated
	 * @ordered
	 */
	protected JMSConnectionFactoryType transportJMSConnectionFactoryType = TRANSPORT_JMS_CONNECTION_FACTORY_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSDestination() <em>Transport JMS Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSDestination()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_DESTINATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSDestination() <em>Transport JMS Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSDestination()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSDestination = TRANSPORT_JMS_DESTINATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransportJMSSessionTransacted() <em>Transport JMS Session Transacted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportJMSSessionTransacted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSPORT_JMS_SESSION_TRANSACTED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTransportJMSSessionTransacted() <em>Transport JMS Session Transacted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportJMSSessionTransacted()
	 * @generated
	 * @ordered
	 */
	protected boolean transportJMSSessionTransacted = TRANSPORT_JMS_SESSION_TRANSACTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSSessionAcknowledgement() <em>Transport JMS Session Acknowledgement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSSessionAcknowledgement()
	 * @generated
	 * @ordered
	 */
	protected static final JMSSessionAcknowledgement TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT_EDEFAULT = JMSSessionAcknowledgement.AUTO_ACKNOWLEDGE;

	/**
	 * The cached value of the '{@link #getTransportJMSSessionAcknowledgement() <em>Transport JMS Session Acknowledgement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSSessionAcknowledgement()
	 * @generated
	 * @ordered
	 */
	protected JMSSessionAcknowledgement transportJMSSessionAcknowledgement = TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSCacheLevel() <em>Transport JMS Cache Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSCacheLevel()
	 * @generated
	 * @ordered
	 */
	protected static final JMSCacheLevel TRANSPORT_JMS_CACHE_LEVEL_EDEFAULT = JMSCacheLevel.ONE;

	/**
	 * The cached value of the '{@link #getTransportJMSCacheLevel() <em>Transport JMS Cache Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSCacheLevel()
	 * @generated
	 * @ordered
	 */
	protected JMSCacheLevel transportJMSCacheLevel = TRANSPORT_JMS_CACHE_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSUserName() <em>Transport JMS User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_USER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSUserName() <em>Transport JMS User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSUserName()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSUserName = TRANSPORT_JMS_USER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSPassword() <em>Transport JMS Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSPassword() <em>Transport JMS Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSPassword()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSPassword = TRANSPORT_JMS_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSJMSSpecVersion() <em>Transport JMSJMS Spec Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSJMSSpecVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMSJMS_SPEC_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSJMSSpecVersion() <em>Transport JMSJMS Spec Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSJMSSpecVersion()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSJMSSpecVersion = TRANSPORT_JMSJMS_SPEC_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSSubscriptionDurable() <em>Transport JMS Subscription Durable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSSubscriptionDurable()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_SUBSCRIPTION_DURABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSSubscriptionDurable() <em>Transport JMS Subscription Durable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSSubscriptionDurable()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSSubscriptionDurable = TRANSPORT_JMS_SUBSCRIPTION_DURABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSDurableSubscriberClientID() <em>Transport JMS Durable Subscriber Client ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSDurableSubscriberClientID()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSDurableSubscriberClientID() <em>Transport JMS Durable Subscriber Client ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSDurableSubscriberClientID()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSDurableSubscriberClientID = TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSMessageSelector() <em>Transport JMS Message Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSMessageSelector()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_MESSAGE_SELECTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSMessageSelector() <em>Transport JMS Message Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSMessageSelector()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSMessageSelector = TRANSPORT_JMS_MESSAGE_SELECTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #isApiDispatchingEnabled() <em>Api Dispatching Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isApiDispatchingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean API_DISPATCHING_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isApiDispatchingEnabled() <em>Api Dispatching Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isApiDispatchingEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean apiDispatchingEnabled = API_DISPATCHING_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSMoveTimestampFormat() <em>Transport VFS Move Timestamp Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSMoveTimestampFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSMoveTimestampFormat() <em>Transport VFS Move Timestamp Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSMoveTimestampFormat()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSMoveTimestampFormat = TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSFileSortAttribute() <em>Transport VFS File Sort Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSFileSortAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final VFSFileSort TRANSPORT_VFS_FILE_SORT_ATTRIBUTE_EDEFAULT = VFSFileSort.NONE;

	/**
	 * The cached value of the '{@link #getTransportVFSFileSortAttribute() <em>Transport VFS File Sort Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSFileSortAttribute()
	 * @generated
	 * @ordered
	 */
	protected VFSFileSort transportVFSFileSortAttribute = TRANSPORT_VFS_FILE_SORT_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransportVFSFileSortAscending() <em>Transport VFS File Sort Ascending</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSFileSortAscending()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSPORT_VFS_FILE_SORT_ASCENDING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransportVFSFileSortAscending() <em>Transport VFS File Sort Ascending</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSFileSortAscending()
	 * @generated
	 * @ordered
	 */
	protected boolean transportVFSFileSortAscending = TRANSPORT_VFS_FILE_SORT_ASCENDING_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportVFSSubFolderTimestampFormat() <em>Transport VFS Sub Folder Timestamp Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSSubFolderTimestampFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportVFSSubFolderTimestampFormat() <em>Transport VFS Sub Folder Timestamp Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportVFSSubFolderTimestampFormat()
	 * @generated
	 * @ordered
	 */
	protected String transportVFSSubFolderTimestampFormat = TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransportVFSCreateFolder() <em>Transport VFS Create Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSCreateFolder()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSPORT_VFS_CREATE_FOLDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransportVFSCreateFolder() <em>Transport VFS Create Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportVFSCreateFolder()
	 * @generated
	 * @ordered
	 */
	protected boolean transportVFSCreateFolder = TRANSPORT_VFS_CREATE_FOLDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSReceiveTimeout() <em>Transport JMS Receive Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSReceiveTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_RECEIVE_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSReceiveTimeout() <em>Transport JMS Receive Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSReceiveTimeout()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSReceiveTimeout = TRANSPORT_JMS_RECEIVE_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSContentType() <em>Transport JMS Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSContentType()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_CONTENT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSContentType() <em>Transport JMS Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSContentType()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSContentType = TRANSPORT_JMS_CONTENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSContentTypeProperty() <em>Transport JMS Content Type Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSContentTypeProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_CONTENT_TYPE_PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSContentTypeProperty() <em>Transport JMS Content Type Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSContentTypeProperty()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSContentTypeProperty = TRANSPORT_JMS_CONTENT_TYPE_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSReplyDestination() <em>Transport JMS Reply Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSReplyDestination()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_REPLY_DESTINATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSReplyDestination() <em>Transport JMS Reply Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSReplyDestination()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSReplyDestination = TRANSPORT_JMS_REPLY_DESTINATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportJMSPubSubNoLocal() <em>Transport JMS Pub Sub No Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSPubSubNoLocal()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_JMS_PUB_SUB_NO_LOCAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportJMSPubSubNoLocal() <em>Transport JMS Pub Sub No Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportJMSPubSubNoLocal()
	 * @generated
	 * @ordered
	 */
	protected String transportJMSPubSubNoLocal = TRANSPORT_JMS_PUB_SUB_NO_LOCAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportMQTTConnectionFactory() <em>Transport MQTT Connection Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTConnectionFactory()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_MQTT_CONNECTION_FACTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportMQTTConnectionFactory() <em>Transport MQTT Connection Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTConnectionFactory()
	 * @generated
	 * @ordered
	 */
	protected String transportMQTTConnectionFactory = TRANSPORT_MQTT_CONNECTION_FACTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportMQTTServerHostName() <em>Transport MQTT Server Host Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTServerHostName()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_MQTT_SERVER_HOST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportMQTTServerHostName() <em>Transport MQTT Server Host Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTServerHostName()
	 * @generated
	 * @ordered
	 */
	protected String transportMQTTServerHostName = TRANSPORT_MQTT_SERVER_HOST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportMQTTServerPort() <em>Transport MQTT Server Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTServerPort()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_MQTT_SERVER_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportMQTTServerPort() <em>Transport MQTT Server Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTServerPort()
	 * @generated
	 * @ordered
	 */
	protected String transportMQTTServerPort = TRANSPORT_MQTT_SERVER_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportMQTTTopicName() <em>Transport MQTT Topic Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTTopicName()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_MQTT_TOPIC_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportMQTTTopicName() <em>Transport MQTT Topic Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTTopicName()
	 * @generated
	 * @ordered
	 */
	protected String transportMQTTTopicName = TRANSPORT_MQTT_TOPIC_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportMQTTSubscriptionQOS() <em>Transport MQTT Subscription QOS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTSubscriptionQOS()
	 * @generated
	 * @ordered
	 */
	protected static final MQTTSubscriptionQOS TRANSPORT_MQTT_SUBSCRIPTION_QOS_EDEFAULT = MQTTSubscriptionQOS.ZERO;

	/**
	 * The cached value of the '{@link #getTransportMQTTSubscriptionQOS() <em>Transport MQTT Subscription QOS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTSubscriptionQOS()
	 * @generated
	 * @ordered
	 */
	protected MQTTSubscriptionQOS transportMQTTSubscriptionQOS = TRANSPORT_MQTT_SUBSCRIPTION_QOS_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransportMQTTSessionClean() <em>Transport MQTT Session Clean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportMQTTSessionClean()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSPORT_MQTT_SESSION_CLEAN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransportMQTTSessionClean() <em>Transport MQTT Session Clean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransportMQTTSessionClean()
	 * @generated
	 * @ordered
	 */
	protected boolean transportMQTTSessionClean = TRANSPORT_MQTT_SESSION_CLEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportMQTTSslEnable() <em>Transport MQTT Ssl Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTSslEnable()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_MQTT_SSL_ENABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportMQTTSslEnable() <em>Transport MQTT Ssl Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTSslEnable()
	 * @generated
	 * @ordered
	 */
	protected String transportMQTTSslEnable = TRANSPORT_MQTT_SSL_ENABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportMQTTTemporaryStoreDirectory() <em>Transport MQTT Temporary Store Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTTemporaryStoreDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportMQTTTemporaryStoreDirectory() <em>Transport MQTT Temporary Store Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTTemporaryStoreDirectory()
	 * @generated
	 * @ordered
	 */
	protected String transportMQTTTemporaryStoreDirectory = TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportMQTTSubscriptionUsername() <em>Transport MQTT Subscription Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTSubscriptionUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_MQTT_SUBSCRIPTION_USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportMQTTSubscriptionUsername() <em>Transport MQTT Subscription Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTSubscriptionUsername()
	 * @generated
	 * @ordered
	 */
	protected String transportMQTTSubscriptionUsername = TRANSPORT_MQTT_SUBSCRIPTION_USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportMQTTSubscriptionPassword() <em>Transport MQTT Subscription Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTSubscriptionPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportMQTTSubscriptionPassword() <em>Transport MQTT Subscription Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTSubscriptionPassword()
	 * @generated
	 * @ordered
	 */
	protected String transportMQTTSubscriptionPassword = TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportMQTTClientId() <em>Transport MQTT Client Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTClientId()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_MQTT_CLIENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportMQTTClientId() <em>Transport MQTT Client Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransportMQTTClientId()
	 * @generated
	 * @ordered
	 */
	protected String transportMQTTClientId = TRANSPORT_MQTT_CLIENT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTruststore() <em>Truststore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTruststore()
	 * @generated
	 * @ordered
	 */
	protected static final String TRUSTSTORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTruststore() <em>Truststore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTruststore()
	 * @generated
	 * @ordered
	 */
	protected String truststore = TRUSTSTORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeystore() <em>Keystore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeystore()
	 * @generated
	 * @ordered
	 */
	protected static final String KEYSTORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeystore() <em>Keystore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeystore()
	 * @generated
	 * @ordered
	 */
	protected String keystore = KEYSTORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSslVerifyClient() <em>Ssl Verify Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSslVerifyClient()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_VERIFY_CLIENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSslVerifyClient() <em>Ssl Verify Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSslVerifyClient()
	 * @generated
	 * @ordered
	 */
	protected String sslVerifyClient = SSL_VERIFY_CLIENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSslProtocol() <em>Ssl Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSslProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_PROTOCOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSslProtocol() <em>Ssl Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSslProtocol()
	 * @generated
	 * @ordered
	 */
	protected String sslProtocol = SSL_PROTOCOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getHttpsProtocols() <em>Https Protocols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHttpsProtocols()
	 * @generated
	 * @ordered
	 */
	protected static final String HTTPS_PROTOCOLS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHttpsProtocols() <em>Https Protocols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHttpsProtocols()
	 * @generated
	 * @ordered
	 */
	protected String httpsProtocols = HTTPS_PROTOCOLS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCertificateRevocationVerifier() <em>Certificate Revocation Verifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCertificateRevocationVerifier()
	 * @generated
	 * @ordered
	 */
	protected static final String CERTIFICATE_REVOCATION_VERIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCertificateRevocationVerifier() <em>Certificate Revocation Verifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCertificateRevocationVerifier()
	 * @generated
	 * @ordered
	 */
	protected String certificateRevocationVerifier = CERTIFICATE_REVOCATION_VERIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundHL7Port() <em>Inbound HL7 Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7Port()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_HL7_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundHL7Port() <em>Inbound HL7 Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7Port()
	 * @generated
	 * @ordered
	 */
	protected String inboundHL7Port = INBOUND_HL7_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #isInboundHL7AutoAck() <em>Inbound HL7 Auto Ack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInboundHL7AutoAck()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INBOUND_HL7_AUTO_ACK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInboundHL7AutoAck() <em>Inbound HL7 Auto Ack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInboundHL7AutoAck()
	 * @generated
	 * @ordered
	 */
	protected boolean inboundHL7AutoAck = INBOUND_HL7_AUTO_ACK_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundHL7MessagePreProcessor() <em>Inbound HL7 Message Pre Processor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7MessagePreProcessor()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_HL7_MESSAGE_PRE_PROCESSOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundHL7MessagePreProcessor() <em>Inbound HL7 Message Pre Processor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7MessagePreProcessor()
	 * @generated
	 * @ordered
	 */
	protected String inboundHL7MessagePreProcessor = INBOUND_HL7_MESSAGE_PRE_PROCESSOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundHL7CharSet() <em>Inbound HL7 Char Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7CharSet()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_HL7_CHAR_SET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundHL7CharSet() <em>Inbound HL7 Char Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7CharSet()
	 * @generated
	 * @ordered
	 */
	protected String inboundHL7CharSet = INBOUND_HL7_CHAR_SET_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundHL7TimeOut() <em>Inbound HL7 Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7TimeOut()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_HL7_TIME_OUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundHL7TimeOut() <em>Inbound HL7 Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7TimeOut()
	 * @generated
	 * @ordered
	 */
	protected String inboundHL7TimeOut = INBOUND_HL7_TIME_OUT_EDEFAULT;

	/**
	 * The default value of the '{@link #isInboundHL7ValidateMessage() <em>Inbound HL7 Validate Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInboundHL7ValidateMessage()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INBOUND_HL7_VALIDATE_MESSAGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInboundHL7ValidateMessage() <em>Inbound HL7 Validate Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInboundHL7ValidateMessage()
	 * @generated
	 * @ordered
	 */
	protected boolean inboundHL7ValidateMessage = INBOUND_HL7_VALIDATE_MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundHL7BuildInvalidMessages() <em>Inbound HL7 Build Invalid Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7BuildInvalidMessages()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_HL7_BUILD_INVALID_MESSAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundHL7BuildInvalidMessages() <em>Inbound HL7 Build Invalid Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7BuildInvalidMessages()
	 * @generated
	 * @ordered
	 */
	protected String inboundHL7BuildInvalidMessages = INBOUND_HL7_BUILD_INVALID_MESSAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundHL7PassThroughInvalidMessages() <em>Inbound HL7 Pass Through Invalid Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7PassThroughInvalidMessages()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundHL7PassThroughInvalidMessages() <em>Inbound HL7 Pass Through Invalid Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundHL7PassThroughInvalidMessages()
	 * @generated
	 * @ordered
	 */
	protected String inboundHL7PassThroughInvalidMessages = INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getZookeeperConnect() <em>Zookeeper Connect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZookeeperConnect()
	 * @generated
	 * @ordered
	 */
	protected static final String ZOOKEEPER_CONNECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getZookeeperConnect() <em>Zookeeper Connect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZookeeperConnect()
	 * @generated
	 * @ordered
	 */
	protected String zookeeperConnect = ZOOKEEPER_CONNECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected String groupId = GROUP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getConsumerType() <em>Consumer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsumerType()
	 * @generated
	 * @ordered
	 */
	protected static final ConsumerType CONSUMER_TYPE_EDEFAULT = ConsumerType.HIGHLEVEL;

	/**
	 * The cached value of the '{@link #getConsumerType() <em>Consumer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsumerType()
	 * @generated
	 * @ordered
	 */
	protected ConsumerType consumerType = CONSUMER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	protected static final ContentType CONTENT_TYPE_EDEFAULT = ContentType.XML;

	/**
	 * The cached value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	protected ContentType contentType = CONTENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTopics() <em>Topics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopics()
	 * @generated
	 * @ordered
	 */
	protected static final String TOPICS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTopics() <em>Topics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopics()
	 * @generated
	 * @ordered
	 */
	protected String topics = TOPICS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSimpleTopic() <em>Simple Topic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleTopic()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_TOPIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleTopic() <em>Simple Topic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleTopic()
	 * @generated
	 * @ordered
	 */
	protected String simpleTopic = SIMPLE_TOPIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getSimpleBrokers() <em>Simple Brokers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleBrokers()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_BROKERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleBrokers() <em>Simple Brokers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleBrokers()
	 * @generated
	 * @ordered
	 */
	protected String simpleBrokers = SIMPLE_BROKERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSimplePort() <em>Simple Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimplePort()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimplePort() <em>Simple Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimplePort()
	 * @generated
	 * @ordered
	 */
	protected String simplePort = SIMPLE_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSimplePartition() <em>Simple Partition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimplePartition()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_PARTITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimplePartition() <em>Simple Partition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimplePartition()
	 * @generated
	 * @ordered
	 */
	protected String simplePartition = SIMPLE_PARTITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSimpleMaxMessagesToRead() <em>Simple Max Messages To Read</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleMaxMessagesToRead()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_MAX_MESSAGES_TO_READ_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleMaxMessagesToRead() <em>Simple Max Messages To Read</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleMaxMessagesToRead()
	 * @generated
	 * @ordered
	 */
	protected String simpleMaxMessagesToRead = SIMPLE_MAX_MESSAGES_TO_READ_EDEFAULT;

	/**
	 * The default value of the '{@link #getThreadCount() <em>Thread Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadCount()
	 * @generated
	 * @ordered
	 */
	protected static final String THREAD_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThreadCount() <em>Thread Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadCount()
	 * @generated
	 * @ordered
	 */
	protected String threadCount = THREAD_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getZookeeperSessionTimeoutMs() <em>Zookeeper Session Timeout Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZookeeperSessionTimeoutMs()
	 * @generated
	 * @ordered
	 */
	protected static final String ZOOKEEPER_SESSION_TIMEOUT_MS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getZookeeperSessionTimeoutMs() <em>Zookeeper Session Timeout Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZookeeperSessionTimeoutMs()
	 * @generated
	 * @ordered
	 */
	protected String zookeeperSessionTimeoutMs = ZOOKEEPER_SESSION_TIMEOUT_MS_EDEFAULT;

	/**
	 * The default value of the '{@link #getZookeeperSyncTimeMs() <em>Zookeeper Sync Time Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZookeeperSyncTimeMs()
	 * @generated
	 * @ordered
	 */
	protected static final String ZOOKEEPER_SYNC_TIME_MS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getZookeeperSyncTimeMs() <em>Zookeeper Sync Time Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZookeeperSyncTimeMs()
	 * @generated
	 * @ordered
	 */
	protected String zookeeperSyncTimeMs = ZOOKEEPER_SYNC_TIME_MS_EDEFAULT;

	/**
	 * The default value of the '{@link #getAutoCommitIntervalMs() <em>Auto Commit Interval Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoCommitIntervalMs()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTO_COMMIT_INTERVAL_MS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAutoCommitIntervalMs() <em>Auto Commit Interval Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoCommitIntervalMs()
	 * @generated
	 * @ordered
	 */
	protected String autoCommitIntervalMs = AUTO_COMMIT_INTERVAL_MS_EDEFAULT;

	/**
	 * The default value of the '{@link #getAutoOffsetReset() <em>Auto Offset Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoOffsetReset()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTO_OFFSET_RESET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAutoOffsetReset() <em>Auto Offset Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoOffsetReset()
	 * @generated
	 * @ordered
	 */
	protected String autoOffsetReset = AUTO_OFFSET_RESET_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundCxfRmHost() <em>Inbound Cxf Rm Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundCxfRmHost()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_CXF_RM_HOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundCxfRmHost() <em>Inbound Cxf Rm Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundCxfRmHost()
	 * @generated
	 * @ordered
	 */
	protected String inboundCxfRmHost = INBOUND_CXF_RM_HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundCxfRmPort() <em>Inbound Cxf Rm Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundCxfRmPort()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_CXF_RM_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundCxfRmPort() <em>Inbound Cxf Rm Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundCxfRmPort()
	 * @generated
	 * @ordered
	 */
	protected String inboundCxfRmPort = INBOUND_CXF_RM_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getInboundCxfRmConfigFile() <em>Inbound Cxf Rm Config File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundCxfRmConfigFile()
	 * @generated
	 * @ordered
	 */
	protected static final String INBOUND_CXF_RM_CONFIG_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInboundCxfRmConfigFile() <em>Inbound Cxf Rm Config File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundCxfRmConfigFile()
	 * @generated
	 * @ordered
	 */
	protected String inboundCxfRmConfigFile = INBOUND_CXF_RM_CONFIG_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnableSSL() <em>Enable SSL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableSSL()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLE_SSL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnableSSL() <em>Enable SSL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableSSL()
	 * @generated
	 * @ordered
	 */
	protected boolean enableSSL = ENABLE_SSL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getServiceParameters() <em>Service Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<InboundEndpointParameter> serviceParameters;

	/**
	 * The default value of the '{@link #isSuspend() <em>Suspend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuspend()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUSPEND_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuspend() <em>Suspend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuspend()
	 * @generated
	 * @ordered
	 */
	protected boolean suspend = SUSPEND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InboundEndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.INBOUND_ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointSequenceInputConnector getSequenceInputConnector() {
		return sequenceInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequenceInputConnector(InboundEndpointSequenceInputConnector newSequenceInputConnector, NotificationChain msgs) {
		InboundEndpointSequenceInputConnector oldSequenceInputConnector = sequenceInputConnector;
		sequenceInputConnector = newSequenceInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR, oldSequenceInputConnector, newSequenceInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceInputConnector(InboundEndpointSequenceInputConnector newSequenceInputConnector) {
		if (newSequenceInputConnector != sequenceInputConnector) {
			NotificationChain msgs = null;
			if (sequenceInputConnector != null)
				msgs = ((InternalEObject)sequenceInputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR, null, msgs);
			if (newSequenceInputConnector != null)
				msgs = ((InternalEObject)newSequenceInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR, null, msgs);
			msgs = basicSetSequenceInputConnector(newSequenceInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR, newSequenceInputConnector, newSequenceInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointSequenceOutputConnector getSequenceOutputConnector() {
		return sequenceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequenceOutputConnector(InboundEndpointSequenceOutputConnector newSequenceOutputConnector, NotificationChain msgs) {
		InboundEndpointSequenceOutputConnector oldSequenceOutputConnector = sequenceOutputConnector;
		sequenceOutputConnector = newSequenceOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR, oldSequenceOutputConnector, newSequenceOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceOutputConnector(InboundEndpointSequenceOutputConnector newSequenceOutputConnector) {
		if (newSequenceOutputConnector != sequenceOutputConnector) {
			NotificationChain msgs = null;
			if (sequenceOutputConnector != null)
				msgs = ((InternalEObject)sequenceOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			if (newSequenceOutputConnector != null)
				msgs = ((InternalEObject)newSequenceOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetSequenceOutputConnector(newSequenceOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR, newSequenceOutputConnector, newSequenceOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointOnErrorSequenceInputConnector getOnErrorSequenceInputConnector() {
		return onErrorSequenceInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector newOnErrorSequenceInputConnector, NotificationChain msgs) {
		InboundEndpointOnErrorSequenceInputConnector oldOnErrorSequenceInputConnector = onErrorSequenceInputConnector;
		onErrorSequenceInputConnector = newOnErrorSequenceInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR, oldOnErrorSequenceInputConnector, newOnErrorSequenceInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector newOnErrorSequenceInputConnector) {
		if (newOnErrorSequenceInputConnector != onErrorSequenceInputConnector) {
			NotificationChain msgs = null;
			if (onErrorSequenceInputConnector != null)
				msgs = ((InternalEObject)onErrorSequenceInputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR, null, msgs);
			if (newOnErrorSequenceInputConnector != null)
				msgs = ((InternalEObject)newOnErrorSequenceInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR, null, msgs);
			msgs = basicSetOnErrorSequenceInputConnector(newOnErrorSequenceInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR, newOnErrorSequenceInputConnector, newOnErrorSequenceInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointOnErrorSequenceOutputConnector getOnErrorSequenceOutputConnector() {
		return onErrorSequenceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector newOnErrorSequenceOutputConnector, NotificationChain msgs) {
		InboundEndpointOnErrorSequenceOutputConnector oldOnErrorSequenceOutputConnector = onErrorSequenceOutputConnector;
		onErrorSequenceOutputConnector = newOnErrorSequenceOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR, oldOnErrorSequenceOutputConnector, newOnErrorSequenceOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector newOnErrorSequenceOutputConnector) {
		if (newOnErrorSequenceOutputConnector != onErrorSequenceOutputConnector) {
			NotificationChain msgs = null;
			if (onErrorSequenceOutputConnector != null)
				msgs = ((InternalEObject)onErrorSequenceOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			if (newOnErrorSequenceOutputConnector != null)
				msgs = ((InternalEObject)newOnErrorSequenceOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOnErrorSequenceOutputConnector(newOnErrorSequenceOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR, newOnErrorSequenceOutputConnector, newOnErrorSequenceOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointContainer getContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(InboundEndpointContainer newContainer, NotificationChain msgs) {
		InboundEndpointContainer oldContainer = container;
		container = newContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__CONTAINER, oldContainer, newContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(InboundEndpointContainer newContainer) {
		if (newContainer != container) {
			NotificationChain msgs = null;
			if (container != null)
				msgs = ((InternalEObject)container).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__CONTAINER, null, msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__CONTAINER, null, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(InboundEndpointType newType) {
		InboundEndpointType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundHL7Port() {
		return inboundHL7Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundHL7Port(String newInboundHL7Port) {
		String oldInboundHL7Port = inboundHL7Port;
		inboundHL7Port = newInboundHL7Port;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PORT, oldInboundHL7Port, inboundHL7Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInboundHL7AutoAck() {
		return inboundHL7AutoAck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundHL7AutoAck(boolean newInboundHL7AutoAck) {
		boolean oldInboundHL7AutoAck = inboundHL7AutoAck;
		inboundHL7AutoAck = newInboundHL7AutoAck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK, oldInboundHL7AutoAck, inboundHL7AutoAck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundHL7MessagePreProcessor() {
		return inboundHL7MessagePreProcessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundHL7MessagePreProcessor(String newInboundHL7MessagePreProcessor) {
		String oldInboundHL7MessagePreProcessor = inboundHL7MessagePreProcessor;
		inboundHL7MessagePreProcessor = newInboundHL7MessagePreProcessor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_MESSAGE_PRE_PROCESSOR, oldInboundHL7MessagePreProcessor, inboundHL7MessagePreProcessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundHL7CharSet() {
		return inboundHL7CharSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundHL7CharSet(String newInboundHL7CharSet) {
		String oldInboundHL7CharSet = inboundHL7CharSet;
		inboundHL7CharSet = newInboundHL7CharSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_CHAR_SET, oldInboundHL7CharSet, inboundHL7CharSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundHL7TimeOut() {
		return inboundHL7TimeOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundHL7TimeOut(String newInboundHL7TimeOut) {
		String oldInboundHL7TimeOut = inboundHL7TimeOut;
		inboundHL7TimeOut = newInboundHL7TimeOut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_TIME_OUT, oldInboundHL7TimeOut, inboundHL7TimeOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInboundHL7ValidateMessage() {
		return inboundHL7ValidateMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundHL7ValidateMessage(boolean newInboundHL7ValidateMessage) {
		boolean oldInboundHL7ValidateMessage = inboundHL7ValidateMessage;
		inboundHL7ValidateMessage = newInboundHL7ValidateMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE, oldInboundHL7ValidateMessage, inboundHL7ValidateMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundHL7BuildInvalidMessages() {
		return inboundHL7BuildInvalidMessages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundHL7BuildInvalidMessages(String newInboundHL7BuildInvalidMessages) {
		String oldInboundHL7BuildInvalidMessages = inboundHL7BuildInvalidMessages;
		inboundHL7BuildInvalidMessages = newInboundHL7BuildInvalidMessages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES, oldInboundHL7BuildInvalidMessages, inboundHL7BuildInvalidMessages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundHL7PassThroughInvalidMessages() {
		return inboundHL7PassThroughInvalidMessages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundHL7PassThroughInvalidMessages(String newInboundHL7PassThroughInvalidMessages) {
		String oldInboundHL7PassThroughInvalidMessages = inboundHL7PassThroughInvalidMessages;
		inboundHL7PassThroughInvalidMessages = newInboundHL7PassThroughInvalidMessages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES, oldInboundHL7PassThroughInvalidMessages, inboundHL7PassThroughInvalidMessages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZookeeperConnect() {
		return zookeeperConnect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZookeeperConnect(String newZookeeperConnect) {
		String oldZookeeperConnect = zookeeperConnect;
		zookeeperConnect = newZookeeperConnect;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_CONNECT, oldZookeeperConnect, zookeeperConnect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupId(String newGroupId) {
		String oldGroupId = groupId;
		groupId = newGroupId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__GROUP_ID, oldGroupId, groupId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsumerType getConsumerType() {
		return consumerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsumerType(ConsumerType newConsumerType) {
		ConsumerType oldConsumerType = consumerType;
		consumerType = newConsumerType == null ? CONSUMER_TYPE_EDEFAULT : newConsumerType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__CONSUMER_TYPE, oldConsumerType, consumerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentType getContentType() {
		return contentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentType(ContentType newContentType) {
		ContentType oldContentType = contentType;
		contentType = newContentType == null ? CONTENT_TYPE_EDEFAULT : newContentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__CONTENT_TYPE, oldContentType, contentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopics() {
		return topics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopics(String newTopics) {
		String oldTopics = topics;
		topics = newTopics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TOPICS, oldTopics, topics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleTopic() {
		return simpleTopic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleTopic(String newSimpleTopic) {
		String oldSimpleTopic = simpleTopic;
		simpleTopic = newSimpleTopic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SIMPLE_TOPIC, oldSimpleTopic, simpleTopic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleBrokers() {
		return simpleBrokers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleBrokers(String newSimpleBrokers) {
		String oldSimpleBrokers = simpleBrokers;
		simpleBrokers = newSimpleBrokers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SIMPLE_BROKERS, oldSimpleBrokers, simpleBrokers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimplePort() {
		return simplePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimplePort(String newSimplePort) {
		String oldSimplePort = simplePort;
		simplePort = newSimplePort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SIMPLE_PORT, oldSimplePort, simplePort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimplePartition() {
		return simplePartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimplePartition(String newSimplePartition) {
		String oldSimplePartition = simplePartition;
		simplePartition = newSimplePartition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SIMPLE_PARTITION, oldSimplePartition, simplePartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleMaxMessagesToRead() {
		return simpleMaxMessagesToRead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleMaxMessagesToRead(String newSimpleMaxMessagesToRead) {
		String oldSimpleMaxMessagesToRead = simpleMaxMessagesToRead;
		simpleMaxMessagesToRead = newSimpleMaxMessagesToRead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SIMPLE_MAX_MESSAGES_TO_READ, oldSimpleMaxMessagesToRead, simpleMaxMessagesToRead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThreadCount() {
		return threadCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreadCount(String newThreadCount) {
		String oldThreadCount = threadCount;
		threadCount = newThreadCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__THREAD_COUNT, oldThreadCount, threadCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZookeeperSessionTimeoutMs() {
		return zookeeperSessionTimeoutMs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZookeeperSessionTimeoutMs(String newZookeeperSessionTimeoutMs) {
		String oldZookeeperSessionTimeoutMs = zookeeperSessionTimeoutMs;
		zookeeperSessionTimeoutMs = newZookeeperSessionTimeoutMs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS, oldZookeeperSessionTimeoutMs, zookeeperSessionTimeoutMs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZookeeperSyncTimeMs() {
		return zookeeperSyncTimeMs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZookeeperSyncTimeMs(String newZookeeperSyncTimeMs) {
		String oldZookeeperSyncTimeMs = zookeeperSyncTimeMs;
		zookeeperSyncTimeMs = newZookeeperSyncTimeMs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS, oldZookeeperSyncTimeMs, zookeeperSyncTimeMs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAutoCommitIntervalMs() {
		return autoCommitIntervalMs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoCommitIntervalMs(String newAutoCommitIntervalMs) {
		String oldAutoCommitIntervalMs = autoCommitIntervalMs;
		autoCommitIntervalMs = newAutoCommitIntervalMs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS, oldAutoCommitIntervalMs, autoCommitIntervalMs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAutoOffsetReset() {
		return autoOffsetReset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoOffsetReset(String newAutoOffsetReset) {
		String oldAutoOffsetReset = autoOffsetReset;
		autoOffsetReset = newAutoOffsetReset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__AUTO_OFFSET_RESET, oldAutoOffsetReset, autoOffsetReset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundCxfRmHost() {
		return inboundCxfRmHost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundCxfRmHost(String newInboundCxfRmHost) {
		String oldInboundCxfRmHost = inboundCxfRmHost;
		inboundCxfRmHost = newInboundCxfRmHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST, oldInboundCxfRmHost, inboundCxfRmHost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundCxfRmPort() {
		return inboundCxfRmPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundCxfRmPort(String newInboundCxfRmPort) {
		String oldInboundCxfRmPort = inboundCxfRmPort;
		inboundCxfRmPort = newInboundCxfRmPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT, oldInboundCxfRmPort, inboundCxfRmPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundCxfRmConfigFile() {
		return inboundCxfRmConfigFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundCxfRmConfigFile(String newInboundCxfRmConfigFile) {
		String oldInboundCxfRmConfigFile = inboundCxfRmConfigFile;
		inboundCxfRmConfigFile = newInboundCxfRmConfigFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE, oldInboundCxfRmConfigFile, inboundCxfRmConfigFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnableSSL() {
		return enableSSL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableSSL(boolean newEnableSSL) {
		boolean oldEnableSSL = enableSSL;
		enableSSL = newEnableSSL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ENABLE_SSL, oldEnableSSL, enableSSL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InboundEndpointParameter> getServiceParameters() {
		if (serviceParameters == null) {
			serviceParameters = new EObjectContainmentEList<InboundEndpointParameter>(InboundEndpointParameter.class, this, EsbPackage.INBOUND_ENDPOINT__SERVICE_PARAMETERS);
		}
		return serviceParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuspend() {
		return suspend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspend(boolean newSuspend) {
		boolean oldSuspend = suspend;
		suspend = newSuspend;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SUSPEND, oldSuspend, suspend));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(String newClass) {
		String oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocol(String newProtocol) {
		String oldProtocol = protocol;
		protocol = newProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__PROTOCOL, oldProtocol, protocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundHttpPort() {
		return inboundHttpPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundHttpPort(String newInboundHttpPort) {
		String oldInboundHttpPort = inboundHttpPort;
		inboundHttpPort = newInboundHttpPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_HTTP_PORT, oldInboundHttpPort, inboundHttpPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundWorkerPoolSizeCore() {
		return inboundWorkerPoolSizeCore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundWorkerPoolSizeCore(String newInboundWorkerPoolSizeCore) {
		String oldInboundWorkerPoolSizeCore = inboundWorkerPoolSizeCore;
		inboundWorkerPoolSizeCore = newInboundWorkerPoolSizeCore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_CORE, oldInboundWorkerPoolSizeCore, inboundWorkerPoolSizeCore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundWorkerPoolSizeMax() {
		return inboundWorkerPoolSizeMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundWorkerPoolSizeMax(String newInboundWorkerPoolSizeMax) {
		String oldInboundWorkerPoolSizeMax = inboundWorkerPoolSizeMax;
		inboundWorkerPoolSizeMax = newInboundWorkerPoolSizeMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_MAX, oldInboundWorkerPoolSizeMax, inboundWorkerPoolSizeMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundWorkerThreadKeepAliveSec() {
		return inboundWorkerThreadKeepAliveSec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundWorkerThreadKeepAliveSec(String newInboundWorkerThreadKeepAliveSec) {
		String oldInboundWorkerThreadKeepAliveSec = inboundWorkerThreadKeepAliveSec;
		inboundWorkerThreadKeepAliveSec = newInboundWorkerThreadKeepAliveSec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC, oldInboundWorkerThreadKeepAliveSec, inboundWorkerThreadKeepAliveSec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundWorkerPoolQueueLength() {
		return inboundWorkerPoolQueueLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundWorkerPoolQueueLength(String newInboundWorkerPoolQueueLength) {
		String oldInboundWorkerPoolQueueLength = inboundWorkerPoolQueueLength;
		inboundWorkerPoolQueueLength = newInboundWorkerPoolQueueLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_QUEUE_LENGTH, oldInboundWorkerPoolQueueLength, inboundWorkerPoolQueueLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundThreadGroupId() {
		return inboundThreadGroupId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundThreadGroupId(String newInboundThreadGroupId) {
		String oldInboundThreadGroupId = inboundThreadGroupId;
		inboundThreadGroupId = newInboundThreadGroupId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_THREAD_GROUP_ID, oldInboundThreadGroupId, inboundThreadGroupId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInboundThreadId() {
		return inboundThreadId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundThreadId(String newInboundThreadId) {
		String oldInboundThreadId = inboundThreadId;
		inboundThreadId = newInboundThreadId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INBOUND_THREAD_ID, oldInboundThreadId, inboundThreadId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDispatchFilterPattern() {
		return dispatchFilterPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDispatchFilterPattern(String newDispatchFilterPattern) {
		String oldDispatchFilterPattern = dispatchFilterPattern;
		dispatchFilterPattern = newDispatchFilterPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__DISPATCH_FILTER_PATTERN, oldDispatchFilterPattern, dispatchFilterPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterval() {
		return interval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterval(String newInterval) {
		String oldInterval = interval;
		interval = newInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__INTERVAL, oldInterval, interval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSequential() {
		return sequential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequential(boolean newSequential) {
		boolean oldSequential = sequential;
		sequential = newSequential;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SEQUENTIAL, oldSequential, sequential));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCoordination() {
		return coordination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoordination(boolean newCoordination) {
		boolean oldCoordination = coordination;
		coordination = newCoordination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__COORDINATION, oldCoordination, coordination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSFileURI() {
		return transportVFSFileURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSFileURI(String newTransportVFSFileURI) {
		String oldTransportVFSFileURI = transportVFSFileURI;
		transportVFSFileURI = newTransportVFSFileURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_URI, oldTransportVFSFileURI, transportVFSFileURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSContentType() {
		return transportVFSContentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSContentType(String newTransportVFSContentType) {
		String oldTransportVFSContentType = transportVFSContentType;
		transportVFSContentType = newTransportVFSContentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CONTENT_TYPE, oldTransportVFSContentType, transportVFSContentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSFileNamePattern() {
		return transportVFSFileNamePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSFileNamePattern(String newTransportVFSFileNamePattern) {
		String oldTransportVFSFileNamePattern = transportVFSFileNamePattern;
		transportVFSFileNamePattern = newTransportVFSFileNamePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_NAME_PATTERN, oldTransportVFSFileNamePattern, transportVFSFileNamePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSFileProcessInterval() {
		return transportVFSFileProcessInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSFileProcessInterval(String newTransportVFSFileProcessInterval) {
		String oldTransportVFSFileProcessInterval = transportVFSFileProcessInterval;
		transportVFSFileProcessInterval = newTransportVFSFileProcessInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_INTERVAL, oldTransportVFSFileProcessInterval, transportVFSFileProcessInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSFileProcessCount() {
		return transportVFSFileProcessCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSFileProcessCount(String newTransportVFSFileProcessCount) {
		String oldTransportVFSFileProcessCount = transportVFSFileProcessCount;
		transportVFSFileProcessCount = newTransportVFSFileProcessCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_COUNT, oldTransportVFSFileProcessCount, transportVFSFileProcessCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enable getTransportVFSLocking() {
		return transportVFSLocking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSLocking(Enable newTransportVFSLocking) {
		Enable oldTransportVFSLocking = transportVFSLocking;
		transportVFSLocking = newTransportVFSLocking == null ? TRANSPORT_VFS_LOCKING_EDEFAULT : newTransportVFSLocking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING, oldTransportVFSLocking, transportVFSLocking));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSMaxRetryCount() {
		return transportVFSMaxRetryCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSMaxRetryCount(String newTransportVFSMaxRetryCount) {
		String oldTransportVFSMaxRetryCount = transportVFSMaxRetryCount;
		transportVFSMaxRetryCount = newTransportVFSMaxRetryCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MAX_RETRY_COUNT, oldTransportVFSMaxRetryCount, transportVFSMaxRetryCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSReconnectTimeout() {
		return transportVFSReconnectTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSReconnectTimeout(String newTransportVFSReconnectTimeout) {
		String oldTransportVFSReconnectTimeout = transportVFSReconnectTimeout;
		transportVFSReconnectTimeout = newTransportVFSReconnectTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_RECONNECT_TIMEOUT, oldTransportVFSReconnectTimeout, transportVFSReconnectTimeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VFSAction getTransportVFSActionAfterProcess() {
		return transportVFSActionAfterProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSActionAfterProcess(VFSAction newTransportVFSActionAfterProcess) {
		VFSAction oldTransportVFSActionAfterProcess = transportVFSActionAfterProcess;
		transportVFSActionAfterProcess = newTransportVFSActionAfterProcess == null ? TRANSPORT_VFS_ACTION_AFTER_PROCESS_EDEFAULT : newTransportVFSActionAfterProcess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS, oldTransportVFSActionAfterProcess, transportVFSActionAfterProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSMoveAfterProcess() {
		return transportVFSMoveAfterProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSMoveAfterProcess(String newTransportVFSMoveAfterProcess) {
		String oldTransportVFSMoveAfterProcess = transportVFSMoveAfterProcess;
		transportVFSMoveAfterProcess = newTransportVFSMoveAfterProcess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_PROCESS, oldTransportVFSMoveAfterProcess, transportVFSMoveAfterProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VFSAction getTransportVFSActionAfterErrors() {
		return transportVFSActionAfterErrors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSActionAfterErrors(VFSAction newTransportVFSActionAfterErrors) {
		VFSAction oldTransportVFSActionAfterErrors = transportVFSActionAfterErrors;
		transportVFSActionAfterErrors = newTransportVFSActionAfterErrors == null ? TRANSPORT_VFS_ACTION_AFTER_ERRORS_EDEFAULT : newTransportVFSActionAfterErrors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_ERRORS, oldTransportVFSActionAfterErrors, transportVFSActionAfterErrors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSMoveAfterErrors() {
		return transportVFSMoveAfterErrors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSMoveAfterErrors(String newTransportVFSMoveAfterErrors) {
		String oldTransportVFSMoveAfterErrors = transportVFSMoveAfterErrors;
		transportVFSMoveAfterErrors = newTransportVFSMoveAfterErrors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_ERRORS, oldTransportVFSMoveAfterErrors, transportVFSMoveAfterErrors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VFSAction getTransportVFSActionAfterFailure() {
		return transportVFSActionAfterFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSActionAfterFailure(VFSAction newTransportVFSActionAfterFailure) {
		VFSAction oldTransportVFSActionAfterFailure = transportVFSActionAfterFailure;
		transportVFSActionAfterFailure = newTransportVFSActionAfterFailure == null ? TRANSPORT_VFS_ACTION_AFTER_FAILURE_EDEFAULT : newTransportVFSActionAfterFailure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE, oldTransportVFSActionAfterFailure, transportVFSActionAfterFailure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSMoveAfterFailure() {
		return transportVFSMoveAfterFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSMoveAfterFailure(String newTransportVFSMoveAfterFailure) {
		String oldTransportVFSMoveAfterFailure = transportVFSMoveAfterFailure;
		transportVFSMoveAfterFailure = newTransportVFSMoveAfterFailure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_FAILURE, oldTransportVFSMoveAfterFailure, transportVFSMoveAfterFailure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransportVFSAutoLockRelease() {
		return transportVFSAutoLockRelease;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSAutoLockRelease(boolean newTransportVFSAutoLockRelease) {
		boolean oldTransportVFSAutoLockRelease = transportVFSAutoLockRelease;
		transportVFSAutoLockRelease = newTransportVFSAutoLockRelease;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE, oldTransportVFSAutoLockRelease, transportVFSAutoLockRelease));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSAutoLockReleaseInterval() {
		return transportVFSAutoLockReleaseInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSAutoLockReleaseInterval(String newTransportVFSAutoLockReleaseInterval) {
		String oldTransportVFSAutoLockReleaseInterval = transportVFSAutoLockReleaseInterval;
		transportVFSAutoLockReleaseInterval = newTransportVFSAutoLockReleaseInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL, oldTransportVFSAutoLockReleaseInterval, transportVFSAutoLockReleaseInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransportVFSLockReleaseSameNode() {
		return transportVFSLockReleaseSameNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSLockReleaseSameNode(boolean newTransportVFSLockReleaseSameNode) {
		boolean oldTransportVFSLockReleaseSameNode = transportVFSLockReleaseSameNode;
		transportVFSLockReleaseSameNode = newTransportVFSLockReleaseSameNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE, oldTransportVFSLockReleaseSameNode, transportVFSLockReleaseSameNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransportVFSDistributedLock() {
		return transportVFSDistributedLock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSDistributedLock(boolean newTransportVFSDistributedLock) {
		boolean oldTransportVFSDistributedLock = transportVFSDistributedLock;
		transportVFSDistributedLock = newTransportVFSDistributedLock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK, oldTransportVFSDistributedLock, transportVFSDistributedLock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransportVFSStreaming() {
		return transportVFSStreaming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSStreaming(boolean newTransportVFSStreaming) {
		boolean oldTransportVFSStreaming = transportVFSStreaming;
		transportVFSStreaming = newTransportVFSStreaming;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING, oldTransportVFSStreaming, transportVFSStreaming));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransportVFSBuild() {
		return transportVFSBuild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSBuild(boolean newTransportVFSBuild) {
		boolean oldTransportVFSBuild = transportVFSBuild;
		transportVFSBuild = newTransportVFSBuild;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_BUILD, oldTransportVFSBuild, transportVFSBuild));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSDistributedTimeout() {
		return transportVFSDistributedTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSDistributedTimeout(String newTransportVFSDistributedTimeout) {
		String oldTransportVFSDistributedTimeout = transportVFSDistributedTimeout;
		transportVFSDistributedTimeout = newTransportVFSDistributedTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_TIMEOUT, oldTransportVFSDistributedTimeout, transportVFSDistributedTimeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJavaNamingFactoryInitial() {
		return javaNamingFactoryInitial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJavaNamingFactoryInitial(String newJavaNamingFactoryInitial) {
		String oldJavaNamingFactoryInitial = javaNamingFactoryInitial;
		javaNamingFactoryInitial = newJavaNamingFactoryInitial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_FACTORY_INITIAL, oldJavaNamingFactoryInitial, javaNamingFactoryInitial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJavaNamingProviderUrl() {
		return javaNamingProviderUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJavaNamingProviderUrl(String newJavaNamingProviderUrl) {
		String oldJavaNamingProviderUrl = javaNamingProviderUrl;
		javaNamingProviderUrl = newJavaNamingProviderUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_PROVIDER_URL, oldJavaNamingProviderUrl, javaNamingProviderUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSConnectionFactoryJNDIName() {
		return transportJMSConnectionFactoryJNDIName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSConnectionFactoryJNDIName(String newTransportJMSConnectionFactoryJNDIName) {
		String oldTransportJMSConnectionFactoryJNDIName = transportJMSConnectionFactoryJNDIName;
		transportJMSConnectionFactoryJNDIName = newTransportJMSConnectionFactoryJNDIName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME, oldTransportJMSConnectionFactoryJNDIName, transportJMSConnectionFactoryJNDIName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JMSConnectionFactoryType getTransportJMSConnectionFactoryType() {
		return transportJMSConnectionFactoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSConnectionFactoryType(JMSConnectionFactoryType newTransportJMSConnectionFactoryType) {
		JMSConnectionFactoryType oldTransportJMSConnectionFactoryType = transportJMSConnectionFactoryType;
		transportJMSConnectionFactoryType = newTransportJMSConnectionFactoryType == null ? TRANSPORT_JMS_CONNECTION_FACTORY_TYPE_EDEFAULT : newTransportJMSConnectionFactoryType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE, oldTransportJMSConnectionFactoryType, transportJMSConnectionFactoryType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSDestination() {
		return transportJMSDestination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSDestination(String newTransportJMSDestination) {
		String oldTransportJMSDestination = transportJMSDestination;
		transportJMSDestination = newTransportJMSDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION, oldTransportJMSDestination, transportJMSDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransportJMSSessionTransacted() {
		return transportJMSSessionTransacted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSSessionTransacted(boolean newTransportJMSSessionTransacted) {
		boolean oldTransportJMSSessionTransacted = transportJMSSessionTransacted;
		transportJMSSessionTransacted = newTransportJMSSessionTransacted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED, oldTransportJMSSessionTransacted, transportJMSSessionTransacted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JMSSessionAcknowledgement getTransportJMSSessionAcknowledgement() {
		return transportJMSSessionAcknowledgement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSSessionAcknowledgement(JMSSessionAcknowledgement newTransportJMSSessionAcknowledgement) {
		JMSSessionAcknowledgement oldTransportJMSSessionAcknowledgement = transportJMSSessionAcknowledgement;
		transportJMSSessionAcknowledgement = newTransportJMSSessionAcknowledgement == null ? TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT_EDEFAULT : newTransportJMSSessionAcknowledgement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT, oldTransportJMSSessionAcknowledgement, transportJMSSessionAcknowledgement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JMSCacheLevel getTransportJMSCacheLevel() {
		return transportJMSCacheLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSCacheLevel(JMSCacheLevel newTransportJMSCacheLevel) {
		JMSCacheLevel oldTransportJMSCacheLevel = transportJMSCacheLevel;
		transportJMSCacheLevel = newTransportJMSCacheLevel == null ? TRANSPORT_JMS_CACHE_LEVEL_EDEFAULT : newTransportJMSCacheLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL, oldTransportJMSCacheLevel, transportJMSCacheLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSUserName() {
		return transportJMSUserName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSUserName(String newTransportJMSUserName) {
		String oldTransportJMSUserName = transportJMSUserName;
		transportJMSUserName = newTransportJMSUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_USER_NAME, oldTransportJMSUserName, transportJMSUserName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSPassword() {
		return transportJMSPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSPassword(String newTransportJMSPassword) {
		String oldTransportJMSPassword = transportJMSPassword;
		transportJMSPassword = newTransportJMSPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_PASSWORD, oldTransportJMSPassword, transportJMSPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSJMSSpecVersion() {
		return transportJMSJMSSpecVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSJMSSpecVersion(String newTransportJMSJMSSpecVersion) {
		String oldTransportJMSJMSSpecVersion = transportJMSJMSSpecVersion;
		transportJMSJMSSpecVersion = newTransportJMSJMSSpecVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMSJMS_SPEC_VERSION, oldTransportJMSJMSSpecVersion, transportJMSJMSSpecVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSSubscriptionDurable() {
		return transportJMSSubscriptionDurable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSSubscriptionDurable(String newTransportJMSSubscriptionDurable) {
		String oldTransportJMSSubscriptionDurable = transportJMSSubscriptionDurable;
		transportJMSSubscriptionDurable = newTransportJMSSubscriptionDurable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_DURABLE, oldTransportJMSSubscriptionDurable, transportJMSSubscriptionDurable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSDurableSubscriberClientID() {
		return transportJMSDurableSubscriberClientID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSDurableSubscriberClientID(String newTransportJMSDurableSubscriberClientID) {
		String oldTransportJMSDurableSubscriberClientID = transportJMSDurableSubscriberClientID;
		transportJMSDurableSubscriberClientID = newTransportJMSDurableSubscriberClientID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID, oldTransportJMSDurableSubscriberClientID, transportJMSDurableSubscriberClientID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSMessageSelector() {
		return transportJMSMessageSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSMessageSelector(String newTransportJMSMessageSelector) {
		String oldTransportJMSMessageSelector = transportJMSMessageSelector;
		transportJMSMessageSelector = newTransportJMSMessageSelector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_MESSAGE_SELECTOR, oldTransportJMSMessageSelector, transportJMSMessageSelector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isApiDispatchingEnabled() {
		return apiDispatchingEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApiDispatchingEnabled(boolean newApiDispatchingEnabled) {
		boolean oldApiDispatchingEnabled = apiDispatchingEnabled;
		apiDispatchingEnabled = newApiDispatchingEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__API_DISPATCHING_ENABLED, oldApiDispatchingEnabled, apiDispatchingEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSMoveTimestampFormat() {
		return transportVFSMoveTimestampFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSMoveTimestampFormat(String newTransportVFSMoveTimestampFormat) {
		String oldTransportVFSMoveTimestampFormat = transportVFSMoveTimestampFormat;
		transportVFSMoveTimestampFormat = newTransportVFSMoveTimestampFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT, oldTransportVFSMoveTimestampFormat, transportVFSMoveTimestampFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VFSFileSort getTransportVFSFileSortAttribute() {
		return transportVFSFileSortAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSFileSortAttribute(VFSFileSort newTransportVFSFileSortAttribute) {
		VFSFileSort oldTransportVFSFileSortAttribute = transportVFSFileSortAttribute;
		transportVFSFileSortAttribute = newTransportVFSFileSortAttribute == null ? TRANSPORT_VFS_FILE_SORT_ATTRIBUTE_EDEFAULT : newTransportVFSFileSortAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE, oldTransportVFSFileSortAttribute, transportVFSFileSortAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransportVFSFileSortAscending() {
		return transportVFSFileSortAscending;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSFileSortAscending(boolean newTransportVFSFileSortAscending) {
		boolean oldTransportVFSFileSortAscending = transportVFSFileSortAscending;
		transportVFSFileSortAscending = newTransportVFSFileSortAscending;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING, oldTransportVFSFileSortAscending, transportVFSFileSortAscending));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportVFSSubFolderTimestampFormat() {
		return transportVFSSubFolderTimestampFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSSubFolderTimestampFormat(String newTransportVFSSubFolderTimestampFormat) {
		String oldTransportVFSSubFolderTimestampFormat = transportVFSSubFolderTimestampFormat;
		transportVFSSubFolderTimestampFormat = newTransportVFSSubFolderTimestampFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT, oldTransportVFSSubFolderTimestampFormat, transportVFSSubFolderTimestampFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransportVFSCreateFolder() {
		return transportVFSCreateFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportVFSCreateFolder(boolean newTransportVFSCreateFolder) {
		boolean oldTransportVFSCreateFolder = transportVFSCreateFolder;
		transportVFSCreateFolder = newTransportVFSCreateFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER, oldTransportVFSCreateFolder, transportVFSCreateFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSReceiveTimeout() {
		return transportJMSReceiveTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSReceiveTimeout(String newTransportJMSReceiveTimeout) {
		String oldTransportJMSReceiveTimeout = transportJMSReceiveTimeout;
		transportJMSReceiveTimeout = newTransportJMSReceiveTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_RECEIVE_TIMEOUT, oldTransportJMSReceiveTimeout, transportJMSReceiveTimeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSContentType() {
		return transportJMSContentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSContentType(String newTransportJMSContentType) {
		String oldTransportJMSContentType = transportJMSContentType;
		transportJMSContentType = newTransportJMSContentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE, oldTransportJMSContentType, transportJMSContentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSContentTypeProperty() {
		return transportJMSContentTypeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSContentTypeProperty(String newTransportJMSContentTypeProperty) {
		String oldTransportJMSContentTypeProperty = transportJMSContentTypeProperty;
		transportJMSContentTypeProperty = newTransportJMSContentTypeProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE_PROPERTY, oldTransportJMSContentTypeProperty, transportJMSContentTypeProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSReplyDestination() {
		return transportJMSReplyDestination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSReplyDestination(String newTransportJMSReplyDestination) {
		String oldTransportJMSReplyDestination = transportJMSReplyDestination;
		transportJMSReplyDestination = newTransportJMSReplyDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_REPLY_DESTINATION, oldTransportJMSReplyDestination, transportJMSReplyDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportJMSPubSubNoLocal() {
		return transportJMSPubSubNoLocal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportJMSPubSubNoLocal(String newTransportJMSPubSubNoLocal) {
		String oldTransportJMSPubSubNoLocal = transportJMSPubSubNoLocal;
		transportJMSPubSubNoLocal = newTransportJMSPubSubNoLocal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_PUB_SUB_NO_LOCAL, oldTransportJMSPubSubNoLocal, transportJMSPubSubNoLocal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportMQTTConnectionFactory() {
		return transportMQTTConnectionFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMQTTConnectionFactory(String newTransportMQTTConnectionFactory) {
		String oldTransportMQTTConnectionFactory = transportMQTTConnectionFactory;
		transportMQTTConnectionFactory = newTransportMQTTConnectionFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_CONNECTION_FACTORY, oldTransportMQTTConnectionFactory, transportMQTTConnectionFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportMQTTServerHostName() {
		return transportMQTTServerHostName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMQTTServerHostName(String newTransportMQTTServerHostName) {
		String oldTransportMQTTServerHostName = transportMQTTServerHostName;
		transportMQTTServerHostName = newTransportMQTTServerHostName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_HOST_NAME, oldTransportMQTTServerHostName, transportMQTTServerHostName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportMQTTServerPort() {
		return transportMQTTServerPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMQTTServerPort(String newTransportMQTTServerPort) {
		String oldTransportMQTTServerPort = transportMQTTServerPort;
		transportMQTTServerPort = newTransportMQTTServerPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_PORT, oldTransportMQTTServerPort, transportMQTTServerPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportMQTTTopicName() {
		return transportMQTTTopicName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMQTTTopicName(String newTransportMQTTTopicName) {
		String oldTransportMQTTTopicName = transportMQTTTopicName;
		transportMQTTTopicName = newTransportMQTTTopicName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_TOPIC_NAME, oldTransportMQTTTopicName, transportMQTTTopicName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQTTSubscriptionQOS getTransportMQTTSubscriptionQOS() {
		return transportMQTTSubscriptionQOS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMQTTSubscriptionQOS(MQTTSubscriptionQOS newTransportMQTTSubscriptionQOS) {
		MQTTSubscriptionQOS oldTransportMQTTSubscriptionQOS = transportMQTTSubscriptionQOS;
		transportMQTTSubscriptionQOS = newTransportMQTTSubscriptionQOS == null ? TRANSPORT_MQTT_SUBSCRIPTION_QOS_EDEFAULT : newTransportMQTTSubscriptionQOS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS, oldTransportMQTTSubscriptionQOS, transportMQTTSubscriptionQOS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransportMQTTSessionClean() {
		return transportMQTTSessionClean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMQTTSessionClean(boolean newTransportMQTTSessionClean) {
		boolean oldTransportMQTTSessionClean = transportMQTTSessionClean;
		transportMQTTSessionClean = newTransportMQTTSessionClean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SESSION_CLEAN, oldTransportMQTTSessionClean, transportMQTTSessionClean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportMQTTSslEnable() {
		return transportMQTTSslEnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMQTTSslEnable(String newTransportMQTTSslEnable) {
		String oldTransportMQTTSslEnable = transportMQTTSslEnable;
		transportMQTTSslEnable = newTransportMQTTSslEnable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_ENABLE, oldTransportMQTTSslEnable, transportMQTTSslEnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportMQTTTemporaryStoreDirectory() {
		return transportMQTTTemporaryStoreDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMQTTTemporaryStoreDirectory(String newTransportMQTTTemporaryStoreDirectory) {
		String oldTransportMQTTTemporaryStoreDirectory = transportMQTTTemporaryStoreDirectory;
		transportMQTTTemporaryStoreDirectory = newTransportMQTTTemporaryStoreDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY, oldTransportMQTTTemporaryStoreDirectory, transportMQTTTemporaryStoreDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportMQTTSubscriptionUsername() {
		return transportMQTTSubscriptionUsername;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMQTTSubscriptionUsername(String newTransportMQTTSubscriptionUsername) {
		String oldTransportMQTTSubscriptionUsername = transportMQTTSubscriptionUsername;
		transportMQTTSubscriptionUsername = newTransportMQTTSubscriptionUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_USERNAME, oldTransportMQTTSubscriptionUsername, transportMQTTSubscriptionUsername));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportMQTTSubscriptionPassword() {
		return transportMQTTSubscriptionPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMQTTSubscriptionPassword(String newTransportMQTTSubscriptionPassword) {
		String oldTransportMQTTSubscriptionPassword = transportMQTTSubscriptionPassword;
		transportMQTTSubscriptionPassword = newTransportMQTTSubscriptionPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD, oldTransportMQTTSubscriptionPassword, transportMQTTSubscriptionPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportMQTTClientId() {
		return transportMQTTClientId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMQTTClientId(String newTransportMQTTClientId) {
		String oldTransportMQTTClientId = transportMQTTClientId;
		transportMQTTClientId = newTransportMQTTClientId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_CLIENT_ID, oldTransportMQTTClientId, transportMQTTClientId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTruststore() {
		return truststore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTruststore(String newTruststore) {
		String oldTruststore = truststore;
		truststore = newTruststore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__TRUSTSTORE, oldTruststore, truststore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeystore() {
		return keystore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeystore(String newKeystore) {
		String oldKeystore = keystore;
		keystore = newKeystore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__KEYSTORE, oldKeystore, keystore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSslVerifyClient() {
		return sslVerifyClient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSslVerifyClient(String newSslVerifyClient) {
		String oldSslVerifyClient = sslVerifyClient;
		sslVerifyClient = newSslVerifyClient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SSL_VERIFY_CLIENT, oldSslVerifyClient, sslVerifyClient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSslProtocol() {
		return sslProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSslProtocol(String newSslProtocol) {
		String oldSslProtocol = sslProtocol;
		sslProtocol = newSslProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SSL_PROTOCOL, oldSslProtocol, sslProtocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHttpsProtocols() {
		return httpsProtocols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHttpsProtocols(String newHttpsProtocols) {
		String oldHttpsProtocols = httpsProtocols;
		httpsProtocols = newHttpsProtocols;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__HTTPS_PROTOCOLS, oldHttpsProtocols, httpsProtocols));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCertificateRevocationVerifier() {
		return certificateRevocationVerifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCertificateRevocationVerifier(String newCertificateRevocationVerifier) {
		String oldCertificateRevocationVerifier = certificateRevocationVerifier;
		certificateRevocationVerifier = newCertificateRevocationVerifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__CERTIFICATE_REVOCATION_VERIFIER, oldCertificateRevocationVerifier, certificateRevocationVerifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
				return basicSetSequenceInputConnector(null, msgs);
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
				return basicSetSequenceOutputConnector(null, msgs);
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
				return basicSetOnErrorSequenceInputConnector(null, msgs);
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
				return basicSetOnErrorSequenceOutputConnector(null, msgs);
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
				return basicSetContainer(null, msgs);
			case EsbPackage.INBOUND_ENDPOINT__SERVICE_PARAMETERS:
				return ((InternalEList<?>)getServiceParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
				return getSequenceInputConnector();
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
				return getSequenceOutputConnector();
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
				return getOnErrorSequenceInputConnector();
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
				return getOnErrorSequenceOutputConnector();
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
				return getContainer();
			case EsbPackage.INBOUND_ENDPOINT__NAME:
				return getName();
			case EsbPackage.INBOUND_ENDPOINT__TYPE:
				return getType();
			case EsbPackage.INBOUND_ENDPOINT__CLASS:
				return getClass_();
			case EsbPackage.INBOUND_ENDPOINT__PROTOCOL:
				return getProtocol();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HTTP_PORT:
				return getInboundHttpPort();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_CORE:
				return getInboundWorkerPoolSizeCore();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_MAX:
				return getInboundWorkerPoolSizeMax();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC:
				return getInboundWorkerThreadKeepAliveSec();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_QUEUE_LENGTH:
				return getInboundWorkerPoolQueueLength();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_THREAD_GROUP_ID:
				return getInboundThreadGroupId();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_THREAD_ID:
				return getInboundThreadId();
			case EsbPackage.INBOUND_ENDPOINT__DISPATCH_FILTER_PATTERN:
				return getDispatchFilterPattern();
			case EsbPackage.INBOUND_ENDPOINT__INTERVAL:
				return getInterval();
			case EsbPackage.INBOUND_ENDPOINT__SEQUENTIAL:
				return isSequential();
			case EsbPackage.INBOUND_ENDPOINT__COORDINATION:
				return isCoordination();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_URI:
				return getTransportVFSFileURI();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CONTENT_TYPE:
				return getTransportVFSContentType();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_NAME_PATTERN:
				return getTransportVFSFileNamePattern();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_INTERVAL:
				return getTransportVFSFileProcessInterval();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_COUNT:
				return getTransportVFSFileProcessCount();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING:
				return getTransportVFSLocking();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MAX_RETRY_COUNT:
				return getTransportVFSMaxRetryCount();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_RECONNECT_TIMEOUT:
				return getTransportVFSReconnectTimeout();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS:
				return getTransportVFSActionAfterProcess();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_PROCESS:
				return getTransportVFSMoveAfterProcess();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_ERRORS:
				return getTransportVFSActionAfterErrors();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_ERRORS:
				return getTransportVFSMoveAfterErrors();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE:
				return getTransportVFSActionAfterFailure();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_FAILURE:
				return getTransportVFSMoveAfterFailure();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE:
				return isTransportVFSAutoLockRelease();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL:
				return getTransportVFSAutoLockReleaseInterval();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE:
				return isTransportVFSLockReleaseSameNode();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK:
				return isTransportVFSDistributedLock();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING:
				return isTransportVFSStreaming();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_BUILD:
				return isTransportVFSBuild();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_TIMEOUT:
				return getTransportVFSDistributedTimeout();
			case EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_FACTORY_INITIAL:
				return getJavaNamingFactoryInitial();
			case EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_PROVIDER_URL:
				return getJavaNamingProviderUrl();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME:
				return getTransportJMSConnectionFactoryJNDIName();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE:
				return getTransportJMSConnectionFactoryType();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION:
				return getTransportJMSDestination();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED:
				return isTransportJMSSessionTransacted();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT:
				return getTransportJMSSessionAcknowledgement();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL:
				return getTransportJMSCacheLevel();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_USER_NAME:
				return getTransportJMSUserName();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_PASSWORD:
				return getTransportJMSPassword();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMSJMS_SPEC_VERSION:
				return getTransportJMSJMSSpecVersion();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_DURABLE:
				return getTransportJMSSubscriptionDurable();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID:
				return getTransportJMSDurableSubscriberClientID();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_MESSAGE_SELECTOR:
				return getTransportJMSMessageSelector();
			case EsbPackage.INBOUND_ENDPOINT__API_DISPATCHING_ENABLED:
				return isApiDispatchingEnabled();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT:
				return getTransportVFSMoveTimestampFormat();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE:
				return getTransportVFSFileSortAttribute();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING:
				return isTransportVFSFileSortAscending();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT:
				return getTransportVFSSubFolderTimestampFormat();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER:
				return isTransportVFSCreateFolder();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_RECEIVE_TIMEOUT:
				return getTransportJMSReceiveTimeout();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE:
				return getTransportJMSContentType();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE_PROPERTY:
				return getTransportJMSContentTypeProperty();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_REPLY_DESTINATION:
				return getTransportJMSReplyDestination();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_PUB_SUB_NO_LOCAL:
				return getTransportJMSPubSubNoLocal();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_CONNECTION_FACTORY:
				return getTransportMQTTConnectionFactory();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_HOST_NAME:
				return getTransportMQTTServerHostName();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_PORT:
				return getTransportMQTTServerPort();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_TOPIC_NAME:
				return getTransportMQTTTopicName();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS:
				return getTransportMQTTSubscriptionQOS();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SESSION_CLEAN:
				return isTransportMQTTSessionClean();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_ENABLE:
				return getTransportMQTTSslEnable();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY:
				return getTransportMQTTTemporaryStoreDirectory();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_USERNAME:
				return getTransportMQTTSubscriptionUsername();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD:
				return getTransportMQTTSubscriptionPassword();
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_CLIENT_ID:
				return getTransportMQTTClientId();
			case EsbPackage.INBOUND_ENDPOINT__TRUSTSTORE:
				return getTruststore();
			case EsbPackage.INBOUND_ENDPOINT__KEYSTORE:
				return getKeystore();
			case EsbPackage.INBOUND_ENDPOINT__SSL_VERIFY_CLIENT:
				return getSslVerifyClient();
			case EsbPackage.INBOUND_ENDPOINT__SSL_PROTOCOL:
				return getSslProtocol();
			case EsbPackage.INBOUND_ENDPOINT__HTTPS_PROTOCOLS:
				return getHttpsProtocols();
			case EsbPackage.INBOUND_ENDPOINT__CERTIFICATE_REVOCATION_VERIFIER:
				return getCertificateRevocationVerifier();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PORT:
				return getInboundHL7Port();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK:
				return isInboundHL7AutoAck();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_MESSAGE_PRE_PROCESSOR:
				return getInboundHL7MessagePreProcessor();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_CHAR_SET:
				return getInboundHL7CharSet();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_TIME_OUT:
				return getInboundHL7TimeOut();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE:
				return isInboundHL7ValidateMessage();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES:
				return getInboundHL7BuildInvalidMessages();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES:
				return getInboundHL7PassThroughInvalidMessages();
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_CONNECT:
				return getZookeeperConnect();
			case EsbPackage.INBOUND_ENDPOINT__GROUP_ID:
				return getGroupId();
			case EsbPackage.INBOUND_ENDPOINT__CONSUMER_TYPE:
				return getConsumerType();
			case EsbPackage.INBOUND_ENDPOINT__CONTENT_TYPE:
				return getContentType();
			case EsbPackage.INBOUND_ENDPOINT__TOPICS:
				return getTopics();
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_TOPIC:
				return getSimpleTopic();
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_BROKERS:
				return getSimpleBrokers();
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_PORT:
				return getSimplePort();
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_PARTITION:
				return getSimplePartition();
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_MAX_MESSAGES_TO_READ:
				return getSimpleMaxMessagesToRead();
			case EsbPackage.INBOUND_ENDPOINT__THREAD_COUNT:
				return getThreadCount();
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS:
				return getZookeeperSessionTimeoutMs();
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS:
				return getZookeeperSyncTimeMs();
			case EsbPackage.INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS:
				return getAutoCommitIntervalMs();
			case EsbPackage.INBOUND_ENDPOINT__AUTO_OFFSET_RESET:
				return getAutoOffsetReset();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST:
				return getInboundCxfRmHost();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT:
				return getInboundCxfRmPort();
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE:
				return getInboundCxfRmConfigFile();
			case EsbPackage.INBOUND_ENDPOINT__ENABLE_SSL:
				return isEnableSSL();
			case EsbPackage.INBOUND_ENDPOINT__SERVICE_PARAMETERS:
				return getServiceParameters();
			case EsbPackage.INBOUND_ENDPOINT__SUSPEND:
				return isSuspend();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
				setSequenceInputConnector((InboundEndpointSequenceInputConnector)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
				setSequenceOutputConnector((InboundEndpointSequenceOutputConnector)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
				setOnErrorSequenceInputConnector((InboundEndpointOnErrorSequenceInputConnector)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
				setOnErrorSequenceOutputConnector((InboundEndpointOnErrorSequenceOutputConnector)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
				setContainer((InboundEndpointContainer)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__NAME:
				setName((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TYPE:
				setType((InboundEndpointType)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CLASS:
				setClass((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__PROTOCOL:
				setProtocol((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HTTP_PORT:
				setInboundHttpPort((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_CORE:
				setInboundWorkerPoolSizeCore((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_MAX:
				setInboundWorkerPoolSizeMax((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC:
				setInboundWorkerThreadKeepAliveSec((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_QUEUE_LENGTH:
				setInboundWorkerPoolQueueLength((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_THREAD_GROUP_ID:
				setInboundThreadGroupId((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_THREAD_ID:
				setInboundThreadId((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__DISPATCH_FILTER_PATTERN:
				setDispatchFilterPattern((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INTERVAL:
				setInterval((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENTIAL:
				setSequential((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__COORDINATION:
				setCoordination((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_URI:
				setTransportVFSFileURI((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CONTENT_TYPE:
				setTransportVFSContentType((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_NAME_PATTERN:
				setTransportVFSFileNamePattern((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_INTERVAL:
				setTransportVFSFileProcessInterval((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_COUNT:
				setTransportVFSFileProcessCount((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING:
				setTransportVFSLocking((Enable)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MAX_RETRY_COUNT:
				setTransportVFSMaxRetryCount((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_RECONNECT_TIMEOUT:
				setTransportVFSReconnectTimeout((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS:
				setTransportVFSActionAfterProcess((VFSAction)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_PROCESS:
				setTransportVFSMoveAfterProcess((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_ERRORS:
				setTransportVFSActionAfterErrors((VFSAction)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_ERRORS:
				setTransportVFSMoveAfterErrors((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE:
				setTransportVFSActionAfterFailure((VFSAction)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_FAILURE:
				setTransportVFSMoveAfterFailure((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE:
				setTransportVFSAutoLockRelease((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL:
				setTransportVFSAutoLockReleaseInterval((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE:
				setTransportVFSLockReleaseSameNode((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK:
				setTransportVFSDistributedLock((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING:
				setTransportVFSStreaming((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_BUILD:
				setTransportVFSBuild((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_TIMEOUT:
				setTransportVFSDistributedTimeout((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_FACTORY_INITIAL:
				setJavaNamingFactoryInitial((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_PROVIDER_URL:
				setJavaNamingProviderUrl((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME:
				setTransportJMSConnectionFactoryJNDIName((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE:
				setTransportJMSConnectionFactoryType((JMSConnectionFactoryType)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION:
				setTransportJMSDestination((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED:
				setTransportJMSSessionTransacted((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT:
				setTransportJMSSessionAcknowledgement((JMSSessionAcknowledgement)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL:
				setTransportJMSCacheLevel((JMSCacheLevel)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_USER_NAME:
				setTransportJMSUserName((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_PASSWORD:
				setTransportJMSPassword((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMSJMS_SPEC_VERSION:
				setTransportJMSJMSSpecVersion((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_DURABLE:
				setTransportJMSSubscriptionDurable((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID:
				setTransportJMSDurableSubscriberClientID((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_MESSAGE_SELECTOR:
				setTransportJMSMessageSelector((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__API_DISPATCHING_ENABLED:
				setApiDispatchingEnabled((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT:
				setTransportVFSMoveTimestampFormat((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE:
				setTransportVFSFileSortAttribute((VFSFileSort)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING:
				setTransportVFSFileSortAscending((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT:
				setTransportVFSSubFolderTimestampFormat((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER:
				setTransportVFSCreateFolder((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_RECEIVE_TIMEOUT:
				setTransportJMSReceiveTimeout((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE:
				setTransportJMSContentType((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE_PROPERTY:
				setTransportJMSContentTypeProperty((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_REPLY_DESTINATION:
				setTransportJMSReplyDestination((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_PUB_SUB_NO_LOCAL:
				setTransportJMSPubSubNoLocal((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_CONNECTION_FACTORY:
				setTransportMQTTConnectionFactory((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_HOST_NAME:
				setTransportMQTTServerHostName((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_PORT:
				setTransportMQTTServerPort((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_TOPIC_NAME:
				setTransportMQTTTopicName((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS:
				setTransportMQTTSubscriptionQOS((MQTTSubscriptionQOS)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SESSION_CLEAN:
				setTransportMQTTSessionClean((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_ENABLE:
				setTransportMQTTSslEnable((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY:
				setTransportMQTTTemporaryStoreDirectory((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_USERNAME:
				setTransportMQTTSubscriptionUsername((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD:
				setTransportMQTTSubscriptionPassword((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_CLIENT_ID:
				setTransportMQTTClientId((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRUSTSTORE:
				setTruststore((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__KEYSTORE:
				setKeystore((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SSL_VERIFY_CLIENT:
				setSslVerifyClient((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SSL_PROTOCOL:
				setSslProtocol((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__HTTPS_PROTOCOLS:
				setHttpsProtocols((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CERTIFICATE_REVOCATION_VERIFIER:
				setCertificateRevocationVerifier((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PORT:
				setInboundHL7Port((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK:
				setInboundHL7AutoAck((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_MESSAGE_PRE_PROCESSOR:
				setInboundHL7MessagePreProcessor((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_CHAR_SET:
				setInboundHL7CharSet((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_TIME_OUT:
				setInboundHL7TimeOut((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE:
				setInboundHL7ValidateMessage((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES:
				setInboundHL7BuildInvalidMessages((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES:
				setInboundHL7PassThroughInvalidMessages((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_CONNECT:
				setZookeeperConnect((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__GROUP_ID:
				setGroupId((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CONSUMER_TYPE:
				setConsumerType((ConsumerType)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CONTENT_TYPE:
				setContentType((ContentType)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TOPICS:
				setTopics((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_TOPIC:
				setSimpleTopic((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_BROKERS:
				setSimpleBrokers((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_PORT:
				setSimplePort((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_PARTITION:
				setSimplePartition((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_MAX_MESSAGES_TO_READ:
				setSimpleMaxMessagesToRead((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__THREAD_COUNT:
				setThreadCount((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS:
				setZookeeperSessionTimeoutMs((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS:
				setZookeeperSyncTimeMs((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS:
				setAutoCommitIntervalMs((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__AUTO_OFFSET_RESET:
				setAutoOffsetReset((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST:
				setInboundCxfRmHost((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT:
				setInboundCxfRmPort((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE:
				setInboundCxfRmConfigFile((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ENABLE_SSL:
				setEnableSSL((Boolean)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SERVICE_PARAMETERS:
				getServiceParameters().clear();
				getServiceParameters().addAll((Collection<? extends InboundEndpointParameter>)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SUSPEND:
				setSuspend((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
				setSequenceInputConnector((InboundEndpointSequenceInputConnector)null);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
				setSequenceOutputConnector((InboundEndpointSequenceOutputConnector)null);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
				setOnErrorSequenceInputConnector((InboundEndpointOnErrorSequenceInputConnector)null);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
				setOnErrorSequenceOutputConnector((InboundEndpointOnErrorSequenceOutputConnector)null);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
				setContainer((InboundEndpointContainer)null);
				return;
			case EsbPackage.INBOUND_ENDPOINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CLASS:
				setClass(CLASS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__PROTOCOL:
				setProtocol(PROTOCOL_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HTTP_PORT:
				setInboundHttpPort(INBOUND_HTTP_PORT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_CORE:
				setInboundWorkerPoolSizeCore(INBOUND_WORKER_POOL_SIZE_CORE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_MAX:
				setInboundWorkerPoolSizeMax(INBOUND_WORKER_POOL_SIZE_MAX_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC:
				setInboundWorkerThreadKeepAliveSec(INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_QUEUE_LENGTH:
				setInboundWorkerPoolQueueLength(INBOUND_WORKER_POOL_QUEUE_LENGTH_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_THREAD_GROUP_ID:
				setInboundThreadGroupId(INBOUND_THREAD_GROUP_ID_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_THREAD_ID:
				setInboundThreadId(INBOUND_THREAD_ID_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__DISPATCH_FILTER_PATTERN:
				setDispatchFilterPattern(DISPATCH_FILTER_PATTERN_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INTERVAL:
				setInterval(INTERVAL_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENTIAL:
				setSequential(SEQUENTIAL_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__COORDINATION:
				setCoordination(COORDINATION_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_URI:
				setTransportVFSFileURI(TRANSPORT_VFS_FILE_URI_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CONTENT_TYPE:
				setTransportVFSContentType(TRANSPORT_VFS_CONTENT_TYPE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_NAME_PATTERN:
				setTransportVFSFileNamePattern(TRANSPORT_VFS_FILE_NAME_PATTERN_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_INTERVAL:
				setTransportVFSFileProcessInterval(TRANSPORT_VFS_FILE_PROCESS_INTERVAL_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_COUNT:
				setTransportVFSFileProcessCount(TRANSPORT_VFS_FILE_PROCESS_COUNT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING:
				setTransportVFSLocking(TRANSPORT_VFS_LOCKING_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MAX_RETRY_COUNT:
				setTransportVFSMaxRetryCount(TRANSPORT_VFS_MAX_RETRY_COUNT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_RECONNECT_TIMEOUT:
				setTransportVFSReconnectTimeout(TRANSPORT_VFS_RECONNECT_TIMEOUT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS:
				setTransportVFSActionAfterProcess(TRANSPORT_VFS_ACTION_AFTER_PROCESS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_PROCESS:
				setTransportVFSMoveAfterProcess(TRANSPORT_VFS_MOVE_AFTER_PROCESS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_ERRORS:
				setTransportVFSActionAfterErrors(TRANSPORT_VFS_ACTION_AFTER_ERRORS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_ERRORS:
				setTransportVFSMoveAfterErrors(TRANSPORT_VFS_MOVE_AFTER_ERRORS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE:
				setTransportVFSActionAfterFailure(TRANSPORT_VFS_ACTION_AFTER_FAILURE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_FAILURE:
				setTransportVFSMoveAfterFailure(TRANSPORT_VFS_MOVE_AFTER_FAILURE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE:
				setTransportVFSAutoLockRelease(TRANSPORT_VFS_AUTO_LOCK_RELEASE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL:
				setTransportVFSAutoLockReleaseInterval(TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE:
				setTransportVFSLockReleaseSameNode(TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK:
				setTransportVFSDistributedLock(TRANSPORT_VFS_DISTRIBUTED_LOCK_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING:
				setTransportVFSStreaming(TRANSPORT_VFS_STREAMING_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_BUILD:
				setTransportVFSBuild(TRANSPORT_VFS_BUILD_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_TIMEOUT:
				setTransportVFSDistributedTimeout(TRANSPORT_VFS_DISTRIBUTED_TIMEOUT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_FACTORY_INITIAL:
				setJavaNamingFactoryInitial(JAVA_NAMING_FACTORY_INITIAL_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_PROVIDER_URL:
				setJavaNamingProviderUrl(JAVA_NAMING_PROVIDER_URL_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME:
				setTransportJMSConnectionFactoryJNDIName(TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE:
				setTransportJMSConnectionFactoryType(TRANSPORT_JMS_CONNECTION_FACTORY_TYPE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION:
				setTransportJMSDestination(TRANSPORT_JMS_DESTINATION_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED:
				setTransportJMSSessionTransacted(TRANSPORT_JMS_SESSION_TRANSACTED_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT:
				setTransportJMSSessionAcknowledgement(TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL:
				setTransportJMSCacheLevel(TRANSPORT_JMS_CACHE_LEVEL_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_USER_NAME:
				setTransportJMSUserName(TRANSPORT_JMS_USER_NAME_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_PASSWORD:
				setTransportJMSPassword(TRANSPORT_JMS_PASSWORD_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMSJMS_SPEC_VERSION:
				setTransportJMSJMSSpecVersion(TRANSPORT_JMSJMS_SPEC_VERSION_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_DURABLE:
				setTransportJMSSubscriptionDurable(TRANSPORT_JMS_SUBSCRIPTION_DURABLE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID:
				setTransportJMSDurableSubscriberClientID(TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_MESSAGE_SELECTOR:
				setTransportJMSMessageSelector(TRANSPORT_JMS_MESSAGE_SELECTOR_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__API_DISPATCHING_ENABLED:
				setApiDispatchingEnabled(API_DISPATCHING_ENABLED_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT:
				setTransportVFSMoveTimestampFormat(TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE:
				setTransportVFSFileSortAttribute(TRANSPORT_VFS_FILE_SORT_ATTRIBUTE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING:
				setTransportVFSFileSortAscending(TRANSPORT_VFS_FILE_SORT_ASCENDING_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT:
				setTransportVFSSubFolderTimestampFormat(TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER:
				setTransportVFSCreateFolder(TRANSPORT_VFS_CREATE_FOLDER_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_RECEIVE_TIMEOUT:
				setTransportJMSReceiveTimeout(TRANSPORT_JMS_RECEIVE_TIMEOUT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE:
				setTransportJMSContentType(TRANSPORT_JMS_CONTENT_TYPE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE_PROPERTY:
				setTransportJMSContentTypeProperty(TRANSPORT_JMS_CONTENT_TYPE_PROPERTY_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_REPLY_DESTINATION:
				setTransportJMSReplyDestination(TRANSPORT_JMS_REPLY_DESTINATION_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_PUB_SUB_NO_LOCAL:
				setTransportJMSPubSubNoLocal(TRANSPORT_JMS_PUB_SUB_NO_LOCAL_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_CONNECTION_FACTORY:
				setTransportMQTTConnectionFactory(TRANSPORT_MQTT_CONNECTION_FACTORY_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_HOST_NAME:
				setTransportMQTTServerHostName(TRANSPORT_MQTT_SERVER_HOST_NAME_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_PORT:
				setTransportMQTTServerPort(TRANSPORT_MQTT_SERVER_PORT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_TOPIC_NAME:
				setTransportMQTTTopicName(TRANSPORT_MQTT_TOPIC_NAME_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS:
				setTransportMQTTSubscriptionQOS(TRANSPORT_MQTT_SUBSCRIPTION_QOS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SESSION_CLEAN:
				setTransportMQTTSessionClean(TRANSPORT_MQTT_SESSION_CLEAN_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_ENABLE:
				setTransportMQTTSslEnable(TRANSPORT_MQTT_SSL_ENABLE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY:
				setTransportMQTTTemporaryStoreDirectory(TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_USERNAME:
				setTransportMQTTSubscriptionUsername(TRANSPORT_MQTT_SUBSCRIPTION_USERNAME_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD:
				setTransportMQTTSubscriptionPassword(TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_CLIENT_ID:
				setTransportMQTTClientId(TRANSPORT_MQTT_CLIENT_ID_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TRUSTSTORE:
				setTruststore(TRUSTSTORE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__KEYSTORE:
				setKeystore(KEYSTORE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SSL_VERIFY_CLIENT:
				setSslVerifyClient(SSL_VERIFY_CLIENT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SSL_PROTOCOL:
				setSslProtocol(SSL_PROTOCOL_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__HTTPS_PROTOCOLS:
				setHttpsProtocols(HTTPS_PROTOCOLS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CERTIFICATE_REVOCATION_VERIFIER:
				setCertificateRevocationVerifier(CERTIFICATE_REVOCATION_VERIFIER_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PORT:
				setInboundHL7Port(INBOUND_HL7_PORT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK:
				setInboundHL7AutoAck(INBOUND_HL7_AUTO_ACK_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_MESSAGE_PRE_PROCESSOR:
				setInboundHL7MessagePreProcessor(INBOUND_HL7_MESSAGE_PRE_PROCESSOR_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_CHAR_SET:
				setInboundHL7CharSet(INBOUND_HL7_CHAR_SET_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_TIME_OUT:
				setInboundHL7TimeOut(INBOUND_HL7_TIME_OUT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE:
				setInboundHL7ValidateMessage(INBOUND_HL7_VALIDATE_MESSAGE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES:
				setInboundHL7BuildInvalidMessages(INBOUND_HL7_BUILD_INVALID_MESSAGES_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES:
				setInboundHL7PassThroughInvalidMessages(INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_CONNECT:
				setZookeeperConnect(ZOOKEEPER_CONNECT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__GROUP_ID:
				setGroupId(GROUP_ID_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CONSUMER_TYPE:
				setConsumerType(CONSUMER_TYPE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CONTENT_TYPE:
				setContentType(CONTENT_TYPE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__TOPICS:
				setTopics(TOPICS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_TOPIC:
				setSimpleTopic(SIMPLE_TOPIC_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_BROKERS:
				setSimpleBrokers(SIMPLE_BROKERS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_PORT:
				setSimplePort(SIMPLE_PORT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_PARTITION:
				setSimplePartition(SIMPLE_PARTITION_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_MAX_MESSAGES_TO_READ:
				setSimpleMaxMessagesToRead(SIMPLE_MAX_MESSAGES_TO_READ_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__THREAD_COUNT:
				setThreadCount(THREAD_COUNT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS:
				setZookeeperSessionTimeoutMs(ZOOKEEPER_SESSION_TIMEOUT_MS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS:
				setZookeeperSyncTimeMs(ZOOKEEPER_SYNC_TIME_MS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS:
				setAutoCommitIntervalMs(AUTO_COMMIT_INTERVAL_MS_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__AUTO_OFFSET_RESET:
				setAutoOffsetReset(AUTO_OFFSET_RESET_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST:
				setInboundCxfRmHost(INBOUND_CXF_RM_HOST_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT:
				setInboundCxfRmPort(INBOUND_CXF_RM_PORT_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE:
				setInboundCxfRmConfigFile(INBOUND_CXF_RM_CONFIG_FILE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ENABLE_SSL:
				setEnableSSL(ENABLE_SSL_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SERVICE_PARAMETERS:
				getServiceParameters().clear();
				return;
			case EsbPackage.INBOUND_ENDPOINT__SUSPEND:
				setSuspend(SUSPEND_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
				return sequenceInputConnector != null;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
				return sequenceOutputConnector != null;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
				return onErrorSequenceInputConnector != null;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
				return onErrorSequenceOutputConnector != null;
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
				return container != null;
			case EsbPackage.INBOUND_ENDPOINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EsbPackage.INBOUND_ENDPOINT__TYPE:
				return type != TYPE_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__CLASS:
				return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
			case EsbPackage.INBOUND_ENDPOINT__PROTOCOL:
				return PROTOCOL_EDEFAULT == null ? protocol != null : !PROTOCOL_EDEFAULT.equals(protocol);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HTTP_PORT:
				return INBOUND_HTTP_PORT_EDEFAULT == null ? inboundHttpPort != null : !INBOUND_HTTP_PORT_EDEFAULT.equals(inboundHttpPort);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_CORE:
				return INBOUND_WORKER_POOL_SIZE_CORE_EDEFAULT == null ? inboundWorkerPoolSizeCore != null : !INBOUND_WORKER_POOL_SIZE_CORE_EDEFAULT.equals(inboundWorkerPoolSizeCore);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_MAX:
				return INBOUND_WORKER_POOL_SIZE_MAX_EDEFAULT == null ? inboundWorkerPoolSizeMax != null : !INBOUND_WORKER_POOL_SIZE_MAX_EDEFAULT.equals(inboundWorkerPoolSizeMax);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC:
				return INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC_EDEFAULT == null ? inboundWorkerThreadKeepAliveSec != null : !INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC_EDEFAULT.equals(inboundWorkerThreadKeepAliveSec);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_QUEUE_LENGTH:
				return INBOUND_WORKER_POOL_QUEUE_LENGTH_EDEFAULT == null ? inboundWorkerPoolQueueLength != null : !INBOUND_WORKER_POOL_QUEUE_LENGTH_EDEFAULT.equals(inboundWorkerPoolQueueLength);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_THREAD_GROUP_ID:
				return INBOUND_THREAD_GROUP_ID_EDEFAULT == null ? inboundThreadGroupId != null : !INBOUND_THREAD_GROUP_ID_EDEFAULT.equals(inboundThreadGroupId);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_THREAD_ID:
				return INBOUND_THREAD_ID_EDEFAULT == null ? inboundThreadId != null : !INBOUND_THREAD_ID_EDEFAULT.equals(inboundThreadId);
			case EsbPackage.INBOUND_ENDPOINT__DISPATCH_FILTER_PATTERN:
				return DISPATCH_FILTER_PATTERN_EDEFAULT == null ? dispatchFilterPattern != null : !DISPATCH_FILTER_PATTERN_EDEFAULT.equals(dispatchFilterPattern);
			case EsbPackage.INBOUND_ENDPOINT__INTERVAL:
				return INTERVAL_EDEFAULT == null ? interval != null : !INTERVAL_EDEFAULT.equals(interval);
			case EsbPackage.INBOUND_ENDPOINT__SEQUENTIAL:
				return sequential != SEQUENTIAL_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__COORDINATION:
				return coordination != COORDINATION_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_URI:
				return TRANSPORT_VFS_FILE_URI_EDEFAULT == null ? transportVFSFileURI != null : !TRANSPORT_VFS_FILE_URI_EDEFAULT.equals(transportVFSFileURI);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CONTENT_TYPE:
				return TRANSPORT_VFS_CONTENT_TYPE_EDEFAULT == null ? transportVFSContentType != null : !TRANSPORT_VFS_CONTENT_TYPE_EDEFAULT.equals(transportVFSContentType);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_NAME_PATTERN:
				return TRANSPORT_VFS_FILE_NAME_PATTERN_EDEFAULT == null ? transportVFSFileNamePattern != null : !TRANSPORT_VFS_FILE_NAME_PATTERN_EDEFAULT.equals(transportVFSFileNamePattern);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_INTERVAL:
				return TRANSPORT_VFS_FILE_PROCESS_INTERVAL_EDEFAULT == null ? transportVFSFileProcessInterval != null : !TRANSPORT_VFS_FILE_PROCESS_INTERVAL_EDEFAULT.equals(transportVFSFileProcessInterval);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_PROCESS_COUNT:
				return TRANSPORT_VFS_FILE_PROCESS_COUNT_EDEFAULT == null ? transportVFSFileProcessCount != null : !TRANSPORT_VFS_FILE_PROCESS_COUNT_EDEFAULT.equals(transportVFSFileProcessCount);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCKING:
				return transportVFSLocking != TRANSPORT_VFS_LOCKING_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MAX_RETRY_COUNT:
				return TRANSPORT_VFS_MAX_RETRY_COUNT_EDEFAULT == null ? transportVFSMaxRetryCount != null : !TRANSPORT_VFS_MAX_RETRY_COUNT_EDEFAULT.equals(transportVFSMaxRetryCount);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_RECONNECT_TIMEOUT:
				return TRANSPORT_VFS_RECONNECT_TIMEOUT_EDEFAULT == null ? transportVFSReconnectTimeout != null : !TRANSPORT_VFS_RECONNECT_TIMEOUT_EDEFAULT.equals(transportVFSReconnectTimeout);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_PROCESS:
				return transportVFSActionAfterProcess != TRANSPORT_VFS_ACTION_AFTER_PROCESS_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_PROCESS:
				return TRANSPORT_VFS_MOVE_AFTER_PROCESS_EDEFAULT == null ? transportVFSMoveAfterProcess != null : !TRANSPORT_VFS_MOVE_AFTER_PROCESS_EDEFAULT.equals(transportVFSMoveAfterProcess);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_ERRORS:
				return transportVFSActionAfterErrors != TRANSPORT_VFS_ACTION_AFTER_ERRORS_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_ERRORS:
				return TRANSPORT_VFS_MOVE_AFTER_ERRORS_EDEFAULT == null ? transportVFSMoveAfterErrors != null : !TRANSPORT_VFS_MOVE_AFTER_ERRORS_EDEFAULT.equals(transportVFSMoveAfterErrors);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_ACTION_AFTER_FAILURE:
				return transportVFSActionAfterFailure != TRANSPORT_VFS_ACTION_AFTER_FAILURE_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_AFTER_FAILURE:
				return TRANSPORT_VFS_MOVE_AFTER_FAILURE_EDEFAULT == null ? transportVFSMoveAfterFailure != null : !TRANSPORT_VFS_MOVE_AFTER_FAILURE_EDEFAULT.equals(transportVFSMoveAfterFailure);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE:
				return transportVFSAutoLockRelease != TRANSPORT_VFS_AUTO_LOCK_RELEASE_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL:
				return TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL_EDEFAULT == null ? transportVFSAutoLockReleaseInterval != null : !TRANSPORT_VFS_AUTO_LOCK_RELEASE_INTERVAL_EDEFAULT.equals(transportVFSAutoLockReleaseInterval);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE:
				return transportVFSLockReleaseSameNode != TRANSPORT_VFS_LOCK_RELEASE_SAME_NODE_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_LOCK:
				return transportVFSDistributedLock != TRANSPORT_VFS_DISTRIBUTED_LOCK_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_STREAMING:
				return transportVFSStreaming != TRANSPORT_VFS_STREAMING_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_BUILD:
				return transportVFSBuild != TRANSPORT_VFS_BUILD_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_DISTRIBUTED_TIMEOUT:
				return TRANSPORT_VFS_DISTRIBUTED_TIMEOUT_EDEFAULT == null ? transportVFSDistributedTimeout != null : !TRANSPORT_VFS_DISTRIBUTED_TIMEOUT_EDEFAULT.equals(transportVFSDistributedTimeout);
			case EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_FACTORY_INITIAL:
				return JAVA_NAMING_FACTORY_INITIAL_EDEFAULT == null ? javaNamingFactoryInitial != null : !JAVA_NAMING_FACTORY_INITIAL_EDEFAULT.equals(javaNamingFactoryInitial);
			case EsbPackage.INBOUND_ENDPOINT__JAVA_NAMING_PROVIDER_URL:
				return JAVA_NAMING_PROVIDER_URL_EDEFAULT == null ? javaNamingProviderUrl != null : !JAVA_NAMING_PROVIDER_URL_EDEFAULT.equals(javaNamingProviderUrl);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME:
				return TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME_EDEFAULT == null ? transportJMSConnectionFactoryJNDIName != null : !TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME_EDEFAULT.equals(transportJMSConnectionFactoryJNDIName);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE:
				return transportJMSConnectionFactoryType != TRANSPORT_JMS_CONNECTION_FACTORY_TYPE_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION:
				return TRANSPORT_JMS_DESTINATION_EDEFAULT == null ? transportJMSDestination != null : !TRANSPORT_JMS_DESTINATION_EDEFAULT.equals(transportJMSDestination);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED:
				return transportJMSSessionTransacted != TRANSPORT_JMS_SESSION_TRANSACTED_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT:
				return transportJMSSessionAcknowledgement != TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL:
				return transportJMSCacheLevel != TRANSPORT_JMS_CACHE_LEVEL_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_USER_NAME:
				return TRANSPORT_JMS_USER_NAME_EDEFAULT == null ? transportJMSUserName != null : !TRANSPORT_JMS_USER_NAME_EDEFAULT.equals(transportJMSUserName);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_PASSWORD:
				return TRANSPORT_JMS_PASSWORD_EDEFAULT == null ? transportJMSPassword != null : !TRANSPORT_JMS_PASSWORD_EDEFAULT.equals(transportJMSPassword);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMSJMS_SPEC_VERSION:
				return TRANSPORT_JMSJMS_SPEC_VERSION_EDEFAULT == null ? transportJMSJMSSpecVersion != null : !TRANSPORT_JMSJMS_SPEC_VERSION_EDEFAULT.equals(transportJMSJMSSpecVersion);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_DURABLE:
				return TRANSPORT_JMS_SUBSCRIPTION_DURABLE_EDEFAULT == null ? transportJMSSubscriptionDurable != null : !TRANSPORT_JMS_SUBSCRIPTION_DURABLE_EDEFAULT.equals(transportJMSSubscriptionDurable);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID:
				return TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID_EDEFAULT == null ? transportJMSDurableSubscriberClientID != null : !TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID_EDEFAULT.equals(transportJMSDurableSubscriberClientID);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_MESSAGE_SELECTOR:
				return TRANSPORT_JMS_MESSAGE_SELECTOR_EDEFAULT == null ? transportJMSMessageSelector != null : !TRANSPORT_JMS_MESSAGE_SELECTOR_EDEFAULT.equals(transportJMSMessageSelector);
			case EsbPackage.INBOUND_ENDPOINT__API_DISPATCHING_ENABLED:
				return apiDispatchingEnabled != API_DISPATCHING_ENABLED_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT:
				return TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT_EDEFAULT == null ? transportVFSMoveTimestampFormat != null : !TRANSPORT_VFS_MOVE_TIMESTAMP_FORMAT_EDEFAULT.equals(transportVFSMoveTimestampFormat);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ATTRIBUTE:
				return transportVFSFileSortAttribute != TRANSPORT_VFS_FILE_SORT_ATTRIBUTE_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_FILE_SORT_ASCENDING:
				return transportVFSFileSortAscending != TRANSPORT_VFS_FILE_SORT_ASCENDING_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT:
				return TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT_EDEFAULT == null ? transportVFSSubFolderTimestampFormat != null : !TRANSPORT_VFS_SUB_FOLDER_TIMESTAMP_FORMAT_EDEFAULT.equals(transportVFSSubFolderTimestampFormat);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_VFS_CREATE_FOLDER:
				return transportVFSCreateFolder != TRANSPORT_VFS_CREATE_FOLDER_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_RECEIVE_TIMEOUT:
				return TRANSPORT_JMS_RECEIVE_TIMEOUT_EDEFAULT == null ? transportJMSReceiveTimeout != null : !TRANSPORT_JMS_RECEIVE_TIMEOUT_EDEFAULT.equals(transportJMSReceiveTimeout);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE:
				return TRANSPORT_JMS_CONTENT_TYPE_EDEFAULT == null ? transportJMSContentType != null : !TRANSPORT_JMS_CONTENT_TYPE_EDEFAULT.equals(transportJMSContentType);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE_PROPERTY:
				return TRANSPORT_JMS_CONTENT_TYPE_PROPERTY_EDEFAULT == null ? transportJMSContentTypeProperty != null : !TRANSPORT_JMS_CONTENT_TYPE_PROPERTY_EDEFAULT.equals(transportJMSContentTypeProperty);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_REPLY_DESTINATION:
				return TRANSPORT_JMS_REPLY_DESTINATION_EDEFAULT == null ? transportJMSReplyDestination != null : !TRANSPORT_JMS_REPLY_DESTINATION_EDEFAULT.equals(transportJMSReplyDestination);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_JMS_PUB_SUB_NO_LOCAL:
				return TRANSPORT_JMS_PUB_SUB_NO_LOCAL_EDEFAULT == null ? transportJMSPubSubNoLocal != null : !TRANSPORT_JMS_PUB_SUB_NO_LOCAL_EDEFAULT.equals(transportJMSPubSubNoLocal);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_CONNECTION_FACTORY:
				return TRANSPORT_MQTT_CONNECTION_FACTORY_EDEFAULT == null ? transportMQTTConnectionFactory != null : !TRANSPORT_MQTT_CONNECTION_FACTORY_EDEFAULT.equals(transportMQTTConnectionFactory);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_HOST_NAME:
				return TRANSPORT_MQTT_SERVER_HOST_NAME_EDEFAULT == null ? transportMQTTServerHostName != null : !TRANSPORT_MQTT_SERVER_HOST_NAME_EDEFAULT.equals(transportMQTTServerHostName);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_PORT:
				return TRANSPORT_MQTT_SERVER_PORT_EDEFAULT == null ? transportMQTTServerPort != null : !TRANSPORT_MQTT_SERVER_PORT_EDEFAULT.equals(transportMQTTServerPort);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_TOPIC_NAME:
				return TRANSPORT_MQTT_TOPIC_NAME_EDEFAULT == null ? transportMQTTTopicName != null : !TRANSPORT_MQTT_TOPIC_NAME_EDEFAULT.equals(transportMQTTTopicName);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS:
				return transportMQTTSubscriptionQOS != TRANSPORT_MQTT_SUBSCRIPTION_QOS_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SESSION_CLEAN:
				return transportMQTTSessionClean != TRANSPORT_MQTT_SESSION_CLEAN_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_ENABLE:
				return TRANSPORT_MQTT_SSL_ENABLE_EDEFAULT == null ? transportMQTTSslEnable != null : !TRANSPORT_MQTT_SSL_ENABLE_EDEFAULT.equals(transportMQTTSslEnable);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY:
				return TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY_EDEFAULT == null ? transportMQTTTemporaryStoreDirectory != null : !TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY_EDEFAULT.equals(transportMQTTTemporaryStoreDirectory);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_USERNAME:
				return TRANSPORT_MQTT_SUBSCRIPTION_USERNAME_EDEFAULT == null ? transportMQTTSubscriptionUsername != null : !TRANSPORT_MQTT_SUBSCRIPTION_USERNAME_EDEFAULT.equals(transportMQTTSubscriptionUsername);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD:
				return TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD_EDEFAULT == null ? transportMQTTSubscriptionPassword != null : !TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD_EDEFAULT.equals(transportMQTTSubscriptionPassword);
			case EsbPackage.INBOUND_ENDPOINT__TRANSPORT_MQTT_CLIENT_ID:
				return TRANSPORT_MQTT_CLIENT_ID_EDEFAULT == null ? transportMQTTClientId != null : !TRANSPORT_MQTT_CLIENT_ID_EDEFAULT.equals(transportMQTTClientId);
			case EsbPackage.INBOUND_ENDPOINT__TRUSTSTORE:
				return TRUSTSTORE_EDEFAULT == null ? truststore != null : !TRUSTSTORE_EDEFAULT.equals(truststore);
			case EsbPackage.INBOUND_ENDPOINT__KEYSTORE:
				return KEYSTORE_EDEFAULT == null ? keystore != null : !KEYSTORE_EDEFAULT.equals(keystore);
			case EsbPackage.INBOUND_ENDPOINT__SSL_VERIFY_CLIENT:
				return SSL_VERIFY_CLIENT_EDEFAULT == null ? sslVerifyClient != null : !SSL_VERIFY_CLIENT_EDEFAULT.equals(sslVerifyClient);
			case EsbPackage.INBOUND_ENDPOINT__SSL_PROTOCOL:
				return SSL_PROTOCOL_EDEFAULT == null ? sslProtocol != null : !SSL_PROTOCOL_EDEFAULT.equals(sslProtocol);
			case EsbPackage.INBOUND_ENDPOINT__HTTPS_PROTOCOLS:
				return HTTPS_PROTOCOLS_EDEFAULT == null ? httpsProtocols != null : !HTTPS_PROTOCOLS_EDEFAULT.equals(httpsProtocols);
			case EsbPackage.INBOUND_ENDPOINT__CERTIFICATE_REVOCATION_VERIFIER:
				return CERTIFICATE_REVOCATION_VERIFIER_EDEFAULT == null ? certificateRevocationVerifier != null : !CERTIFICATE_REVOCATION_VERIFIER_EDEFAULT.equals(certificateRevocationVerifier);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PORT:
				return INBOUND_HL7_PORT_EDEFAULT == null ? inboundHL7Port != null : !INBOUND_HL7_PORT_EDEFAULT.equals(inboundHL7Port);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK:
				return inboundHL7AutoAck != INBOUND_HL7_AUTO_ACK_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_MESSAGE_PRE_PROCESSOR:
				return INBOUND_HL7_MESSAGE_PRE_PROCESSOR_EDEFAULT == null ? inboundHL7MessagePreProcessor != null : !INBOUND_HL7_MESSAGE_PRE_PROCESSOR_EDEFAULT.equals(inboundHL7MessagePreProcessor);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_CHAR_SET:
				return INBOUND_HL7_CHAR_SET_EDEFAULT == null ? inboundHL7CharSet != null : !INBOUND_HL7_CHAR_SET_EDEFAULT.equals(inboundHL7CharSet);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_TIME_OUT:
				return INBOUND_HL7_TIME_OUT_EDEFAULT == null ? inboundHL7TimeOut != null : !INBOUND_HL7_TIME_OUT_EDEFAULT.equals(inboundHL7TimeOut);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE:
				return inboundHL7ValidateMessage != INBOUND_HL7_VALIDATE_MESSAGE_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES:
				return INBOUND_HL7_BUILD_INVALID_MESSAGES_EDEFAULT == null ? inboundHL7BuildInvalidMessages != null : !INBOUND_HL7_BUILD_INVALID_MESSAGES_EDEFAULT.equals(inboundHL7BuildInvalidMessages);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES:
				return INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES_EDEFAULT == null ? inboundHL7PassThroughInvalidMessages != null : !INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES_EDEFAULT.equals(inboundHL7PassThroughInvalidMessages);
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_CONNECT:
				return ZOOKEEPER_CONNECT_EDEFAULT == null ? zookeeperConnect != null : !ZOOKEEPER_CONNECT_EDEFAULT.equals(zookeeperConnect);
			case EsbPackage.INBOUND_ENDPOINT__GROUP_ID:
				return GROUP_ID_EDEFAULT == null ? groupId != null : !GROUP_ID_EDEFAULT.equals(groupId);
			case EsbPackage.INBOUND_ENDPOINT__CONSUMER_TYPE:
				return consumerType != CONSUMER_TYPE_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__CONTENT_TYPE:
				return contentType != CONTENT_TYPE_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__TOPICS:
				return TOPICS_EDEFAULT == null ? topics != null : !TOPICS_EDEFAULT.equals(topics);
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_TOPIC:
				return SIMPLE_TOPIC_EDEFAULT == null ? simpleTopic != null : !SIMPLE_TOPIC_EDEFAULT.equals(simpleTopic);
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_BROKERS:
				return SIMPLE_BROKERS_EDEFAULT == null ? simpleBrokers != null : !SIMPLE_BROKERS_EDEFAULT.equals(simpleBrokers);
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_PORT:
				return SIMPLE_PORT_EDEFAULT == null ? simplePort != null : !SIMPLE_PORT_EDEFAULT.equals(simplePort);
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_PARTITION:
				return SIMPLE_PARTITION_EDEFAULT == null ? simplePartition != null : !SIMPLE_PARTITION_EDEFAULT.equals(simplePartition);
			case EsbPackage.INBOUND_ENDPOINT__SIMPLE_MAX_MESSAGES_TO_READ:
				return SIMPLE_MAX_MESSAGES_TO_READ_EDEFAULT == null ? simpleMaxMessagesToRead != null : !SIMPLE_MAX_MESSAGES_TO_READ_EDEFAULT.equals(simpleMaxMessagesToRead);
			case EsbPackage.INBOUND_ENDPOINT__THREAD_COUNT:
				return THREAD_COUNT_EDEFAULT == null ? threadCount != null : !THREAD_COUNT_EDEFAULT.equals(threadCount);
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS:
				return ZOOKEEPER_SESSION_TIMEOUT_MS_EDEFAULT == null ? zookeeperSessionTimeoutMs != null : !ZOOKEEPER_SESSION_TIMEOUT_MS_EDEFAULT.equals(zookeeperSessionTimeoutMs);
			case EsbPackage.INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS:
				return ZOOKEEPER_SYNC_TIME_MS_EDEFAULT == null ? zookeeperSyncTimeMs != null : !ZOOKEEPER_SYNC_TIME_MS_EDEFAULT.equals(zookeeperSyncTimeMs);
			case EsbPackage.INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS:
				return AUTO_COMMIT_INTERVAL_MS_EDEFAULT == null ? autoCommitIntervalMs != null : !AUTO_COMMIT_INTERVAL_MS_EDEFAULT.equals(autoCommitIntervalMs);
			case EsbPackage.INBOUND_ENDPOINT__AUTO_OFFSET_RESET:
				return AUTO_OFFSET_RESET_EDEFAULT == null ? autoOffsetReset != null : !AUTO_OFFSET_RESET_EDEFAULT.equals(autoOffsetReset);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST:
				return INBOUND_CXF_RM_HOST_EDEFAULT == null ? inboundCxfRmHost != null : !INBOUND_CXF_RM_HOST_EDEFAULT.equals(inboundCxfRmHost);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT:
				return INBOUND_CXF_RM_PORT_EDEFAULT == null ? inboundCxfRmPort != null : !INBOUND_CXF_RM_PORT_EDEFAULT.equals(inboundCxfRmPort);
			case EsbPackage.INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE:
				return INBOUND_CXF_RM_CONFIG_FILE_EDEFAULT == null ? inboundCxfRmConfigFile != null : !INBOUND_CXF_RM_CONFIG_FILE_EDEFAULT.equals(inboundCxfRmConfigFile);
			case EsbPackage.INBOUND_ENDPOINT__ENABLE_SSL:
				return enableSSL != ENABLE_SSL_EDEFAULT;
			case EsbPackage.INBOUND_ENDPOINT__SERVICE_PARAMETERS:
				return serviceParameters != null && !serviceParameters.isEmpty();
			case EsbPackage.INBOUND_ENDPOINT__SUSPEND:
				return suspend != SUSPEND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", class: ");
		result.append(class_);
		result.append(", protocol: ");
		result.append(protocol);
		result.append(", inboundHttpPort: ");
		result.append(inboundHttpPort);
		result.append(", inboundWorkerPoolSizeCore: ");
		result.append(inboundWorkerPoolSizeCore);
		result.append(", inboundWorkerPoolSizeMax: ");
		result.append(inboundWorkerPoolSizeMax);
		result.append(", inboundWorkerThreadKeepAliveSec: ");
		result.append(inboundWorkerThreadKeepAliveSec);
		result.append(", inboundWorkerPoolQueueLength: ");
		result.append(inboundWorkerPoolQueueLength);
		result.append(", inboundThreadGroupId: ");
		result.append(inboundThreadGroupId);
		result.append(", inboundThreadId: ");
		result.append(inboundThreadId);
		result.append(", dispatchFilterPattern: ");
		result.append(dispatchFilterPattern);
		result.append(", interval: ");
		result.append(interval);
		result.append(", sequential: ");
		result.append(sequential);
		result.append(", coordination: ");
		result.append(coordination);
		result.append(", transportVFSFileURI: ");
		result.append(transportVFSFileURI);
		result.append(", transportVFSContentType: ");
		result.append(transportVFSContentType);
		result.append(", transportVFSFileNamePattern: ");
		result.append(transportVFSFileNamePattern);
		result.append(", transportVFSFileProcessInterval: ");
		result.append(transportVFSFileProcessInterval);
		result.append(", transportVFSFileProcessCount: ");
		result.append(transportVFSFileProcessCount);
		result.append(", transportVFSLocking: ");
		result.append(transportVFSLocking);
		result.append(", transportVFSMaxRetryCount: ");
		result.append(transportVFSMaxRetryCount);
		result.append(", transportVFSReconnectTimeout: ");
		result.append(transportVFSReconnectTimeout);
		result.append(", transportVFSActionAfterProcess: ");
		result.append(transportVFSActionAfterProcess);
		result.append(", transportVFSMoveAfterProcess: ");
		result.append(transportVFSMoveAfterProcess);
		result.append(", transportVFSActionAfterErrors: ");
		result.append(transportVFSActionAfterErrors);
		result.append(", transportVFSMoveAfterErrors: ");
		result.append(transportVFSMoveAfterErrors);
		result.append(", transportVFSActionAfterFailure: ");
		result.append(transportVFSActionAfterFailure);
		result.append(", transportVFSMoveAfterFailure: ");
		result.append(transportVFSMoveAfterFailure);
		result.append(", transportVFSAutoLockRelease: ");
		result.append(transportVFSAutoLockRelease);
		result.append(", transportVFSAutoLockReleaseInterval: ");
		result.append(transportVFSAutoLockReleaseInterval);
		result.append(", transportVFSLockReleaseSameNode: ");
		result.append(transportVFSLockReleaseSameNode);
		result.append(", transportVFSDistributedLock: ");
		result.append(transportVFSDistributedLock);
		result.append(", transportVFSStreaming: ");
		result.append(transportVFSStreaming);
		result.append(", transportVFSBuild: ");
		result.append(transportVFSBuild);
		result.append(", transportVFSDistributedTimeout: ");
		result.append(transportVFSDistributedTimeout);
		result.append(", javaNamingFactoryInitial: ");
		result.append(javaNamingFactoryInitial);
		result.append(", javaNamingProviderUrl: ");
		result.append(javaNamingProviderUrl);
		result.append(", transportJMSConnectionFactoryJNDIName: ");
		result.append(transportJMSConnectionFactoryJNDIName);
		result.append(", transportJMSConnectionFactoryType: ");
		result.append(transportJMSConnectionFactoryType);
		result.append(", transportJMSDestination: ");
		result.append(transportJMSDestination);
		result.append(", transportJMSSessionTransacted: ");
		result.append(transportJMSSessionTransacted);
		result.append(", transportJMSSessionAcknowledgement: ");
		result.append(transportJMSSessionAcknowledgement);
		result.append(", transportJMSCacheLevel: ");
		result.append(transportJMSCacheLevel);
		result.append(", transportJMSUserName: ");
		result.append(transportJMSUserName);
		result.append(", transportJMSPassword: ");
		result.append(transportJMSPassword);
		result.append(", transportJMSJMSSpecVersion: ");
		result.append(transportJMSJMSSpecVersion);
		result.append(", transportJMSSubscriptionDurable: ");
		result.append(transportJMSSubscriptionDurable);
		result.append(", transportJMSDurableSubscriberClientID: ");
		result.append(transportJMSDurableSubscriberClientID);
		result.append(", transportJMSMessageSelector: ");
		result.append(transportJMSMessageSelector);
		result.append(", apiDispatchingEnabled: ");
		result.append(apiDispatchingEnabled);
		result.append(", transportVFSMoveTimestampFormat: ");
		result.append(transportVFSMoveTimestampFormat);
		result.append(", transportVFSFileSortAttribute: ");
		result.append(transportVFSFileSortAttribute);
		result.append(", transportVFSFileSortAscending: ");
		result.append(transportVFSFileSortAscending);
		result.append(", transportVFSSubFolderTimestampFormat: ");
		result.append(transportVFSSubFolderTimestampFormat);
		result.append(", transportVFSCreateFolder: ");
		result.append(transportVFSCreateFolder);
		result.append(", transportJMSReceiveTimeout: ");
		result.append(transportJMSReceiveTimeout);
		result.append(", transportJMSContentType: ");
		result.append(transportJMSContentType);
		result.append(", transportJMSContentTypeProperty: ");
		result.append(transportJMSContentTypeProperty);
		result.append(", transportJMSReplyDestination: ");
		result.append(transportJMSReplyDestination);
		result.append(", transportJMSPubSubNoLocal: ");
		result.append(transportJMSPubSubNoLocal);
		result.append(", transportMQTTConnectionFactory: ");
		result.append(transportMQTTConnectionFactory);
		result.append(", transportMQTTServerHostName: ");
		result.append(transportMQTTServerHostName);
		result.append(", transportMQTTServerPort: ");
		result.append(transportMQTTServerPort);
		result.append(", transportMQTTTopicName: ");
		result.append(transportMQTTTopicName);
		result.append(", transportMQTTSubscriptionQOS: ");
		result.append(transportMQTTSubscriptionQOS);
		result.append(", transportMQTTSessionClean: ");
		result.append(transportMQTTSessionClean);
		result.append(", transportMQTTSslEnable: ");
		result.append(transportMQTTSslEnable);
		result.append(", transportMQTTTemporaryStoreDirectory: ");
		result.append(transportMQTTTemporaryStoreDirectory);
		result.append(", transportMQTTSubscriptionUsername: ");
		result.append(transportMQTTSubscriptionUsername);
		result.append(", transportMQTTSubscriptionPassword: ");
		result.append(transportMQTTSubscriptionPassword);
		result.append(", transportMQTTClientId: ");
		result.append(transportMQTTClientId);
		result.append(", truststore: ");
		result.append(truststore);
		result.append(", keystore: ");
		result.append(keystore);
		result.append(", sslVerifyClient: ");
		result.append(sslVerifyClient);
		result.append(", sslProtocol: ");
		result.append(sslProtocol);
		result.append(", httpsProtocols: ");
		result.append(httpsProtocols);
		result.append(", certificateRevocationVerifier: ");
		result.append(certificateRevocationVerifier);
		result.append(", inboundHL7Port: ");
		result.append(inboundHL7Port);
		result.append(", inboundHL7AutoAck: ");
		result.append(inboundHL7AutoAck);
		result.append(", inboundHL7MessagePreProcessor: ");
		result.append(inboundHL7MessagePreProcessor);
		result.append(", inboundHL7CharSet: ");
		result.append(inboundHL7CharSet);
		result.append(", inboundHL7TimeOut: ");
		result.append(inboundHL7TimeOut);
		result.append(", inboundHL7ValidateMessage: ");
		result.append(inboundHL7ValidateMessage);
		result.append(", inboundHL7BuildInvalidMessages: ");
		result.append(inboundHL7BuildInvalidMessages);
		result.append(", inboundHL7PassThroughInvalidMessages: ");
		result.append(inboundHL7PassThroughInvalidMessages);
		result.append(", zookeeperConnect: ");
		result.append(zookeeperConnect);
		result.append(", groupId: ");
		result.append(groupId);
		result.append(", consumerType: ");
		result.append(consumerType);
		result.append(", contentType: ");
		result.append(contentType);
		result.append(", topics: ");
		result.append(topics);
		result.append(", simpleTopic: ");
		result.append(simpleTopic);
		result.append(", simpleBrokers: ");
		result.append(simpleBrokers);
		result.append(", simplePort: ");
		result.append(simplePort);
		result.append(", simplePartition: ");
		result.append(simplePartition);
		result.append(", simpleMaxMessagesToRead: ");
		result.append(simpleMaxMessagesToRead);
		result.append(", threadCount: ");
		result.append(threadCount);
		result.append(", zookeeperSessionTimeoutMs: ");
		result.append(zookeeperSessionTimeoutMs);
		result.append(", zookeeperSyncTimeMs: ");
		result.append(zookeeperSyncTimeMs);
		result.append(", autoCommitIntervalMs: ");
		result.append(autoCommitIntervalMs);
		result.append(", autoOffsetReset: ");
		result.append(autoOffsetReset);
		result.append(", inboundCxfRmHost: ");
		result.append(inboundCxfRmHost);
		result.append(", inboundCxfRmPort: ");
		result.append(inboundCxfRmPort);
		result.append(", inboundCxfRmConfigFile: ");
		result.append(inboundCxfRmConfigFile);
		result.append(", enableSSL: ");
		result.append(enableSSL);
		result.append(", suspend: ");
		result.append(suspend);
		result.append(')');
		return result.toString();
	}

} //InboundEndpointImpl
