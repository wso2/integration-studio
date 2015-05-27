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
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPointWestOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndpointType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recipient List End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RecipientListEndPointImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RecipientListEndPointImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RecipientListEndPointImpl#getWestOutputConnector <em>West Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RecipientListEndPointImpl#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RecipientListEndPointImpl#getEndpointsValue <em>Endpoints Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RecipientListEndPointImpl#getEndpointsExpression <em>Endpoints Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RecipientListEndPointImpl#getMaxCache <em>Max Cache</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RecipientListEndPointImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecipientListEndPointImpl extends ParentEndPointImpl implements RecipientListEndPoint {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected RecipientListEndPointInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EList<RecipientListEndPointOutputConnector> outputConnector;

	/**
	 * The cached value of the '{@link #getWestOutputConnector() <em>West Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWestOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected RecipientListEndPointWestOutputConnector westOutputConnector;

	/**
	 * The default value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected static final RecipientListEndpointType ENDPOINT_TYPE_EDEFAULT = RecipientListEndpointType.INLINE;

	/**
	 * The cached value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected RecipientListEndpointType endpointType = ENDPOINT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndpointsValue() <em>Endpoints Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointsValue()
	 * @generated
	 * @ordered
	 */
	protected static final String ENDPOINTS_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndpointsValue() <em>Endpoints Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointsValue()
	 * @generated
	 * @ordered
	 */
	protected String endpointsValue = ENDPOINTS_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEndpointsExpression() <em>Endpoints Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointsExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty endpointsExpression;

	/**
	 * The default value of the '{@link #getMaxCache() <em>Max Cache</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCache()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_CACHE_EDEFAULT = 20;

	/**
	 * The cached value of the '{@link #getMaxCache() <em>Max Cache</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCache()
	 * @generated
	 * @ordered
	 */
	protected int maxCache = MAX_CACHE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMediatorFlow() <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediatorFlow()
	 * @generated
	 * @ordered
	 */
	protected MediatorFlow mediatorFlow;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RecipientListEndPointImpl() {
		super();
		NamespacedProperty endpointsExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		endpointsExpression.setPrettyName("Endpoints Expression");
		endpointsExpression.setPropertyName("expression");
		endpointsExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);		
		setEndpointsExpression(endpointsExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.RECIPIENT_LIST_END_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecipientListEndPointInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(RecipientListEndPointInputConnector newInputConnector, NotificationChain msgs) {
		RecipientListEndPointInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(RecipientListEndPointInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RecipientListEndPointOutputConnector> getOutputConnector() {
		if (outputConnector == null) {
			outputConnector = new EObjectContainmentEList<RecipientListEndPointOutputConnector>(RecipientListEndPointOutputConnector.class, this, EsbPackage.RECIPIENT_LIST_END_POINT__OUTPUT_CONNECTOR);
		}
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecipientListEndPointWestOutputConnector getWestOutputConnector() {
		return westOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWestOutputConnector(RecipientListEndPointWestOutputConnector newWestOutputConnector, NotificationChain msgs) {
		RecipientListEndPointWestOutputConnector oldWestOutputConnector = westOutputConnector;
		westOutputConnector = newWestOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR, oldWestOutputConnector, newWestOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWestOutputConnector(RecipientListEndPointWestOutputConnector newWestOutputConnector) {
		if (newWestOutputConnector != westOutputConnector) {
			NotificationChain msgs = null;
			if (westOutputConnector != null)
				msgs = ((InternalEObject)westOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR, null, msgs);
			if (newWestOutputConnector != null)
				msgs = ((InternalEObject)newWestOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetWestOutputConnector(newWestOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR, newWestOutputConnector, newWestOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecipientListEndpointType getEndpointType() {
		return endpointType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointType(RecipientListEndpointType newEndpointType) {
		RecipientListEndpointType oldEndpointType = endpointType;
		endpointType = newEndpointType == null ? ENDPOINT_TYPE_EDEFAULT : newEndpointType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE, oldEndpointType, endpointType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEndpointsValue() {
		return endpointsValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointsValue(String newEndpointsValue) {
		String oldEndpointsValue = endpointsValue;
		endpointsValue = newEndpointsValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE, oldEndpointsValue, endpointsValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getEndpointsExpression() {
		return endpointsExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndpointsExpression(NamespacedProperty newEndpointsExpression, NotificationChain msgs) {
		NamespacedProperty oldEndpointsExpression = endpointsExpression;
		endpointsExpression = newEndpointsExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION, oldEndpointsExpression, newEndpointsExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointsExpression(NamespacedProperty newEndpointsExpression) {
		if (newEndpointsExpression != endpointsExpression) {
			NotificationChain msgs = null;
			if (endpointsExpression != null)
				msgs = ((InternalEObject)endpointsExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION, null, msgs);
			if (newEndpointsExpression != null)
				msgs = ((InternalEObject)newEndpointsExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION, null, msgs);
			msgs = basicSetEndpointsExpression(newEndpointsExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION, newEndpointsExpression, newEndpointsExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxCache() {
		return maxCache;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxCache(int newMaxCache) {
		int oldMaxCache = maxCache;
		maxCache = newMaxCache;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RECIPIENT_LIST_END_POINT__MAX_CACHE, oldMaxCache, maxCache));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorFlow getMediatorFlow() {
		return mediatorFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMediatorFlow(MediatorFlow newMediatorFlow, NotificationChain msgs) {
		MediatorFlow oldMediatorFlow = mediatorFlow;
		mediatorFlow = newMediatorFlow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediatorFlow(MediatorFlow newMediatorFlow) {
		if (newMediatorFlow != mediatorFlow) {
			NotificationChain msgs = null;
			if (mediatorFlow != null)
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.RECIPIENT_LIST_END_POINT__OUTPUT_CONNECTOR:
				return ((InternalEList<?>)getOutputConnector()).basicRemove(otherEnd, msgs);
			case EsbPackage.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR:
				return basicSetWestOutputConnector(null, msgs);
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION:
				return basicSetEndpointsExpression(null, msgs);
			case EsbPackage.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW:
				return basicSetMediatorFlow(null, msgs);
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
			case EsbPackage.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.RECIPIENT_LIST_END_POINT__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR:
				return getWestOutputConnector();
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE:
				return getEndpointType();
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE:
				return getEndpointsValue();
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION:
				return getEndpointsExpression();
			case EsbPackage.RECIPIENT_LIST_END_POINT__MAX_CACHE:
				return getMaxCache();
			case EsbPackage.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW:
				return getMediatorFlow();
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
			case EsbPackage.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR:
				setInputConnector((RecipientListEndPointInputConnector)newValue);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__OUTPUT_CONNECTOR:
				getOutputConnector().clear();
				getOutputConnector().addAll((Collection<? extends RecipientListEndPointOutputConnector>)newValue);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR:
				setWestOutputConnector((RecipientListEndPointWestOutputConnector)newValue);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE:
				setEndpointType((RecipientListEndpointType)newValue);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE:
				setEndpointsValue((String)newValue);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION:
				setEndpointsExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__MAX_CACHE:
				setMaxCache((Integer)newValue);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)newValue);
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
			case EsbPackage.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR:
				setInputConnector((RecipientListEndPointInputConnector)null);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__OUTPUT_CONNECTOR:
				getOutputConnector().clear();
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR:
				setWestOutputConnector((RecipientListEndPointWestOutputConnector)null);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE:
				setEndpointType(ENDPOINT_TYPE_EDEFAULT);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE:
				setEndpointsValue(ENDPOINTS_VALUE_EDEFAULT);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION:
				setEndpointsExpression((NamespacedProperty)null);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__MAX_CACHE:
				setMaxCache(MAX_CACHE_EDEFAULT);
				return;
			case EsbPackage.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)null);
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
			case EsbPackage.RECIPIENT_LIST_END_POINT__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.RECIPIENT_LIST_END_POINT__OUTPUT_CONNECTOR:
				return outputConnector != null && !outputConnector.isEmpty();
			case EsbPackage.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR:
				return westOutputConnector != null;
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE:
				return endpointType != ENDPOINT_TYPE_EDEFAULT;
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE:
				return ENDPOINTS_VALUE_EDEFAULT == null ? endpointsValue != null : !ENDPOINTS_VALUE_EDEFAULT.equals(endpointsValue);
			case EsbPackage.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION:
				return endpointsExpression != null;
			case EsbPackage.RECIPIENT_LIST_END_POINT__MAX_CACHE:
				return maxCache != MAX_CACHE_EDEFAULT;
			case EsbPackage.RECIPIENT_LIST_END_POINT__MEDIATOR_FLOW:
				return mediatorFlow != null;
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
		result.append(", endpointsValue: ");
		result.append(endpointsValue);
		result.append(", maxCache: ");
		result.append(maxCache);
		result.append(')');
		return result.toString();
	}

} //RecipientListEndPointImpl
