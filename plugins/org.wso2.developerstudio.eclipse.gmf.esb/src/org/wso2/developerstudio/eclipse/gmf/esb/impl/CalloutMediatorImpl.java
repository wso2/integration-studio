/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.CalloutEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutPayloadType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutResultType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityPolicies;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Callout Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getServiceURL <em>Service URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getSoapAction <em>Soap Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getPathToAxis2xml <em>Path To Axis2xml</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getPathToAxis2Repository <em>Path To Axis2 Repository</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getPayloadType <em>Payload Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getPayloadMessageXpath <em>Payload Message Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getResultType <em>Result Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getResultMessageXpath <em>Result Message Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getResultContextProperty <em>Result Context Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#isPassHeaders <em>Pass Headers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getAddressEndpoint <em>Address Endpoint</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getPayloadProperty <em>Payload Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getSecurityType <em>Security Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getOutboundPolicyKey <em>Outbound Policy Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getInboundPolicyKey <em>Inbound Policy Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getPolicies <em>Policies</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#getPolicyKey <em>Policy Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CalloutMediatorImpl#isInitAxis2ClientOptions <em>Init Axis2 Client Options</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CalloutMediatorImpl extends MediatorImpl implements CalloutMediator {
	/**
	 * The default value of the '{@link #getServiceURL() <em>Service URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceURL()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceURL() <em>Service URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceURL()
	 * @generated
	 * @ordered
	 */
	protected String serviceURL = SERVICE_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSoapAction() <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoapAction()
	 * @generated
	 * @ordered
	 */
	protected static final String SOAP_ACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSoapAction() <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoapAction()
	 * @generated
	 * @ordered
	 */
	protected String soapAction = SOAP_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPathToAxis2xml() <em>Path To Axis2xml</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathToAxis2xml()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_TO_AXIS2XML_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPathToAxis2xml() <em>Path To Axis2xml</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathToAxis2xml()
	 * @generated
	 * @ordered
	 */
	protected String pathToAxis2xml = PATH_TO_AXIS2XML_EDEFAULT;

	/**
	 * The default value of the '{@link #getPathToAxis2Repository() <em>Path To Axis2 Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathToAxis2Repository()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_TO_AXIS2_REPOSITORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPathToAxis2Repository() <em>Path To Axis2 Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathToAxis2Repository()
	 * @generated
	 * @ordered
	 */
	protected String pathToAxis2Repository = PATH_TO_AXIS2_REPOSITORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPayloadType() <em>Payload Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayloadType()
	 * @generated
	 * @ordered
	 */
	protected static final CalloutPayloadType PAYLOAD_TYPE_EDEFAULT = CalloutPayloadType.XPATH;

	/**
	 * The cached value of the '{@link #getPayloadType() <em>Payload Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayloadType()
	 * @generated
	 * @ordered
	 */
	protected CalloutPayloadType payloadType = PAYLOAD_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPayloadMessageXpath() <em>Payload Message Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayloadMessageXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty payloadMessageXpath;

	/**
	 * The default value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected static final CalloutResultType RESULT_TYPE_EDEFAULT = CalloutResultType.XPATH;

	/**
	 * The cached value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected CalloutResultType resultType = RESULT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResultMessageXpath() <em>Result Message Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultMessageXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty resultMessageXpath;

	/**
	 * The default value of the '{@link #getResultContextProperty() <em>Result Context Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultContextProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_CONTEXT_PROPERTY_EDEFAULT = "context_property_name";

	/**
	 * The cached value of the '{@link #getResultContextProperty() <em>Result Context Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultContextProperty()
	 * @generated
	 * @ordered
	 */
	protected String resultContextProperty = RESULT_CONTEXT_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #isPassHeaders() <em>Pass Headers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPassHeaders()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PASS_HEADERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPassHeaders() <em>Pass Headers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPassHeaders()
	 * @generated
	 * @ordered
	 */
	protected boolean passHeaders = PASS_HEADERS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected CalloutMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected CalloutMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getAddressEndpoint() <em>Address Endpoint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressEndpoint()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty addressEndpoint;

	/**
	 * The default value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected static final CalloutEndpointType ENDPOINT_TYPE_EDEFAULT = CalloutEndpointType.URL;

	/**
	 * The cached value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected CalloutEndpointType endpointType = ENDPOINT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPayloadProperty() <em>Payload Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayloadProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String PAYLOAD_PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPayloadProperty() <em>Payload Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayloadProperty()
	 * @generated
	 * @ordered
	 */
	protected String payloadProperty = PAYLOAD_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecurityType() <em>Security Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityType()
	 * @generated
	 * @ordered
	 */
	protected static final CalloutSecurityType SECURITY_TYPE_EDEFAULT = CalloutSecurityType.FALSE;

	/**
	 * The cached value of the '{@link #getSecurityType() <em>Security Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityType()
	 * @generated
	 * @ordered
	 */
	protected CalloutSecurityType securityType = SECURITY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutboundPolicyKey() <em>Outbound Policy Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutboundPolicyKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty outboundPolicyKey;

	/**
	 * The cached value of the '{@link #getInboundPolicyKey() <em>Inbound Policy Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundPolicyKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty inboundPolicyKey;

	/**
	 * The default value of the '{@link #getPolicies() <em>Policies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicies()
	 * @generated
	 * @ordered
	 */
	protected static final CalloutSecurityPolicies POLICIES_EDEFAULT = CalloutSecurityPolicies.FALSE;

	/**
	 * The cached value of the '{@link #getPolicies() <em>Policies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicies()
	 * @generated
	 * @ordered
	 */
	protected CalloutSecurityPolicies policies = POLICIES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPolicyKey() <em>Policy Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty policyKey;

	/**
	 * The default value of the '{@link #isInitAxis2ClientOptions() <em>Init Axis2 Client Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitAxis2ClientOptions()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INIT_AXIS2_CLIENT_OPTIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInitAxis2ClientOptions() <em>Init Axis2 Client Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitAxis2ClientOptions()
	 * @generated
	 * @ordered
	 */
	protected boolean initAxis2ClientOptions = INIT_AXIS2_CLIENT_OPTIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected CalloutMediatorImpl() {
		super();
		
		// Payload xpath.
		NamespacedProperty payloadXpath = EsbFactoryImpl.eINSTANCE
				.createNamespacedProperty();
		payloadXpath.setPrettyName("Payload XPath");
		payloadXpath.setPropertyName("xpath");
		payloadXpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setPayloadMessageXpath(payloadXpath);

		/*// Payload registry key.
		RegistryKeyProperty payloadKey = EsbFactoryImpl.eINSTANCE
				.createRegistryKeyProperty();
		payloadKey.setPrettyName("Payload Key");
		payloadKey.setKeyName("key");
		payloadKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setPayloadRegistryKey(payloadKey);*/

		RegistryKeyProperty policyKey = EsbFactoryImpl.eINSTANCE
				.createRegistryKeyProperty();
		policyKey.setPrettyName("policyKey Key");
		policyKey.setKeyName("key");
		policyKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setPolicyKey(policyKey);
		
		RegistryKeyProperty inboundpolicyKey = EsbFactoryImpl.eINSTANCE
				.createRegistryKeyProperty();
		inboundpolicyKey.setPrettyName("inboundpolicy Key");
		inboundpolicyKey.setKeyName("key");
		inboundpolicyKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setInboundPolicyKey(inboundpolicyKey);
		
		RegistryKeyProperty outboundpolicyKey = EsbFactoryImpl.eINSTANCE
				.createRegistryKeyProperty();
		outboundpolicyKey.setPrettyName("outboundpolicy Key");
		outboundpolicyKey.setKeyName("key");
		outboundpolicyKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setOutboundPolicyKey(outboundpolicyKey);
		
		
		// Result xpath.
		NamespacedProperty resultXpath = EsbFactoryImpl.eINSTANCE
				.createNamespacedProperty();
		resultXpath.setPrettyName("Target XPath");
		resultXpath.setPropertyName("xpath");
		resultXpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setResultMessageXpath(resultXpath);
		
		//Endpoint key
		RegistryKeyProperty endpointKey = EsbFactoryImpl.eINSTANCE
				.createRegistryKeyProperty();
		endpointKey.setPrettyName("endpoint Key");
		endpointKey.setKeyName("key");
		endpointKey.setKeyValue("");
		setAddressEndpoint(endpointKey);	
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CALLOUT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceURL() {
		return serviceURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceURL(String newServiceURL) {
		String oldServiceURL = serviceURL;
		serviceURL = newServiceURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__SERVICE_URL, oldServiceURL, serviceURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSoapAction() {
		return soapAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoapAction(String newSoapAction) {
		String oldSoapAction = soapAction;
		soapAction = newSoapAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__SOAP_ACTION, oldSoapAction, soapAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathToAxis2xml() {
		return pathToAxis2xml;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathToAxis2xml(String newPathToAxis2xml) {
		String oldPathToAxis2xml = pathToAxis2xml;
		pathToAxis2xml = newPathToAxis2xml;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML, oldPathToAxis2xml, pathToAxis2xml));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathToAxis2Repository() {
		return pathToAxis2Repository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathToAxis2Repository(String newPathToAxis2Repository) {
		String oldPathToAxis2Repository = pathToAxis2Repository;
		pathToAxis2Repository = newPathToAxis2Repository;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY, oldPathToAxis2Repository, pathToAxis2Repository));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutPayloadType getPayloadType() {
		return payloadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayloadType(CalloutPayloadType newPayloadType) {
		CalloutPayloadType oldPayloadType = payloadType;
		payloadType = newPayloadType == null ? PAYLOAD_TYPE_EDEFAULT : newPayloadType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE, oldPayloadType, payloadType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getPayloadMessageXpath() {
		return payloadMessageXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPayloadMessageXpath(NamespacedProperty newPayloadMessageXpath, NotificationChain msgs) {
		NamespacedProperty oldPayloadMessageXpath = payloadMessageXpath;
		payloadMessageXpath = newPayloadMessageXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH, oldPayloadMessageXpath, newPayloadMessageXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayloadMessageXpath(NamespacedProperty newPayloadMessageXpath) {
		if (newPayloadMessageXpath != payloadMessageXpath) {
			NotificationChain msgs = null;
			if (payloadMessageXpath != null)
				msgs = ((InternalEObject)payloadMessageXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH, null, msgs);
			if (newPayloadMessageXpath != null)
				msgs = ((InternalEObject)newPayloadMessageXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH, null, msgs);
			msgs = basicSetPayloadMessageXpath(newPayloadMessageXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH, newPayloadMessageXpath, newPayloadMessageXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutResultType getResultType() {
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultType(CalloutResultType newResultType) {
		CalloutResultType oldResultType = resultType;
		resultType = newResultType == null ? RESULT_TYPE_EDEFAULT : newResultType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__RESULT_TYPE, oldResultType, resultType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getResultMessageXpath() {
		return resultMessageXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultMessageXpath(NamespacedProperty newResultMessageXpath, NotificationChain msgs) {
		NamespacedProperty oldResultMessageXpath = resultMessageXpath;
		resultMessageXpath = newResultMessageXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH, oldResultMessageXpath, newResultMessageXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultMessageXpath(NamespacedProperty newResultMessageXpath) {
		if (newResultMessageXpath != resultMessageXpath) {
			NotificationChain msgs = null;
			if (resultMessageXpath != null)
				msgs = ((InternalEObject)resultMessageXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH, null, msgs);
			if (newResultMessageXpath != null)
				msgs = ((InternalEObject)newResultMessageXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH, null, msgs);
			msgs = basicSetResultMessageXpath(newResultMessageXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH, newResultMessageXpath, newResultMessageXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResultContextProperty() {
		return resultContextProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultContextProperty(String newResultContextProperty) {
		String oldResultContextProperty = resultContextProperty;
		resultContextProperty = newResultContextProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY, oldResultContextProperty, resultContextProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPassHeaders() {
		return passHeaders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassHeaders(boolean newPassHeaders) {
		boolean oldPassHeaders = passHeaders;
		passHeaders = newPassHeaders;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__PASS_HEADERS, oldPassHeaders, passHeaders));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(CalloutMediatorInputConnector newInputConnector, NotificationChain msgs) {
		CalloutMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(CalloutMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(CalloutMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		CalloutMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(CalloutMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getAddressEndpoint() {
		return addressEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddressEndpoint(RegistryKeyProperty newAddressEndpoint, NotificationChain msgs) {
		RegistryKeyProperty oldAddressEndpoint = addressEndpoint;
		addressEndpoint = newAddressEndpoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT, oldAddressEndpoint, newAddressEndpoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddressEndpoint(RegistryKeyProperty newAddressEndpoint) {
		if (newAddressEndpoint != addressEndpoint) {
			NotificationChain msgs = null;
			if (addressEndpoint != null)
				msgs = ((InternalEObject)addressEndpoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT, null, msgs);
			if (newAddressEndpoint != null)
				msgs = ((InternalEObject)newAddressEndpoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT, null, msgs);
			msgs = basicSetAddressEndpoint(newAddressEndpoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT, newAddressEndpoint, newAddressEndpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutEndpointType getEndpointType() {
		return endpointType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointType(CalloutEndpointType newEndpointType) {
		CalloutEndpointType oldEndpointType = endpointType;
		endpointType = newEndpointType == null ? ENDPOINT_TYPE_EDEFAULT : newEndpointType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE, oldEndpointType, endpointType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPayloadProperty() {
		return payloadProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayloadProperty(String newPayloadProperty) {
		String oldPayloadProperty = payloadProperty;
		payloadProperty = newPayloadProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_PROPERTY, oldPayloadProperty, payloadProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutSecurityType getSecurityType() {
		return securityType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecurityType(CalloutSecurityType newSecurityType) {
		CalloutSecurityType oldSecurityType = securityType;
		securityType = newSecurityType == null ? SECURITY_TYPE_EDEFAULT : newSecurityType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__SECURITY_TYPE, oldSecurityType, securityType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOutboundPolicyKey() {
		return outboundPolicyKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutboundPolicyKey(RegistryKeyProperty newOutboundPolicyKey, NotificationChain msgs) {
		RegistryKeyProperty oldOutboundPolicyKey = outboundPolicyKey;
		outboundPolicyKey = newOutboundPolicyKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY, oldOutboundPolicyKey, newOutboundPolicyKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutboundPolicyKey(RegistryKeyProperty newOutboundPolicyKey) {
		if (newOutboundPolicyKey != outboundPolicyKey) {
			NotificationChain msgs = null;
			if (outboundPolicyKey != null)
				msgs = ((InternalEObject)outboundPolicyKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY, null, msgs);
			if (newOutboundPolicyKey != null)
				msgs = ((InternalEObject)newOutboundPolicyKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY, null, msgs);
			msgs = basicSetOutboundPolicyKey(newOutboundPolicyKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY, newOutboundPolicyKey, newOutboundPolicyKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getInboundPolicyKey() {
		return inboundPolicyKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInboundPolicyKey(RegistryKeyProperty newInboundPolicyKey, NotificationChain msgs) {
		RegistryKeyProperty oldInboundPolicyKey = inboundPolicyKey;
		inboundPolicyKey = newInboundPolicyKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__INBOUND_POLICY_KEY, oldInboundPolicyKey, newInboundPolicyKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundPolicyKey(RegistryKeyProperty newInboundPolicyKey) {
		if (newInboundPolicyKey != inboundPolicyKey) {
			NotificationChain msgs = null;
			if (inboundPolicyKey != null)
				msgs = ((InternalEObject)inboundPolicyKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__INBOUND_POLICY_KEY, null, msgs);
			if (newInboundPolicyKey != null)
				msgs = ((InternalEObject)newInboundPolicyKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__INBOUND_POLICY_KEY, null, msgs);
			msgs = basicSetInboundPolicyKey(newInboundPolicyKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__INBOUND_POLICY_KEY, newInboundPolicyKey, newInboundPolicyKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutSecurityPolicies getPolicies() {
		return policies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicies(CalloutSecurityPolicies newPolicies) {
		CalloutSecurityPolicies oldPolicies = policies;
		policies = newPolicies == null ? POLICIES_EDEFAULT : newPolicies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__POLICIES, oldPolicies, policies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getPolicyKey() {
		return policyKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPolicyKey(RegistryKeyProperty newPolicyKey, NotificationChain msgs) {
		RegistryKeyProperty oldPolicyKey = policyKey;
		policyKey = newPolicyKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__POLICY_KEY, oldPolicyKey, newPolicyKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicyKey(RegistryKeyProperty newPolicyKey) {
		if (newPolicyKey != policyKey) {
			NotificationChain msgs = null;
			if (policyKey != null)
				msgs = ((InternalEObject)policyKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__POLICY_KEY, null, msgs);
			if (newPolicyKey != null)
				msgs = ((InternalEObject)newPolicyKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALLOUT_MEDIATOR__POLICY_KEY, null, msgs);
			msgs = basicSetPolicyKey(newPolicyKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__POLICY_KEY, newPolicyKey, newPolicyKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInitAxis2ClientOptions() {
		return initAxis2ClientOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitAxis2ClientOptions(boolean newInitAxis2ClientOptions) {
		boolean oldInitAxis2ClientOptions = initAxis2ClientOptions;
		initAxis2ClientOptions = newInitAxis2ClientOptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALLOUT_MEDIATOR__INIT_AXIS2_CLIENT_OPTIONS, oldInitAxis2ClientOptions, initAxis2ClientOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
				return basicSetPayloadMessageXpath(null, msgs);
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
				return basicSetResultMessageXpath(null, msgs);
			case EsbPackage.CALLOUT_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT:
				return basicSetAddressEndpoint(null, msgs);
			case EsbPackage.CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY:
				return basicSetOutboundPolicyKey(null, msgs);
			case EsbPackage.CALLOUT_MEDIATOR__INBOUND_POLICY_KEY:
				return basicSetInboundPolicyKey(null, msgs);
			case EsbPackage.CALLOUT_MEDIATOR__POLICY_KEY:
				return basicSetPolicyKey(null, msgs);
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
			case EsbPackage.CALLOUT_MEDIATOR__SERVICE_URL:
				return getServiceURL();
			case EsbPackage.CALLOUT_MEDIATOR__SOAP_ACTION:
				return getSoapAction();
			case EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML:
				return getPathToAxis2xml();
			case EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY:
				return getPathToAxis2Repository();
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE:
				return getPayloadType();
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
				return getPayloadMessageXpath();
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_TYPE:
				return getResultType();
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
				return getResultMessageXpath();
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY:
				return getResultContextProperty();
			case EsbPackage.CALLOUT_MEDIATOR__PASS_HEADERS:
				return isPassHeaders();
			case EsbPackage.CALLOUT_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT:
				return getAddressEndpoint();
			case EsbPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE:
				return getEndpointType();
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_PROPERTY:
				return getPayloadProperty();
			case EsbPackage.CALLOUT_MEDIATOR__SECURITY_TYPE:
				return getSecurityType();
			case EsbPackage.CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY:
				return getOutboundPolicyKey();
			case EsbPackage.CALLOUT_MEDIATOR__INBOUND_POLICY_KEY:
				return getInboundPolicyKey();
			case EsbPackage.CALLOUT_MEDIATOR__POLICIES:
				return getPolicies();
			case EsbPackage.CALLOUT_MEDIATOR__POLICY_KEY:
				return getPolicyKey();
			case EsbPackage.CALLOUT_MEDIATOR__INIT_AXIS2_CLIENT_OPTIONS:
				return isInitAxis2ClientOptions();
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
			case EsbPackage.CALLOUT_MEDIATOR__SERVICE_URL:
				setServiceURL((String)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__SOAP_ACTION:
				setSoapAction((String)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML:
				setPathToAxis2xml((String)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY:
				setPathToAxis2Repository((String)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE:
				setPayloadType((CalloutPayloadType)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
				setPayloadMessageXpath((NamespacedProperty)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_TYPE:
				setResultType((CalloutResultType)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
				setResultMessageXpath((NamespacedProperty)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY:
				setResultContextProperty((String)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PASS_HEADERS:
				setPassHeaders((Boolean)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((CalloutMediatorInputConnector)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((CalloutMediatorOutputConnector)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT:
				setAddressEndpoint((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE:
				setEndpointType((CalloutEndpointType)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_PROPERTY:
				setPayloadProperty((String)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__SECURITY_TYPE:
				setSecurityType((CalloutSecurityType)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY:
				setOutboundPolicyKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__INBOUND_POLICY_KEY:
				setInboundPolicyKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__POLICIES:
				setPolicies((CalloutSecurityPolicies)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__POLICY_KEY:
				setPolicyKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__INIT_AXIS2_CLIENT_OPTIONS:
				setInitAxis2ClientOptions((Boolean)newValue);
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
			case EsbPackage.CALLOUT_MEDIATOR__SERVICE_URL:
				setServiceURL(SERVICE_URL_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__SOAP_ACTION:
				setSoapAction(SOAP_ACTION_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML:
				setPathToAxis2xml(PATH_TO_AXIS2XML_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY:
				setPathToAxis2Repository(PATH_TO_AXIS2_REPOSITORY_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE:
				setPayloadType(PAYLOAD_TYPE_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
				setPayloadMessageXpath((NamespacedProperty)null);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_TYPE:
				setResultType(RESULT_TYPE_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
				setResultMessageXpath((NamespacedProperty)null);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY:
				setResultContextProperty(RESULT_CONTEXT_PROPERTY_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PASS_HEADERS:
				setPassHeaders(PASS_HEADERS_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((CalloutMediatorInputConnector)null);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((CalloutMediatorOutputConnector)null);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT:
				setAddressEndpoint((RegistryKeyProperty)null);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE:
				setEndpointType(ENDPOINT_TYPE_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_PROPERTY:
				setPayloadProperty(PAYLOAD_PROPERTY_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__SECURITY_TYPE:
				setSecurityType(SECURITY_TYPE_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY:
				setOutboundPolicyKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__INBOUND_POLICY_KEY:
				setInboundPolicyKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__POLICIES:
				setPolicies(POLICIES_EDEFAULT);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__POLICY_KEY:
				setPolicyKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.CALLOUT_MEDIATOR__INIT_AXIS2_CLIENT_OPTIONS:
				setInitAxis2ClientOptions(INIT_AXIS2_CLIENT_OPTIONS_EDEFAULT);
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
			case EsbPackage.CALLOUT_MEDIATOR__SERVICE_URL:
				return SERVICE_URL_EDEFAULT == null ? serviceURL != null : !SERVICE_URL_EDEFAULT.equals(serviceURL);
			case EsbPackage.CALLOUT_MEDIATOR__SOAP_ACTION:
				return SOAP_ACTION_EDEFAULT == null ? soapAction != null : !SOAP_ACTION_EDEFAULT.equals(soapAction);
			case EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML:
				return PATH_TO_AXIS2XML_EDEFAULT == null ? pathToAxis2xml != null : !PATH_TO_AXIS2XML_EDEFAULT.equals(pathToAxis2xml);
			case EsbPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY:
				return PATH_TO_AXIS2_REPOSITORY_EDEFAULT == null ? pathToAxis2Repository != null : !PATH_TO_AXIS2_REPOSITORY_EDEFAULT.equals(pathToAxis2Repository);
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE:
				return payloadType != PAYLOAD_TYPE_EDEFAULT;
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
				return payloadMessageXpath != null;
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_TYPE:
				return resultType != RESULT_TYPE_EDEFAULT;
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
				return resultMessageXpath != null;
			case EsbPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY:
				return RESULT_CONTEXT_PROPERTY_EDEFAULT == null ? resultContextProperty != null : !RESULT_CONTEXT_PROPERTY_EDEFAULT.equals(resultContextProperty);
			case EsbPackage.CALLOUT_MEDIATOR__PASS_HEADERS:
				return passHeaders != PASS_HEADERS_EDEFAULT;
			case EsbPackage.CALLOUT_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.CALLOUT_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.CALLOUT_MEDIATOR__ADDRESS_ENDPOINT:
				return addressEndpoint != null;
			case EsbPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE:
				return endpointType != ENDPOINT_TYPE_EDEFAULT;
			case EsbPackage.CALLOUT_MEDIATOR__PAYLOAD_PROPERTY:
				return PAYLOAD_PROPERTY_EDEFAULT == null ? payloadProperty != null : !PAYLOAD_PROPERTY_EDEFAULT.equals(payloadProperty);
			case EsbPackage.CALLOUT_MEDIATOR__SECURITY_TYPE:
				return securityType != SECURITY_TYPE_EDEFAULT;
			case EsbPackage.CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY:
				return outboundPolicyKey != null;
			case EsbPackage.CALLOUT_MEDIATOR__INBOUND_POLICY_KEY:
				return inboundPolicyKey != null;
			case EsbPackage.CALLOUT_MEDIATOR__POLICIES:
				return policies != POLICIES_EDEFAULT;
			case EsbPackage.CALLOUT_MEDIATOR__POLICY_KEY:
				return policyKey != null;
			case EsbPackage.CALLOUT_MEDIATOR__INIT_AXIS2_CLIENT_OPTIONS:
				return initAxis2ClientOptions != INIT_AXIS2_CLIENT_OPTIONS_EDEFAULT;
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
		result.append(" (serviceURL: ");
		result.append(serviceURL);
		result.append(", soapAction: ");
		result.append(soapAction);
		result.append(", pathToAxis2xml: ");
		result.append(pathToAxis2xml);
		result.append(", pathToAxis2Repository: ");
		result.append(pathToAxis2Repository);
		result.append(", payloadType: ");
		result.append(payloadType);
		result.append(", resultType: ");
		result.append(resultType);
		result.append(", resultContextProperty: ");
		result.append(resultContextProperty);
		result.append(", passHeaders: ");
		result.append(passHeaders);
		result.append(", EndpointType: ");
		result.append(endpointType);
		result.append(", payloadProperty: ");
		result.append(payloadProperty);
		result.append(", securityType: ");
		result.append(securityType);
		result.append(", policies: ");
		result.append(policies);
		result.append(", initAxis2ClientOptions: ");
		result.append(initAxis2ClientOptions);
		result.append(')');
		return result.toString();
	}

} //CalloutMediatorImpl
