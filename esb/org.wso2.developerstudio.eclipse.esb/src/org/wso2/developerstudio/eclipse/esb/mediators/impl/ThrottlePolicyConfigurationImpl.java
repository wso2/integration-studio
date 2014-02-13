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
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyType;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throttle Policy Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyConfigurationImpl#getPolicyType <em>Policy Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyConfigurationImpl#getPolicyKey <em>Policy Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyConfigurationImpl#getMaxConcurrentAccessCount <em>Max Concurrent Access Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyConfigurationImpl#getPolicyEntries <em>Policy Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThrottlePolicyConfigurationImpl extends ModelObjectImpl implements ThrottlePolicyConfiguration {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected ThrottlePolicyConfigurationImpl() {
		super();
		
		// Policy key.
		RegistryKeyProperty policyKey = getEsbFactory().createRegistryKeyProperty();
		policyKey.setPrettyName("Policy Key");
		policyKey.setKeyName("key");
		policyKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setPolicyKey(policyKey);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {		
		if (self.hasAttribute("key")) {
			getPolicyKey().load(self);
		} else {
			// In-line policy.
			Element policyElem = getChildElement(self, "Policy");
			if (null != policyElem) {
				Element mediatorThrottleAssertionElem = 
					getChildElement(policyElem, "MediatorThrottleAssertion");
				if (null != mediatorThrottleAssertionElem) {
					// Maximum concurrent access count.
					Element elemMaximumConcurrentAccess = 
						getChildElement(mediatorThrottleAssertionElem, "MaximumConcurrentAccess");
					if (null != elemMaximumConcurrentAccess) {
						setMaxConcurrentAccessCount(Integer.parseInt(elemMaximumConcurrentAccess.getTextContent()));
					}
					
					// Policy entries
					loadObjects(mediatorThrottleAssertionElem, "Policy", ThrottlePolicyEntry.class,
							new ObjectHandler<ThrottlePolicyEntry>() {
								public void handle(ThrottlePolicyEntry object) {
									getPolicyEntries().add(object);
								}
							});							
				} else {
					throw new Exception("Unknown throttle policy configuration.");
				}
			} else {
				throw new Exception("Expected throttle policy configuration.");
			}
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		String policyNsPrefix = WS_POLICY_NAMESAPCE_PREFIX;
		String policyNsURI = WS_POLICY_NAMESPACE_URI;
		
		String throttleNsPrefix = WSO2_THROTTLE_NAMESPACE_PREFIX;
		String throttleNsURI = WSO2_THROTTLE_NAMESPACE_URI;
		
		Element self = createChildElement(parent, "policy");

		// Policy definition.
		if (getPolicyType().equals(ThrottlePolicyType.REGISTRY_REFERENCE)) {
			getPolicyKey().save(self);			
		} else {
			Element policyElem = createChildElement(self, policyNsURI, policyNsPrefix, "Policy");			
			policyElem.setAttributeNS(WSS_UTILITY_NAMESPACE_URI, 
					String.format("%s:Id", WSS_UTILITY_NAMESPACE_PREFIX), "WSO2MediatorThrottlingPolicy");

			Element mediatorThrottleAssertionElem = 
				createChildElement(policyElem, throttleNsURI, throttleNsPrefix, "MediatorThrottleAssertion");
			
			// Maximum concurrent access count.
			if (getMaxConcurrentAccessCount() > 0) {
				Element elemMaximumConcurrentAccess = 
					createChildElement(mediatorThrottleAssertionElem,
							throttleNsURI, throttleNsPrefix, "MaximumConcurrentAccess");
				elemMaximumConcurrentAccess.setTextContent(Integer.toString(getMaxConcurrentAccessCount()));
			}

			// Policy entries.
			for (ThrottlePolicyEntry policyEntry : getPolicyEntries()) {
				policyEntry.save(mediatorThrottleAssertionElem);
			}
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
		return MediatorsPackage.Literals.THROTTLE_POLICY_CONFIGURATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_TYPE, oldPolicyType, policyType));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_KEY, oldPolicyKey, newPolicyKey);
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
				msgs = ((InternalEObject)policyKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_KEY, null, msgs);
			if (newPolicyKey != null)
				msgs = ((InternalEObject)newPolicyKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_KEY, null, msgs);
			msgs = basicSetPolicyKey(newPolicyKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_KEY, newPolicyKey, newPolicyKey));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__MAX_CONCURRENT_ACCESS_COUNT, oldMaxConcurrentAccessCount, maxConcurrentAccessCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThrottlePolicyEntry> getPolicyEntries() {
		if (policyEntries == null) {
			policyEntries = new EObjectContainmentEList<ThrottlePolicyEntry>(ThrottlePolicyEntry.class, this, MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_ENTRIES);
		}
		return policyEntries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_KEY:
				return basicSetPolicyKey(null, msgs);
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_ENTRIES:
				return ((InternalEList<?>)getPolicyEntries()).basicRemove(otherEnd, msgs);
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
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_TYPE:
				return getPolicyType();
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_KEY:
				return getPolicyKey();
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__MAX_CONCURRENT_ACCESS_COUNT:
				return getMaxConcurrentAccessCount();
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_ENTRIES:
				return getPolicyEntries();
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
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_TYPE:
				setPolicyType((ThrottlePolicyType)newValue);
				return;
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_KEY:
				setPolicyKey((RegistryKeyProperty)newValue);
				return;
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__MAX_CONCURRENT_ACCESS_COUNT:
				setMaxConcurrentAccessCount((Integer)newValue);
				return;
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_ENTRIES:
				getPolicyEntries().clear();
				getPolicyEntries().addAll((Collection<? extends ThrottlePolicyEntry>)newValue);
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
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_TYPE:
				setPolicyType(POLICY_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_KEY:
				setPolicyKey((RegistryKeyProperty)null);
				return;
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__MAX_CONCURRENT_ACCESS_COUNT:
				setMaxConcurrentAccessCount(MAX_CONCURRENT_ACCESS_COUNT_EDEFAULT);
				return;
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_ENTRIES:
				getPolicyEntries().clear();
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
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_TYPE:
				return policyType != POLICY_TYPE_EDEFAULT;
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_KEY:
				return policyKey != null;
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__MAX_CONCURRENT_ACCESS_COUNT:
				return maxConcurrentAccessCount != MAX_CONCURRENT_ACCESS_COUNT_EDEFAULT;
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION__POLICY_ENTRIES:
				return policyEntries != null && !policyEntries.isEmpty();
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
		result.append(" (policyType: ");
		result.append(policyType);
		result.append(", maxConcurrentAccessCount: ");
		result.append(maxConcurrentAccessCount);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }
	

} //ThrottlePolicyConfigurationImpl
