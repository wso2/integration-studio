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

import org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.esb.ModelObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleCondition#getOptionalRuleCondition <em>Optional Rule Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleCondition()
 * @model
 * @generated
 */
public interface RuleCondition extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Optional Rule Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Rule Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional Rule Condition</em>' reference.
	 * @see #setOptionalRuleCondition(EvaluatorExpressionProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleCondition_OptionalRuleCondition()
	 * @model
	 * @generated
	 */
	EvaluatorExpressionProperty getOptionalRuleCondition();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleCondition#getOptionalRuleCondition <em>Optional Rule Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional Rule Condition</em>' reference.
	 * @see #getOptionalRuleCondition()
	 * @generated
	 */
	void setOptionalRuleCondition(EvaluatorExpressionProperty value);

} // RuleCondition
