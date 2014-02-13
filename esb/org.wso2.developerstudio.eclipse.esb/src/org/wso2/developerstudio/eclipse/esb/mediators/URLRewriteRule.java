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

import org.eclipse.emf.common.util.EList;
import org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.esb.ModelObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>URL Rewrite Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule#getUrlRewriteRuleCondition <em>Url Rewrite Rule Condition</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule#getRewriteRuleAction <em>Rewrite Rule Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteRule()
 * @model
 * @generated
 */
public interface URLRewriteRule extends ModelObject {

	/**
	 * Returns the value of the '<em><b>Url Rewrite Rule Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Rewrite Rule Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Rewrite Rule Condition</em>' reference.
	 * @see #setUrlRewriteRuleCondition(EvaluatorExpressionProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteRule_UrlRewriteRuleCondition()
	 * @model
	 * @generated
	 */
	EvaluatorExpressionProperty getUrlRewriteRuleCondition();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule#getUrlRewriteRuleCondition <em>Url Rewrite Rule Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url Rewrite Rule Condition</em>' reference.
	 * @see #getUrlRewriteRuleCondition()
	 * @generated
	 */
	void setUrlRewriteRuleCondition(EvaluatorExpressionProperty value);

	/**
	 * Returns the value of the '<em><b>Rewrite Rule Action</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rewrite Rule Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rewrite Rule Action</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteRule_RewriteRuleAction()
	 * @model containment="true"
	 * @generated
	 */
	EList<URLRewriteRuleAction> getRewriteRuleAction();
} // URLRewriteRule
