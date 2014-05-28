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
 * $Id: VariableExtensionImpl.java,v 1.4 2011/02/11 16:43:04 vzurczak Exp $
 */
package org.eclipse.bpel.ui.uiextensionmodel.impl;

import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelPackage;
import org.eclipse.bpel.ui.uiextensionmodel.VariableExtension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.ui.uiextensionmodel.impl.VariableExtensionImpl#getAdvancedKind <em>Advanced Kind</em>}</li>
 *   <li>{@link org.eclipse.bpel.ui.uiextensionmodel.impl.VariableExtensionImpl#getVariableKind <em>Variable Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableExtensionImpl extends EObjectImpl implements VariableExtension {
	/**
	 * The default value of the '{@link #getAdvancedKind() <em>Advanced Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvancedKind()
	 * @generated
	 * @ordered
	 */
	protected static final int ADVANCED_KIND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAdvancedKind() <em>Advanced Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvancedKind()
	 * @generated
	 * @ordered
	 */
	protected int advancedKind = ADVANCED_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariableKind() <em>Variable Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableKind()
	 * @generated
	 * @ordered
	 */
	protected static final int VARIABLE_KIND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVariableKind() <em>Variable Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableKind()
	 * @generated
	 * @ordered
	 */
	protected int variableKind = VARIABLE_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiextensionmodelPackage.Literals.VARIABLE_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAdvancedKind() {
		return advancedKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdvancedKind(int newAdvancedKind) {
		int oldAdvancedKind = advancedKind;
		advancedKind = newAdvancedKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiextensionmodelPackage.VARIABLE_EXTENSION__ADVANCED_KIND, oldAdvancedKind, advancedKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVariableKind() {
		return variableKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableKind(int newVariableKind) {
		int oldVariableKind = variableKind;
		variableKind = newVariableKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiextensionmodelPackage.VARIABLE_EXTENSION__VARIABLE_KIND, oldVariableKind, variableKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiextensionmodelPackage.VARIABLE_EXTENSION__ADVANCED_KIND:
				return Integer.valueOf( getAdvancedKind());
			case UiextensionmodelPackage.VARIABLE_EXTENSION__VARIABLE_KIND:
				return Integer.valueOf( getVariableKind());
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
			case UiextensionmodelPackage.VARIABLE_EXTENSION__ADVANCED_KIND:
				setAdvancedKind(((Integer)newValue).intValue());
				return;
			case UiextensionmodelPackage.VARIABLE_EXTENSION__VARIABLE_KIND:
				setVariableKind(((Integer)newValue).intValue());
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
			case UiextensionmodelPackage.VARIABLE_EXTENSION__ADVANCED_KIND:
				setAdvancedKind(ADVANCED_KIND_EDEFAULT);
				return;
			case UiextensionmodelPackage.VARIABLE_EXTENSION__VARIABLE_KIND:
				setVariableKind(VARIABLE_KIND_EDEFAULT);
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
			case UiextensionmodelPackage.VARIABLE_EXTENSION__ADVANCED_KIND:
				return advancedKind != ADVANCED_KIND_EDEFAULT;
			case UiextensionmodelPackage.VARIABLE_EXTENSION__VARIABLE_KIND:
				return variableKind != VARIABLE_KIND_EDEFAULT;
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
		result.append(" (advancedKind: ");
		result.append(advancedKind);
		result.append(", variableKind: ");
		result.append(variableKind);
		result.append(')');
		return result.toString();
	}

} //VariableExtensionImpl
