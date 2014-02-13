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

import org.wso2.developerstudio.eclipse.esb.Mediator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throttle Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getPolicyConfiguration <em>Policy Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getOnAcceptBranch <em>On Accept Branch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getOnRejectBranch <em>On Reject Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottleMediator()
 * @model
 * @generated
 */
public interface ThrottleMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>On Accept Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Accept Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Accept Branch</em>' containment reference.
	 * @see #setOnAcceptBranch(ThrottleOnAcceptBranch)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottleMediator_OnAcceptBranch()
	 * @model containment="true"
	 * @generated
	 */
	ThrottleOnAcceptBranch getOnAcceptBranch();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getOnAcceptBranch <em>On Accept Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Accept Branch</em>' containment reference.
	 * @see #getOnAcceptBranch()
	 * @generated
	 */
	void setOnAcceptBranch(ThrottleOnAcceptBranch value);

	/**
	 * Returns the value of the '<em><b>On Reject Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Reject Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Reject Branch</em>' containment reference.
	 * @see #setOnRejectBranch(ThrottleOnRejectBranch)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottleMediator_OnRejectBranch()
	 * @model containment="true"
	 * @generated
	 */
	ThrottleOnRejectBranch getOnRejectBranch();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getOnRejectBranch <em>On Reject Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Reject Branch</em>' containment reference.
	 * @see #getOnRejectBranch()
	 * @generated
	 */
	void setOnRejectBranch(ThrottleOnRejectBranch value);

	/**
	 * Returns the value of the '<em><b>Group Id</b></em>' attribute.
	 * The default value is <code>"group_id"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Id</em>' attribute.
	 * @see #setGroupId(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottleMediator_GroupId()
	 * @model default="group_id"
	 * @generated
	 */
	String getGroupId();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getGroupId <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Id</em>' attribute.
	 * @see #getGroupId()
	 * @generated
	 */
	void setGroupId(String value);

	/**
	 * Returns the value of the '<em><b>Policy Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Configuration</em>' containment reference.
	 * @see #setPolicyConfiguration(ThrottlePolicyConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getThrottleMediator_PolicyConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ThrottlePolicyConfiguration getPolicyConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getPolicyConfiguration <em>Policy Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Configuration</em>' containment reference.
	 * @see #getPolicyConfiguration()
	 * @generated
	 */
	void setPolicyConfiguration(ThrottlePolicyConfiguration value);

} // ThrottleMediator
