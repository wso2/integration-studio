/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.model.dd.impl;

import java.util.Collection;

import org.eclipse.bpel.apache.ode.deploy.model.dd.TEnableEventList;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TEnable Event List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEnableEventListImpl#getEnableEvent <em>Enable Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TEnableEventListImpl extends EObjectImpl implements TEnableEventList {
	/**
	 * The cached value of the '{@link #getEnableEvent() <em>Enable Event</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableEvent()
	 * @generated
	 * @ordered
	 */
	protected EList<String> enableEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TEnableEventListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ddPackage.Literals.TENABLE_EVENT_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEnableEvent() {
		if (enableEvent == null) {
			enableEvent = new EDataTypeEList<String>(String.class, this, ddPackage.TENABLE_EVENT_LIST__ENABLE_EVENT);
		}
		return enableEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ddPackage.TENABLE_EVENT_LIST__ENABLE_EVENT:
				return getEnableEvent();
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
			case ddPackage.TENABLE_EVENT_LIST__ENABLE_EVENT:
				getEnableEvent().clear();
				getEnableEvent().addAll((Collection<? extends String>)newValue);
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
			case ddPackage.TENABLE_EVENT_LIST__ENABLE_EVENT:
				getEnableEvent().clear();
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
			case ddPackage.TENABLE_EVENT_LIST__ENABLE_EVENT:
				return enableEvent != null && !enableEvent.isEmpty();
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
		result.append(" (enableEvent: ");
		result.append(enableEvent);
		result.append(')');
		return result.toString();
	}

} //TEnableEventListImpl
