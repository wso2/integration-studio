/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>URL Rewrite Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRule#getUrlRewriteRuleCondition <em>Url Rewrite Rule Condition</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRule#getRewriteRuleAction <em>Rewrite Rule Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteRule()
 * @model
 * @generated
 */
public interface URLRewriteRule extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Url Rewrite Rule Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Rewrite Rule Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Rewrite Rule Condition</em>' containment reference.
	 * @see #setUrlRewriteRuleCondition(EvaluatorExpressionProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteRule_UrlRewriteRuleCondition()
	 * @model containment="true"
	 * @generated
	 */
	EvaluatorExpressionProperty getUrlRewriteRuleCondition();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRule#getUrlRewriteRuleCondition <em>Url Rewrite Rule Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url Rewrite Rule Condition</em>' containment reference.
	 * @see #getUrlRewriteRuleCondition()
	 * @generated
	 */
	void setUrlRewriteRuleCondition(EvaluatorExpressionProperty value);

	/**
	 * Returns the value of the '<em><b>Rewrite Rule Action</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rewrite Rule Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rewrite Rule Action</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteRule_RewriteRuleAction()
	 * @model containment="true"
	 * @generated
	 */
	EList<URLRewriteRuleAction> getRewriteRuleAction();

} // URLRewriteRule
