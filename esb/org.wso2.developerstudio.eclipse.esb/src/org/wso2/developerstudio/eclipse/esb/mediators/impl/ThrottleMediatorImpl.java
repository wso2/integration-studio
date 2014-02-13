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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnAcceptBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnRejectBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throttle Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleMediatorImpl#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleMediatorImpl#getPolicyConfiguration <em>Policy Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleMediatorImpl#getOnAcceptBranch <em>On Accept Branch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleMediatorImpl#getOnRejectBranch <em>On Reject Branch</em>}</li>
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected ThrottleMediatorImpl() {
		super();		
		setOnAcceptBranch(getMediatorFactory().createThrottleOnAcceptBranch());
		setOnRejectBranch(getMediatorFactory().createThrottleOnRejectBranch());
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		if (self.hasAttribute("id")) {
			setGroupId(self.getAttribute("id"));
		} else {
			throw new Exception("Expected throttle group id.");
		}	
		
		// Policy configuration.
		loadObject(self, "policy", ThrottlePolicyConfiguration.class, false, new ObjectHandler<ThrottlePolicyConfiguration>() {
			public void handle(ThrottlePolicyConfiguration object) {
				setPolicyConfiguration(object);
			}
		});
		
		getOnAcceptBranch().load(self);				
		getOnRejectBranch().load(self);
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "throttle");
		self.setAttribute("id", getGroupId());		
		
		if (null != getPolicyConfiguration()) {
			getPolicyConfiguration().save(self);
		}
		getOnAcceptBranch().save(self);				
		getOnRejectBranch().save(self);
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
		return MediatorsPackage.Literals.THROTTLE_MEDIATOR;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH, oldOnAcceptBranch, newOnAcceptBranch);
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
				msgs = ((InternalEObject)onAcceptBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH, null, msgs);
			if (newOnAcceptBranch != null)
				msgs = ((InternalEObject)newOnAcceptBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH, null, msgs);
			msgs = basicSetOnAcceptBranch(newOnAcceptBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH, newOnAcceptBranch, newOnAcceptBranch));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH, oldOnRejectBranch, newOnRejectBranch);
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
				msgs = ((InternalEObject)onRejectBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH, null, msgs);
			if (newOnRejectBranch != null)
				msgs = ((InternalEObject)newOnRejectBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH, null, msgs);
			msgs = basicSetOnRejectBranch(newOnRejectBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH, newOnRejectBranch, newOnRejectBranch));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_MEDIATOR__GROUP_ID, oldGroupId, groupId));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION, oldPolicyConfiguration, newPolicyConfiguration);
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
				msgs = ((InternalEObject)policyConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION, null, msgs);
			if (newPolicyConfiguration != null)
				msgs = ((InternalEObject)newPolicyConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION, null, msgs);
			msgs = basicSetPolicyConfiguration(newPolicyConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION, newPolicyConfiguration, newPolicyConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION:
				return basicSetPolicyConfiguration(null, msgs);
			case MediatorsPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH:
				return basicSetOnAcceptBranch(null, msgs);
			case MediatorsPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH:
				return basicSetOnRejectBranch(null, msgs);
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
			case MediatorsPackage.THROTTLE_MEDIATOR__GROUP_ID:
				return getGroupId();
			case MediatorsPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION:
				return getPolicyConfiguration();
			case MediatorsPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH:
				return getOnAcceptBranch();
			case MediatorsPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH:
				return getOnRejectBranch();
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
			case MediatorsPackage.THROTTLE_MEDIATOR__GROUP_ID:
				setGroupId((String)newValue);
				return;
			case MediatorsPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION:
				setPolicyConfiguration((ThrottlePolicyConfiguration)newValue);
				return;
			case MediatorsPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH:
				setOnAcceptBranch((ThrottleOnAcceptBranch)newValue);
				return;
			case MediatorsPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH:
				setOnRejectBranch((ThrottleOnRejectBranch)newValue);
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
			case MediatorsPackage.THROTTLE_MEDIATOR__GROUP_ID:
				setGroupId(GROUP_ID_EDEFAULT);
				return;
			case MediatorsPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION:
				setPolicyConfiguration((ThrottlePolicyConfiguration)null);
				return;
			case MediatorsPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH:
				setOnAcceptBranch((ThrottleOnAcceptBranch)null);
				return;
			case MediatorsPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH:
				setOnRejectBranch((ThrottleOnRejectBranch)null);
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
			case MediatorsPackage.THROTTLE_MEDIATOR__GROUP_ID:
				return GROUP_ID_EDEFAULT == null ? groupId != null : !GROUP_ID_EDEFAULT.equals(groupId);
			case MediatorsPackage.THROTTLE_MEDIATOR__POLICY_CONFIGURATION:
				return policyConfiguration != null;
			case MediatorsPackage.THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH:
				return onAcceptBranch != null;
			case MediatorsPackage.THROTTLE_MEDIATOR__ON_REJECT_BRANCH:
				return onRejectBranch != null;
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
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
 		if (null == getGroupId()|| getGroupId().trim().isEmpty()) {
 			validateMap.put("Group id", "Group id is empty");
 		}			
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("Throttle Mediator", objectValidator);
 	    return mediatorValidateMap;
    }

} //ThrottleMediatorImpl
