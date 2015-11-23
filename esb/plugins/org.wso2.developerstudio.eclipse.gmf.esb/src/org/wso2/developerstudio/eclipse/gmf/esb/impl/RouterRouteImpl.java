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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RouteTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterRoute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Router Route</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterRouteImpl#isBreakAfterRoute <em>Break After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterRouteImpl#getRouteExpression <em>Route Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterRouteImpl#getRoutePattern <em>Route Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RouterRouteImpl extends EsbNodeImpl implements RouterRoute {
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
	 * The cached value of the '{@link #getRouteExpression() <em>Route Expression</em>}' reference.
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RouterRouteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ROUTER_ROUTE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_ROUTE__BREAK_AFTER_ROUTE, oldBreakAfterRoute, breakAfterRoute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getRouteExpression() {
		if (routeExpression != null && routeExpression.eIsProxy()) {
			InternalEObject oldRouteExpression = (InternalEObject)routeExpression;
			routeExpression = (NamespacedProperty)eResolveProxy(oldRouteExpression);
			if (routeExpression != oldRouteExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.ROUTER_ROUTE__ROUTE_EXPRESSION, oldRouteExpression, routeExpression));
			}
		}
		return routeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetRouteExpression() {
		return routeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRouteExpression(NamespacedProperty newRouteExpression) {
		NamespacedProperty oldRouteExpression = routeExpression;
		routeExpression = newRouteExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_ROUTE__ROUTE_EXPRESSION, oldRouteExpression, routeExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_ROUTE__ROUTE_PATTERN, oldRoutePattern, routePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.ROUTER_ROUTE__BREAK_AFTER_ROUTE:
				return isBreakAfterRoute();
			case EsbPackage.ROUTER_ROUTE__ROUTE_EXPRESSION:
				if (resolve) return getRouteExpression();
				return basicGetRouteExpression();
			case EsbPackage.ROUTER_ROUTE__ROUTE_PATTERN:
				return getRoutePattern();
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
			case EsbPackage.ROUTER_ROUTE__BREAK_AFTER_ROUTE:
				setBreakAfterRoute((Boolean)newValue);
				return;
			case EsbPackage.ROUTER_ROUTE__ROUTE_EXPRESSION:
				setRouteExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.ROUTER_ROUTE__ROUTE_PATTERN:
				setRoutePattern((String)newValue);
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
			case EsbPackage.ROUTER_ROUTE__BREAK_AFTER_ROUTE:
				setBreakAfterRoute(BREAK_AFTER_ROUTE_EDEFAULT);
				return;
			case EsbPackage.ROUTER_ROUTE__ROUTE_EXPRESSION:
				setRouteExpression((NamespacedProperty)null);
				return;
			case EsbPackage.ROUTER_ROUTE__ROUTE_PATTERN:
				setRoutePattern(ROUTE_PATTERN_EDEFAULT);
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
			case EsbPackage.ROUTER_ROUTE__BREAK_AFTER_ROUTE:
				return breakAfterRoute != BREAK_AFTER_ROUTE_EDEFAULT;
			case EsbPackage.ROUTER_ROUTE__ROUTE_EXPRESSION:
				return routeExpression != null;
			case EsbPackage.ROUTER_ROUTE__ROUTE_PATTERN:
				return ROUTE_PATTERN_EDEFAULT == null ? routePattern != null : !ROUTE_PATTERN_EDEFAULT.equals(routePattern);
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

} //RouterRouteImpl
