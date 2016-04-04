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
 * $Id: ServiceRefImpl.java,v 1.13 2009/04/14 10:50:37 smoser Exp $
 */
package org.eclipse.bpel.model.impl;

import javax.wsdl.extensions.ExtensibilityElement;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.ServiceRef;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ElementFactory;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.wst.wsdl.internal.impl.ExtensibleElementImpl;
import org.w3c.dom.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ServiceRefImpl#getReferenceScheme <em>Reference Scheme</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ServiceRefImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceRefImpl extends ExtensibleElementImpl implements ServiceRef {
	/**
	 * The default value of the '{@link #getReferenceScheme() <em>Reference Scheme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceScheme()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCE_SCHEME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferenceScheme() <em>Reference Scheme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceScheme()
	 * @generated
	 * @ordered
	 */
	protected String referenceScheme = REFERENCE_SCHEME_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

	private Node valueNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.SERVICE_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferenceScheme() {
		return referenceScheme;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setReferenceScheme(String newReferenceScheme) {
		String oldReferenceScheme = referenceScheme;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_REFERENCE_SCHEME, newReferenceScheme);
		}
		referenceScheme = newReferenceScheme;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SERVICE_REF__REFERENCE_SCHEME,
					oldReferenceScheme, referenceScheme));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Object getValue() {
		if (!isReconciling && getElement() != null) {
			ReconciliationHelper.getInstance().reconcile(this, getElement());
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (!isReconciling && oldValue != newValue) {
			valueNode = ReconciliationHelper.replaceValue(this, valueNode,
					newValue);
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.SERVICE_REF__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BPELPackage.SERVICE_REF__REFERENCE_SCHEME:
			return getReferenceScheme();
		case BPELPackage.SERVICE_REF__VALUE:
			return getValue();
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
		case BPELPackage.SERVICE_REF__REFERENCE_SCHEME:
			setReferenceScheme((String) newValue);
			return;
		case BPELPackage.SERVICE_REF__VALUE:
			setValue(newValue);
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
		case BPELPackage.SERVICE_REF__REFERENCE_SCHEME:
			setReferenceScheme(REFERENCE_SCHEME_EDEFAULT);
			return;
		case BPELPackage.SERVICE_REF__VALUE:
			setValue(VALUE_EDEFAULT);
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
		case BPELPackage.SERVICE_REF__REFERENCE_SCHEME:
			return REFERENCE_SCHEME_EDEFAULT == null ? referenceScheme != null
					: !REFERENCE_SCHEME_EDEFAULT.equals(referenceScheme);
		case BPELPackage.SERVICE_REF__VALUE:
			return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT
					.equals(value);
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
		result.append(" (referenceScheme: "); //$NON-NLS-1$
		result.append(referenceScheme);
		result.append(", value: "); //$NON-NLS-1$
		result.append(value);
		result.append(')');
		return result.toString();
	}

	//	@Override
	public ExtensibilityElement removeExtensibilityElement(
			ExtensibilityElement arg0) {
		// TODO Auto-generated method stub
		return null;
	}

} //ServiceRefImpl
