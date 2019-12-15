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
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.JsonTransformMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.JsonTransformMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.JsonTransformMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.JsonTransformMediatorProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Json Transform Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.JsonTransformMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.JsonTransformMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.JsonTransformMediatorImpl#getJsonTransformProperties <em>Json Transform Properties</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.JsonTransformMediatorImpl#getSchema <em>Schema</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JsonTransformMediatorImpl extends MediatorImpl implements JsonTransformMediator {
    /**
     * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputConnector()
     * @generated
     * @ordered
     */
    protected JsonTransformMediatorInputConnector inputConnector;

    /**
     * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputConnector()
     * @generated
     * @ordered
     */
    protected JsonTransformMediatorOutputConnector outputConnector;

    /**
     * The cached value of the '{@link #getJsonTransformProperties() <em>Json Transform Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJsonTransformProperties()
     * @generated
     * @ordered
     */
    protected EList<JsonTransformMediatorProperty> jsonTransformProperties;

    /**
     * The cached value of the '{@link #getSchema() <em>Schema</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSchema()
     * @generated
     * @ordered
     */
    protected RegistryKeyProperty schema;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JsonTransformMediatorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EsbPackage.Literals.JSON_TRANSFORM_MEDIATOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JsonTransformMediatorInputConnector getInputConnector() {
        return inputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInputConnector(JsonTransformMediatorInputConnector newInputConnector, NotificationChain msgs) {
        JsonTransformMediatorInputConnector oldInputConnector = inputConnector;
        inputConnector = newInputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.JSON_TRANSFORM_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInputConnector(JsonTransformMediatorInputConnector newInputConnector) {
        if (newInputConnector != inputConnector) {
            NotificationChain msgs = null;
            if (inputConnector != null)
                msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.JSON_TRANSFORM_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            if (newInputConnector != null)
                msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.JSON_TRANSFORM_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            msgs = basicSetInputConnector(newInputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.JSON_TRANSFORM_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JsonTransformMediatorOutputConnector getOutputConnector() {
        return outputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOutputConnector(JsonTransformMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
        JsonTransformMediatorOutputConnector oldOutputConnector = outputConnector;
        outputConnector = newOutputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.JSON_TRANSFORM_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutputConnector(JsonTransformMediatorOutputConnector newOutputConnector) {
        if (newOutputConnector != outputConnector) {
            NotificationChain msgs = null;
            if (outputConnector != null)
                msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.JSON_TRANSFORM_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            if (newOutputConnector != null)
                msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.JSON_TRANSFORM_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            msgs = basicSetOutputConnector(newOutputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.JSON_TRANSFORM_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<JsonTransformMediatorProperty> getJsonTransformProperties() {
        if (jsonTransformProperties == null) {
            jsonTransformProperties = new EObjectContainmentEList<JsonTransformMediatorProperty>(JsonTransformMediatorProperty.class, this, EsbPackage.JSON_TRANSFORM_MEDIATOR__JSON_TRANSFORM_PROPERTIES);
        }
        return jsonTransformProperties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RegistryKeyProperty getSchema() {
        return schema;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSchema(RegistryKeyProperty newSchema, NotificationChain msgs) {
        RegistryKeyProperty oldSchema = schema;
        schema = newSchema;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.JSON_TRANSFORM_MEDIATOR__SCHEMA, oldSchema, newSchema);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSchema(RegistryKeyProperty newSchema) {
        if (newSchema != schema) {
            NotificationChain msgs = null;
            if (schema != null)
                msgs = ((InternalEObject)schema).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.JSON_TRANSFORM_MEDIATOR__SCHEMA, null, msgs);
            if (newSchema != null)
                msgs = ((InternalEObject)newSchema).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.JSON_TRANSFORM_MEDIATOR__SCHEMA, null, msgs);
            msgs = basicSetSchema(newSchema, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.JSON_TRANSFORM_MEDIATOR__SCHEMA, newSchema, newSchema));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__INPUT_CONNECTOR:
                return basicSetInputConnector(null, msgs);
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__OUTPUT_CONNECTOR:
                return basicSetOutputConnector(null, msgs);
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__JSON_TRANSFORM_PROPERTIES:
                return ((InternalEList<?>)getJsonTransformProperties()).basicRemove(otherEnd, msgs);
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__SCHEMA:
                return basicSetSchema(null, msgs);
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
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__INPUT_CONNECTOR:
                return getInputConnector();
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__OUTPUT_CONNECTOR:
                return getOutputConnector();
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__JSON_TRANSFORM_PROPERTIES:
                return getJsonTransformProperties();
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__SCHEMA:
                return getSchema();
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
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((JsonTransformMediatorInputConnector)newValue);
                return;
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((JsonTransformMediatorOutputConnector)newValue);
                return;
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__JSON_TRANSFORM_PROPERTIES:
                getJsonTransformProperties().clear();
                getJsonTransformProperties().addAll((Collection<? extends JsonTransformMediatorProperty>)newValue);
                return;
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__SCHEMA:
                setSchema((RegistryKeyProperty)newValue);
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
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((JsonTransformMediatorInputConnector)null);
                return;
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((JsonTransformMediatorOutputConnector)null);
                return;
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__JSON_TRANSFORM_PROPERTIES:
                getJsonTransformProperties().clear();
                return;
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__SCHEMA:
                setSchema((RegistryKeyProperty)null);
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
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__INPUT_CONNECTOR:
                return inputConnector != null;
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__OUTPUT_CONNECTOR:
                return outputConnector != null;
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__JSON_TRANSFORM_PROPERTIES:
                return jsonTransformProperties != null && !jsonTransformProperties.isEmpty();
            case EsbPackage.JSON_TRANSFORM_MEDIATOR__SCHEMA:
                return schema != null;
        }
        return super.eIsSet(featureID);
    }

} //JsonTransformMediatorImpl
