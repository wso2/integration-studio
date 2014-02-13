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
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.RouterMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Router Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterMediatorImpl#isContinueAfterRouting <em>Continue After Routing</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterMediatorImpl#getRoutes <em>Routes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RouterMediatorImpl extends MediatorImpl implements RouterMediator {
	/**
	 * The default value of the '{@link #isContinueAfterRouting() <em>Continue After Routing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContinueAfterRouting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTINUE_AFTER_ROUTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContinueAfterRouting() <em>Continue After Routing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContinueAfterRouting()
	 * @generated
	 * @ordered
	 */
	protected boolean continueAfterRouting = CONTINUE_AFTER_ROUTING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoutes() <em>Routes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutes()
	 * @generated
	 * @ordered
	 */
	protected EList<RouterRoute> routes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RouterMediatorImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		if (self.hasAttribute("continueAfter")) {
			setContinueAfterRouting(self.getAttribute("continueAfter").equals("true") ? true : false);
		} else {
			setContinueAfterRouting(false);
		}
		
		// Load all routes.
		loadObjects(self, "route", RouterRoute.class, new ObjectHandler<RouterRoute>() {
			public void handle(RouterRoute object) {
				getRoutes().add(object);
			}			
		});	
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "router");
		
		// Routes.
		for (RouterRoute route : getRoutes()) {
			route.save(self);
		}
		
		if (isContinueAfterRouting()) {
			self.setAttribute("continueAfter","true");
		}
		if(description!=null)
			description.save(self);
		
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
		return MediatorsPackage.Literals.ROUTER_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContinueAfterRouting() {
		return continueAfterRouting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContinueAfterRouting(boolean newContinueAfterRouting) {
		boolean oldContinueAfterRouting = continueAfterRouting;
		continueAfterRouting = newContinueAfterRouting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING, oldContinueAfterRouting, continueAfterRouting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RouterRoute> getRoutes() {
		if (routes == null) {
			routes = new EObjectContainmentEList<RouterRoute>(RouterRoute.class, this, MediatorsPackage.ROUTER_MEDIATOR__ROUTES);
		}
		return routes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.ROUTER_MEDIATOR__ROUTES:
				return ((InternalEList<?>)getRoutes()).basicRemove(otherEnd, msgs);
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
			case MediatorsPackage.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING:
				return isContinueAfterRouting();
			case MediatorsPackage.ROUTER_MEDIATOR__ROUTES:
				return getRoutes();
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
			case MediatorsPackage.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING:
				setContinueAfterRouting((Boolean)newValue);
				return;
			case MediatorsPackage.ROUTER_MEDIATOR__ROUTES:
				getRoutes().clear();
				getRoutes().addAll((Collection<? extends RouterRoute>)newValue);
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
			case MediatorsPackage.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING:
				setContinueAfterRouting(CONTINUE_AFTER_ROUTING_EDEFAULT);
				return;
			case MediatorsPackage.ROUTER_MEDIATOR__ROUTES:
				getRoutes().clear();
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
			case MediatorsPackage.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING:
				return continueAfterRouting != CONTINUE_AFTER_ROUTING_EDEFAULT;
			case MediatorsPackage.ROUTER_MEDIATOR__ROUTES:
				return routes != null && !routes.isEmpty();
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
		result.append(" (continueAfterRouting: ");
		result.append(continueAfterRouting);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    return new HashMap<String, ObjectValidator>();
    }

} //RouterMediatorImpl
