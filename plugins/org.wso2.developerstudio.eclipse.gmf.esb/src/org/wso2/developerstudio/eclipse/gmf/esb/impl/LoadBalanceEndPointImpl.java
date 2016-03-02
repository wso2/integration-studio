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
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceAlgorithm;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointWestOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceSessionType;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.Member;
import org.wso2.developerstudio.eclipse.gmf.esb.Session;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load Balance End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LoadBalanceEndPointImpl#isFailover <em>Failover</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LoadBalanceEndPointImpl#getPolicy <em>Policy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LoadBalanceEndPointImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LoadBalanceEndPointImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LoadBalanceEndPointImpl#getWestOutputConnector <em>West Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LoadBalanceEndPointImpl#getMember <em>Member</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LoadBalanceEndPointImpl#getSessionType <em>Session Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LoadBalanceEndPointImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LoadBalanceEndPointImpl#getSessionTimeout <em>Session Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LoadBalanceEndPointImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoadBalanceEndPointImpl extends ParentEndPointImpl implements LoadBalanceEndPoint {
	/**
	 * The default value of the '{@link #isFailover() <em>Failover</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFailover()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FAILOVER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFailover() <em>Failover</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFailover()
	 * @generated
	 * @ordered
	 */
	protected boolean failover = FAILOVER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPolicy() <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final String POLICY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPolicy() <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicy()
	 * @generated
	 * @ordered
	 */
	protected String policy = POLICY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected LoadBalanceEndPointInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EList<LoadBalanceEndPointOutputConnector> outputConnector;

	/**
	 * The cached value of the '{@link #getWestOutputConnector() <em>West Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWestOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected LoadBalanceEndPointWestOutputConnector westOutputConnector;

	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<Member> member;

	/**
	 * The default value of the '{@link #getSessionType() <em>Session Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionType()
	 * @generated
	 * @ordered
	 */
	protected static final LoadBalanceSessionType SESSION_TYPE_EDEFAULT = LoadBalanceSessionType.NONE;

	/**
	 * The cached value of the '{@link #getSessionType() <em>Session Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionType()
	 * @generated
	 * @ordered
	 */
	protected LoadBalanceSessionType sessionType = SESSION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_EDEFAULT = "org.apache.synapse.endpoints.algorithms.RoundRobin";

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected String algorithm = ALGORITHM_EDEFAULT;

	/**
	 * The default value of the '{@link #getSessionTimeout() <em>Session Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final long SESSION_TIMEOUT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSessionTimeout() <em>Session Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionTimeout()
	 * @generated
	 * @ordered
	 */
	protected long sessionTimeout = SESSION_TIMEOUT_EDEFAULT;

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
	protected LoadBalanceEndPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.LOAD_BALANCE_END_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFailover() {
		return failover;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailover(boolean newFailover) {
		boolean oldFailover = failover;
		failover = newFailover;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__FAILOVER, oldFailover, failover));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPolicy() {
		return policy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicy(String newPolicy) {
		String oldPolicy = policy;
		policy = newPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__POLICY, oldPolicy, policy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceEndPointInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(LoadBalanceEndPointInputConnector newInputConnector, NotificationChain msgs) {
		LoadBalanceEndPointInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(LoadBalanceEndPointInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LoadBalanceEndPointOutputConnector> getOutputConnector() {
		if (outputConnector == null) {
			outputConnector = new EObjectContainmentEList<LoadBalanceEndPointOutputConnector>(LoadBalanceEndPointOutputConnector.class, this, EsbPackage.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR);
		}
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceEndPointWestOutputConnector getWestOutputConnector() {
		return westOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWestOutputConnector(LoadBalanceEndPointWestOutputConnector newWestOutputConnector, NotificationChain msgs) {
		LoadBalanceEndPointWestOutputConnector oldWestOutputConnector = westOutputConnector;
		westOutputConnector = newWestOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR, oldWestOutputConnector, newWestOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWestOutputConnector(LoadBalanceEndPointWestOutputConnector newWestOutputConnector) {
		if (newWestOutputConnector != westOutputConnector) {
			NotificationChain msgs = null;
			if (westOutputConnector != null)
				msgs = ((InternalEObject)westOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR, null, msgs);
			if (newWestOutputConnector != null)
				msgs = ((InternalEObject)newWestOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetWestOutputConnector(newWestOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR, newWestOutputConnector, newWestOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Member> getMember() {
		if (member == null) {
			member = new EObjectContainmentEList<Member>(Member.class, this, EsbPackage.LOAD_BALANCE_END_POINT__MEMBER);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceSessionType getSessionType() {
		return sessionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSessionType(LoadBalanceSessionType newSessionType) {
		LoadBalanceSessionType oldSessionType = sessionType;
		sessionType = newSessionType == null ? SESSION_TYPE_EDEFAULT : newSessionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE, oldSessionType, sessionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithm(String newAlgorithm) {
		String oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSessionTimeout() {
		return sessionTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSessionTimeout(long newSessionTimeout) {
		long oldSessionTimeout = sessionTimeout;
		sessionTimeout = newSessionTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT, oldSessionTimeout, sessionTimeout));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
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
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR:
				return ((InternalEList<?>)getOutputConnector()).basicRemove(otherEnd, msgs);
			case EsbPackage.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR:
				return basicSetWestOutputConnector(null, msgs);
			case EsbPackage.LOAD_BALANCE_END_POINT__MEMBER:
				return ((InternalEList<?>)getMember()).basicRemove(otherEnd, msgs);
			case EsbPackage.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW:
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
			case EsbPackage.LOAD_BALANCE_END_POINT__FAILOVER:
				return isFailover();
			case EsbPackage.LOAD_BALANCE_END_POINT__POLICY:
				return getPolicy();
			case EsbPackage.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR:
				return getWestOutputConnector();
			case EsbPackage.LOAD_BALANCE_END_POINT__MEMBER:
				return getMember();
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE:
				return getSessionType();
			case EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM:
				return getAlgorithm();
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT:
				return getSessionTimeout();
			case EsbPackage.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW:
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
			case EsbPackage.LOAD_BALANCE_END_POINT__FAILOVER:
				setFailover((Boolean)newValue);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__POLICY:
				setPolicy((String)newValue);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR:
				setInputConnector((LoadBalanceEndPointInputConnector)newValue);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR:
				getOutputConnector().clear();
				getOutputConnector().addAll((Collection<? extends LoadBalanceEndPointOutputConnector>)newValue);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR:
				setWestOutputConnector((LoadBalanceEndPointWestOutputConnector)newValue);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends Member>)newValue);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE:
				setSessionType((LoadBalanceSessionType)newValue);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT:
				setSessionTimeout((Long)newValue);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW:
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
			case EsbPackage.LOAD_BALANCE_END_POINT__FAILOVER:
				setFailover(FAILOVER_EDEFAULT);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__POLICY:
				setPolicy(POLICY_EDEFAULT);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR:
				setInputConnector((LoadBalanceEndPointInputConnector)null);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR:
				getOutputConnector().clear();
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR:
				setWestOutputConnector((LoadBalanceEndPointWestOutputConnector)null);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__MEMBER:
				getMember().clear();
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE:
				setSessionType(SESSION_TYPE_EDEFAULT);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT:
				setSessionTimeout(SESSION_TIMEOUT_EDEFAULT);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW:
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
			case EsbPackage.LOAD_BALANCE_END_POINT__FAILOVER:
				return failover != FAILOVER_EDEFAULT;
			case EsbPackage.LOAD_BALANCE_END_POINT__POLICY:
				return POLICY_EDEFAULT == null ? policy != null : !POLICY_EDEFAULT.equals(policy);
			case EsbPackage.LOAD_BALANCE_END_POINT__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR:
				return outputConnector != null && !outputConnector.isEmpty();
			case EsbPackage.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR:
				return westOutputConnector != null;
			case EsbPackage.LOAD_BALANCE_END_POINT__MEMBER:
				return member != null && !member.isEmpty();
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE:
				return sessionType != SESSION_TYPE_EDEFAULT;
			case EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT:
				return sessionTimeout != SESSION_TIMEOUT_EDEFAULT;
			case EsbPackage.LOAD_BALANCE_END_POINT__MEDIATOR_FLOW:
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
		result.append(" (failover: ");
		result.append(failover);
		result.append(", policy: ");
		result.append(policy);
		result.append(", sessionType: ");
		result.append(sessionType);
		result.append(", algorithm: ");
		result.append(algorithm);
		result.append(", sessionTimeout: ");
		result.append(sessionTimeout);
		result.append(')');
		return result.toString();
	}

} //LoadBalanceEndPointImpl
