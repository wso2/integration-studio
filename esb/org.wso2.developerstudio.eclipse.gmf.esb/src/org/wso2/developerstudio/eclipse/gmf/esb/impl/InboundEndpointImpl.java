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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.Enable;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointOnErrorSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointOnErrorSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSCacheLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSConnectionFactoryType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSSessionAcknowledgement;
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
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getTruststore <em>Truststore</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getKeystore <em>Keystore</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSslVerifyClient <em>Ssl Verify Client</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSslProtocol <em>Ssl Protocol</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getHttpsProtocols <em>Https Protocols</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getCertificateRevocationVerifier <em>Certificate Revocation Verifier</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getOnErrorSequence <em>On Error Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSequence <em>Sequence</em>}</li>
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
	 * The default value of the '{@link #getOnErrorSequence() <em>On Error Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnErrorSequence()
	 * @generated
	 * @ordered
	 */
	protected static final String ON_ERROR_SEQUENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOnErrorSequence() <em>On Error Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnErrorSequence()
	 * @generated
	 * @ordered
	 */
	protected String onErrorSequence = ON_ERROR_SEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSequence() <em>Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequence()
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSequence() <em>Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequence()
	 * @generated
	 * @ordered
	 */
	protected String sequence = SEQUENCE_EDEFAULT;

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
	public String getSequence() {
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequence(String newSequence) {
		String oldSequence = sequence;
		sequence = newSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SEQUENCE, oldSequence, sequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOnErrorSequence() {
		return onErrorSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnErrorSequence(String newOnErrorSequence) {
		String oldOnErrorSequence = onErrorSequence;
		onErrorSequence = newOnErrorSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE, oldOnErrorSequence, onErrorSequence));
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
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE:
				return getOnErrorSequence();
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE:
				return getSequence();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE:
				setOnErrorSequence((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE:
				setSequence((String)newValue);
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
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE:
				setOnErrorSequence(ON_ERROR_SEQUENCE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE:
				setSequence(SEQUENCE_EDEFAULT);
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
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE:
				return ON_ERROR_SEQUENCE_EDEFAULT == null ? onErrorSequence != null : !ON_ERROR_SEQUENCE_EDEFAULT.equals(onErrorSequence);
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE:
				return SEQUENCE_EDEFAULT == null ? sequence != null : !SEQUENCE_EDEFAULT.equals(sequence);
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
		result.append(", onErrorSequence: ");
		result.append(onErrorSequence);
		result.append(", sequence: ");
		result.append(sequence);
		result.append(')');
		return result.toString();
	}

} //InboundEndpointImpl
