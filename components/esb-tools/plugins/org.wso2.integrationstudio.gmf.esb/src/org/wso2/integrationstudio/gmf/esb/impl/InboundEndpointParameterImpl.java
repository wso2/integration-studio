/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.integrationstudio.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.InboundEndpointParameter;
import org.wso2.integrationstudio.gmf.esb.KeyType;
import org.wso2.integrationstudio.gmf.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inbound Endpoint Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.InboundEndpointParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.InboundEndpointParameterImpl#getInboundEndpointParameterType <em>Inbound Endpoint Parameter Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.InboundEndpointParameterImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.InboundEndpointParameterImpl#getInboundEndpointParameterKey <em>Inbound Endpoint Parameter Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InboundEndpointParameterImpl extends EObjectImpl implements InboundEndpointParameter {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = "parameter_name";

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
     * The default value of the '{@link #getInboundEndpointParameterType() <em>Inbound Endpoint Parameter Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInboundEndpointParameterType()
     * @generated
     * @ordered
     */
    protected static final KeyType INBOUND_ENDPOINT_PARAMETER_TYPE_EDEFAULT = KeyType.STATIC;

    /**
     * The cached value of the '{@link #getInboundEndpointParameterType() <em>Inbound Endpoint Parameter Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInboundEndpointParameterType()
     * @generated
     * @ordered
     */
    protected KeyType inboundEndpointParameterType = INBOUND_ENDPOINT_PARAMETER_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = "parameter_value";

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * The cached value of the '{@link #getInboundEndpointParameterKey() <em>Inbound Endpoint Parameter Key</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInboundEndpointParameterKey()
     * @generated
     * @ordered
     */
    protected RegistryKeyProperty inboundEndpointParameterKey;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InboundEndpointParameterImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EsbPackage.Literals.INBOUND_ENDPOINT_PARAMETER;
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
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT_PARAMETER__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KeyType getInboundEndpointParameterType() {
        return inboundEndpointParameterType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInboundEndpointParameterType(KeyType newInboundEndpointParameterType) {
        KeyType oldInboundEndpointParameterType = inboundEndpointParameterType;
        inboundEndpointParameterType = newInboundEndpointParameterType == null ? INBOUND_ENDPOINT_PARAMETER_TYPE_EDEFAULT : newInboundEndpointParameterType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_TYPE, oldInboundEndpointParameterType, inboundEndpointParameterType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT_PARAMETER__VALUE, oldValue, value));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RegistryKeyProperty getInboundEndpointParameterKey() {
        return inboundEndpointParameterKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInboundEndpointParameterKey(RegistryKeyProperty newInboundEndpointParameterKey, NotificationChain msgs) {
        RegistryKeyProperty oldInboundEndpointParameterKey = inboundEndpointParameterKey;
        inboundEndpointParameterKey = newInboundEndpointParameterKey;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_KEY, oldInboundEndpointParameterKey, newInboundEndpointParameterKey);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInboundEndpointParameterKey(RegistryKeyProperty newInboundEndpointParameterKey) {
        if (newInboundEndpointParameterKey != inboundEndpointParameterKey) {
            NotificationChain msgs = null;
            if (inboundEndpointParameterKey != null)
                msgs = ((InternalEObject)inboundEndpointParameterKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_KEY, null, msgs);
            if (newInboundEndpointParameterKey != null)
                msgs = ((InternalEObject)newInboundEndpointParameterKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_KEY, null, msgs);
            msgs = basicSetInboundEndpointParameterKey(newInboundEndpointParameterKey, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_KEY, newInboundEndpointParameterKey, newInboundEndpointParameterKey));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_KEY:
                return basicSetInboundEndpointParameterKey(null, msgs);
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
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__NAME:
                return getName();
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_TYPE:
                return getInboundEndpointParameterType();
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__VALUE:
                return getValue();
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_KEY:
                return getInboundEndpointParameterKey();
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
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__NAME:
                setName((String)newValue);
                return;
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_TYPE:
                setInboundEndpointParameterType((KeyType)newValue);
                return;
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__VALUE:
                setValue((String)newValue);
                return;
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_KEY:
                setInboundEndpointParameterKey((RegistryKeyProperty)newValue);
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
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__NAME:
                setName(NAME_EDEFAULT);
                return;
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_TYPE:
                setInboundEndpointParameterType(INBOUND_ENDPOINT_PARAMETER_TYPE_EDEFAULT);
                return;
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__VALUE:
                setValue(VALUE_EDEFAULT);
                return;
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_KEY:
                setInboundEndpointParameterKey((RegistryKeyProperty)null);
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
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_TYPE:
                return inboundEndpointParameterType != INBOUND_ENDPOINT_PARAMETER_TYPE_EDEFAULT;
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
            case EsbPackage.INBOUND_ENDPOINT_PARAMETER__INBOUND_ENDPOINT_PARAMETER_KEY:
                return inboundEndpointParameterKey != null;
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

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", inboundEndpointParameterType: ");
        result.append(inboundEndpointParameterType);
        result.append(", value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} // InboundEndpointParameterImpl
