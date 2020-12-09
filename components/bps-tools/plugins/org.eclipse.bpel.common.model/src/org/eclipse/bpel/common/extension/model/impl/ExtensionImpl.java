/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.extension.model.impl;

import org.eclipse.bpel.common.extension.model.Extension;
import org.eclipse.bpel.common.extension.model.ExtensionmodelPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.common.extension.model.impl.ExtensionImpl#getExtendedObject <em>Extended Object</em>}</li>
 *   <li>{@link org.eclipse.bpel.common.extension.model.impl.ExtensionImpl#getExtensionObject <em>Extension Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionImpl extends EObjectImpl implements Extension {
	/**
	 * The cached value of the '{@link #getExtendedObject() <em>Extended Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedObject()
	 * @generated
	 * @ordered
	 */
	protected EObject extendedObject = null;

	/**
	 * The cached value of the '{@link #getExtensionObject() <em>Extension Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionObject()
	 * @generated
	 * @ordered
	 */
	protected EObject extensionObject = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtensionmodelPackage.eINSTANCE.getExtension();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getExtendedObject() {
		if (extendedObject != null && extendedObject.eIsProxy()) {
			EObject oldExtendedObject = extendedObject;
			extendedObject = eResolveProxy((InternalEObject)extendedObject);
			if (extendedObject != oldExtendedObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtensionmodelPackage.EXTENSION__EXTENDED_OBJECT, oldExtendedObject, extendedObject));
			}
		}
		return extendedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetExtendedObject() {
		return extendedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedObject(EObject newExtendedObject) {
		EObject oldExtendedObject = extendedObject;
		extendedObject = newExtendedObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensionmodelPackage.EXTENSION__EXTENDED_OBJECT, oldExtendedObject, extendedObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getExtensionObject() {
		return extensionObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionObject(EObject newExtensionObject, NotificationChain msgs) {
		EObject oldExtensionObject = extensionObject;
		extensionObject = newExtensionObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExtensionmodelPackage.EXTENSION__EXTENSION_OBJECT, oldExtensionObject, newExtensionObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionObject(EObject newExtensionObject) {
		if (newExtensionObject != extensionObject) {
			NotificationChain msgs = null;
			if (extensionObject != null)
				msgs = ((InternalEObject)extensionObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExtensionmodelPackage.EXTENSION__EXTENSION_OBJECT, null, msgs);
			if (newExtensionObject != null)
				msgs = ((InternalEObject)newExtensionObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExtensionmodelPackage.EXTENSION__EXTENSION_OBJECT, null, msgs);
			msgs = basicSetExtensionObject(newExtensionObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensionmodelPackage.EXTENSION__EXTENSION_OBJECT, newExtensionObject, newExtensionObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExtensionmodelPackage.EXTENSION__EXTENSION_OBJECT:
					return basicSetExtensionObject(null, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExtensionmodelPackage.EXTENSION__EXTENDED_OBJECT:
				if (resolve) return getExtendedObject();
				return basicGetExtendedObject();
			case ExtensionmodelPackage.EXTENSION__EXTENSION_OBJECT:
				return getExtensionObject();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExtensionmodelPackage.EXTENSION__EXTENDED_OBJECT:
				setExtendedObject((EObject)newValue);
				return;
			case ExtensionmodelPackage.EXTENSION__EXTENSION_OBJECT:
				setExtensionObject((EObject)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExtensionmodelPackage.EXTENSION__EXTENDED_OBJECT:
				setExtendedObject((EObject)null);
				return;
			case ExtensionmodelPackage.EXTENSION__EXTENSION_OBJECT:
				setExtensionObject((EObject)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExtensionmodelPackage.EXTENSION__EXTENDED_OBJECT:
				return extendedObject != null;
			case ExtensionmodelPackage.EXTENSION__EXTENSION_OBJECT:
				return extensionObject != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //ExtensionImpl
