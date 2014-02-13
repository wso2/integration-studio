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
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getConditionType <em>Condition Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterXpath <em>Filter Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterSource <em>Filter Source</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterRegex <em>Filter Regex</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getThenBranch <em>Then Branch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getElseBranch <em>Else Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFilterMediator()
 * @model
 * @generated
 */
public interface FilterMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Condition Type</b></em>' attribute.
	 * The default value is <code>"XPATH"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.FilterConditionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterConditionType
	 * @see #setConditionType(FilterConditionType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFilterMediator_ConditionType()
	 * @model default="XPATH"
	 * @generated
	 */
	FilterConditionType getConditionType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getConditionType <em>Condition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterConditionType
	 * @see #getConditionType()
	 * @generated
	 */
	void setConditionType(FilterConditionType value);

	/**
	 * Returns the value of the '<em><b>Filter Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Xpath</em>' containment reference.
	 * @see #setFilterXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFilterMediator_FilterXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getFilterXpath();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterXpath <em>Filter Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Xpath</em>' containment reference.
	 * @see #getFilterXpath()
	 * @generated
	 */
	void setFilterXpath(NamespacedProperty value);

				/**
	 * Returns the value of the '<em><b>Filter Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Source</em>' containment reference.
	 * @see #setFilterSource(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFilterMediator_FilterSource()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getFilterSource();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterSource <em>Filter Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Source</em>' containment reference.
	 * @see #getFilterSource()
	 * @generated
	 */
	void setFilterSource(NamespacedProperty value);

				/**
	 * Returns the value of the '<em><b>Filter Regex</b></em>' attribute.
	 * The default value is <code>"http://localhost:9000.*"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Regex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Regex</em>' attribute.
	 * @see #setFilterRegex(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFilterMediator_FilterRegex()
	 * @model default="http://localhost:9000.*"
	 * @generated
	 */
	String getFilterRegex();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterRegex <em>Filter Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Regex</em>' attribute.
	 * @see #getFilterRegex()
	 * @generated
	 */
	void setFilterRegex(String value);

				/**
	 * Returns the value of the '<em><b>Then Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Branch</em>' containment reference.
	 * @see #setThenBranch(FilterThenBranch)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFilterMediator_ThenBranch()
	 * @model containment="true"
	 * @generated
	 */
	FilterThenBranch getThenBranch();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getThenBranch <em>Then Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Branch</em>' containment reference.
	 * @see #getThenBranch()
	 * @generated
	 */
	void setThenBranch(FilterThenBranch value);

	/**
	 * Returns the value of the '<em><b>Else Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Branch</em>' containment reference.
	 * @see #setElseBranch(FilterElseBranch)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFilterMediator_ElseBranch()
	 * @model containment="true"
	 * @generated
	 */
	FilterElseBranch getElseBranch();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getElseBranch <em>Else Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Branch</em>' containment reference.
	 * @see #getElseBranch()
	 * @generated
	 */
	void setElseBranch(FilterElseBranch value);

} // FilterMediator
