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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallMediatorImpl#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallMediatorImpl#getEndpointOutputConnector <em>Endpoint Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallMediatorImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallMediatorImpl#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallMediatorImpl#isEnableBlockingCalls <em>Enable Blocking Calls</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallMediatorImpl#getEndpointRegistrykey <em>Endpoint Registrykey</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallMediatorImpl#getEndpointXpath <em>Endpoint Xpath</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallMediatorImpl extends MediatorImpl implements CallMediator {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected CallMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected CallMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getEndpoint() <em>Endpoint</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpoint()
	 * @generated
	 * @ordered
	 */
	protected EList<EndPoint> endpoint;

	/**
	 * The cached value of the '{@link #getEndpointOutputConnector() <em>Endpoint Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected CallMediatorEndpointOutputConnector endpointOutputConnector;

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
	 * The default value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected static final CallMediatorEndpointType ENDPOINT_TYPE_EDEFAULT = CallMediatorEndpointType.INLINE;

	/**
	 * The cached value of the '{@link #getEndpointType() <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointType()
	 * @generated
	 * @ordered
	 */
	protected CallMediatorEndpointType endpointType = ENDPOINT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnableBlockingCalls() <em>Enable Blocking Calls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableBlockingCalls()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLE_BLOCKING_CALLS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnableBlockingCalls() <em>Enable Blocking Calls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableBlockingCalls()
	 * @generated
	 * @ordered
	 */
	protected boolean enableBlockingCalls = ENABLE_BLOCKING_CALLS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEndpointRegistrykey() <em>Endpoint Registrykey</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointRegistrykey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty endpointRegistrykey;

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
	 * @generated NOT
	 */
    protected CallMediatorImpl() {
        super();
        NamespacedProperty xpath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        xpath.setPrettyName("Endpoint XPath");
        xpath.setPropertyName("expression");
        xpath.setPropertyValue("/default/expression");
        setEndpointXpath(xpath);
        
        RegistryKeyProperty sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        sequenceKey.setKeyName("Endpoint Key");
        sequenceKey.setPrettyName("Endpoint Key");
        sequenceKey.setKeyValue("/default/key");
        setEndpointRegistrykey(sequenceKey);
}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CALL_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(CallMediatorInputConnector newInputConnector, NotificationChain msgs) {
		CallMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(CallMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(CallMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		CallMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(CallMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndPoint> getEndpoint() {
		if (endpoint == null) {
			endpoint = new EObjectResolvingEList<EndPoint>(EndPoint.class, this, EsbPackage.CALL_MEDIATOR__ENDPOINT);
		}
		return endpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallMediatorEndpointOutputConnector getEndpointOutputConnector() {
		return endpointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndpointOutputConnector(CallMediatorEndpointOutputConnector newEndpointOutputConnector, NotificationChain msgs) {
		CallMediatorEndpointOutputConnector oldEndpointOutputConnector = endpointOutputConnector;
		endpointOutputConnector = newEndpointOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR, oldEndpointOutputConnector, newEndpointOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointOutputConnector(CallMediatorEndpointOutputConnector newEndpointOutputConnector) {
		if (newEndpointOutputConnector != endpointOutputConnector) {
			NotificationChain msgs = null;
			if (endpointOutputConnector != null)
				msgs = ((InternalEObject)endpointOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR, null, msgs);
			if (newEndpointOutputConnector != null)
				msgs = ((InternalEObject)newEndpointOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetEndpointOutputConnector(newEndpointOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR, newEndpointOutputConnector, newEndpointOutputConnector));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
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
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallMediatorEndpointType getEndpointType() {
		return endpointType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointType(CallMediatorEndpointType newEndpointType) {
		CallMediatorEndpointType oldEndpointType = endpointType;
		endpointType = newEndpointType == null ? ENDPOINT_TYPE_EDEFAULT : newEndpointType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__ENDPOINT_TYPE, oldEndpointType, endpointType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnableBlockingCalls() {
		return enableBlockingCalls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableBlockingCalls(boolean newEnableBlockingCalls) {
		boolean oldEnableBlockingCalls = enableBlockingCalls;
		enableBlockingCalls = newEnableBlockingCalls;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__ENABLE_BLOCKING_CALLS, oldEnableBlockingCalls, enableBlockingCalls));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getEndpointRegistrykey() {
		return endpointRegistrykey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndpointRegistrykey(RegistryKeyProperty newEndpointRegistrykey, NotificationChain msgs) {
		RegistryKeyProperty oldEndpointRegistrykey = endpointRegistrykey;
		endpointRegistrykey = newEndpointRegistrykey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY, oldEndpointRegistrykey, newEndpointRegistrykey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointRegistrykey(RegistryKeyProperty newEndpointRegistrykey) {
		if (newEndpointRegistrykey != endpointRegistrykey) {
			NotificationChain msgs = null;
			if (endpointRegistrykey != null)
				msgs = ((InternalEObject)endpointRegistrykey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY, null, msgs);
			if (newEndpointRegistrykey != null)
				msgs = ((InternalEObject)newEndpointRegistrykey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY, null, msgs);
			msgs = basicSetEndpointRegistrykey(newEndpointRegistrykey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY, newEndpointRegistrykey, newEndpointRegistrykey));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__ENDPOINT_XPATH, oldEndpointXpath, newEndpointXpath);
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
				msgs = ((InternalEObject)endpointXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__ENDPOINT_XPATH, null, msgs);
			if (newEndpointXpath != null)
				msgs = ((InternalEObject)newEndpointXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_MEDIATOR__ENDPOINT_XPATH, null, msgs);
			msgs = basicSetEndpointXpath(newEndpointXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_MEDIATOR__ENDPOINT_XPATH, newEndpointXpath, newEndpointXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.CALL_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.CALL_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR:
				return basicSetEndpointOutputConnector(null, msgs);
			case EsbPackage.CALL_MEDIATOR__MEDIATOR_FLOW:
				return basicSetMediatorFlow(null, msgs);
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY:
				return basicSetEndpointRegistrykey(null, msgs);
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_XPATH:
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
			case EsbPackage.CALL_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.CALL_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.CALL_MEDIATOR__ENDPOINT:
				return getEndpoint();
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR:
				return getEndpointOutputConnector();
			case EsbPackage.CALL_MEDIATOR__MEDIATOR_FLOW:
				return getMediatorFlow();
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_TYPE:
				return getEndpointType();
			case EsbPackage.CALL_MEDIATOR__ENABLE_BLOCKING_CALLS:
				return isEnableBlockingCalls();
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY:
				return getEndpointRegistrykey();
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_XPATH:
				return getEndpointXpath();
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
			case EsbPackage.CALL_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((CallMediatorInputConnector)newValue);
				return;
			case EsbPackage.CALL_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((CallMediatorOutputConnector)newValue);
				return;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT:
				getEndpoint().clear();
				getEndpoint().addAll((Collection<? extends EndPoint>)newValue);
				return;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR:
				setEndpointOutputConnector((CallMediatorEndpointOutputConnector)newValue);
				return;
			case EsbPackage.CALL_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)newValue);
				return;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_TYPE:
				setEndpointType((CallMediatorEndpointType)newValue);
				return;
			case EsbPackage.CALL_MEDIATOR__ENABLE_BLOCKING_CALLS:
				setEnableBlockingCalls((Boolean)newValue);
				return;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY:
				setEndpointRegistrykey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_XPATH:
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
			case EsbPackage.CALL_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((CallMediatorInputConnector)null);
				return;
			case EsbPackage.CALL_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((CallMediatorOutputConnector)null);
				return;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT:
				getEndpoint().clear();
				return;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR:
				setEndpointOutputConnector((CallMediatorEndpointOutputConnector)null);
				return;
			case EsbPackage.CALL_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)null);
				return;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_TYPE:
				setEndpointType(ENDPOINT_TYPE_EDEFAULT);
				return;
			case EsbPackage.CALL_MEDIATOR__ENABLE_BLOCKING_CALLS:
				setEnableBlockingCalls(ENABLE_BLOCKING_CALLS_EDEFAULT);
				return;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY:
				setEndpointRegistrykey((RegistryKeyProperty)null);
				return;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_XPATH:
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
			case EsbPackage.CALL_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.CALL_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT:
				return endpoint != null && !endpoint.isEmpty();
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_OUTPUT_CONNECTOR:
				return endpointOutputConnector != null;
			case EsbPackage.CALL_MEDIATOR__MEDIATOR_FLOW:
				return mediatorFlow != null;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_TYPE:
				return endpointType != ENDPOINT_TYPE_EDEFAULT;
			case EsbPackage.CALL_MEDIATOR__ENABLE_BLOCKING_CALLS:
				return enableBlockingCalls != ENABLE_BLOCKING_CALLS_EDEFAULT;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY:
				return endpointRegistrykey != null;
			case EsbPackage.CALL_MEDIATOR__ENDPOINT_XPATH:
				return endpointXpath != null;
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
		result.append(", enableBlockingCalls: ");
		result.append(enableBlockingCalls);
		result.append(')');
		return result.toString();
	}

} //CallMediatorImpl
