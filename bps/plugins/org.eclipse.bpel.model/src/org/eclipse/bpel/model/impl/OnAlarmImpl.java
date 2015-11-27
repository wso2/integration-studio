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
 * $Id: OnAlarmImpl.java,v 1.10 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.OnAlarm;
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
 * An implementation of the model object '<em><b>On Alarm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.OnAlarmImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnAlarmImpl#getFor <em>For</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnAlarmImpl#getUntil <em>Until</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnAlarmImpl#getRepeatEvery <em>Repeat Every</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OnAlarmImpl extends BPELExtensibleElementImpl implements OnAlarm {
	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected Activity activity;

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
	 * The cached value of the '{@link #getRepeatEvery() <em>Repeat Every</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepeatEvery()
	 * @generated
	 * @ordered
	 */
	protected Expression repeatEvery;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OnAlarmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.ON_ALARM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetActivity(Activity newActivity,
			NotificationChain msgs) {
		Activity oldActivity = activity;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldActivity, newActivity);
		}
		activity = newActivity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.ON_ALARM__ACTIVITY,
					oldActivity, newActivity);
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
	public void setActivity(Activity newActivity) {
		if (newActivity != activity) {
			NotificationChain msgs = null;
			if (activity != null)
				msgs = ((InternalEObject) activity)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_ALARM__ACTIVITY, null, msgs);
			if (newActivity != null)
				msgs = ((InternalEObject) newActivity)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_ALARM__ACTIVITY, null, msgs);
			msgs = basicSetActivity(newActivity, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_ALARM__ACTIVITY, newActivity, newActivity));
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
					Notification.SET, BPELPackage.ON_ALARM__FOR, oldFor, newFor);
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
						EOPPOSITE_FEATURE_BASE - BPELPackage.ON_ALARM__FOR,
						null, msgs);
			if (newFor != null)
				msgs = ((InternalEObject) newFor).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.ON_ALARM__FOR,
						null, msgs);
			msgs = basicSetFor(newFor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_ALARM__FOR, newFor, newFor));
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
					Notification.SET, BPELPackage.ON_ALARM__UNTIL, oldUntil,
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
						EOPPOSITE_FEATURE_BASE - BPELPackage.ON_ALARM__UNTIL,
						null, msgs);
			if (newUntil != null)
				msgs = ((InternalEObject) newUntil).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.ON_ALARM__UNTIL,
						null, msgs);
			msgs = basicSetUntil(newUntil, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_ALARM__UNTIL, newUntil, newUntil));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRepeatEvery() {
		return repeatEvery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetRepeatEvery(Expression newRepeatEvery,
			NotificationChain msgs) {
		Expression oldRepeatEvery = repeatEvery;
		if (!isReconciling) {
			if (newRepeatEvery != null && newRepeatEvery.getElement() == null
					&& !ReconciliationHelper.isLoading(this)) {
				newRepeatEvery.setElement(ElementFactory.getInstance()
						.createExpressionElement(newRepeatEvery, this,
								BPELConstants.ND_REPEAT_EVERY));
			}
			ReconciliationHelper.replaceChild(this, oldRepeatEvery,
					newRepeatEvery);
		}
		repeatEvery = newRepeatEvery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.ON_ALARM__REPEAT_EVERY,
					oldRepeatEvery, newRepeatEvery);
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
	public void setRepeatEvery(Expression newRepeatEvery) {
		if (newRepeatEvery != repeatEvery) {
			NotificationChain msgs = null;
			if (repeatEvery != null)
				msgs = ((InternalEObject) repeatEvery).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_ALARM__REPEAT_EVERY, null,
						msgs);
			if (newRepeatEvery != null)
				msgs = ((InternalEObject) newRepeatEvery).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_ALARM__REPEAT_EVERY, null,
						msgs);
			msgs = basicSetRepeatEvery(newRepeatEvery, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_ALARM__REPEAT_EVERY, newRepeatEvery,
					newRepeatEvery));
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
		case BPELPackage.ON_ALARM__ACTIVITY:
			return basicSetActivity(null, msgs);
		case BPELPackage.ON_ALARM__FOR:
			return basicSetFor(null, msgs);
		case BPELPackage.ON_ALARM__UNTIL:
			return basicSetUntil(null, msgs);
		case BPELPackage.ON_ALARM__REPEAT_EVERY:
			return basicSetRepeatEvery(null, msgs);
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
		case BPELPackage.ON_ALARM__ACTIVITY:
			return getActivity();
		case BPELPackage.ON_ALARM__FOR:
			return getFor();
		case BPELPackage.ON_ALARM__UNTIL:
			return getUntil();
		case BPELPackage.ON_ALARM__REPEAT_EVERY:
			return getRepeatEvery();
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
		case BPELPackage.ON_ALARM__ACTIVITY:
			setActivity((Activity) newValue);
			return;
		case BPELPackage.ON_ALARM__FOR:
			setFor((Expression) newValue);
			return;
		case BPELPackage.ON_ALARM__UNTIL:
			setUntil((Expression) newValue);
			return;
		case BPELPackage.ON_ALARM__REPEAT_EVERY:
			setRepeatEvery((Expression) newValue);
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
		case BPELPackage.ON_ALARM__ACTIVITY:
			setActivity((Activity) null);
			return;
		case BPELPackage.ON_ALARM__FOR:
			setFor((Expression) null);
			return;
		case BPELPackage.ON_ALARM__UNTIL:
			setUntil((Expression) null);
			return;
		case BPELPackage.ON_ALARM__REPEAT_EVERY:
			setRepeatEvery((Expression) null);
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
		case BPELPackage.ON_ALARM__ACTIVITY:
			return activity != null;
		case BPELPackage.ON_ALARM__FOR:
			return for_ != null;
		case BPELPackage.ON_ALARM__UNTIL:
			return until != null;
		case BPELPackage.ON_ALARM__REPEAT_EVERY:
			return repeatEvery != null;
		}
		return super.eIsSet(featureID);
	}

} //OnAlarmImpl
