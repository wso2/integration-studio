/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyFaultInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyOutSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceFaultContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceEndpointContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceInSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceOutSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServicePolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWSDLResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceSequenceAndEndpointContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceSequenceContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWsdlType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceType;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proxy Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getFaultInputConnector <em>Fault Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getOutSequenceOutputConnector <em>Out Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getInSequenceInputConnectors <em>In Sequence Input Connectors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getPinnedServers <em>Pinned Servers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getServiceGroup <em>Service Group</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#isTraceEnabled <em>Trace Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#isStatisticsEnabled <em>Statistics Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#isStartOnLoad <em>Start On Load</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getTransports <em>Transports</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#isSecurityEnabled <em>Security Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getServiceParameters <em>Service Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getServicePolicies <em>Service Policies</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getInSequenceType <em>In Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getInSequenceKey <em>In Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getInSequenceName <em>In Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getInSequenceOnError <em>In Sequence On Error</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getOutSequenceType <em>Out Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getOutSequenceKey <em>Out Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getOutSequenceName <em>Out Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getOutSequenceOnError <em>Out Sequence On Error</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getFaultSequenceType <em>Fault Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getFaultSequenceKey <em>Fault Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getFaultSequenceName <em>Fault Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getFaultSequenceOnError <em>Fault Sequence On Error</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getEndpointKey <em>Endpoint Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getEndpointName <em>Endpoint Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#isMainSequence <em>Main Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getWsdlType <em>Wsdl Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getWsdlXML <em>Wsdl XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getWsdlURL <em>Wsdl URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getWsdlKey <em>Wsdl Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getWsdlEndpoint <em>Wsdl Endpoint</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getWsdlResources <em>Wsdl Resources</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl#getOnError <em>On Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProxyServiceImpl extends EsbElementImpl implements ProxyService {
	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected ProxyOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected ProxyInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getFaultInputConnector() <em>Fault Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultInputConnector()
	 * @generated
	 * @ordered
	 */
	protected ProxyFaultInputConnector faultInputConnector;

	/**
	 * The cached value of the '{@link #getOutSequenceOutputConnector() <em>Out Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected ProxyOutSequenceOutputConnector outSequenceOutputConnector;

	/**
	 * The cached value of the '{@link #getInSequenceInputConnectors() <em>In Sequence Input Connectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceInputConnectors()
	 * @generated
	 * @ordered
	 */
	protected EList<ProxyInSequenceInputConnector> inSequenceInputConnectors;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "proxy1";

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
	 * The default value of the '{@link #getPinnedServers() <em>Pinned Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPinnedServers()
	 * @generated
	 * @ordered
	 */
	protected static final String PINNED_SERVERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPinnedServers() <em>Pinned Servers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPinnedServers()
	 * @generated
	 * @ordered
	 */
	protected String pinnedServers = PINNED_SERVERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceGroup() <em>Service Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceGroup()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_GROUP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceGroup() <em>Service Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceGroup()
	 * @generated
	 * @ordered
	 */
	protected String serviceGroup = SERVICE_GROUP_EDEFAULT;

	/**
	 * The default value of the '{@link #isTraceEnabled() <em>Trace Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTraceEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRACE_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTraceEnabled() <em>Trace Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTraceEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean traceEnabled = TRACE_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isStatisticsEnabled() <em>Statistics Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatisticsEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATISTICS_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStatisticsEnabled() <em>Statistics Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatisticsEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean statisticsEnabled = STATISTICS_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isStartOnLoad() <em>Start On Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStartOnLoad()
	 * @generated NOT
	 * @ordered
	 */
	protected static final boolean START_ON_LOAD_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isStartOnLoad() <em>Start On Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStartOnLoad()
	 * @generated
	 * @ordered
	 */
	protected boolean startOnLoad = START_ON_LOAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransports() <em>Transports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransports()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORTS_EDEFAULT = "https,http";

	/**
	 * The cached value of the '{@link #getTransports() <em>Transports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransports()
	 * @generated
	 * @ordered
	 */
	protected String transports = TRANSPORTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isReliableMessagingEnabled() <em>Reliable Messaging Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReliableMessagingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RELIABLE_MESSAGING_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReliableMessagingEnabled() <em>Reliable Messaging Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReliableMessagingEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean reliableMessagingEnabled = RELIABLE_MESSAGING_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isSecurityEnabled() <em>Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSecurityEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SECURITY_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSecurityEnabled() <em>Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSecurityEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean securityEnabled = SECURITY_ENABLED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getServiceParameters() <em>Service Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ProxyServiceParameter> serviceParameters;

	/**
	 * The cached value of the '{@link #getServicePolicies() <em>Service Policies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServicePolicies()
	 * @generated
	 * @ordered
	 */
	protected EList<ProxyServicePolicy> servicePolicies;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected ProxyServiceContainer container;

	/**
	 * The default value of the '{@link #getInSequenceType() <em>In Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final SequenceType IN_SEQUENCE_TYPE_EDEFAULT = SequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getInSequenceType() <em>In Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceType()
	 * @generated
	 * @ordered
	 */
	protected SequenceType inSequenceType = IN_SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInSequenceKey() <em>In Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty inSequenceKey;

	/**
	 * The default value of the '{@link #getInSequenceName() <em>In Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String IN_SEQUENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInSequenceName() <em>In Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String inSequenceName = IN_SEQUENCE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInSequenceOnError() <em>In Sequence On Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceOnError()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty inSequenceOnError;

	/**
	 * The default value of the '{@link #getOutSequenceType() <em>Out Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final SequenceType OUT_SEQUENCE_TYPE_EDEFAULT = SequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getOutSequenceType() <em>Out Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceType()
	 * @generated
	 * @ordered
	 */
	protected SequenceType outSequenceType = OUT_SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutSequenceKey() <em>Out Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty outSequenceKey;

	/**
	 * The default value of the '{@link #getOutSequenceName() <em>Out Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String OUT_SEQUENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutSequenceName() <em>Out Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String outSequenceName = OUT_SEQUENCE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutSequenceOnError() <em>Out Sequence On Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceOnError()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty outSequenceOnError;

	/**
	 * The default value of the '{@link #getFaultSequenceType() <em>Fault Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final SequenceType FAULT_SEQUENCE_TYPE_EDEFAULT = SequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getFaultSequenceType() <em>Fault Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceType()
	 * @generated
	 * @ordered
	 */
	protected SequenceType faultSequenceType = FAULT_SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFaultSequenceKey() <em>Fault Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty faultSequenceKey;

	/**
	 * The default value of the '{@link #getFaultSequenceName() <em>Fault Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_SEQUENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaultSequenceName() <em>Fault Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String faultSequenceName = FAULT_SEQUENCE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFaultSequenceOnError() <em>Fault Sequence On Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceOnError()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty faultSequenceOnError;

	/**
	 * The default value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected static final SequenceType ENDPOINT_TYPE_EDEFAULT = SequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected SequenceType endpointType = ENDPOINT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEndpointKey() <em>Endpoint Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty endpointKey;

	/**
	 * The default value of the '{@link #getEndpointName() <em>Endpoint Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointName()
	 * @generated
	 * @ordered
	 */
	protected static final String ENDPOINT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndpointName() <em>Endpoint Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointName()
	 * @generated
	 * @ordered
	 */
	protected String endpointName = ENDPOINT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isMainSequence() <em>Main Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMainSequence()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MAIN_SEQUENCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMainSequence() <em>Main Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMainSequence()
	 * @generated
	 * @ordered
	 */
	protected boolean mainSequence = MAIN_SEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWsdlType() <em>Wsdl Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlType()
	 * @generated
	 * @ordered
	 */
	protected static final ProxyWsdlType WSDL_TYPE_EDEFAULT = ProxyWsdlType.NONE;

	/**
	 * The cached value of the '{@link #getWsdlType() <em>Wsdl Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlType()
	 * @generated
	 * @ordered
	 */
	protected ProxyWsdlType wsdlType = WSDL_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWsdlXML() <em>Wsdl XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlXML()
	 * @generated
	 * @ordered
	 */
	protected static final String WSDL_XML_EDEFAULT = "<definitions/>";

	/**
	 * The cached value of the '{@link #getWsdlXML() <em>Wsdl XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlXML()
	 * @generated
	 * @ordered
	 */
	protected String wsdlXML = WSDL_XML_EDEFAULT;

	/**
	 * The default value of the '{@link #getWsdlURL() <em>Wsdl URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlURL()
	 * @generated
	 * @ordered
	 */
	protected static final String WSDL_URL_EDEFAULT = "http://default/wsdl/url";

	/**
	 * The cached value of the '{@link #getWsdlURL() <em>Wsdl URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlURL()
	 * @generated
	 * @ordered
	 */
	protected String wsdlURL = WSDL_URL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWsdlKey() <em>Wsdl Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty wsdlKey;

	/**
	 * The cached value of the '{@link #getWsdlEndpoint() <em>Wsdl Endpoint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlEndpoint()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty wsdlEndpoint;

	/**
	 * The cached value of the '{@link #getWsdlResources() <em>Wsdl Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlResources()
	 * @generated
	 * @ordered
	 */
	protected EList<ProxyWSDLResource> wsdlResources;

	/**
	 * The cached value of the '{@link #getOnError() <em>On Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnError()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty onError;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ProxyServiceImpl() {
		super();		
		// WSDL Key.
		RegistryKeyProperty wsdlKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		//Set filter properties to filter in only wsdl media type
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)wsdlKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, PlatformMediaTypeConstants.MEDIA_TYPE_WSDL);

		wsdlKey.setPrettyName("WSDL Reference");
		wsdlKey.setKeyName("key");
		wsdlKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setWsdlKey(wsdlKey);
		
		
		//WSDL Endpoint Key
 		RegistryKeyProperty wsdlEndpointKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
 	    DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)wsdlEndpointKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, PlatformMediaTypeConstants.MEDIA_TYPE_WSDL);
 
 		wsdlEndpointKey.setPrettyName("WSDL Endpoint");
 		wsdlEndpointKey.setKeyName("endpoint");
 		wsdlEndpointKey.setKeyValue(DEFAULT_REGISTRY_KEY);
 		setWsdlEndpoint(wsdlEndpointKey);
		
		RegistryKeyProperty inSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		inSequenceKey.setPrettyName("In Sequence Reference");
		inSequenceKey.setKeyName("key");
		inSequenceKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setInSequenceKey(inSequenceKey);
		
		RegistryKeyProperty inSequenceOnErroKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)inSequenceOnErroKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		inSequenceOnErroKey.setPrettyName("In Sequence On Error Reference");
		inSequenceOnErroKey.setKeyName("key");
		inSequenceOnErroKey.setKeyValue(DEFAULT_ON_ERROR_REGISTRY_KEY);
		setInSequenceOnError(inSequenceOnErroKey);
		
		RegistryKeyProperty outSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		outSequenceKey.setPrettyName("Out Sequence Reference");
		outSequenceKey.setKeyName("key");
		outSequenceKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setOutSequenceKey(outSequenceKey);
		
		RegistryKeyProperty outSequenceOnErroKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)outSequenceOnErroKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		outSequenceOnErroKey.setPrettyName("Out Sequence On Error Reference");
		outSequenceOnErroKey.setKeyName("key");
		outSequenceOnErroKey.setKeyValue(DEFAULT_ON_ERROR_REGISTRY_KEY);
		setOutSequenceOnError(outSequenceOnErroKey);
		
		RegistryKeyProperty faultSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		faultSequenceKey.setPrettyName("Fault Sequence Reference");
		faultSequenceKey.setKeyName("key");
		faultSequenceKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setFaultSequenceKey(faultSequenceKey);
		
		RegistryKeyProperty faultSequenceOnErroKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)faultSequenceOnErroKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		faultSequenceOnErroKey.setPrettyName("Fault Sequence On Error Reference");
		faultSequenceOnErroKey.setKeyName("key");
		faultSequenceOnErroKey.setKeyValue(DEFAULT_ON_ERROR_REGISTRY_KEY);
		setFaultSequenceOnError(faultSequenceOnErroKey);
		
		RegistryKeyProperty endpointKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		endpointKey.setPrettyName("Endpoint Reference");
		endpointKey.setKeyName("key");
		endpointKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setEndpointKey(endpointKey);
		
		RegistryKeyProperty onErrorSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		onErrorSequenceKey.setPrettyName("On Error Sequence Reference");
		onErrorSequenceKey.setKeyName("key");
		onErrorSequenceKey.setKeyValue("");
		setOnError(onErrorSequenceKey);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.PROXY_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(ProxyOutputConnector newOutputConnector, NotificationChain msgs) {
		ProxyOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(ProxyOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(ProxyInputConnector newInputConnector, NotificationChain msgs) {
		ProxyInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(ProxyInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyFaultInputConnector getFaultInputConnector() {
		return faultInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultInputConnector(ProxyFaultInputConnector newFaultInputConnector, NotificationChain msgs) {
		ProxyFaultInputConnector oldFaultInputConnector = faultInputConnector;
		faultInputConnector = newFaultInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__FAULT_INPUT_CONNECTOR, oldFaultInputConnector, newFaultInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultInputConnector(ProxyFaultInputConnector newFaultInputConnector) {
		if (newFaultInputConnector != faultInputConnector) {
			NotificationChain msgs = null;
			if (faultInputConnector != null)
				msgs = ((InternalEObject)faultInputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__FAULT_INPUT_CONNECTOR, null, msgs);
			if (newFaultInputConnector != null)
				msgs = ((InternalEObject)newFaultInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__FAULT_INPUT_CONNECTOR, null, msgs);
			msgs = basicSetFaultInputConnector(newFaultInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__FAULT_INPUT_CONNECTOR, newFaultInputConnector, newFaultInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyOutSequenceOutputConnector getOutSequenceOutputConnector() {
		return outSequenceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutSequenceOutputConnector(ProxyOutSequenceOutputConnector newOutSequenceOutputConnector, NotificationChain msgs) {
		ProxyOutSequenceOutputConnector oldOutSequenceOutputConnector = outSequenceOutputConnector;
		outSequenceOutputConnector = newOutSequenceOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_OUTPUT_CONNECTOR, oldOutSequenceOutputConnector, newOutSequenceOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutSequenceOutputConnector(ProxyOutSequenceOutputConnector newOutSequenceOutputConnector) {
		if (newOutSequenceOutputConnector != outSequenceOutputConnector) {
			NotificationChain msgs = null;
			if (outSequenceOutputConnector != null)
				msgs = ((InternalEObject)outSequenceOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			if (newOutSequenceOutputConnector != null)
				msgs = ((InternalEObject)newOutSequenceOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutSequenceOutputConnector(newOutSequenceOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_OUTPUT_CONNECTOR, newOutSequenceOutputConnector, newOutSequenceOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProxyInSequenceInputConnector> getInSequenceInputConnectors() {
		if (inSequenceInputConnectors == null) {
			inSequenceInputConnectors = new EObjectContainmentEList<ProxyInSequenceInputConnector>(ProxyInSequenceInputConnector.class, this, EsbPackage.PROXY_SERVICE__IN_SEQUENCE_INPUT_CONNECTORS);
		}
		return inSequenceInputConnectors;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPinnedServers() {
		return pinnedServers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPinnedServers(String newPinnedServers) {
		String oldPinnedServers = pinnedServers;
		pinnedServers = newPinnedServers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__PINNED_SERVERS, oldPinnedServers, pinnedServers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceGroup() {
		return serviceGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceGroup(String newServiceGroup) {
		String oldServiceGroup = serviceGroup;
		serviceGroup = newServiceGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__SERVICE_GROUP, oldServiceGroup, serviceGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTraceEnabled() {
		return traceEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceEnabled(boolean newTraceEnabled) {
		boolean oldTraceEnabled = traceEnabled;
		traceEnabled = newTraceEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__TRACE_ENABLED, oldTraceEnabled, traceEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStatisticsEnabled() {
		return statisticsEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatisticsEnabled(boolean newStatisticsEnabled) {
		boolean oldStatisticsEnabled = statisticsEnabled;
		statisticsEnabled = newStatisticsEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__STATISTICS_ENABLED, oldStatisticsEnabled, statisticsEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStartOnLoad() {
		return startOnLoad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartOnLoad(boolean newStartOnLoad) {
		boolean oldStartOnLoad = startOnLoad;
		startOnLoad = newStartOnLoad;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__START_ON_LOAD, oldStartOnLoad, startOnLoad));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransports() {
		return transports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransports(String newTransports) {
		String oldTransports = transports;
		transports = newTransports;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__TRANSPORTS, oldTransports, transports));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReliableMessagingEnabled() {
		return reliableMessagingEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReliableMessagingEnabled(boolean newReliableMessagingEnabled) {
		boolean oldReliableMessagingEnabled = reliableMessagingEnabled;
		reliableMessagingEnabled = newReliableMessagingEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED, oldReliableMessagingEnabled, reliableMessagingEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSecurityEnabled() {
		return securityEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecurityEnabled(boolean newSecurityEnabled) {
		boolean oldSecurityEnabled = securityEnabled;
		securityEnabled = newSecurityEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__SECURITY_ENABLED, oldSecurityEnabled, securityEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProxyServiceParameter> getServiceParameters() {
		if (serviceParameters == null) {
			serviceParameters = new EObjectContainmentEList<ProxyServiceParameter>(ProxyServiceParameter.class, this, EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS);
		}
		return serviceParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProxyServicePolicy> getServicePolicies() {
		if (servicePolicies == null) {
			servicePolicies = new EObjectContainmentEList<ProxyServicePolicy>(ProxyServicePolicy.class, this, EsbPackage.PROXY_SERVICE__SERVICE_POLICIES);
		}
		return servicePolicies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyServiceContainer getContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(ProxyServiceContainer newContainer, NotificationChain msgs) {
		ProxyServiceContainer oldContainer = container;
		container = newContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__CONTAINER, oldContainer, newContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(ProxyServiceContainer newContainer) {
		if (newContainer != container) {
			NotificationChain msgs = null;
			if (container != null)
				msgs = ((InternalEObject)container).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__CONTAINER, null, msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__CONTAINER, null, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType getInSequenceType() {
		return inSequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSequenceType(SequenceType newInSequenceType) {
		SequenceType oldInSequenceType = inSequenceType;
		inSequenceType = newInSequenceType == null ? IN_SEQUENCE_TYPE_EDEFAULT : newInSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__IN_SEQUENCE_TYPE, oldInSequenceType, inSequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getInSequenceKey() {
		return inSequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInSequenceKey(RegistryKeyProperty newInSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldInSequenceKey = inSequenceKey;
		inSequenceKey = newInSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__IN_SEQUENCE_KEY, oldInSequenceKey, newInSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSequenceKey(RegistryKeyProperty newInSequenceKey) {
		if (newInSequenceKey != inSequenceKey) {
			NotificationChain msgs = null;
			if (inSequenceKey != null)
				msgs = ((InternalEObject)inSequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__IN_SEQUENCE_KEY, null, msgs);
			if (newInSequenceKey != null)
				msgs = ((InternalEObject)newInSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__IN_SEQUENCE_KEY, null, msgs);
			msgs = basicSetInSequenceKey(newInSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__IN_SEQUENCE_KEY, newInSequenceKey, newInSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInSequenceName() {
		return inSequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSequenceName(String newInSequenceName) {
		String oldInSequenceName = inSequenceName;
		inSequenceName = newInSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__IN_SEQUENCE_NAME, oldInSequenceName, inSequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getInSequenceOnError() {
		return inSequenceOnError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInSequenceOnError(RegistryKeyProperty newInSequenceOnError, NotificationChain msgs) {
		RegistryKeyProperty oldInSequenceOnError = inSequenceOnError;
		inSequenceOnError = newInSequenceOnError;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__IN_SEQUENCE_ON_ERROR, oldInSequenceOnError, newInSequenceOnError);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSequenceOnError(RegistryKeyProperty newInSequenceOnError) {
		if (newInSequenceOnError != inSequenceOnError) {
			NotificationChain msgs = null;
			if (inSequenceOnError != null)
				msgs = ((InternalEObject)inSequenceOnError).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__IN_SEQUENCE_ON_ERROR, null, msgs);
			if (newInSequenceOnError != null)
				msgs = ((InternalEObject)newInSequenceOnError).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__IN_SEQUENCE_ON_ERROR, null, msgs);
			msgs = basicSetInSequenceOnError(newInSequenceOnError, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__IN_SEQUENCE_ON_ERROR, newInSequenceOnError, newInSequenceOnError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType getOutSequenceType() {
		return outSequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutSequenceType(SequenceType newOutSequenceType) {
		SequenceType oldOutSequenceType = outSequenceType;
		outSequenceType = newOutSequenceType == null ? OUT_SEQUENCE_TYPE_EDEFAULT : newOutSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_TYPE, oldOutSequenceType, outSequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOutSequenceKey() {
		return outSequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutSequenceKey(RegistryKeyProperty newOutSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldOutSequenceKey = outSequenceKey;
		outSequenceKey = newOutSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_KEY, oldOutSequenceKey, newOutSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutSequenceKey(RegistryKeyProperty newOutSequenceKey) {
		if (newOutSequenceKey != outSequenceKey) {
			NotificationChain msgs = null;
			if (outSequenceKey != null)
				msgs = ((InternalEObject)outSequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_KEY, null, msgs);
			if (newOutSequenceKey != null)
				msgs = ((InternalEObject)newOutSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_KEY, null, msgs);
			msgs = basicSetOutSequenceKey(newOutSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_KEY, newOutSequenceKey, newOutSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutSequenceName() {
		return outSequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutSequenceName(String newOutSequenceName) {
		String oldOutSequenceName = outSequenceName;
		outSequenceName = newOutSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_NAME, oldOutSequenceName, outSequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOutSequenceOnError() {
		return outSequenceOnError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutSequenceOnError(RegistryKeyProperty newOutSequenceOnError, NotificationChain msgs) {
		RegistryKeyProperty oldOutSequenceOnError = outSequenceOnError;
		outSequenceOnError = newOutSequenceOnError;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_ON_ERROR, oldOutSequenceOnError, newOutSequenceOnError);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutSequenceOnError(RegistryKeyProperty newOutSequenceOnError) {
		if (newOutSequenceOnError != outSequenceOnError) {
			NotificationChain msgs = null;
			if (outSequenceOnError != null)
				msgs = ((InternalEObject)outSequenceOnError).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_ON_ERROR, null, msgs);
			if (newOutSequenceOnError != null)
				msgs = ((InternalEObject)newOutSequenceOnError).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_ON_ERROR, null, msgs);
			msgs = basicSetOutSequenceOnError(newOutSequenceOnError, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_ON_ERROR, newOutSequenceOnError, newOutSequenceOnError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType getFaultSequenceType() {
		return faultSequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultSequenceType(SequenceType newFaultSequenceType) {
		SequenceType oldFaultSequenceType = faultSequenceType;
		faultSequenceType = newFaultSequenceType == null ? FAULT_SEQUENCE_TYPE_EDEFAULT : newFaultSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_TYPE, oldFaultSequenceType, faultSequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getFaultSequenceKey() {
		return faultSequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultSequenceKey(RegistryKeyProperty newFaultSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldFaultSequenceKey = faultSequenceKey;
		faultSequenceKey = newFaultSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_KEY, oldFaultSequenceKey, newFaultSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultSequenceKey(RegistryKeyProperty newFaultSequenceKey) {
		if (newFaultSequenceKey != faultSequenceKey) {
			NotificationChain msgs = null;
			if (faultSequenceKey != null)
				msgs = ((InternalEObject)faultSequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_KEY, null, msgs);
			if (newFaultSequenceKey != null)
				msgs = ((InternalEObject)newFaultSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_KEY, null, msgs);
			msgs = basicSetFaultSequenceKey(newFaultSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_KEY, newFaultSequenceKey, newFaultSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultSequenceName() {
		return faultSequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultSequenceName(String newFaultSequenceName) {
		String oldFaultSequenceName = faultSequenceName;
		faultSequenceName = newFaultSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_NAME, oldFaultSequenceName, faultSequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getFaultSequenceOnError() {
		return faultSequenceOnError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultSequenceOnError(RegistryKeyProperty newFaultSequenceOnError, NotificationChain msgs) {
		RegistryKeyProperty oldFaultSequenceOnError = faultSequenceOnError;
		faultSequenceOnError = newFaultSequenceOnError;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_ON_ERROR, oldFaultSequenceOnError, newFaultSequenceOnError);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultSequenceOnError(RegistryKeyProperty newFaultSequenceOnError) {
		if (newFaultSequenceOnError != faultSequenceOnError) {
			NotificationChain msgs = null;
			if (faultSequenceOnError != null)
				msgs = ((InternalEObject)faultSequenceOnError).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_ON_ERROR, null, msgs);
			if (newFaultSequenceOnError != null)
				msgs = ((InternalEObject)newFaultSequenceOnError).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_ON_ERROR, null, msgs);
			msgs = basicSetFaultSequenceOnError(newFaultSequenceOnError, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_ON_ERROR, newFaultSequenceOnError, newFaultSequenceOnError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType getEndpointType() {
		return endpointType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointType(SequenceType newEndpointType) {
		SequenceType oldEndpointType = endpointType;
		endpointType = newEndpointType == null ? ENDPOINT_TYPE_EDEFAULT : newEndpointType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__ENDPOINT_TYPE, oldEndpointType, endpointType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getEndpointKey() {
		return endpointKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndpointKey(RegistryKeyProperty newEndpointKey, NotificationChain msgs) {
		RegistryKeyProperty oldEndpointKey = endpointKey;
		endpointKey = newEndpointKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__ENDPOINT_KEY, oldEndpointKey, newEndpointKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointKey(RegistryKeyProperty newEndpointKey) {
		if (newEndpointKey != endpointKey) {
			NotificationChain msgs = null;
			if (endpointKey != null)
				msgs = ((InternalEObject)endpointKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__ENDPOINT_KEY, null, msgs);
			if (newEndpointKey != null)
				msgs = ((InternalEObject)newEndpointKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__ENDPOINT_KEY, null, msgs);
			msgs = basicSetEndpointKey(newEndpointKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__ENDPOINT_KEY, newEndpointKey, newEndpointKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEndpointName() {
		return endpointName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointName(String newEndpointName) {
		String oldEndpointName = endpointName;
		endpointName = newEndpointName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__ENDPOINT_NAME, oldEndpointName, endpointName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMainSequence() {
		return mainSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainSequence(boolean newMainSequence) {
		boolean oldMainSequence = mainSequence;
		mainSequence = newMainSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__MAIN_SEQUENCE, oldMainSequence, mainSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyWsdlType getWsdlType() {
		return wsdlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlType(ProxyWsdlType newWsdlType) {
		ProxyWsdlType oldWsdlType = wsdlType;
		wsdlType = newWsdlType == null ? WSDL_TYPE_EDEFAULT : newWsdlType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__WSDL_TYPE, oldWsdlType, wsdlType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWsdlXML() {
		return wsdlXML;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlXML(String newWsdlXML) {
		String oldWsdlXML = wsdlXML;
		wsdlXML = newWsdlXML;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__WSDL_XML, oldWsdlXML, wsdlXML));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWsdlURL() {
		return wsdlURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlURL(String newWsdlURL) {
		String oldWsdlURL = wsdlURL;
		wsdlURL = newWsdlURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__WSDL_URL, oldWsdlURL, wsdlURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getWsdlKey() {
		return wsdlKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWsdlKey(RegistryKeyProperty newWsdlKey, NotificationChain msgs) {
		RegistryKeyProperty oldWsdlKey = wsdlKey;
		wsdlKey = newWsdlKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__WSDL_KEY, oldWsdlKey, newWsdlKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlKey(RegistryKeyProperty newWsdlKey) {
		if (newWsdlKey != wsdlKey) {
			NotificationChain msgs = null;
			if (wsdlKey != null)
				msgs = ((InternalEObject)wsdlKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__WSDL_KEY, null, msgs);
			if (newWsdlKey != null)
				msgs = ((InternalEObject)newWsdlKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__WSDL_KEY, null, msgs);
			msgs = basicSetWsdlKey(newWsdlKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__WSDL_KEY, newWsdlKey, newWsdlKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getWsdlEndpoint() {
		return wsdlEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWsdlEndpoint(RegistryKeyProperty newWsdlEndpoint, NotificationChain msgs) {
		RegistryKeyProperty oldWsdlEndpoint = wsdlEndpoint;
		wsdlEndpoint = newWsdlEndpoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__WSDL_ENDPOINT, oldWsdlEndpoint, newWsdlEndpoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlEndpoint(RegistryKeyProperty newWsdlEndpoint) {
		if (newWsdlEndpoint != wsdlEndpoint) {
			NotificationChain msgs = null;
			if (wsdlEndpoint != null)
				msgs = ((InternalEObject)wsdlEndpoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__WSDL_ENDPOINT, null, msgs);
			if (newWsdlEndpoint != null)
				msgs = ((InternalEObject)newWsdlEndpoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__WSDL_ENDPOINT, null, msgs);
			msgs = basicSetWsdlEndpoint(newWsdlEndpoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__WSDL_ENDPOINT, newWsdlEndpoint, newWsdlEndpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProxyWSDLResource> getWsdlResources() {
		if (wsdlResources == null) {
			wsdlResources = new EObjectContainmentEList<ProxyWSDLResource>(ProxyWSDLResource.class, this, EsbPackage.PROXY_SERVICE__WSDL_RESOURCES);
		}
		return wsdlResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOnError() {
		return onError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnError(RegistryKeyProperty newOnError, NotificationChain msgs) {
		RegistryKeyProperty oldOnError = onError;
		onError = newOnError;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__ON_ERROR, oldOnError, newOnError);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnError(RegistryKeyProperty newOnError) {
		if (newOnError != onError) {
			NotificationChain msgs = null;
			if (onError != null)
				msgs = ((InternalEObject)onError).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__ON_ERROR, null, msgs);
			if (newOnError != null)
				msgs = ((InternalEObject)newOnError).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__ON_ERROR, null, msgs);
			msgs = basicSetOnError(newOnError, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__ON_ERROR, newOnError, newOnError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.PROXY_SERVICE__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.PROXY_SERVICE__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.PROXY_SERVICE__FAULT_INPUT_CONNECTOR:
				return basicSetFaultInputConnector(null, msgs);
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_OUTPUT_CONNECTOR:
				return basicSetOutSequenceOutputConnector(null, msgs);
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_INPUT_CONNECTORS:
				return ((InternalEList<?>)getInSequenceInputConnectors()).basicRemove(otherEnd, msgs);
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
				return ((InternalEList<?>)getServiceParameters()).basicRemove(otherEnd, msgs);
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
				return ((InternalEList<?>)getServicePolicies()).basicRemove(otherEnd, msgs);
			case EsbPackage.PROXY_SERVICE__CONTAINER:
				return basicSetContainer(null, msgs);
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_KEY:
				return basicSetInSequenceKey(null, msgs);
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_ON_ERROR:
				return basicSetInSequenceOnError(null, msgs);
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_KEY:
				return basicSetOutSequenceKey(null, msgs);
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_ON_ERROR:
				return basicSetOutSequenceOnError(null, msgs);
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_KEY:
				return basicSetFaultSequenceKey(null, msgs);
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_ON_ERROR:
				return basicSetFaultSequenceOnError(null, msgs);
			case EsbPackage.PROXY_SERVICE__ENDPOINT_KEY:
				return basicSetEndpointKey(null, msgs);
			case EsbPackage.PROXY_SERVICE__WSDL_KEY:
				return basicSetWsdlKey(null, msgs);
			case EsbPackage.PROXY_SERVICE__WSDL_ENDPOINT:
				return basicSetWsdlEndpoint(null, msgs);
			case EsbPackage.PROXY_SERVICE__WSDL_RESOURCES:
				return ((InternalEList<?>)getWsdlResources()).basicRemove(otherEnd, msgs);
			case EsbPackage.PROXY_SERVICE__ON_ERROR:
				return basicSetOnError(null, msgs);
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
			case EsbPackage.PROXY_SERVICE__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.PROXY_SERVICE__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.PROXY_SERVICE__FAULT_INPUT_CONNECTOR:
				return getFaultInputConnector();
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_OUTPUT_CONNECTOR:
				return getOutSequenceOutputConnector();
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_INPUT_CONNECTORS:
				return getInSequenceInputConnectors();
			case EsbPackage.PROXY_SERVICE__NAME:
				return getName();
			case EsbPackage.PROXY_SERVICE__PINNED_SERVERS:
				return getPinnedServers();
			case EsbPackage.PROXY_SERVICE__SERVICE_GROUP:
				return getServiceGroup();
			case EsbPackage.PROXY_SERVICE__TRACE_ENABLED:
				return isTraceEnabled();
			case EsbPackage.PROXY_SERVICE__STATISTICS_ENABLED:
				return isStatisticsEnabled();
			case EsbPackage.PROXY_SERVICE__START_ON_LOAD:
				return isStartOnLoad();
			case EsbPackage.PROXY_SERVICE__TRANSPORTS:
				return getTransports();
			case EsbPackage.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED:
				return isReliableMessagingEnabled();
			case EsbPackage.PROXY_SERVICE__SECURITY_ENABLED:
				return isSecurityEnabled();
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
				return getServiceParameters();
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
				return getServicePolicies();
			case EsbPackage.PROXY_SERVICE__CONTAINER:
				return getContainer();
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_TYPE:
				return getInSequenceType();
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_KEY:
				return getInSequenceKey();
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_NAME:
				return getInSequenceName();
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_ON_ERROR:
				return getInSequenceOnError();
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_TYPE:
				return getOutSequenceType();
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_KEY:
				return getOutSequenceKey();
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_NAME:
				return getOutSequenceName();
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_ON_ERROR:
				return getOutSequenceOnError();
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_TYPE:
				return getFaultSequenceType();
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_KEY:
				return getFaultSequenceKey();
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_NAME:
				return getFaultSequenceName();
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_ON_ERROR:
				return getFaultSequenceOnError();
			case EsbPackage.PROXY_SERVICE__ENDPOINT_TYPE:
				return getEndpointType();
			case EsbPackage.PROXY_SERVICE__ENDPOINT_KEY:
				return getEndpointKey();
			case EsbPackage.PROXY_SERVICE__ENDPOINT_NAME:
				return getEndpointName();
			case EsbPackage.PROXY_SERVICE__MAIN_SEQUENCE:
				return isMainSequence();
			case EsbPackage.PROXY_SERVICE__WSDL_TYPE:
				return getWsdlType();
			case EsbPackage.PROXY_SERVICE__WSDL_XML:
				return getWsdlXML();
			case EsbPackage.PROXY_SERVICE__WSDL_URL:
				return getWsdlURL();
			case EsbPackage.PROXY_SERVICE__WSDL_KEY:
				return getWsdlKey();
			case EsbPackage.PROXY_SERVICE__WSDL_ENDPOINT:
				return getWsdlEndpoint();
			case EsbPackage.PROXY_SERVICE__WSDL_RESOURCES:
				return getWsdlResources();
			case EsbPackage.PROXY_SERVICE__ON_ERROR:
				return getOnError();
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
			case EsbPackage.PROXY_SERVICE__OUTPUT_CONNECTOR:
				setOutputConnector((ProxyOutputConnector)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__INPUT_CONNECTOR:
				setInputConnector((ProxyInputConnector)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_INPUT_CONNECTOR:
				setFaultInputConnector((ProxyFaultInputConnector)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_OUTPUT_CONNECTOR:
				setOutSequenceOutputConnector((ProxyOutSequenceOutputConnector)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_INPUT_CONNECTORS:
				getInSequenceInputConnectors().clear();
				getInSequenceInputConnectors().addAll((Collection<? extends ProxyInSequenceInputConnector>)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__NAME:
				setName((String)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__PINNED_SERVERS:
				setPinnedServers((String)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__SERVICE_GROUP:
				setServiceGroup((String)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__TRACE_ENABLED:
				setTraceEnabled((Boolean)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__STATISTICS_ENABLED:
				setStatisticsEnabled((Boolean)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__START_ON_LOAD:
				setStartOnLoad((Boolean)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__TRANSPORTS:
				setTransports((String)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED:
				setReliableMessagingEnabled((Boolean)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__SECURITY_ENABLED:
				setSecurityEnabled((Boolean)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
				getServiceParameters().clear();
				getServiceParameters().addAll((Collection<? extends ProxyServiceParameter>)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
				getServicePolicies().clear();
				getServicePolicies().addAll((Collection<? extends ProxyServicePolicy>)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__CONTAINER:
				setContainer((ProxyServiceContainer)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_TYPE:
				setInSequenceType((SequenceType)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_KEY:
				setInSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_NAME:
				setInSequenceName((String)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_ON_ERROR:
				setInSequenceOnError((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_TYPE:
				setOutSequenceType((SequenceType)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_KEY:
				setOutSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_NAME:
				setOutSequenceName((String)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_ON_ERROR:
				setOutSequenceOnError((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_TYPE:
				setFaultSequenceType((SequenceType)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_KEY:
				setFaultSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_NAME:
				setFaultSequenceName((String)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_ON_ERROR:
				setFaultSequenceOnError((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_TYPE:
				setEndpointType((SequenceType)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_KEY:
				setEndpointKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_NAME:
				setEndpointName((String)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__MAIN_SEQUENCE:
				setMainSequence((Boolean)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_TYPE:
				setWsdlType((ProxyWsdlType)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_XML:
				setWsdlXML((String)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_URL:
				setWsdlURL((String)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_KEY:
				setWsdlKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_ENDPOINT:
				setWsdlEndpoint((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_RESOURCES:
				getWsdlResources().clear();
				getWsdlResources().addAll((Collection<? extends ProxyWSDLResource>)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__ON_ERROR:
				setOnError((RegistryKeyProperty)newValue);
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
			case EsbPackage.PROXY_SERVICE__OUTPUT_CONNECTOR:
				setOutputConnector((ProxyOutputConnector)null);
				return;
			case EsbPackage.PROXY_SERVICE__INPUT_CONNECTOR:
				setInputConnector((ProxyInputConnector)null);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_INPUT_CONNECTOR:
				setFaultInputConnector((ProxyFaultInputConnector)null);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_OUTPUT_CONNECTOR:
				setOutSequenceOutputConnector((ProxyOutSequenceOutputConnector)null);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_INPUT_CONNECTORS:
				getInSequenceInputConnectors().clear();
				return;
			case EsbPackage.PROXY_SERVICE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__PINNED_SERVERS:
				setPinnedServers(PINNED_SERVERS_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__SERVICE_GROUP:
				setServiceGroup(SERVICE_GROUP_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__TRACE_ENABLED:
				setTraceEnabled(TRACE_ENABLED_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__STATISTICS_ENABLED:
				setStatisticsEnabled(STATISTICS_ENABLED_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__START_ON_LOAD:
				setStartOnLoad(START_ON_LOAD_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__TRANSPORTS:
				setTransports(TRANSPORTS_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED:
				setReliableMessagingEnabled(RELIABLE_MESSAGING_ENABLED_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__SECURITY_ENABLED:
				setSecurityEnabled(SECURITY_ENABLED_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
				getServiceParameters().clear();
				return;
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
				getServicePolicies().clear();
				return;
			case EsbPackage.PROXY_SERVICE__CONTAINER:
				setContainer((ProxyServiceContainer)null);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_TYPE:
				setInSequenceType(IN_SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_KEY:
				setInSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_NAME:
				setInSequenceName(IN_SEQUENCE_NAME_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_ON_ERROR:
				setInSequenceOnError((RegistryKeyProperty)null);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_TYPE:
				setOutSequenceType(OUT_SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_KEY:
				setOutSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_NAME:
				setOutSequenceName(OUT_SEQUENCE_NAME_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_ON_ERROR:
				setOutSequenceOnError((RegistryKeyProperty)null);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_TYPE:
				setFaultSequenceType(FAULT_SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_KEY:
				setFaultSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_NAME:
				setFaultSequenceName(FAULT_SEQUENCE_NAME_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_ON_ERROR:
				setFaultSequenceOnError((RegistryKeyProperty)null);
				return;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_TYPE:
				setEndpointType(ENDPOINT_TYPE_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_KEY:
				setEndpointKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_NAME:
				setEndpointName(ENDPOINT_NAME_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__MAIN_SEQUENCE:
				setMainSequence(MAIN_SEQUENCE_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_TYPE:
				setWsdlType(WSDL_TYPE_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_XML:
				setWsdlXML(WSDL_XML_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_URL:
				setWsdlURL(WSDL_URL_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_KEY:
				setWsdlKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_ENDPOINT:
				setWsdlEndpoint((RegistryKeyProperty)null);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_RESOURCES:
				getWsdlResources().clear();
				return;
			case EsbPackage.PROXY_SERVICE__ON_ERROR:
				setOnError((RegistryKeyProperty)null);
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
			case EsbPackage.PROXY_SERVICE__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.PROXY_SERVICE__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.PROXY_SERVICE__FAULT_INPUT_CONNECTOR:
				return faultInputConnector != null;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_OUTPUT_CONNECTOR:
				return outSequenceOutputConnector != null;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_INPUT_CONNECTORS:
				return inSequenceInputConnectors != null && !inSequenceInputConnectors.isEmpty();
			case EsbPackage.PROXY_SERVICE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EsbPackage.PROXY_SERVICE__PINNED_SERVERS:
				return PINNED_SERVERS_EDEFAULT == null ? pinnedServers != null : !PINNED_SERVERS_EDEFAULT.equals(pinnedServers);
			case EsbPackage.PROXY_SERVICE__SERVICE_GROUP:
				return SERVICE_GROUP_EDEFAULT == null ? serviceGroup != null : !SERVICE_GROUP_EDEFAULT.equals(serviceGroup);
			case EsbPackage.PROXY_SERVICE__TRACE_ENABLED:
				return traceEnabled != TRACE_ENABLED_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__STATISTICS_ENABLED:
				return statisticsEnabled != STATISTICS_ENABLED_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__START_ON_LOAD:
				return startOnLoad != START_ON_LOAD_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__TRANSPORTS:
				return TRANSPORTS_EDEFAULT == null ? transports != null : !TRANSPORTS_EDEFAULT.equals(transports);
			case EsbPackage.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED:
				return reliableMessagingEnabled != RELIABLE_MESSAGING_ENABLED_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__SECURITY_ENABLED:
				return securityEnabled != SECURITY_ENABLED_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
				return serviceParameters != null && !serviceParameters.isEmpty();
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
				return servicePolicies != null && !servicePolicies.isEmpty();
			case EsbPackage.PROXY_SERVICE__CONTAINER:
				return container != null;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_TYPE:
				return inSequenceType != IN_SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_KEY:
				return inSequenceKey != null;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_NAME:
				return IN_SEQUENCE_NAME_EDEFAULT == null ? inSequenceName != null : !IN_SEQUENCE_NAME_EDEFAULT.equals(inSequenceName);
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_ON_ERROR:
				return inSequenceOnError != null;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_TYPE:
				return outSequenceType != OUT_SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_KEY:
				return outSequenceKey != null;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_NAME:
				return OUT_SEQUENCE_NAME_EDEFAULT == null ? outSequenceName != null : !OUT_SEQUENCE_NAME_EDEFAULT.equals(outSequenceName);
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_ON_ERROR:
				return outSequenceOnError != null;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_TYPE:
				return faultSequenceType != FAULT_SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_KEY:
				return faultSequenceKey != null;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_NAME:
				return FAULT_SEQUENCE_NAME_EDEFAULT == null ? faultSequenceName != null : !FAULT_SEQUENCE_NAME_EDEFAULT.equals(faultSequenceName);
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_ON_ERROR:
				return faultSequenceOnError != null;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_TYPE:
				return endpointType != ENDPOINT_TYPE_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_KEY:
				return endpointKey != null;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_NAME:
				return ENDPOINT_NAME_EDEFAULT == null ? endpointName != null : !ENDPOINT_NAME_EDEFAULT.equals(endpointName);
			case EsbPackage.PROXY_SERVICE__MAIN_SEQUENCE:
				return mainSequence != MAIN_SEQUENCE_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__WSDL_TYPE:
				return wsdlType != WSDL_TYPE_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__WSDL_XML:
				return WSDL_XML_EDEFAULT == null ? wsdlXML != null : !WSDL_XML_EDEFAULT.equals(wsdlXML);
			case EsbPackage.PROXY_SERVICE__WSDL_URL:
				return WSDL_URL_EDEFAULT == null ? wsdlURL != null : !WSDL_URL_EDEFAULT.equals(wsdlURL);
			case EsbPackage.PROXY_SERVICE__WSDL_KEY:
				return wsdlKey != null;
			case EsbPackage.PROXY_SERVICE__WSDL_ENDPOINT:
				return wsdlEndpoint != null;
			case EsbPackage.PROXY_SERVICE__WSDL_RESOURCES:
				return wsdlResources != null && !wsdlResources.isEmpty();
			case EsbPackage.PROXY_SERVICE__ON_ERROR:
				return onError != null;
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
		result.append(", pinnedServers: ");
		result.append(pinnedServers);
		result.append(", serviceGroup: ");
		result.append(serviceGroup);
		result.append(", traceEnabled: ");
		result.append(traceEnabled);
		result.append(", statisticsEnabled: ");
		result.append(statisticsEnabled);
		result.append(", startOnLoad: ");
		result.append(startOnLoad);
		result.append(", transports: ");
		result.append(transports);
		result.append(", reliableMessagingEnabled: ");
		result.append(reliableMessagingEnabled);
		result.append(", securityEnabled: ");
		result.append(securityEnabled);
		result.append(", inSequenceType: ");
		result.append(inSequenceType);
		result.append(", inSequenceName: ");
		result.append(inSequenceName);
		result.append(", outSequenceType: ");
		result.append(outSequenceType);
		result.append(", outSequenceName: ");
		result.append(outSequenceName);
		result.append(", faultSequenceType: ");
		result.append(faultSequenceType);
		result.append(", faultSequenceName: ");
		result.append(faultSequenceName);
		result.append(", endpointType: ");
		result.append(endpointType);
		result.append(", endpointName: ");
		result.append(endpointName);
		result.append(", mainSequence: ");
		result.append(mainSequence);
		result.append(", wsdlType: ");
		result.append(wsdlType);
		result.append(", wsdlXML: ");
		result.append(wsdlXML);
		result.append(", wsdlURL: ");
		result.append(wsdlURL);
		result.append(')');
		return result.toString();
	}

} //ProxyServiceImpl
