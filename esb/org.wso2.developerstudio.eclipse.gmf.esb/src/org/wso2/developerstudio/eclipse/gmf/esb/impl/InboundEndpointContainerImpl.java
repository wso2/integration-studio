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
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointOnErrorSequenceContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointSequenceContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inbound Endpoint Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointContainerImpl#getSequenceContainer <em>Sequence Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.InboundEndpointContainerImpl#getOnErrorSequenceContainer <em>On Error Sequence Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InboundEndpointContainerImpl extends EsbElementImpl implements InboundEndpointContainer {
	/**
	 * The cached value of the '{@link #getSequenceContainer() <em>Sequence Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceContainer()
	 * @generated
	 * @ordered
	 */
	protected InboundEndpointSequenceContainer sequenceContainer;

	/**
	 * The cached value of the '{@link #getOnErrorSequenceContainer() <em>On Error Sequence Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnErrorSequenceContainer()
	 * @generated
	 * @ordered
	 */
	protected InboundEndpointOnErrorSequenceContainer onErrorSequenceContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InboundEndpointContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.INBOUND_ENDPOINT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointSequenceContainer getSequenceContainer() {
		return sequenceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequenceContainer(InboundEndpointSequenceContainer newSequenceContainer, NotificationChain msgs) {
		InboundEndpointSequenceContainer oldSequenceContainer = sequenceContainer;
		sequenceContainer = newSequenceContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT_CONTAINER__SEQUENCE_CONTAINER, oldSequenceContainer, newSequenceContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceContainer(InboundEndpointSequenceContainer newSequenceContainer) {
		if (newSequenceContainer != sequenceContainer) {
			NotificationChain msgs = null;
			if (sequenceContainer != null)
				msgs = ((InternalEObject)sequenceContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT_CONTAINER__SEQUENCE_CONTAINER, null, msgs);
			if (newSequenceContainer != null)
				msgs = ((InternalEObject)newSequenceContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT_CONTAINER__SEQUENCE_CONTAINER, null, msgs);
			msgs = basicSetSequenceContainer(newSequenceContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT_CONTAINER__SEQUENCE_CONTAINER, newSequenceContainer, newSequenceContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointOnErrorSequenceContainer getOnErrorSequenceContainer() {
		return onErrorSequenceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnErrorSequenceContainer(InboundEndpointOnErrorSequenceContainer newOnErrorSequenceContainer, NotificationChain msgs) {
		InboundEndpointOnErrorSequenceContainer oldOnErrorSequenceContainer = onErrorSequenceContainer;
		onErrorSequenceContainer = newOnErrorSequenceContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT_CONTAINER__ON_ERROR_SEQUENCE_CONTAINER, oldOnErrorSequenceContainer, newOnErrorSequenceContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnErrorSequenceContainer(InboundEndpointOnErrorSequenceContainer newOnErrorSequenceContainer) {
		if (newOnErrorSequenceContainer != onErrorSequenceContainer) {
			NotificationChain msgs = null;
			if (onErrorSequenceContainer != null)
				msgs = ((InternalEObject)onErrorSequenceContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT_CONTAINER__ON_ERROR_SEQUENCE_CONTAINER, null, msgs);
			if (newOnErrorSequenceContainer != null)
				msgs = ((InternalEObject)newOnErrorSequenceContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.INBOUND_ENDPOINT_CONTAINER__ON_ERROR_SEQUENCE_CONTAINER, null, msgs);
			msgs = basicSetOnErrorSequenceContainer(newOnErrorSequenceContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.INBOUND_ENDPOINT_CONTAINER__ON_ERROR_SEQUENCE_CONTAINER, newOnErrorSequenceContainer, newOnErrorSequenceContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER__SEQUENCE_CONTAINER:
				return basicSetSequenceContainer(null, msgs);
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER__ON_ERROR_SEQUENCE_CONTAINER:
				return basicSetOnErrorSequenceContainer(null, msgs);
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
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER__SEQUENCE_CONTAINER:
				return getSequenceContainer();
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER__ON_ERROR_SEQUENCE_CONTAINER:
				return getOnErrorSequenceContainer();
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
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER__SEQUENCE_CONTAINER:
				setSequenceContainer((InboundEndpointSequenceContainer)newValue);
				return;
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER__ON_ERROR_SEQUENCE_CONTAINER:
				setOnErrorSequenceContainer((InboundEndpointOnErrorSequenceContainer)newValue);
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
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER__SEQUENCE_CONTAINER:
				setSequenceContainer((InboundEndpointSequenceContainer)null);
				return;
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER__ON_ERROR_SEQUENCE_CONTAINER:
				setOnErrorSequenceContainer((InboundEndpointOnErrorSequenceContainer)null);
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
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER__SEQUENCE_CONTAINER:
				return sequenceContainer != null;
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER__ON_ERROR_SEQUENCE_CONTAINER:
				return onErrorSequenceContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //InboundEndpointContainerImpl
