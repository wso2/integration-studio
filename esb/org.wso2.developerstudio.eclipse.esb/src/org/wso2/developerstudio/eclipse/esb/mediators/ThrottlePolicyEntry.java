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
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.wso2.developerstudio.eclipse.esb.ModelObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throttle Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getThrottleType <em>Throttle Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getThrottleRange <em>Throttle Range</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getAccessType <em>Access Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getMaxRequestCount <em>Max Request Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getUnitTime <em>Unit Time</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getProhibitPeriod <em>Prohibit Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyEntry()
 * @model
 * @generated
 */
public interface ThrottlePolicyEntry extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Throttle Type</b></em>' attribute.
	 * The default value is <code>"IP"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleConditionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throttle Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throttle Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleConditionType
	 * @see #setThrottleType(ThrottleConditionType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyEntry_ThrottleType()
	 * @model default="IP"
	 * @generated
	 */
	ThrottleConditionType getThrottleType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getThrottleType <em>Throttle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throttle Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleConditionType
	 * @see #getThrottleType()
	 * @generated
	 */
	void setThrottleType(ThrottleConditionType value);

	/**
	 * Returns the value of the '<em><b>Throttle Range</b></em>' attribute.
	 * The default value is <code>"other"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throttle Range</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throttle Range</em>' attribute.
	 * @see #setThrottleRange(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyEntry_ThrottleRange()
	 * @model default="other"
	 * @generated
	 */
	String getThrottleRange();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getThrottleRange <em>Throttle Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throttle Range</em>' attribute.
	 * @see #getThrottleRange()
	 * @generated
	 */
	void setThrottleRange(String value);

	/**
	 * Returns the value of the '<em><b>Access Type</b></em>' attribute.
	 * The default value is <code>"ALLOW"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleAccessType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleAccessType
	 * @see #setAccessType(ThrottleAccessType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyEntry_AccessType()
	 * @model default="ALLOW"
	 * @generated
	 */
	ThrottleAccessType getAccessType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getAccessType <em>Access Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleAccessType
	 * @see #getAccessType()
	 * @generated
	 */
	void setAccessType(ThrottleAccessType value);

	/**
	 * Returns the value of the '<em><b>Max Request Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Request Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Request Count</em>' attribute.
	 * @see #setMaxRequestCount(int)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyEntry_MaxRequestCount()
	 * @model
	 * @generated
	 */
	int getMaxRequestCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getMaxRequestCount <em>Max Request Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Request Count</em>' attribute.
	 * @see #getMaxRequestCount()
	 * @generated
	 */
	void setMaxRequestCount(int value);

	/**
	 * Returns the value of the '<em><b>Unit Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Time</em>' attribute.
	 * @see #setUnitTime(int)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyEntry_UnitTime()
	 * @model
	 * @generated
	 */
	int getUnitTime();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getUnitTime <em>Unit Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Time</em>' attribute.
	 * @see #getUnitTime()
	 * @generated
	 */
	void setUnitTime(int value);

	/**
	 * Returns the value of the '<em><b>Prohibit Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prohibit Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prohibit Period</em>' attribute.
	 * @see #setProhibitPeriod(int)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyEntry_ProhibitPeriod()
	 * @model
	 * @generated
	 */
	int getProhibitPeriod();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getProhibitPeriod <em>Prohibit Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prohibit Period</em>' attribute.
	 * @see #getProhibitPeriod()
	 * @generated
	 */
	void setProhibitPeriod(int value);

} // ThrottlePolicy
