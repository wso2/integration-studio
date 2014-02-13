/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.RouteTarget;
import org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Route</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterRouteImpl#isBreakAfterRoute <em>Break After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterRouteImpl#getRouteExpression <em>Route Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterRouteImpl#getRoutePattern <em>Route Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterRouteImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RouterRouteImpl extends ModelObjectImpl implements RouterRoute {
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
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected RouteTarget target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected RouterRouteImpl() {
		super();
		
		// Route expression.
		NamespacedProperty routeExpression = getEsbFactory().createNamespacedProperty();
		routeExpression.setPrettyName("Route Expression");
		routeExpression.setPropertyName("expression");
		routeExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);		
		setRouteExpression(routeExpression);
		
		// Route target.
		RouteTarget target = getMediatorFactory().createRouteTarget();
		setTarget(target);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		if (self.hasAttribute("match")) {
			setRoutePattern(self.getAttribute("match"));
		}

		if (self.hasAttribute("breakRouter")) {
			setBreakAfterRoute(self.getAttribute("breakRouter").equals("true") ? true : false);
		} else {
			setBreakAfterRoute(false);
		}

		if (self.hasAttribute("expression")) {
			getRouteExpression().load(self);
		}

		loadObjects(self, "target", RouteTarget.class, new ObjectHandler<RouteTarget>() {
			public void handle(RouteTarget object) {
				setTarget(object);
			}			
		});
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "route");
		self.setAttribute("breakRouter", isBreakAfterRoute() ? "true" : "false");
		
		getRouteExpression().save(self);

		if (!StringUtils.isBlank(getRoutePattern())) {
			self.setAttribute("match", getRoutePattern());
		}
		
		if (getTarget() != null) {
			getTarget().save(self);
		}					
		addComments(self);
		return self;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.ROUTER_ROUTE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ROUTER_ROUTE__BREAK_AFTER_ROUTE, oldBreakAfterRoute, breakAfterRoute));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.ROUTER_ROUTE__ROUTE_EXPRESSION, oldRouteExpression, routeExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ROUTER_ROUTE__ROUTE_EXPRESSION, oldRouteExpression, routeExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ROUTER_ROUTE__ROUTE_PATTERN, oldRoutePattern, routePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouteTarget getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(RouteTarget newTarget, NotificationChain msgs) {
		RouteTarget oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.ROUTER_ROUTE__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(RouteTarget newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ROUTER_ROUTE__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ROUTER_ROUTE__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ROUTER_ROUTE__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.ROUTER_ROUTE__TARGET:
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
			case MediatorsPackage.ROUTER_ROUTE__BREAK_AFTER_ROUTE:
				return isBreakAfterRoute();
			case MediatorsPackage.ROUTER_ROUTE__ROUTE_EXPRESSION:
				if (resolve) return getRouteExpression();
				return basicGetRouteExpression();
			case MediatorsPackage.ROUTER_ROUTE__ROUTE_PATTERN:
				return getRoutePattern();
			case MediatorsPackage.ROUTER_ROUTE__TARGET:
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
			case MediatorsPackage.ROUTER_ROUTE__BREAK_AFTER_ROUTE:
				setBreakAfterRoute((Boolean)newValue);
				return;
			case MediatorsPackage.ROUTER_ROUTE__ROUTE_EXPRESSION:
				setRouteExpression((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.ROUTER_ROUTE__ROUTE_PATTERN:
				setRoutePattern((String)newValue);
				return;
			case MediatorsPackage.ROUTER_ROUTE__TARGET:
				setTarget((RouteTarget)newValue);
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
			case MediatorsPackage.ROUTER_ROUTE__BREAK_AFTER_ROUTE:
				setBreakAfterRoute(BREAK_AFTER_ROUTE_EDEFAULT);
				return;
			case MediatorsPackage.ROUTER_ROUTE__ROUTE_EXPRESSION:
				setRouteExpression((NamespacedProperty)null);
				return;
			case MediatorsPackage.ROUTER_ROUTE__ROUTE_PATTERN:
				setRoutePattern(ROUTE_PATTERN_EDEFAULT);
				return;
			case MediatorsPackage.ROUTER_ROUTE__TARGET:
				setTarget((RouteTarget)null);
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
			case MediatorsPackage.ROUTER_ROUTE__BREAK_AFTER_ROUTE:
				return breakAfterRoute != BREAK_AFTER_ROUTE_EDEFAULT;
			case MediatorsPackage.ROUTER_ROUTE__ROUTE_EXPRESSION:
				return routeExpression != null;
			case MediatorsPackage.ROUTER_ROUTE__ROUTE_PATTERN:
				return ROUTE_PATTERN_EDEFAULT == null ? routePattern != null : !ROUTE_PATTERN_EDEFAULT.equals(routePattern);
			case MediatorsPackage.ROUTER_ROUTE__TARGET:
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

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		if (null == getRouteExpression().getPropertyValue() || getRouteExpression().getPropertyValue().trim().isEmpty()) {
			validateMap.put("Route Expression","Route Expression is empty");
		}
		
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Router Mediator - Route", objectValidator);
	    return mediatorValidateMap;
    }

} //RouteImpl
