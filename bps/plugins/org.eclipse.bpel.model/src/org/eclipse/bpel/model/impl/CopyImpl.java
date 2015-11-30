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
 * $Id: CopyImpl.java,v 1.12 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Copy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.CopyImpl#getTo <em>To</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.CopyImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.CopyImpl#getKeepSrcElementName <em>Keep Src Element Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.CopyImpl#getIgnoreMissingFromData <em>Ignore Missing From Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CopyImpl extends BPELExtensibleElementImpl implements Copy {
	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected To to;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected From from;

	/**
	 * The default value of the '{@link #getKeepSrcElementName() <em>Keep Src Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeepSrcElementName()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean KEEP_SRC_ELEMENT_NAME_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getKeepSrcElementName() <em>Keep Src Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeepSrcElementName()
	 * @generated
	 * @ordered
	 */
	protected Boolean keepSrcElementName = KEEP_SRC_ELEMENT_NAME_EDEFAULT;

	/**
	 * This is true if the Keep Src Element Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean keepSrcElementNameESet;

	/**
	 * The default value of the '{@link #getIgnoreMissingFromData() <em>Ignore Missing From Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnoreMissingFromData()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean IGNORE_MISSING_FROM_DATA_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getIgnoreMissingFromData() <em>Ignore Missing From Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnoreMissingFromData()
	 * @generated
	 * @ordered
	 */
	protected Boolean ignoreMissingFromData = IGNORE_MISSING_FROM_DATA_EDEFAULT;

	/**
	 * This is true if the Ignore Missing From Data attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreMissingFromDataESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CopyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.COPY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public To getTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetTo(To newTo, NotificationChain msgs) {
		To oldTo = to;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldTo, newTo);
		}
		to = newTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.COPY__TO, oldTo, newTo);
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
	public void setTo(To newTo) {
		if (newTo != to) {
			NotificationChain msgs = null;
			if (to != null)
				msgs = ((InternalEObject) to).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.COPY__TO, null,
						msgs);
			if (newTo != null)
				msgs = ((InternalEObject) newTo).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.COPY__TO, null,
						msgs);
			msgs = basicSetTo(newTo, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.COPY__TO, newTo, newTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public From getFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetFrom(From newFrom, NotificationChain msgs) {
		From oldFrom = from;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldFrom, newFrom);
		}
		from = newFrom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.COPY__FROM, oldFrom, newFrom);
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
	public void setFrom(From newFrom) {
		if (newFrom != from) {
			NotificationChain msgs = null;
			if (from != null)
				msgs = ((InternalEObject) from).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.COPY__FROM, null,
						msgs);
			if (newFrom != null)
				msgs = ((InternalEObject) newFrom).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.COPY__FROM, null,
						msgs);
			msgs = basicSetFrom(newFrom, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.COPY__FROM, newFrom, newFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getKeepSrcElementName() {
		return keepSrcElementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setKeepSrcElementName(Boolean newKeepSrcElementName) {
		Boolean oldKeepSrcElementName = keepSrcElementName;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_KEEP_SRC_ELEMENT_NAME,
					BPELUtils.boolean2XML(newKeepSrcElementName));
		}
		keepSrcElementName = newKeepSrcElementName;
		boolean oldKeepSrcElementNameESet = keepSrcElementNameESet;
		keepSrcElementNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.COPY__KEEP_SRC_ELEMENT_NAME,
					oldKeepSrcElementName, keepSrcElementName,
					!oldKeepSrcElementNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetKeepSrcElementName() {
		Boolean oldKeepSrcElementName = keepSrcElementName;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_KEEP_SRC_ELEMENT_NAME, (String) null);
		}
		boolean oldKeepSrcElementNameESet = keepSrcElementNameESet;
		keepSrcElementName = KEEP_SRC_ELEMENT_NAME_EDEFAULT;
		keepSrcElementNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.COPY__KEEP_SRC_ELEMENT_NAME,
					oldKeepSrcElementName, KEEP_SRC_ELEMENT_NAME_EDEFAULT,
					oldKeepSrcElementNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetKeepSrcElementName() {
		return keepSrcElementNameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIgnoreMissingFromData() {
		return ignoreMissingFromData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setIgnoreMissingFromData(Boolean newIgnoreMissingFromData) {
		Boolean oldIgnoreMissingFromData = ignoreMissingFromData;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_IGNORE_MISSING_FROM_DATA,
					BPELUtils.boolean2XML(newIgnoreMissingFromData));
		}
		ignoreMissingFromData = newIgnoreMissingFromData;
		boolean oldIgnoreMissingFromDataESet = ignoreMissingFromDataESet;
		ignoreMissingFromDataESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.COPY__IGNORE_MISSING_FROM_DATA,
					oldIgnoreMissingFromData, ignoreMissingFromData,
					!oldIgnoreMissingFromDataESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetIgnoreMissingFromData() {
		Boolean oldIgnoreMissingFromData = ignoreMissingFromData;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_IGNORE_MISSING_FROM_DATA, (String) null);
		}
		boolean oldIgnoreMissingFromDataESet = ignoreMissingFromDataESet;
		ignoreMissingFromData = IGNORE_MISSING_FROM_DATA_EDEFAULT;
		ignoreMissingFromDataESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.COPY__IGNORE_MISSING_FROM_DATA,
					oldIgnoreMissingFromData,
					IGNORE_MISSING_FROM_DATA_EDEFAULT,
					oldIgnoreMissingFromDataESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIgnoreMissingFromData() {
		return ignoreMissingFromDataESet;
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
		case BPELPackage.COPY__TO:
			return basicSetTo(null, msgs);
		case BPELPackage.COPY__FROM:
			return basicSetFrom(null, msgs);
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
		case BPELPackage.COPY__TO:
			return getTo();
		case BPELPackage.COPY__FROM:
			return getFrom();
		case BPELPackage.COPY__KEEP_SRC_ELEMENT_NAME:
			return getKeepSrcElementName();
		case BPELPackage.COPY__IGNORE_MISSING_FROM_DATA:
			return getIgnoreMissingFromData();
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
		case BPELPackage.COPY__TO:
			setTo((To) newValue);
			return;
		case BPELPackage.COPY__FROM:
			setFrom((From) newValue);
			return;
		case BPELPackage.COPY__KEEP_SRC_ELEMENT_NAME:
			setKeepSrcElementName((Boolean) newValue);
			return;
		case BPELPackage.COPY__IGNORE_MISSING_FROM_DATA:
			setIgnoreMissingFromData((Boolean) newValue);
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
		case BPELPackage.COPY__TO:
			setTo((To) null);
			return;
		case BPELPackage.COPY__FROM:
			setFrom((From) null);
			return;
		case BPELPackage.COPY__KEEP_SRC_ELEMENT_NAME:
			unsetKeepSrcElementName();
			return;
		case BPELPackage.COPY__IGNORE_MISSING_FROM_DATA:
			unsetIgnoreMissingFromData();
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
		case BPELPackage.COPY__TO:
			return to != null;
		case BPELPackage.COPY__FROM:
			return from != null;
		case BPELPackage.COPY__KEEP_SRC_ELEMENT_NAME:
			return isSetKeepSrcElementName();
		case BPELPackage.COPY__IGNORE_MISSING_FROM_DATA:
			return isSetIgnoreMissingFromData();
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
		result.append(" (keepSrcElementName: "); //$NON-NLS-1$
		if (keepSrcElementNameESet)
			result.append(keepSrcElementName);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", ignoreMissingFromData: "); //$NON-NLS-1$
		if (ignoreMissingFromDataESet)
			result.append(ignoreMissingFromData);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //CopyImpl
