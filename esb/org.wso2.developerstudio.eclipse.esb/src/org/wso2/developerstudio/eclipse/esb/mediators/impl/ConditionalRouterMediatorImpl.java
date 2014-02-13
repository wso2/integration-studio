/**
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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Conditional Router Mediator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouterMediatorImpl#isContinueAfterRoute <em>Continue After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouterMediatorImpl#getConditionalRouteBraches <em>Conditional Route Braches</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalRouterMediatorImpl extends MediatorImpl implements
		ConditionalRouterMediator {
	/**
	 * The default value of the '{@link #isContinueAfterRoute() <em>Continue After Route</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isContinueAfterRoute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTINUE_AFTER_ROUTE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContinueAfterRoute() <em>Continue After Route</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isContinueAfterRoute()
	 * @generated
	 * @ordered
	 */
	protected boolean continueAfterRoute = CONTINUE_AFTER_ROUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConditionalRouteBraches()
	 * <em>Conditional Route Braches</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConditionalRouteBraches()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionalRouteBranch> conditionalRouteBraches;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * 
	 */
	protected ConditionalRouterMediatorImpl() {
		super();

	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {

		// Continue After Routing
		if (self.hasAttribute("continueAfter")) {
			if (self.getAttribute("continueAfter").equals("true")) {
				setContinueAfterRoute(true);
			}
		}

		loadObjects(self, "conditionalRoute", ConditionalRouteBranch.class,
				new ObjectHandler<ConditionalRouteBranch>() {
					public void handle(ConditionalRouteBranch object) {
						getConditionalRouteBraches().add(object);

					}
				});
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "conditionalRouter");

		// Continue After Routing
		if (isContinueAfterRoute()) {
			self.setAttribute("continueAfter", "true");
		} 
		
		for (ConditionalRouteBranch conditionalRouteBranch : getConditionalRouteBraches()) {
			conditionalRouteBranch.save(self);
		}
		if(description!=null)
			description.save(self);
		
		addComments(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContinueAfterRoute() {
		return continueAfterRoute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContinueAfterRoute(boolean newContinueAfterRoute) {
		boolean oldContinueAfterRoute = continueAfterRoute;
		continueAfterRoute = newContinueAfterRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE, oldContinueAfterRoute, continueAfterRoute));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConditionalRouteBranch> getConditionalRouteBraches() {
		if (conditionalRouteBraches == null) {
			conditionalRouteBraches = new EObjectContainmentEList<ConditionalRouteBranch>(ConditionalRouteBranch.class, this, MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRACHES);
		}
		return conditionalRouteBraches;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRACHES:
				return ((InternalEList<?>)getConditionalRouteBraches()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE:
				return isContinueAfterRoute();
			case MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRACHES:
				return getConditionalRouteBraches();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE:
				setContinueAfterRoute((Boolean)newValue);
				return;
			case MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRACHES:
				getConditionalRouteBraches().clear();
				getConditionalRouteBraches().addAll((Collection<? extends ConditionalRouteBranch>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE:
				setContinueAfterRoute(CONTINUE_AFTER_ROUTE_EDEFAULT);
				return;
			case MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRACHES:
				getConditionalRouteBraches().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE:
				return continueAfterRoute != CONTINUE_AFTER_ROUTE_EDEFAULT;
			case MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRACHES:
				return conditionalRouteBraches != null && !conditionalRouteBraches.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (continueAfterRoute: ");
		result.append(continueAfterRoute);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    return new HashMap<String, ObjectValidator>();
    }

} // ConditionalRouterMediatorImpl
