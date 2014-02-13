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
package org.wso2.developerstudio.eclipse.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Load Balance End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint#isFailoverEnabled <em>Failover Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint#getMembershipHandlerClass <em>Membership Handler Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getDynamicLoadBalanceEndPoint()
 * @model
 * @generated
 */
public interface DynamicLoadBalanceEndPoint extends EndPoint {
	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' attribute.
	 * The default value is <code>"ROUND_ROBIN"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.LoadBalanceAlgorithm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.LoadBalanceAlgorithm
	 * @see #setAlgorithm(LoadBalanceAlgorithm)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getDynamicLoadBalanceEndPoint_Algorithm()
	 * @model default="ROUND_ROBIN"
	 * @generated
	 */
	LoadBalanceAlgorithm getAlgorithm();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint#getAlgorithm <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.LoadBalanceAlgorithm
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(LoadBalanceAlgorithm value);

	/**
	 * Returns the value of the '<em><b>Failover Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failover Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failover Enabled</em>' attribute.
	 * @see #setFailoverEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getDynamicLoadBalanceEndPoint_FailoverEnabled()
	 * @model default="true"
	 * @generated
	 */
	boolean isFailoverEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint#isFailoverEnabled <em>Failover Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failover Enabled</em>' attribute.
	 * @see #isFailoverEnabled()
	 * @generated
	 */
	void setFailoverEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Membership Handler Class</b></em>' attribute.
	 * The default value is <code>"class_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Membership Handler Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Membership Handler Class</em>' attribute.
	 * @see #setMembershipHandlerClass(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getDynamicLoadBalanceEndPoint_MembershipHandlerClass()
	 * @model default="class_name"
	 * @generated
	 */
	String getMembershipHandlerClass();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint#getMembershipHandlerClass <em>Membership Handler Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Membership Handler Class</em>' attribute.
	 * @see #getMembershipHandlerClass()
	 * @generated
	 */
	void setMembershipHandlerClass(String value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getDynamicLoadBalanceEndPoint_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<DynamicLoadBalanceProperty> getProperties();

} // DynamicLoadBalanceEndPoint
