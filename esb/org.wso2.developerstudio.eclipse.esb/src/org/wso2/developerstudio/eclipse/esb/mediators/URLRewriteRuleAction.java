/**
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
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>URL Rewrite Rule Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleAction <em>Rule Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleFragment <em>Rule Fragment</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleOption <em>Rule Option</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionExpression <em>Action Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionValue <em>Action Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionRegex <em>Action Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteRuleAction()
 * @model
 * @generated
 */
public interface URLRewriteRuleAction extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Rule Action</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.RuleActionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleActionType
	 * @see #setRuleAction(RuleActionType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteRuleAction_RuleAction()
	 * @model default=""
	 * @generated
	 */
	RuleActionType getRuleAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleAction <em>Rule Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleActionType
	 * @see #getRuleAction()
	 * @generated
	 */
	void setRuleAction(RuleActionType value);

	/**
	 * Returns the value of the '<em><b>Rule Fragment</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFragmentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Fragment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Fragment</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFragmentType
	 * @see #setRuleFragment(RuleFragmentType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteRuleAction_RuleFragment()
	 * @model default=""
	 * @generated
	 */
	RuleFragmentType getRuleFragment();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleFragment <em>Rule Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Fragment</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFragmentType
	 * @see #getRuleFragment()
	 * @generated
	 */
	void setRuleFragment(RuleFragmentType value);

	/**
	 * Returns the value of the '<em><b>Rule Option</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Option</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType
	 * @see #setRuleOption(RuleOptionType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteRuleAction_RuleOption()
	 * @model default=""
	 * @generated
	 */
	RuleOptionType getRuleOption();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleOption <em>Rule Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Option</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType
	 * @see #getRuleOption()
	 * @generated
	 */
	void setRuleOption(RuleOptionType value);

	/**
	 * Returns the value of the '<em><b>Action Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Expression</em>' reference.
	 * @see #setActionExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteRuleAction_ActionExpression()
	 * @model
	 * @generated
	 */
	NamespacedProperty getActionExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionExpression <em>Action Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Expression</em>' reference.
	 * @see #getActionExpression()
	 * @generated
	 */
	void setActionExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Action Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Value</em>' attribute.
	 * @see #setActionValue(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteRuleAction_ActionValue()
	 * @model default=""
	 * @generated
	 */
	String getActionValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionValue <em>Action Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Value</em>' attribute.
	 * @see #getActionValue()
	 * @generated
	 */
	void setActionValue(String value);

	/**
	 * Returns the value of the '<em><b>Action Regex</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Regex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Regex</em>' attribute.
	 * @see #setActionRegex(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteRuleAction_ActionRegex()
	 * @model default=""
	 * @generated
	 */
	String getActionRegex();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionRegex <em>Action Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Regex</em>' attribute.
	 * @see #getActionRegex()
	 * @generated
	 */
	void setActionRegex(String value);

} // URLRewriteRuleAction
