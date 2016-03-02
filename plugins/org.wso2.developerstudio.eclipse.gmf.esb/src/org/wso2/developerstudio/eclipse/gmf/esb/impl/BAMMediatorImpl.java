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

import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BAM Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.BAMMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.BAMMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.BAMMediatorImpl#getServerProfile <em>Server Profile</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.BAMMediatorImpl#getStreamName <em>Stream Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.BAMMediatorImpl#getStreamVersion <em>Stream Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BAMMediatorImpl extends MediatorImpl implements BAMMediator {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected BAMMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected BAMMediatorOutputConnector outputConnector;

	/**
	 * The default value of the '{@link #getServerProfile() <em>Server Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerProfile()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_PROFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerProfile() <em>Server Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerProfile()
	 * @generated
	 * @ordered
	 */
	protected String serverProfile = SERVER_PROFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStreamName() <em>Stream Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreamName()
	 * @generated
	 * @ordered
	 */
	protected static final String STREAM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStreamName() <em>Stream Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreamName()
	 * @generated
	 * @ordered
	 */
	protected String streamName = STREAM_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStreamVersion() <em>Stream Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreamVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String STREAM_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStreamVersion() <em>Stream Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreamVersion()
	 * @generated
	 * @ordered
	 */
	protected String streamVersion = STREAM_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BAMMediatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.BAM_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BAMMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(BAMMediatorInputConnector newInputConnector, NotificationChain msgs) {
		BAMMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.BAM_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(BAMMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.BAM_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.BAM_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.BAM_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BAMMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(BAMMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		BAMMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.BAM_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(BAMMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.BAM_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.BAM_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.BAM_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerProfile() {
		return serverProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerProfile(String newServerProfile) {
		String oldServerProfile = serverProfile;
		serverProfile = newServerProfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.BAM_MEDIATOR__SERVER_PROFILE, oldServerProfile, serverProfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStreamName() {
		return streamName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreamName(String newStreamName) {
		String oldStreamName = streamName;
		streamName = newStreamName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.BAM_MEDIATOR__STREAM_NAME, oldStreamName, streamName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStreamVersion() {
		return streamVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreamVersion(String newStreamVersion) {
		String oldStreamVersion = streamVersion;
		streamVersion = newStreamVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.BAM_MEDIATOR__STREAM_VERSION, oldStreamVersion, streamVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.BAM_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.BAM_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.BAM_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.BAM_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.BAM_MEDIATOR__SERVER_PROFILE:
				return getServerProfile();
			case EsbPackage.BAM_MEDIATOR__STREAM_NAME:
				return getStreamName();
			case EsbPackage.BAM_MEDIATOR__STREAM_VERSION:
				return getStreamVersion();
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
			case EsbPackage.BAM_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((BAMMediatorInputConnector)newValue);
				return;
			case EsbPackage.BAM_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((BAMMediatorOutputConnector)newValue);
				return;
			case EsbPackage.BAM_MEDIATOR__SERVER_PROFILE:
				setServerProfile((String)newValue);
				return;
			case EsbPackage.BAM_MEDIATOR__STREAM_NAME:
				setStreamName((String)newValue);
				return;
			case EsbPackage.BAM_MEDIATOR__STREAM_VERSION:
				setStreamVersion((String)newValue);
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
			case EsbPackage.BAM_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((BAMMediatorInputConnector)null);
				return;
			case EsbPackage.BAM_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((BAMMediatorOutputConnector)null);
				return;
			case EsbPackage.BAM_MEDIATOR__SERVER_PROFILE:
				setServerProfile(SERVER_PROFILE_EDEFAULT);
				return;
			case EsbPackage.BAM_MEDIATOR__STREAM_NAME:
				setStreamName(STREAM_NAME_EDEFAULT);
				return;
			case EsbPackage.BAM_MEDIATOR__STREAM_VERSION:
				setStreamVersion(STREAM_VERSION_EDEFAULT);
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
			case EsbPackage.BAM_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.BAM_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.BAM_MEDIATOR__SERVER_PROFILE:
				return SERVER_PROFILE_EDEFAULT == null ? serverProfile != null : !SERVER_PROFILE_EDEFAULT.equals(serverProfile);
			case EsbPackage.BAM_MEDIATOR__STREAM_NAME:
				return STREAM_NAME_EDEFAULT == null ? streamName != null : !STREAM_NAME_EDEFAULT.equals(streamName);
			case EsbPackage.BAM_MEDIATOR__STREAM_VERSION:
				return STREAM_VERSION_EDEFAULT == null ? streamVersion != null : !STREAM_VERSION_EDEFAULT.equals(streamVersion);
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
		result.append(" (serverProfile: ");
		result.append(serverProfile);
		result.append(", streamName: ");
		result.append(streamName);
		result.append(", streamVersion: ");
		result.append(streamVersion);
		result.append(')');
		return result.toString();
	}

} //BAMMediatorImpl
