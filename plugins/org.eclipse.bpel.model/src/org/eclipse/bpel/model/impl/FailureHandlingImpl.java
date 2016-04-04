/**
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * JIRA TOOL - 785
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.FailureHandling;
import org.eclipse.bpel.model.FaultOnFailure;
import org.eclipse.bpel.model.RetryDelay;
import org.eclipse.bpel.model.RetryFor;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Handling</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.FailureHandlingImpl#getFaultOnFailure <em>Fault On Failure</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FailureHandlingImpl#getRetryFor <em>Retry For</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FailureHandlingImpl#getRetryDelay <em>Retry Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FailureHandlingImpl extends BPELExtensibleElementImpl implements
		FailureHandling {
	/**
	 * The cached value of the '{@link #getFaultOnFailure() <em>Fault On Failure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultOnFailure()
	 * @generated
	 * @ordered
	 */
	protected FaultOnFailure faultOnFailure;

	/**
	 * The cached value of the '{@link #getRetryFor() <em>Retry For</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryFor()
	 * @generated
	 * @ordered
	 */
	protected RetryFor retryFor;

	/**
	 * The cached value of the '{@link #getRetryDelay() <em>Retry Delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryDelay()
	 * @generated
	 * @ordered
	 */
	protected RetryDelay retryDelay;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FailureHandlingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.FAILURE_HANDLING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultOnFailure getFaultOnFailure() {
		return faultOnFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetFaultOnFailure(
			FaultOnFailure newFaultOnFailure, NotificationChain msgs) {
		FaultOnFailure oldFaultOnFailure = faultOnFailure;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldFaultOnFailure,
					newFaultOnFailure);
		}
		faultOnFailure = newFaultOnFailure;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					BPELPackage.FAILURE_HANDLING__FAULT_ON_FAILURE,
					oldFaultOnFailure, newFaultOnFailure);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultOnFailure(FaultOnFailure newFaultOnFailure) {
		if (newFaultOnFailure != faultOnFailure) {
			NotificationChain msgs = null;
			if (faultOnFailure != null)
				msgs = ((InternalEObject) faultOnFailure)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- BPELPackage.FAILURE_HANDLING__FAULT_ON_FAILURE,
								null, msgs);
			if (newFaultOnFailure != null)
				msgs = ((InternalEObject) newFaultOnFailure)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- BPELPackage.FAILURE_HANDLING__FAULT_ON_FAILURE,
								null, msgs);
			msgs = basicSetFaultOnFailure(newFaultOnFailure, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FAILURE_HANDLING__FAULT_ON_FAILURE,
					newFaultOnFailure, newFaultOnFailure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RetryFor getRetryFor() {
		return retryFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetRetryFor(RetryFor newRetryFor,
			NotificationChain msgs) {
		RetryFor oldRetryFor = retryFor;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldRetryFor, newRetryFor);
		}
		retryFor = newRetryFor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.FAILURE_HANDLING__RETRY_FOR,
					oldRetryFor, newRetryFor);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetryFor(RetryFor newRetryFor) {
		if (newRetryFor != retryFor) {
			NotificationChain msgs = null;
			if (retryFor != null)
				msgs = ((InternalEObject) retryFor).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.FAILURE_HANDLING__RETRY_FOR,
						null, msgs);
			if (newRetryFor != null)
				msgs = ((InternalEObject) newRetryFor).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.FAILURE_HANDLING__RETRY_FOR,
						null, msgs);
			msgs = basicSetRetryFor(newRetryFor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FAILURE_HANDLING__RETRY_FOR, newRetryFor,
					newRetryFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RetryDelay getRetryDelay() {
		return retryDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetRetryDelay(RetryDelay newRetryDelay,
			NotificationChain msgs) {
		RetryDelay oldRetryDelay = retryDelay;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldRetryDelay,
					newRetryDelay);
		}
		retryDelay = newRetryDelay;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					BPELPackage.FAILURE_HANDLING__RETRY_DELAY, oldRetryDelay,
					newRetryDelay);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetryDelay(RetryDelay newRetryDelay) {
		if (newRetryDelay != retryDelay) {
			NotificationChain msgs = null;
			if (retryDelay != null)
				msgs = ((InternalEObject) retryDelay).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.FAILURE_HANDLING__RETRY_DELAY,
						null, msgs);
			if (newRetryDelay != null)
				msgs = ((InternalEObject) newRetryDelay).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.FAILURE_HANDLING__RETRY_DELAY,
						null, msgs);
			msgs = basicSetRetryDelay(newRetryDelay, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FAILURE_HANDLING__RETRY_DELAY, newRetryDelay,
					newRetryDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BPELPackage.FAILURE_HANDLING__FAULT_ON_FAILURE:
			return basicSetFaultOnFailure(null, msgs);
		case BPELPackage.FAILURE_HANDLING__RETRY_FOR:
			return basicSetRetryFor(null, msgs);
		case BPELPackage.FAILURE_HANDLING__RETRY_DELAY:
			return basicSetRetryDelay(null, msgs);
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
		case BPELPackage.FAILURE_HANDLING__FAULT_ON_FAILURE:
			return getFaultOnFailure();
		case BPELPackage.FAILURE_HANDLING__RETRY_FOR:
			return getRetryFor();
		case BPELPackage.FAILURE_HANDLING__RETRY_DELAY:
			return getRetryDelay();
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
		case BPELPackage.FAILURE_HANDLING__FAULT_ON_FAILURE:
			setFaultOnFailure((FaultOnFailure) newValue);
			return;
		case BPELPackage.FAILURE_HANDLING__RETRY_FOR:
			setRetryFor((RetryFor) newValue);
			return;
		case BPELPackage.FAILURE_HANDLING__RETRY_DELAY:
			setRetryDelay((RetryDelay) newValue);
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
		case BPELPackage.FAILURE_HANDLING__FAULT_ON_FAILURE:
			setFaultOnFailure((FaultOnFailure) null);
			return;
		case BPELPackage.FAILURE_HANDLING__RETRY_FOR:
			setRetryFor((RetryFor) null);
			return;
		case BPELPackage.FAILURE_HANDLING__RETRY_DELAY:
			setRetryDelay((RetryDelay) null);
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
		case BPELPackage.FAILURE_HANDLING__FAULT_ON_FAILURE:
			return faultOnFailure != null;
		case BPELPackage.FAILURE_HANDLING__RETRY_FOR:
			return retryFor != null;
		case BPELPackage.FAILURE_HANDLING__RETRY_DELAY:
			return retryDelay != null;
		}
		return super.eIsSet(featureID);
	}

} //FailureHandlingImpl
