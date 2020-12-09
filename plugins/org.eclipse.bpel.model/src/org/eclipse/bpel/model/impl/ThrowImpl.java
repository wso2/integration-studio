/**
 * <copyright>
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: ThrowImpl.java,v 1.12 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Throw;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throw</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ThrowImpl#getFaultName <em>Fault Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ThrowImpl#getFaultVariable <em>Fault Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThrowImpl extends ActivityImpl implements Throw {
	/**
	 * The default value of the '{@link #getFaultName() <em>Fault Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultName()
	 * @generated
	 * @ordered
	 */
	protected static final QName FAULT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaultName() <em>Fault Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultName()
	 * @generated
	 * @ordered
	 */
	protected QName faultName = FAULT_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFaultVariable() <em>Fault Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable faultVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThrowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.THROW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getFaultName() {
		return faultName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setFaultName(QName newFaultName) {
		QName oldFaultName = faultName;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_FAULT_NAME, newFaultName);
		}
		faultName = newFaultName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.THROW__FAULT_NAME, oldFaultName, faultName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getFaultVariable() {
		if (faultVariable != null && faultVariable.eIsProxy()) {
			InternalEObject oldFaultVariable = (InternalEObject) faultVariable;
			faultVariable = (Variable) eResolveProxy(oldFaultVariable);
			if (faultVariable != oldFaultVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.THROW__FAULT_VARIABLE,
							oldFaultVariable, faultVariable));
			}
		}
		return faultVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetFaultVariable() {
		return faultVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setFaultVariable(Variable newFaultVariable) {
		Variable oldFaultVariable = faultVariable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					BPELConstants.AT_FAULT_VARIABLE,
					newFaultVariable == null ? null : newFaultVariable
							.getName());
		}
		faultVariable = newFaultVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.THROW__FAULT_VARIABLE, oldFaultVariable,
					faultVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BPELPackage.THROW__FAULT_NAME:
			return getFaultName();
		case BPELPackage.THROW__FAULT_VARIABLE:
			if (resolve)
				return getFaultVariable();
			return basicGetFaultVariable();
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
		case BPELPackage.THROW__FAULT_NAME:
			setFaultName((QName) newValue);
			return;
		case BPELPackage.THROW__FAULT_VARIABLE:
			setFaultVariable((Variable) newValue);
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
		case BPELPackage.THROW__FAULT_NAME:
			setFaultName(FAULT_NAME_EDEFAULT);
			return;
		case BPELPackage.THROW__FAULT_VARIABLE:
			setFaultVariable((Variable) null);
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
		case BPELPackage.THROW__FAULT_NAME:
			return FAULT_NAME_EDEFAULT == null ? faultName != null
					: !FAULT_NAME_EDEFAULT.equals(faultName);
		case BPELPackage.THROW__FAULT_VARIABLE:
			return faultVariable != null;
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (faultName: "); //$NON-NLS-1$
		result.append(faultName);
		result.append(')');
		return result.toString();
	}

} //ThrowImpl
