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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EndPoint;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxyEndpointType;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proxy Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyEndpointConfigurationImpl#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyEndpointConfigurationImpl#getInlineEndpoint <em>Inline Endpoint</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyEndpointConfigurationImpl#getEndpointKey <em>Endpoint Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyEndpointConfigurationImpl#getEndpointName <em>Endpoint Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProxyEndpointConfigurationImpl extends ModelObjectImpl implements ProxyEndpointConfiguration {
	/**
	 * The default value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
//	protected static final ProxyEndpointType ENDPOINT_TYPE_EDEFAULT = ProxyEndpointType.ANONYMOUS;
	protected static final ProxyEndpointType ENDPOINT_TYPE_EDEFAULT = ProxyEndpointType.ANONYMOUS;
	/**
	 * The cached value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected ProxyEndpointType endpointType = ENDPOINT_TYPE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getInlineEndpoint() <em>Inline Endpoint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInlineEndpoint()
	 * @generated
	 * @ordered
	 */
	protected EndPoint inlineEndpoint;
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
	protected static final String ENDPOINT_NAME_EDEFAULT = "endpoint_name";
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	protected ProxyEndpointConfigurationImpl() {
		super();
		
		// Endpoint Key.
		RegistryKeyProperty endpointKey = getEsbFactory().createRegistryKeyProperty();
		//Setting up filters to filter in only the relevant items from the list 
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)endpointKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_ENDPOINT);
		endpointKey.setPrettyName("Endpoint");
		endpointKey.setKeyName("endpoint");
		endpointKey.setKeyValue(DEFAULT_ENDPOINT_REFERENCE_REGISTRY_KEY);
		setEndpointKey(endpointKey);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasSourceRepresentation() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		if (self.hasAttribute("endpoint")) {
			String endpointReference = self.getAttribute("endpoint");
			
			// TODO: This is not optimal, we could mis-interpret a registry
			// reference as a named reference and vice versa.
			if (isRegistryKey(endpointReference)) {
				setEndpointType(ProxyEndpointType.REGISTRY_REFERENCE);
				getEndpointKey().load(self);
			} else {
				setEndpointType(ProxyEndpointType.NAMED_REFERENCE);
				setEndpointName(endpointReference);
			}
		} else {
			loadObject(self, "endpoint", EndPoint.class, false, new ObjectHandler<EndPoint>() {
				public void handle(EndPoint object) {
					object.setAnonymous(true);
					setInlineEndpoint(object);
					setEndpointType(ProxyEndpointType.ANONYMOUS);
				}				
			});
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		switch (getEndpointType()) {
			case ANONYMOUS: {
				if (null != getInlineEndpoint()) {
					// Force the endpoint to be anonymous.
					getInlineEndpoint().setAnonymous(true);
					
					return getInlineEndpoint().save(parent);
				}
				break;
			}
			
			case REGISTRY_REFERENCE: {
				getEndpointKey().save(parent);
				break;
			}
			
			case NAMED_REFERENCE: {
				parent.setAttribute("endpoint", getEndpointName());
				break;
			}
			
			default: {
				// Do nothing.
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.PROXY_ENDPOINT_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyEndpointType getEndpointType() {
		return endpointType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointType(ProxyEndpointType newEndpointType) {
		ProxyEndpointType oldEndpointType = endpointType;
		endpointType = newEndpointType == null ? ENDPOINT_TYPE_EDEFAULT : newEndpointType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_TYPE, oldEndpointType, endpointType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPoint getInlineEndpoint() {
		return inlineEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInlineEndpoint(EndPoint newInlineEndpoint, NotificationChain msgs) {
		EndPoint oldInlineEndpoint = inlineEndpoint;
		inlineEndpoint = newInlineEndpoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT, oldInlineEndpoint, newInlineEndpoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInlineEndpoint(EndPoint newInlineEndpoint) {
		if (newInlineEndpoint != inlineEndpoint) {
			NotificationChain msgs = null;
			if (inlineEndpoint != null)
				msgs = ((InternalEObject)inlineEndpoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT, null, msgs);
			if (newInlineEndpoint != null)
				msgs = ((InternalEObject)newInlineEndpoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT, null, msgs);
			msgs = basicSetInlineEndpoint(newInlineEndpoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT, newInlineEndpoint, newInlineEndpoint));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY, oldEndpointKey, newEndpointKey);
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
				msgs = ((InternalEObject)endpointKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY, null, msgs);
			if (newEndpointKey != null)
				msgs = ((InternalEObject)newEndpointKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY, null, msgs);
			msgs = basicSetEndpointKey(newEndpointKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY, newEndpointKey, newEndpointKey));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_NAME, oldEndpointName, endpointName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT:
				return basicSetInlineEndpoint(null, msgs);
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY:
				return basicSetEndpointKey(null, msgs);
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
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_TYPE:
				return getEndpointType();
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT:
				return getInlineEndpoint();
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY:
				return getEndpointKey();
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_NAME:
				return getEndpointName();
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
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_TYPE:
				setEndpointType((ProxyEndpointType)newValue);
				return;
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT:
				setInlineEndpoint((EndPoint)newValue);
				return;
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY:
				setEndpointKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_NAME:
				setEndpointName((String)newValue);
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
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_TYPE:
				setEndpointType(ENDPOINT_TYPE_EDEFAULT);
				return;
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT:
				setInlineEndpoint((EndPoint)null);
				return;
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY:
				setEndpointKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_NAME:
				setEndpointName(ENDPOINT_NAME_EDEFAULT);
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
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_TYPE:
				return endpointType != ENDPOINT_TYPE_EDEFAULT;
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT:
				return inlineEndpoint != null;
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY:
				return endpointKey != null;
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_NAME:
				return ENDPOINT_NAME_EDEFAULT == null ? endpointName != null : !ENDPOINT_NAME_EDEFAULT.equals(endpointName);
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
		result.append(" (endpointType: ");
		result.append(endpointType);
		result.append(", endpointName: ");
		result.append(endpointName);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} //ProxyEndpointImpl
