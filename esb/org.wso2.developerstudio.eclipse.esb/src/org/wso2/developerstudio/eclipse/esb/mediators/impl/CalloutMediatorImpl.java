/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType;
import org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType;
import org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Callout Mediator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getServiceURL <em>Service URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getSoapAction <em>Soap Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getPathToAxis2xml <em>Path To Axis2xml</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getPathToAxis2Repository <em>Path To Axis2 Repository</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getPayloadType <em>Payload Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getPayloadMessageXpath <em>Payload Message Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getPayloadRegistryKey <em>Payload Registry Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getResultType <em>Result Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getResultMessageXpath <em>Result Message Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getResultContextProperty <em>Result Context Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#isPassHeaders <em>Pass Headers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#isUseServerConfig <em>Use Server Config</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl#getEndpointKey <em>Endpoint Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CalloutMediatorImpl extends MediatorImpl implements
		CalloutMediator {
	/**
	 * The default value of the '{@link #getServiceURL() <em>Service URL</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceURL()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_URL_EDEFAULT = "service_url";

	/**
	 * The cached value of the '{@link #getServiceURL() <em>Service URL</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceURL()
	 * @generated
	 * @ordered
	 */
	protected String serviceURL = SERVICE_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSoapAction() <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSoapAction()
	 * @generated
	 * @ordered
	 */
	protected static final String SOAP_ACTION_EDEFAULT = "soap_action";

	/**
	 * The cached value of the '{@link #getSoapAction() <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSoapAction()
	 * @generated
	 * @ordered
	 */
	protected String soapAction = SOAP_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPathToAxis2xml() <em>Path To Axis2xml</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPathToAxis2xml()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_TO_AXIS2XML_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPathToAxis2xml() <em>Path To Axis2xml</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
	protected static final String PATH_TO_AXIS2_REPOSITORY_EDEFAULT = "";

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPayloadType()
	 * @generated
	 * @ordered
	 */
	protected static final CalloutPayloadType PAYLOAD_TYPE_EDEFAULT = CalloutPayloadType.MESSAGE_ELEMENT;

	/**
	 * The cached value of the '{@link #getPayloadType() <em>Payload Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPayloadType()
	 * @generated
	 * @ordered
	 */
	protected CalloutPayloadType payloadType = PAYLOAD_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPayloadMessageXpath()
	 * <em>Payload Message Xpath</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPayloadMessageXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty payloadMessageXpath;

	/**
	 * The cached value of the '{@link #getPayloadRegistryKey()
	 * <em>Payload Registry Key</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPayloadRegistryKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty payloadRegistryKey;

	/**
	 * The default value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected static final CalloutResultType RESULT_TYPE_EDEFAULT = CalloutResultType.MESSAGE_ELEMENT;

	/**
	 * The cached value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected CalloutResultType resultType = RESULT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResultMessageXpath()
	 * <em>Result Message Xpath</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * The default value of the '{@link #isUseServerConfig() <em>Use Server Config</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseServerConfig()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_SERVER_CONFIG_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseServerConfig() <em>Use Server Config</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseServerConfig()
	 * @generated
	 * @ordered
	 */
	protected boolean useServerConfig = USE_SERVER_CONFIG_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected static final CallOutMediatorEndpointType ENDPOINT_TYPE_EDEFAULT = CallOutMediatorEndpointType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected CallOutMediatorEndpointType endpointType = ENDPOINT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEndpointKey() <em>Endpoint Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty endpointKey;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected CalloutMediatorImpl() {
		super();

		// Payload xpath.
		NamespacedProperty payloadXpath = getEsbFactory()
				.createNamespacedProperty();
		payloadXpath.setPrettyName("Payload XPath");
		payloadXpath.setPropertyName("xpath");
		payloadXpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setPayloadMessageXpath(payloadXpath);

		// Payload registry key.
		RegistryKeyProperty payloadKey = getEsbFactory()
				.createRegistryKeyProperty();
		payloadKey.setPrettyName("Payload Key");
		payloadKey.setKeyName("key");
		payloadKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setPayloadRegistryKey(payloadKey);

		// Result xpath.
		NamespacedProperty resultXpath = getEsbFactory()
				.createNamespacedProperty();
		resultXpath.setPrettyName("Target XPath");
		resultXpath.setPropertyName("xpath");
		resultXpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setResultMessageXpath(resultXpath);
		
		// Endpoint registry key.
		RegistryKeyProperty endpointKey = getEsbFactory()
				.createRegistryKeyProperty();
		//Setting up filters to filter in only the relevant items from the list 
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)endpointKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_ENDPOINT);
		endpointKey.setPrettyName("Endpoint Key");
		endpointKey.setKeyName("endpointKey");
		endpointKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setEndpointKey(endpointKey);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Service URL.
		if (self.hasAttribute("serviceURL")) {
			setServiceURL(self.getAttribute("serviceURL"));
			setEndpointType(CallOutMediatorEndpointType.ANONYMOUS);
		} else if(self.hasAttribute("endpointKey")){
			setEndpointType(CallOutMediatorEndpointType.REGISTRY_REFERENCE);
			RegistryKeyProperty endPointKey = getEsbFactory().createRegistryKeyProperty();
			endPointKey.setKeyValue(self.getAttribute("endpointKey"));
			endPointKey.setPrettyName("Endpoint Key");
			endPointKey.setKeyName("endpointKey");
			setEndpointKey(endPointKey);
		} else {
			throw new Exception("Expected service url.");
		}

		// Soap action.
		setSoapAction(self.getAttribute("action"));

		// Configuration.
		Element configElem = getChildElement(self, "configuration");
		if (null != configElem) {
			setPathToAxis2xml(configElem.getAttribute("axis2xml"));
			setPathToAxis2Repository(configElem.getAttribute("repository"));
		}

		// Pass Headers
		if (self.hasAttribute("passHeaders")) {
			setPassHeaders(self.getAttribute("passHeaders").equals("true") ? true
					: false);
		} else {
			setPassHeaders(false);
		}
				
		// Use Server Config
		if (self.hasAttribute("useServerConfig")) {
			setUseServerConfig(self.getAttribute("useServerConfig").equals(
					"true") ? true : false);
		} else {
			setUseServerConfig(false);
		}

		// Payload.
		Element sourceElem = getChildElement(self, "source");
		if (null != sourceElem) {
			if (sourceElem.hasAttribute("xpath")) {
				setPayloadType(CalloutPayloadType.MESSAGE_ELEMENT);
				getPayloadMessageXpath().load(sourceElem);
			} else if (sourceElem.hasAttribute("key")) {
				setPayloadType(CalloutPayloadType.REGISTRY_ENTRY);
				getPayloadRegistryKey().load(sourceElem);
			} else {
				throw new Exception(
						"Expected either payload xpath or payload registry key.");
			}
		} else {
			throw new Exception("Expected payload configuration.");
		}

		// Result.
		Element targetElem = getChildElement(self, "target");
		if (null != targetElem) {
			if (targetElem.hasAttribute("xpath")) {
				setResultType(CalloutResultType.MESSAGE_ELEMENT);
				getResultMessageXpath().load(targetElem);
			} else if (targetElem.hasAttribute("key")) {
				setResultType(CalloutResultType.CONTEXT_PROPERTY);
				setResultContextProperty(targetElem.getAttribute("key"));
			} else {
				throw new Exception(
						"Expected result xpath or result context property name.");
			}
		} else {
			throw new Exception("Expected result configuration.");
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "callout");
		
		if(getEndpointType()==CallOutMediatorEndpointType.ANONYMOUS){
			self.setAttribute("serviceURL", getServiceURL());
		}else{
			self.setAttribute("endpointKey", getEndpointKey().getKeyValue());
		}
		

		if (!StringUtils.isBlank(getSoapAction())) {
			self.setAttribute("action", getSoapAction());
		}

		// Pass Headers
		if (isPassHeaders()) {
			self.setAttribute("passHeaders", "true");
		}
				
		// Use Server Configs
		if (isUseServerConfig()) {
			self.setAttribute("useServerConfig", "true");
		}

		// Configuration.
		boolean axis2xmlPathIsBlank = StringUtils.isBlank(getPathToAxis2xml());
		boolean axis2repositoryPathIsBlank = StringUtils
				.isBlank(getPathToAxis2Repository());
		boolean createConfigElem = !(axis2xmlPathIsBlank && axis2repositoryPathIsBlank);
		if (createConfigElem) {
			Element configElem = createChildElement(self, "configuration");
			if (!axis2xmlPathIsBlank) {
				configElem.setAttribute("axis2xml", getPathToAxis2xml());
			}

			if (!axis2repositoryPathIsBlank) {
				configElem.setAttribute("repository",
						getPathToAxis2Repository());
			}
		}

		// Payload.
		Element sourceElem = createChildElement(self, "source");
		if (getPayloadType().equals(CalloutPayloadType.MESSAGE_ELEMENT)) {
			getPayloadMessageXpath().save(sourceElem);
		} else {
			getPayloadRegistryKey().save(sourceElem);
		}

		// Result.
		Element targetElem = createChildElement(self, "target");
		if (getResultType().equals(CalloutResultType.MESSAGE_ELEMENT)) {
			getResultMessageXpath().save(targetElem);
		} else {
			targetElem.setAttribute("key", getResultContextProperty());
		}
		if(description!=null)
			description.save(self);
		
		addComments(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.CALLOUT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceURL() {
		return serviceURL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceURL(String newServiceURL) {
		String oldServiceURL = serviceURL;
		serviceURL = newServiceURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__SERVICE_URL, oldServiceURL, serviceURL));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSoapAction() {
		return soapAction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoapAction(String newSoapAction) {
		String oldSoapAction = soapAction;
		soapAction = newSoapAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__SOAP_ACTION, oldSoapAction, soapAction));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathToAxis2xml() {
		return pathToAxis2xml;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathToAxis2xml(String newPathToAxis2xml) {
		String oldPathToAxis2xml = pathToAxis2xml;
		pathToAxis2xml = newPathToAxis2xml;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML, oldPathToAxis2xml, pathToAxis2xml));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathToAxis2Repository() {
		return pathToAxis2Repository;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathToAxis2Repository(String newPathToAxis2Repository) {
		String oldPathToAxis2Repository = pathToAxis2Repository;
		pathToAxis2Repository = newPathToAxis2Repository;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY, oldPathToAxis2Repository, pathToAxis2Repository));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutPayloadType getPayloadType() {
		return payloadType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayloadType(CalloutPayloadType newPayloadType) {
		CalloutPayloadType oldPayloadType = payloadType;
		payloadType = newPayloadType == null ? PAYLOAD_TYPE_EDEFAULT : newPayloadType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE, oldPayloadType, payloadType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getPayloadMessageXpath() {
		return payloadMessageXpath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPayloadMessageXpath(
			NamespacedProperty newPayloadMessageXpath, NotificationChain msgs) {
		NamespacedProperty oldPayloadMessageXpath = payloadMessageXpath;
		payloadMessageXpath = newPayloadMessageXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH, oldPayloadMessageXpath, newPayloadMessageXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayloadMessageXpath(NamespacedProperty newPayloadMessageXpath) {
		if (newPayloadMessageXpath != payloadMessageXpath) {
			NotificationChain msgs = null;
			if (payloadMessageXpath != null)
				msgs = ((InternalEObject)payloadMessageXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH, null, msgs);
			if (newPayloadMessageXpath != null)
				msgs = ((InternalEObject)newPayloadMessageXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH, null, msgs);
			msgs = basicSetPayloadMessageXpath(newPayloadMessageXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH, newPayloadMessageXpath, newPayloadMessageXpath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getPayloadRegistryKey() {
		return payloadRegistryKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPayloadRegistryKey(
			RegistryKeyProperty newPayloadRegistryKey, NotificationChain msgs) {
		RegistryKeyProperty oldPayloadRegistryKey = payloadRegistryKey;
		payloadRegistryKey = newPayloadRegistryKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY, oldPayloadRegistryKey, newPayloadRegistryKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayloadRegistryKey(RegistryKeyProperty newPayloadRegistryKey) {
		if (newPayloadRegistryKey != payloadRegistryKey) {
			NotificationChain msgs = null;
			if (payloadRegistryKey != null)
				msgs = ((InternalEObject)payloadRegistryKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY, null, msgs);
			if (newPayloadRegistryKey != null)
				msgs = ((InternalEObject)newPayloadRegistryKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY, null, msgs);
			msgs = basicSetPayloadRegistryKey(newPayloadRegistryKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY, newPayloadRegistryKey, newPayloadRegistryKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutResultType getResultType() {
		return resultType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultType(CalloutResultType newResultType) {
		CalloutResultType oldResultType = resultType;
		resultType = newResultType == null ? RESULT_TYPE_EDEFAULT : newResultType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__RESULT_TYPE, oldResultType, resultType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getResultMessageXpath() {
		return resultMessageXpath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultMessageXpath(
			NamespacedProperty newResultMessageXpath, NotificationChain msgs) {
		NamespacedProperty oldResultMessageXpath = resultMessageXpath;
		resultMessageXpath = newResultMessageXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH, oldResultMessageXpath, newResultMessageXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultMessageXpath(NamespacedProperty newResultMessageXpath) {
		if (newResultMessageXpath != resultMessageXpath) {
			NotificationChain msgs = null;
			if (resultMessageXpath != null)
				msgs = ((InternalEObject)resultMessageXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH, null, msgs);
			if (newResultMessageXpath != null)
				msgs = ((InternalEObject)newResultMessageXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH, null, msgs);
			msgs = basicSetResultMessageXpath(newResultMessageXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH, newResultMessageXpath, newResultMessageXpath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getResultContextProperty() {
		return resultContextProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultContextProperty(String newResultContextProperty) {
		String oldResultContextProperty = resultContextProperty;
		resultContextProperty = newResultContextProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY, oldResultContextProperty, resultContextProperty));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__PASS_HEADERS, oldPassHeaders, passHeaders));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseServerConfig() {
		return useServerConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseServerConfig(boolean newUseServerConfig) {
		boolean oldUseServerConfig = useServerConfig;
		useServerConfig = newUseServerConfig;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__USE_SERVER_CONFIG, oldUseServerConfig, useServerConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallOutMediatorEndpointType getEndpointType() {
		return endpointType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointType(CallOutMediatorEndpointType newEndpointType) {
		CallOutMediatorEndpointType oldEndpointType = endpointType;
		endpointType = newEndpointType == null ? ENDPOINT_TYPE_EDEFAULT : newEndpointType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE, oldEndpointType, endpointType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getEndpointKey() {
		if (endpointKey != null && endpointKey.eIsProxy()) {
			InternalEObject oldEndpointKey = (InternalEObject)endpointKey;
			endpointKey = (RegistryKeyProperty)eResolveProxy(oldEndpointKey);
			if (endpointKey != oldEndpointKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_KEY, oldEndpointKey, endpointKey));
			}
		}
		return endpointKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetEndpointKey() {
		return endpointKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointKey(RegistryKeyProperty newEndpointKey) {
		RegistryKeyProperty oldEndpointKey = endpointKey;
		endpointKey = newEndpointKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_KEY, oldEndpointKey, endpointKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
				return basicSetPayloadMessageXpath(null, msgs);
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY:
				return basicSetPayloadRegistryKey(null, msgs);
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
				return basicSetResultMessageXpath(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.CALLOUT_MEDIATOR__SERVICE_URL:
				return getServiceURL();
			case MediatorsPackage.CALLOUT_MEDIATOR__SOAP_ACTION:
				return getSoapAction();
			case MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML:
				return getPathToAxis2xml();
			case MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY:
				return getPathToAxis2Repository();
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE:
				return getPayloadType();
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
				return getPayloadMessageXpath();
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY:
				return getPayloadRegistryKey();
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_TYPE:
				return getResultType();
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
				return getResultMessageXpath();
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY:
				return getResultContextProperty();
			case MediatorsPackage.CALLOUT_MEDIATOR__PASS_HEADERS:
				return isPassHeaders();
			case MediatorsPackage.CALLOUT_MEDIATOR__USE_SERVER_CONFIG:
				return isUseServerConfig();
			case MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE:
				return getEndpointType();
			case MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_KEY:
				if (resolve) return getEndpointKey();
				return basicGetEndpointKey();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.CALLOUT_MEDIATOR__SERVICE_URL:
				setServiceURL((String)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__SOAP_ACTION:
				setSoapAction((String)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML:
				setPathToAxis2xml((String)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY:
				setPathToAxis2Repository((String)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE:
				setPayloadType((CalloutPayloadType)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
				setPayloadMessageXpath((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY:
				setPayloadRegistryKey((RegistryKeyProperty)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_TYPE:
				setResultType((CalloutResultType)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
				setResultMessageXpath((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY:
				setResultContextProperty((String)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PASS_HEADERS:
				setPassHeaders((Boolean)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__USE_SERVER_CONFIG:
				setUseServerConfig((Boolean)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE:
				setEndpointType((CallOutMediatorEndpointType)newValue);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_KEY:
				setEndpointKey((RegistryKeyProperty)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MediatorsPackage.CALLOUT_MEDIATOR__SERVICE_URL:
				setServiceURL(SERVICE_URL_EDEFAULT);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__SOAP_ACTION:
				setSoapAction(SOAP_ACTION_EDEFAULT);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML:
				setPathToAxis2xml(PATH_TO_AXIS2XML_EDEFAULT);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY:
				setPathToAxis2Repository(PATH_TO_AXIS2_REPOSITORY_EDEFAULT);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE:
				setPayloadType(PAYLOAD_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
				setPayloadMessageXpath((NamespacedProperty)null);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY:
				setPayloadRegistryKey((RegistryKeyProperty)null);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_TYPE:
				setResultType(RESULT_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
				setResultMessageXpath((NamespacedProperty)null);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY:
				setResultContextProperty(RESULT_CONTEXT_PROPERTY_EDEFAULT);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__PASS_HEADERS:
				setPassHeaders(PASS_HEADERS_EDEFAULT);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__USE_SERVER_CONFIG:
				setUseServerConfig(USE_SERVER_CONFIG_EDEFAULT);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE:
				setEndpointType(ENDPOINT_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_KEY:
				setEndpointKey((RegistryKeyProperty)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MediatorsPackage.CALLOUT_MEDIATOR__SERVICE_URL:
				return SERVICE_URL_EDEFAULT == null ? serviceURL != null : !SERVICE_URL_EDEFAULT.equals(serviceURL);
			case MediatorsPackage.CALLOUT_MEDIATOR__SOAP_ACTION:
				return SOAP_ACTION_EDEFAULT == null ? soapAction != null : !SOAP_ACTION_EDEFAULT.equals(soapAction);
			case MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2XML:
				return PATH_TO_AXIS2XML_EDEFAULT == null ? pathToAxis2xml != null : !PATH_TO_AXIS2XML_EDEFAULT.equals(pathToAxis2xml);
			case MediatorsPackage.CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY:
				return PATH_TO_AXIS2_REPOSITORY_EDEFAULT == null ? pathToAxis2Repository != null : !PATH_TO_AXIS2_REPOSITORY_EDEFAULT.equals(pathToAxis2Repository);
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_TYPE:
				return payloadType != PAYLOAD_TYPE_EDEFAULT;
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH:
				return payloadMessageXpath != null;
			case MediatorsPackage.CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY:
				return payloadRegistryKey != null;
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_TYPE:
				return resultType != RESULT_TYPE_EDEFAULT;
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH:
				return resultMessageXpath != null;
			case MediatorsPackage.CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY:
				return RESULT_CONTEXT_PROPERTY_EDEFAULT == null ? resultContextProperty != null : !RESULT_CONTEXT_PROPERTY_EDEFAULT.equals(resultContextProperty);
			case MediatorsPackage.CALLOUT_MEDIATOR__PASS_HEADERS:
				return passHeaders != PASS_HEADERS_EDEFAULT;
			case MediatorsPackage.CALLOUT_MEDIATOR__USE_SERVER_CONFIG:
				return useServerConfig != USE_SERVER_CONFIG_EDEFAULT;
			case MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_TYPE:
				return endpointType != ENDPOINT_TYPE_EDEFAULT;
			case MediatorsPackage.CALLOUT_MEDIATOR__ENDPOINT_KEY:
				return endpointKey != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		result.append(", useServerConfig: ");
		result.append(useServerConfig);
		result.append(", EndpointType: ");
		result.append(endpointType);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
 		if (null == getServiceURL()|| getServiceURL().trim().isEmpty()) {
 			validateMap.put("Service URL", "Service URL is empty");
 		}			
 		// Payload.
		if (getPayloadType().equals(CalloutPayloadType.MESSAGE_ELEMENT)) {
			if (null == getPayloadMessageXpath().getPropertyValue()
					|| getPayloadMessageXpath().getPropertyValue().trim()
							.isEmpty()) {
				validateMap.put("PayloadMessage Xpath", "PayloadMessage Xpath is empty");
			}
		} else {
			if (null == getPayloadRegistryKey().getKeyValue()
					|| getPayloadRegistryKey().getKeyValue().trim()
							.isEmpty()) {
				validateMap.put("PayloadRegistry Key", "PayloadRegistry Key is empty");
			}
		}

		// Result.
		if (getResultType().equals(CalloutResultType.MESSAGE_ELEMENT)) {
			if (null == getResultMessageXpath().getPropertyValue()
					|| getResultMessageXpath().getPropertyValue().trim()
							.isEmpty()) {
				validateMap.put("ResultMessage Xpath", "ResultMessage Xpath is empty");
			}
		} else {
			if (null == getResultContextProperty()
					|| getResultContextProperty().trim()
							.isEmpty()) {
				validateMap.put("ResultContext Property", "ResultContext Property is empty");
			}
		}
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("Callout Mediator", objectValidator);
 	    return mediatorValidateMap;
    }

} // CalloutMediatorImpl
