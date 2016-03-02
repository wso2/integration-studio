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
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediatorOnAcceptOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediatorOnRejectOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnAcceptBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnRejectBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyConfiguration;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throttle Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getPolicyType <em>Policy Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getPolicyKey <em>Policy Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getMaxConcurrentAccessCount <em>Max Concurrent Access Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getPolicyEntries <em>Policy Entries</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getPolicyConfiguration <em>Policy Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getOnAcceptBranch <em>On Accept Branch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getOnRejectBranch <em>On Reject Branch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getOnAcceptOutputConnector <em>On Accept Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getOnRejectOutputConnector <em>On Reject Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getThrottleContainer <em>Throttle Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getOnAcceptBranchsequenceType <em>On Accept Branchsequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getOnAcceptBranchsequenceKey <em>On Accept Branchsequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getOnRejectBranchsequenceType <em>On Reject Branchsequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl#getOnRejectBranchsequenceKey <em>On Reject Branchsequence Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThrottleMediatorImpl extends MediatorImpl implements ThrottleMediator {
	/**
	 * The default value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_ID_EDEFAULT = "group_id";

	/**
	 * The cached value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected String groupId = GROUP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPolicyType() <em>Policy Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyType()
	 * @generated
	 * @ordered
	 */
	protected static final ThrottlePolicyType POLICY_TYPE_EDEFAULT = ThrottlePolicyType.INLINE;

	/**
	 * The cached value of the '{@link #getPolicyType() <em>Policy Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyType()
	 * @generated
	 * @ordered
	 */
	protected ThrottlePolicyType policyType = POLICY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPolicyKey() <em>Policy Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty policyKey;

	/**
	 * The default value of the '{@link #getMaxConcurrentAccessCount() <em>Max Concurrent Access Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxConcurrentAccessCount()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_CONCURRENT_ACCESS_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxConcurrentAccessCount() <em>Max Concurrent Access Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxConcurrentAccessCount()
	 * @generated
	 * @ordered
	 */
	protected int maxConcurrentAccessCount = MAX_CONCURRENT_ACCESS_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPolicyEntries() <em>Policy Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<ThrottlePolicyEntry> policyEntries;

	/**
	 * The cached value of the '{@link #getPolicyConfiguration() <em>Policy Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ThrottlePolicyConfiguration policyConfiguration;

	/**
	 * The cached value of the '{@link #getOnAcceptBranch() <em>On Accept Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnAcceptBranch()
	 * @generated
	 * @ordered
	 */
	protected ThrottleOnAcceptBranch onAcceptBranch;

	/**
	 * The cached value of the '{@link #getOnRejectBranch() <em>On Reject Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnRejectBranch()
	 * @generated
	 * @ordered
	 */
	protected ThrottleOnRejectBranch onRejectBranch;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected ThrottleMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected ThrottleMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getOnAcceptOutputConnector() <em>On Accept Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOnAcceptOutputConnector()
	 * @generated
	 * @ordered
	 */
    protected ThrottleMediatorOnAcceptOutputConnector onAcceptOutputConnector;

    /**
	 * The cached value of the '{@link #getOnRejectOutputConnector() <em>On Reject Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOnRejectOutputConnector()
	 * @generated
	 * @ordered
	 */
    protected ThrottleMediatorOnRejectOutputConnector onRejectOutputConnector;

    /**
	 * The cached value of the '{@link #getThrottleContainer() <em>Throttle Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getThrottleContainer()
	 * @generated
	 * @ordered
	 */
    protected ThrottleContainer throttleContainer;

    /**
	 * The default value of the '{@link #getOnAcceptBranchsequenceType() <em>On Accept Branchsequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnAcceptBranchsequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final ThrottleSequenceType ON_ACCEPT_BRANCHSEQUENCE_TYPE_EDEFAULT = ThrottleSequenceType.ANONYMOUS;

				/**
	 * The cached value of the '{@link #getOnAcceptBranchsequenceType() <em>On Accept Branchsequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnAcceptBranchsequenceType()
	 * @generated
	 * @ordered
	 */
	protected ThrottleSequenceType onAcceptBranchsequenceType = ON_ACCEPT_BRANCHSEQUENCE_TYPE_EDEFAULT;

				/**
	 * The cached value of the '{@link #getOnAcceptBranchsequenceKey() <em>On Accept Branchsequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnAcceptBranchsequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty onAcceptBranchsequenceKey;

				/**
	 * The default value of the '{@link #getOnRejectBranchsequenceType() <em>On Reject Branchsequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnRejectBranchsequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final ThrottleSequenceType ON_REJECT_BRANCHSEQUENCE_TYPE_EDEFAULT = ThrottleSequenceType.ANONYMOUS;

				/**
	 * The cached value of the '{@link #getOnRejectBranchsequenceType() <em>On Reject Branchsequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnRejectBranchsequenceType()
	 * @generated
	 * @ordered
	 */
	protected ThrottleSequenceType onRejectBranchsequenceType = ON_REJECT_BRANCHSEQUENCE_TYPE_EDEFAULT;

				/**
	 * The cached value of the '{@link #getOnRejectBranchsequenceKey() <em>On Reject Branchsequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnRejectBranchsequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty onRejectBranchsequenceKey;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ThrottleMediatorImpl() {
		super();

		RegistryKeyProperty policyKey = EsbFactoryImpl.eINSTANCE
				.createRegistryKeyProperty();
		policyKey.setKeyValue("default/key");
		setPolicyKey(policyKey);

		RegistryKeyProperty onAcceptKey = EsbFactoryImpl.eINSTANCE
				.createRegistryKeyProperty();
		onAcceptKey.setKeyValue("default/key");
		setOnAcceptBranchsequenceKey(onAcceptKey);

		RegistryKeyProperty onRejectKey = EsbFactoryImpl.eINSTANCE
				.createRegistryKeyProperty();
		onRejectKey.setKeyValue("default/key");
		setOnRejectBranchsequenceKey(onRejectKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.THROTTLE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupId(String newGroupId) {
		String oldGroupId = groupId;
		groupId = newGroupId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__GROUP_ID, oldGroupId, groupId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottlePolicyType getPolicyType() {
		return policyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicyType(ThrottlePolicyType newPolicyType) {
		ThrottlePolicyType oldPolicyType = policyType;
		policyType = newPolicyType == null ? POLICY_TYPE_EDEFAULT : newPolicyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__POLICY_TYPE, oldPolicyType, policyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getPolicyKey() {
		return policyKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPolicyKey(RegistryKeyProperty newPolicyKey, NotificationChain msgs) {
		RegistryKeyProperty oldPolicyKey = policyKey;
		policyKey = newPolicyKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__POLICY_KEY, oldPolicyKey, newPolicyKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicyKey(RegistryKeyProperty newPolicyKey) {
		if (newPolicyKey != policyKey) {
			NotificationChain msgs = null;
			if (policyKey != null)
				msgs = ((InternalEObject)policyKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__POLICY_KEY, null, msgs);
			if (newPolicyKey != null)
				msgs = ((InternalEObject)newPolicyKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__POLICY_KEY, null, msgs);
			msgs = basicSetPolicyKey(newPolicyKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__POLICY_KEY, newPolicyKey, newPolicyKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxConcurrentAccessCount() {
		return maxConcurrentAccessCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxConcurrentAccessCount(int newMaxConcurrentAccessCount) {
		int oldMaxConcurrentAccessCount = maxConcurrentAccessCount;
		maxConcurrentAccessCount = newMaxConcurrentAccessCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__MAX_CONCURRENT_ACCESS_COUNT, oldMaxConcurrentAccessCount, maxConcurrentAccessCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThrottlePolicyEntry> getPolicyEntries() {
		if (policyEntries == null) {
			policyEntries = new EObjectContainmentEList<ThrottlePolicyEntry>(ThrottlePolicyEntry.class, this, EsbPackage.THROTTLE_MEDIATOR__POLICY_ENTRIES);
		}
		return policyEntries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottlePolicyConfiguration getPolicyConfiguration() {
		return policyConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPolicyConfiguration(ThrottlePolicyConfiguration newPolicyConfiguration, NotificationChain msgs) {
		ThrottlePolicyConfiguration oldPolicyConfiguration = policyConfiguration;
		policyConfiguration = newPolicyConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION, oldPolicyConfiguration, newPolicyConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicyConfiguration(ThrottlePolicyConfiguration newPolicyConfiguration) {
		if (newPolicyConfiguration != policyConfiguration) {
			NotificationChain msgs = null;
			if (policyConfiguration != null)
				msgs = ((InternalEObject)policyConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION, null, msgs);
			if (newPolicyConfiguration != null)
				msgs = ((InternalEObject)newPolicyConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION, null, msgs);
			msgs = basicSetPolicyConfiguration(newPolicyConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION, newPolicyConfiguration, newPolicyConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleOnAcceptBranch getOnAcceptBranch() {
		return onAcceptBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnAcceptBranch(ThrottleOnAcceptBranch newOnAcceptBranch, NotificationChain msgs) {
		ThrottleOnAcceptBranch oldOnAcceptBranch = onAcceptBranch;
		onAcceptBranch = newOnAcceptBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH, oldOnAcceptBranch, newOnAcceptBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnAcceptBranch(ThrottleOnAcceptBranch newOnAcceptBranch) {
		if (newOnAcceptBranch != onAcceptBranch) {
			NotificationChain msgs = null;
			if (onAcceptBranch != null)
				msgs = ((InternalEObject)onAcceptBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH, null, msgs);
			if (newOnAcceptBranch != null)
				msgs = ((InternalEObject)newOnAcceptBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH, null, msgs);
			msgs = basicSetOnAcceptBranch(newOnAcceptBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH, newOnAcceptBranch, newOnAcceptBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleOnRejectBranch getOnRejectBranch() {
		return onRejectBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnRejectBranch(ThrottleOnRejectBranch newOnRejectBranch, NotificationChain msgs) {
		ThrottleOnRejectBranch oldOnRejectBranch = onRejectBranch;
		onRejectBranch = newOnRejectBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH, oldOnRejectBranch, newOnRejectBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnRejectBranch(ThrottleOnRejectBranch newOnRejectBranch) {
		if (newOnRejectBranch != onRejectBranch) {
			NotificationChain msgs = null;
			if (onRejectBranch != null)
				msgs = ((InternalEObject)onRejectBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH, null, msgs);
			if (newOnRejectBranch != null)
				msgs = ((InternalEObject)newOnRejectBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH, null, msgs);
			msgs = basicSetOnRejectBranch(newOnRejectBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH, newOnRejectBranch, newOnRejectBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(ThrottleMediatorInputConnector newInputConnector, NotificationChain msgs) {
		ThrottleMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(ThrottleMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(ThrottleMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		ThrottleMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(ThrottleMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ThrottleMediatorOnAcceptOutputConnector getOnAcceptOutputConnector() {
		return onAcceptOutputConnector;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetOnAcceptOutputConnector(ThrottleMediatorOnAcceptOutputConnector newOnAcceptOutputConnector, NotificationChain msgs) {
		ThrottleMediatorOnAcceptOutputConnector oldOnAcceptOutputConnector = onAcceptOutputConnector;
		onAcceptOutputConnector = newOnAcceptOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR, oldOnAcceptOutputConnector, newOnAcceptOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setOnAcceptOutputConnector(ThrottleMediatorOnAcceptOutputConnector newOnAcceptOutputConnector) {
		if (newOnAcceptOutputConnector != onAcceptOutputConnector) {
			NotificationChain msgs = null;
			if (onAcceptOutputConnector != null)
				msgs = ((InternalEObject)onAcceptOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR, null, msgs);
			if (newOnAcceptOutputConnector != null)
				msgs = ((InternalEObject)newOnAcceptOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOnAcceptOutputConnector(newOnAcceptOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR, newOnAcceptOutputConnector, newOnAcceptOutputConnector));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ThrottleMediatorOnRejectOutputConnector getOnRejectOutputConnector() {
		return onRejectOutputConnector;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetOnRejectOutputConnector(ThrottleMediatorOnRejectOutputConnector newOnRejectOutputConnector, NotificationChain msgs) {
		ThrottleMediatorOnRejectOutputConnector oldOnRejectOutputConnector = onRejectOutputConnector;
		onRejectOutputConnector = newOnRejectOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR, oldOnRejectOutputConnector, newOnRejectOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setOnRejectOutputConnector(ThrottleMediatorOnRejectOutputConnector newOnRejectOutputConnector) {
		if (newOnRejectOutputConnector != onRejectOutputConnector) {
			NotificationChain msgs = null;
			if (onRejectOutputConnector != null)
				msgs = ((InternalEObject)onRejectOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR, null, msgs);
			if (newOnRejectOutputConnector != null)
				msgs = ((InternalEObject)newOnRejectOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOnRejectOutputConnector(newOnRejectOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR, newOnRejectOutputConnector, newOnRejectOutputConnector));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ThrottleContainer getThrottleContainer() {
		return throttleContainer;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetThrottleContainer(ThrottleContainer newThrottleContainer, NotificationChain msgs) {
		ThrottleContainer oldThrottleContainer = throttleContainer;
		throttleContainer = newThrottleContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__THROTTLE_CONTAINER, oldThrottleContainer, newThrottleContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setThrottleContainer(ThrottleContainer newThrottleContainer) {
		if (newThrottleContainer != throttleContainer) {
			NotificationChain msgs = null;
			if (throttleContainer != null)
				msgs = ((InternalEObject)throttleContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__THROTTLE_CONTAINER, null, msgs);
			if (newThrottleContainer != null)
				msgs = ((InternalEObject)newThrottleContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__THROTTLE_CONTAINER, null, msgs);
			msgs = basicSetThrottleContainer(newThrottleContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__THROTTLE_CONTAINER, newThrottleContainer, newThrottleContainer));
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleSequenceType getOnAcceptBranchsequenceType() {
		return onAcceptBranchsequenceType;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnAcceptBranchsequenceType(ThrottleSequenceType newOnAcceptBranchsequenceType) {
		ThrottleSequenceType oldOnAcceptBranchsequenceType = onAcceptBranchsequenceType;
		onAcceptBranchsequenceType = newOnAcceptBranchsequenceType == null ? ON_ACCEPT_BRANCHSEQUENCE_TYPE_EDEFAULT : newOnAcceptBranchsequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_TYPE, oldOnAcceptBranchsequenceType, onAcceptBranchsequenceType));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOnAcceptBranchsequenceKey() {
		return onAcceptBranchsequenceKey;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnAcceptBranchsequenceKey(RegistryKeyProperty newOnAcceptBranchsequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldOnAcceptBranchsequenceKey = onAcceptBranchsequenceKey;
		onAcceptBranchsequenceKey = newOnAcceptBranchsequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY, oldOnAcceptBranchsequenceKey, newOnAcceptBranchsequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnAcceptBranchsequenceKey(RegistryKeyProperty newOnAcceptBranchsequenceKey) {
		if (newOnAcceptBranchsequenceKey != onAcceptBranchsequenceKey) {
			NotificationChain msgs = null;
			if (onAcceptBranchsequenceKey != null)
				msgs = ((InternalEObject)onAcceptBranchsequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY, null, msgs);
			if (newOnAcceptBranchsequenceKey != null)
				msgs = ((InternalEObject)newOnAcceptBranchsequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY, null, msgs);
			msgs = basicSetOnAcceptBranchsequenceKey(newOnAcceptBranchsequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY, newOnAcceptBranchsequenceKey, newOnAcceptBranchsequenceKey));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleSequenceType getOnRejectBranchsequenceType() {
		return onRejectBranchsequenceType;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnRejectBranchsequenceType(ThrottleSequenceType newOnRejectBranchsequenceType) {
		ThrottleSequenceType oldOnRejectBranchsequenceType = onRejectBranchsequenceType;
		onRejectBranchsequenceType = newOnRejectBranchsequenceType == null ? ON_REJECT_BRANCHSEQUENCE_TYPE_EDEFAULT : newOnRejectBranchsequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_TYPE, oldOnRejectBranchsequenceType, onRejectBranchsequenceType));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOnRejectBranchsequenceKey() {
		return onRejectBranchsequenceKey;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnRejectBranchsequenceKey(RegistryKeyProperty newOnRejectBranchsequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldOnRejectBranchsequenceKey = onRejectBranchsequenceKey;
		onRejectBranchsequenceKey = newOnRejectBranchsequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY, oldOnRejectBranchsequenceKey, newOnRejectBranchsequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnRejectBranchsequenceKey(RegistryKeyProperty newOnRejectBranchsequenceKey) {
		if (newOnRejectBranchsequenceKey != onRejectBranchsequenceKey) {
			NotificationChain msgs = null;
			if (onRejectBranchsequenceKey != null)
				msgs = ((InternalEObject)onRejectBranchsequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY, null, msgs);
			if (newOnRejectBranchsequenceKey != null)
				msgs = ((InternalEObject)newOnRejectBranchsequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY, null, msgs);
			msgs = basicSetOnRejectBranchsequenceKey(newOnRejectBranchsequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY, newOnRejectBranchsequenceKey, newOnRejectBranchsequenceKey));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_KEY:
				return basicSetPolicyKey(null, msgs);
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_ENTRIES:
				return ((InternalEList<?>)getPolicyEntries()).basicRemove(otherEnd, msgs);
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION:
				return basicSetPolicyConfiguration(null, msgs);
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH:
				return basicSetOnAcceptBranch(null, msgs);
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH:
				return basicSetOnRejectBranch(null, msgs);
			case EsbPackage.THROTTLE_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
				return basicSetOnAcceptOutputConnector(null, msgs);
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
				return basicSetOnRejectOutputConnector(null, msgs);
			case EsbPackage.THROTTLE_MEDIATOR__THROTTLE_CONTAINER:
				return basicSetThrottleContainer(null, msgs);
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY:
				return basicSetOnAcceptBranchsequenceKey(null, msgs);
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY:
				return basicSetOnRejectBranchsequenceKey(null, msgs);
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
			case EsbPackage.THROTTLE_MEDIATOR__GROUP_ID:
				return getGroupId();
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_TYPE:
				return getPolicyType();
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_KEY:
				return getPolicyKey();
			case EsbPackage.THROTTLE_MEDIATOR__MAX_CONCURRENT_ACCESS_COUNT:
				return getMaxConcurrentAccessCount();
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_ENTRIES:
				return getPolicyEntries();
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION:
				return getPolicyConfiguration();
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH:
				return getOnAcceptBranch();
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH:
				return getOnRejectBranch();
			case EsbPackage.THROTTLE_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
				return getOnAcceptOutputConnector();
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
				return getOnRejectOutputConnector();
			case EsbPackage.THROTTLE_MEDIATOR__THROTTLE_CONTAINER:
				return getThrottleContainer();
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_TYPE:
				return getOnAcceptBranchsequenceType();
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY:
				return getOnAcceptBranchsequenceKey();
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_TYPE:
				return getOnRejectBranchsequenceType();
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY:
				return getOnRejectBranchsequenceKey();
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
			case EsbPackage.THROTTLE_MEDIATOR__GROUP_ID:
				setGroupId((String)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_TYPE:
				setPolicyType((ThrottlePolicyType)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_KEY:
				setPolicyKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__MAX_CONCURRENT_ACCESS_COUNT:
				setMaxConcurrentAccessCount((Integer)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_ENTRIES:
				getPolicyEntries().clear();
				getPolicyEntries().addAll((Collection<? extends ThrottlePolicyEntry>)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION:
				setPolicyConfiguration((ThrottlePolicyConfiguration)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH:
				setOnAcceptBranch((ThrottleOnAcceptBranch)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH:
				setOnRejectBranch((ThrottleOnRejectBranch)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((ThrottleMediatorInputConnector)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((ThrottleMediatorOutputConnector)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
				setOnAcceptOutputConnector((ThrottleMediatorOnAcceptOutputConnector)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
				setOnRejectOutputConnector((ThrottleMediatorOnRejectOutputConnector)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__THROTTLE_CONTAINER:
				setThrottleContainer((ThrottleContainer)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_TYPE:
				setOnAcceptBranchsequenceType((ThrottleSequenceType)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY:
				setOnAcceptBranchsequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_TYPE:
				setOnRejectBranchsequenceType((ThrottleSequenceType)newValue);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY:
				setOnRejectBranchsequenceKey((RegistryKeyProperty)newValue);
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
			case EsbPackage.THROTTLE_MEDIATOR__GROUP_ID:
				setGroupId(GROUP_ID_EDEFAULT);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_TYPE:
				setPolicyType(POLICY_TYPE_EDEFAULT);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_KEY:
				setPolicyKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__MAX_CONCURRENT_ACCESS_COUNT:
				setMaxConcurrentAccessCount(MAX_CONCURRENT_ACCESS_COUNT_EDEFAULT);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_ENTRIES:
				getPolicyEntries().clear();
				return;
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION:
				setPolicyConfiguration((ThrottlePolicyConfiguration)null);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH:
				setOnAcceptBranch((ThrottleOnAcceptBranch)null);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH:
				setOnRejectBranch((ThrottleOnRejectBranch)null);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((ThrottleMediatorInputConnector)null);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((ThrottleMediatorOutputConnector)null);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
				setOnAcceptOutputConnector((ThrottleMediatorOnAcceptOutputConnector)null);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
				setOnRejectOutputConnector((ThrottleMediatorOnRejectOutputConnector)null);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__THROTTLE_CONTAINER:
				setThrottleContainer((ThrottleContainer)null);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_TYPE:
				setOnAcceptBranchsequenceType(ON_ACCEPT_BRANCHSEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY:
				setOnAcceptBranchsequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_TYPE:
				setOnRejectBranchsequenceType(ON_REJECT_BRANCHSEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY:
				setOnRejectBranchsequenceKey((RegistryKeyProperty)null);
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
			case EsbPackage.THROTTLE_MEDIATOR__GROUP_ID:
				return GROUP_ID_EDEFAULT == null ? groupId != null : !GROUP_ID_EDEFAULT.equals(groupId);
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_TYPE:
				return policyType != POLICY_TYPE_EDEFAULT;
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_KEY:
				return policyKey != null;
			case EsbPackage.THROTTLE_MEDIATOR__MAX_CONCURRENT_ACCESS_COUNT:
				return maxConcurrentAccessCount != MAX_CONCURRENT_ACCESS_COUNT_EDEFAULT;
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_ENTRIES:
				return policyEntries != null && !policyEntries.isEmpty();
			case EsbPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION:
				return policyConfiguration != null;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH:
				return onAcceptBranch != null;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH:
				return onRejectBranch != null;
			case EsbPackage.THROTTLE_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.THROTTLE_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_OUTPUT_CONNECTOR:
				return onAcceptOutputConnector != null;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_OUTPUT_CONNECTOR:
				return onRejectOutputConnector != null;
			case EsbPackage.THROTTLE_MEDIATOR__THROTTLE_CONTAINER:
				return throttleContainer != null;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_TYPE:
				return onAcceptBranchsequenceType != ON_ACCEPT_BRANCHSEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCHSEQUENCE_KEY:
				return onAcceptBranchsequenceKey != null;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_TYPE:
				return onRejectBranchsequenceType != ON_REJECT_BRANCHSEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCHSEQUENCE_KEY:
				return onRejectBranchsequenceKey != null;
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
		result.append(" (groupId: ");
		result.append(groupId);
		result.append(", policyType: ");
		result.append(policyType);
		result.append(", maxConcurrentAccessCount: ");
		result.append(maxConcurrentAccessCount);
		result.append(", OnAcceptBranchsequenceType: ");
		result.append(onAcceptBranchsequenceType);
		result.append(", OnRejectBranchsequenceType: ");
		result.append(onRejectBranchsequenceType);
		result.append(')');
		return result.toString();
	}

} //ThrottleMediatorImpl
