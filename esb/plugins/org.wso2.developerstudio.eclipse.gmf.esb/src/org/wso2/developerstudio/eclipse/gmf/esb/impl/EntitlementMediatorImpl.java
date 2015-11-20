/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementCallbackHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementClientType;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorAdviceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorObligationsOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorOnAcceptOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorOnRejectOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entitlement Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getEntitlementServerURL <em>Entitlement Server URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getCallbackClassName <em>Callback Class Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getThriftHost <em>Thrift Host</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getThriftPort <em>Thrift Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getEntitlementClientType <em>Entitlement Client Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getOnRejectSequenceType <em>On Reject Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getOnAcceptSequenceType <em>On Accept Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getAdviceSequenceType <em>Advice Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getObligationsSequenceType <em>Obligations Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getOnRejectSequenceKey <em>On Reject Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getOnAcceptSequenceKey <em>On Accept Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getAdviceSequenceKey <em>Advice Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getObligationsSequenceKey <em>Obligations Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getEntitlementContainer <em>Entitlement Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getOnRejectOutputConnector <em>On Reject Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getOnAcceptOutputConnector <em>On Accept Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getAdviceOutputConnector <em>Advice Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getObligationsOutputConnector <em>Obligations Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl#getCallbackHandler <em>Callback Handler</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntitlementMediatorImpl extends MediatorImpl implements EntitlementMediator {
	/**
	 * The default value of the '{@link #getEntitlementServerURL() <em>Entitlement Server URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntitlementServerURL()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTITLEMENT_SERVER_URL_EDEFAULT = "server_url";

	/**
	 * The cached value of the '{@link #getEntitlementServerURL() <em>Entitlement Server URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntitlementServerURL()
	 * @generated
	 * @ordered
	 */
	protected String entitlementServerURL = ENTITLEMENT_SERVER_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = "username";

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = "password";

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getCallbackClassName() <em>Callback Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallbackClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CALLBACK_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCallbackClassName() <em>Callback Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallbackClassName()
	 * @generated
	 * @ordered
	 */
	protected String callbackClassName = CALLBACK_CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getThriftHost() <em>Thrift Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThriftHost()
	 * @generated
	 * @ordered
	 */
	protected static final String THRIFT_HOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThriftHost() <em>Thrift Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThriftHost()
	 * @generated
	 * @ordered
	 */
	protected String thriftHost = THRIFT_HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getThriftPort() <em>Thrift Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThriftPort()
	 * @generated
	 * @ordered
	 */
	protected static final String THRIFT_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThriftPort() <em>Thrift Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThriftPort()
	 * @generated
	 * @ordered
	 */
	protected String thriftPort = THRIFT_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getEntitlementClientType() <em>Entitlement Client Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntitlementClientType()
	 * @generated
	 * @ordered
	 */
	protected static final EntitlementClientType ENTITLEMENT_CLIENT_TYPE_EDEFAULT = EntitlementClientType.BASIC_AUTH;

	/**
	 * The cached value of the '{@link #getEntitlementClientType() <em>Entitlement Client Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntitlementClientType()
	 * @generated
	 * @ordered
	 */
	protected EntitlementClientType entitlementClientType = ENTITLEMENT_CLIENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnRejectSequenceType() <em>On Reject Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnRejectSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final EntitlementSequenceType ON_REJECT_SEQUENCE_TYPE_EDEFAULT = EntitlementSequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getOnRejectSequenceType() <em>On Reject Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnRejectSequenceType()
	 * @generated
	 * @ordered
	 */
	protected EntitlementSequenceType onRejectSequenceType = ON_REJECT_SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnAcceptSequenceType() <em>On Accept Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnAcceptSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final EntitlementSequenceType ON_ACCEPT_SEQUENCE_TYPE_EDEFAULT = EntitlementSequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getOnAcceptSequenceType() <em>On Accept Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnAcceptSequenceType()
	 * @generated
	 * @ordered
	 */
	protected EntitlementSequenceType onAcceptSequenceType = ON_ACCEPT_SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdviceSequenceType() <em>Advice Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdviceSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final EntitlementSequenceType ADVICE_SEQUENCE_TYPE_EDEFAULT = EntitlementSequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getAdviceSequenceType() <em>Advice Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdviceSequenceType()
	 * @generated
	 * @ordered
	 */
	protected EntitlementSequenceType adviceSequenceType = ADVICE_SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getObligationsSequenceType() <em>Obligations Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObligationsSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final EntitlementSequenceType OBLIGATIONS_SEQUENCE_TYPE_EDEFAULT = EntitlementSequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getObligationsSequenceType() <em>Obligations Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObligationsSequenceType()
	 * @generated
	 * @ordered
	 */
	protected EntitlementSequenceType obligationsSequenceType = OBLIGATIONS_SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOnRejectSequenceKey() <em>On Reject Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnRejectSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty onRejectSequenceKey;

	/**
	 * The cached value of the '{@link #getOnAcceptSequenceKey() <em>On Accept Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnAcceptSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty onAcceptSequenceKey;

	/**
	 * The cached value of the '{@link #getAdviceSequenceKey() <em>Advice Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdviceSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty adviceSequenceKey;

	/**
	 * The cached value of the '{@link #getObligationsSequenceKey() <em>Obligations Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObligationsSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty obligationsSequenceKey;

	/**
	 * The cached value of the '{@link #getEntitlementContainer() <em>Entitlement Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntitlementContainer()
	 * @generated
	 * @ordered
	 */
	protected EntitlementContainer entitlementContainer;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected EntitlementMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EntitlementMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getOnRejectOutputConnector() <em>On Reject Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnRejectOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EntitlementMediatorOnRejectOutputConnector onRejectOutputConnector;

	/**
	 * The cached value of the '{@link #getOnAcceptOutputConnector() <em>On Accept Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnAcceptOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EntitlementMediatorOnAcceptOutputConnector onAcceptOutputConnector;

	/**
	 * The cached value of the '{@link #getAdviceOutputConnector() <em>Advice Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdviceOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EntitlementMediatorAdviceOutputConnector adviceOutputConnector;

	/**
	 * The cached value of the '{@link #getObligationsOutputConnector() <em>Obligations Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObligationsOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EntitlementMediatorObligationsOutputConnector obligationsOutputConnector;

	/**
	 * The default value of the '{@link #getCallbackHandler() <em>Callback Handler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallbackHandler()
	 * @generated
	 * @ordered
	 */
	protected static final EntitlementCallbackHandler CALLBACK_HANDLER_EDEFAULT = EntitlementCallbackHandler.UT;

	/**
	 * The cached value of the '{@link #getCallbackHandler() <em>Callback Handler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallbackHandler()
	 * @generated
	 * @ordered
	 */
	protected EntitlementCallbackHandler callbackHandler = CALLBACK_HANDLER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected EntitlementMediatorImpl() {
		super();
	
		RegistryKeyProperty onRejectSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)onRejectSequenceKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		onRejectSequenceKey.setPrettyName("Entitlement OnReject Sequence");
		onRejectSequenceKey.setKeyName("sequence");
		onRejectSequenceKey.setKeyValue(DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY);
		setOnRejectSequenceKey(onRejectSequenceKey);
		
		RegistryKeyProperty onAcceptSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)onAcceptSequenceKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		onAcceptSequenceKey.setPrettyName("Entitlement OnAccept Sequence");
		onAcceptSequenceKey.setKeyName("sequence");
		onAcceptSequenceKey.setKeyValue(DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY);
		setOnAcceptSequenceKey(onAcceptSequenceKey);
		
		RegistryKeyProperty adviceSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)adviceSequenceKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		adviceSequenceKey.setPrettyName("Entitlement Advice Sequence");
		adviceSequenceKey.setKeyName("sequence");
		adviceSequenceKey.setKeyValue(DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY);
		setAdviceSequenceKey(adviceSequenceKey);
		
		RegistryKeyProperty obligationsSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)obligationsSequenceKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		obligationsSequenceKey.setPrettyName("Entitlement Obligations Sequence");
		obligationsSequenceKey.setKeyName("sequence");
		obligationsSequenceKey.setKeyValue(DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY);
		setObligationsSequenceKey(obligationsSequenceKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ENTITLEMENT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntitlementServerURL() {
		return entitlementServerURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntitlementServerURL(String newEntitlementServerURL) {
		String oldEntitlementServerURL = entitlementServerURL;
		entitlementServerURL = newEntitlementServerURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_SERVER_URL, oldEntitlementServerURL, entitlementServerURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCallbackClassName() {
		return callbackClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallbackClassName(String newCallbackClassName) {
		String oldCallbackClassName = callbackClassName;
		callbackClassName = newCallbackClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS_NAME, oldCallbackClassName, callbackClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThriftHost() {
		return thriftHost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThriftHost(String newThriftHost) {
		String oldThriftHost = thriftHost;
		thriftHost = newThriftHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_HOST, oldThriftHost, thriftHost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThriftPort() {
		return thriftPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThriftPort(String newThriftPort) {
		String oldThriftPort = thriftPort;
		thriftPort = newThriftPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_PORT, oldThriftPort, thriftPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementClientType getEntitlementClientType() {
		return entitlementClientType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntitlementClientType(EntitlementClientType newEntitlementClientType) {
		EntitlementClientType oldEntitlementClientType = entitlementClientType;
		entitlementClientType = newEntitlementClientType == null ? ENTITLEMENT_CLIENT_TYPE_EDEFAULT : newEntitlementClientType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE, oldEntitlementClientType, entitlementClientType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementSequenceType getOnRejectSequenceType() {
		return onRejectSequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnRejectSequenceType(EntitlementSequenceType newOnRejectSequenceType) {
		EntitlementSequenceType oldOnRejectSequenceType = onRejectSequenceType;
		onRejectSequenceType = newOnRejectSequenceType == null ? ON_REJECT_SEQUENCE_TYPE_EDEFAULT : newOnRejectSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_TYPE, oldOnRejectSequenceType, onRejectSequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementSequenceType getOnAcceptSequenceType() {
		return onAcceptSequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnAcceptSequenceType(EntitlementSequenceType newOnAcceptSequenceType) {
		EntitlementSequenceType oldOnAcceptSequenceType = onAcceptSequenceType;
		onAcceptSequenceType = newOnAcceptSequenceType == null ? ON_ACCEPT_SEQUENCE_TYPE_EDEFAULT : newOnAcceptSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_TYPE, oldOnAcceptSequenceType, onAcceptSequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementSequenceType getAdviceSequenceType() {
		return adviceSequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdviceSequenceType(EntitlementSequenceType newAdviceSequenceType) {
		EntitlementSequenceType oldAdviceSequenceType = adviceSequenceType;
		adviceSequenceType = newAdviceSequenceType == null ? ADVICE_SEQUENCE_TYPE_EDEFAULT : newAdviceSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_TYPE, oldAdviceSequenceType, adviceSequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementSequenceType getObligationsSequenceType() {
		return obligationsSequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObligationsSequenceType(EntitlementSequenceType newObligationsSequenceType) {
		EntitlementSequenceType oldObligationsSequenceType = obligationsSequenceType;
		obligationsSequenceType = newObligationsSequenceType == null ? OBLIGATIONS_SEQUENCE_TYPE_EDEFAULT : newObligationsSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_TYPE, oldObligationsSequenceType, obligationsSequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOnRejectSequenceKey() {
		return onRejectSequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnRejectSequenceKey(RegistryKeyProperty newOnRejectSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldOnRejectSequenceKey = onRejectSequenceKey;
		onRejectSequenceKey = newOnRejectSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY, oldOnRejectSequenceKey, newOnRejectSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnRejectSequenceKey(RegistryKeyProperty newOnRejectSequenceKey) {
		if (newOnRejectSequenceKey != onRejectSequenceKey) {
			NotificationChain msgs = null;
			if (onRejectSequenceKey != null)
				msgs = ((InternalEObject)onRejectSequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY, null, msgs);
			if (newOnRejectSequenceKey != null)
				msgs = ((InternalEObject)newOnRejectSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY, null, msgs);
			msgs = basicSetOnRejectSequenceKey(newOnRejectSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY, newOnRejectSequenceKey, newOnRejectSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOnAcceptSequenceKey() {
		return onAcceptSequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnAcceptSequenceKey(RegistryKeyProperty newOnAcceptSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldOnAcceptSequenceKey = onAcceptSequenceKey;
		onAcceptSequenceKey = newOnAcceptSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY, oldOnAcceptSequenceKey, newOnAcceptSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnAcceptSequenceKey(RegistryKeyProperty newOnAcceptSequenceKey) {
		if (newOnAcceptSequenceKey != onAcceptSequenceKey) {
			NotificationChain msgs = null;
			if (onAcceptSequenceKey != null)
				msgs = ((InternalEObject)onAcceptSequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY, null, msgs);
			if (newOnAcceptSequenceKey != null)
				msgs = ((InternalEObject)newOnAcceptSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY, null, msgs);
			msgs = basicSetOnAcceptSequenceKey(newOnAcceptSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY, newOnAcceptSequenceKey, newOnAcceptSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getAdviceSequenceKey() {
		return adviceSequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdviceSequenceKey(RegistryKeyProperty newAdviceSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldAdviceSequenceKey = adviceSequenceKey;
		adviceSequenceKey = newAdviceSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY, oldAdviceSequenceKey, newAdviceSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdviceSequenceKey(RegistryKeyProperty newAdviceSequenceKey) {
		if (newAdviceSequenceKey != adviceSequenceKey) {
			NotificationChain msgs = null;
			if (adviceSequenceKey != null)
				msgs = ((InternalEObject)adviceSequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY, null, msgs);
			if (newAdviceSequenceKey != null)
				msgs = ((InternalEObject)newAdviceSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY, null, msgs);
			msgs = basicSetAdviceSequenceKey(newAdviceSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY, newAdviceSequenceKey, newAdviceSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getObligationsSequenceKey() {
		return obligationsSequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObligationsSequenceKey(RegistryKeyProperty newObligationsSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldObligationsSequenceKey = obligationsSequenceKey;
		obligationsSequenceKey = newObligationsSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY, oldObligationsSequenceKey, newObligationsSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObligationsSequenceKey(RegistryKeyProperty newObligationsSequenceKey) {
		if (newObligationsSequenceKey != obligationsSequenceKey) {
			NotificationChain msgs = null;
			if (obligationsSequenceKey != null)
				msgs = ((InternalEObject)obligationsSequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY, null, msgs);
			if (newObligationsSequenceKey != null)
				msgs = ((InternalEObject)newObligationsSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY, null, msgs);
			msgs = basicSetObligationsSequenceKey(newObligationsSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY, newObligationsSequenceKey, newObligationsSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementContainer getEntitlementContainer() {
		return entitlementContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntitlementContainer(EntitlementContainer newEntitlementContainer, NotificationChain msgs) {
		EntitlementContainer oldEntitlementContainer = entitlementContainer;
		entitlementContainer = newEntitlementContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER, oldEntitlementContainer, newEntitlementContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntitlementContainer(EntitlementContainer newEntitlementContainer) {
		if (newEntitlementContainer != entitlementContainer) {
			NotificationChain msgs = null;
			if (entitlementContainer != null)
				msgs = ((InternalEObject)entitlementContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER, null, msgs);
			if (newEntitlementContainer != null)
				msgs = ((InternalEObject)newEntitlementContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER, null, msgs);
			msgs = basicSetEntitlementContainer(newEntitlementContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER, newEntitlementContainer, newEntitlementContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(EntitlementMediatorInputConnector newInputConnector, NotificationChain msgs) {
		EntitlementMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(EntitlementMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(EntitlementMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		EntitlementMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(EntitlementMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorOnRejectOutputConnector getOnRejectOutputConnector() {
		return onRejectOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnRejectOutputConnector(EntitlementMediatorOnRejectOutputConnector newOnRejectOutputConnector, NotificationChain msgs) {
		EntitlementMediatorOnRejectOutputConnector oldOnRejectOutputConnector = onRejectOutputConnector;
		onRejectOutputConnector = newOnRejectOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR, oldOnRejectOutputConnector, newOnRejectOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnRejectOutputConnector(EntitlementMediatorOnRejectOutputConnector newOnRejectOutputConnector) {
		if (newOnRejectOutputConnector != onRejectOutputConnector) {
			NotificationChain msgs = null;
			if (onRejectOutputConnector != null)
				msgs = ((InternalEObject)onRejectOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR, null, msgs);
			if (newOnRejectOutputConnector != null)
				msgs = ((InternalEObject)newOnRejectOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOnRejectOutputConnector(newOnRejectOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR, newOnRejectOutputConnector, newOnRejectOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorOnAcceptOutputConnector getOnAcceptOutputConnector() {
		return onAcceptOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnAcceptOutputConnector(EntitlementMediatorOnAcceptOutputConnector newOnAcceptOutputConnector, NotificationChain msgs) {
		EntitlementMediatorOnAcceptOutputConnector oldOnAcceptOutputConnector = onAcceptOutputConnector;
		onAcceptOutputConnector = newOnAcceptOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR, oldOnAcceptOutputConnector, newOnAcceptOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnAcceptOutputConnector(EntitlementMediatorOnAcceptOutputConnector newOnAcceptOutputConnector) {
		if (newOnAcceptOutputConnector != onAcceptOutputConnector) {
			NotificationChain msgs = null;
			if (onAcceptOutputConnector != null)
				msgs = ((InternalEObject)onAcceptOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR, null, msgs);
			if (newOnAcceptOutputConnector != null)
				msgs = ((InternalEObject)newOnAcceptOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOnAcceptOutputConnector(newOnAcceptOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR, newOnAcceptOutputConnector, newOnAcceptOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorAdviceOutputConnector getAdviceOutputConnector() {
		return adviceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdviceOutputConnector(EntitlementMediatorAdviceOutputConnector newAdviceOutputConnector, NotificationChain msgs) {
		EntitlementMediatorAdviceOutputConnector oldAdviceOutputConnector = adviceOutputConnector;
		adviceOutputConnector = newAdviceOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR, oldAdviceOutputConnector, newAdviceOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdviceOutputConnector(EntitlementMediatorAdviceOutputConnector newAdviceOutputConnector) {
		if (newAdviceOutputConnector != adviceOutputConnector) {
			NotificationChain msgs = null;
			if (adviceOutputConnector != null)
				msgs = ((InternalEObject)adviceOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR, null, msgs);
			if (newAdviceOutputConnector != null)
				msgs = ((InternalEObject)newAdviceOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetAdviceOutputConnector(newAdviceOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR, newAdviceOutputConnector, newAdviceOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorObligationsOutputConnector getObligationsOutputConnector() {
		return obligationsOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObligationsOutputConnector(EntitlementMediatorObligationsOutputConnector newObligationsOutputConnector, NotificationChain msgs) {
		EntitlementMediatorObligationsOutputConnector oldObligationsOutputConnector = obligationsOutputConnector;
		obligationsOutputConnector = newObligationsOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR, oldObligationsOutputConnector, newObligationsOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObligationsOutputConnector(EntitlementMediatorObligationsOutputConnector newObligationsOutputConnector) {
		if (newObligationsOutputConnector != obligationsOutputConnector) {
			NotificationChain msgs = null;
			if (obligationsOutputConnector != null)
				msgs = ((InternalEObject)obligationsOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR, null, msgs);
			if (newObligationsOutputConnector != null)
				msgs = ((InternalEObject)newObligationsOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetObligationsOutputConnector(newObligationsOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR, newObligationsOutputConnector, newObligationsOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementCallbackHandler getCallbackHandler() {
		return callbackHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallbackHandler(EntitlementCallbackHandler newCallbackHandler) {
		EntitlementCallbackHandler oldCallbackHandler = callbackHandler;
		callbackHandler = newCallbackHandler == null ? CALLBACK_HANDLER_EDEFAULT : newCallbackHandler;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER, oldCallbackHandler, callbackHandler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY:
				return basicSetOnRejectSequenceKey(null, msgs);
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY:
				return basicSetOnAcceptSequenceKey(null, msgs);
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY:
				return basicSetAdviceSequenceKey(null, msgs);
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY:
				return basicSetObligationsSequenceKey(null, msgs);
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER:
				return basicSetEntitlementContainer(null, msgs);
			case EsbPackage.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
				return basicSetOnRejectOutputConnector(null, msgs);
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
				return basicSetOnAcceptOutputConnector(null, msgs);
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR:
				return basicSetAdviceOutputConnector(null, msgs);
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR:
				return basicSetObligationsOutputConnector(null, msgs);
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
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_SERVER_URL:
				return getEntitlementServerURL();
			case EsbPackage.ENTITLEMENT_MEDIATOR__USERNAME:
				return getUsername();
			case EsbPackage.ENTITLEMENT_MEDIATOR__PASSWORD:
				return getPassword();
			case EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS_NAME:
				return getCallbackClassName();
			case EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_HOST:
				return getThriftHost();
			case EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_PORT:
				return getThriftPort();
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE:
				return getEntitlementClientType();
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_TYPE:
				return getOnRejectSequenceType();
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_TYPE:
				return getOnAcceptSequenceType();
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_TYPE:
				return getAdviceSequenceType();
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_TYPE:
				return getObligationsSequenceType();
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY:
				return getOnRejectSequenceKey();
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY:
				return getOnAcceptSequenceKey();
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY:
				return getAdviceSequenceKey();
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY:
				return getObligationsSequenceKey();
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER:
				return getEntitlementContainer();
			case EsbPackage.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
				return getOnRejectOutputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
				return getOnAcceptOutputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR:
				return getAdviceOutputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR:
				return getObligationsOutputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER:
				return getCallbackHandler();
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
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_SERVER_URL:
				setEntitlementServerURL((String)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__USERNAME:
				setUsername((String)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__PASSWORD:
				setPassword((String)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS_NAME:
				setCallbackClassName((String)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_HOST:
				setThriftHost((String)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_PORT:
				setThriftPort((String)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE:
				setEntitlementClientType((EntitlementClientType)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_TYPE:
				setOnRejectSequenceType((EntitlementSequenceType)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_TYPE:
				setOnAcceptSequenceType((EntitlementSequenceType)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_TYPE:
				setAdviceSequenceType((EntitlementSequenceType)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_TYPE:
				setObligationsSequenceType((EntitlementSequenceType)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY:
				setOnRejectSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY:
				setOnAcceptSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY:
				setAdviceSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY:
				setObligationsSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER:
				setEntitlementContainer((EntitlementContainer)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((EntitlementMediatorInputConnector)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((EntitlementMediatorOutputConnector)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
				setOnRejectOutputConnector((EntitlementMediatorOnRejectOutputConnector)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
				setOnAcceptOutputConnector((EntitlementMediatorOnAcceptOutputConnector)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR:
				setAdviceOutputConnector((EntitlementMediatorAdviceOutputConnector)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR:
				setObligationsOutputConnector((EntitlementMediatorObligationsOutputConnector)newValue);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER:
				setCallbackHandler((EntitlementCallbackHandler)newValue);
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
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_SERVER_URL:
				setEntitlementServerURL(ENTITLEMENT_SERVER_URL_EDEFAULT);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS_NAME:
				setCallbackClassName(CALLBACK_CLASS_NAME_EDEFAULT);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_HOST:
				setThriftHost(THRIFT_HOST_EDEFAULT);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_PORT:
				setThriftPort(THRIFT_PORT_EDEFAULT);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE:
				setEntitlementClientType(ENTITLEMENT_CLIENT_TYPE_EDEFAULT);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_TYPE:
				setOnRejectSequenceType(ON_REJECT_SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_TYPE:
				setOnAcceptSequenceType(ON_ACCEPT_SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_TYPE:
				setAdviceSequenceType(ADVICE_SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_TYPE:
				setObligationsSequenceType(OBLIGATIONS_SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY:
				setOnRejectSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY:
				setOnAcceptSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY:
				setAdviceSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY:
				setObligationsSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER:
				setEntitlementContainer((EntitlementContainer)null);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((EntitlementMediatorInputConnector)null);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((EntitlementMediatorOutputConnector)null);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
				setOnRejectOutputConnector((EntitlementMediatorOnRejectOutputConnector)null);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
				setOnAcceptOutputConnector((EntitlementMediatorOnAcceptOutputConnector)null);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR:
				setAdviceOutputConnector((EntitlementMediatorAdviceOutputConnector)null);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR:
				setObligationsOutputConnector((EntitlementMediatorObligationsOutputConnector)null);
				return;
			case EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER:
				setCallbackHandler(CALLBACK_HANDLER_EDEFAULT);
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
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_SERVER_URL:
				return ENTITLEMENT_SERVER_URL_EDEFAULT == null ? entitlementServerURL != null : !ENTITLEMENT_SERVER_URL_EDEFAULT.equals(entitlementServerURL);
			case EsbPackage.ENTITLEMENT_MEDIATOR__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case EsbPackage.ENTITLEMENT_MEDIATOR__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_CLASS_NAME:
				return CALLBACK_CLASS_NAME_EDEFAULT == null ? callbackClassName != null : !CALLBACK_CLASS_NAME_EDEFAULT.equals(callbackClassName);
			case EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_HOST:
				return THRIFT_HOST_EDEFAULT == null ? thriftHost != null : !THRIFT_HOST_EDEFAULT.equals(thriftHost);
			case EsbPackage.ENTITLEMENT_MEDIATOR__THRIFT_PORT:
				return THRIFT_PORT_EDEFAULT == null ? thriftPort != null : !THRIFT_PORT_EDEFAULT.equals(thriftPort);
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE:
				return entitlementClientType != ENTITLEMENT_CLIENT_TYPE_EDEFAULT;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_TYPE:
				return onRejectSequenceType != ON_REJECT_SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_TYPE:
				return onAcceptSequenceType != ON_ACCEPT_SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_TYPE:
				return adviceSequenceType != ADVICE_SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_TYPE:
				return obligationsSequenceType != OBLIGATIONS_SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY:
				return onRejectSequenceKey != null;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY:
				return onAcceptSequenceKey != null;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY:
				return adviceSequenceKey != null;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY:
				return obligationsSequenceKey != null;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ENTITLEMENT_CONTAINER:
				return entitlementContainer != null;
			case EsbPackage.ENTITLEMENT_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
				return onRejectOutputConnector != null;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
				return onAcceptOutputConnector != null;
			case EsbPackage.ENTITLEMENT_MEDIATOR__ADVICE_OUTPUT_CONNECTOR:
				return adviceOutputConnector != null;
			case EsbPackage.ENTITLEMENT_MEDIATOR__OBLIGATIONS_OUTPUT_CONNECTOR:
				return obligationsOutputConnector != null;
			case EsbPackage.ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER:
				return callbackHandler != CALLBACK_HANDLER_EDEFAULT;
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
		result.append(" (entitlementServerURL: ");
		result.append(entitlementServerURL);
		result.append(", username: ");
		result.append(username);
		result.append(", password: ");
		result.append(password);
		result.append(", callbackClassName: ");
		result.append(callbackClassName);
		result.append(", thriftHost: ");
		result.append(thriftHost);
		result.append(", thriftPort: ");
		result.append(thriftPort);
		result.append(", entitlementClientType: ");
		result.append(entitlementClientType);
		result.append(", onRejectSequenceType: ");
		result.append(onRejectSequenceType);
		result.append(", onAcceptSequenceType: ");
		result.append(onAcceptSequenceType);
		result.append(", adviceSequenceType: ");
		result.append(adviceSequenceType);
		result.append(", obligationsSequenceType: ");
		result.append(obligationsSequenceType);
		result.append(", callbackHandler: ");
		result.append(callbackHandler);
		result.append(')');
		return result.toString();
	}

} //EntitlementMediatorImpl
