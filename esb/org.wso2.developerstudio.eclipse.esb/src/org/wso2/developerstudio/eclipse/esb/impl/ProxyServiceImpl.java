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
package org.wso2.developerstudio.eclipse.esb.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxyFaultSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxyInSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxyOutSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxyService;
import org.wso2.developerstudio.eclipse.esb.ProxyServiceParameter;
import org.wso2.developerstudio.eclipse.esb.ProxyServicePolicy;
import org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proxy Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#getPinnedServers <em>Pinned Servers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#getServiceGroup <em>Service Group</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#isTraceEnabled <em>Trace Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#isStatisticsEnabled <em>Statistics Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#getTransports <em>Transports</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#isSecurityEnabled <em>Security Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#getWsdlConfiguration <em>Wsdl Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#getInSequenceConfiguration <em>In Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#getEndpointConfiguration <em>Endpoint Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#getOutSequenceConfiguration <em>Out Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#getFaultSequenceConfiguration <em>Fault Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#getServiceParameters <em>Service Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyServiceImpl#getServicePolicies <em>Service Policies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProxyServiceImpl extends ConfigurationElementImpl implements ProxyService {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "service_name";

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
	 * The cached value of the '{@link #getWsdlConfiguration() <em>Wsdl Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ProxyWsdlConfiguration wsdlConfiguration;

	/**
	 * The cached value of the '{@link #getInSequenceConfiguration() <em>In Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ProxyInSequenceConfiguration inSequenceConfiguration;

	/**
	 * The cached value of the '{@link #getEndpointConfiguration() <em>Endpoint Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ProxyEndpointConfiguration endpointConfiguration;

	/**
	 * The cached value of the '{@link #getOutSequenceConfiguration() <em>Out Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ProxyOutSequenceConfiguration outSequenceConfiguration;

	/**
	 * The cached value of the '{@link #getFaultSequenceConfiguration() <em>Fault Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ProxyFaultSequenceConfiguration faultSequenceConfiguration;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected ProxyServiceImpl() {
		super();
		
		// WSDL
		ProxyWsdlConfiguration wsdlConfiguration = getEsbFactory().createProxyWsdlConfiguration();
		setWsdlConfiguration(wsdlConfiguration);
		
		// In Sequence
		ProxyInSequenceConfiguration inSequenceConfiguration = getEsbFactory().createProxyInSequenceConfiguration();
		setInSequenceConfiguration(inSequenceConfiguration);
		
		// Endpoint
		ProxyEndpointConfiguration endpointConfiguration = getEsbFactory().createProxyEndpointConfiguration();
		setEndpointConfiguration(endpointConfiguration);
		
		// Out Sequence
		ProxyOutSequenceConfiguration outSequenceConfiguration = getEsbFactory().createProxyOutSequenceConfiguration();
		setOutSequenceConfiguration(outSequenceConfiguration);
		
		// Fault Sequence
		ProxyFaultSequenceConfiguration faultSequenceConfiguration = getEsbFactory().createProxyFaultSequenceConfiguration();
		setFaultSequenceConfiguration(faultSequenceConfiguration);		
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {				
		// General information.
		{
			setName(self.getAttribute("name"));

			if (self.getAttribute("statistics").equalsIgnoreCase("enable")) {
				setStatisticsEnabled(true);
			}

			if (self.getAttribute("trace").equalsIgnoreCase("enable")) {
				setTraceEnabled(true);
			}

			setPinnedServers(self.getAttribute("pinnedServers"));			
			setServiceGroup(self.getAttribute("serviceGroup"));			
			setTransports(self.getAttribute("transports"));
		}					
		
		// A valid proxy service deifinition should contain a 'target' element.
		Element targetElem = getChildElement(self, "target");		
		if (null == targetElem) {
			throw new Exception("Incomplete proxy service definition - expected <target/> element.");
		}				
		
		// In sequence.
		getInSequenceConfiguration().load(targetElem);
		
		
		// Endpoint.
		getEndpointConfiguration().load(targetElem);
		
		// Out sequence.
		getOutSequenceConfiguration().load(targetElem);		
		
		// Fault sequence.
		getFaultSequenceConfiguration().load(targetElem);						
		
		// WSDL.
		getWsdlConfiguration().load(self);		
		
		// Service policies.		
		loadObjects(self, "policy", ProxyServicePolicy.class, new ObjectHandler<ProxyServicePolicy>() {
			public void handle(ProxyServicePolicy object) {
				getServicePolicies().add(object);
			}			
		});
		
		// Service parameters.
		loadObjects(self, "parameter", ProxyServiceParameter.class, new ObjectHandler<ProxyServiceParameter>() {
			public void handle(ProxyServiceParameter object) {
				getServiceParameters().add(object);
			}
		});
		
		// QoS Information.
		{
			// Reliable messaging.
			Element reliableMessagingElem = getChildElement(self, "enableRM");
			if (null != reliableMessagingElem) {
				setReliableMessagingEnabled(true);
			}
			
			// Security.
			Element securityElem = getChildElement(self, "enableSec");
			if (null != securityElem) {
				setSecurityEnabled(true);
			}
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {		
		Element self = createChildElement(parent, "proxy");

		// Gerneral information.
		{
			self.setAttribute("name", getName());

			String statisticsEnabled = isStatisticsEnabled() ? "enable" : "disable";
			self.setAttribute("statistics", statisticsEnabled);

			String traceEnabled = isTraceEnabled() ? "enable" : "disable";
			self.setAttribute("trace", traceEnabled);

			if (!StringUtils.isBlank(getPinnedServers())) {
				self.setAttribute("pinnedServers", getPinnedServers());
			}

			if (!StringUtils.isBlank(getServiceGroup())) {
				self.setAttribute("serviceGroup", getServiceGroup());
			}
			
			if (!StringUtils.isBlank(getTransports())) {
				self.setAttribute("transports", getTransports());
			}
		}	
		
		Element targetElem = createChildElement(self, "target");
		
		// In sequence.
		if(getInSequenceConfiguration()!=null){
			getInSequenceConfiguration().save(targetElem);
		}
		
		// Endpoint.
		if(getEndpointConfiguration()!=null){
			getEndpointConfiguration().save(targetElem);
		}
		
		
		// Out sequence.
		if(getOutSequenceConfiguration()!=null){
			getOutSequenceConfiguration().save(targetElem);
		}
		
		// Fault sequence.
		if(getFaultSequenceConfiguration()!=null){
			getFaultSequenceConfiguration().save(targetElem);
		}				
		
		// WSDL.
		if(getWsdlConfiguration()!=null){
			getWsdlConfiguration().save(self);
		}
		
		// Service policies.
		for (ProxyServicePolicy policy : getServicePolicies()) {
			policy.save(self);
		}
		
		// Service parameters.
		for (ProxyServiceParameter parameter : getServiceParameters()) {
			parameter.save(self);
		}
		
		// QoS Information.
		{
			// Reliable messaging.
			if (isReliableMessagingEnabled()) {
				createChildElement(self, "enableRM");
			}
			
			// Security.
			if (isSecurityEnabled()) {
				createChildElement(self, "enableSec");
			}
		}
		
		addComments(self);
		return self;
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
	public ProxyWsdlConfiguration getWsdlConfiguration() {
		return wsdlConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWsdlConfiguration(ProxyWsdlConfiguration newWsdlConfiguration, NotificationChain msgs) {
		ProxyWsdlConfiguration oldWsdlConfiguration = wsdlConfiguration;
		wsdlConfiguration = newWsdlConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__WSDL_CONFIGURATION, oldWsdlConfiguration, newWsdlConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlConfiguration(ProxyWsdlConfiguration newWsdlConfiguration) {
		if (newWsdlConfiguration != wsdlConfiguration) {
			NotificationChain msgs = null;
			if (wsdlConfiguration != null)
				msgs = ((InternalEObject)wsdlConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__WSDL_CONFIGURATION, null, msgs);
			if (newWsdlConfiguration != null)
				msgs = ((InternalEObject)newWsdlConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__WSDL_CONFIGURATION, null, msgs);
			msgs = basicSetWsdlConfiguration(newWsdlConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__WSDL_CONFIGURATION, newWsdlConfiguration, newWsdlConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyInSequenceConfiguration getInSequenceConfiguration() {
		return inSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInSequenceConfiguration(ProxyInSequenceConfiguration newInSequenceConfiguration, NotificationChain msgs) {
		ProxyInSequenceConfiguration oldInSequenceConfiguration = inSequenceConfiguration;
		inSequenceConfiguration = newInSequenceConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION, oldInSequenceConfiguration, newInSequenceConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSequenceConfiguration(ProxyInSequenceConfiguration newInSequenceConfiguration) {
		if (newInSequenceConfiguration != inSequenceConfiguration) {
			NotificationChain msgs = null;
			if (inSequenceConfiguration != null)
				msgs = ((InternalEObject)inSequenceConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION, null, msgs);
			if (newInSequenceConfiguration != null)
				msgs = ((InternalEObject)newInSequenceConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION, null, msgs);
			msgs = basicSetInSequenceConfiguration(newInSequenceConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION, newInSequenceConfiguration, newInSequenceConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyEndpointConfiguration getEndpointConfiguration() {
		return endpointConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndpointConfiguration(ProxyEndpointConfiguration newEndpointConfiguration, NotificationChain msgs) {
		ProxyEndpointConfiguration oldEndpointConfiguration = endpointConfiguration;
		endpointConfiguration = newEndpointConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__ENDPOINT_CONFIGURATION, oldEndpointConfiguration, newEndpointConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointConfiguration(ProxyEndpointConfiguration newEndpointConfiguration) {
		if (newEndpointConfiguration != endpointConfiguration) {
			NotificationChain msgs = null;
			if (endpointConfiguration != null)
				msgs = ((InternalEObject)endpointConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__ENDPOINT_CONFIGURATION, null, msgs);
			if (newEndpointConfiguration != null)
				msgs = ((InternalEObject)newEndpointConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__ENDPOINT_CONFIGURATION, null, msgs);
			msgs = basicSetEndpointConfiguration(newEndpointConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__ENDPOINT_CONFIGURATION, newEndpointConfiguration, newEndpointConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyOutSequenceConfiguration getOutSequenceConfiguration() {
		return outSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutSequenceConfiguration(ProxyOutSequenceConfiguration newOutSequenceConfiguration, NotificationChain msgs) {
		ProxyOutSequenceConfiguration oldOutSequenceConfiguration = outSequenceConfiguration;
		outSequenceConfiguration = newOutSequenceConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION, oldOutSequenceConfiguration, newOutSequenceConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutSequenceConfiguration(ProxyOutSequenceConfiguration newOutSequenceConfiguration) {
		if (newOutSequenceConfiguration != outSequenceConfiguration) {
			NotificationChain msgs = null;
			if (outSequenceConfiguration != null)
				msgs = ((InternalEObject)outSequenceConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION, null, msgs);
			if (newOutSequenceConfiguration != null)
				msgs = ((InternalEObject)newOutSequenceConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION, null, msgs);
			msgs = basicSetOutSequenceConfiguration(newOutSequenceConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION, newOutSequenceConfiguration, newOutSequenceConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyFaultSequenceConfiguration getFaultSequenceConfiguration() {
		return faultSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultSequenceConfiguration(ProxyFaultSequenceConfiguration newFaultSequenceConfiguration, NotificationChain msgs) {
		ProxyFaultSequenceConfiguration oldFaultSequenceConfiguration = faultSequenceConfiguration;
		faultSequenceConfiguration = newFaultSequenceConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION, oldFaultSequenceConfiguration, newFaultSequenceConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultSequenceConfiguration(ProxyFaultSequenceConfiguration newFaultSequenceConfiguration) {
		if (newFaultSequenceConfiguration != faultSequenceConfiguration) {
			NotificationChain msgs = null;
			if (faultSequenceConfiguration != null)
				msgs = ((InternalEObject)faultSequenceConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION, null, msgs);
			if (newFaultSequenceConfiguration != null)
				msgs = ((InternalEObject)newFaultSequenceConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION, null, msgs);
			msgs = basicSetFaultSequenceConfiguration(newFaultSequenceConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION, newFaultSequenceConfiguration, newFaultSequenceConfiguration));
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
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.PROXY_SERVICE__WSDL_CONFIGURATION:
				return basicSetWsdlConfiguration(null, msgs);
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION:
				return basicSetInSequenceConfiguration(null, msgs);
			case EsbPackage.PROXY_SERVICE__ENDPOINT_CONFIGURATION:
				return basicSetEndpointConfiguration(null, msgs);
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION:
				return basicSetOutSequenceConfiguration(null, msgs);
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION:
				return basicSetFaultSequenceConfiguration(null, msgs);
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
				return ((InternalEList<?>)getServiceParameters()).basicRemove(otherEnd, msgs);
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
				return ((InternalEList<?>)getServicePolicies()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.PROXY_SERVICE__TRANSPORTS:
				return getTransports();
			case EsbPackage.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED:
				return isReliableMessagingEnabled();
			case EsbPackage.PROXY_SERVICE__SECURITY_ENABLED:
				return isSecurityEnabled();
			case EsbPackage.PROXY_SERVICE__WSDL_CONFIGURATION:
				return getWsdlConfiguration();
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION:
				return getInSequenceConfiguration();
			case EsbPackage.PROXY_SERVICE__ENDPOINT_CONFIGURATION:
				return getEndpointConfiguration();
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION:
				return getOutSequenceConfiguration();
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION:
				return getFaultSequenceConfiguration();
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
				return getServiceParameters();
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
				return getServicePolicies();
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
			case EsbPackage.PROXY_SERVICE__TRANSPORTS:
				setTransports((String)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED:
				setReliableMessagingEnabled((Boolean)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__SECURITY_ENABLED:
				setSecurityEnabled((Boolean)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_CONFIGURATION:
				setWsdlConfiguration((ProxyWsdlConfiguration)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION:
				setInSequenceConfiguration((ProxyInSequenceConfiguration)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_CONFIGURATION:
				setEndpointConfiguration((ProxyEndpointConfiguration)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION:
				setOutSequenceConfiguration((ProxyOutSequenceConfiguration)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION:
				setFaultSequenceConfiguration((ProxyFaultSequenceConfiguration)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
				getServiceParameters().clear();
				getServiceParameters().addAll((Collection<? extends ProxyServiceParameter>)newValue);
				return;
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
				getServicePolicies().clear();
				getServicePolicies().addAll((Collection<? extends ProxyServicePolicy>)newValue);
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
			case EsbPackage.PROXY_SERVICE__TRANSPORTS:
				setTransports(TRANSPORTS_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED:
				setReliableMessagingEnabled(RELIABLE_MESSAGING_ENABLED_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__SECURITY_ENABLED:
				setSecurityEnabled(SECURITY_ENABLED_EDEFAULT);
				return;
			case EsbPackage.PROXY_SERVICE__WSDL_CONFIGURATION:
				setWsdlConfiguration((ProxyWsdlConfiguration)null);
				return;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION:
				setInSequenceConfiguration((ProxyInSequenceConfiguration)null);
				return;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_CONFIGURATION:
				setEndpointConfiguration((ProxyEndpointConfiguration)null);
				return;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION:
				setOutSequenceConfiguration((ProxyOutSequenceConfiguration)null);
				return;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION:
				setFaultSequenceConfiguration((ProxyFaultSequenceConfiguration)null);
				return;
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
				getServiceParameters().clear();
				return;
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
				getServicePolicies().clear();
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
			case EsbPackage.PROXY_SERVICE__TRANSPORTS:
				return TRANSPORTS_EDEFAULT == null ? transports != null : !TRANSPORTS_EDEFAULT.equals(transports);
			case EsbPackage.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED:
				return reliableMessagingEnabled != RELIABLE_MESSAGING_ENABLED_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__SECURITY_ENABLED:
				return securityEnabled != SECURITY_ENABLED_EDEFAULT;
			case EsbPackage.PROXY_SERVICE__WSDL_CONFIGURATION:
				return wsdlConfiguration != null;
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION:
				return inSequenceConfiguration != null;
			case EsbPackage.PROXY_SERVICE__ENDPOINT_CONFIGURATION:
				return endpointConfiguration != null;
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION:
				return outSequenceConfiguration != null;
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION:
				return faultSequenceConfiguration != null;
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
				return serviceParameters != null && !serviceParameters.isEmpty();
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
				return servicePolicies != null && !servicePolicies.isEmpty();
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
		result.append(", transports: ");
		result.append(transports);
		result.append(", reliableMessagingEnabled: ");
		result.append(reliableMessagingEnabled);
		result.append(", securityEnabled: ");
		result.append(securityEnabled);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
    	if(null==getName() || getName().trim().isEmpty()){
    		validateMap.put("Name", "Name is empty");
    	}
    	//TODO

	    
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Proxy Service", objectValidator);
	    return mediatorValidateMap;
    }

} //ProxyServiceImpl
