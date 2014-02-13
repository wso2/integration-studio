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

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.XPathEndPointReference;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XPath End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.XPathEndPointReferenceImpl#getEndpointXpath <em>Endpoint Xpath</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XPathEndPointReferenceImpl extends EndPointReferenceImpl implements XPathEndPointReference {
	/**
	 * The cached value of the '{@link #getEndpointXpath() <em>Endpoint Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty endpointXpath;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected XPathEndPointReferenceImpl() {
		super();
		
		// Endpoint xpath.
		NamespacedProperty endpointXpath = getEsbFactory().createNamespacedProperty();
		endpointXpath.setPrettyName("Endpoint XPath");
		endpointXpath.setPropertyName("key-expression");
		endpointXpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setEndpointXpath(endpointXpath);
	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		getEndpointXpath().load(self);		
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "endpoint");		
		getEndpointXpath().save(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.XPATH_END_POINT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getEndpointXpath() {
		return endpointXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndpointXpath(NamespacedProperty newEndpointXpath, NotificationChain msgs) {
		NamespacedProperty oldEndpointXpath = endpointXpath;
		endpointXpath = newEndpointXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XPATH_END_POINT_REFERENCE__ENDPOINT_XPATH, oldEndpointXpath, newEndpointXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointXpath(NamespacedProperty newEndpointXpath) {
		if (newEndpointXpath != endpointXpath) {
			NotificationChain msgs = null;
			if (endpointXpath != null)
				msgs = ((InternalEObject)endpointXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XPATH_END_POINT_REFERENCE__ENDPOINT_XPATH, null, msgs);
			if (newEndpointXpath != null)
				msgs = ((InternalEObject)newEndpointXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XPATH_END_POINT_REFERENCE__ENDPOINT_XPATH, null, msgs);
			msgs = basicSetEndpointXpath(newEndpointXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XPATH_END_POINT_REFERENCE__ENDPOINT_XPATH, newEndpointXpath, newEndpointXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.XPATH_END_POINT_REFERENCE__ENDPOINT_XPATH:
				return basicSetEndpointXpath(null, msgs);
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
			case EsbPackage.XPATH_END_POINT_REFERENCE__ENDPOINT_XPATH:
				return getEndpointXpath();
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
			case EsbPackage.XPATH_END_POINT_REFERENCE__ENDPOINT_XPATH:
				setEndpointXpath((NamespacedProperty)newValue);
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
			case EsbPackage.XPATH_END_POINT_REFERENCE__ENDPOINT_XPATH:
				setEndpointXpath((NamespacedProperty)null);
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
			case EsbPackage.XPATH_END_POINT_REFERENCE__ENDPOINT_XPATH:
				return endpointXpath != null;
		}
		return super.eIsSet(featureID);
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} //XPathEndPointImpl
