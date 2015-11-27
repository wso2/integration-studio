/**
 * <copyright>
 * </copyright>
 *
 * $Id: ForEachImpl.java,v 1.15 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.CompletionCondition;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ElementFactory;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Each</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ForEachImpl#getStartCounterValue <em>Start Counter Value</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ForEachImpl#getFinalCounterValue <em>Final Counter Value</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ForEachImpl#getParallel <em>Parallel</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ForEachImpl#getCounterName <em>Counter Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ForEachImpl#getCompletionCondition <em>Completion Condition</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ForEachImpl#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForEachImpl extends ActivityImpl implements ForEach {
	/**
	 * The cached value of the '{@link #getStartCounterValue() <em>Start Counter Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartCounterValue()
	 * @generated
	 * @ordered
	 */
	protected Expression startCounterValue;

	/**
	 * The cached value of the '{@link #getFinalCounterValue() <em>Final Counter Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalCounterValue()
	 * @generated
	 * @ordered
	 */
	protected Expression finalCounterValue;

	/**
	 * The default value of the '{@link #getParallel() <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParallel()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean PARALLEL_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getParallel() <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParallel()
	 * @generated
	 * @ordered
	 */
	protected Boolean parallel = PARALLEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCounterName() <em>Counter Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCounterName()
	 * @generated
	 * @ordered
	 */
	protected Variable counterName;

	/**
	 * The cached value of the '{@link #getCompletionCondition() <em>Completion Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionCondition()
	 * @generated
	 * @ordered
	 */
	protected CompletionCondition completionCondition;

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
	protected ForEachImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.FOR_EACH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getStartCounterValue() {
		return startCounterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetStartCounterValue(
			Expression newStartCounterValue, NotificationChain msgs) {
		Expression oldStartCounterValue = startCounterValue;
		if (!isReconciling) {
			if (newStartCounterValue != null
					&& newStartCounterValue.getElement() == null
					&& !ReconciliationHelper.isLoading(this)) {
				newStartCounterValue.setElement(ElementFactory.getInstance()
						.createExpressionElement(newStartCounterValue, this,
								BPELConstants.ND_START_COUNTER_VALUE));
			}
			ReconciliationHelper.replaceChild(this, oldStartCounterValue,
					newStartCounterValue);
		}
		startCounterValue = newStartCounterValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					BPELPackage.FOR_EACH__START_COUNTER_VALUE,
					oldStartCounterValue, newStartCounterValue);
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
	public void setStartCounterValue(Expression newStartCounterValue) {
		if (newStartCounterValue != startCounterValue) {
			NotificationChain msgs = null;
			if (startCounterValue != null)
				msgs = ((InternalEObject) startCounterValue).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.FOR_EACH__START_COUNTER_VALUE,
						null, msgs);
			if (newStartCounterValue != null)
				msgs = ((InternalEObject) newStartCounterValue).eInverseAdd(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.FOR_EACH__START_COUNTER_VALUE,
						null, msgs);
			msgs = basicSetStartCounterValue(newStartCounterValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FOR_EACH__START_COUNTER_VALUE,
					newStartCounterValue, newStartCounterValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getFinalCounterValue() {
		return finalCounterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetFinalCounterValue(
			Expression newFinalCounterValue, NotificationChain msgs) {
		Expression oldFinalCounterValue = finalCounterValue;
		if (!isReconciling) {
			if (newFinalCounterValue != null
					&& newFinalCounterValue.getElement() == null
					&& !ReconciliationHelper.isLoading(this)) {
				newFinalCounterValue.setElement(ElementFactory.getInstance()
						.createExpressionElement(newFinalCounterValue, this,
								BPELConstants.ND_FINAL_COUNTER_VALUE));
			}
			ReconciliationHelper.replaceChild(this, oldFinalCounterValue,
					newFinalCounterValue);
		}

		finalCounterValue = newFinalCounterValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					BPELPackage.FOR_EACH__FINAL_COUNTER_VALUE,
					oldFinalCounterValue, newFinalCounterValue);
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
	public void setFinalCounterValue(Expression newFinalCounterValue) {
		if (newFinalCounterValue != finalCounterValue) {
			NotificationChain msgs = null;
			if (finalCounterValue != null)
				msgs = ((InternalEObject) finalCounterValue).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.FOR_EACH__FINAL_COUNTER_VALUE,
						null, msgs);
			if (newFinalCounterValue != null)
				msgs = ((InternalEObject) newFinalCounterValue).eInverseAdd(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.FOR_EACH__FINAL_COUNTER_VALUE,
						null, msgs);
			msgs = basicSetFinalCounterValue(newFinalCounterValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FOR_EACH__FINAL_COUNTER_VALUE,
					newFinalCounterValue, newFinalCounterValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getParallel() {
		return parallel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setParallel(Boolean newParallel) {
		Boolean oldParallel = parallel;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_PARALLEL,
					BPELUtils.boolean2XML(newParallel));
		}
		parallel = newParallel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FOR_EACH__PARALLEL, oldParallel, parallel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getCounterName() {
		return counterName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetCounterName(Variable newCounterName,
			NotificationChain msgs) {
		Variable oldCounterName = counterName;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_COUNTER_NAME,
					newCounterName != null ? newCounterName.getName() : null);
		}
		counterName = newCounterName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.FOR_EACH__COUNTER_NAME,
					oldCounterName, newCounterName);
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
	public void setCounterName(Variable newCounterName) {
		if (newCounterName != counterName) {
			NotificationChain msgs = null;
			if (counterName != null)
				msgs = ((InternalEObject) counterName).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.FOR_EACH__COUNTER_NAME, null,
						msgs);
			if (newCounterName != null)
				msgs = ((InternalEObject) newCounterName).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.FOR_EACH__COUNTER_NAME, null,
						msgs);
			msgs = basicSetCounterName(newCounterName, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FOR_EACH__COUNTER_NAME, newCounterName,
					newCounterName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionCondition getCompletionCondition() {
		return completionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetCompletionCondition(
			CompletionCondition newCompletionCondition, NotificationChain msgs) {
		CompletionCondition oldCompletionCondition = completionCondition;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldCompletionCondition,
					newCompletionCondition);
		}
		completionCondition = newCompletionCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					BPELPackage.FOR_EACH__COMPLETION_CONDITION,
					oldCompletionCondition, newCompletionCondition);
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
	public void setCompletionCondition(
			CompletionCondition newCompletionCondition) {
		if (newCompletionCondition != completionCondition) {
			NotificationChain msgs = null;
			if (completionCondition != null)
				msgs = ((InternalEObject) completionCondition).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.FOR_EACH__COMPLETION_CONDITION,
						null, msgs);
			if (newCompletionCondition != null)
				msgs = ((InternalEObject) newCompletionCondition).eInverseAdd(
						this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.FOR_EACH__COMPLETION_CONDITION,
						null, msgs);
			msgs = basicSetCompletionCondition(newCompletionCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FOR_EACH__COMPLETION_CONDITION,
					newCompletionCondition, newCompletionCondition));
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
					Notification.SET, BPELPackage.FOR_EACH__ACTIVITY,
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
								- BPELPackage.FOR_EACH__ACTIVITY, null, msgs);
			if (newActivity != null)
				msgs = ((InternalEObject) newActivity)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.FOR_EACH__ACTIVITY, null, msgs);
			msgs = basicSetActivity(newActivity, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FOR_EACH__ACTIVITY, newActivity, newActivity));
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
		case BPELPackage.FOR_EACH__START_COUNTER_VALUE:
			return basicSetStartCounterValue(null, msgs);
		case BPELPackage.FOR_EACH__FINAL_COUNTER_VALUE:
			return basicSetFinalCounterValue(null, msgs);
		case BPELPackage.FOR_EACH__COUNTER_NAME:
			return basicSetCounterName(null, msgs);
		case BPELPackage.FOR_EACH__COMPLETION_CONDITION:
			return basicSetCompletionCondition(null, msgs);
		case BPELPackage.FOR_EACH__ACTIVITY:
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
		case BPELPackage.FOR_EACH__START_COUNTER_VALUE:
			return getStartCounterValue();
		case BPELPackage.FOR_EACH__FINAL_COUNTER_VALUE:
			return getFinalCounterValue();
		case BPELPackage.FOR_EACH__PARALLEL:
			return getParallel();
		case BPELPackage.FOR_EACH__COUNTER_NAME:
			return getCounterName();
		case BPELPackage.FOR_EACH__COMPLETION_CONDITION:
			return getCompletionCondition();
		case BPELPackage.FOR_EACH__ACTIVITY:
			return getActivity();
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
		case BPELPackage.FOR_EACH__START_COUNTER_VALUE:
			setStartCounterValue((Expression) newValue);
			return;
		case BPELPackage.FOR_EACH__FINAL_COUNTER_VALUE:
			setFinalCounterValue((Expression) newValue);
			return;
		case BPELPackage.FOR_EACH__PARALLEL:
			setParallel((Boolean) newValue);
			return;
		case BPELPackage.FOR_EACH__COUNTER_NAME:
			setCounterName((Variable) newValue);
			return;
		case BPELPackage.FOR_EACH__COMPLETION_CONDITION:
			setCompletionCondition((CompletionCondition) newValue);
			return;
		case BPELPackage.FOR_EACH__ACTIVITY:
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
		case BPELPackage.FOR_EACH__START_COUNTER_VALUE:
			setStartCounterValue((Expression) null);
			return;
		case BPELPackage.FOR_EACH__FINAL_COUNTER_VALUE:
			setFinalCounterValue((Expression) null);
			return;
		case BPELPackage.FOR_EACH__PARALLEL:
			setParallel(PARALLEL_EDEFAULT);
			return;
		case BPELPackage.FOR_EACH__COUNTER_NAME:
			setCounterName((Variable) null);
			return;
		case BPELPackage.FOR_EACH__COMPLETION_CONDITION:
			setCompletionCondition((CompletionCondition) null);
			return;
		case BPELPackage.FOR_EACH__ACTIVITY:
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
		case BPELPackage.FOR_EACH__START_COUNTER_VALUE:
			return startCounterValue != null;
		case BPELPackage.FOR_EACH__FINAL_COUNTER_VALUE:
			return finalCounterValue != null;
		case BPELPackage.FOR_EACH__PARALLEL:
			return PARALLEL_EDEFAULT == null ? parallel != null
					: !PARALLEL_EDEFAULT.equals(parallel);
		case BPELPackage.FOR_EACH__COUNTER_NAME:
			return counterName != null;
		case BPELPackage.FOR_EACH__COMPLETION_CONDITION:
			return completionCondition != null;
		case BPELPackage.FOR_EACH__ACTIVITY:
			return activity != null;
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
		result.append(" (parallel: "); //$NON-NLS-1$
		result.append(parallel);
		result.append(')');
		return result.toString();
	}

} //ForEachImpl
