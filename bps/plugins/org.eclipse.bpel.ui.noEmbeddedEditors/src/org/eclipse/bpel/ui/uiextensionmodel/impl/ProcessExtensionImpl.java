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
 * $Id: ProcessExtensionImpl.java,v 1.4 2011/02/11 16:43:04 vzurczak Exp $
 */
package org.eclipse.bpel.ui.uiextensionmodel.impl;

import org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension;
import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.ui.uiextensionmodel.impl.ProcessExtensionImpl#isSpecCompliant <em>Spec Compliant</em>}</li>
 *   <li>{@link org.eclipse.bpel.ui.uiextensionmodel.impl.ProcessExtensionImpl#getModificationStamp <em>Modification Stamp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessExtensionImpl extends EObjectImpl implements ProcessExtension {
	/**
	 * The default value of the '{@link #isSpecCompliant() <em>Spec Compliant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpecCompliant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SPEC_COMPLIANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSpecCompliant() <em>Spec Compliant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpecCompliant()
	 * @generated
	 * @ordered
	 */
	protected boolean specCompliant = SPEC_COMPLIANT_EDEFAULT;

	/**
	 * The default value of the '{@link #getModificationStamp() <em>Modification Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationStamp()
	 * @generated
	 * @ordered
	 */
	protected static final long MODIFICATION_STAMP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getModificationStamp() <em>Modification Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationStamp()
	 * @generated
	 * @ordered
	 */
	protected long modificationStamp = MODIFICATION_STAMP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiextensionmodelPackage.Literals.PROCESS_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSpecCompliant() {
		return specCompliant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecCompliant(boolean newSpecCompliant) {
		boolean oldSpecCompliant = specCompliant;
		specCompliant = newSpecCompliant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiextensionmodelPackage.PROCESS_EXTENSION__SPEC_COMPLIANT, oldSpecCompliant, specCompliant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getModificationStamp() {
		return modificationStamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModificationStamp(long newModificationStamp) {
		long oldModificationStamp = modificationStamp;
		modificationStamp = newModificationStamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiextensionmodelPackage.PROCESS_EXTENSION__MODIFICATION_STAMP, oldModificationStamp, modificationStamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiextensionmodelPackage.PROCESS_EXTENSION__SPEC_COMPLIANT:
				return isSpecCompliant() ? Boolean.TRUE : Boolean.FALSE;
			case UiextensionmodelPackage.PROCESS_EXTENSION__MODIFICATION_STAMP:
				return Long.valueOf( getModificationStamp());
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
			case UiextensionmodelPackage.PROCESS_EXTENSION__SPEC_COMPLIANT:
				setSpecCompliant(((Boolean)newValue).booleanValue());
				return;
			case UiextensionmodelPackage.PROCESS_EXTENSION__MODIFICATION_STAMP:
				setModificationStamp(((Long)newValue).longValue());
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
			case UiextensionmodelPackage.PROCESS_EXTENSION__SPEC_COMPLIANT:
				setSpecCompliant(SPEC_COMPLIANT_EDEFAULT);
				return;
			case UiextensionmodelPackage.PROCESS_EXTENSION__MODIFICATION_STAMP:
				setModificationStamp(MODIFICATION_STAMP_EDEFAULT);
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
			case UiextensionmodelPackage.PROCESS_EXTENSION__SPEC_COMPLIANT:
				return specCompliant != SPEC_COMPLIANT_EDEFAULT;
			case UiextensionmodelPackage.PROCESS_EXTENSION__MODIFICATION_STAMP:
				return modificationStamp != MODIFICATION_STAMP_EDEFAULT;
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
		result.append(" (specCompliant: ");
		result.append(specCompliant);
		result.append(", modificationStamp: ");
		result.append(modificationStamp);
		result.append(')');
		return result.toString();
	}

} //ProcessExtensionImpl
