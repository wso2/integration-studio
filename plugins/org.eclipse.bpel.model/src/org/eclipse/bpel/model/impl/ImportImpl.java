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
 * $Id: ImportImpl.java,v 1.12 2011/03/30 18:54:24 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ImportImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ImportImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ImportImpl#getImportType <em>Import Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImportImpl extends BPELExtensibleElementImpl implements Import {
	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getImportType() <em>Import Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportType()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImportType() <em>Import Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportType()
	 * @generated
	 * @ordered
	 */
	protected String importType = IMPORT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.IMPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_NAMESPACE, newNamespace);
		}
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.IMPORT__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_LOCATION, newLocation);
		}
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.IMPORT__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImportType() {
		return importType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setImportType(String newImportType) {
		String oldImportType = importType;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_IMPORT_TYPE, newImportType);
		}
		importType = newImportType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.IMPORT__IMPORT_TYPE, oldImportType, importType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BPELPackage.IMPORT__NAMESPACE:
			return getNamespace();
		case BPELPackage.IMPORT__LOCATION:
			return getLocation();
		case BPELPackage.IMPORT__IMPORT_TYPE:
			return getImportType();
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
		case BPELPackage.IMPORT__NAMESPACE:
			setNamespace((String) newValue);
			return;
		case BPELPackage.IMPORT__LOCATION:
			setLocation((String) newValue);
			return;
		case BPELPackage.IMPORT__IMPORT_TYPE:
			setImportType((String) newValue);
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
		case BPELPackage.IMPORT__NAMESPACE:
			setNamespace(NAMESPACE_EDEFAULT);
			return;
		case BPELPackage.IMPORT__LOCATION:
			setLocation(LOCATION_EDEFAULT);
			return;
		case BPELPackage.IMPORT__IMPORT_TYPE:
			setImportType(IMPORT_TYPE_EDEFAULT);
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
		case BPELPackage.IMPORT__NAMESPACE:
			return NAMESPACE_EDEFAULT == null ? namespace != null
					: !NAMESPACE_EDEFAULT.equals(namespace);
		case BPELPackage.IMPORT__LOCATION:
			return LOCATION_EDEFAULT == null ? location != null
					: !LOCATION_EDEFAULT.equals(location);
		case BPELPackage.IMPORT__IMPORT_TYPE:
			return IMPORT_TYPE_EDEFAULT == null ? importType != null
					: !IMPORT_TYPE_EDEFAULT.equals(importType);
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
		result.append(" (namespace: "); //$NON-NLS-1$
		result.append(namespace);
		result.append(", location: "); //$NON-NLS-1$
		result.append(location);
		result.append(", importType: "); //$NON-NLS-1$
		result.append(importType);
		result.append(')');
		return result.toString();
	}

} //ImportImpl
