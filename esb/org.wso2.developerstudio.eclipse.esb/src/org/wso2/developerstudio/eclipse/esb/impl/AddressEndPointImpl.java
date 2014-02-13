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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.AddressEndPoint;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Address End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AddressEndPointImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddressEndPointImpl extends AbstractDefaultEndPointImpl implements AddressEndPoint {
    /**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
    protected static final String URI_EDEFAULT = "http://default/address/endpoint/uri";

    /**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
    protected String uri = URI_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 */
    protected AddressEndPointImpl() {
		super();
		
		// Reliable messaging policy key.
		RegistryKeyProperty rmPolicyKey = getEsbFactory().createRegistryKeyProperty();
		rmPolicyKey.setPrettyName("Select RM Policy");
		rmPolicyKey.setKeyName("policy");
		rmPolicyKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setReliableMessagingPolicy(rmPolicyKey);

		// Security policy key.
		RegistryKeyProperty securityPolicyKey = getEsbFactory().createRegistryKeyProperty();
		securityPolicyKey.setPrettyName("Select Security Policy");
		securityPolicyKey.setKeyName("policy");
		securityPolicyKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setSecurityPolicy(securityPolicyKey);
	}        

	/**
     * {@inheritDoc}
     */
    public void doLoad(Element self) throws Exception {
	    super.doLoad(self);
	    
	    // Get the <address/> element.
	    Element addressElem = getChildElement(self, "address");

	    // URI.
    	setUri(addressElem.getAttribute("uri"));
	    
	    // Delegate.
	    loadContent(addressElem);
    }

	/**
     * {@inheritDoc}
     */
    public Element doSave(Element parent) throws Exception {
		Element self = super.doSave(parent);
		
		// Create the <address/> element.
		Element addressElem = createChildElement(self, "address");
		
		// URI.
		addressElem.setAttribute("uri", getUri());
		
		// Delegate.
		storeContent(addressElem);
		
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
		return EsbPackage.Literals.ADDRESS_END_POINT;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getUri() {
		return uri;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ADDRESS_END_POINT__URI, oldUri, uri));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.ADDRESS_END_POINT__URI:
				return getUri();
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
			case EsbPackage.ADDRESS_END_POINT__URI:
				setUri((String)newValue);
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
			case EsbPackage.ADDRESS_END_POINT__URI:
				setUri(URI_EDEFAULT);
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
			case EsbPackage.ADDRESS_END_POINT__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		if (null == getUri() || getUri().trim().isEmpty()) {
			validateMap.put("URI","URI is empty");
		}
		
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Address EndPoint", objectValidator);
	    return mediatorValidateMap;
    }

} //AddressEndPointImpl
