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
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointCaseBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointDefaultBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointWestOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failover End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FailoverEndPointImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FailoverEndPointImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FailoverEndPointImpl#getWestOutputConnector <em>West Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FailoverEndPointImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FailoverEndPointImpl extends ParentEndPointImpl implements FailoverEndPoint {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected FailoverEndPointInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EList<FailoverEndPointOutputConnector> outputConnector;

	/**
	 * The cached value of the '{@link #getWestOutputConnector() <em>West Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWestOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected FailoverEndPointWestOutputConnector westOutputConnector;

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
	protected FailoverEndPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.FAILOVER_END_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailoverEndPointInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(FailoverEndPointInputConnector newInputConnector, NotificationChain msgs) {
		FailoverEndPointInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAILOVER_END_POINT__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(FailoverEndPointInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAILOVER_END_POINT__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAILOVER_END_POINT__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAILOVER_END_POINT__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailoverEndPointOutputConnector> getOutputConnector() {
		if (outputConnector == null) {
			outputConnector = new EObjectContainmentEList<FailoverEndPointOutputConnector>(FailoverEndPointOutputConnector.class, this, EsbPackage.FAILOVER_END_POINT__OUTPUT_CONNECTOR);
		}
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailoverEndPointWestOutputConnector getWestOutputConnector() {
		return westOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWestOutputConnector(FailoverEndPointWestOutputConnector newWestOutputConnector, NotificationChain msgs) {
		FailoverEndPointWestOutputConnector oldWestOutputConnector = westOutputConnector;
		westOutputConnector = newWestOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR, oldWestOutputConnector, newWestOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWestOutputConnector(FailoverEndPointWestOutputConnector newWestOutputConnector) {
		if (newWestOutputConnector != westOutputConnector) {
			NotificationChain msgs = null;
			if (westOutputConnector != null)
				msgs = ((InternalEObject)westOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR, null, msgs);
			if (newWestOutputConnector != null)
				msgs = ((InternalEObject)newWestOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetWestOutputConnector(newWestOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR, newWestOutputConnector, newWestOutputConnector));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAILOVER_END_POINT__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
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
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAILOVER_END_POINT__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAILOVER_END_POINT__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAILOVER_END_POINT__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.FAILOVER_END_POINT__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.FAILOVER_END_POINT__OUTPUT_CONNECTOR:
				return ((InternalEList<?>)getOutputConnector()).basicRemove(otherEnd, msgs);
			case EsbPackage.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR:
				return basicSetWestOutputConnector(null, msgs);
			case EsbPackage.FAILOVER_END_POINT__MEDIATOR_FLOW:
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
			case EsbPackage.FAILOVER_END_POINT__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.FAILOVER_END_POINT__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR:
				return getWestOutputConnector();
			case EsbPackage.FAILOVER_END_POINT__MEDIATOR_FLOW:
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
			case EsbPackage.FAILOVER_END_POINT__INPUT_CONNECTOR:
				setInputConnector((FailoverEndPointInputConnector)newValue);
				return;
			case EsbPackage.FAILOVER_END_POINT__OUTPUT_CONNECTOR:
				getOutputConnector().clear();
				getOutputConnector().addAll((Collection<? extends FailoverEndPointOutputConnector>)newValue);
				return;
			case EsbPackage.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR:
				setWestOutputConnector((FailoverEndPointWestOutputConnector)newValue);
				return;
			case EsbPackage.FAILOVER_END_POINT__MEDIATOR_FLOW:
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
			case EsbPackage.FAILOVER_END_POINT__INPUT_CONNECTOR:
				setInputConnector((FailoverEndPointInputConnector)null);
				return;
			case EsbPackage.FAILOVER_END_POINT__OUTPUT_CONNECTOR:
				getOutputConnector().clear();
				return;
			case EsbPackage.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR:
				setWestOutputConnector((FailoverEndPointWestOutputConnector)null);
				return;
			case EsbPackage.FAILOVER_END_POINT__MEDIATOR_FLOW:
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
			case EsbPackage.FAILOVER_END_POINT__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.FAILOVER_END_POINT__OUTPUT_CONNECTOR:
				return outputConnector != null && !outputConnector.isEmpty();
			case EsbPackage.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR:
				return westOutputConnector != null;
			case EsbPackage.FAILOVER_END_POINT__MEDIATOR_FLOW:
				return mediatorFlow != null;
		}
		return super.eIsSet(featureID);
	}

} //FailoverEndPointImpl
