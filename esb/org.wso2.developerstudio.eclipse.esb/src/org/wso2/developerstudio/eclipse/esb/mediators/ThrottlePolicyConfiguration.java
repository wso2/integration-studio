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

import org.eclipse.emf.common.util.EList;
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throttle Policy Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getPolicyType <em>Policy Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getPolicyKey <em>Policy Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getMaxConcurrentAccessCount <em>Max Concurrent Access Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getPolicyEntries <em>Policy Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyConfiguration()
 * @model
 * @generated
 */
public interface ThrottlePolicyConfiguration extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Policy Type</b></em>' attribute.
	 * The default value is <code>"INLINE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyType
	 * @see #setPolicyType(ThrottlePolicyType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyConfiguration_PolicyType()
	 * @model default="INLINE"
	 * @generated
	 */
	ThrottlePolicyType getPolicyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getPolicyType <em>Policy Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyType
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyConfiguration_PolicyKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getPolicyKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getPolicyKey <em>Policy Key</em>}' containment reference.
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyConfiguration_MaxConcurrentAccessCount()
	 * @model
	 * @generated
	 */
	int getMaxConcurrentAccessCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getMaxConcurrentAccessCount <em>Max Concurrent Access Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Concurrent Access Count</em>' attribute.
	 * @see #getMaxConcurrentAccessCount()
	 * @generated
	 */
	void setMaxConcurrentAccessCount(int value);

	/**
	 * Returns the value of the '<em><b>Policy Entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Entries</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottlePolicyConfiguration_PolicyEntries()
	 * @model containment="true"
	 * @generated
	 */
	EList<ThrottlePolicyEntry> getPolicyEntries();

} // ThrottlePolicyConfiguration
