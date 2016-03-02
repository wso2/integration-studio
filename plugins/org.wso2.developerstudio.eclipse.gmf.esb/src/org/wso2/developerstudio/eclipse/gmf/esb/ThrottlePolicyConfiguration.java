/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throttle Policy Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyConfiguration#getPolicyType <em>Policy Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyConfiguration#getPolicyKey <em>Policy Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyConfiguration#getMaxConcurrentAccessCount <em>Max Concurrent Access Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyConfiguration#getPolicyEntries <em>Policy Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyConfiguration()
 * @model
 * @generated
 */
public interface ThrottlePolicyConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Policy Type</b></em>' attribute.
	 * The default value is <code>"INLINE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType
	 * @see #setPolicyType(ThrottlePolicyType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyConfiguration_PolicyType()
	 * @model default="INLINE"
	 * @generated
	 */
	ThrottlePolicyType getPolicyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyConfiguration#getPolicyType <em>Policy Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType
	 * @see #getPolicyType()
	 * @generated
	 */
	void setPolicyType(ThrottlePolicyType value);

	/**
	 * Returns the value of the '<em><b>Policy Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Key</em>' containment reference.
	 * @see #setPolicyKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyConfiguration_PolicyKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getPolicyKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyConfiguration#getPolicyKey <em>Policy Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Key</em>' containment reference.
	 * @see #getPolicyKey()
	 * @generated
	 */
	void setPolicyKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Max Concurrent Access Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Concurrent Access Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Concurrent Access Count</em>' attribute.
	 * @see #setMaxConcurrentAccessCount(int)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyConfiguration_MaxConcurrentAccessCount()
	 * @model
	 * @generated
	 */
	int getMaxConcurrentAccessCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyConfiguration#getMaxConcurrentAccessCount <em>Max Concurrent Access Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Concurrent Access Count</em>' attribute.
	 * @see #getMaxConcurrentAccessCount()
	 * @generated
	 */
	void setMaxConcurrentAccessCount(int value);

	/**
	 * Returns the value of the '<em><b>Policy Entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Entries</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottlePolicyConfiguration_PolicyEntries()
	 * @model containment="true"
	 * @generated
	 */
	EList<ThrottlePolicyEntry> getPolicyEntries();

} // ThrottlePolicyConfiguration
