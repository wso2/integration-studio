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

import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediatorAdditionalOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Router Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ConditionalRouterMediatorImpl#isContinueAfterRoute <em>Continue After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ConditionalRouterMediatorImpl#getConditionalRouteBranches <em>Conditional Route Branches</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ConditionalRouterMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ConditionalRouterMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ConditionalRouterMediatorImpl#getAdditionalOutputConnector <em>Additional Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ConditionalRouterMediatorImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalRouterMediatorImpl extends MediatorImpl implements ConditionalRouterMediator {
	/**
	 * The default value of the '{@link #isContinueAfterRoute() <em>Continue After Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContinueAfterRoute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTINUE_AFTER_ROUTE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContinueAfterRoute() <em>Continue After Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContinueAfterRoute()
	 * @generated
	 * @ordered
	 */
	protected boolean continueAfterRoute = CONTINUE_AFTER_ROUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConditionalRouteBranches() <em>Conditional Route Branches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionalRouteBranches()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionalRouteBranch> conditionalRouteBranches;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected ConditionalRouterMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected ConditionalRouterMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getAdditionalOutputConnector() <em>Additional Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected ConditionalRouterMediatorAdditionalOutputConnector additionalOutputConnector;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalRouterMediatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CONDITIONAL_ROUTER_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContinueAfterRoute() {
		return continueAfterRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContinueAfterRoute(boolean newContinueAfterRoute) {
		boolean oldContinueAfterRoute = continueAfterRoute;
		continueAfterRoute = newContinueAfterRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE, oldContinueAfterRoute, continueAfterRoute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConditionalRouteBranch> getConditionalRouteBranches() {
		if (conditionalRouteBranches == null) {
			conditionalRouteBranches = new EObjectContainmentEList<ConditionalRouteBranch>(ConditionalRouteBranch.class, this, EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES);
		}
		return conditionalRouteBranches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalRouterMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(ConditionalRouterMediatorInputConnector newInputConnector, NotificationChain msgs) {
		ConditionalRouterMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(ConditionalRouterMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalRouterMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(ConditionalRouterMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		ConditionalRouterMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(ConditionalRouterMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalRouterMediatorAdditionalOutputConnector getAdditionalOutputConnector() {
		return additionalOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdditionalOutputConnector(ConditionalRouterMediatorAdditionalOutputConnector newAdditionalOutputConnector, NotificationChain msgs) {
		ConditionalRouterMediatorAdditionalOutputConnector oldAdditionalOutputConnector = additionalOutputConnector;
		additionalOutputConnector = newAdditionalOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR, oldAdditionalOutputConnector, newAdditionalOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditionalOutputConnector(ConditionalRouterMediatorAdditionalOutputConnector newAdditionalOutputConnector) {
		if (newAdditionalOutputConnector != additionalOutputConnector) {
			NotificationChain msgs = null;
			if (additionalOutputConnector != null)
				msgs = ((InternalEObject)additionalOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR, null, msgs);
			if (newAdditionalOutputConnector != null)
				msgs = ((InternalEObject)newAdditionalOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetAdditionalOutputConnector(newAdditionalOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR, newAdditionalOutputConnector, newAdditionalOutputConnector));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
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
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES:
				return ((InternalEList<?>)getConditionalRouteBranches()).basicRemove(otherEnd, msgs);
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR:
				return basicSetAdditionalOutputConnector(null, msgs);
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW:
				return basicSetMediatorFlow(null, msgs);
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
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE:
				return isContinueAfterRoute();
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES:
				return getConditionalRouteBranches();
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR:
				return getAdditionalOutputConnector();
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW:
				return getMediatorFlow();
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
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE:
				setContinueAfterRoute((Boolean)newValue);
				return;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES:
				getConditionalRouteBranches().clear();
				getConditionalRouteBranches().addAll((Collection<? extends ConditionalRouteBranch>)newValue);
				return;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((ConditionalRouterMediatorInputConnector)newValue);
				return;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((ConditionalRouterMediatorOutputConnector)newValue);
				return;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR:
				setAdditionalOutputConnector((ConditionalRouterMediatorAdditionalOutputConnector)newValue);
				return;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)newValue);
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
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE:
				setContinueAfterRoute(CONTINUE_AFTER_ROUTE_EDEFAULT);
				return;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES:
				getConditionalRouteBranches().clear();
				return;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((ConditionalRouterMediatorInputConnector)null);
				return;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((ConditionalRouterMediatorOutputConnector)null);
				return;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR:
				setAdditionalOutputConnector((ConditionalRouterMediatorAdditionalOutputConnector)null);
				return;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)null);
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
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE:
				return continueAfterRoute != CONTINUE_AFTER_ROUTE_EDEFAULT;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRANCHES:
				return conditionalRouteBranches != null && !conditionalRouteBranches.isEmpty();
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_OUTPUT_CONNECTOR:
				return additionalOutputConnector != null;
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR__MEDIATOR_FLOW:
				return mediatorFlow != null;
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
		result.append(" (continueAfterRoute: ");
		result.append(continueAfterRoute);
		result.append(')');
		return result.toString();
	}

} //ConditionalRouterMediatorImpl
