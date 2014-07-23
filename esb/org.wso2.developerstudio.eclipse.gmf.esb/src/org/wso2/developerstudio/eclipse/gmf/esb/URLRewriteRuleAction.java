/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>URL Rewrite Rule Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getRuleAction <em>Rule Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getRuleFragment <em>Rule Fragment</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getRuleOption <em>Rule Option</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getActionExpression <em>Action Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getActionValue <em>Action Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getActionRegex <em>Action Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteRuleAction()
 * @model
 * @generated
 */
public interface URLRewriteRuleAction extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Rule Action</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleActionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleActionType
	 * @see #setRuleAction(RuleActionType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteRuleAction_RuleAction()
	 * @model
	 * @generated
	 */
	RuleActionType getRuleAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getRuleAction <em>Rule Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleActionType
	 * @see #getRuleAction()
	 * @generated
	 */
	void setRuleAction(RuleActionType value);

	/**
	 * Returns the value of the '<em><b>Rule Fragment</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFragmentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Fragment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Fragment</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleFragmentType
	 * @see #setRuleFragment(RuleFragmentType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteRuleAction_RuleFragment()
	 * @model
	 * @generated
	 */
	RuleFragmentType getRuleFragment();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getRuleFragment <em>Rule Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Fragment</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleFragmentType
	 * @see #getRuleFragment()
	 * @generated
	 */
	void setRuleFragment(RuleFragmentType value);

	/**
	 * Returns the value of the '<em><b>Rule Option</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Option</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType
	 * @see #setRuleOption(RuleOptionType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteRuleAction_RuleOption()
	 * @model
	 * @generated
	 */
	RuleOptionType getRuleOption();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getRuleOption <em>Rule Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Option</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType
	 * @see #getRuleOption()
	 * @generated
	 */
	void setRuleOption(RuleOptionType value);

	/**
	 * Returns the value of the '<em><b>Action Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Expression</em>' containment reference.
	 * @see #setActionExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteRuleAction_ActionExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getActionExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getActionExpression <em>Action Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Expression</em>' containment reference.
	 * @see #getActionExpression()
	 * @generated
	 */
	void setActionExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Action Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Value</em>' attribute.
	 * @see #setActionValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteRuleAction_ActionValue()
	 * @model
	 * @generated
	 */
	String getActionValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getActionValue <em>Action Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Value</em>' attribute.
	 * @see #getActionValue()
	 * @generated
	 */
	void setActionValue(String value);

	/**
	 * Returns the value of the '<em><b>Action Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Regex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Regex</em>' attribute.
	 * @see #setActionRegex(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteRuleAction_ActionRegex()
	 * @model
	 * @generated
	 */
	String getActionRegex();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction#getActionRegex <em>Action Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Regex</em>' attribute.
	 * @see #getActionRegex()
	 * @generated
	 */
	void setActionRegex(String value);

} // URLRewriteRuleAction
