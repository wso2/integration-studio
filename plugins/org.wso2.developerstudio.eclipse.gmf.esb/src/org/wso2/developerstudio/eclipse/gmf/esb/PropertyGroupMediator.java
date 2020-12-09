/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
  * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
  *      http://www.apache.org/licenses/LICENSE-2.0
  * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Group Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyGroupMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyGroupMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyGroupMediator#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyGroupMediator()
 * @model
 * @generated
 */
public interface PropertyGroupMediator extends Mediator {
	/**
     * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Input Connector</em>' containment reference.
     * @see #setInputConnector(PropertyGroupMediatorInputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyGroupMediator_InputConnector()
     * @model containment="true"
     * @generated
     */
	PropertyGroupMediatorInputConnector getInputConnector();

	/**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyGroupMediator#getInputConnector <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Connector</em>' containment reference.
     * @see #getInputConnector()
     * @generated
     */
	void setInputConnector(PropertyGroupMediatorInputConnector value);

	/**
     * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Output Connector</em>' containment reference.
     * @see #setOutputConnector(PropertyGroupMediatorOutputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyGroupMediator_OutputConnector()
     * @model containment="true"
     * @generated
     */
	PropertyGroupMediatorOutputConnector getOutputConnector();

	/**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyGroupMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Connector</em>' containment reference.
     * @see #getOutputConnector()
     * @generated
     */
	void setOutputConnector(PropertyGroupMediatorOutputConnector value);

	/**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyGroupMediator_Properties()
     * @model containment="true"
     * @generated
     */
	EList<PropertyMediator> getProperties();
} // PropertyGroupMediator
