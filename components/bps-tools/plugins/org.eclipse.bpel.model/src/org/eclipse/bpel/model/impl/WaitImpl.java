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
 * $Id: WaitImpl.java,v 1.9 2009/04/14 10:50:36 smoser Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.Wait;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ElementFactory;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wait</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.WaitImpl#getFor <em>For</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.WaitImpl#getUntil <em>Until</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WaitImpl extends ActivityImpl implements Wait {
	/**
	 * The cached value of the '{@link #getFor() <em>For</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFor()
	 * @generated
	 * @ordered
	 */
	protected Expression for_;

	/**
	 * The cached value of the '{@link #getUntil() <em>Until</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUntil()
	 * @generated
	 * @ordered
	 */
	protected Expression until;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WaitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.WAIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getFor() {
		return for_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetFor(Expression newFor,
			NotificationChain msgs) {
		Expression oldFor = for_;
		if (!isReconciling) {
			if (newFor != null && newFor.getElement() == null
					&& !ReconciliationHelper.isLoading(this)) {
				newFor.setElement(ElementFactory.getInstance()
						.createExpressionElement(newFor, this,
								BPELConstants.ND_FOR));
			}
			ReconciliationHelper.replaceChild(this, oldFor, newFor);
		}
		for_ = newFor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.WAIT__FOR, oldFor, newFor);
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
	public void setFor(Expression newFor) {
		if (newFor != for_) {
			NotificationChain msgs = null;
			if (for_ != null)
				msgs = ((InternalEObject) for_).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.WAIT__FOR, null,
						msgs);
			if (newFor != null)
				msgs = ((InternalEObject) newFor).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.WAIT__FOR, null,
						msgs);
			msgs = basicSetFor(newFor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.WAIT__FOR, newFor, newFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getUntil() {
		return until;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetUntil(Expression newUntil,
			NotificationChain msgs) {
		Expression oldUntil = until;
		if (!isReconciling) {
			if (newUntil != null && newUntil.getElement() == null
					&& !ReconciliationHelper.isLoading(this)) {
				newUntil.setElement(ElementFactory.getInstance()
						.createExpressionElement(newUntil, this,
								BPELConstants.ND_UNTIL));
			}
			ReconciliationHelper.replaceChild(this, oldUntil, newUntil);
		}

		until = newUntil;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.WAIT__UNTIL, oldUntil,
					newUntil);
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
	public void setUntil(Expression newUntil) {
		if (newUntil != until) {
			NotificationChain msgs = null;
			if (until != null)
				msgs = ((InternalEObject) until).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.WAIT__UNTIL, null,
						msgs);
			if (newUntil != null)
				msgs = ((InternalEObject) newUntil).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.WAIT__UNTIL, null,
						msgs);
			msgs = basicSetUntil(newUntil, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.WAIT__UNTIL, newUntil, newUntil));
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
		case BPELPackage.WAIT__FOR:
			return basicSetFor(null, msgs);
		case BPELPackage.WAIT__UNTIL:
			return basicSetUntil(null, msgs);
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
		case BPELPackage.WAIT__FOR:
			return getFor();
		case BPELPackage.WAIT__UNTIL:
			return getUntil();
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
		case BPELPackage.WAIT__FOR:
			setFor((Expression) newValue);
			return;
		case BPELPackage.WAIT__UNTIL:
			setUntil((Expression) newValue);
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
		case BPELPackage.WAIT__FOR:
			setFor((Expression) null);
			return;
		case BPELPackage.WAIT__UNTIL:
			setUntil((Expression) null);
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
		case BPELPackage.WAIT__FOR:
			return for_ != null;
		case BPELPackage.WAIT__UNTIL:
			return until != null;
		}
		return super.eIsSet(featureID);
	}

} //WaitImpl
