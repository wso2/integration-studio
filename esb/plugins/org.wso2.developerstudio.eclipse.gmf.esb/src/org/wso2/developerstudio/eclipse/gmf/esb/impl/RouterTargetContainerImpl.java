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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Router Target Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterTargetContainerImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterTargetContainerImpl#isBreakAfterRoute <em>Break After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterTargetContainerImpl#getRouteExpression <em>Route Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterTargetContainerImpl#getRoutePattern <em>Route Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterTargetContainerImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RouterTargetContainerImpl extends EsbNodeImpl implements RouterTargetContainer {
	/**
	 * The cached value of the '{@link #getMediatorFlow() <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediatorFlow()
	 * @generated
	 * @ordered
	 */
	protected MediatorFlow mediatorFlow;

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
	 * The cached value of the '{@link #getRouteExpression() <em>Route Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRouteExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty routeExpression;
	/**
	 * The default value of the '{@link #getRoutePattern() <em>Route Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String ROUTE_PATTERN_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRoutePattern() <em>Route Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutePattern()
	 * @generated
	 * @ordered
	 */
	protected String routePattern = ROUTE_PATTERN_EDEFAULT;
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected RouterTarget target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RouterTargetContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ROUTER_TARGET_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorFlow getMediatorFlow() {
		return mediatorFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMediatorFlow(MediatorFlow newMediatorFlow, NotificationChain msgs) {
		MediatorFlow oldMediatorFlow = mediatorFlow;
		mediatorFlow = newMediatorFlow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_TARGET_CONTAINER__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediatorFlow(MediatorFlow newMediatorFlow) {
		if (newMediatorFlow != mediatorFlow) {
			NotificationChain msgs = null;
			if (mediatorFlow != null)
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_TARGET_CONTAINER__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_TARGET_CONTAINER__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_TARGET_CONTAINER__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_TARGET_CONTAINER__BREAK_AFTER_ROUTE, oldBreakAfterRoute, breakAfterRoute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getRouteExpression() {
		return routeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRouteExpression(NamespacedProperty newRouteExpression, NotificationChain msgs) {
		NamespacedProperty oldRouteExpression = routeExpression;
		routeExpression = newRouteExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION, oldRouteExpression, newRouteExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRouteExpression(NamespacedProperty newRouteExpression) {
		if (newRouteExpression != routeExpression) {
			NotificationChain msgs = null;
			if (routeExpression != null)
				msgs = ((InternalEObject)routeExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION, null, msgs);
			if (newRouteExpression != null)
				msgs = ((InternalEObject)newRouteExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION, null, msgs);
			msgs = basicSetRouteExpression(newRouteExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION, newRouteExpression, newRouteExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoutePattern() {
		return routePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoutePattern(String newRoutePattern) {
		String oldRoutePattern = routePattern;
		routePattern = newRoutePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_PATTERN, oldRoutePattern, routePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterTarget getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(RouterTarget newTarget, NotificationChain msgs) {
		RouterTarget oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_TARGET_CONTAINER__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(RouterTarget newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_TARGET_CONTAINER__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_TARGET_CONTAINER__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_TARGET_CONTAINER__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ROUTER_TARGET_CONTAINER__MEDIATOR_FLOW:
				return basicSetMediatorFlow(null, msgs);
			case EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION:
				return basicSetRouteExpression(null, msgs);
			case EsbPackage.ROUTER_TARGET_CONTAINER__TARGET:
				return basicSetTarget(null, msgs);
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
			case EsbPackage.ROUTER_TARGET_CONTAINER__MEDIATOR_FLOW:
				return getMediatorFlow();
			case EsbPackage.ROUTER_TARGET_CONTAINER__BREAK_AFTER_ROUTE:
				return isBreakAfterRoute();
			case EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION:
				return getRouteExpression();
			case EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_PATTERN:
				return getRoutePattern();
			case EsbPackage.ROUTER_TARGET_CONTAINER__TARGET:
				return getTarget();
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
			case EsbPackage.ROUTER_TARGET_CONTAINER__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)newValue);
				return;
			case EsbPackage.ROUTER_TARGET_CONTAINER__BREAK_AFTER_ROUTE:
				setBreakAfterRoute((Boolean)newValue);
				return;
			case EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION:
				setRouteExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_PATTERN:
				setRoutePattern((String)newValue);
				return;
			case EsbPackage.ROUTER_TARGET_CONTAINER__TARGET:
				setTarget((RouterTarget)newValue);
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
			case EsbPackage.ROUTER_TARGET_CONTAINER__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)null);
				return;
			case EsbPackage.ROUTER_TARGET_CONTAINER__BREAK_AFTER_ROUTE:
				setBreakAfterRoute(BREAK_AFTER_ROUTE_EDEFAULT);
				return;
			case EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION:
				setRouteExpression((NamespacedProperty)null);
				return;
			case EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_PATTERN:
				setRoutePattern(ROUTE_PATTERN_EDEFAULT);
				return;
			case EsbPackage.ROUTER_TARGET_CONTAINER__TARGET:
				setTarget((RouterTarget)null);
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
			case EsbPackage.ROUTER_TARGET_CONTAINER__MEDIATOR_FLOW:
				return mediatorFlow != null;
			case EsbPackage.ROUTER_TARGET_CONTAINER__BREAK_AFTER_ROUTE:
				return breakAfterRoute != BREAK_AFTER_ROUTE_EDEFAULT;
			case EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_EXPRESSION:
				return routeExpression != null;
			case EsbPackage.ROUTER_TARGET_CONTAINER__ROUTE_PATTERN:
				return ROUTE_PATTERN_EDEFAULT == null ? routePattern != null : !ROUTE_PATTERN_EDEFAULT.equals(routePattern);
			case EsbPackage.ROUTER_TARGET_CONTAINER__TARGET:
				return target != null;
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
		result.append(", routePattern: ");
		result.append(routePattern);
		result.append(')');
		return result.toString();
	}

} //RouterTargetContainerImpl
