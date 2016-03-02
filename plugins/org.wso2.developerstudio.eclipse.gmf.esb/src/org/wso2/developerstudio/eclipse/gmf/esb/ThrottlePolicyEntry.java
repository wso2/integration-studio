/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throttle Policy Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getThrottleType <em>Throttle Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getThrottleRange <em>Throttle Range</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getAccessType <em>Access Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getMaxRequestCount <em>Max Request Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getUnitTime <em>Unit Time</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getProhibitPeriod <em>Prohibit Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyEntry()
 * @model
 * @generated
 */
public interface ThrottlePolicyEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Throttle Type</b></em>' attribute.
	 * The default value is <code>"IP"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleConditionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throttle Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throttle Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottleConditionType
	 * @see #setThrottleType(ThrottleConditionType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyEntry_ThrottleType()
	 * @model default="IP"
	 * @generated
	 */
	ThrottleConditionType getThrottleType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getThrottleType <em>Throttle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throttle Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottleConditionType
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyEntry_ThrottleRange()
	 * @model default="other"
	 * @generated
	 */
	String getThrottleRange();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getThrottleRange <em>Throttle Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throttle Range</em>' attribute.
	 * @see #getThrottleRange()
	 * @generated
	 */
	void setThrottleRange(String value);

	/**
	 * Returns the value of the '<em><b>Access Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleAccessType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottleAccessType
	 * @see #setAccessType(ThrottleAccessType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyEntry_AccessType()
	 * @model
	 * @generated
	 */
	ThrottleAccessType getAccessType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getAccessType <em>Access Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottleAccessType
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyEntry_MaxRequestCount()
	 * @model
	 * @generated
	 */
	int getMaxRequestCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getMaxRequestCount <em>Max Request Count</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyEntry_UnitTime()
	 * @model
	 * @generated
	 */
	int getUnitTime();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getUnitTime <em>Unit Time</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyEntry_ProhibitPeriod()
	 * @model
	 * @generated
	 */
	int getProhibitPeriod();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry#getProhibitPeriod <em>Prohibit Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prohibit Period</em>' attribute.
	 * @see #getProhibitPeriod()
	 * @generated
	 */
	void setProhibitPeriod(int value);

} // ThrottlePolicyEntry
