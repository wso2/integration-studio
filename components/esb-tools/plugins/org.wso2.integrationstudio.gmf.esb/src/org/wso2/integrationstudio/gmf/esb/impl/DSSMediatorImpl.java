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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.integrationstudio.gmf.esb.AbstractDSSOperation;
import org.wso2.integrationstudio.gmf.esb.DSSMediator;
import org.wso2.integrationstudio.gmf.esb.DSSMediatorInputConnector;
import org.wso2.integrationstudio.gmf.esb.DSSMediatorOutputConnector;
import org.wso2.integrationstudio.gmf.esb.DSSSourceType;
import org.wso2.integrationstudio.gmf.esb.DSSTargetType;
import org.wso2.integrationstudio.gmf.esb.DSSoperationProperty;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DSS Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.DSSMediatorImpl#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.DSSMediatorImpl#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.DSSMediatorImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.DSSMediatorImpl#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.DSSMediatorImpl#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.DSSMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.DSSMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DSSMediatorImpl extends MediatorImpl implements DSSMediator {
    /**
     * The default value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceName()
     * @generated
     * @ordered
     */
    protected static final String SERVICE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceName()
     * @generated
     * @ordered
     */
    protected String serviceName = SERVICE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceType()
     * @generated
     * @ordered
     */
    protected static final DSSSourceType SOURCE_TYPE_EDEFAULT = DSSSourceType.INLINE;

    /**
     * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceType()
     * @generated
     * @ordered
     */
    protected DSSSourceType sourceType = SOURCE_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperations()
     * @generated
     * @ordered
     */
    protected EList<AbstractDSSOperation> operations;

    /**
     * The default value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetType()
     * @generated
     * @ordered
     */
    protected static final DSSTargetType TARGET_TYPE_EDEFAULT = DSSTargetType.BODY;

    /**
     * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetType()
     * @generated
     * @ordered
     */
    protected DSSTargetType targetType = TARGET_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getTargetProperty() <em>Target Property</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetProperty()
     * @generated
     * @ordered
     */
    protected static final String TARGET_PROPERTY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTargetProperty() <em>Target Property</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetProperty()
     * @generated
     * @ordered
     */
    protected String targetProperty = TARGET_PROPERTY_EDEFAULT;

    /**
     * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputConnector()
     * @generated
     * @ordered
     */
    protected DSSMediatorInputConnector inputConnector;

    /**
     * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputConnector()
     * @generated
     * @ordered
     */
    protected DSSMediatorOutputConnector outputConnector;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DSSMediatorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EsbPackage.Literals.DSS_MEDIATOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setServiceName(String newServiceName) {
        String oldServiceName = serviceName;
        serviceName = newServiceName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DSS_MEDIATOR__SERVICE_NAME, oldServiceName, serviceName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DSSSourceType getSourceType() {
        return sourceType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceType(DSSSourceType newSourceType) {
        DSSSourceType oldSourceType = sourceType;
        sourceType = newSourceType == null ? SOURCE_TYPE_EDEFAULT : newSourceType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DSS_MEDIATOR__SOURCE_TYPE, oldSourceType, sourceType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<AbstractDSSOperation> getOperations() {
        if (operations == null) {
            operations = new EObjectContainmentEList<AbstractDSSOperation>(AbstractDSSOperation.class, this, EsbPackage.DSS_MEDIATOR__OPERATIONS);
        }
        return operations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DSSTargetType getTargetType() {
        return targetType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetType(DSSTargetType newTargetType) {
        DSSTargetType oldTargetType = targetType;
        targetType = newTargetType == null ? TARGET_TYPE_EDEFAULT : newTargetType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DSS_MEDIATOR__TARGET_TYPE, oldTargetType, targetType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTargetProperty() {
        return targetProperty;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetProperty(String newTargetProperty) {
        String oldTargetProperty = targetProperty;
        targetProperty = newTargetProperty;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DSS_MEDIATOR__TARGET_PROPERTY, oldTargetProperty, targetProperty));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DSSMediatorInputConnector getInputConnector() {
        return inputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInputConnector(DSSMediatorInputConnector newInputConnector, NotificationChain msgs) {
        DSSMediatorInputConnector oldInputConnector = inputConnector;
        inputConnector = newInputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.DSS_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInputConnector(DSSMediatorInputConnector newInputConnector) {
        if (newInputConnector != inputConnector) {
            NotificationChain msgs = null;
            if (inputConnector != null)
                msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DSS_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            if (newInputConnector != null)
                msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DSS_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            msgs = basicSetInputConnector(newInputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DSS_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DSSMediatorOutputConnector getOutputConnector() {
        return outputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOutputConnector(DSSMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
        DSSMediatorOutputConnector oldOutputConnector = outputConnector;
        outputConnector = newOutputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.DSS_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutputConnector(DSSMediatorOutputConnector newOutputConnector) {
        if (newOutputConnector != outputConnector) {
            NotificationChain msgs = null;
            if (outputConnector != null)
                msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DSS_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            if (newOutputConnector != null)
                msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DSS_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            msgs = basicSetOutputConnector(newOutputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DSS_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EsbPackage.DSS_MEDIATOR__OPERATIONS:
                return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
            case EsbPackage.DSS_MEDIATOR__INPUT_CONNECTOR:
                return basicSetInputConnector(null, msgs);
            case EsbPackage.DSS_MEDIATOR__OUTPUT_CONNECTOR:
                return basicSetOutputConnector(null, msgs);
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
            case EsbPackage.DSS_MEDIATOR__SERVICE_NAME:
                return getServiceName();
            case EsbPackage.DSS_MEDIATOR__SOURCE_TYPE:
                return getSourceType();
            case EsbPackage.DSS_MEDIATOR__OPERATIONS:
                return getOperations();
            case EsbPackage.DSS_MEDIATOR__TARGET_TYPE:
                return getTargetType();
            case EsbPackage.DSS_MEDIATOR__TARGET_PROPERTY:
                return getTargetProperty();
            case EsbPackage.DSS_MEDIATOR__INPUT_CONNECTOR:
                return getInputConnector();
            case EsbPackage.DSS_MEDIATOR__OUTPUT_CONNECTOR:
                return getOutputConnector();
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
            case EsbPackage.DSS_MEDIATOR__SERVICE_NAME:
                setServiceName((String)newValue);
                return;
            case EsbPackage.DSS_MEDIATOR__SOURCE_TYPE:
                setSourceType((DSSSourceType)newValue);
                return;
            case EsbPackage.DSS_MEDIATOR__OPERATIONS:
                getOperations().clear();
                getOperations().addAll((Collection<? extends AbstractDSSOperation>)newValue);
                return;
            case EsbPackage.DSS_MEDIATOR__TARGET_TYPE:
                setTargetType((DSSTargetType)newValue);
                return;
            case EsbPackage.DSS_MEDIATOR__TARGET_PROPERTY:
                setTargetProperty((String)newValue);
                return;
            case EsbPackage.DSS_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((DSSMediatorInputConnector)newValue);
                return;
            case EsbPackage.DSS_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((DSSMediatorOutputConnector)newValue);
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
            case EsbPackage.DSS_MEDIATOR__SERVICE_NAME:
                setServiceName(SERVICE_NAME_EDEFAULT);
                return;
            case EsbPackage.DSS_MEDIATOR__SOURCE_TYPE:
                setSourceType(SOURCE_TYPE_EDEFAULT);
                return;
            case EsbPackage.DSS_MEDIATOR__OPERATIONS:
                getOperations().clear();
                return;
            case EsbPackage.DSS_MEDIATOR__TARGET_TYPE:
                setTargetType(TARGET_TYPE_EDEFAULT);
                return;
            case EsbPackage.DSS_MEDIATOR__TARGET_PROPERTY:
                setTargetProperty(TARGET_PROPERTY_EDEFAULT);
                return;
            case EsbPackage.DSS_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((DSSMediatorInputConnector)null);
                return;
            case EsbPackage.DSS_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((DSSMediatorOutputConnector)null);
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
            case EsbPackage.DSS_MEDIATOR__SERVICE_NAME:
                return SERVICE_NAME_EDEFAULT == null ? serviceName != null : !SERVICE_NAME_EDEFAULT.equals(serviceName);
            case EsbPackage.DSS_MEDIATOR__SOURCE_TYPE:
                return sourceType != SOURCE_TYPE_EDEFAULT;
            case EsbPackage.DSS_MEDIATOR__OPERATIONS:
                return operations != null && !operations.isEmpty();
            case EsbPackage.DSS_MEDIATOR__TARGET_TYPE:
                return targetType != TARGET_TYPE_EDEFAULT;
            case EsbPackage.DSS_MEDIATOR__TARGET_PROPERTY:
                return TARGET_PROPERTY_EDEFAULT == null ? targetProperty != null : !TARGET_PROPERTY_EDEFAULT.equals(targetProperty);
            case EsbPackage.DSS_MEDIATOR__INPUT_CONNECTOR:
                return inputConnector != null;
            case EsbPackage.DSS_MEDIATOR__OUTPUT_CONNECTOR:
                return outputConnector != null;
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
        result.append(" (serviceName: ");
        result.append(serviceName);
        result.append(", sourceType: ");
        result.append(sourceType);
        result.append(", targetType: ");
        result.append(targetType);
        result.append(", targetProperty: ");
        result.append(targetProperty);
        result.append(')');
        return result.toString();
    }

} //DSSMediatorImpl
