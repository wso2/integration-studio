/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entitlement Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementContainer#getOnRejectContainer <em>On Reject Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementContainer#getOnAcceptContainer <em>On Accept Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementContainer#getAdviceContainer <em>Advice Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementContainer#getObligationsContainer <em>Obligations Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementContainer()
 * @model
 * @generated
 */
public interface EntitlementContainer extends EsbNode {
	/**
	 * Returns the value of the '<em><b>On Reject Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Reject Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Reject Container</em>' containment reference.
	 * @see #setOnRejectContainer(EntitlementOnRejectContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementContainer_OnRejectContainer()
	 * @model containment="true"
	 * @generated
	 */
	EntitlementOnRejectContainer getOnRejectContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementContainer#getOnRejectContainer <em>On Reject Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Reject Container</em>' containment reference.
	 * @see #getOnRejectContainer()
	 * @generated
	 */
	void setOnRejectContainer(EntitlementOnRejectContainer value);

	/**
	 * Returns the value of the '<em><b>On Accept Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Accept Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Accept Container</em>' containment reference.
	 * @see #setOnAcceptContainer(EntitlementOnAcceptContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementContainer_OnAcceptContainer()
	 * @model containment="true"
	 * @generated
	 */
	EntitlementOnAcceptContainer getOnAcceptContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementContainer#getOnAcceptContainer <em>On Accept Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Accept Container</em>' containment reference.
	 * @see #getOnAcceptContainer()
	 * @generated
	 */
	void setOnAcceptContainer(EntitlementOnAcceptContainer value);

	/**
	 * Returns the value of the '<em><b>Advice Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advice Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advice Container</em>' containment reference.
	 * @see #setAdviceContainer(EntitlementAdviceContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementContainer_AdviceContainer()
	 * @model containment="true"
	 * @generated
	 */
	EntitlementAdviceContainer getAdviceContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementContainer#getAdviceContainer <em>Advice Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Advice Container</em>' containment reference.
	 * @see #getAdviceContainer()
	 * @generated
	 */
	void setAdviceContainer(EntitlementAdviceContainer value);

	/**
	 * Returns the value of the '<em><b>Obligations Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obligations Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obligations Container</em>' containment reference.
	 * @see #setObligationsContainer(EntitlementObligationsContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementContainer_ObligationsContainer()
	 * @model containment="true"
	 * @generated
	 */
	EntitlementObligationsContainer getObligationsContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EntitlementContainer#getObligationsContainer <em>Obligations Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obligations Container</em>' containment reference.
	 * @see #getObligationsContainer()
	 * @generated
	 */
	void setObligationsContainer(EntitlementObligationsContainer value);

} // EntitlementContainer
