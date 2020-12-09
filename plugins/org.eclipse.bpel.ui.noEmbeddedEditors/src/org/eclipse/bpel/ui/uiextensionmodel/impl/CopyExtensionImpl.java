/**
 * <copyright>
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: CopyExtensionImpl.java,v 1.4 2011/02/11 16:43:04 vzurczak Exp $
 */
package org.eclipse.bpel.ui.uiextensionmodel.impl;

import org.eclipse.bpel.ui.uiextensionmodel.CopyExtension;
import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Copy Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.ui.uiextensionmodel.impl.CopyExtensionImpl#getFromType <em>From Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.ui.uiextensionmodel.impl.CopyExtensionImpl#getToType <em>To Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CopyExtensionImpl extends EObjectImpl implements CopyExtension {
	/**
	 * The default value of the '{@link #getFromType() <em>From Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromType()
	 * @generated
	 * @ordered
	 */
	protected static final int FROM_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFromType() <em>From Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromType()
	 * @generated
	 * @ordered
	 */
	protected int fromType = FROM_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getToType() <em>To Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToType()
	 * @generated
	 * @ordered
	 */
	protected static final int TO_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getToType() <em>To Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToType()
	 * @generated
	 * @ordered
	 */
	protected int toType = TO_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CopyExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiextensionmodelPackage.Literals.COPY_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFromType() {
		return fromType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromType(int newFromType) {
		int oldFromType = fromType;
		fromType = newFromType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiextensionmodelPackage.COPY_EXTENSION__FROM_TYPE, oldFromType, fromType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getToType() {
		return toType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToType(int newToType) {
		int oldToType = toType;
		toType = newToType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiextensionmodelPackage.COPY_EXTENSION__TO_TYPE, oldToType, toType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiextensionmodelPackage.COPY_EXTENSION__FROM_TYPE:
				return Integer.valueOf( getFromType());
			case UiextensionmodelPackage.COPY_EXTENSION__TO_TYPE:
				return Integer.valueOf( getToType());
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
			case UiextensionmodelPackage.COPY_EXTENSION__FROM_TYPE:
				setFromType(((Integer)newValue).intValue());
				return;
			case UiextensionmodelPackage.COPY_EXTENSION__TO_TYPE:
				setToType(((Integer)newValue).intValue());
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
			case UiextensionmodelPackage.COPY_EXTENSION__FROM_TYPE:
				setFromType(FROM_TYPE_EDEFAULT);
				return;
			case UiextensionmodelPackage.COPY_EXTENSION__TO_TYPE:
				setToType(TO_TYPE_EDEFAULT);
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
			case UiextensionmodelPackage.COPY_EXTENSION__FROM_TYPE:
				return fromType != FROM_TYPE_EDEFAULT;
			case UiextensionmodelPackage.COPY_EXTENSION__TO_TYPE:
				return toType != TO_TYPE_EDEFAULT;
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
		result.append(" (fromType: ");
		result.append(fromType);
		result.append(", toType: ");
		result.append(toType);
		result.append(')');
		return result.toString();
	}

} //CopyExtensionImpl
