/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Route Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ConditionalRouteBranchImpl#isBreakAfterRoute <em>Break After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ConditionalRouteBranchImpl#getEvaluatorExpression <em>Evaluator Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ConditionalRouteBranchImpl#getTargetSequence <em>Target Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalRouteBranchImpl extends EsbNodeImpl implements ConditionalRouteBranch {
	/**
	 * The default value of the '{@link #isBreakAfterRoute() <em>Break After Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBreakAfterRoute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BREAK_AFTER_ROUTE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBreakAfterRoute() <em>Break After Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBreakAfterRoute()
	 * @generated
	 * @ordered
	 */
	protected boolean breakAfterRoute = BREAK_AFTER_ROUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEvaluatorExpression() <em>Evaluator Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluatorExpression()
	 * @generated
	 * @ordered
	 */
	protected EvaluatorExpressionProperty evaluatorExpression;

	/**
	 * The cached value of the '{@link #getTargetSequence() <em>Target Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetSequence()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty targetSequence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalRouteBranchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CONDITIONAL_ROUTE_BRANCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBreakAfterRoute() {
		return breakAfterRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBreakAfterRoute(boolean newBreakAfterRoute) {
		boolean oldBreakAfterRoute = breakAfterRoute;
		breakAfterRoute = newBreakAfterRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE, oldBreakAfterRoute, breakAfterRoute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluatorExpressionProperty getEvaluatorExpression() {
		return evaluatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEvaluatorExpression(EvaluatorExpressionProperty newEvaluatorExpression, NotificationChain msgs) {
		EvaluatorExpressionProperty oldEvaluatorExpression = evaluatorExpression;
		evaluatorExpression = newEvaluatorExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION, oldEvaluatorExpression, newEvaluatorExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvaluatorExpression(EvaluatorExpressionProperty newEvaluatorExpression) {
		if (newEvaluatorExpression != evaluatorExpression) {
			NotificationChain msgs = null;
			if (evaluatorExpression != null)
				msgs = ((InternalEObject)evaluatorExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION, null, msgs);
			if (newEvaluatorExpression != null)
				msgs = ((InternalEObject)newEvaluatorExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION, null, msgs);
			msgs = basicSetEvaluatorExpression(newEvaluatorExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION, newEvaluatorExpression, newEvaluatorExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getTargetSequence() {
		return targetSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetSequence(RegistryKeyProperty newTargetSequence, NotificationChain msgs) {
		RegistryKeyProperty oldTargetSequence = targetSequence;
		targetSequence = newTargetSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE, oldTargetSequence, newTargetSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetSequence(RegistryKeyProperty newTargetSequence) {
		if (newTargetSequence != targetSequence) {
			NotificationChain msgs = null;
			if (targetSequence != null)
				msgs = ((InternalEObject)targetSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE, null, msgs);
			if (newTargetSequence != null)
				msgs = ((InternalEObject)newTargetSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE, null, msgs);
			msgs = basicSetTargetSequence(newTargetSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE, newTargetSequence, newTargetSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION:
				return basicSetEvaluatorExpression(null, msgs);
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE:
				return basicSetTargetSequence(null, msgs);
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
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE:
				return isBreakAfterRoute();
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION:
				return getEvaluatorExpression();
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE:
				return getTargetSequence();
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
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE:
				setBreakAfterRoute((Boolean)newValue);
				return;
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION:
				setEvaluatorExpression((EvaluatorExpressionProperty)newValue);
				return;
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE:
				setTargetSequence((RegistryKeyProperty)newValue);
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
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE:
				setBreakAfterRoute(BREAK_AFTER_ROUTE_EDEFAULT);
				return;
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION:
				setEvaluatorExpression((EvaluatorExpressionProperty)null);
				return;
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE:
				setTargetSequence((RegistryKeyProperty)null);
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
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE:
				return breakAfterRoute != BREAK_AFTER_ROUTE_EDEFAULT;
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION:
				return evaluatorExpression != null;
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE:
				return targetSequence != null;
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
		result.append(" (breakAfterRoute: ");
		result.append(breakAfterRoute);
		result.append(')');
		return result.toString();
	}

} //ConditionalRouteBranchImpl
