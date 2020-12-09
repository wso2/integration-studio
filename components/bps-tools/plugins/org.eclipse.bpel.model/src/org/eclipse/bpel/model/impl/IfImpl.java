/**
 * <copyright>
 * </copyright>
 *
 * $Id: IfImpl.java,v 1.9 2009/04/14 10:50:37 smoser Exp $
 */
package org.eclipse.bpel.model.impl;

import java.util.Collection;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Condition;
import org.eclipse.bpel.model.Else;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.IfImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.IfImpl#getElseIf <em>Else If</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.IfImpl#getElse <em>Else</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.IfImpl#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfImpl extends ActivityImpl implements If {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Condition condition;

	/**
	 * The cached value of the '{@link #getElseIf() <em>Else If</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseIf()
	 * @generated
	 * @ordered
	 */
	protected EList<ElseIf> elseIf;

	/**
	 * The cached value of the '{@link #getElse() <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElse()
	 * @generated
	 * @ordered
	 */
	protected Else else_;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.IF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetCondition(Condition newCondition,
			NotificationChain msgs) {
		Condition oldCondition = condition;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldCondition, newCondition);
		}
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.IF__CONDITION, oldCondition,
					newCondition);
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
	public void setCondition(Condition newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject) condition).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.IF__CONDITION,
						null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject) newCondition).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.IF__CONDITION,
						null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.IF__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElseIf> getElseIf() {
		if (elseIf == null) {
			elseIf = new EObjectContainmentEList<ElseIf>(ElseIf.class, this,
					BPELPackage.IF__ELSE_IF);
		}
		return elseIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Else getElse() {
		return else_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetElse(Else newElse, NotificationChain msgs) {
		Else oldElse = else_;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldElse, newElse);
		}
		else_ = newElse;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.IF__ELSE, oldElse, newElse);
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
	public void setElse(Else newElse) {
		if (newElse != else_) {
			NotificationChain msgs = null;
			if (else_ != null)
				msgs = ((InternalEObject) else_).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.IF__ELSE, null,
						msgs);
			if (newElse != null)
				msgs = ((InternalEObject) newElse).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.IF__ELSE, null,
						msgs);
			msgs = basicSetElse(newElse, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.IF__ELSE, newElse, newElse));
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
					Notification.SET, BPELPackage.IF__ACTIVITY, oldActivity,
					newActivity);
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
				msgs = ((InternalEObject) activity).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.IF__ACTIVITY,
						null, msgs);
			if (newActivity != null)
				msgs = ((InternalEObject) newActivity).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.IF__ACTIVITY,
						null, msgs);
			msgs = basicSetActivity(newActivity, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.IF__ACTIVITY, newActivity, newActivity));
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
		case BPELPackage.IF__CONDITION:
			return basicSetCondition(null, msgs);
		case BPELPackage.IF__ELSE_IF:
			return ((InternalEList<?>) getElseIf()).basicRemove(otherEnd, msgs);
		case BPELPackage.IF__ELSE:
			return basicSetElse(null, msgs);
		case BPELPackage.IF__ACTIVITY:
			return basicSetActivity(null, msgs);
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
		case BPELPackage.IF__CONDITION:
			return getCondition();
		case BPELPackage.IF__ELSE_IF:
			return getElseIf();
		case BPELPackage.IF__ELSE:
			return getElse();
		case BPELPackage.IF__ACTIVITY:
			return getActivity();
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
		case BPELPackage.IF__CONDITION:
			setCondition((Condition) newValue);
			return;
		case BPELPackage.IF__ELSE_IF:
			getElseIf().clear();
			getElseIf().addAll((Collection<? extends ElseIf>) newValue);
			return;
		case BPELPackage.IF__ELSE:
			setElse((Else) newValue);
			return;
		case BPELPackage.IF__ACTIVITY:
			setActivity((Activity) newValue);
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
		case BPELPackage.IF__CONDITION:
			setCondition((Condition) null);
			return;
		case BPELPackage.IF__ELSE_IF:
			getElseIf().clear();
			return;
		case BPELPackage.IF__ELSE:
			setElse((Else) null);
			return;
		case BPELPackage.IF__ACTIVITY:
			setActivity((Activity) null);
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
		case BPELPackage.IF__CONDITION:
			return condition != null;
		case BPELPackage.IF__ELSE_IF:
			return elseIf != null && !elseIf.isEmpty();
		case BPELPackage.IF__ELSE:
			return else_ != null;
		case BPELPackage.IF__ACTIVITY:
			return activity != null;
		}
		return super.eIsSet(featureID);
	}

} //IfImpl
