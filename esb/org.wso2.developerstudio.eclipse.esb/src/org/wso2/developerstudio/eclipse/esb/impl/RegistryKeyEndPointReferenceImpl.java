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
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyEndPointReference;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registry Key End Point Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.RegistryKeyEndPointReferenceImpl#getEndpointKey <em>Endpoint Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistryKeyEndPointReferenceImpl extends EndPointReferenceImpl implements RegistryKeyEndPointReference {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected RegistryKeyEndPointReferenceImpl() {
		super();
		
		// Endpoint key.
		RegistryKeyProperty endpointKey = getEsbFactory().createRegistryKeyProperty();
		//Set filter properties to filter in only endpoints media type
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)endpointKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_ENDPOINT);

		endpointKey.setPrettyName("Endpoint Key");
		endpointKey.setKeyName("key");
		endpointKey.setKeyValue(DEFAULT_ENDPOINT_REFERENCE_REGISTRY_KEY);
		setEndpointKey(endpointKey);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		getEndpointKey().load(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "endpoint");		
		getEndpointKey().save(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.REGISTRY_KEY_END_POINT_REFERENCE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.REGISTRY_KEY_END_POINT_REFERENCE__ENDPOINT_KEY, oldEndpointKey, newEndpointKey);
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
				msgs = ((InternalEObject)endpointKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.REGISTRY_KEY_END_POINT_REFERENCE__ENDPOINT_KEY, null, msgs);
			if (newEndpointKey != null)
				msgs = ((InternalEObject)newEndpointKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.REGISTRY_KEY_END_POINT_REFERENCE__ENDPOINT_KEY, null, msgs);
			msgs = basicSetEndpointKey(newEndpointKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.REGISTRY_KEY_END_POINT_REFERENCE__ENDPOINT_KEY, newEndpointKey, newEndpointKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.REGISTRY_KEY_END_POINT_REFERENCE__ENDPOINT_KEY:
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
			case EsbPackage.REGISTRY_KEY_END_POINT_REFERENCE__ENDPOINT_KEY:
				return getEndpointKey();
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
			case EsbPackage.REGISTRY_KEY_END_POINT_REFERENCE__ENDPOINT_KEY:
				setEndpointKey((RegistryKeyProperty)newValue);
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
			case EsbPackage.REGISTRY_KEY_END_POINT_REFERENCE__ENDPOINT_KEY:
				setEndpointKey((RegistryKeyProperty)null);
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
			case EsbPackage.REGISTRY_KEY_END_POINT_REFERENCE__ENDPOINT_KEY:
				return endpointKey != null;
		}
		return super.eIsSet(featureID);
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} //RegistryKeyEndPointReferenceImpl
