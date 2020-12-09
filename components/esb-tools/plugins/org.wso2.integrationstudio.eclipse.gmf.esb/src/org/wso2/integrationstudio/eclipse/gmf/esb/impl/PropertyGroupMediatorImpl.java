/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
  * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
  *      http://www.apache.org/licenses/LICENSE-2.0
  * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyGroupMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyGroupMediatorInputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyGroupMediatorOutputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyMediator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Group Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.impl.PropertyGroupMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.impl.PropertyGroupMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.impl.PropertyGroupMediatorImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyGroupMediatorImpl extends MediatorImpl implements PropertyGroupMediator {
	/**
     * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInputConnector()
     * @generated
     * @ordered
     */
	protected PropertyGroupMediatorInputConnector inputConnector;

	/**
     * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOutputConnector()
     * @generated
     * @ordered
     */
	protected PropertyGroupMediatorOutputConnector outputConnector;

	/**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
	protected EList<PropertyMediator> properties;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PropertyGroupMediatorImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EsbPackage.Literals.PROPERTY_GROUP_MEDIATOR;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PropertyGroupMediatorInputConnector getInputConnector() {
        return inputConnector;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetInputConnector(PropertyGroupMediatorInputConnector newInputConnector, NotificationChain msgs) {
        PropertyGroupMediatorInputConnector oldInputConnector = inputConnector;
        inputConnector = newInputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_GROUP_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInputConnector(PropertyGroupMediatorInputConnector newInputConnector) {
        if (newInputConnector != inputConnector) {
            NotificationChain msgs = null;
            if (inputConnector != null)
                msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROPERTY_GROUP_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            if (newInputConnector != null)
                msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROPERTY_GROUP_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            msgs = basicSetInputConnector(newInputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_GROUP_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PropertyGroupMediatorOutputConnector getOutputConnector() {
        return outputConnector;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOutputConnector(PropertyGroupMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
        PropertyGroupMediatorOutputConnector oldOutputConnector = outputConnector;
        outputConnector = newOutputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_GROUP_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOutputConnector(PropertyGroupMediatorOutputConnector newOutputConnector) {
        if (newOutputConnector != outputConnector) {
            NotificationChain msgs = null;
            if (outputConnector != null)
                msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROPERTY_GROUP_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            if (newOutputConnector != null)
                msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROPERTY_GROUP_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            msgs = basicSetOutputConnector(newOutputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROPERTY_GROUP_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<PropertyMediator> getProperties() {
        if (properties == null) {
            properties = new EObjectContainmentEList<PropertyMediator>(PropertyMediator.class, this, EsbPackage.PROPERTY_GROUP_MEDIATOR__PROPERTIES);
        }
        return properties;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__INPUT_CONNECTOR:
                return basicSetInputConnector(null, msgs);
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__OUTPUT_CONNECTOR:
                return basicSetOutputConnector(null, msgs);
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__PROPERTIES:
                return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__INPUT_CONNECTOR:
                return getInputConnector();
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__OUTPUT_CONNECTOR:
                return getOutputConnector();
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__PROPERTIES:
                return getProperties();
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
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((PropertyGroupMediatorInputConnector)newValue);
                return;
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((PropertyGroupMediatorOutputConnector)newValue);
                return;
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__PROPERTIES:
                getProperties().clear();
                getProperties().addAll((Collection<? extends PropertyMediator>)newValue);
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
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((PropertyGroupMediatorInputConnector)null);
                return;
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((PropertyGroupMediatorOutputConnector)null);
                return;
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__PROPERTIES:
                getProperties().clear();
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
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__INPUT_CONNECTOR:
                return inputConnector != null;
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__OUTPUT_CONNECTOR:
                return outputConnector != null;
            case EsbPackage.PROPERTY_GROUP_MEDIATOR__PROPERTIES:
                return properties != null && !properties.isEmpty();
        }
        return super.eIsSet(featureID);
    }
} //PropertyGroupMediatorImpl
