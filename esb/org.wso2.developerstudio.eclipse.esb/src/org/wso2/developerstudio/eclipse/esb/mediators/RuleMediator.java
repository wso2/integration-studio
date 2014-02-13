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
 * A representation of the model object '<em><b>Rule Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getRuleSetConfiguration <em>Rule Set Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getRuleSessionConfiguration <em>Rule Session Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getFactsConfiguration <em>Facts Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getResultsConfiguration <em>Results Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getChildMediatorsConfiguration <em>Child Mediators Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleMediator()
 * @model
 * @generated
 */
public interface RuleMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Rule Set Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Set Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Set Configuration</em>' containment reference.
	 * @see #setRuleSetConfiguration(RuleSetConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleMediator_RuleSetConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	RuleSetConfiguration getRuleSetConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getRuleSetConfiguration <em>Rule Set Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Set Configuration</em>' containment reference.
	 * @see #getRuleSetConfiguration()
	 * @generated
	 */
	void setRuleSetConfiguration(RuleSetConfiguration value);

	/**
	 * Returns the value of the '<em><b>Rule Session Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Session Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Session Configuration</em>' containment reference.
	 * @see #setRuleSessionConfiguration(RuleSessionConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleMediator_RuleSessionConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	RuleSessionConfiguration getRuleSessionConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getRuleSessionConfiguration <em>Rule Session Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Session Configuration</em>' containment reference.
	 * @see #getRuleSessionConfiguration()
	 * @generated
	 */
	void setRuleSessionConfiguration(RuleSessionConfiguration value);

	/**
	 * Returns the value of the '<em><b>Facts Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facts Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facts Configuration</em>' containment reference.
	 * @see #setFactsConfiguration(RuleFactsConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleMediator_FactsConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	RuleFactsConfiguration getFactsConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getFactsConfiguration <em>Facts Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facts Configuration</em>' containment reference.
	 * @see #getFactsConfiguration()
	 * @generated
	 */
	void setFactsConfiguration(RuleFactsConfiguration value);

	/**
	 * Returns the value of the '<em><b>Results Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results Configuration</em>' containment reference.
	 * @see #setResultsConfiguration(RuleResultsConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleMediator_ResultsConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	RuleResultsConfiguration getResultsConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getResultsConfiguration <em>Results Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Results Configuration</em>' containment reference.
	 * @see #getResultsConfiguration()
	 * @generated
	 */
	void setResultsConfiguration(RuleResultsConfiguration value);

	/**
	 * Returns the value of the '<em><b>Child Mediators Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Mediators Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Mediators Configuration</em>' containment reference.
	 * @see #setChildMediatorsConfiguration(RuleChildMediatorsConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleMediator_ChildMediatorsConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	RuleChildMediatorsConfiguration getChildMediatorsConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getChildMediatorsConfiguration <em>Child Mediators Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child Mediators Configuration</em>' containment reference.
	 * @see #getChildMediatorsConfiguration()
	 * @generated
	 */
	void setChildMediatorsConfiguration(RuleChildMediatorsConfiguration value);

} // RuleMediator
