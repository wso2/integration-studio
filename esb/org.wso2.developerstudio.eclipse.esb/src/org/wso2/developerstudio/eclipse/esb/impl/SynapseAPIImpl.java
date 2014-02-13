/**
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
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.ApiResource;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.SynapseAPI;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Synapse API</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.SynapseAPIImpl#getApiName <em>Api Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.SynapseAPIImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.SynapseAPIImpl#getHostname <em>Hostname</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.SynapseAPIImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.SynapseAPIImpl#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SynapseAPIImpl extends ConfigurationElementImpl implements SynapseAPI {
	/**
	 * The default value of the '{@link #getApiName() <em>Api Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiName()
	 * @generated
	 * @ordered
	 */
	protected static final String API_NAME_EDEFAULT = "api_name";

	/**
	 * The cached value of the '{@link #getApiName() <em>Api Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiName()
	 * @generated
	 * @ordered
	 */
	protected String apiName = API_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_EDEFAULT = "/context";

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected String context = CONTEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getHostname() <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected static final String HOSTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHostname() <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected String hostname = HOSTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final int PORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected int port = PORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<ApiResource> resources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SynapseAPIImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.SYNAPSE_API;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApiName() {
		return apiName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApiName(String newApiName) {
		String oldApiName = apiName;
		apiName = newApiName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SYNAPSE_API__API_NAME, oldApiName, apiName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(String newContext) {
		String oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SYNAPSE_API__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostname(String newHostname) {
		String oldHostname = hostname;
		hostname = newHostname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SYNAPSE_API__HOSTNAME, oldHostname, hostname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(int newPort) {
		int oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SYNAPSE_API__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApiResource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<ApiResource>(ApiResource.class, this, EsbPackage.SYNAPSE_API__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.SYNAPSE_API__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.SYNAPSE_API__API_NAME:
				return getApiName();
			case EsbPackage.SYNAPSE_API__CONTEXT:
				return getContext();
			case EsbPackage.SYNAPSE_API__HOSTNAME:
				return getHostname();
			case EsbPackage.SYNAPSE_API__PORT:
				return getPort();
			case EsbPackage.SYNAPSE_API__RESOURCES:
				return getResources();
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
			case EsbPackage.SYNAPSE_API__API_NAME:
				setApiName((String)newValue);
				return;
			case EsbPackage.SYNAPSE_API__CONTEXT:
				setContext((String)newValue);
				return;
			case EsbPackage.SYNAPSE_API__HOSTNAME:
				setHostname((String)newValue);
				return;
			case EsbPackage.SYNAPSE_API__PORT:
				setPort((Integer)newValue);
				return;
			case EsbPackage.SYNAPSE_API__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends ApiResource>)newValue);
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
			case EsbPackage.SYNAPSE_API__API_NAME:
				setApiName(API_NAME_EDEFAULT);
				return;
			case EsbPackage.SYNAPSE_API__CONTEXT:
				setContext(CONTEXT_EDEFAULT);
				return;
			case EsbPackage.SYNAPSE_API__HOSTNAME:
				setHostname(HOSTNAME_EDEFAULT);
				return;
			case EsbPackage.SYNAPSE_API__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case EsbPackage.SYNAPSE_API__RESOURCES:
				getResources().clear();
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
			case EsbPackage.SYNAPSE_API__API_NAME:
				return API_NAME_EDEFAULT == null ? apiName != null : !API_NAME_EDEFAULT.equals(apiName);
			case EsbPackage.SYNAPSE_API__CONTEXT:
				return CONTEXT_EDEFAULT == null ? context != null : !CONTEXT_EDEFAULT.equals(context);
			case EsbPackage.SYNAPSE_API__HOSTNAME:
				return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
			case EsbPackage.SYNAPSE_API__PORT:
				return port != PORT_EDEFAULT;
			case EsbPackage.SYNAPSE_API__RESOURCES:
				return resources != null && !resources.isEmpty();
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
		result.append(" (apiName: ");
		result.append(apiName);
		result.append(", context: ");
		result.append(context);
		result.append(", hostname: ");
		result.append(hostname);
		result.append(", port: ");
		result.append(port);
		result.append(')');
		return result.toString();
	}

	@Override
	public Map<String, ObjectValidator> validate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void doLoad(Element self) throws Exception {
		
		if(self.hasAttribute("name")){
			setApiName(self.getAttribute("name"));
		}
		if(self.hasAttribute("context")){
			setContext(self.getAttribute("context"));
		}
		if(self.hasAttribute("hostname")){
			setHostname(self.getAttribute("hostname"));
		}
		if(self.hasAttribute("port")){
			try {
				int port = Integer.parseInt(self.getAttribute("port"));
				setPort(port);
			} catch (Exception e) {
				// ignore
			}
		}

		// resources
		loadObjects(self, "resource", ApiResource.class, new ObjectHandler<ApiResource>() {
			public void handle(ApiResource object) {
				getResources().add(object);
			}
		});

		super.doLoad(self);
	}

	@Override
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "api");
		
		self.setAttribute("name", getApiName());
		self.setAttribute("context", getContext());
		if(getHostname()!=null){
			self.setAttribute("hostname", getHostname());
		}
		if(getPort()>0){
			self.setAttribute("port", String.valueOf(getPort()));
		}
		// resources
		for (ApiResource resource : getResources()) {
			resource.save(self);
		}
		
		return self;
	}

} //SynapseAPIImpl
