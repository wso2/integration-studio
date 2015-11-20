/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterRoute;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTarget;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Router Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterMediatorImpl#isContinueAfterRouting <em>Continue After Routing</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterMediatorImpl#getTargetOutputConnector <em>Target Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RouterMediatorImpl#getRouterContainer <em>Router Container</em>}</li>
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
	 * The cached value of the '{@link #getTargetOutputConnector() <em>Target Output Connector</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EList<RouterMediatorTargetOutputConnector> targetOutputConnector;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected RouterMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected RouterMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getRouterContainer() <em>Router Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRouterContainer()
	 * @generated
	 * @ordered
	 */
	protected RouterMediatorContainer routerContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RouterMediatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ROUTER_MEDIATOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING, oldContinueAfterRouting, continueAfterRouting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RouterMediatorTargetOutputConnector> getTargetOutputConnector() {
		if (targetOutputConnector == null) {
			targetOutputConnector = new EObjectContainmentEList<RouterMediatorTargetOutputConnector>(RouterMediatorTargetOutputConnector.class, this, EsbPackage.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR);
		}
		return targetOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(RouterMediatorInputConnector newInputConnector, NotificationChain msgs) {
		RouterMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(RouterMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(RouterMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		RouterMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(RouterMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterMediatorContainer getRouterContainer() {
		return routerContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRouterContainer(RouterMediatorContainer newRouterContainer, NotificationChain msgs) {
		RouterMediatorContainer oldRouterContainer = routerContainer;
		routerContainer = newRouterContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_MEDIATOR__ROUTER_CONTAINER, oldRouterContainer, newRouterContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRouterContainer(RouterMediatorContainer newRouterContainer) {
		if (newRouterContainer != routerContainer) {
			NotificationChain msgs = null;
			if (routerContainer != null)
				msgs = ((InternalEObject)routerContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_MEDIATOR__ROUTER_CONTAINER, null, msgs);
			if (newRouterContainer != null)
				msgs = ((InternalEObject)newRouterContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ROUTER_MEDIATOR__ROUTER_CONTAINER, null, msgs);
			msgs = basicSetRouterContainer(newRouterContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ROUTER_MEDIATOR__ROUTER_CONTAINER, newRouterContainer, newRouterContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				return ((InternalEList<?>)getTargetOutputConnector()).basicRemove(otherEnd, msgs);
			case EsbPackage.ROUTER_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.ROUTER_MEDIATOR__ROUTER_CONTAINER:
				return basicSetRouterContainer(null, msgs);
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
			case EsbPackage.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING:
				return isContinueAfterRouting();
			case EsbPackage.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				return getTargetOutputConnector();
			case EsbPackage.ROUTER_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.ROUTER_MEDIATOR__ROUTER_CONTAINER:
				return getRouterContainer();
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
			case EsbPackage.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING:
				setContinueAfterRouting((Boolean)newValue);
				return;
			case EsbPackage.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				getTargetOutputConnector().clear();
				getTargetOutputConnector().addAll((Collection<? extends RouterMediatorTargetOutputConnector>)newValue);
				return;
			case EsbPackage.ROUTER_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((RouterMediatorInputConnector)newValue);
				return;
			case EsbPackage.ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((RouterMediatorOutputConnector)newValue);
				return;
			case EsbPackage.ROUTER_MEDIATOR__ROUTER_CONTAINER:
				setRouterContainer((RouterMediatorContainer)newValue);
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
			case EsbPackage.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING:
				setContinueAfterRouting(CONTINUE_AFTER_ROUTING_EDEFAULT);
				return;
			case EsbPackage.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				getTargetOutputConnector().clear();
				return;
			case EsbPackage.ROUTER_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((RouterMediatorInputConnector)null);
				return;
			case EsbPackage.ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((RouterMediatorOutputConnector)null);
				return;
			case EsbPackage.ROUTER_MEDIATOR__ROUTER_CONTAINER:
				setRouterContainer((RouterMediatorContainer)null);
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
			case EsbPackage.ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING:
				return continueAfterRouting != CONTINUE_AFTER_ROUTING_EDEFAULT;
			case EsbPackage.ROUTER_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				return targetOutputConnector != null && !targetOutputConnector.isEmpty();
			case EsbPackage.ROUTER_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.ROUTER_MEDIATOR__ROUTER_CONTAINER:
				return routerContainer != null;
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

} //RouterMediatorImpl
