/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleAccessType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleConditionType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throttle Policy Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottlePolicyEntryImpl#getThrottleType <em>Throttle Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottlePolicyEntryImpl#getThrottleRange <em>Throttle Range</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottlePolicyEntryImpl#getAccessType <em>Access Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottlePolicyEntryImpl#getMaxRequestCount <em>Max Request Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottlePolicyEntryImpl#getUnitTime <em>Unit Time</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottlePolicyEntryImpl#getProhibitPeriod <em>Prohibit Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThrottlePolicyEntryImpl extends EObjectImpl implements ThrottlePolicyEntry {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.THROTTLE_POLICY_ENTRY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_POLICY_ENTRY__THROTTLE_TYPE, oldThrottleType, throttleType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_POLICY_ENTRY__THROTTLE_RANGE, oldThrottleRange, throttleRange));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_POLICY_ENTRY__ACCESS_TYPE, oldAccessType, accessType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT, oldMaxRequestCount, maxRequestCount));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_POLICY_ENTRY__UNIT_TIME, oldUnitTime, unitTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD, oldProhibitPeriod, prohibitPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.THROTTLE_POLICY_ENTRY__THROTTLE_TYPE:
				return getThrottleType();
			case EsbPackage.THROTTLE_POLICY_ENTRY__THROTTLE_RANGE:
				return getThrottleRange();
			case EsbPackage.THROTTLE_POLICY_ENTRY__ACCESS_TYPE:
				return getAccessType();
			case EsbPackage.THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT:
				return getMaxRequestCount();
			case EsbPackage.THROTTLE_POLICY_ENTRY__UNIT_TIME:
				return getUnitTime();
			case EsbPackage.THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD:
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
			case EsbPackage.THROTTLE_POLICY_ENTRY__THROTTLE_TYPE:
				setThrottleType((ThrottleConditionType)newValue);
				return;
			case EsbPackage.THROTTLE_POLICY_ENTRY__THROTTLE_RANGE:
				setThrottleRange((String)newValue);
				return;
			case EsbPackage.THROTTLE_POLICY_ENTRY__ACCESS_TYPE:
				setAccessType((ThrottleAccessType)newValue);
				return;
			case EsbPackage.THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT:
				setMaxRequestCount((Integer)newValue);
				return;
			case EsbPackage.THROTTLE_POLICY_ENTRY__UNIT_TIME:
				setUnitTime((Integer)newValue);
				return;
			case EsbPackage.THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD:
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
			case EsbPackage.THROTTLE_POLICY_ENTRY__THROTTLE_TYPE:
				setThrottleType(THROTTLE_TYPE_EDEFAULT);
				return;
			case EsbPackage.THROTTLE_POLICY_ENTRY__THROTTLE_RANGE:
				setThrottleRange(THROTTLE_RANGE_EDEFAULT);
				return;
			case EsbPackage.THROTTLE_POLICY_ENTRY__ACCESS_TYPE:
				setAccessType(ACCESS_TYPE_EDEFAULT);
				return;
			case EsbPackage.THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT:
				setMaxRequestCount(MAX_REQUEST_COUNT_EDEFAULT);
				return;
			case EsbPackage.THROTTLE_POLICY_ENTRY__UNIT_TIME:
				setUnitTime(UNIT_TIME_EDEFAULT);
				return;
			case EsbPackage.THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD:
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
			case EsbPackage.THROTTLE_POLICY_ENTRY__THROTTLE_TYPE:
				return throttleType != THROTTLE_TYPE_EDEFAULT;
			case EsbPackage.THROTTLE_POLICY_ENTRY__THROTTLE_RANGE:
				return THROTTLE_RANGE_EDEFAULT == null ? throttleRange != null : !THROTTLE_RANGE_EDEFAULT.equals(throttleRange);
			case EsbPackage.THROTTLE_POLICY_ENTRY__ACCESS_TYPE:
				return accessType != ACCESS_TYPE_EDEFAULT;
			case EsbPackage.THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT:
				return maxRequestCount != MAX_REQUEST_COUNT_EDEFAULT;
			case EsbPackage.THROTTLE_POLICY_ENTRY__UNIT_TIME:
				return unitTime != UNIT_TIME_EDEFAULT;
			case EsbPackage.THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD:
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

} //ThrottlePolicyEntryImpl
