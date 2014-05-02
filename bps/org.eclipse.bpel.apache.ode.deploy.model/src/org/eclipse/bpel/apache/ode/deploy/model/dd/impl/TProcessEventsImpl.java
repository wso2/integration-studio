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

import org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TScopeEvents;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TProcess Events</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProcessEventsImpl#getScopeEvents <em>Scope Events</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProcessEventsImpl#getGenerate <em>Generate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TProcessEventsImpl extends TEnableEventListImpl implements TProcessEvents {
	/**
	 * The cached value of the '{@link #getScopeEvents() <em>Scope Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<TScopeEvents> scopeEvents;

	/**
	 * The default value of the '{@link #getGenerate() <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerate()
	 * @generated
	 * @ordered
	 */
	protected static final GenerateType GENERATE_EDEFAULT = GenerateType.ALL;

	/**
	 * The cached value of the '{@link #getGenerate() <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerate()
	 * @generated
	 * @ordered
	 */
	protected GenerateType generate = GENERATE_EDEFAULT;

	/**
	 * This is true if the Generate attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean generateESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TProcessEventsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ddPackage.Literals.TPROCESS_EVENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TScopeEvents> getScopeEvents() {
		if (scopeEvents == null) {
			scopeEvents = new EObjectContainmentEList<TScopeEvents>(TScopeEvents.class, this, ddPackage.TPROCESS_EVENTS__SCOPE_EVENTS);
		}
		return scopeEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenerateType getGenerate() {
		return generate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerate(GenerateType newGenerate) {
		GenerateType oldGenerate = generate;
		generate = newGenerate == null ? GENERATE_EDEFAULT : newGenerate;
		boolean oldGenerateESet = generateESet;
		generateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.TPROCESS_EVENTS__GENERATE, oldGenerate, generate, !oldGenerateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetGenerate() {
		GenerateType oldGenerate = generate;
		boolean oldGenerateESet = generateESet;
		generate = GENERATE_EDEFAULT;
		generateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ddPackage.TPROCESS_EVENTS__GENERATE, oldGenerate, GENERATE_EDEFAULT, oldGenerateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGenerate() {
		return generateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ddPackage.TPROCESS_EVENTS__SCOPE_EVENTS:
				return ((InternalEList<?>)getScopeEvents()).basicRemove(otherEnd, msgs);
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
			case ddPackage.TPROCESS_EVENTS__SCOPE_EVENTS:
				return getScopeEvents();
			case ddPackage.TPROCESS_EVENTS__GENERATE:
				return getGenerate();
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
			case ddPackage.TPROCESS_EVENTS__SCOPE_EVENTS:
				getScopeEvents().clear();
				getScopeEvents().addAll((Collection<? extends TScopeEvents>)newValue);
				return;
			case ddPackage.TPROCESS_EVENTS__GENERATE:
				setGenerate((GenerateType)newValue);
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
			case ddPackage.TPROCESS_EVENTS__SCOPE_EVENTS:
				getScopeEvents().clear();
				return;
			case ddPackage.TPROCESS_EVENTS__GENERATE:
				unsetGenerate();
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
			case ddPackage.TPROCESS_EVENTS__SCOPE_EVENTS:
				return scopeEvents != null && !scopeEvents.isEmpty();
			case ddPackage.TPROCESS_EVENTS__GENERATE:
				return isSetGenerate();
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
		result.append(" (generate: ");
		if (generateESet) result.append(generate); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TProcessEventsImpl
