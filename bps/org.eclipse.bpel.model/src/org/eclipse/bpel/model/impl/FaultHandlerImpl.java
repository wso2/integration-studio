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
 * $Id: FaultHandlerImpl.java,v 1.10 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import java.util.Collection;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.CatchAll;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.wst.wsdl.WSDLElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fault Handler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.FaultHandlerImpl#getCatch <em>Catch</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FaultHandlerImpl#getCatchAll <em>Catch All</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FaultHandlerImpl extends BPELExtensibleElementImpl implements
		FaultHandler {
	/**
	 * The cached value of the '{@link #getCatch() <em>Catch</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatch()
	 * @generated
	 * @ordered
	 */
	protected EList<Catch> catch_;

	/**
	 * The cached value of the '{@link #getCatchAll() <em>Catch All</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatchAll()
	 * @generated
	 * @ordered
	 */
	protected CatchAll catchAll;

	/**
	 * This is true if the Catch All containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean catchAllESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FaultHandlerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.FAULT_HANDLER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Catch> getCatch() {
		if (catch_ == null) {
			catch_ = new EObjectContainmentEList<Catch>(Catch.class, this,
					BPELPackage.FAULT_HANDLER__CATCH);
		}
		return catch_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CatchAll getCatchAll() {
		return catchAll;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetCatchAll(CatchAll newCatchAll,
			NotificationChain msgs) {
		CatchAll oldCatchAll = catchAll;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(
					element == null ? (WSDLElement) eContainer() : this,
					oldCatchAll, newCatchAll);
		}
		catchAll = newCatchAll;
		boolean oldCatchAllESet = catchAllESet;
		catchAllESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.FAULT_HANDLER__CATCH_ALL,
					oldCatchAll, newCatchAll, !oldCatchAllESet);
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
	public void setCatchAll(CatchAll newCatchAll) {
		if (newCatchAll != catchAll) {
			NotificationChain msgs = null;
			if (catchAll != null)
				msgs = ((InternalEObject) catchAll).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.FAULT_HANDLER__CATCH_ALL, null,
						msgs);
			if (newCatchAll != null)
				msgs = ((InternalEObject) newCatchAll).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.FAULT_HANDLER__CATCH_ALL, null,
						msgs);
			msgs = basicSetCatchAll(newCatchAll, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else {
			boolean oldCatchAllESet = catchAllESet;
			catchAllESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						BPELPackage.FAULT_HANDLER__CATCH_ALL, newCatchAll,
						newCatchAll, !oldCatchAllESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicUnsetCatchAll(NotificationChain msgs) {
		CatchAll oldCatchAll = catchAll;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldCatchAll, null);
		}
		catchAll = null;
		boolean oldCatchAllESet = catchAllESet;
		catchAllESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.UNSET, BPELPackage.FAULT_HANDLER__CATCH_ALL,
					oldCatchAll, null, oldCatchAllESet);
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
	public void unsetCatchAll() {
		if (catchAll != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject) catchAll).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
							- BPELPackage.FAULT_HANDLER__CATCH_ALL, null, msgs);
			msgs = basicUnsetCatchAll(msgs);
			if (msgs != null)
				msgs.dispatch();
		} else {
			boolean oldCatchAllESet = catchAllESet;
			catchAllESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET,
						BPELPackage.FAULT_HANDLER__CATCH_ALL, null, null,
						oldCatchAllESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCatchAll() {
		return catchAllESet;
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
		case BPELPackage.FAULT_HANDLER__CATCH:
			return ((InternalEList<?>) getCatch()).basicRemove(otherEnd, msgs);
		case BPELPackage.FAULT_HANDLER__CATCH_ALL:
			return basicUnsetCatchAll(msgs);
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
		case BPELPackage.FAULT_HANDLER__CATCH:
			return getCatch();
		case BPELPackage.FAULT_HANDLER__CATCH_ALL:
			return getCatchAll();
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
		case BPELPackage.FAULT_HANDLER__CATCH:
			getCatch().clear();
			getCatch().addAll((Collection<? extends Catch>) newValue);
			return;
		case BPELPackage.FAULT_HANDLER__CATCH_ALL:
			setCatchAll((CatchAll) newValue);
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
		case BPELPackage.FAULT_HANDLER__CATCH:
			getCatch().clear();
			return;
		case BPELPackage.FAULT_HANDLER__CATCH_ALL:
			unsetCatchAll();
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
		case BPELPackage.FAULT_HANDLER__CATCH:
			return catch_ != null && !catch_.isEmpty();
		case BPELPackage.FAULT_HANDLER__CATCH_ALL:
			return isSetCatchAll();
		}
		return super.eIsSet(featureID);
	}

	@Override
	protected void adoptContent(EReference reference, Object object) {
		if (object instanceof Catch) {
			ReconciliationHelper.adoptChild(
					element == null ? (WSDLElement) eContainer() : this,
					catch_, (Catch) object, BPELConstants.ND_CATCH);
		}
		super.adoptContent(reference, object);
	}

	@Override
	protected void orphanContent(EReference reference, Object obj) {
		if (obj instanceof Catch) {
			ReconciliationHelper.orphanChild(
					element == null ? (WSDLElement) eContainer() : this,
					(Catch) obj);
		}
		super.orphanContent(reference, obj);
	}

} //FaultHandlerImpl
