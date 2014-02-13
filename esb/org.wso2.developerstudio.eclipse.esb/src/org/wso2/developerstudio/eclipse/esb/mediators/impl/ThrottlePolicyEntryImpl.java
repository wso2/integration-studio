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

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleAccessType;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleConditionType;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throttle Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyEntryImpl#getThrottleType <em>Throttle Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyEntryImpl#getThrottleRange <em>Throttle Range</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyEntryImpl#getAccessType <em>Access Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyEntryImpl#getMaxRequestCount <em>Max Request Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyEntryImpl#getUnitTime <em>Unit Time</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyEntryImpl#getProhibitPeriod <em>Prohibit Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThrottlePolicyEntryImpl extends ModelObjectImpl implements ThrottlePolicyEntry {
	/**
	 * The default value of the '{@link #getThrottleType() <em>Throttle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottleType()
	 * @generated
	 * @ordered
	 */
	protected static final ThrottleConditionType THROTTLE_TYPE_EDEFAULT = ThrottleConditionType.IP;

	/**
	 * The cached value of the '{@link #getThrottleType() <em>Throttle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottleType()
	 * @generated
	 * @ordered
	 */
	protected ThrottleConditionType throttleType = THROTTLE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getThrottleRange() <em>Throttle Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottleRange()
	 * @generated
	 * @ordered
	 */
	protected static final String THROTTLE_RANGE_EDEFAULT = "other";

	/**
	 * The cached value of the '{@link #getThrottleRange() <em>Throttle Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottleRange()
	 * @generated
	 * @ordered
	 */
	protected String throttleRange = THROTTLE_RANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAccessType() <em>Access Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessType()
	 * @generated
	 * @ordered
	 */
	protected static final ThrottleAccessType ACCESS_TYPE_EDEFAULT = ThrottleAccessType.ALLOW;

	/**
	 * The cached value of the '{@link #getAccessType() <em>Access Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessType()
	 * @generated
	 * @ordered
	 */
	protected ThrottleAccessType accessType = ACCESS_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxRequestCount() <em>Max Request Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxRequestCount()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_REQUEST_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxRequestCount() <em>Max Request Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxRequestCount()
	 * @generated
	 * @ordered
	 */
	protected int maxRequestCount = MAX_REQUEST_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnitTime() <em>Unit Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitTime()
	 * @generated
	 * @ordered
	 */
	protected static final int UNIT_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUnitTime() <em>Unit Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitTime()
	 * @generated
	 * @ordered
	 */
	protected int unitTime = UNIT_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProhibitPeriod() <em>Prohibit Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProhibitPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final int PROHIBIT_PERIOD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getProhibitPeriod() <em>Prohibit Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProhibitPeriod()
	 * @generated
	 * @ordered
	 */
	protected int prohibitPeriod = PROHIBIT_PERIOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThrottlePolicyEntryImpl() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Throttle id.
		Element idElem = getChildElement(self, "ID");
		if (null != idElem) {
			ThrottleConditionType conditionType = 
				ThrottleConditionType.get(idElem.getAttributeNS(WSO2_THROTTLE_NAMESPACE_URI, "type"));
			if (null != conditionType) {
				setThrottleType(conditionType);
			}
			setThrottleRange(idElem.getTextContent());			
		} else {
			throw new Exception("Expected id element.");
		}
		
		// Policy definition.
		Element policyElem = getChildElement(self, "Policy");
		if (null != policyElem) {		
			Element allowElem = getChildElement(policyElem, "Allow");
			Element denyElem = getChildElement(policyElem, "Deny");
			Element controlElem = getChildElement(policyElem, "Control");
			
			if (null != allowElem) {
				setAccessType(ThrottleAccessType.ALLOW);
			} else if (null != denyElem) {
				setAccessType(ThrottleAccessType.DENY);
			} else if (null != controlElem) {
				setAccessType(ThrottleAccessType.CONTROL);
				
				// Control policy.
				Element controlPolicyElem = getChildElement(controlElem, "Policy");
				
				Element maxCountElem = getChildElement(controlPolicyElem, "MaximumCount");
				if (null != maxCountElem) {
					setMaxRequestCount(Integer.parseInt(maxCountElem.getTextContent()));
				}
				
				Element unitTimeElem = getChildElement(controlPolicyElem, "UnitTime");
				if (null != unitTimeElem) {
					setUnitTime(Integer.parseInt(unitTimeElem.getTextContent()));
				}
				
				Element prohibitPeriodElem = getChildElement(controlPolicyElem, "ProhibitTimePeriod");
				if (null != prohibitPeriodElem) {
					setProhibitPeriod(Integer.parseInt(prohibitPeriodElem.getTextContent()));
				}
			} else {
				throw new Exception("Unknown throttle policy entry.");
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
		
		Element self = createChildElement(parent, policyNsURI, policyNsPrefix, "Policy");

		// Throttle id.
		Element idElem = createChildElement(self, throttleNsURI, throttleNsPrefix, "ID");
		idElem.setAttributeNS(throttleNsURI, String.format("%s:%s", throttleNsPrefix, "type"), getThrottleType().getLiteral());
		idElem.setTextContent(getThrottleRange());
		
		// Policy definition.
		Element policyElem = createChildElement(self, policyNsURI, policyNsPrefix, "Policy");
		switch (getAccessType()) {
			case ALLOW : {
				createChildElement(policyElem, throttleNsURI, throttleNsPrefix, "Allow");
				break;
			}
			
			case DENY : {
				createChildElement(policyElem, throttleNsURI, throttleNsPrefix, "Deny");
				break;
			}
			
			case CONTROL : {
				Element controlElem = 
					createChildElement(policyElem, throttleNsURI, throttleNsPrefix, "Control");
				Element controlPolicyElem = 
					createChildElement(controlElem, policyNsURI, policyNsPrefix, "Policy");
				
				Element maxCountElem = 
					createChildElement(controlPolicyElem, throttleNsURI, throttleNsPrefix, "MaximumCount");
				maxCountElem.setTextContent(Integer.toString(getMaxRequestCount()));
				
				Element unitTimeElem = 
					createChildElement(controlPolicyElem, throttleNsURI, throttleNsPrefix, "UnitTime");
				unitTimeElem.setTextContent(Integer.toString(getUnitTime()));
				
				Element prohibitPeriodElem = 
					createChildElement(controlPolicyElem, throttleNsURI, throttleNsPrefix, "ProhibitTimePeriod");
				prohibitPeriodElem.setTextContent(Integer.toString(getProhibitPeriod()));
				prohibitPeriodElem.setAttributeNS(policyNsURI, String.format("%s:%s", policyNsPrefix, "Optional"), "true");
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
		return MediatorsPackage.Literals.THROTTLE_POLICY_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleConditionType getThrottleType() {
		return throttleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrottleType(ThrottleConditionType newThrottleType) {
		ThrottleConditionType oldThrottleType = throttleType;
		throttleType = newThrottleType == null ? THROTTLE_TYPE_EDEFAULT : newThrottleType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_POLICY_ENTRY__THROTTLE_TYPE, oldThrottleType, throttleType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThrottleRange() {
		return throttleRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrottleRange(String newThrottleRange) {
		String oldThrottleRange = throttleRange;
		throttleRange = newThrottleRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_POLICY_ENTRY__THROTTLE_RANGE, oldThrottleRange, throttleRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleAccessType getAccessType() {
		return accessType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessType(ThrottleAccessType newAccessType) {
		ThrottleAccessType oldAccessType = accessType;
		accessType = newAccessType == null ? ACCESS_TYPE_EDEFAULT : newAccessType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_POLICY_ENTRY__ACCESS_TYPE, oldAccessType, accessType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxRequestCount() {
		return maxRequestCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxRequestCount(int newMaxRequestCount) {
		int oldMaxRequestCount = maxRequestCount;
		maxRequestCount = newMaxRequestCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT, oldMaxRequestCount, maxRequestCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUnitTime() {
		return unitTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitTime(int newUnitTime) {
		int oldUnitTime = unitTime;
		unitTime = newUnitTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_POLICY_ENTRY__UNIT_TIME, oldUnitTime, unitTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProhibitPeriod() {
		return prohibitPeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProhibitPeriod(int newProhibitPeriod) {
		int oldProhibitPeriod = prohibitPeriod;
		prohibitPeriod = newProhibitPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD, oldProhibitPeriod, prohibitPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__THROTTLE_TYPE:
				return getThrottleType();
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__THROTTLE_RANGE:
				return getThrottleRange();
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__ACCESS_TYPE:
				return getAccessType();
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT:
				return getMaxRequestCount();
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__UNIT_TIME:
				return getUnitTime();
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD:
				return getProhibitPeriod();
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
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__THROTTLE_TYPE:
				setThrottleType((ThrottleConditionType)newValue);
				return;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__THROTTLE_RANGE:
				setThrottleRange((String)newValue);
				return;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__ACCESS_TYPE:
				setAccessType((ThrottleAccessType)newValue);
				return;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT:
				setMaxRequestCount((Integer)newValue);
				return;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__UNIT_TIME:
				setUnitTime((Integer)newValue);
				return;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD:
				setProhibitPeriod((Integer)newValue);
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
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__THROTTLE_TYPE:
				setThrottleType(THROTTLE_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__THROTTLE_RANGE:
				setThrottleRange(THROTTLE_RANGE_EDEFAULT);
				return;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__ACCESS_TYPE:
				setAccessType(ACCESS_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT:
				setMaxRequestCount(MAX_REQUEST_COUNT_EDEFAULT);
				return;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__UNIT_TIME:
				setUnitTime(UNIT_TIME_EDEFAULT);
				return;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD:
				setProhibitPeriod(PROHIBIT_PERIOD_EDEFAULT);
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
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__THROTTLE_TYPE:
				return throttleType != THROTTLE_TYPE_EDEFAULT;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__THROTTLE_RANGE:
				return THROTTLE_RANGE_EDEFAULT == null ? throttleRange != null : !THROTTLE_RANGE_EDEFAULT.equals(throttleRange);
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__ACCESS_TYPE:
				return accessType != ACCESS_TYPE_EDEFAULT;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT:
				return maxRequestCount != MAX_REQUEST_COUNT_EDEFAULT;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__UNIT_TIME:
				return unitTime != UNIT_TIME_EDEFAULT;
			case MediatorsPackage.THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD:
				return prohibitPeriod != PROHIBIT_PERIOD_EDEFAULT;
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
		result.append(" (throttleType: ");
		result.append(throttleType);
		result.append(", throttleRange: ");
		result.append(throttleRange);
		result.append(", accessType: ");
		result.append(accessType);
		result.append(", maxRequestCount: ");
		result.append(maxRequestCount);
		result.append(", unitTime: ");
		result.append(unitTime);
		result.append(", prohibitPeriod: ");
		result.append(prohibitPeriod);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }


} //ThrottlePolicyImpl
