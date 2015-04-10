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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointOnErrorSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointOnErrorSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointSequenceOutputConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inbound Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSequenceInputConnector <em>Sequence Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSequenceOutputConnector <em>Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getOnErrorSequenceInputConnector <em>On Error Sequence Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getOnErrorSequenceOutputConnector <em>On Error Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getOnErrorSequence <em>On Error Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointImpl#getProtocol <em>Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InboundEndpointImpl extends EsbElementImpl implements InboundEndpoint {
    /**
	 * The cached value of the '{@link #getSequenceInputConnector() <em>Sequence Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSequenceInputConnector()
	 * @generated
	 * @ordered
	 */
    protected InboundEndpointSequenceInputConnector sequenceInputConnector;

    /**
	 * The cached value of the '{@link #getSequenceOutputConnector() <em>Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSequenceOutputConnector()
	 * @generated
	 * @ordered
	 */
    protected InboundEndpointSequenceOutputConnector sequenceOutputConnector;

    /**
	 * The cached value of the '{@link #getOnErrorSequenceInputConnector() <em>On Error Sequence Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOnErrorSequenceInputConnector()
	 * @generated
	 * @ordered
	 */
    protected InboundEndpointOnErrorSequenceInputConnector onErrorSequenceInputConnector;

    /**
	 * The cached value of the '{@link #getOnErrorSequenceOutputConnector() <em>On Error Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOnErrorSequenceOutputConnector()
	 * @generated
	 * @ordered
	 */
    protected InboundEndpointOnErrorSequenceOutputConnector onErrorSequenceOutputConnector;

    /**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
    protected InboundEndpointContainer container;

    /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
    protected static final String NAME_EDEFAULT = null;

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
	 * The default value of the '{@link #getSequence() <em>Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSequence()
	 * @generated
	 * @ordered
	 */
    protected static final String SEQUENCE_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getSequence() <em>Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSequence()
	 * @generated
	 * @ordered
	 */
    protected String sequence = SEQUENCE_EDEFAULT;

    /**
	 * The default value of the '{@link #getOnErrorSequence() <em>On Error Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOnErrorSequence()
	 * @generated
	 * @ordered
	 */
    protected static final String ON_ERROR_SEQUENCE_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getOnErrorSequence() <em>On Error Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOnErrorSequence()
	 * @generated
	 * @ordered
	 */
    protected String onErrorSequence = ON_ERROR_SEQUENCE_EDEFAULT;

    /**
	 * The default value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
    protected static final String PROTOCOL_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
    protected String protocol = PROTOCOL_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected InboundEndpointImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return EsbPackage.Literals.INBOUND_ENDPOINT;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public InboundEndpointSequenceInputConnector getSequenceInputConnector() {
		return sequenceInputConnector;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetSequenceInputConnector(InboundEndpointSequenceInputConnector newSequenceInputConnector, NotificationChain msgs) {
		InboundEndpointSequenceInputConnector oldSequenceInputConnector = sequenceInputConnector;
		sequenceInputConnector = newSequenceInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR, oldSequenceInputConnector, newSequenceInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSequenceInputConnector(InboundEndpointSequenceInputConnector newSequenceInputConnector) {
		if (newSequenceInputConnector != sequenceInputConnector) {
			NotificationChain msgs = null;
			if (sequenceInputConnector != null)
				msgs = ((InternalEObject)sequenceInputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR, null, msgs);
			if (newSequenceInputConnector != null)
				msgs = ((InternalEObject)newSequenceInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR, null, msgs);
			msgs = basicSetSequenceInputConnector(newSequenceInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR, newSequenceInputConnector, newSequenceInputConnector));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public InboundEndpointSequenceOutputConnector getSequenceOutputConnector() {
		return sequenceOutputConnector;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetSequenceOutputConnector(InboundEndpointSequenceOutputConnector newSequenceOutputConnector, NotificationChain msgs) {
		InboundEndpointSequenceOutputConnector oldSequenceOutputConnector = sequenceOutputConnector;
		sequenceOutputConnector = newSequenceOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR, oldSequenceOutputConnector, newSequenceOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSequenceOutputConnector(InboundEndpointSequenceOutputConnector newSequenceOutputConnector) {
		if (newSequenceOutputConnector != sequenceOutputConnector) {
			NotificationChain msgs = null;
			if (sequenceOutputConnector != null)
				msgs = ((InternalEObject)sequenceOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			if (newSequenceOutputConnector != null)
				msgs = ((InternalEObject)newSequenceOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetSequenceOutputConnector(newSequenceOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR, newSequenceOutputConnector, newSequenceOutputConnector));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public InboundEndpointOnErrorSequenceInputConnector getOnErrorSequenceInputConnector() {
		return onErrorSequenceInputConnector;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector newOnErrorSequenceInputConnector, NotificationChain msgs) {
		InboundEndpointOnErrorSequenceInputConnector oldOnErrorSequenceInputConnector = onErrorSequenceInputConnector;
		onErrorSequenceInputConnector = newOnErrorSequenceInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR, oldOnErrorSequenceInputConnector, newOnErrorSequenceInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector newOnErrorSequenceInputConnector) {
		if (newOnErrorSequenceInputConnector != onErrorSequenceInputConnector) {
			NotificationChain msgs = null;
			if (onErrorSequenceInputConnector != null)
				msgs = ((InternalEObject)onErrorSequenceInputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR, null, msgs);
			if (newOnErrorSequenceInputConnector != null)
				msgs = ((InternalEObject)newOnErrorSequenceInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR, null, msgs);
			msgs = basicSetOnErrorSequenceInputConnector(newOnErrorSequenceInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR, newOnErrorSequenceInputConnector, newOnErrorSequenceInputConnector));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public InboundEndpointOnErrorSequenceOutputConnector getOnErrorSequenceOutputConnector() {
		return onErrorSequenceOutputConnector;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector newOnErrorSequenceOutputConnector, NotificationChain msgs) {
		InboundEndpointOnErrorSequenceOutputConnector oldOnErrorSequenceOutputConnector = onErrorSequenceOutputConnector;
		onErrorSequenceOutputConnector = newOnErrorSequenceOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR, oldOnErrorSequenceOutputConnector, newOnErrorSequenceOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector newOnErrorSequenceOutputConnector) {
		if (newOnErrorSequenceOutputConnector != onErrorSequenceOutputConnector) {
			NotificationChain msgs = null;
			if (onErrorSequenceOutputConnector != null)
				msgs = ((InternalEObject)onErrorSequenceOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			if (newOnErrorSequenceOutputConnector != null)
				msgs = ((InternalEObject)newOnErrorSequenceOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOnErrorSequenceOutputConnector(newOnErrorSequenceOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR, newOnErrorSequenceOutputConnector, newOnErrorSequenceOutputConnector));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public InboundEndpointContainer getContainer() {
		return container;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetContainer(InboundEndpointContainer newContainer, NotificationChain msgs) {
		InboundEndpointContainer oldContainer = container;
		container = newContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__CONTAINER, oldContainer, newContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setContainer(InboundEndpointContainer newContainer) {
		if (newContainer != container) {
			NotificationChain msgs = null;
			if (container != null)
				msgs = ((InternalEObject)container).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__CONTAINER, null, msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT__CONTAINER, null, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__CONTAINER, newContainer, newContainer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__NAME, oldName, name));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getSequence() {
		return sequence;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSequence(String newSequence) {
		String oldSequence = sequence;
		sequence = newSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__SEQUENCE, oldSequence, sequence));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getOnErrorSequence() {
		return onErrorSequence;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setOnErrorSequence(String newOnErrorSequence) {
		String oldOnErrorSequence = onErrorSequence;
		onErrorSequence = newOnErrorSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE, oldOnErrorSequence, onErrorSequence));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getProtocol() {
		return protocol;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setProtocol(String newProtocol) {
		String oldProtocol = protocol;
		protocol = newProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT__PROTOCOL, oldProtocol, protocol));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
				return basicSetSequenceInputConnector(null, msgs);
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
				return basicSetSequenceOutputConnector(null, msgs);
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
				return basicSetOnErrorSequenceInputConnector(null, msgs);
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
				return basicSetOnErrorSequenceOutputConnector(null, msgs);
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
				return basicSetContainer(null, msgs);
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
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
				return getSequenceInputConnector();
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
				return getSequenceOutputConnector();
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
				return getOnErrorSequenceInputConnector();
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
				return getOnErrorSequenceOutputConnector();
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
				return getContainer();
			case EsbPackage.INBOUND_ENDPOINT__NAME:
				return getName();
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE:
				return getSequence();
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE:
				return getOnErrorSequence();
			case EsbPackage.INBOUND_ENDPOINT__PROTOCOL:
				return getProtocol();
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
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
				setSequenceInputConnector((InboundEndpointSequenceInputConnector)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
				setSequenceOutputConnector((InboundEndpointSequenceOutputConnector)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
				setOnErrorSequenceInputConnector((InboundEndpointOnErrorSequenceInputConnector)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
				setOnErrorSequenceOutputConnector((InboundEndpointOnErrorSequenceOutputConnector)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
				setContainer((InboundEndpointContainer)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__NAME:
				setName((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE:
				setSequence((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE:
				setOnErrorSequence((String)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT__PROTOCOL:
				setProtocol((String)newValue);
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
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
				setSequenceInputConnector((InboundEndpointSequenceInputConnector)null);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
				setSequenceOutputConnector((InboundEndpointSequenceOutputConnector)null);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
				setOnErrorSequenceInputConnector((InboundEndpointOnErrorSequenceInputConnector)null);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
				setOnErrorSequenceOutputConnector((InboundEndpointOnErrorSequenceOutputConnector)null);
				return;
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
				setContainer((InboundEndpointContainer)null);
				return;
			case EsbPackage.INBOUND_ENDPOINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE:
				setSequence(SEQUENCE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE:
				setOnErrorSequence(ON_ERROR_SEQUENCE_EDEFAULT);
				return;
			case EsbPackage.INBOUND_ENDPOINT__PROTOCOL:
				setProtocol(PROTOCOL_EDEFAULT);
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
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_INPUT_CONNECTOR:
				return sequenceInputConnector != null;
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE_OUTPUT_CONNECTOR:
				return sequenceOutputConnector != null;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_INPUT_CONNECTOR:
				return onErrorSequenceInputConnector != null;
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR:
				return onErrorSequenceOutputConnector != null;
			case EsbPackage.INBOUND_ENDPOINT__CONTAINER:
				return container != null;
			case EsbPackage.INBOUND_ENDPOINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EsbPackage.INBOUND_ENDPOINT__SEQUENCE:
				return SEQUENCE_EDEFAULT == null ? sequence != null : !SEQUENCE_EDEFAULT.equals(sequence);
			case EsbPackage.INBOUND_ENDPOINT__ON_ERROR_SEQUENCE:
				return ON_ERROR_SEQUENCE_EDEFAULT == null ? onErrorSequence != null : !ON_ERROR_SEQUENCE_EDEFAULT.equals(onErrorSequence);
			case EsbPackage.INBOUND_ENDPOINT__PROTOCOL:
				return PROTOCOL_EDEFAULT == null ? protocol != null : !PROTOCOL_EDEFAULT.equals(protocol);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", sequence: ");
		result.append(sequence);
		result.append(", onErrorSequence: ");
		result.append(onErrorSequence);
		result.append(", protocol: ");
		result.append(protocol);
		result.append(')');
		return result.toString();
	}

} //InboundEndpointImpl
